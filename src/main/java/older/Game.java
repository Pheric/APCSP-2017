package older;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Created by Eric.Graham on 4/11/2017.
 */
public class Game {
    private static Game instance = new Game();
    private Table<Integer, Integer, Rectangle> topScreen = HashBasedTable.create(), bottomScreen = HashBasedTable.create();
    //private List<older.Ship> playerShips = new ArrayList<>();
    Player player = new Player();
    Bot bot = new Bot();
    private int moves = 0;

    public Game() {
        Group group = new Group();
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                Rectangle rect = new Rectangle(x + 20 * x, y + 20 * y, 20, 20);
                rect.setFill(Color.WHITE);
                rect.setStroke(Color.GRAY);
                rect.setOnMouseEntered(event -> rect.setFill(Color.DARKGRAY));
                rect.setOnMouseExited(event -> rect.setFill(Color.WHITE));
                //rect.setOnMouseClicked(event -> );
                topScreen.put(x, y, rect);
                group.getChildren().add(rect);
            }
        }
        Main.getStage().setScene(new Scene(group));
    }

    public Table<Integer, Integer, Rectangle> getTopScreen() {
        return topScreen;
    }

    public Table<Integer, Integer, Rectangle> getBottomScreen() {
        return bottomScreen;
    }

    public Player getPlayer() {
        return player;
    }

    public Bot getBot() {
        return bot;
    }

    public int getMoves() {
        return moves;
    }

    public void addMove() {
        moves++;
    }

    public static Game getInstance() {
        return instance;
    }
}
