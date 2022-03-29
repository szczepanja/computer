case class Create(symbol: Char, x: Int, y: Int, id: String)
case class Move(n: Int)
case class Rotate(r: Int)

case class Board(m: Int, n: Int) {
  def renderBoard(): Unit = {
    board foreach { row => row foreach print; println }
  }

  val board: Array[Array[String]] = Array.fill(m, n)(" . ")
}
