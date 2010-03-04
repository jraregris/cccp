package org.illithid.cccp.world;

import org.illithid.cccp.Face;

public interface Occupier {
    public String getName();
	
	public Face getFace();

	public boolean isA(String s);
}
