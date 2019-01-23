package scommons.examples.puzzle15

case class Puzzle15Model(items: List[Puzzle15ModelItem] = Puzzle15Model.target) {

  def row(rowIndex: Int): List[Puzzle15ModelItem] = {
    val from = rowIndex * 4
    items.slice(from, from + 4)
  }

  def move(itemIndex: Int): Puzzle15Model = {
    val itemToMove = items(itemIndex)
    val emptyIndex = items.indexOf(Puzzle15ModelItem.Empty)

    if (emptyIndex != itemIndex && (
      emptyIndex == itemIndex - 1
        || emptyIndex == itemIndex + 1
        || emptyIndex == itemIndex - 4
        || emptyIndex == itemIndex + 4
      )) {
      Puzzle15Model(items
        .updated(itemIndex, Puzzle15ModelItem.Empty)
        .updated(emptyIndex, itemToMove)
      )
    }
    else this
  }
}

object Puzzle15Model {

  private val target = List(
    Puzzle15ModelItem._1,
    Puzzle15ModelItem._2,
    Puzzle15ModelItem._3,
    Puzzle15ModelItem._4,
    Puzzle15ModelItem._5,
    Puzzle15ModelItem._6,
    Puzzle15ModelItem._7,
    Puzzle15ModelItem._8,
    Puzzle15ModelItem._9,
    Puzzle15ModelItem._10,
    Puzzle15ModelItem._11,
    Puzzle15ModelItem._12,
    Puzzle15ModelItem._13,
    Puzzle15ModelItem._14,
    Puzzle15ModelItem._15,
    Puzzle15ModelItem.Empty
  )
}
