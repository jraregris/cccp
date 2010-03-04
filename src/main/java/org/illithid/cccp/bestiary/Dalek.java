package org.illithid.cccp.bestiary;

import java.util.Random;

import org.illithid.cccp.Face;
import org.illithid.cccp.intelligence.DalekIntelligence;
import org.illithid.cccp.intelligence.DeadIntelligence;
import org.illithid.cccp.world.Occupier;

import net.slashie.libjcsi.CSIColor;

public class Dalek extends Robot {
	Random r = new Random();
	private boolean dead;
	
	public Dalek() {
		name = "Dalek";
		dead = false;
		face = new Face('d', CSIColor.GOLD);
		setIntelligence(new DalekIntelligence());
	}

	public boolean isDead() {
		return dead;
	}

	public void crashInto(Occupier r) {
		if (r.isA("Dalek")) {
			face = new Face('#', CSIColor.GOLD);
			setIntelligence(new DeadIntelligence());
			dead = true;
		}
	}
	
    @Override
    public boolean isA(String s){
    	if(s.equalsIgnoreCase(name) || super.isA(s))
    		return true;
    	return false;
    }
}
