import com.google.common.collect.HashBasedTable
import com.google.common.collect.Table
import javafx.scene.shape.Rectangle

/**
 * Created by Eric.Graham on 4/13/2017.
 */
object GameData {
    private var playerShips = mutableListOf<Ship>()
    private var botShips = mutableListOf<Ship>()
    private var topScreen: Table<Int, Int, Rectangle> = HashBasedTable.create()
    private var bottomScreen: Table<Int, Int, Rectangle> = HashBasedTable.create()
    fun addTopCell(x: Int, y: Int, rect: Rectangle) {
        topScreen.put(x, y, rect)
    }

    fun addBottomCell(x: Int, y: Int, rect: Rectangle) {
        bottomScreen.put(x, y, rect)
    }

    fun getBottomTable(): Table<Int, Int, Rectangle> = bottomScreen
    fun getTopTable(): Table<Int, Int, Rectangle> = topScreen

    fun getTopCell(x: Int, y: Int): Rectangle? = topScreen.get(x, y)
    fun getBottomCell(x: Int, y: Int): Rectangle? = bottomScreen.get(x, y)

    fun addPlayerShip(ship: Ship) = playerShips.add(ship)
    fun addBotShip(ship: Ship) = botShips.add(ship)

    fun getPlayerShips(): MutableList<Ship> = playerShips
    fun getBotShips(): MutableList<Ship> = botShips

    fun dump() {
        println("-- Begin Debug Dump --")
        System.out.print("PlayerShips: ")
        playerShips.forEach { System.out.print("Start: (${it.startCoords.first}, ${it.startCoords.second}) End: (${it.endCoords.first}, ${it.endCoords.second}) | ") }
        System.out.print("\nBotShips: ")
        botShips.forEach { System.out.print("Start: (${it.startCoords.first}, ${it.startCoords.second}) End: (${it.endCoords.first}, ${it.endCoords.second}) | ") }
        System.out.print("\nTopScreen:    ")
        topScreen.cellSet().forEach { System.out.print("<${it.columnKey}, ${it.rowKey}, ${it.value == null}> | ") }
        System.out.print("\nBottomScreen: ")
        bottomScreen.cellSet().forEach { System.out.print("<${it.columnKey}, ${it.rowKey}, ${it.value == null}> | ") }
        println("\n-- End Dump --")
    }
}