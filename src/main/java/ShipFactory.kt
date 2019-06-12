import javafx.scene.paint.Color
import java.util.*

/**
Copyright (c) 2017, Eric Graham. All Rights Reserved.
 */
class ShipFactory(val gameData: GameData, val display: Display) {
    fun populateBoard(bot: Boolean) {
        val ships: MutableList<Int> = getRandomShips()
        var random = Random()
        var verticalShips: Int = Math.round(random.nextFloat() * (ships.size - 1))
        var x: Int
        var y: Int

        for (i in 0..verticalShips) {
            x = Math.round(random.nextFloat() * 9)
            y = Math.round(random.nextFloat() * 9)
            if (y + ships[i] >= 9) y -= ships[i]
            if (bot) {
                gameData.addBotShip(Ship().setStart(x, y).setEnd(x, y + ships[i]))
            } else {
                gameData.addPlayerShip(Ship().setStart(x, y).setEnd(x, y + ships[i]))
            }
        }

        for (i in verticalShips + 1..ships.size - 1) {
            x = Math.round(random.nextFloat() * 9)
            y = Math.round(random.nextFloat() * 9)
            if (x + ships[i] >= 9) x -= ships[i]
            if (bot) {
                gameData.addBotShip(Ship().setStart(x, y).setEnd(x + ships[i], y))
            } else {
                gameData.addPlayerShip(Ship().setStart(x, y).setEnd(x + ships[i], y))
            }
        }

        if (!bot) gameData.getPlayerShips().flatMap(Ship::getCoords).forEach { display.show(false, it.first, it.second, Color.GREEN) }
    }


    private fun getRandomShips(): MutableList<Int> { // Inspired by http://stackoverflow.com/a/1520212
        var ret = Main.shipLengths
        val rand = (Math.random() * ret.size).toInt() // Mistake that works
        for (i in 0..ret.size - 1) {
            Collections.swap(ret, i, rand)
        }
        return ret
    }
}

/*fun _populateBoard(){
    val ships: MutableList<Int> = getRandomShips()
    var random = Random()
    var verticalShips: Int = Math.round(random.nextFloat()*ships.size)
    var currentX: Int = 1

    for(i in 1.. verticalShips){
        val newX: Int = Math.round((10-currentX)/(verticalShips)*random.nextFloat())+1
        var newY: Int = Math.round(random.nextFloat()*( *//* Credit to Jared Brandt --> *//* 9 - *//* <-- for this super complex code here. *//* ships[i-1]))
            gameData.addBotShip(Ship().setStart(newX, newY).setEnd(newX, newY+ships[i-1]))
            currentX+=newX
        }

        random = Random()
        var currentY: Int = 1

        for (i in 1.. ships.size-verticalShips){
            val newY: Int = Math.round((10-currentY)/(ships.size-verticalShips)*random.nextFloat())+1
            var newX: Int = Math.round(random.nextFloat()*( *//* Credit to Jared Brandt --> *//* 9 - *//* <-- for this super complex code here. *//* ships[i-1]))
            gameData.addBotShip(Ship().setStart(newX, newY).setEnd(newX+ships[i-1], newY))
            currentY+=newY
        }

        gameData.getBotShips()
                .flatMap(Ship::getCoords)
                .forEach { display.show(it.first, it.second) }
    }*/
