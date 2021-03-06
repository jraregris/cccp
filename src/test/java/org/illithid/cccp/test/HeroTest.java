package org.illithid.cccp.test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import junit.framework.TestCase;

import org.illithid.cccp.bestiary.Actor;
import org.illithid.cccp.bestiary.Hero;
import org.illithid.cccp.intelligence.Intelligence;
import org.illithid.cccp.world.Occupier;
import org.junit.Test;

public class HeroTest extends TestCase {

    @Test
        public void testHeroIsAHero(){
        Intelligence i = mock(Intelligence.class);
        Occupier h = new Hero(i);

        assertTrue(h.isA("Hero"));
        assertFalse(h.isA("Dalek"));
    }

	@Test
	public void testHeroGetsIntelligenceFromConstructor() {
		Intelligence i = mock(Intelligence.class);
		Actor h = new Hero(i);
		verify(i).actfor(h);
	}

	@Test
	public void testGetsFace() {
		Intelligence i = mock(Intelligence.class);
		assertNotNull(new Hero(i).getFace());
	}

}
