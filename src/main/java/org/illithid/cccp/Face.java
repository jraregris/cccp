package org.illithid.cccp;

import net.slashie.libjcsi.CSIColor;

public class Face {
    Character face;
    CSIColor  color;

    public Face(char c, CSIColor col) {
        face = c;
        color = col;
    }

    public Face() {}

    public Face(char c) {
        face = c;
    }

    public Character getFace() {
        if (face != null)
            return face;
        return ' ';
    }

    public CSIColor getColor() {
        if (color != null)
            return color;
        return new CSIColor();
    }

}
