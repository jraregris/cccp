package org.illithid.cccp;

import net.slashie.libjcsi.ConsoleSystemInterface;
import net.slashie.libjcsi.jcurses.JCursesConsoleInterface;
import net.slashie.libjcsi.wswing.WSwingConsoleInterface;

<<<<<<< HEAD:src/main/java/org/illithid/cccp/CCCP.java
import org.illithid.cccp.bestiary.Dalek;
import org.illithid.cccp.bestiary.Hero;
import org.illithid.cccp.intelligence.HumanIntelligence;
import org.illithid.cccp.world.Level;
import org.illithid.cccp.world.RandomLevel;

public class CCCP extends Thread {
    private static ConsoleSystemInterface csi;
    private static int                    turns = 0;

    private static Level                  level;
    private static Hero                   hero;

    public static void main(String args[]) throws InterruptedException {
        if (args.length > 0 && args[0].equalsIgnoreCase("-c"))
            initCurses();
        else
            initSwing();

        // actors.add(new Hero(new HumanIntelligence(csi)));
        // for (int i = 0; i < 10; i++)
        // actors.add(new Dalek());
        //

        level = new RandomLevel();
        Hero h = new Hero(new HumanIntelligence(csi));
        hero = h;
        level.add(h);
        for (int i = 0; i < 10; i++) {
            level.add(new Dalek());
        }

        while (true) {
            drawScreen();
            getInput();

            turns++;
        }

    }

    private static void initCurses() {
        try {
            csi = new JCursesConsoleInterface();
        } catch (ExceptionInInitializerError eiie) {
            System.out.println("Fatal Error Initializing JCurses");
            eiie.printStackTrace();
            System.exit(-1);
        }
    }

    private static void initSwing() {
       	try {
            csi = new WSwingConsoleInterface(
                    "Illithid CCCP 0.0.4 - Level branch", true);
        } catch (ExceptionInInitializerError eiie) {
            System.out.println("Fatal Error Initializing Swing Console Box");
            eiie.printStackTrace();
            System.exit(-1);
        }
    }

    private static void getInput() {
        level.act();
    }

    private static void drawScreen() {

        csi.cls();
<<<<<<< HEAD:src/main/java/org/illithid/cccp/CCCP.java
<<<<<<< HEAD:src/main/java/org/illithid/cccp/CCCP.java
        drawActors();
=======
        drawAwesome();
=======

>>>>>>> e1d85bf... stash commit:src/main/java/org/illithid/cccp/CCCP.java
        drawStuff();
>>>>>>> 16ffb12... branchsfins:src/main/java/org/illithid/cccp/CCCP.java
        drawUI();

        csi.refresh();
    }

    private static void drawStuff() {
        for (int x = 0; x < level.getX(); x++) {
            for (int y = 0; y < level.getY(); y++) {
                Face f = level.getCell(x, y).getFace();
                csi.print(x, y, f.getFace(), f.getColor());
            }
        }
    }

    private static void drawUI() {
        csi.print(0, 0, "*", CSIColor.WHEAT);
        csi.print(79, 0, "*", CSIColor.WHEAT);
        csi.print(0, 24, "*", CSIColor.WHEAT);
        csi.print(79, 24, "*", CSIColor.WHEAT);
        csi.print(1, 0, "CCCP", CSIColor.GRAY);
        csi.print(1, 1, "T:" + turns, CSIColor.GRAY);

    }

    public static void quit() {
        System.out.println("Exited by user");
        System.exit(0);

    }

    public static Level getLevel() {
        return level;
    }

    public static Hero getHero() {
        return hero;
    }

=======
public class CCCP {

	private static CCCPGame game;
	public static void main(String[] args) {
		game = new CCCPGame();

		if (args.length > 0 && args[0].equalsIgnoreCase("-c"))
			game.setCSI(initCurses());
		else
			game.setCSI(initSwing());
		
		game.run();
	}

	private static ConsoleSystemInterface initSwing() {
		try {
			return new WSwingConsoleInterface(
					"Illithid CCCP 0.0.4.2 - Level branch", true);
		} catch (ExceptionInInitializerError eiie) {
			System.out.println("Fatal Error Initializing Swing Console Box");
			eiie.printStackTrace();
			System.exit(-1);
		}
		return null;
	}

	private static ConsoleSystemInterface initCurses() {
		try {
			return new JCursesConsoleInterface();
		} catch (ExceptionInInitializerError eiie) {
			System.out.println("Fatal Error Initializing JCurses");
			eiie.printStackTrace();
			System.exit(-1);
		}
		return null; // It won't ever get this far. But eclipse doesn't get it.
	}
	
	public static CCCPGame getGame(){
		return game;
	}
>>>>>>> 607b2c6... Made a starter class, CCCP and moved the old CCCP to CCCPGame. Refactored some other classes that statically referenced CCCP and some other general cleanups.:src/main/java/org/illithid/cccp/CCCP.java
}
