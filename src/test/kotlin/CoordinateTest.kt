import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.function.Executable

class CoordinateTest {

    @Test
    fun `create invalid coordinate should throw exception`() {
        assertAll(
            Executable {
                val exception = assertThrows(Exception::class.java) { Coordinate(Pair(-1, 1)) }
                assertEquals("Bad position : outside matrix", exception.message)
            },
            Executable { assertThrows(Exception::class.java) { Coordinate(Pair(1, -1)) } },
            Executable { assertThrows(Exception::class.java) { Coordinate(Pair(13, 1)) } },
            Executable { assertThrows(Exception::class.java) { Coordinate(Pair(1, 27)) } }
        )
    }

    @Test
    fun `given a map when calculate word should return a word `() {
        val gridMap = listOf(
            "******     ",
            "     *     ",
            "     C     ",
            "     *     ",
            "     **O** ",
            "         * ",
            "        d* ",
            "        *  ",
            "     Ni**  ",
            "     *     ",
            "     *     ",
            "     *  g  ",
            "     *  *  ",
            "     *  *  ",
            "     *  *  ",
            "     ****  "
        )
        val coordinate = Coordinate(Pair(0, 0))
        assertEquals("COdiNg", coordinate.calculateWord(gridMap, coordinate, coordinate, ""))
    }

    @Test
    fun `given a second map when calculate word should return a word `() {
        val gridMap = listOf(
            "     *     ",
            "     i     ",
            "     C     ",
            "     *     ",
            "     **O** ",
            "         * ",
            "        d* ",
            "        *  ",
            "     Ni**  ",
            "     *     ",
            "     *     ",
            "     *  g  ",
            "     *  *  ",
            "     *  *  ",
            "     *  *  ",
            "     ****  "
        )
        val coordinate = Coordinate(Pair(5, 0))
        assertEquals("iCOdiNg", coordinate.calculateWord(gridMap, coordinate, coordinate, ""))
    }
}
