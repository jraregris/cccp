package org.illithid.cccp.world;

import org.illithid.cccp.bestiary.Actor;

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
        // TODO Auto-generated method stub
        return null;
    }

}
