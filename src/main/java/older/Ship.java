package older;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import javafx.scene.shape.Rectangle;

import java.util.List;


/**
 * Created by Eric.Graham on 4/11/2017.
 */
public class Ship {
    Table<Integer, Integer, Rectangle> coords = HashBasedTable.create();
    Player owner;

    public Ship(Player owner, List<Rectangle> rectangles) {
        this.owner = owner;
        for (Rectangle rect : rectangles) coords.put((int) rect.getX(), (int) rect.getY(), rect);
    }

    public void addHit(Rectangle rect) {
        coords.put((int) rect.getX(), (int) rect.getY(), rect);
    }

    public boolean isHit(int x, int y) {
        return coords.contains(x, y);
    }
}
