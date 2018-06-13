package scommons.examples.puzzle15

import io.github.shogowada.scalajs.reactjs.React
import io.github.shogowada.scalajs.reactjs.VirtualDOM._
import io.github.shogowada.scalajs.reactjs.classes.ReactClass
import io.github.shogowada.scalajs.reactjs.events.MouseSyntheticEvent
import scommons.client.ui.UiComponent

case class Puzzle15ViewCellProps(item: Puzzle15ModelItem,
                                 onMove: Puzzle15ModelItem => Unit)

object Puzzle15ViewCell extends UiComponent[Puzzle15ViewCellProps] {

  def apply(): ReactClass = reactClass

  lazy val reactClass: ReactClass = React.createClass[PropsType, Unit] { self =>
    val props = self.props.wrapped

    <.div(
      ^.className := props.item.style,
      ^.onClick := { _: MouseSyntheticEvent =>
        props.onMove(props.item)
      }
    )()
  }
}
