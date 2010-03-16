package org.illithid.cccp.test;

import junit.framework.TestCase;

import org.illithid.cccp.bestiary.Dalek;
import org.junit.Test;


public class DalekTest extends TestCase{
	@Test
	public void testGetsFace() {
		assertNotNull(new Dalek().getFace());
	}
	
	@Test
	public void testShouldExplodeWhenCrashingWithADalek(){
		Dalek d = new Dalek();
		whenChrash(d, new Dalek());		
		assertTrue(d.isDead());
	}

	@Test
	public void testNewDalekIsNotDead(){
		assertFalse(new Dalek().isDead());
	}
	
	private void whenChrash(Dalek d, Dalek dalek) {
		d.crashInto(dalek);
	}
	
	
}
