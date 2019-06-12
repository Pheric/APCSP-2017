package old;

import javafx.scene.paint.Color;

/**
 * Created by Eric.Graham on 4/10/2017.
 */
public class GamePlayer {
    enum PlayerType {
        BOT, HUMAN
    }

    private PlayerType side;

    public GamePlayer(PlayerType type) {
        side = type;
        if (side == PlayerType.BOT) autosetShips();
    }

    private void autosetShips() {
        int[] ships = GameMain.getInstance().SHIPLENGTHS;
        for (int length : ships) {
            System.out.println(length);
            makeShip(5);
        }
        GameMain.getInstance().getBotShips().forEach(System.out::println);
    }

    private void makeShip(int length) { // TODO: Asynchronous execution
        int randXOne = Math.toIntExact(Math.round(Math.random() * 9));
        int randYOne = Math.toIntExact(Math.round(Math.random() * 9));
        int direction = Math.toIntExact(Math.round(Math.random() * 3));

        if (GameMain.getInstance().isCoordUsed(randXOne, randYOne))
            makeShip(length); // Original coordinate is not unique.

        int randXTwo = randXOne, randYTwo = randYOne;
        switch (direction) {
            case 0: // x++
                randXTwo += length;
                for (int i = randXOne; i <= randXTwo; i++)
                    if (GameMain.getInstance().isCoordUsed(i, randYOne)) makeShip(length);
                break;
            case 1: // x--
                randXTwo -= length;
                for (int i = randXOne; i >= randXTwo; i--)
                    if (GameMain.getInstance().isCoordUsed(i, randYOne)) makeShip(length);
                break;
            case 2: // y++
                randYTwo += length;
                for (int i = randYOne; i <= randYTwo; i++)
                    if (GameMain.getInstance().isCoordUsed(i, randYOne)) makeShip(length);
                break;
            case 3: // y--
                randYTwo -= length;
                for (int i = randYOne; i >= randYTwo; i++)
                    if (GameMain.getInstance().isCoordUsed(i, randYOne)) makeShip(length);
                break;
        }
        // old.older.Ship's coordinates are unique
        GameMain.getInstance().addBotShip(new Ship(randXOne, randYOne, randXTwo, randYTwo));

        // TEMP
        System.out.println("Finished! x1: " + randXOne + " y1: " + randYOne + " x2: " + randXTwo + " y2: " + randYTwo);
    }

    public void fireAt(int x, int y) {
        if (side == PlayerType.BOT) {
            GameMain.getInstance().getPlayerSonar().get(x, y).setFill((GameMain.getInstance().isHit(this, x, y) ? Color.RED : Color.GREEN));
        } else {
            GameMain.getInstance().getBotSonar().get(x, y).setFill((GameMain.getInstance().isHit(this, x, y) ? Color.RED : Color.GREEN));
        }
    }

    public PlayerType getSide() {
        return side;
    }
}
