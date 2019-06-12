package old;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;

/**
 * Copyright (c) 2017, Eric Graham. All Rights Reserved.
 */
public class GameScreen {
    private static GameScreen instance = new GameScreen();
    private Group group = new Group();
    private Scene scene;

    public void showScreen() {
        Main.getStage().setHeight(525);
        GameMain.getInstance().drawScreen();
    }

    public void addObjectsToScene(Node... nodes) {
        group.getChildren().addAll(nodes);
    }

    public void removeObjectFromScene(Node node) {
        group.getChildren().remove(node);
    }

    public void updateScene() {
        Main.getStage().setScene(scene = new Scene(group));
        Main.getStage().show();
    }

    public static GameScreen getInstance() {
        return instance;
    }
}
