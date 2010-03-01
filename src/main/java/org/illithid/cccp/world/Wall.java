package org.illithid.cccp.world;

import net.slashie.libjcsi.CSIColor;
import org.illithid.cccp.Face;

public class Wall implements Occupier{
    @Override
    public Face getFace(){
        return new Face('#', CSIColor.GRAY);
    }
}
