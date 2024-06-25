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
    val startCoordinates = Coordinate(Pair(0, 0))
    val word = startCoordinates.calculateWord(gridMap)
    println("Word: $word")
}

private fun printMatrix(gridMap: List<String>) {
    for (i in gridMap) {
        val ch = i.replace(' ', '_')
        println(ch)
    }
}
