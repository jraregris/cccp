package org.illithid.cccp.intelligence;

import java.util.ArrayList;
import java.util.Collection;

import org.illithid.cccp.CCCPGame;
import org.illithid.cccp.ui.Keys;

import net.slashie.libjcsi.CharKey;
import net.slashie.libjcsi.ConsoleSystemInterface;

public class HumanIntelligence extends BaseIntelligence {
    ConsoleSystemInterface csi;
    public HumanIntelligence(ConsoleSystemInterface csi) {
        this.csi = csi;
    }

    public void act(){
        Keys in = new Keys(csi.inkey().code);       
        if (in.isLeftArrow())
            actor.goWest();
        if (in.isDownArrow())
            actor.goSouth();
        if (in.isUpArrow())
            actor.goNorth();
        if (in.isRightArrow())
            actor.goEast();
        if (in.isUpLeftArrow())
            actor.goNorthWest();
        if (in.isUpRightArrow())
            actor.goNorthEast();
        if (in.isDownLeftArrow())
            actor.goSouthWest();
        if (in.isDownRightArrow())
            actor.goSouthEast();
        if (in.isCenterArrow())
            actor.stay();
        if (in.isQuitCommand())
            CCCPGame.quit();
    }
}
