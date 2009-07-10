package org.illithid.cccp.world;

import java.util.Random;
import org.illithid.cccp.bestiary.Actor;

public class RandomLevel extends BaseLevel {

	Random rand = new Random();

	public RandomLevel() {
		super();
	}

	@Override
	public void place(Actor a) {
		boolean done = false;
		while (!done) {
			int x = rand.nextInt(X - 1);
			int y = rand.nextInt(Y - 1);
			if (getCell(x, y).isWalkable()) {
				getCell(x, y).place(a);
				done = true;
			}
		}
	}

	public Cell getCell(int x, int y) {
		return cells[x][y];
	}
}
