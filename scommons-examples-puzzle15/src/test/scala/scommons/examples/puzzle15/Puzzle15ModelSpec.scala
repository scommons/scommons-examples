package scommons.examples.puzzle15

import scommons.client.test.TestSpec
import scommons.examples.puzzle15.Puzzle15ModelItem._

class Puzzle15ModelSpec extends TestSpec {

  it should "return row's items at the given index when call row" in {
    //given
    val model = Puzzle15Model(List(
      _9, _2, _7, _4,
      _5, _12, _3, _8,
      _1, _10, _11, _6,
      _13, Empty, _15, _14
    ))

    //when & then
    model.row(-1) shouldBe Nil
    model.row(0) shouldBe List(_9, _2, _7, _4)
    model.row(1) shouldBe List(_5, _12, _3, _8)
    model.row(2) shouldBe List(_1, _10, _11, _6)
    model.row(3) shouldBe List(_13, Empty, _15, _14)
    model.row(4) shouldBe Nil
    model.row(5) shouldBe Nil
  }

  it should "move item from the given index to empty place when call move" in {
    //given
    val model = Puzzle15Model(List(
      _9, _2, _7, _4,
      _5, _12, _3, _8,
      _1, Empty, _11, _6,
      _13, _10, _15, _14
    ))

    //when & then
    model.move(0) should be theSameInstanceAs model
    model.move(15) should be theSameInstanceAs model
    model.move(14) should be theSameInstanceAs model
    model.move(9) should be theSameInstanceAs model

    model.move(13) shouldBe Puzzle15Model(List(
      _9, _2, _7, _4,
      _5, _12, _3, _8,
      _1, _10, _11, _6,
      _13, Empty, _15, _14
    ))
    model.move(8) shouldBe Puzzle15Model(List(
      _9, _2, _7, _4,
      _5, _12, _3, _8,
      Empty, _1, _11, _6,
      _13, _10, _15, _14
    ))
    model.move(5) shouldBe Puzzle15Model(List(
      _9, _2, _7, _4,
      _5, Empty, _3, _8,
      _1, _12, _11, _6,
      _13, _10, _15, _14
    ))
    model.move(10) shouldBe Puzzle15Model(List(
      _9, _2, _7, _4,
      _5, _12, _3, _8,
      _1, _11, Empty, _6,
      _13, _10, _15, _14
    ))
  }
}
