import org.scalatest._
import flatspec._
import matchers._

class MainSpec extends AnyFlatSpec with should.Matchers {
  "A Board" should "draw board m * n" in {
    val board = Board(3, 3)

    board.render()
  }

  "A Create" should "create class with symbol, x and y positiond, and id" in {
    val create = Create('>', 0, 0, "ID1")
  }
}
