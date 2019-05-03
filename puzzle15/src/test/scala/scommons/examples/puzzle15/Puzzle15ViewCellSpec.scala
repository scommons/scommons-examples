package scommons.examples.puzzle15

import scommons.react.test.TestSpec
import scommons.react.test.dom.util.TestDOMUtils
import scommons.react.test.util.ShallowRendererUtils

class Puzzle15ViewCellSpec extends TestSpec
  with TestDOMUtils
  with ShallowRendererUtils {

  it should "call onMove when onClick" in {
    //given
    val onMove = mockFunction[Puzzle15ModelItem, Unit]
    val props = Puzzle15ViewCellProps(Puzzle15ModelItem._1, onMove = onMove)
    domRender(<(Puzzle15ViewCell())(^.wrapped := props)())
    val div = domContainer.querySelector("div")
    
    //then
    onMove.expects(props.item)

    //when
    fireDomEvent(Simulate.click(div))
  }
  
  it should "render component" in {
    //given
    val props = Puzzle15ViewCellProps(Puzzle15ModelItem._1, onMove = _ => ())
    val comp = <(Puzzle15ViewCell())(^.wrapped := props)()
    
    //when
    val result = shallowRender(comp)

    //then
    assertNativeComponent(result,
      <.div(
        ^.className := props.item.style
      )()
    )
  }
}
