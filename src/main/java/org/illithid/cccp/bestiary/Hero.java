package org.illithid.cccp.bestiary;

import org.illithid.cccp.intelligence.Intelligence;

import net.slashie.libjcsi.CSIColor;

public class Hero extends Actor {
    public Hero(Intelligence intelligence) {
        face = '@';
        colour = CSIColor.BEIGE;
        intelligence.actfor(this);
        this.intelligence = intelligence;
        x = 40;
        y = 12;
    }
}
