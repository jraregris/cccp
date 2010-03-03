package org.illithid.cccp.intelligence;

import java.util.Collection;


import org.illithid.cccp.CCCP;
import org.illithid.cccp.MessageBuffer;
import org.illithid.cccp.bestiary.Actor;
import org.illithid.cccp.bestiary.Hero;
import org.illithid.cccp.world.Direction;
import org.illithid.cccp.world.Level;

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
			if(a.isA(Hero.class))
				mark = a;
	}

	private void approach(Actor mark) {
		int hx = mark.getX();
		int hy = mark.getY();
		int ax = actor.getX();
		int ay = actor.getY();

		if (hx == ax && hy < ay)
			actor.goNorth();
		if (hx > ax && hy < ay)
			actor.goNorthEast();
		if (hx > ax && hy == ay)
			actor.goEast();
		if (hx > ax && hy > ay)
			actor.goSouthEast();
		if (hx == ax && hy > ay)
			actor.goSouth();
		if (hx < ax && hy > ay)
			actor.goSouthWest();
		if (hx < ax && hy == ay)
			actor.goWest();
		if (hx < ax && hy < ay)
			actor.goNorthWest();

		
		moveInto(getLevel().getDirectionTo(mark));
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
	}

	public void setMark(Actor hero) {
		this.mark = hero;		
	}

	public Actor getMark() {
		return mark;
	}

}
