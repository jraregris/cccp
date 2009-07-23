package org.illithid.cccp.ui;

import net.slashie.libjcsi.CSIColor;
import net.slashie.libjcsi.ConsoleSystemInterface;
import net.slashie.libjcsi.textcomponents.TextBox;
import net.slashie.libjcsi.textcomponents.TextInformBox;

public class UI{
    private TextInformBox          mb;
    private UIField                turns;
    private ConsoleSystemInterface csi;

    public UI(ConsoleSystemInterface si){
        csi = si;
        mb = new TextInformBox(csi);
        mb.setBounds(1, 21, 77, 3);
        mb.setForeColor(CSIColor.CAMO_GREEN);
        turns = new UIField(csi, CSIColor.WHEAT, 70, 0, 5);
    }

    public void mb(String string){
        mb.addText(string);
    }

    public TextInformBox getMb(){
        return mb;
    }

    public void setTurns(int i){
        turns.setValue(Integer.toString(i));
    }

    public void draw(){
        drawChrome();
        mb.draw();
    }

    private void drawChrome(){
        for (int x = 0; x < 2; x++)
            for (int i = 0; i < 24; i++)
                csi.print((x * 79), i, "│", CSIColor.CAMO_GREEN);
        csi
                .print(
                        0,
                        0,
                        "┌┤    ├───────────────────────────────────────────────────────────────────────├┐",
                        CSIColor.CAMO_GREEN);
        csi.print(2, 0, "CCCP", CSIColor.WHEAT);
        csi.print(77 - turns.getValue().length(), 0, "┤",
                CSIColor.CAMO_GREEN);
        csi.print(78 - turns.getValue().length(), 0, turns.getValue(), CSIColor.WHEAT);
        csi
                .print(
                        0,
                        20,
                        "├──────────────────────────────────────────────────────────────────────────────┤",
                        CSIColor.CAMO_GREEN);
        csi
                .print(
                        0,
                        24,
                        "└──────────────────────────────────────────────────────────────────────────────┘",
                        CSIColor.CAMO_GREEN);
    }
}
