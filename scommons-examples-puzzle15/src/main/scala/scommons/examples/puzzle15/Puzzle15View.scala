package scommons.examples.puzzle15

import io.github.shogowada.scalajs.reactjs.React
import io.github.shogowada.scalajs.reactjs.VirtualDOM._
import io.github.shogowada.scalajs.reactjs.classes.ReactClass
import scommons.examples.puzzle15.Puzzle15ViewCss._
import scommons.react.UiComponent

object Puzzle15View extends UiComponent[Unit] {

  private case class Puzzle15ViewState(model: Puzzle15Model = Puzzle15Model())

  protected def create(): ReactClass = React.createClass[PropsType, Puzzle15ViewState](
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
