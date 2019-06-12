package old;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eric.Graham on 4/10/2017.
 */
public class GameMain {
    private static GameMain instance = new GameMain();
    private Table<Integer, Integer, Rectangle> playerSonar = HashBasedTable.create(), botSonar = HashBasedTable.create();

    private List<Ship> playerShips = new ArrayList<>(), botShips = new ArrayList<>(); // Outer list- ships; inner list- arrays ({x, y} coords)
    public final int[] SHIPLENGTHS = {3, 4, 5, 6, 7};

    private GameMain() { // Private so it can only be made via singleton
        instance = this;
        drawScreen();
        new GamePlayer(GamePlayer.PlayerType.BOT); // TEMP!
        System.out.println("Now player");
        GamePlayer player = new GamePlayer(GamePlayer.PlayerType.HUMAN);
        System.out.println("Loops");
        for (int i : playerSonar.columnKeySet()) {
            for (int m : playerSonar.rowKeySet()) {
                player.fireAt(i, m);
            }
        }
    }

    public void drawScreen() {
        for (int y = 0; y <= 10; y++) {
            for (int x = 0; x <= 10; x++) {
                Rectangle rectangle = new Rectangle(x * 20, y * 20, 20, 20);
                rectangle.setFill(Color.WHITE);
                rectangle.setStroke(Color.GRAY);
                rectangle.setOnMouseEntered(event -> rectangle.setFill(new Color(.2, .2, .2, .5)));
                rectangle.setOnMouseExited(event -> rectangle.setFill(Color.WHITE));
                playerSonar.put(x, y, rectangle);
                GameScreen.getInstance().addObjectsToScene(rectangle);
            }
        }
        for (int y = 0; y <= 10; y++) {
            for (int x = 0; x <= 10; x++) {
                Rectangle rectangle = new Rectangle(x * 20, 250 + y * 20, 20, 20);
                rectangle.setFill(Color.WHITE);
                rectangle.setStroke(new Color(0.6471, 0.6471, 0.6471, 1));
                playerSonar.put(x, y, rectangle);
                GameScreen.getInstance().addObjectsToScene(rectangle);
            }
        }
        GameScreen.getInstance().updateScene();
        System.out.println("Done");
    }

    public Table<Integer, Integer, Rectangle> getPlayerSonar() {
        return playerSonar;
    }

    public Table<Integer, Integer, Rectangle> getBotSonar() {
        return botSonar;
    }

    public List<Ship> getPlayerShips() {
        return playerShips;
    }

    public List<Ship> getBotShips() {
        return botShips;
    }

    public void addBotShip(Ship ship) {
        botShips.add(ship);
    }

    public boolean isCoordUsed(int x, int y) {
        return botShips.stream().anyMatch(ship -> ship.isInRange(x, y)) || playerShips.stream().anyMatch(ship -> ship.isInRange(x, y));
    }

    public boolean isHit(GamePlayer attacker, int x, int y) {
        if (attacker.getSide() == GamePlayer.PlayerType.BOT) {
            return playerShips.stream().anyMatch(ship -> ship.isInRange(x, y));
        } else {
            return botShips.stream().anyMatch(ship -> ship.isInRange(x, y));
        }
    }

    public static GameMain getInstance() {
        return instance;
    }
}
