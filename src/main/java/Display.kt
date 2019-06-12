import javafx.scene.Group
import javafx.scene.Scene
import javafx.scene.paint.Color
import javafx.scene.shape.Rectangle
import javafx.stage.Stage

/**
 * Created by Eric.Graham on 4/13/2017.
 */
class Display(val gameData: GameData, val stage: Stage, val game: Game) {
    var group: Group = Group()

    init {
        stage.setOnCloseRequest { System.exit(0) }
        stage.isResizable = false
        stage.width = 260.toDouble()
        stage.height = 535.toDouble()

        for (x in 0..9) {
            for (y in 0..9) {
                var r1 = Rectangle(x * 21 + 20.toDouble(), y * 21 + 20.toDouble(), 20.toDouble(), 20.toDouble())
                var r2 = Rectangle(x * 21 + 20.toDouble(), y * 21 + 270.toDouble(), 20.toDouble(), 20.toDouble())
                r1.fill = Color.WHITE
                r2.fill = Color.WHITE
                r1.stroke = Color.GRAY
                r2.stroke = Color(.5, .5, .5, 1.toDouble())

                r1.setOnMouseEntered { r1.stroke = Color.GREENYELLOW; r1.strokeWidth = 3.toDouble() }
                r1.setOnMouseExited { r1.stroke = Color.GRAY; r1.strokeWidth = 1.toDouble() }
                r1.setOnMouseClicked { game.fireAt(x, y) }

                r2.setOnMouseEntered { r2.stroke = Color.RED }
                r2.setOnMouseExited { r2.stroke = Color(.5, .5, .5, 1.toDouble()) }

                gameData.addTopCell(x, y, r1)
                gameData.addBottomCell(x, y, r2)
                group.children.addAll(r1, r2)
            }
        }
        stage.scene = Scene(group)
        stage.show()

        val factory = ShipFactory(gameData, this)
        factory.populateBoard(true)
        factory.populateBoard(false)
    }

    /**
     * @param bot Which screen to show on; true shows the top screen
     */
    fun show(bot: Boolean, x: Int, y: Int, color: Color) {
        if (bot) {
            gameData.getTopTable().get(x, y)?.fill = color
            if (gameData.getTopCell(x, y) == null) gameData.dump()
        } else {
            gameData.getBottomTable().get(x, y)?.fill = color
            if (gameData.getBottomCell(x, y) == null) gameData.dump()
        }
    }

    fun lockOut(){
        group.children.forEach {
            it.setOnMouseClicked {  }
        }
    }
}
