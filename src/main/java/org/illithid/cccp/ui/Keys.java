package org.illithid.cccp.ui;

import net.slashie.libjcsi.CharKey;

public class Keys extends CharKey {
	
	public Keys(int code) {
		super(code);
	}

	@Override
	public boolean isDownArrow(){
		return (super.isDownArrow() || code == CharKey.j);
	}
	
	@Override
	public boolean isDownLeftArrow(){
		return (super.isDownLeftArrow() || code == CharKey.b);
	}
	
	@Override
	public boolean isDownRightArrow(){
		return (super.isDownRightArrow() || code == CharKey.n);
	}
	
	@Override
	public boolean isCenterArrow(){
		return (super.isCenterArrow() || code == CharKey.DOT);
	}
	
	@Override
	public boolean isLeftArrow(){
		return (super.isLeftArrow() || code == CharKey.h);
	}
	
	@Override
	public boolean isRightArrow(){
		return (super.isRightArrow() || code == CharKey.l);
	}
	
	@Override
	public boolean isUpArrow(){
		return (super.isUpArrow() || code == CharKey.k);
	}
	
	@Override
	public boolean isUpLeftArrow(){
		return (super.isUpLeftArrow() || code == CharKey.y);
	}
	
	@Override
	public boolean isUpRightArrow(){
		return (super.isUpRightArrow() || code == CharKey.u);
	}
	
	@Override
	public boolean isSelfArrow(){
		return (super.isSelfArrow() || code == CharKey.DOT);
	}

	public boolean isQuitCommand() {
		return (code == CharKey.Q);
	}
}
