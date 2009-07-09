package org.illithid.cccp;

import net.slashie.libjcsi.CSIColor;

public class Hero {
    private int      x;
    private int      y;

    private char     face   = '@';
    private CSIColor colour = CSIColor.BRONZE;

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

    public char getChar() {
        return face;
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

    public void stay() {
    // TODO Auto-generated method stub

    }

}
