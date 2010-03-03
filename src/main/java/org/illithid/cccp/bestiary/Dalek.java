package org.illithid.cccp.bestiary;

import java.util.Random;

import org.illithid.cccp.Face;
import org.illithid.cccp.intelligence.DalekIntelligence;

import net.slashie.libjcsi.CSIColor;

public class Dalek extends Robot {
    Random r = new Random();
    private boolean dead;
    
    public Dalek(){
    	dead = false;
        face = new Face('d', CSIColor.GOLD);
        setIntelligence(new DalekIntelligence());
    }

	public boolean isDead() {
		return dead;
	}

	public void crashInto(Dalek dalek) {
		dead=true;
	}
}
