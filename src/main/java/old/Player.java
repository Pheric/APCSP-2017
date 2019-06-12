package old;

import older.Ship;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (c) 2017, Eric Graham. All Rights Reserved.
 */
public class Player {
    protected List<Ship> ships = new ArrayList<>();
    protected int score = 0;

    public void addShip(Ship ship) {
        ships.add(ship);
    }
}
