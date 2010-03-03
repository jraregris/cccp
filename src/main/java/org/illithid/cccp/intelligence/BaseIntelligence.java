package org.illithid.cccp.intelligence;

import net.slashie.libjcsi.textcomponents.TextInformBox;

import org.illithid.cccp.bestiary.Actor;

public abstract class BaseIntelligence implements Intelligence{

    protected Actor actor;
	protected TextInformBox mb;
    
    public void actfor(Actor a) {
        actor = a;
    }

	public TextInformBox getMb() {
		return mb;
	}

	public void setMb(TextInformBox mb) {
		this.mb = mb;
	}

	protected void message(String s) {
		if(mb==null){
			mb = actor.mb();
		}
		mb.addText(s);
	}

}
