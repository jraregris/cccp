package org.illithid.cccp.intelligence;

import org.illithid.cccp.CCCP;
import org.illithid.cccp.bestiary.Actor;
import org.illithid.cccp.bestiary.Hero;

public class DalekIntelligence extends BaseIntelligence {
	boolean tick = false;
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
		CCCP.getGame().getMB().say("The Dalek (" + Integer.toHexString(this.hashCode()) +") scans for prey.");
		Hero h = CCCP.getGame().getHero();
		if (h != null)
			mark = h;
		
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

	}

}
