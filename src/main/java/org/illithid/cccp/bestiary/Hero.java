package org.illithid.cccp.bestiary;

import org.illithid.cccp.Face;
import org.illithid.cccp.intelligence.Intelligence;

import net.slashie.libjcsi.CSIColor;

public class Hero extends Actor {
    public Hero(Intelligence intelligence) {
        face = new Face('@', CSIColor.BEIGE);
        setIntelligence(intelligence);
    }
    
    @Override
    public boolean isA(Class c){
    	if(c == Hero.class || super.isA(c))
    		return true;
    	return false;
    }
}
