import Constants.Companion.MAX_HEIGHT
import Constants.Companion.MAX_WIDTH
import Constants.Companion.PATTERN

data class Coordinate(private val position: Pair<Int, Int>) {

    init {
        if (position.first < 0 || position.first > MAX_WIDTH || position.second > MAX_HEIGHT || position.second < 0) {
            throw Exception("Bad position : outside matrix")
        }
    }

    fun calculateWord(gridMap: List<String>, coordinate: Coordinate?, previousCoordinate: Coordinate, word: String): String {
        if(coordinate == null) return word
        var result: Pair<Coordinate, String>? = calculate(gridMap, Direction.UP, coordinate, previousCoordinate, word)
        if (result != null) return calculateWord(gridMap, result.first, coordinate, result.second)
        result = calculate(gridMap, Direction.DOWN, coordinate, previousCoordinate, word)
        if (result != null) return calculateWord(gridMap, result.first, coordinate, result.second)
        result = calculate(gridMap, Direction.LEFT, coordinate, previousCoordinate, word)
        if (result != null) return calculateWord(gridMap, result.first, coordinate, result.second)
        result = calculate(gridMap, Direction.RIGHT, coordinate, previousCoordinate, word)
        if (result != null) return calculateWord(gridMap, result.first, coordinate, result.second)
        return calculateWord(gridMap, null, previousCoordinate, word)
    }

    private fun calculate(
        gridMap: List<String>,
        direction: Direction,
        coordinate: Coordinate,
        previousCoordinate: Coordinate,
        word: String
    ): Pair<Coordinate, String>? {
        val coordinateCalculated = Coordinate(direction.next(coordinate.position))
        val coordinateValue = getValue(coordinateCalculated.position, gridMap)
        if (coordinate != coordinateCalculated && previousCoordinate != coordinateCalculated && PATTERN.toRegex().matches(coordinateValue.toString())) {
            var calculatedWord = word
            if (coordinateValue != '*') {
                calculatedWord = word.plus(coordinateValue)
            }
            return Pair(coordinateCalculated, calculatedWord)
        }
        return null
    }

    private fun getValue(coordinates: Pair<Int, Int>, map: List<String>): Char {
        return map[coordinates.second][coordinates.first]
    }


}
