package old;

import javafx.scene.paint.Color;

/**
 * Copyright (c) 2017, Eric Graham. All Rights Reserved.
 */
public class RandomIslandFactory {
    public Island createIsland() {
        Double randX = Math.abs(Main.getStage().getMaxWidth() - Math.random() * 100);
        Double randY = Math.abs(Main.getStage().getMaxHeight() - Math.random() * 100);
        long rate = Math.round(Math.random() * 100);
        Double size = Math.random() * 10;
        return new Island(rate, randX.intValue(), randY.intValue(), size.intValue(), Color.RED);
    }
}