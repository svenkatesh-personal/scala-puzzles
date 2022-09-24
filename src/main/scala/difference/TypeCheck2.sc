trait Command

case class InternalCommand1() extends Command

case class InternalCommand2() extends Command

// 1. The Type Class
trait HoldBack[T <: Command] {
  def isHoldBack(t: T): Boolean
}

//2. Type Class Instances
object HoldBackCommandInstances {
  // command1 type class instance
  implicit object command1 extends HoldBack[InternalCommand1] {
    override def isHoldBack(t: InternalCommand1) = true
  }

  // command2 type class instance
  implicit object command2 extends HoldBack[InternalCommand2] {
    override def isHoldBack(t: InternalCommand2) = false
  }
}

val c1 = new InternalCommand1
HoldBackCommandInstances.command1.isHoldBack(c1)

val c2 = new InternalCommand2
HoldBackCommandInstances.command2.isHoldBack(c2)

//3. Type Class Interface Syntax
object HoldBackCommandSyntax {
  implicit class HoldBackCommandOps[T <: Command](t: T) {
    def checkHoldBack(implicit holdBack: HoldBack[T]) = holdBack.isHoldBack(t)
  }
}

import HoldBackCommandInstances.{command1, command2}
import HoldBackCommandSyntax.HoldBackCommandOps

c1.checkHoldBack
c2.checkHoldBack
