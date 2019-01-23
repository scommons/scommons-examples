package scommons.examples.puzzle15

import scommons.examples.puzzle15.Puzzle15ViewCss._

sealed trait Puzzle15ModelItem {

  def style: String
}

object Puzzle15ModelItem {

  case object _1 extends Puzzle15ModelItem {
    val style = bitmap1
  }

  case object _2 extends Puzzle15ModelItem {
    val style = bitmap2
  }

  case object _3 extends Puzzle15ModelItem {
    val style = bitmap3
  }

  case object _4 extends Puzzle15ModelItem {
    val style = bitmap4
  }

  case object _5 extends Puzzle15ModelItem {
    val style = bitmap5
  }

  case object _6 extends Puzzle15ModelItem {
    val style = bitmap6
  }

  case object _7 extends Puzzle15ModelItem {
    val style = bitmap7
  }

  case object _8 extends Puzzle15ModelItem {
    val style = bitmap8
  }

  case object _9 extends Puzzle15ModelItem {
    val style = bitmap9
  }

  case object _10 extends Puzzle15ModelItem {
    val style = bitmap10
  }

  case object _11 extends Puzzle15ModelItem {
    val style = bitmap11
  }

  case object _12 extends Puzzle15ModelItem {
    val style = bitmap12
  }

  case object _13 extends Puzzle15ModelItem {
    val style = bitmap13
  }

  case object _14 extends Puzzle15ModelItem {
    val style = bitmap14
  }

  case object _15 extends Puzzle15ModelItem {
    val style = bitmap15
  }

  case object Empty extends Puzzle15ModelItem {
    val style = bitmap16
  }
}
