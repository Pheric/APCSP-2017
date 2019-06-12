package old;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Created by Eric.Graham on 4/6/2017.
 */
public class Main extends Application {
    private static Stage stage;

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;

        Button startGame = new Button("Start the game!");
        startGame.setOnMouseClicked(event -> new GameScreen().showScreen());

        stage.setOnCloseRequest(event -> System.exit(0));

        Group objects = new Group();
        objects.getChildren().add(startGame);
        Scene scene = new Scene(objects);
        stage.setScene(scene);
        stage.setMinHeight(300);
        stage.setMinWidth(300);
        stage.setTitle("Battleship, v1");
        stage.show();
    }

    public static Stage getStage() {
        return stage;
    }

    /*private static Stage stage;
    private static Group rootGroup = new Group();
    public void start(Stage primaryStage) throws Exception {
        this.stage = primaryStage;
        primaryStage.setMaxHeight(500);
        primaryStage.setMaxWidth(800);

        old.RandomIslandFactory factory = new old.RandomIslandFactory();
        for(int i=0;i<11;i++){
            rootGroup.getChildren().add(factory.createIsland());
        }

        Scene scene = new Scene(rootGroup);
        primaryStage.setScene(scene);
        primaryStage.show();

        primaryStage.setOnCloseRequest(event -> {
            old.Animator.getInstance().interrupt();
            System.exit(0);
        });
    }

    public static void addToScene(Node... node){
        rootGroup.getChildren().addAll(node);
    }

    private double getDistance(Circle circle1, Circle circle2) {
        return Math.sqrt(Math.pow(circle2.getCenterX() - circle1.getCenterX(), 2) + Math.pow(circle2.getCenterY() - circle1.getCenterY(), 2));
    }

    private Color getColoredDistance(double distance) {
        double r = distance / 255;
        double g = (255 - distance) / 255;
        return new Color(r, g, 0, 1);
    }

    public static Stage getStage(){
        return stage;
    }*/
}
