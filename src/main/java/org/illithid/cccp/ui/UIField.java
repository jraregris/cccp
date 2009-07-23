package org.illithid.cccp.ui;

import net.slashie.libjcsi.CSIColor;
import net.slashie.libjcsi.ConsoleSystemInterface;

public class UIField{
    private String                 title;
    private int                    x;
    private int                    y;
    private int                    width;
    private ConsoleSystemInterface csi;
    private CSIColor               color;

    public UIField(ConsoleSystemInterface csi, CSIColor color, int x, int y,
            int width){
        this.csi = csi;
        this.color = color;
        this.x = x;
        this.y = y;
        this.width = width;
    }

    public String getValue(){
        return value;
    }

    public void setValue(String value){
        this.value = value;
    }

    private String value;

    public void draw(){
        csi.print(x, y, value, color);
    }
}
