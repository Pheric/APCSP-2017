package older;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import javafx.event.Event;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eric.Graham on 4/12/2017.
 */
public class Setup {
    private Table<Integer, Integer, Rectangle> graph = HashBasedTable.create();

    public Setup() {
        Group group = new Group();
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                Rectangle rect = new Rectangle(x + 20 * x, y + 20 * y, 20, 20);
                rect.setFill(Color.WHITE);
                rect.setStroke(Color.GRAY);
                rect.setOnMouseEntered(event -> {
                    if (rect.getFill() == Color.WHITE)
                        rect.setFill(Color.GREEN);
                });
                rect.setOnMouseExited(event -> {
                    if (rect.getFill() == Color.GREEN)
                        rect.setFill(Color.WHITE);
                });
                rect.setOnMouseClicked(event -> clickEvent(event));
                graph.put(x, y, rect);
                group.getChildren().add(rect);
            }
        }
        Scene scene = new Scene(group);
        Screen.getInstance().getStage().setScene(scene);
    }

    private int ship = 0;
    private Color shipColor;
    private List<Rectangle> temp = new ArrayList<>();

    private void clickEvent(Event event) {
        Rectangle rect = graph.get((((int) (((Rectangle) event.getSource()).getX() - ((Rectangle) event.getSource()).getX() / 20) + 1) / 10 / 2), (((int) (((Rectangle) event.getSource()).getY() - ((Rectangle) event.getSource()).getY() / 20 + 1) / 10 / 2)));
        if (ship == 0 && temp.size() == 0) {
            rect.setFill(shipColor = randomColor());
        }
        switch (ship) {
            case 0:
                temp.add(rect);
                if (temp.size() > 5) {
                    Screen.getProgramInstance().getPlayer().addShip(new Ship(Screen.getProgramInstance().getPlayer(), temp));
                    rect.setFill(shipColor = randomColor());
                }
                break;
        }
    }

    private Color randomColor() {
        double random = Math.random();
        if (random < .1) {
            return Color.RED;
        } else if (random < .2) {
            return Color.GREEN;
        } else if (random < .3) {
            return Color.BLUE;
        } else if (random < .4) {
            return Color.BLACK;
        } else if (random < .5) {
            return Color.AZURE;
        } else if (random < .6) {
            return Color.BROWN;
        } else if (random < .7) {
            return Color.CORAL;
        } else if (random < .8) {
            return Color.DARKOLIVEGREEN;
        } else if (random < .9) {
            return Color.ORANGERED;
        } else {
            return Color.ORANGE;
        }
    }
}
