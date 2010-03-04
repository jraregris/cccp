package org.illithid.cccp.world;

import java.util.Collection;

import net.slashie.libjcsi.textcomponents.TextInformBox;

import org.illithid.cccp.bestiary.Actor;

public interface Level {
    public void add(Actor a);
    public void add(Actor[] a);
    public int getX();
    public int getY();
    public Cell getCell(int x, int y);
    void place(Occupier a);
    public void act();
    public Collection<Actor> getActors();
    public void move(int i, Direction d, Actor actor);
	public int getXof(Occupier actor);
	public int getYof(Occupier actor);
	public TextInformBox mb();
	public void setMB(TextInformBox mb);
	Direction getDirectionTo(Actor actor, Actor target);
}