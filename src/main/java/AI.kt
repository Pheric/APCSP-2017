/**
 * Copyright (c) 2017, Eric Graham. All Rights Reserved.
 */
class AI {
    var hitPoints: MutableList<Pair<Int, Int>> = mutableListOf()
    var lastGuess: Pair<Int, Int> = Pair(0, 0)

    fun addResults(vararg hits: Pair<Int, Int>) {
        hitPoints.addAll(hits)
    }

    fun getNextGuess(lastGuessHit: Boolean): Pair<Int, Int> { // WARNING: Will throw errors if it is allowed to continue after a ship is sunk by moving off the screen

        // return Pair((Math.random()*9).toInt(), (Math.random()*9).toInt()) // TEMP

        println(lastGuessHit)
        if (lastGuessHit) {
            hitPoints.add(lastGuess)
            if (hitPoints[hitPoints.size - 2].first < hitPoints.last().first) { // Horizontal, moving to the right.
                lastGuess = Pair(hitPoints[hitPoints.size - 2].first + 1, hitPoints[hitPoints.size - 2].second)
            } else if (hitPoints[hitPoints.size - 2].first > hitPoints.last().first) { // Horizontal, moving to the left
                lastGuess = Pair(hitPoints[hitPoints.size - 2].first - 1, hitPoints[hitPoints.size - 2].second)
            } else if (hitPoints[hitPoints.size - 2].second < hitPoints.last().second) { // Vertical, moving down
                lastGuess = Pair(hitPoints[hitPoints.size - 2].first, hitPoints[hitPoints.size - 2].second - 1)
            } else if (hitPoints[hitPoints.size - 2].second > hitPoints.last().second) { // Vertical, moving up
                lastGuess = Pair(hitPoints[hitPoints.size - 2].first, hitPoints[hitPoints.size - 2].second + 1)
            }
            //guessedPoints.add(lastGuess) // Temp
            return lastGuess
        } else {
            return Pair((Math.random().toFloat() * 9).toInt(), (Math.random().toFloat() * 9).toInt())
        }
    }
}
