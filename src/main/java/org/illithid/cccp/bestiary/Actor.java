package org.illithid.cccp.bestiary;

import net.slashie.libjcsi.textcomponents.TextInformBox;

import org.illithid.cccp.CCCP;
import org.illithid.cccp.Face;
import org.illithid.cccp.MessageBuffer;
import org.illithid.cccp.intelligence.Intelligence;
import org.illithid.cccp.world.Direction;
import org.illithid.cccp.world.Level;
import org.illithid.cccp.world.Occupier;

public abstract class Actor implements Occupier {
	protected Face face;

	protected Intelligence intelligence;

	private Level level;
	
	protected String name;
	
	private TextInformBox mb;

	public Face getFace() {
		return face;
	}

	public void goWest() {
		CCCP.getGame().getLevel().move(1, Direction.WEST, this);

	}

	public void goSouth() {
		CCCP.getGame().getLevel().move(1, Direction.SOUTH, this);
	}

	public void goNorth() {
		CCCP.getGame().getLevel().move(1, Direction.NORTH, this);
	}

	public void goEast() {
		CCCP.getGame().getLevel().move(1, Direction.EAST, this);

	}

	public void goNorthWest() {
		CCCP.getGame().getLevel().move(1, Direction.NORTHWEST, this);
	}

	public void goNorthEast() {
		CCCP.getGame().getLevel().move(1, Direction.NORTHEAST, this);
	}

	public void goSouthWest() {
		CCCP.getGame().getLevel().move(1, Direction.SOUTHWEST, this);
	}

	public void goSouthEast() {
		CCCP.getGame().getLevel().move(1, Direction.SOUTHEAST, this);
	}

	public void stay() {
	}

	public void act() {
		intelligence.act();
	}

	public int getX(){
		return CCCP.getGame().getLevel().getXof(this);
	}
	
	public int getY(){
		return CCCP.getGame().getLevel().getYof(this);
	}

	protected void setIntelligence(Intelligence intelligence) {
		intelligence.actfor(this);
	    this.intelligence = intelligence;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
		
	}

	public boolean isA(String s) {
		return false;
	}
	
	public TextInformBox mb(){
		return mb;
	}
	
	public void setMb(TextInformBox mb){
		this.mb = mb;
	}
}
