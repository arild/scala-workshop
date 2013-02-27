package futures

import scala.concurrent.Future
import scala.concurrent.future
import scala.concurrent.Await
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global
import work._

object MyFutures {

  def computeSquare(n: Int): Future[Int] = {
    ???
  }

  def computeSquare(f: Future[Int]): Future[Int] = {
    ???
  }

  def findMaxFactor(work: FactorNumber): Future[Long] = {
    ???
  }

  def findMaxFactor(work: Future[FactorNumber]): Future[Long] = {
    ???
  }

  def computeRiskySumFallbackOnSafeSum(riskyWork: SumSequence, safeWork: SumSequence): Future[Int] = {
    ???
  }

  def findSumOfAllMaxFactors(work: Seq[FactorNumber]): Future[Long] = {
    ???
  }

  def findMaxFactorOfAllMaxFactorsInParallel(work: Seq[FactorNumber]): Future[Long] = {
    ???
  }
}

object Examples extends App {

  def futureHelloWorld() = {
    println("Test print before future")
    val s = "hello"
    val f = future {
      Thread.sleep(10)
      s + " future!"
    }
    println("Test print after future")
    f onSuccess { case s => println(s) } //Completely asynchronous
    Await.ready(f, Duration.Inf) //Blocks until the future is ready
  }

  def simpleTransformation() = {
    val f1 = future {
      Thread.sleep(1000)
      println("Original future done")
      1 + 1
    }

    val f2 = f1.map(x => { // Completely asynchronously
      Thread.sleep(1000)
      println("Transformation future done")
      x + 1
    })

    f2 onSuccess { case v => println("Result: " + v) }
    Await.ready(f2, Duration.Inf)
  }

  futureHelloWorld
//  simpleTransformation
}
