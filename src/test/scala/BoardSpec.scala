import org.scalatest._
import flatspec._
import matchers._

class BoardSpec extends AnyFlatSpec with should.Matchers {
  "A Board" should "draw board m * n" in {
    val board = Board(3, 3)

    board.render()
  }
}
