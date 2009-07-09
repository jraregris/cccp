package org.illithid.cccp;

import net.slashie.libjcsi.CSIColor;
import net.slashie.libjcsi.ConsoleSystemInterface;

import org.illithid.cccp.bestiary.Dalek;
import org.illithid.cccp.bestiary.Hero;
import org.illithid.cccp.intelligence.HumanIntelligence;
import org.illithid.cccp.world.Level;
import org.illithid.cccp.world.RandomLevel;

public class CCCPGame {
	private static final String version = "0.0.4 - Message Buffer Branch";
	
	private ConsoleSystemInterface csi;
	private int turns = 0;

	private Level level;
	private Hero hero;
	private MessageBuffer mb;

	public void run(){
	
		mb.say("Welcome to Colossal Carola Cave Plus " + version + "!");
		mb.say("Move with vi-keys, and quit with Q.");
		mb.say("I'd be very happy if you report bugs or/and stuff");
		
		while (true) {
			drawScreen();
			getInput();

			turns++;
		}

	}

	private void getInput() {
		level.act();
	}

	private void drawScreen() {

		csi.cls();

		drawStuff();
		drawUI();
		drawMessageBuffer();

		csi.refresh();
	}

	private void drawMessageBuffer() {
		int x = 1;
		int y = 21;
		for(String s : mb.getHead(3))
			csi.print(x, y++, s, CSIColor.CAMO_GREEN);
			
	}

	private void drawStuff() {
		for (int x = 0; x < level.getX(); x++) {
			for (int y = 0; y < level.getY(); y++) {
				Face f = level.getCell(x, y).getFace();
				csi.print(x+1, y+1, f.getFace(), f.getColor());
			}
		}
	}

	private void drawUI() {
		for(int x=0;x<2;x++)
			for(int i=0;i<24;i++)
				csi.print((x*79),i,"│", CSIColor.CAMO_GREEN);
		csi.print(0, 0, "┌┤    ├───────────────────────────────────────────────────────────────────────├┐", CSIColor.CAMO_GREEN);
		csi.print(2, 0, "CCCP", CSIColor.WHEAT);
		csi.print(77-String.valueOf(turns).length(), 0, "┤", CSIColor.CAMO_GREEN);
		
		csi.print(0, 20, "├──────────────────────────────────────────────────────────────────────────────┤", CSIColor.CAMO_GREEN);
		csi.print(0, 24, "└──────────────────────────────────────────────────────────────────────────────┘", CSIColor.CAMO_GREEN);
		
		csi.print(78-String.valueOf(turns).length(), 0, turns+"", CSIColor.WHEAT);

	}

	public static void quit() {
		System.out.println("Exited by user");
		System.exit(0);

	}

	public Level getLevel() {
		return level;
	}

	public Hero getHero() {
		return hero;
	}

	public void setCSI(ConsoleSystemInterface csi) {
		this.csi = csi;
		
	}

	public void init() {
		mb = new MessageBuffer();
		
		level = new RandomLevel();
		Hero h = new Hero(new HumanIntelligence(csi));
		hero = h;
		level.add(h);
		for (int i = 0; i < 10; i++) {
			level.add(new Dalek());
		}
	}

	public String getVersion() {
		return version;
	}

	public MessageBuffer getMB() {
		return mb;
	}
}
