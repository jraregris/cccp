package org.illithid.cccp.world;

import net.slashie.libjcsi.CSIColor;

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


    public Occupier getOccupant() {
        return occupant;
    }


    public Face getFace() {
        if(occupant!=null)
            return occupant.getFace();
        if(isWalkable())
        	return new Face('.', CSIColor.GRAY);
        return new Face();
    }


	public boolean isOccupiedBy(Occupier a) {
		if(a==occupant)
			return true;
		return false;
	}


	public void removeOccupant() {
		occupant = null;
		
	}

}
