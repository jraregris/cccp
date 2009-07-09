package org.illithid.cccp.intelligence;

import org.illithid.cccp.CCCP;
import org.illithid.cccp.bestiary.Actor;
import org.illithid.cccp.bestiary.Hero;

public class DalekIntelligence extends BaseIntelligence {
    boolean tick = false;

    @Override
    public void act() {
        if (tick) {
            Hero hero = null;
            for (Actor a : CCCP.actors.getAll())
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
