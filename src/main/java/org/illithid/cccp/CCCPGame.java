package org.illithid.cccp;

import net.slashie.libjcsi.ConsoleSystemInterface;
import net.slashie.libjcsi.textcomponents.TextInformBox;

import org.illithid.cccp.bestiary.Actor;
import org.illithid.cccp.bestiary.Dalek;
import org.illithid.cccp.bestiary.Hero;
import org.illithid.cccp.intelligence.HumanIntelligence;
import org.illithid.cccp.ui.UI;
import org.illithid.cccp.world.Level;
import org.illithid.cccp.world.RandomLevel;

public class CCCPGame {
	private static final String version = "0.0.5 - Obstacle Branch";
	
	private ConsoleSystemInterface csi;
	private int turns = 0;

	private Level level;
	private Actor hero;
	private UI ui;
	

	public void run(){
	
		ui.mb("Welcome to Colossal Carola Cave Plus " + version + "!");
		ui.mb("Move with vi-keys, and quit with Q.");
		ui.mb("I'd be very happy if you report bugs or/and stuff.");
		
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

		csi.refresh();
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
	    ui.setTurns(turns);
	    
	    ui.draw();

	}

	public static void quit() {
		System.out.println("Exited by user");
		System.exit(0);

	}

	public Level getLevel() {
		return level;
	}

	public Actor getHero() {
		return hero;
	}

	public void setCSI(ConsoleSystemInterface csi) {
		this.csi = csi;
		
	}

	public void init() {
		ui = new UI(csi);
		
		level = new RandomLevel();
		Actor h = new Hero(new HumanIntelligence(csi));
		hero = h;
		level.add(h);
		for (int i = 0; i < 10; i++) {
			level.add(new Dalek());
		}
	}

	public String getVersion() {
		return version;
	}

	public TextInformBox getMB() {
		return ui.getMb();
	}
}
;