package scommons.examples.puzzle15

import io.github.shogowada.scalajs.reactjs.ReactDOM
import io.github.shogowada.scalajs.reactjs.VirtualDOM._
import org.scalajs.dom

import scala.scalajs.js.annotation.JSExportTopLevel

object Puzzle15Main {

  @JSExportTopLevel("scommons.examples.puzzle15.main")
  def main(args: Array[String]): Unit = {
    val mountNode = dom.document.getElementById("root")
    mountNode.setAttribute("class", Puzzle15ViewCss.view)

    dom.document.title = "scommons-examples-puzzle15"

    ReactDOM.render(<(Puzzle15View()).empty, mountNode)
  }
}
