package org.illithid.cccp.bestiary;

import java.util.Random;

import net.slashie.libjcsi.CSIColor;


public class Dalek extends Robot {
    Random r = new Random();
    
    public Dalek(){
        face = 'd';
        colour = CSIColor.GOLD;
        intelligence = new DalekIntelligence();
        intelligence.actfor(this);
        x = r.nextInt(80);
        y = r.nextInt(20);
    }
}
