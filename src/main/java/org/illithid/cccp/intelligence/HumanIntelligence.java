package org.illithid.cccp.intelligence;

import org.illithid.cccp.CCCPGame;

import net.slashie.libjcsi.CharKey;
import net.slashie.libjcsi.ConsoleSystemInterface;

public class HumanIntelligence extends BaseIntelligence {
    ConsoleSystemInterface csi;
    public HumanIntelligence(ConsoleSystemInterface csi) {
        this.csi = csi;
    }

    public void act(){
        int in = csi.inkey().code;       
        
        if (in == CharKey.h)
            actor.goWest();
        if (in == CharKey.j)
            actor.goSouth();
        if (in == CharKey.k)
            actor.goNorth();
        if (in == CharKey.l)
            actor.goEast();
        if (in == CharKey.y)
            actor.goNorthWest();
        if (in == CharKey.u)
            actor.goNorthEast();
        if (in == CharKey.b)
            actor.goSouthWest();
        if (in == CharKey.n)
            actor.goSouthEast();
        if (in == CharKey.DOT)
            actor.stay();
        if (in == CharKey.Q)
            CCCPGame.quit();
    }
}
