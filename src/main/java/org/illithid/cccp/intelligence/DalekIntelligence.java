package org.illithid.cccp.intelligence;

import java.util.Collection;

import org.illithid.cccp.bestiary.Actor;
import org.illithid.cccp.world.Direction;
import org.illithid.cccp.world.Level;
import org.illithid.cccp.world.Occupier;

public class DalekIntelligence extends BaseIntelligence {
	boolean tick = true;
	Actor mark;


	
	@Override
	public void act() {
		if (tick) {
			if (mark != null)
				approach(mark);
			else
				newMark();

			tick = false;
		} else {
			tick = true;

		}

	}
	
	private void newMark() {
		message("The Dalek (" + Integer.toHexString(this.hashCode()) +") scans for prey.");

		Collection<Actor> actors = getLevel().getActors();

		for(Actor a : actors)
			if(a.isA("Hero"))
				mark = a;
	}

	private void approach(Actor mark) {
		moveInto(getLevel().getDirectionTo(actor, mark));
	}

	private Level getLevel() {
		return actor.getLevel();
	}

	private void moveInto(Direction dir) {
		if(dir == Direction.NORTH)actor.goNorth();
		if(dir == Direction.NORTHEAST)actor.goNorthEast();
		if(dir == Direction.EAST)actor.goEast();
		if(dir == Direction.SOUTHEAST)actor.goSouthEast();
		if(dir == Direction.SOUTH)actor.goSouth();
		if(dir == Direction.SOUTHWEST)actor.goSouthWest();
		if(dir == Direction.WEST)actor.goWest();
		if(dir == Direction.NORTHWEST)actor.goNorthWest();
	}

	public void setMark(Actor hero) {
		this.mark = hero;		
	}

	public Occupier getMark() {
		return mark;
	}

}
