package org.illithid.cccp.intelligence;

import org.illithid.cccp.CCCP;
import org.illithid.cccp.CCCPGame;
import org.illithid.cccp.bestiary.Actor;
import org.illithid.cccp.bestiary.Hero;

public class DalekIntelligence extends BaseIntelligence {
    boolean tick = false;
    Actor   mark;

    @Override
    public void act() {
        if (mark != null)
            approach(mark);
        else
            newMark();

        if (tick) {
            Hero hero = null;
            for (Actor a : CCCP.getGame().getLevel().getActors())
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

    private void newMark() {
        Hero h = CCCP.getGame().getHero();
        if (h != null)
            mark = h;
    }

    private void goRandom() {

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
