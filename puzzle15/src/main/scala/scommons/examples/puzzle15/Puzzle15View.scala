package scommons.examples.puzzle15

import scommons.examples.puzzle15.Puzzle15ViewCss._
import scommons.react._

object Puzzle15View extends ClassComponent[Unit] {

  private case class Puzzle15ViewState(model: Puzzle15Model = Puzzle15Model())

  protected def create(): ReactClass = createClass[Puzzle15ViewState](
    getInitialState = { _ =>
      Puzzle15ViewState()
    },
    render = { self =>
      val model = self.state.model

      def onMove(item: Puzzle15ModelItem): Unit = {
        self.setState(state => state.copy(
          model = state.model.move(state.model.items.indexOf(item))
        ))
      }

      <.div(^.className := app)(
        <.div(^.className := container)(
          <.div(^.className := background)(
            <(Puzzle15ViewRow())(^.wrapped := Puzzle15ViewRowProps(topRow, model.row(0), onMove))(),
            <(Puzzle15ViewRow())(^.wrapped := Puzzle15ViewRowProps(row, model.row(1), onMove))(),
            <(Puzzle15ViewRow())(^.wrapped := Puzzle15ViewRowProps(row, model.row(2), onMove))(),
            <(Puzzle15ViewRow())(^.wrapped := Puzzle15ViewRowProps(bottomRow, model.row(3), onMove))()
          )
        )
      )
    }
  )
}
