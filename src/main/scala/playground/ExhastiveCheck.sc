import enumeratum._

import scala.collection.immutable

sealed class StatusEnrichmentEnum(override val entryName: String) extends EnumEntry

object StatusEnrichmentEnum extends Enum[StatusEnrichmentEnum] {
  val values: immutable.IndexedSeq[StatusEnrichmentEnum] = findValues

  //private def unApply()

  case object Rejected extends StatusEnrichmentEnum("Rejected")

  case object AutomaticallyGenerated extends StatusEnrichmentEnum("Automatically Generated")

  case object SentForApproval extends StatusEnrichmentEnum("Sent for Approval")

  case object Approved extends StatusEnrichmentEnum("Approved")

  case object SentToDraftFromRejected extends StatusEnrichmentEnum("Sent to Draft from Rejected")

  case object ResubmittedForApproval extends StatusEnrichmentEnum("Resubmitted for Approval")

  case object Retracted extends StatusEnrichmentEnum("Retracted")

  case object EditsMade extends StatusEnrichmentEnum("Edits Made")


  val Response_AwaitingApproval = "AwaitingApproval"
  val Response_Approved = "Approved"
  val Response_Rejected = "Rejected"
  val Response_DraftFromRejected = "DraftFromRejected"
  val Response_Draft = "Draft"

  def getEnrichedStatus(lastChange: String, currentChange: String) {
    (lastChange, currentChange) match {
      case (Response_AwaitingApproval, Response_Approved) => Approved
      case (Response_AwaitingApproval, Response_Rejected) => Rejected
      case (Response_Rejected, Response_DraftFromRejected) => SentToDraftFromRejected
      case (Response_DraftFromRejected, Response_AwaitingApproval) => ResubmittedForApproval
      case (Response_Draft, Response_AwaitingApproval) => SentForApproval
      case (Response_AwaitingApproval, Response_Draft) => Retracted
      // case (_, _) => None
    }
  }
}

import StatusEnrichmentEnum.{Response_AwaitingApproval, Response_Approved, getEnrichedStatus}

val lastChange = Response_AwaitingApproval
val currentChange = Response_Approved
println(getEnrichedStatus(lastChange, currentChange))

