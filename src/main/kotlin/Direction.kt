import Constants.Companion.MAX_HEIGHT
import Constants.Companion.MAX_WIDTH

enum class Direction {
    UP {
        override fun next(coordinates: Pair<Int, Int>): Pair<Int, Int> {
            val p = coordinates.copy(second = coordinates.second.dec())
            if (p.second < 0) return coordinates
            return p
        }
    },
    DOWN {
        override fun next(coordinates: Pair<Int, Int>): Pair<Int, Int> {
            val p = coordinates.copy(second = coordinates.second.inc())
            if (p.second > MAX_HEIGHT) return coordinates
            return p
        }
    },
    LEFT {
        override fun next(coordinates: Pair<Int, Int>): Pair<Int, Int> {
            val p = coordinates.copy(first = coordinates.first.dec())
            if (p.first < 0) return coordinates
            return p
        }
    },
    RIGHT {
        override fun next(coordinates: Pair<Int, Int>): Pair<Int, Int> {
            val p = coordinates.copy(first = coordinates.first.inc())
            if (p.first > MAX_WIDTH) return coordinates
            return p
        }
    };

    abstract fun next(coordinates: Pair<Int, Int>): Pair<Int, Int>
}
