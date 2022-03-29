import scala.io.Source

class Main {}

object Main extends App {
  val fileName = "instructions.txt"
  val lines = Source.fromFile(fileName).getLines.toSeq
  val board = Board(0, 0)

  val commands = lines.map {
    case line if line.startsWith("BOARD") => {
      val Array(_, m, n) = line.split("\\s+")
      Board(m.toInt, n.toInt)
    }
    case line if line.startsWith("CREATE") => {
      val Array(_, symbol, x, y, id) = line.split("\\s+")
      Create(symbol.charAt(0), x.toInt, y.toInt, id)
    }
    case _ => println("FIXME")
  }

  commands.head match {
    case b: Board => b
    case _ => println("nie zachodzi")
  }

  commands.tail.foldLeft(board) { (b, cmd) =>
    b.render()
    b.execute(cmd)
  }
}
