/**
 * 
 */
package org.effrafax.math.algebra;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * @author Daan van Berkel
 */
public class RationalTest {

	@Test
	public void testZeroRational() {

		Rational element = new Rational(0, 1);

		assertTrue(element.isZero());
		assertFalse(element.isOne());
		assertTrue(element.isInteger());
	}

	@Test
	public void testOneRational() {

		Rational element = new Rational(1, 1);

		assertFalse(element.isZero());
		assertTrue(element.isOne());
		assertTrue(element.isInteger());
	}

	@Test
	public void testOnePlusZeroEqualsOne() {

		Rational zero = new Rational(0, 1);
		Rational one = new Rational(1, 1);

		assertEquals(one, zero.add(one));
		assertEquals(one, one.add(zero));
	}
}
