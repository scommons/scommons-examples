package scommons.examples.puzzle15

import org.scalajs.dom
import scommons.react.test.TestSpec
import scommons.react.test.dom.util.TestDOMUtils

class Puzzle15MainSpec extends TestSpec with TestDOMUtils {

  it should "render app in dom" in {
    //given
    domContainer.setAttribute("id", "root")
    
    //when
    Puzzle15Main.main(Array[String]())

    //then
    domContainer.getAttribute("class") shouldBe Puzzle15ViewCss.view
    dom.document.title shouldBe "scommons-examples-puzzle15"
  }
}
