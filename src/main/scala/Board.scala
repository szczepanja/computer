case class Move(n: Int)
case class Rotate(r: Int)

case class Board(m: Int, n: Int) extends Command {

  type ARROW_ID = String
  val arrows = collection.mutable.HashMap.empty[ARROW_ID, Create]

  def execute(cmd: Product): Board = cmd match {
    case c: Create => arrows.addOne(c.id, c)
    this
    case m: Move => println(s"Move m ${m} steps")
      this
  }

  def render(): Unit = {
    board foreach { row => row foreach print; println }
  }

  val board: Array[Array[String]] = Array.fill(m, n)(" . ")
}
