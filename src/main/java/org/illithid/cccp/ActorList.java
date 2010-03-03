package org.illithid.cccp;

import java.util.ArrayList;
import java.util.Collection;

import org.illithid.cccp.bestiary.Actor;

public class ActorList {
    ArrayList<Actor>          actors           = new ArrayList<Actor>();

    private static final long serialVersionUID = -574013274149584937L;

    public Collection<Actor> getAll() {
        return actors;
    }

    public void add(Actor a) {
        actors.add(a);

    }

    public void act() {
        for(Actor a : actors)
            a.act();
    }

}
