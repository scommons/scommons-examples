package scommons.examples.puzzle15

import io.github.shogowada.scalajs.reactjs.React
import io.github.shogowada.scalajs.reactjs.VirtualDOM._
import io.github.shogowada.scalajs.reactjs.classes.ReactClass
import scommons.react.UiComponent

case class Puzzle15ViewRowProps(style: String,
                                items: List[Puzzle15ModelItem],
                                onMove: Puzzle15ModelItem => Unit)

object Puzzle15ViewRow extends UiComponent[Puzzle15ViewRowProps] {

  protected def create(): ReactClass = React.createClass[PropsType, Unit] { self =>
    val props = self.props.wrapped

    <.div(^.className := props.style)(props.items.map { item =>
      <(Puzzle15ViewCell())(^.wrapped := Puzzle15ViewCellProps(item, props.onMove))()
    })
  }
}
