package org.illithid.cccp.bestiary;

import org.illithid.cccp.Face;
import org.illithid.cccp.intelligence.Intelligence;

import net.slashie.libjcsi.CSIColor;

public class Hero extends Actor {
    String name = "Hero";
	
	public Hero(Intelligence intelligence) {
        face = new Face('@', CSIColor.BEIGE);
        setIntelligence(intelligence);
    }
    
    @Override
    public boolean isA(String s){
    	if(s.equalsIgnoreCase(name) || super.isA(s))
    		return true;
    	return false;
    }
}
