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
public class GFTest {

	private static final int MODULUS = 7;

	private GF zero = new GF(0, MODULUS);
	private GF one = new GF(1, MODULUS);
	private GF two = new GF(2, MODULUS);
	private GF minusTwo = new GF(5, MODULUS);
	private GF aHalf = new GF(4, MODULUS);

	@Test
	public void testZeroIsZero() {

		assertTrue(zero.isZero());
	}

	@Test
	public void testZeroIsNotOne() {

		assertFalse(zero.isOne());
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

	@Test
	public void testTwoDividedByTwoEqualsOne() {

		assertEquals(one, two.divide(two));
	}

	@Test
	public void testZeroDenominatorConstructionFails() {

		try {

			new Rational(0, 0);
		} catch (Exception e) {

			/* This is the expected behavior */
			assertEquals(IllegalArgumentException.class, e.getClass());
		}
	}

	@Test
	public void testDivideByZeroFails() {

		try {

			one.divide(zero);
		} catch (Exception e) {

			/* This is the expected behavior */
			assertEquals(IllegalStateException.class, e.getClass());
		}
	}

	@Test
	public void testTwoLooksLikeAnInteger() {

		assertEquals("2", two.toString());
	}

	@Test
	public void testCallToHashcode() {

		/* This method only calls the hashcode no consequences are attached. */
		zero.hashCode();
	}

	@Test
	public void testZeroIsIdenticalToZero() {

		assertTrue(zero.equals(zero));
	}

	@Test
	public void testZeroDoesNotEqualNull() {

		assertFalse(zero.equals(null));
	}

	@Test
	public void testZeroDoesNotEqualObjectOfOtherClass() {

		Integer integerZero = new Integer(0);

		assertFalse(zero.equals(integerZero));
	}

	@Test
	public void testZeroDoesNotEqualAHalf() {

		assertFalse(zero.equals(aHalf));
	}

	@Test
	public void testOneThirdDoesNotEqualTwoThirds() {

		Rational aThird = new Rational(1, 3);
		Rational twoThirds = new Rational(2, 3);

		assertFalse(aThird.equals(twoThirds));
	}

	@Test
	public void testGCDInputFailure() {

		try {

			Rational.GCD.gcd(0, 0);
		} catch (Exception e) {

			/* This is the intended behavior. */
			assertEquals(IllegalArgumentException.class, e.getClass());
		}
	}

	@Test
	public void testOnePlusOneEqualsTwo() {

		assertEquals(two, one.add(one));
	}
}
