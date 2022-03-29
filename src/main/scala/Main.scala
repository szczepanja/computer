import scala.io.Source

class Main {}

object Main extends App {
  val board = Board(3, 3)

  val fileName = "instructions.txt"
  val lines = Source.fromFile(fileName).getLines.toSeq

  lines.map {
    case line if line.startsWith("CREATE") => {
      val Array(_, symbol, x, y, id) = line.split("\\s+")
      Create(symbol.charAt(0), x.toInt, y.toInt, id)
    }
    case _ => println("FIXME")
  }.foreach(println)
}
