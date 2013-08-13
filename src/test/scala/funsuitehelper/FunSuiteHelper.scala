package funsuitehelper

import org.scalatest.FunSuite

class FunSuiteHelper extends FunSuite {

  def checkImplemented[R](block: => R): R = {
    try {
      block
    } catch {
      case e : scala.NotImplementedError => fail("implementation missing for method")
    }
  }

  def time[R](block: => R): R = {
    val t0 = System.currentTimeMillis()
    val result = block
    val t1 = System.currentTimeMillis()
    if (t1 - t0 > FunSuiteHelper.FUTURE_TIME_LIMIT)
      fail("Did not return immediately as a future!")
    result
  }

}

object FunSuiteHelper {
  val FUTURE_TIME_LIMIT: Long = 100
}
