import Constants.Companion.MAX_HEIGHT
import Constants.Companion.MAX_WIDTH
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.function.Executable

class DirectionTest {

    @Test
    fun `move up cursor should be equal to the expected value`() {
        assertAll(
            Executable { assertEquals(Pair(0, 0), Direction.UP.next(Pair(0,0))) },
            Executable { assertEquals(Pair(0 ,0), Direction.UP.next(Pair(0,1))) }
        )
    }

    @Test
    fun `move down cursor should be equal to the expected value`() {
        assertAll(
            Executable { assertEquals(Pair(0, 2), Direction.DOWN.next(Pair(0,1))) },
            Executable { assertEquals(Pair(0 ,MAX_HEIGHT), Direction.DOWN.next(Pair(0, MAX_HEIGHT))) }
        )
    }


    @Test
    fun `move left cursor should be equal to the expected value`() {
        assertAll(
            Executable { assertEquals(Pair(0, 0), Direction.LEFT.next(Pair(0,0))) },
            Executable { assertEquals(Pair(0 ,0), Direction.LEFT.next(Pair(1,0))) }
        )
    }


    @Test
    fun `move right cursor should be equal to the expected value`() {
        assertAll(
            Executable { assertEquals(Pair(1, 0), Direction.RIGHT.next(Pair(0,0))) },
            Executable { assertEquals(Pair(MAX_WIDTH ,0), Direction.RIGHT.next(Pair(MAX_WIDTH, 0))) }
        )
    }


}
