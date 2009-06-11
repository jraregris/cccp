package org.illithid.cccp.intelligence;

import org.illithid.cccp.bestiary.Actor;

public abstract class BaseIntelligence implements Intelligence{

    protected Actor actor;
    
    public void actfor(Actor a) {
        actor = a;
    }

}
