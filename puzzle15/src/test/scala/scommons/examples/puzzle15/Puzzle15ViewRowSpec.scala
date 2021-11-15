package scommons.examples.puzzle15

import scommons.examples.puzzle15.Puzzle15ViewRow._
import scommons.react.test._

class Puzzle15ViewRowSpec extends TestSpec with TestRendererUtils {

  Puzzle15ViewRow.puzzle15ViewCellComp = mockUiComponent("Puzzle15ViewCell")

  it should "render component" in {
    //given
    val props = Puzzle15ViewRowProps(
      style = "test-style",
      items = List(Puzzle15ModelItem._1, Puzzle15ModelItem._2),
      onMove = _ => ()
    )
    val comp = <(Puzzle15ViewRow())(^.wrapped := props)()
    
    //when
    val result = testRender(comp)

    //then
    assertNativeComponent(result, <.div(^.className := props.style)(), { case List(comp1, comp2) =>
      assertTestComponent(comp1, puzzle15ViewCellComp) { case Puzzle15ViewCellProps(item, onMove) =>
        item shouldBe props.items.head
        onMove shouldBe props.onMove
      }
      assertTestComponent(comp2, puzzle15ViewCellComp) { case Puzzle15ViewCellProps(item, onMove) =>
        item shouldBe props.items(1)
        onMove shouldBe props.onMove
      }
    })
  }
}
