package org.illithid.cccp;

public abstract class BaseIntelligence implements Intelligence{

    protected Actor actor;
    
    public void actfor(Actor a) {
        actor = a;
    }

}
