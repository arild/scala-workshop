package introduction

import org.scalatest.FunSuite

class MyAdvancedProblemsSuite extends FunSuite{

  test("should give empty list when duplicating empty list") {
    assert(MyAdvancedProblems.duplicate(List()) == List())
  }

  test("should duplicate list of elements containing one element") {
    assert(MyAdvancedProblems.duplicate(List('a)) == List('a,'a))
  }

  test("should duplicate list of elements containing four unique elements") {
    assert(MyAdvancedProblems.duplicate(List('a,'b,'c,'d)) == List('a,'a,'b,'b,'c,'c,'d,'d))
  }

  test("pack consecutive duplicates of list elements into sublists") {
    assert(MyAdvancedProblems.pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) ==
      List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e)
    ))
  }


}
