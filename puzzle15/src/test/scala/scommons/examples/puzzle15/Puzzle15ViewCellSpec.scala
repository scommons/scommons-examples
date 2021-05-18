package scommons.examples.puzzle15

import scommons.react.test._

class Puzzle15ViewCellSpec extends TestSpec with TestRendererUtils {

  it should "call onMove when onClick" in {
    //given
    val onMove = mockFunction[Puzzle15ModelItem, Unit]
    val props = Puzzle15ViewCellProps(Puzzle15ModelItem._1, onMove = onMove)
    val comp = testRender(<(Puzzle15ViewCell())(^.wrapped := props)())
    val div = inside(findComponents(comp, <.div.name)) {
      case List(c) => c
    }
    
    //then
    onMove.expects(props.item)

    //when
    div.props.onClick(null)
  }
  
  it should "render component" in {
    //given
    val props = Puzzle15ViewCellProps(Puzzle15ModelItem._1, onMove = _ => ())
    val comp = <(Puzzle15ViewCell())(^.wrapped := props)()
    
    //when
    val result = testRender(comp)

    //then
    assertNativeComponent(result,
      <.div(
        ^.className := props.item.style
      )()
    )
  }
}
