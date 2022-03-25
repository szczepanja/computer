import scala.collection.mutable.ArrayBuffer
import scala.io.Source

case class Board(m: Int, n: Int) {
  val filename = "C:\\Users\\a.szczepanik\\Projekty\\Computer\\Instructions.txt"
  val fileContent = Source.fromFile(filename).getLines.flatMap(_.split("\\W+")).toSeq

  def renderBoard(): Unit = {
    board foreach { row => row foreach print; println }
  }

  val lista = ArrayBuffer[Char]()

  def create(symbol: Char, x: Int, y: Int) = {
    lista.addOne(symbol)
    this
  }

  val board: Array[Array[String]] = Array.fill(m, n)(" . ")
}

object Game extends App {
  val table = new Board(4, 5)

  def getWord(line: String) = {
    val words = line.split("\\W+").toList

    //stworzyć dla każdej instrukcji klasę

    val instructions = Seq("CR", "MO", "REA", "DO")

    words.foldLeft(table.board) { (board, cmd) =>
      cmd match {
        case "CR" => board.create(cmd(0), cmd(1), cmd(2))
      }
    }

    words.head match {
      case "CREATE" =>
        table.board(0)(0) = " > "
        table.renderBoard()
      //            case "ROTATE" => println("")
      //      case "MOVE" => println("")
      case _ => true
    }
    println(words.zipWithIndex)
  }

  readContent()


  def readContent() = {
    table.fileContent.indices.foldLeft(()) { (m, n) =>
      getWord(table.fileContent(n))
    }
  }

  //  readContent()
}
