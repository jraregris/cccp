package org.illithid.cccp.world;

import org.illithid.cccp.ActorList;
import org.illithid.cccp.bestiary.Actor;

public abstract class BaseLevel implements Level {
    public static ActorList               actors = new ActorList();
    
    final int X     = 80;
    final int Y     = 25;

    Cell[][]  cells = new Cell[X][Y];

    public BaseLevel() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = new Cell();
            }
            
        }
    }

    public Actor[] getActors(){
        return actors.getAll();
    }
    
    public void act(){
        for(Actor a : actors.getAll()){
            if(a!=null)
                a.act();
        }
            
    }
    
    
    
    public void add(Actor a){
        actors.add(a);
        place(a);
    }
    
    public int getX(){
        return X;
    }
    
    public int getY(){
        return Y;
    }
    
    public void add(Actor[] all) {
        for (Actor a : all)
            add(a);
    }
}
