package introduction

object MyAdvancedProblems {

  // Duplicate the elements of a list.
  // Example:
  // scala> duplicate(List('a, 'b, 'c, 'c, 'd))
  // res0: List[Symbol] = List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd)
  def duplicate[A](elements: List[A]): List[A] = {
    val nestedList = elements.map((e: A) => List(e,e))
    nestedList.flatten

    //elements flatMap {
    //  e => List(e,e)
    //}
  }

  // Pack consecutive duplicates of list elements into sublists.
  // If a list contains repeated elements they should be placed in separate sublists.
  // Example:
  // scala> pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  // res0: List[List[Symbol]] = List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))
  def pack[A](elements: List[A]): List[List[A]] = {
    val packed = elements takeWhile {
      _ == elements.head
    }
    val next = elements dropWhile {
      _ == elements.head
    }
    if (next == Nil)
      List(packed)
    else
      packed :: pack(next)
  }

}
