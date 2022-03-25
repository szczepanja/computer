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

  val board: Array[Array[String]] = Array.fill(m, n)(" . ")
}

object Game extends App {
  val table = Board(4, 5)

  def getWord(line: String) = {
    val words = line.split("\\W+").map { w => w match {
        case w if w.startsWith("CREATE") => println("Coś")
      }
    }

    words.foldLeft(table) { (board, cmd) =>
      cmd match {
        case _ => Board(1, 2)
//        case Create(symbol, x, y) => board.create('>', 0, 0)
      }
    }
  }

  def readContent() = {
    table.fileContent.foldLeft(()) { (m, n) =>
      getWord(table.fileContent.toString())
    }
  }

  readContent()
}
