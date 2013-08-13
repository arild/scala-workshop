package test.scala.introduction

import introduction.MyIntroProblems
import work.FactorNumber
import funsuitehelper.FunSuiteHelper

class MyIntroProblemsTest extends FunSuiteHelper {

  test("should compute square") {
    checkImplemented{MyIntroProblems.computeSquare(4) == 16}
  }

  test("should find last element") {
    checkImplemented{MyIntroProblems.findLastElement(List(1, 2, 3)) == 3}
  }

  test("should find two last elements") {
    checkImplemented{MyIntroProblems.findTwoLastElements(List(1, 2, 3)) == List(2, 3)}
  }

  test("should find even numbers") {
    checkImplemented{MyIntroProblems.findEvenNumbers(List(1, 2, 3, 4, 6, 7)) == List(2, 4, 6)}
  }

  test("should find sublist from predicate") {
    checkImplemented{MyIntroProblems.findSublistFromPredicate(List(1, 2, 3, 4, 5), x => x > 3) == List(4, 5)}
    checkImplemented{MyIntroProblems.findSublistFromPredicate(List(1, 2, 3, 4, 5), x => x % 2 == 1) == List(1, 3, 5)}
  }

  test("should sum of all max factors") {
    val work = List(new FactorNumber(21L), new FactorNumber(49L), new FactorNumber(12L))
    checkImplemented{MyIntroProblems.findSumOfAllMaxFactors(work) == 20L}
  }

  test("should compute square of int or string") {
    checkImplemented{MyIntroProblems.computeSquareOfIntOrString(4) == 16}
    checkImplemented{MyIntroProblems.computeSquareOfIntOrString("4") == 16}
  }
}
