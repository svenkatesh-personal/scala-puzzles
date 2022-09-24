import com.softwaremill.diffx.generic.auto._
import com.softwaremill.diffx._

// Example-1
case class PaymentRequest(cta: String, amount: Int, status: String)

val left = PaymentRequest("100", 100, "draft")
val right = PaymentRequest("100", 200, "rejected")
compare(left, right)
// DiffResultObject(PaymentRequest,ListMap(cta -> Identical(100), amount -> DiffResultValue(100,200), status -> DiffResultString(List(DiffResultValue(draft,rejected)))))

// Example-2
case class Payment(cta: String, amount: Int, status: String)

val one = Payment("100", 100, "draft")
val two = Payment("100", 200, "rejected")

val paymentDiff1: Diff[Payment] = Diff.derived[Payment].ignore(_.cta)
implicit val paymentDiff2: Diff[Payment] = Derived[Diff[Payment]].ignore(_.status)
compare(one, two)
// val res1: com.softwaremill.diffx.DiffResult = DiffResultObject(Payment,ListMap(cta -> Identical(100), amount -> DiffResultValue(100,200), status -> Identical(draft)))
