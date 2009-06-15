package org.illithid.cccp.world;


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

}
