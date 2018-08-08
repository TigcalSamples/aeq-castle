package com.tigcal.aeq.castle;

import static org.junit.Assert.*;

import org.junit.Test;

public class CastleBuilderTest {

	@Test
	public void noLandHeightsInput() {
		assertEquals(0, CastleBuilder.getNumberOfCastles(new int[] {}));
	}

	@Test
	public void oneLandHeightInput() {
		assertEquals(1, CastleBuilder.getNumberOfCastles(new int[] { 88 }));
	}

	@Test
	public void peak() {
		assertEquals(2, CastleBuilder.getNumberOfCastles(new int[] { 2, 6, 6, 3 }));
	}

	@Test
	public void valley() {
		assertEquals(2, CastleBuilder.getNumberOfCastles(new int[] { 6, 1, 4 }));
	}
}
