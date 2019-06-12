package old;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Eric.Graham on 4/7/2017.
 */
public class Island extends Circle implements Animator.Animated {
    private double xAnimation = 0, yAnimation = 0;
    private Text label;
    private int unitCount = 0;
    private boolean animating = false;

    /**
     * Constructor
     *
     * @param rate    Rate at which units are generated (one per amount of time)
     * @param centerX old.Island's center
     * @param centerY Islands's center
     * @param radius  old.Island's size
     * @param color   old.Island's color
     */
    public Island(long rate, int centerX, int centerY, int radius, Paint color) {
        super(centerX, centerY, radius, color);
        label = new Text();
        label = new Text(centerX, centerY, unitCount + "Units");
        label.setFill(Color.BLACK);
        label.setFont(new Font(50));
        Main.addToScene(label);

        System.out.println("Rate: " + rate);
        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(() -> label.setText(++unitCount + " Units"), 0, rate, TimeUnit.MILLISECONDS); // Continually update the unit count label
    }

    public void setAnimation(boolean status) {
        animating = status;
        if (animating) {
            Animator.getInstance().addObject(this);
        } else {
            Animator.getInstance().removeObject(this);
        }
    }

    /**
     * Animates the island
     *
     * @param status     Whether or not this should be animating
     * @param xAnimation Amount to shift the circle every tick
     * @param yAnimation Amount to shift the circle every tick
     */

    public void setAnimation(boolean status, int xAnimation, int yAnimation) {
        this.xAnimation = xAnimation;
        this.yAnimation = yAnimation;
        setAnimation(status);
    }

    public void animate() {
        this.setCenterX(this.getCenterX() + xAnimation);
        this.setCenterY(this.getCenterY() + yAnimation);
    }

    public double getXAnimation() {
        return xAnimation;
    }

    public double getYAnimation() {
        return yAnimation;
    }
}
