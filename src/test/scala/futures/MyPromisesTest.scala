package test.scala.futures
import org.scalatest.FunSuite

import scala.concurrent.Future
import scala.concurrent.future
import scala.concurrent.promise
import scala.concurrent.Promise
import scala.concurrent.Await
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

import work._
import futures.MyPromises 



class MyPromisesTest extends FunSuite {
  val PROMISE_TIME_LIMIT: Long = 100

  def time[R](block: => R): R = {
    val t0 = System.currentTimeMillis()
    val result = block
    val t1 = System.currentTimeMillis()
    if (t1 - t0 > PROMISE_TIME_LIMIT)
      fail("You are too slow to promise")
    result
  }
  
  def delayFactorNumber(n: Long): FactorNumber = new FactorNumber(n, PROMISE_TIME_LIMIT * 2)

    test("should compute square") {
      val promise = time { MyPromises.computeSquare(2) }
      val result = Await.result(promise.future, Duration.Inf)
      assert(result == 4)
    }

    test("should compute square of future value") {
      val futureValue = future {
        Thread.sleep(PROMISE_TIME_LIMIT * 2)
        2
      }
      val promise = time { MyPromises.computeSquare(futureValue) }
      val result = Await.result(promise.future, Duration.Inf)
      assert(result == 4)
    }

    test("should find max factor") {
      val work = delayFactorNumber(49L)
      val promise = time { MyPromises.findMaxFactor(work) }
      val result = Await.result(promise.future, Duration.Inf)
      assert(result == 7L)
    }

    test("should find max factor of future factors") {
      val futureFactors = future {
        delayFactorNumber(49L)
      }
      val promise = time { MyPromises.findMaxFactor(futureFactors) }
      val result = Await.result(promise.future, Duration.Inf)
      assert(result == 7L)
    }

    test("do risky work or fallback on safe work") {
      // Each work will exceed the time limit
      val shouldNotDoWork = new SumSequence(0, 4, PROMISE_TIME_LIMIT + 1)
      val safeWork = new SumSequence(0, 5, PROMISE_TIME_LIMIT + 1)
      val riskyWork = new SumSequence(-1, 6, PROMISE_TIME_LIMIT + 1)
      val promise = time { MyPromises.computeRiskySumFallbackOnSafeSum(safeWork, shouldNotDoWork) }
      val promise2 = time { MyPromises.computeRiskySumFallbackOnSafeSum(riskyWork, safeWork) }

      val result = Await.result(promise.future, Duration.Inf)
      val result2 = Await.result(promise2.future, Duration.Inf)
      assert(result == 15)
      assert(result2 == 15)
    }

    test("find sum of all max factors") {
      val work = Seq(delayFactorNumber(21L), delayFactorNumber(49L), delayFactorNumber(12L))
      val promise = time { MyPromises.findSumOfAllMaxFactors(work) }
      val result = Await.result(promise.future, Duration.Inf)
      assert(result == 20L)
    }
    
    test("find max factor of all max factors in parallel") {
      // Each work will take at least 100 milliseconds
      val work = Seq(delayFactorNumber(49L), delayFactorNumber(12L), delayFactorNumber(21L), delayFactorNumber(54L))
      
      val promise = time { MyPromises.findMaxFactorOfAllMaxFactorsInParallel(work) }
      val t1 = System.currentTimeMillis()
      val result = Await.result(promise.future, Duration.Inf)
      assert(result == 27)
      val totalExecutionTime = System.currentTimeMillis() - t1
      assert(totalExecutionTime < PROMISE_TIME_LIMIT * 7)
      println("Parallel execution time: " + totalExecutionTime)
    }
  }
