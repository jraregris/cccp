package org.illithid.cccp.bestiary;

import org.illithid.cccp.CCCP;
import org.illithid.cccp.Face;
import org.illithid.cccp.intelligence.Intelligence;
import org.illithid.cccp.world.Direction;
import org.illithid.cccp.world.Occupier;

public abstract class Actor implements Occupier {
	protected Face face;

	protected Intelligence intelligence;

	public Face getFace() {
		return face;
	}

	public void goWest() {
		CCCP.getLevel().move(1, Direction.WEST, this);

	}

	public void goSouth() {
		CCCP.getLevel().move(1, Direction.SOUTH, this);
	}

	public void goNorth() {
		CCCP.getLevel().move(1, Direction.NORTH, this);
	}

	public void goEast() {
		CCCP.getLevel().move(1, Direction.EAST, this);

	}

	public void goNorthWest() {
		CCCP.getLevel().move(1, Direction.NORTHWEST, this);
	}

	public void goNorthEast() {
		CCCP.getLevel().move(1, Direction.NORTHEAST, this);
	}

	public void goSouthWest() {
		CCCP.getLevel().move(1, Direction.SOUTHWEST, this);
	}

	public void goSouthEast() {
		CCCP.getLevel().move(1, Direction.SOUTHEAST, this);
	}

	public void stay() {
	}

	public void act() {
		intelligence.act();
	}

	public int getX(){
		return CCCP.getLevel().getXof(this);
	}
	
	public int getY(){
		return CCCP.getLevel().getYof(this);
	}
}
