package org.illithid.cccp.bestiary;

import org.illithid.cccp.Actor;
import org.illithid.cccp.BaseIntelligence;
import org.illithid.cccp.CCCP;
import org.illithid.cccp.Hero;

public class DalekIntelligence extends BaseIntelligence {
    boolean tick = false;

    @Override
    public void act() {
        if (tick) {
            Hero hero = null;
            for (Actor a : CCCP.actors)
                if (a instanceof Hero)
                    hero = (Hero) a;
            if (hero != null)
                approach(hero);
            else
                goRandom();
            tick = false;
        } else {
            tick = true;

        }

    }

    private void goRandom() {

    }

    private void approach(Hero hero) {
        int hx = hero.getX();
        int hy = hero.getY();
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
