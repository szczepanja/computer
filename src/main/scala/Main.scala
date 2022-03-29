import scala.io.Source

class Main {}

object Main extends App {
  val board = Board(3, 3)

  val fileName = "instructions.txt"
  val lines = Source.fromFile(fileName).getLines

  board.renderBoard()
}
