package org.illithid.cccp;

import java.util.ArrayList;

import org.illithid.cccp.bestiary.Dalek;

import net.slashie.libjcsi.CSIColor;
import net.slashie.libjcsi.CharKey;
import net.slashie.libjcsi.ConsoleSystemInterface;
import net.slashie.libjcsi.wswing.WSwingConsoleInterface;

public class CCCP extends Thread {
    private static ConsoleSystemInterface csi;
    private static Hero                   hero;
    private static int                    turns  = 0;
    public static ArrayList<Actor>        actors = new ArrayList<Actor>();

    public static void main(String args[]) throws InterruptedException {
        try {
            csi = new WSwingConsoleInterface("Illithid CCCP 0.0.1");
        } catch (ExceptionInInitializerError eiie) {
            System.out.println("Fatal Error Initializing Swing Console Box");
            eiie.printStackTrace();
            System.exit(-1);
        }

        actors.add(new Hero(new HumanIntelligence(csi)));
        for (int i = 0; i < 10; i++)
            actors.add(new Dalek());

        boolean exit = false;

        while (true) {
            drawScreen();
            getInput();
            turns++;
        }

    }

    private static void getInput() {
        for (Actor a : actors)
            a.act();
    }

    private static void drawScreen() {

        csi.cls();
        drawAwesome();
        drawActors();
        drawUI();
        csi.refresh();
    }

    private static void drawActors() {
        for (Actor a : actors)
            csi.print(a.getX(), a.getY(), a.face + "");

    }

    private static void drawUI() {
        csi.print(0, 0, "CCCP Sandbox 1", CSIColor.GRAY);
        csi.print(0, 1, "Turns: " + turns, CSIColor.GRAY);

    }

    private static void drawAwesome() {
        csi.print(45, 6, "A", CSIColor.RED);
        csi.print(46, 6, "W", CSIColor.ORANGE);
        csi.print(47, 6, "E", CSIColor.YELLOW);
        csi.print(48, 6, "S", CSIColor.GREEN);
        csi.print(49, 6, "O", CSIColor.BLUE);
        csi.print(50, 6, "M", CSIColor.INDIGO);
        csi.print(51, 6, "E", CSIColor.VIOLET);

    }

    public static void quit() {
        System.out.println("Exited by user");
        System.exit(0);

    }

}
