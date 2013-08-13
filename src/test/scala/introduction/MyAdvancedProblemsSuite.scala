package introduction

import funsuitehelper.FlatSpecHelper
import org.scalatest.matchers.ShouldMatchers

class MyAdvancedProblemsSuite  extends FlatSpecHelper with ShouldMatchers {

  it should("should give empty list when duplicating empty list") in {
    checkImplemented{MyAdvancedProblems.duplicate(List()) == List()}
  }

  it should("should duplicate list of elements containing one element") in {
    checkImplemented{MyAdvancedProblems.duplicate(List('a)) == List('a,'a)}
  }

  it should("should duplicate list of elements containing four unique elements") in {
    checkImplemented{MyAdvancedProblems.duplicate(List('a,'b,'c,'d)) == List('a,'a,'b,'b,'c,'c,'d,'d)}
  }

  it should("pack consecutive duplicates of list elements into sublists") in {
    checkImplemented{MyAdvancedProblems.pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) ==
      List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e)
    )}
  }
}
