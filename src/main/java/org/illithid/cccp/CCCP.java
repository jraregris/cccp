package org.illithid.cccp;

import net.slashie.libjcsi.ConsoleSystemInterface;
import net.slashie.libjcsi.jcurses.JCursesConsoleInterface;
import net.slashie.libjcsi.wswing.WSwingConsoleInterface;

public class CCCP {

	private static CCCPGame game;
	public static void main(String[] args) {
		game = new CCCPGame();

		if (args.length > 0 && args[0].equalsIgnoreCase("-c"))
			game.setCSI(initCurses());
		else
			game.setCSI(initSwing());
		
		game.init();
		game.run();
	}

	private static ConsoleSystemInterface initSwing() {
		try {
			return new WSwingConsoleInterface(
					"Illithid CCCP " + game.getVersion(), true);
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
}
