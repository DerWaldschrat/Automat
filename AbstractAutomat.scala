/**
 * Created with IntelliJ IDEA.
 * User: hauke
 * Date: 04.10.12
 * Time: 17:16
 * To change this template use File | Settings | File Templates.
 */

trait AbstractAutomat[A] {
  def delta(zustand: Zustand, element: A): Zustand
  val start: Zustand

  def istEndzustand(zustand: Zustand): Boolean = zustand match {
    case z: Endzustand => true
    case _ => false
  }
  def start(input: List[A]): Boolean = {
    istEndzustand(berechneZustand(input))
  }
  def berechneZustand(input: List[A]): Zustand = {
    var zustand: Zustand = start
    for (el <- input) {
      zustand = delta(zustand, el)
    }
    zustand
  }
}
