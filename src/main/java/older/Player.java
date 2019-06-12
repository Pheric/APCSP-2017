package older;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eric.Graham on 4/11/2017.
 */
public class Player {
    protected List<Ship> ships = new ArrayList();
    private int score = 0;

    public void fireAt(int x, int y) {
        if (game.getBot().isHit(x, y)) {
            score += 10 + (10 - game.getMoves());
            game.getTopScreen().get(x, y).setFill(Color.RED);
        }
    }

    public boolean isHit(int x, int y) {
        return true;
        //return ships.parallelStream().anyMatch(ship -> ship.isHit(x, y)); // FIXME: Is parallel fine here?
    }

    public void addShip(Ship ship) {
        ships.add(ship);
    }

    public List<Ship> getShips() {
        return ships;
    }
}
