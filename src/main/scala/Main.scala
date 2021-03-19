import cats.effect._
import fs2._

object Main extends IOApp.Simple {

  private val nums = List(1, 2, 3)

  // Note that `Stream[IO, Int]` doesn't crash but produces the expected type-error.
  // Without the explicit type annotations it crashes, even when using `.covary[IO]`.
  override def run: IO[Unit] =
    Stream(nums)
}
