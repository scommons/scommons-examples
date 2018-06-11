package scommons.examples.puzzle15

import io.github.shogowada.scalajs.reactjs.React
import io.github.shogowada.scalajs.reactjs.VirtualDOM._
import io.github.shogowada.scalajs.reactjs.classes.ReactClass
import scommons.client.ui.UiComponent
import scommons.examples.puzzle15.Puzzle15ViewCss._

object Puzzle15View extends UiComponent[Unit] {

  private case class Puzzle15ViewState(model: Puzzle15Model = Puzzle15Model())

  def apply(): ReactClass = reactClass

  lazy val reactClass: ReactClass = React.createClass[PropsType, Puzzle15ViewState](
    getInitialState = { _ =>
      Puzzle15ViewState()
    },
    render = { self =>
      val model = self.state.model

      <.div(^.className := app)(
        <.div(^.className := container)(
          <.div(^.className := background)(
            <(Puzzle15ViewRow())(^.wrapped := Puzzle15ViewRowProps(topRow, model.row(0)))(),
            <(Puzzle15ViewRow())(^.wrapped := Puzzle15ViewRowProps(row, model.row(1)))(),
            <(Puzzle15ViewRow())(^.wrapped := Puzzle15ViewRowProps(row, model.row(2)))(),
            <(Puzzle15ViewRow())(^.wrapped := Puzzle15ViewRowProps(bottomRow, model.row(3)))()
          )
        )
      )
    }
  )
}
