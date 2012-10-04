import collection.immutable.StringOps

/**
 * Created with IntelliJ IDEA.
 * User: hauke
 * Date: 04.10.12
 * Time: 17:29
 * To change this template use File | Settings | File Templates.
 */

case object Z0 extends Zustand

case object Z1 extends Endzustand

case object Z2 extends Endzustand

object BinaryChecker extends StringAutomat {
  override val start: Zustand = Z0

  override def delta(zustand: Zustand, zahl: Char): Zustand = {
    zustand match {
      case Z0 => zahl match {
        case '0' => Z2
        case '1' => Z1
      }
      case Z1 => Z1
      case Z2 => ZM
      case ZM => ZM
    }
  }

  //implicit def stringToIterate(ops: String): Iterate = new StringOps(ops)

  def main(args: Array[String]) {
    val toCheck = List("0", "011", "1", "1001", "111", "10011")
    for (check <- toCheck) {
      println(check)
      println(start(check))
    }
  }
}
