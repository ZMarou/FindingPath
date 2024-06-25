import Constants.Companion.MAX_HEIGHT
import Constants.Companion.MAX_WIDTH
import Constants.Companion.PATTERN

class Coordinate(private val position: Pair<Int, Int>) {

    init {
        if (position.first < 0 || position.first > MAX_WIDTH || position.second > MAX_HEIGHT || position.second < 0) {
            throw Exception("Bad position : outside matrix")
        }
    }

    fun calculateWord(gridMap: List<String>): String {
        var wordEnd = false
        var word = ""
        var coordinates = position.copy()
        var previousCoordinates = Pair(0, 0)
        val regex = PATTERN.toRegex()
        while (!wordEnd) {
            val upCoordinates = Direction.UP.next(coordinates)
            val upValue = getValue(upCoordinates, gridMap)
            val downCoordinates = Direction.DOWN.next(coordinates)
            val downValue = getValue(downCoordinates, gridMap)
            val leftCoordinates = Direction.LEFT.next(coordinates)
            val leftValue = getValue(leftCoordinates, gridMap)
            val rightCoordinates = Direction.RIGHT.next(coordinates)
            val rightValue = getValue(rightCoordinates, gridMap)
            if (coordinates != upCoordinates && previousCoordinates != upCoordinates && regex.matches(upValue.toString())) {
                if (upValue != '*') word = word.plus(upValue)
                previousCoordinates = coordinates.copy()
                coordinates = upCoordinates
            } else if (coordinates != downCoordinates && previousCoordinates != downCoordinates && regex.matches(
                    downValue.toString()
                )
            ) {
                if (downValue != '*') word = word.plus(downValue)
                previousCoordinates = coordinates.copy()
                coordinates = downCoordinates
            } else if (coordinates != leftCoordinates && previousCoordinates != leftCoordinates && regex.matches(
                    leftValue.toString()
                )
            ) {
                if (leftValue != '*') word = word.plus(leftValue)
                previousCoordinates = coordinates.copy()
                coordinates = leftCoordinates
            } else if (coordinates != rightCoordinates && previousCoordinates != rightCoordinates && regex.matches(
                    rightValue.toString()
                )
            ) {
                if (rightValue != '*') word = word.plus(rightValue)
                previousCoordinates = coordinates.copy()
                coordinates = rightCoordinates
            } else wordEnd = true
        }
        return word
    }

    private fun getValue(coordinates: Pair<Int, Int>, map: List<String>): Char {
        return map[coordinates.second][coordinates.first]
    }
}
