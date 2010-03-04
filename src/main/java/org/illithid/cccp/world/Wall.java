package org.illithid.cccp.world;

import net.slashie.libjcsi.CSIColor;
import org.illithid.cccp.Face;

public class Wall implements Occupier{
    String name;
	
    public Wall(){
    	name = "Wall";
    }
    
	@Override
    public Face getFace(){
        return new Face('#', CSIColor.GRAY);
    }

	public boolean isA(String s) {
		return false;
	}

	@Override
	public String getName() {
		return name;
	}
}
