package introduction

import work.FactorNumber


object MyIntroProblems {

  def computeSquare(n: Int): Int = {
    n * n
  }

  def findLastElement(numbers: List[Int]): Int = {
    numbers.last
  }

  def findTwoLastElements(numbers: List[Int]): List[Int] = {
    numbers.takeRight(2)
  }

  def findEvenNumbers(numbers: List[Int]): List[Int] = {
    numbers.filter(_ % 2 == 0)
  }

  def computeSquareOnAllNumbers(numbers: List[Int]): List[Int] = {
    numbers.map(n => computeSquare(n))
    //numbers.map(computeSquare)
  }

  def findSublistFromPredicate(numbers: List[Int], predicate: Int => Boolean): List[Int] = {
    numbers.filter(predicate)
  }

  def findSumOfAllMaxFactors(numbers: List[FactorNumber]): Long = {
    val factors = numbers.map((number: FactorNumber) => {
      number.perform.max
    })
    factors.sum
//    numbers.map(w => w.perform.max).sum
  }
  
  def computeSquareOfIntOrString(number: Any): Int = {
    val n = number match {
      case i: Int => i
      case s: String => s.toInt
    }
    computeSquare(n)
  }

}
