/**
 * Created by Eric.Graham on 4/13/2017.
 */
class Ship {
    var startCoords: Pair<Int, Int> = Pair(0, 0)
    var endCoords: Pair<Int, Int> = Pair(0, 1)
    var coordList: MutableList<Pair<Int, Int>> = mutableListOf()
    var hitList: MutableList<Pair<Int, Int>> = mutableListOf()

    fun setStart(x: Int, y: Int): Ship {
        startCoords = Pair(x, y)
        return this
    }

    fun setEnd(x: Int, y: Int): Ship {
        endCoords = Pair(x, y)
        setCoordsList()
        return this
    }

    private fun setCoordsList() {
        coordList.clear()
        for (x in startCoords.first..endCoords.first) {
            (startCoords.second..endCoords.second).mapTo(coordList) { Pair(x, it) }
        }
    }

    fun getCoords(): MutableList<Pair<Int, Int>> {
        return coordList
    }

    fun isHit(x: Int, y: Int): Boolean {
        if (coordList.remove(Pair(x, y))) {
            hitList.add(Pair(x, y))
        }
        return hitList.contains(Pair(x, y))
    }

    fun isHit(pair: Pair<Int, Int>): Boolean = isHit(pair.first, pair.second) // Overload

    fun isSunk(): Boolean = coordList.isEmpty()
}