package test.scala.introduction

import org.scalatest.FunSuite
import work.FactorNumber
import introduction.MyIntroProblems

class MyIntroProblemsTest extends FunSuite {

  test("should compute square") {
    assert(MyIntroProblems.computeSquare(4) == 16)
  }

  test("should find last element") {
    assert(MyIntroProblems.findLastElement(List(1, 2, 3)) == 3)
  }

  test("should find two last elements") {
    assert(MyIntroProblems.findTwoLastElements(List(1, 2, 3)) == List(2, 3))
  }

  test("should find even numbers") {
    assert(MyIntroProblems.findEvenNumbers(List(1, 2, 3, 4, 6, 7)) == List(2, 4, 6))
  }

  test("should find sublist from predicate") {
    assert(MyIntroProblems.findSublistFromPredicate(List(1, 2, 3, 4, 5), x => x > 3) == List(4, 5))
    assert(MyIntroProblems.findSublistFromPredicate(List(1, 2, 3, 4, 5), x => x % 2 == 1) == List(1, 3, 5))
  }

  test("should sum of all max factors") {
    val work = List(new FactorNumber(21L), new FactorNumber(49L), new FactorNumber(12L))
    assert(MyIntroProblems.findSumOfAllMaxFactors(work) == 20L)
  }

  test("should compute square of int or string") {
    assert(MyIntroProblems.computeSquareOfIntOrString(4) == 16)
    assert(MyIntroProblems.computeSquareOfIntOrString("4") == 16)
  }
}