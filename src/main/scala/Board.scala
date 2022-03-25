import scala.collection.mutable.ArrayBuffer
import scala.io.Source

case class Create(symbol: Char, x: Int, y: Int)

case class Move(x: Int)

case class Rotate(x: Int)

case class Board(m: Int, n: Int) {
  val filename = "C:\\Users\\a.szczepanik\\Projekty\\Computer\\Instructions.txt"
  val fileContent = Source.fromFile(filename).getLines

  def renderBoard(): Unit = {
    board foreach { row => row foreach print; println }
  }

  val list = ArrayBuffer[Char]()

  def create(symbol: Char, x: Int, y: Int): Board = {
    list.addOne(symbol)
    this
  }

  def move(step: Int) = ???

  def rotate(angle: Int) = ???

  val board: Array[Array[String]] = Array.fill(m, n)(" . ")
}

object Game extends App {
  val table = Board(4, 5)

  def getWord(): Board = {
    val words = table.fileContent.flatMap(c => c.split("\\W+"))

    words.map { w => w match {
        case w.contains("CREATE") => Create(w(1), w(2), w(3))
        case w.contains("ROTATE") => Rotate(w(1))
        case w.contains("MOVE") => Move(w(1))
      }
    }

    words.foldLeft(table) { (board, cmd) =>
      cmd match {
        case Create('>', 0, 0) => board.create('>', 0, 0)
        case Move(0) => board.move(0)
        case Rotate(0) => board.rotate(0)
      }
    }
  }

  def play(): Unit = {
    table.fileContent.foldLeft(()) { (m, n) =>
      getWord(table.fileContent.toString())
    }
  }

  play()
}
