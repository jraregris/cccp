package org.illithid.cccp;

import net.slashie.libjcsi.CSIColor;
import net.slashie.libjcsi.ConsoleSystemInterface;

import org.illithid.cccp.bestiary.Dalek;
import org.illithid.cccp.bestiary.Hero;
import org.illithid.cccp.intelligence.HumanIntelligence;
import org.illithid.cccp.world.Level;
import org.illithid.cccp.world.RandomLevel;

public class CCCPGame {
	private ConsoleSystemInterface csi;
	private int turns = 0;

	private Level level;
	private Hero hero;

	public void run(){
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
				csi.print(x, y, f.getFace(), f.getColor());
			}
		}
	}

	private void drawUI() {
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

	public Level getLevel() {
		return level;
	}

	public Hero getHero() {
		return hero;
	}

	public void setCSI(ConsoleSystemInterface csi) {
		this.csi = csi;
		
	}

}
