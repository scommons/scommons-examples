package scommons.examples.puzzle15

import scommons.react.test.TestSpec
import scommons.react.test.util.ShallowRendererUtils

class Puzzle15ViewRowSpec extends TestSpec with ShallowRendererUtils {

  it should "render component" in {
    //given
    val props = Puzzle15ViewRowProps(
      style = "test-style",
      items = List(Puzzle15ModelItem._1, Puzzle15ModelItem._2),
      onMove = _ => ()
    )
    val comp = <(Puzzle15ViewRow())(^.wrapped := props)()
    
    //when
    val result = shallowRender(comp)

    //then
    assertNativeComponent(result, <.div(^.className := props.style)(), { case List(comp1, comp2) =>
      assertComponent(comp1, Puzzle15ViewCell) { case Puzzle15ViewCellProps(item, onMove) =>
        item shouldBe props.items.head
        onMove shouldBe props.onMove
      }
      assertComponent(comp2, Puzzle15ViewCell) { case Puzzle15ViewCellProps(item, onMove) =>
        item shouldBe props.items(1)
        onMove shouldBe props.onMove
      }
    })
  }
}
