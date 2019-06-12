package older;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import javafx.application.Application;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (c) 2017, Eric Graham. All Rights Reserved.
 */
public class Screen extends Application {
    private static Screen instance;
    private Table<Integer, Integer, Rectangle> topScreen = HashBasedTable.create(), bottomScreen = HashBasedTable.create();
    private List<int[]> playerShips = new ArrayList<>();
    private static final Program program = new Program();
    private Stage stage;
    private Text instructions = new Text("");

    @Override
    public void start(final Stage stage) {
        instance = this;
        this.stage = stage;
        /*
        Group group = new Group();
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                Rectangle rect = new Rectangle(x + 20 * x, y + 20 * y, 20, 20);
                rect.setFill(Color.WHITE);
                rect.setStroke(Color.GRAY);
                rect.setOnMouseEntered(event -> rect.setFill(Color.DARKGRAY));
                rect.setOnMouseExited(event -> rect.setFill(Color.WHITE));
                rect.setOnMouseClicked(event -> program.clickEvent(event));
                topScreen.put(x, y, rect);

                Rectangle rectangle = new Rectangle(x + 20 * x, y + 250 + 20 * y, 20, 20);
                rectangle.setFill(Color.WHITE);
                rectangle.setStroke(new Color(.7, .7, .7, 1));
                group.getChildren().addAll(rect, rectangle);
            }
        }
        instructions.setText("Click a cell to set part of a ship.");

        stage.setScene(new Scene(group));*/

        new Setup();
        stage.show();
    }

    public Text getInstructions() {
        return instructions;
    }

    public Stage getStage() {
        return stage;
    }

    public static Program getProgramInstance() {
        return program;
    }

    public static Screen getInstance() {
        return instance;
    }
}
