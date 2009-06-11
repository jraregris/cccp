package org.illithid.cccp.intelligence;

import org.illithid.cccp.bestiary.Actor;

public interface Intelligence {
    void act();

    void actfor(Actor actor);
}
