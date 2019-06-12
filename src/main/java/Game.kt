import javafx.scene.paint.Color
    import javafx.stage.Stage
    import java.util.*

    /**
 * Created by Eric.Graham on 4/26/2017.
 */
    class Game(val gameData: GameData, val stage: Stage) {
        val display: Display = Display(gameData, stage, this)
        var originalPoint = Pair(-1, -1)
        var workingPoint = Pair(-1, -1)
        var hitList: MutableList<Pair<Int, Int>> = mutableListOf()
        var beginning = true
        var following = false
        val rand: Random = Random()
        var currentDirection = 0

        fun fireAt(x: Int, y: Int) {
            display.show(true, x, y, if (gameData.getBotShips().any { it.isHit(x, y) }) { Color.RED } else { Color.YELLOW })
            if(gameData.getBotShips().all { it.isSunk() }){ display.lockOut(); println("Player wins") }

            val point = returnFireFrom()
            display.show(false, point.first, point.second, if(gameData.getPlayerShips().any { it.isHit(point) }){ Color.RED } else { Color.YELLOW })
            if(gameData.getPlayerShips().all { it.isSunk() }){ display.lockOut(); println("Bot wins") }
        }



        fun returnFireFrom(): Pair<Int, Int> {
            if(workingPoint.first>9 || workingPoint.first<0 || workingPoint.second>9 || workingPoint.second<0){
                workingPoint = if(originalPoint != Pair(-1, -1) && following) originalPoint else Pair((rand.nextFloat() * 9).toInt(), (rand.nextFloat() * 9).toInt())
                return returnFireFrom()
            }

            if (!gameData.getPlayerShips().any { it.isHit(workingPoint) }) {
                if(following){
                    workingPoint = originalPoint
                    if(currentDirection>3) {
                        reset()
                    }else currentDirection++
                    return returnFireFrom()
                }
                workingPoint = Pair((rand.nextFloat() * 9).toInt(), (rand.nextFloat() * 9).toInt())
                return workingPoint
            } else {
                if(beginning || (!following&&!beginning)){ originalPoint = workingPoint; beginning = false; println("Beginning") }

                when(currentDirection){
                    0 -> workingPoint = Pair(workingPoint.first, workingPoint.second+1)
                    1 -> workingPoint = Pair(workingPoint.first+1, workingPoint.second)
                    2 -> workingPoint = Pair(workingPoint.first, workingPoint.second-1)
                    3 -> workingPoint = Pair(workingPoint.first-1, workingPoint.second)
                    else -> {
                        reset()
                        return returnFireFrom()
                    }
                }

                if(workingPoint.first>9 || workingPoint.first<0 || workingPoint.second>9 || workingPoint.second<0){
                    workingPoint = originalPoint
                    return returnFireFrom()
                }
                following = true

                return workingPoint
            }
        }

        private fun reset(){
            beginning = false
            currentDirection = 0
            originalPoint = Pair(-1, -1)
            following = false
            workingPoint = Pair((rand.nextFloat() * 9).toInt(), (rand.nextFloat() * 9).toInt())
        }
    }

    /*fun fireAt(bot: Boolean, x: Int, y: Int){
        if(!bot&&!botTurn){ // Player's turn
            display.show(true, x, y, if(gameData.getBotShips().any { it.isHit(x, y) }){ Color.RED }else{ Color.YELLOW })

            if(gameData.getBotShips().all { it.isSunk() }){
                println("Player wins!")
                return
            }
            botTurn = true

            // Bot code ------------------------------------------------------------

            if(hitPoints.isEmpty()){
                fireAt(true, (rand.nextFloat()*9).toInt(), (rand.nextFloat()*9).toInt())
            }else{
                if(!lastHit){ // Last try missed, pick another direction.
                    when(currentDirection){
                        0 -> fireAt(true, hitPoints.last().first, hitPoints.last().second+1)
                        1 -> fireAt(true, hitPoints.last().first+1, hitPoints.last().second)
                        2 -> fireAt(true, hitPoints.last().first, hitPoints.last().second-1)
                        3 -> fireAt(true, hitPoints.last().first-1, hitPoints.last().second)
                    }
                }else{
                    if(original == Pair(-1, -1)) original = hitPoints.last() // Original hasn't been set yet
                    when(currentDirection){
                        0 -> fireAt(true, original.first, original.second+1)
                        1 -> fireAt(true, original.first+1, original.second)
                        2 -> fireAt(true, original.first, original.second-1)
                        3 -> fireAt(true, original.first-1, original.second)
                    }
                }
            }
        }else{ // Bot's turn
            var temp = false
            gameData.getPlayerShips().filter { it.isHit(x, y) }.forEach {
                following = true
                lastHit = true
                if(!temp) { // Make sure we don't add extra ships if one's on top
                    temp = true
                    hitPoints.add(Pair(x, y))
                }
            }
            display.show(true, x, y, if(gameData.getPlayerShips().any { it.isHit(x, y) }){ following = false; Color.RED }else{
                if(currentDirection>3){ // Tried in every direction, but none were hits; something's wrong, just pick some other random point.
                    following = false
                    currentDirection = 0
                }
                Color.YELLOW
            })

            if(gameData.getPlayerShips().all { it.isSunk() }) println("Bot wins!")
        }
    }*/


    // SNAPSHOT -------------------------------------------------------------------------------------------------------------------------------------


    /*import javafx.scene.paint.Color
    import javafx.stage.Stage
    import java.util.*

    *//**
     * Created by Eric.Graham on 4/26/2017.
     *//*
    class Game(val gameData: GameData, val stage: Stage) {
        val display: Display = Display(gameData, stage, this)
        var originalPoint = Pair(-1, -1)
        var workingPoint = Pair(-1, -1)
        var beginning = true
        var following = false
        val rand: Random = Random()
        var currentDirection = 0

        fun fireAt(x: Int, y: Int) {
            display.show(true, x, y, if (gameData.getBotShips().any { it.isHit(x, y) }) { Color.RED } else { Color.YELLOW })
            if(gameData.getBotShips().all { it.isSunk() }){ display.lockOut(); println("Player wins") }

            val point = returnFireFrom()
            display.show(false, point.first, point.second, if(gameData.getPlayerShips().any { it.isHit(point) }){ *//*Color.RED*//* randColor() } else { *//*Color.YELLOW*//* randColor() }) // TEMP, FIXME
            if(gameData.getPlayerShips().all { it.isSunk() }){ display.lockOut(); println("Bot wins") }
        }

        fun returnFireFrom(): Pair<Int, Int> {
            if(workingPoint.first>9 || workingPoint.first<0 || workingPoint.second>9 || workingPoint.second<0){
                workingPoint = if(originalPoint != Pair(-1, -1) && following) originalPoint else Pair((rand.nextFloat() * 9).toInt(), (rand.nextFloat() * 9).toInt())
                return returnFireFrom()
            }

            if (!gameData.getPlayerShips().any { it.isHit(workingPoint) }) {
                if(following){
                    workingPoint = originalPoint
                    if(currentDirection>3) {
                        currentDirection = 0
                        following = false
                        originalPoint = Pair(-1, -1)
                        workingPoint = Pair((rand.nextFloat() * 9).toInt(), (rand.nextFloat() * 9).toInt())
                    }else currentDirection++
                    return returnFireFrom()
                }
                workingPoint = Pair((rand.nextFloat() * 9).toInt(), (rand.nextFloat() * 9).toInt())
                return workingPoint
            } else {
                if(beginning){ originalPoint = workingPoint; beginning = false; println("Beginning") }

                when(currentDirection){
                    0 -> workingPoint = Pair(workingPoint.first, workingPoint.second+1)
                    1 -> workingPoint = Pair(workingPoint.first+1, workingPoint.second)
                    2 -> workingPoint = Pair(workingPoint.first, workingPoint.second-1)
                    3 -> workingPoint = Pair(workingPoint.first-1, workingPoint.second)
                    else -> {
                        currentDirection = 0
                        originalPoint = Pair(-1, -1)
                        following = false
                        workingPoint = Pair((rand.nextFloat() * 9).toInt(), (rand.nextFloat() * 9).toInt())
                        return returnFireFrom()
                    }
                }

                if(workingPoint.first>9 || workingPoint.first<0 || workingPoint.second>9 || workingPoint.second<0){
                    workingPoint = originalPoint
                    return returnFireFrom()
                }
                following = true

                return workingPoint
            }
        }

        fun randColor(): Color = Color(rand.nextDouble(), rand.nextDouble(), rand.nextDouble(), rand.nextDouble())
    }*/
/*
}*/
