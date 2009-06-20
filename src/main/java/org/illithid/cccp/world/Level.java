package org.illithid.cccp.world;

import org.illithid.cccp.bestiary.Actor;

public interface Level {
    public void add(Actor a);
    public void add(Actor[] a);
    public int getX();
    public int getY();
    public Cell getCell(int x, int y);
    void place(Actor a);
    public void act();
    public Actor[] getActors();
    public void move(int i, Direction d, Actor actor);
	public int getXof(Actor actor);
	public int getYof(Actor actor);
}
