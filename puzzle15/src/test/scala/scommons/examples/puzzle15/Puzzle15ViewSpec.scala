package scommons.examples.puzzle15

import scommons.examples.puzzle15.Puzzle15ViewCss._
import scommons.react.test._

class Puzzle15ViewSpec extends TestSpec with TestRendererUtils {

  it should "move item when onMove in row" in {
    //given
    val renderer = createTestRenderer(<(Puzzle15View())()())
    val rows = findProps(renderer.root, Puzzle15ViewRow)
    val row3 = rows(2)
    val item = row3.items(3)

    //when
    row3.onMove(item)

    //then
    val model = Puzzle15Model()
    val afterMove = model.move(model.items.indexOf(item))
    model should not be afterMove
    
    assertPuzzle15View(renderer.root.children(0), afterMove)
  }
  
  it should "render component" in {
    //given
    val comp = <(Puzzle15View())()()

    //when
    val result = testRender(comp)

    //then
    assertPuzzle15View(result, Puzzle15Model())
  }
  
  private def assertPuzzle15View(result: TestInstance, model: Puzzle15Model): Unit = {
    assertNativeComponent(result, <.div(^.className := app)(), inside(_) { case List(cont) =>
      assertNativeComponent(cont, <.div(^.className := container)(), inside(_) { case List(back) =>
        assertNativeComponent(back, <.div(^.className := background)(), inside(_) { case List(row1, row2, row3, row4) =>
          assertTestComponent(row1, Puzzle15ViewRow) { case Puzzle15ViewRowProps(style, items, _) =>
            style shouldBe topRow
            items shouldBe model.row(0)
          }
          assertTestComponent(row2, Puzzle15ViewRow) { case Puzzle15ViewRowProps(style, items, _) =>
            style shouldBe row
            items shouldBe model.row(1)
          }
          assertTestComponent(row3, Puzzle15ViewRow) { case Puzzle15ViewRowProps(style, items, _) =>
            style shouldBe row
            items shouldBe model.row(2)
          }
          assertTestComponent(row4, Puzzle15ViewRow) { case Puzzle15ViewRowProps(style, items, _) =>
            style shouldBe bottomRow
            items shouldBe model.row(3)
          }
        })
      })
    })
  }
}
