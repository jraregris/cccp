package org.illithid.cccp;

import net.slashie.libjcsi.CSIColor;

public class Hero extends Actor {
    public Hero(Intelligence intelligence) {
        face = '@';
        colour = CSIColor.BRONZE;
        intelligence.actfor(this);
        this.intelligence = intelligence;
        x = 40;
        y = 12;
    }
}
