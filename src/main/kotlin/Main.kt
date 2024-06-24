fun main() {
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
    printMatrix(gridMap)
    val word = calculateWord(gridMap)
    println("Word: $word")
}

private fun calculateWord(gridMap: List<String>): String {
    var wordEnd = false
    var word = ""
    var coordinates = Pair(0, 0)
    var previousCoordinates = Pair(0, 0)
    val regex = """[A-Za-z*]""".toRegex()
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
        } else if (coordinates != downCoordinates && previousCoordinates != downCoordinates && regex.matches(downValue.toString())) {
            if (downValue != '*') word = word.plus(downValue)
            previousCoordinates = coordinates.copy()
            coordinates = downCoordinates
        } else if (coordinates != leftCoordinates && previousCoordinates != leftCoordinates && regex.matches(leftValue.toString())) {
            if (leftValue != '*') word = word.plus(leftValue)
            previousCoordinates = coordinates.copy()
            coordinates = leftCoordinates
        } else if (coordinates != rightCoordinates && previousCoordinates != rightCoordinates && regex.matches(rightValue.toString())) {
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

private fun printMatrix(gridMap: List<String>) {
    for (i in gridMap) {
        val ch = i.replace(' ', '_')
        println(ch)
    }
}
