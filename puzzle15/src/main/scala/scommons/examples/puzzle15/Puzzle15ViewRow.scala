package scommons.examples.puzzle15

import scommons.react._

case class Puzzle15ViewRowProps(style: String,
                                items: List[Puzzle15ModelItem],
                                onMove: Puzzle15ModelItem => Unit)

object Puzzle15ViewRow extends FunctionComponent[Puzzle15ViewRowProps] {

  private[puzzle15] var puzzle15ViewCellComp: UiComponent[Puzzle15ViewCellProps] = Puzzle15ViewCell

  protected def render(compProps: Props): ReactElement = {
    val props = compProps.wrapped

    <.div(^.className := props.style)(props.items.map { item =>
      <(puzzle15ViewCellComp())(^.wrapped := Puzzle15ViewCellProps(item, props.onMove))()
    })
  }
}
