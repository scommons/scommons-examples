package scommons.examples.puzzle15

import io.github.shogowada.scalajs.reactjs.React
import io.github.shogowada.scalajs.reactjs.VirtualDOM._
import io.github.shogowada.scalajs.reactjs.classes.ReactClass
import scommons.client.ui.UiComponent
import scommons.examples.puzzle15.Puzzle15ViewCss._

case class Puzzle15ViewProps()

object Puzzle15View extends UiComponent[Puzzle15ViewProps] {

  def apply(): ReactClass = reactClass

  lazy val reactClass: ReactClass = React.createClass[PropsType, Unit] { _ =>
    //val props = self.props.wrapped

    <.div(^.className := app)(
      <.div(^.className := container)(
        <.div(^.className := background)(
          <.div(^.className := topRow)(
            <.div(^.className := bitmap1)(),
            <.div(^.className := bitmap2)(),
            <.div(^.className := bitmap3)(),
            <.div(^.className := bitmap4)()
          ),
          <.div(^.className := row)(
            <.div(^.className := bitmap5)(),
            <.div(^.className := bitmap6)(),
            <.div(^.className := bitmap7)(),
            <.div(^.className := bitmap8)()
          ),
          <.div(^.className := row)(
            <.div(^.className := bitmap9)(),
            <.div(^.className := bitmap10)(),
            <.div(^.className := bitmap11)(),
            <.div(^.className := bitmap12)()
          ),
          <.div(^.className := bottomRow)(
            <.div(^.className := bitmap13)(),
            <.div(^.className := bitmap14)(),
            <.div(^.className := bitmap15)(),
            <.div(^.className := bitmap16)()
          )
        )
      )
    )
  }
}
