package org.illithid.cccp.world;

import org.illithid.cccp.Face;
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


    public Occupier getOccupant() {
        return occupant;
    }


    public Face getFace() {
        if(occupant!=null)
            return occupant.getFace();
        return new Face();
    }


	public boolean isOccupiedBy(Actor a) {
		if(a==occupant)
			return true;
		return false;
	}


	public void removeOccupant() {
		occupant = null;
		
	}

}
