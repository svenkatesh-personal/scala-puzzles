trait Command

case class InternalCommand1() extends Command

case class InternalCommand2() extends Command

// 1. The Type Class
trait HoldBack[T <: Command] {
  def isHoldBack: Boolean
}

//2. Type Class Instances
object HoldBackCommandInstances {
  // command1 type class instance
  implicit object command1 extends HoldBack[InternalCommand1] {
    def isHoldBack = true
  }

  // command2 type class instance
  implicit object command2 extends HoldBack[InternalCommand2] {
    def isHoldBack = false
  }
}

HoldBackCommandInstances.command1.isHoldBack
HoldBackCommandInstances.command2.isHoldBack

