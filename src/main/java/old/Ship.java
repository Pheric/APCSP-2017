package old;

/**
 * Copyright (c) 2017, Eric Graham. All Rights Reserved.
 */
public class Ship {
    private int[] coordinateOne, coordinateTwo;

    public Ship(int coord1X, int coord1Y, int coord2X, int coord2Y) {
        coordinateOne = new int[]{coord1X, coord1Y};
        coordinateTwo = new int[]{coord2X, coord2Y};
    }

    public boolean isInRange(int x, int y) {
        if (coordinateOne[0] == coordinateTwo[0]) { // Vertical
            if (coordinateOne[0] == x) {
                return Math.max(coordinateOne[1], coordinateTwo[1]) >= y && Math.min(coordinateOne[1], coordinateTwo[1]) <= y;
            }
        } else if (coordinateOne[1] == coordinateTwo[1]) { // Horizontal
            if (coordinateOne[1] == y) {
                return Math.max(coordinateOne[0], coordinateTwo[0]) >= x && Math.min(coordinateOne[0], coordinateTwo[0]) <= x;
            }
        } else {
            throw new IllegalArgumentException("Invalid ship!");
        }
        return false;
    }

    public int[] getCoordinateOne() {
        return coordinateOne;
    }

    public int[] getCoordinateTwo() {
        return coordinateTwo;
    }
}
