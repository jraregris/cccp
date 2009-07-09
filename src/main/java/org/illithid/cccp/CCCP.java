package org.illithid.cccp;

import net.slashie.libjcsi.CSIColor;
import net.slashie.libjcsi.CharKey;
import net.slashie.libjcsi.ConsoleSystemInterface;
import net.slashie.libjcsi.wswing.WSwingConsoleInterface;

public class CCCP extends Thread {
    private static ConsoleSystemInterface csi;
    private static Hero                   hero;
    private static int                    turns = 0;
    

    public static void main(String args[]) throws InterruptedException {
        try {
            csi = new WSwingConsoleInterface("Illithid CCCP 0.0.1");
        } catch (ExceptionInInitializerError eiie) {
            System.out.println("Fatal Error Initializing Swing Console Box");
            eiie.printStackTrace();
            System.exit(-1);
        }

        hero = new Hero();
        hero.setPosition(10, 10);

        boolean exit = false;

        while (true) {
            drawScreen();
            getInput();
            turns++;
        }

    }

    private static void getInput() {
        int in = csi.inkey().code;

        if (in == CharKey.h)
            hero.goWest();
        if (in == CharKey.j)
            hero.goSouth();
        if (in == CharKey.k)
            hero.goNorth();
        if (in == CharKey.l)
            hero.goEast();
        if (in == CharKey.y)
            hero.goNorthWest();
        if (in == CharKey.u)
            hero.goNorthEast();
        if (in == CharKey.b)
            hero.goSouthWest();
        if (in == CharKey.n)
            hero.goSouthEast();
        if (in == CharKey.DOT)
            hero.stay();

    }

    private static void drawScreen() {

        csi.cls();

        drawWalls();
        drawHero();
        drawUI();
        csi.refresh();
    }

    private static void drawHero() {
        csi.print(hero.getX(), hero.getY(), hero.getChar(), hero.getColor());

    }

    private static void drawUI() {
        csi.print(0, 0, "SWINGCURSES TEST!", ConsoleSystemInterface.CYAN);
        csi.print(0, 1, turns + "", CSIColor.OLD_LAVENDER);
        csi
                .print(2, 3,
                        "This is printed using the Java Console System Interface lib. (libjcsi)");
        csi.print(2, 4, "Swing Console Box Implementation",
                ConsoleSystemInterface.RED);
    }

    private static void drawWalls() {
        csi.print(5, 6, "########", ConsoleSystemInterface.GRAY);
        csi.print(5, 7, "#......#", ConsoleSystemInterface.GRAY);
        csi.print(5, 8, "#......#", ConsoleSystemInterface.GRAY);
        csi.print(5, 9, "####/###", ConsoleSystemInterface.GRAY);

        csi.print(6, 7, "......", ConsoleSystemInterface.BLUE);
        csi.print(6, 8, "......", ConsoleSystemInterface.BLUE);

        csi.print(9, 9, "/", ConsoleSystemInterface.BROWN);

    }

}
