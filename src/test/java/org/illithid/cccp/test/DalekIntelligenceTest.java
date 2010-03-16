package org.illithid.cccp.test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collection;

import junit.framework.TestCase;

import net.slashie.libjcsi.textcomponents.TextInformBox;

import org.illithid.cccp.bestiary.Actor;
import org.illithid.cccp.bestiary.Dalek;
import org.illithid.cccp.intelligence.DalekIntelligence;
import org.illithid.cccp.world.Direction;
import org.illithid.cccp.world.Level;
import org.junit.Test;

public class DalekIntelligenceTest extends TestCase {

	@Test
	public void testShouldChooseAHeroAsMark() {
		DalekIntelligence di = new DalekIntelligence();
		Level level = mock(Level.class);
		Dalek dalek = mock(Dalek.class);
		TextInformBox mb = mock(TextInformBox.class);
		
		
		Collection<Actor> al = new ArrayList<Actor>();

		Actor a = mock(Actor.class);

		al.add(a);

		di.actfor(dalek);

		when(dalek.getLevel()).thenReturn(level);
		when(level.getActors()).thenReturn(al);
		when(a.isA("Hero")).thenReturn(true);
		when(dalek.mb()).thenReturn(mb);
		
		di.act();

		verify(dalek).getLevel();
		verify(level).getActors();
		verify(a).isA("Hero");

		assertEquals(a, di.getMark());

	}

	@Test
	public void testShouldMoveIntoHero() {
		DalekIntelligence di = new DalekIntelligence();

		Dalek dalek = mock(Dalek.class);
		Level level = mock(Level.class);
		Actor hero1 = mock(Actor.class);

		di.actfor(dalek);
		dalek.setLevel(level);
		di.setMark(hero1);

		when(dalek.getLevel()).thenReturn(level);
		when(level.getDirectionTo(dalek, hero1)).thenReturn(Direction.NORTH);
		di.act();
		verify(level).getDirectionTo(dalek, hero1);
		verify(dalek).goNorth();
	}

}
