package org.illithid.cccp.bestiary;

import net.slashie.libjcsi.textcomponents.TextInformBox;

import org.illithid.cccp.CCCP;
import org.illithid.cccp.Face;
import org.illithid.cccp.intelligence.Intelligence;
import org.illithid.cccp.world.Direction;
import org.illithid.cccp.world.Level;
import org.illithid.cccp.world.Occupier;

public abstract class Actor implements Occupier, Crashable {
	protected Face face;
	
	protected String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	protected Intelligence intelligence;

	private Level level;
	
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
		level.move(1, Direction.NORTH, this);
	}

	public void goEast() {
		level.move(1, Direction.EAST, this);

	}

	public void goNorthWest() {
		level.move(1, Direction.NORTHWEST, this);
	}

	public void goNorthEast() {
		level.move(1, Direction.NORTHEAST, this);
	}

	public void goSouthWest() {
		level.move(1, Direction.SOUTHWEST, this);
	}

	public void goSouthEast() {
		level.move(1, Direction.SOUTHEAST, this);
	}

	public void stay() {
	}

	public void act() {
		intelligence.act();
	}

	public int getX(){
		return level.getXof(this);
	}
	
	public int getY(){
		return level.getYof(this);
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

	
	public TextInformBox mb(){
		return mb;
	}
	
	public void setMb(TextInformBox mb){
		this.mb = mb;
	}

	public void crashInto(Occupier occupant) {
		// TODO Auto-generated method stub
		
	}
    

	public boolean isA(String s){
    	if(s.equalsIgnoreCase(getName()))
    		return true;
    	return false;
    }
}
