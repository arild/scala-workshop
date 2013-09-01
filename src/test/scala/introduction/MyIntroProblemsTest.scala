package test.scala.introduction

import introduction.MyIntroProblems
import work.FactorNumber
import funsuitehelper.FlatSpecHelper
import org.scalatest.matchers.ShouldMatchers


class MyIntroProblemsTest extends FlatSpecHelper with ShouldMatchers {

  it should "should compute square" in {
    checkImplemented { MyIntroProblems.computeSquare(4) should equal (16)}
  }

  it should "should find last element" in {
    checkImplemented {
      MyIntroProblems.findLastElement(List(1, 2, 3)) should equal (3)
    }
  }

  it should "should find two last elements" in {
    checkImplemented {
      MyIntroProblems.findTwoLastElements(List(1, 2, 3)) should equal (List(2, 3))
    }
  }

  it should "should find even numbers" in {
    checkImplemented {
      MyIntroProblems.findEvenNumbers(List(1, 2, 3, 4, 6, 7)) should equal (List(2, 4, 6))
    }
  }

  it should "should compute square on all numbers" in {
    checkImplemented {
      MyIntroProblems.computeSquareOnAllNumbers(List(1, 2, 3, 4, 6, 7)) should equal (List(1, 4, 9, 16, 36, 49))
    }
  }

  it should "should find sublist from predicate" in {
    checkImplemented {
      MyIntroProblems.findSublistFromPredicate(List(1, 2, 3, 4, 5), x => x > 3) should equal (List(4, 5))
      MyIntroProblems.findSublistFromPredicate(List(1, 2, 3, 4, 5), x => x % 2 == 1) should equal (List(1, 3, 5))
    }
  }

  it should "should compute sum of all max factors" in {
    val work1 = List(new FactorNumber(21L), new FactorNumber(49L), new FactorNumber(12L))
    val work2 = List(new FactorNumber(51L), new FactorNumber(81L))
    checkImplemented {
      MyIntroProblems.findSumOfAllMaxFactors(work1) should equal (20L)
      MyIntroProblems.findSumOfAllMaxFactors(work2) should equal (44L)
    }
  }

  it should "should compute square of int or string" in {
    checkImplemented {
      MyIntroProblems.computeSquareOfIntOrString(4) should equal(16)
      MyIntroProblems.computeSquareOfIntOrString("4") should equal(16)
    }
  }
}
