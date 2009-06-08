package org.illithid.cccp.bestiary;

import java.util.Random;


public class Dalek extends Robot {
    Random r = new Random();
    
    public Dalek(){
        face = 'd';
        intelligence = new DalekIntelligence();
        intelligence.actfor(this);
        x = r.nextInt(80);
        y = r.nextInt(20);
    }
}
