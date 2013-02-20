package introduction

object MyAdvancedProblems {

  def duplicate[A](elements: List[A]): List[A] = {
    val nestedList = elements.map((e: A) => List(e,e))
    nestedList.flatten

    //elements flatMap {
    //  e => List(e,e)
    //}
  }

  def pack[A](ls: List[A]): List[List[A]] = {
    val packed = ls takeWhile {
      _ == ls.head
    }
    val next = ls dropWhile {
      _ == ls.head
    }
    if (next == Nil)
      List(packed)
    else
      packed :: pack(next)
  }

}
