package org.illithid.cccp.test;

import junit.framework.TestCase;

import org.illithid.cccp.bestiary.Dalek;
import org.junit.Test;


public class DalekTest extends TestCase{
	@Test
	public void testGetsFace() {
		assertNotNull(new Dalek().getFace());
	}
}
