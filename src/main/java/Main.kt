import javafx.application.Application
import javafx.stage.Stage

/**
Copyright (c) 2017, Eric Graham. All Rights Reserved.
 */
class Main : Application() {
    companion object Constants {
        val shipLengths: MutableList<Int> = mutableListOf(2, 2, 3, 3, 3)
    }

    override fun start(stage: Stage) {
        Game(GameData, stage)
    }
}