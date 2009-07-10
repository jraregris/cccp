package org.illithid.cccp.bestiary;

import org.illithid.cccp.CCCP;
import org.illithid.cccp.Face;
import org.illithid.cccp.intelligence.Intelligence;
import org.illithid.cccp.world.Direction;
import org.illithid.cccp.world.Occupier;

public abstract class Actor implements Occupier {
    protected Face   face;
    
    protected Intelligence intelligence;
    

    public Face getFace() {
        return face;
    }

    public void goWest() {
        CCCP.getLevel().move(1, Direction.WEST, this);

    }

    public void goSouth() {
        y++;
    }

    public void goNorth() {
        y--;
    }

    public void goEast() {
        x++;

    }

    public void goNorthWest() {
        x--;
        y--;
    }

    public void goNorthEast() {
        x++;
        y--;
    }

    public void goSouthWest() {
        x--;
        y++;
    }

    public void goSouthEast() {
        x++;
        y++;
    }

    public void stay() {}

    public void act() {
        intelligence.act();
    }
}
