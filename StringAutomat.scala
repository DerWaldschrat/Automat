import collection.immutable.StringOps

/**
 * Created with IntelliJ IDEA.
 * User: hauke
 * Date: 04.10.12
 * Time: 17:59
 * To change this template use File | Settings | File Templates.
 */

trait StringAutomat extends AbstractAutomat[Char] {
  implicit def stringToList(string: String): List[Char] = new StringOps(string).toList
}
