package scommons.examples.puzzle15

import io.github.shogowada.scalajs.reactjs.events.MouseSyntheticEvent
import scommons.react._

case class Puzzle15ViewCellProps(item: Puzzle15ModelItem,
                                 onMove: Puzzle15ModelItem => Unit)

object Puzzle15ViewCell extends FunctionComponent[Puzzle15ViewCellProps] {

  protected def render(compProps: Props): ReactElement = {
    val props = compProps.wrapped

    <.div(
      ^.className := props.item.style,
      ^.onClick := { _: MouseSyntheticEvent =>
        props.onMove(props.item)
      }
    )()
  }
}
