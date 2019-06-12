package older;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Created by Eric.Graham on 4/11/2017.
 */
public class Main extends Application {
    private static Stage stage;

    @Override
    public void start(Stage stage) {
        this.stage = stage;

        new Game();

        stage.setTitle("BattleShip v2");
        stage.setOnCloseRequest(event -> System.exit(0));
        stage.show();
    }

    public static Stage getStage() {
        return stage;
    }
}
