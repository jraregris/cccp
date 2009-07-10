package org.illithid.cccp.world;

import org.illithid.cccp.Face;


public class Cell {
    Occupier occupant;
    
    
    public boolean isWalkable() {
        if(occupant == null)
            return true;
        return false;
    }


    public void place(Occupier a) {
        occupant = a;        
    }


    public Occupier getOccupier() {
        return occupant;
    }


    public Face getFace() {
        if(occupant!=null)
            return occupant.getFace();
        return new Face();
    }

}
