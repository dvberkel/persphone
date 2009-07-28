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

	private Rational zero = new Rational(0, 1);
	private Rational one = new Rational(1, 1);
	private Rational two = new Rational(2, 1);
	private Rational minusTwo = new Rational(-2, 1);
	private Rational aHalf = new Rational(1, 2);

	@Test
	public void testZeroIsAnInteger() {

		assertTrue(zero.isInteger());
	}

	@Test
	public void testZeroIsZero() {

		assertTrue(zero.isZero());
	}

	@Test
	public void testZeroIsNotOne() {

		assertFalse(zero.isOne());
	}

	@Test
	public void testOneIsAnInteger() {

		assertTrue(one.isInteger());
	}

	@Test
	public void testOneIsNotZero() {

		assertFalse(one.isZero());
	}

	@Test
	public void testOneIsOne() {

		assertTrue(one.isOne());
	}

	@Test
	public void testZeroPlusZeroEqualsZero() {

		assertEquals(zero, zero.add(zero));
	}

	@Test
	public void testOnePlusZeroEqualsOne() {

		assertEquals(one, zero.add(one));
		assertEquals(one, one.add(zero));
	}

	@Test
	public void testOneTimesOneEqualsOne() {

		assertEquals(one, one.multiply(one));
	}

	@Test
	public void testOneTimesZeroEqualsZero() {

		assertEquals(zero, one.multiply(zero));
		assertEquals(zero, zero.multiply(one));
	}

	@Test
	public void testZeroTimesZeroEqualsZero() {

		assertEquals(zero, zero.multiply(zero));
	}

	@Test
	public void testTwoIsAnInteger() {

		assertTrue(two.isInteger());
	}

	@Test
	public void testMinusTwoHasANegativeNumerator() {

		assertTrue(minusTwo.getNumerator() < 0);
	}

	@Test
	public void testMinusTwoHasAPositiveDenominator() {

		assertTrue(minusTwo.getDenominator() > 0);
	}

	@Test
	public void testMinusTwoIsAnInteger() {

		assertTrue(minusTwo.isInteger());
	}

	@Test
	public void testAHalfIsNotAnInteger() {

		assertFalse(aHalf.isInteger());
	}

	@Test
	public void testMinusTwoIsTheNegativeOfTwo() {

		assertEquals(minusTwo, two.negative());
		assertEquals(two, minusTwo.negative());
	}

	@Test
	public void testTwoPlusMinusTwoEqualsZero() {

		assertEquals(zero, two.add(minusTwo));
		assertEquals(zero, minusTwo.add(two));
	}

	@Test
	public void testTwoSubtractedTwoEqualsTwo() {

		assertEquals(zero, two.subtract(two));
	}

	@Test
	public void testOneHalfIsTheInverseOfTwo() {

		assertEquals(two, aHalf.inverse());
		assertEquals(aHalf, two.inverse());
	}

	@Test
	public void testTwoTimesAHalfEqualsOne() {

		assertEquals(one, two.multiply(aHalf));
		assertEquals(one, aHalf.multiply(two));
	}
}
