package org.illithid.cccp.bestiary;

import org.illithid.cccp.intelligence.Intelligence;
import org.illithid.cccp.world.Occupier;

import net.slashie.libjcsi.CSIColor;

public abstract class Actor implements Occupier {
    protected int    x;
    protected int    y;

    protected char   face;
    protected CSIColor colour;
    protected Intelligence intelligence;
    

    public char getFace() {
        return face;
    }

    public void setPosition(int i, int j) {
        x = i;
        y = j;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public CSIColor getColor() {
        return colour;
    }

    public void goWest() {
        x--;

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
