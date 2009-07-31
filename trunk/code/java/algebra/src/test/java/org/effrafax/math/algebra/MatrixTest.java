/**
 * 
 */
package org.effrafax.math.algebra;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Daan van Berkel
 */
public class MatrixTest {

	private Matrix<GF> zero;
	private Matrix<GF> one;
	private Matrix<GF> two;
	private Matrix<GF> minusTwo;
	private Matrix<GF> aHalf;

	@Before
	public void constructMatrices() {

		int modulus = 7;

		GF zero = new GF(0, modulus);
		GF one = new GF(1, modulus);
		GF two = new GF(2, modulus);
		GF minusTwo = new GF(5, modulus);
		GF aHalf = new GF(4, modulus);

		this.zero = new Matrix<GF>(3, Arrays.asList(new GF[] {zero, zero, zero,
				zero, zero, zero, zero, zero, zero }));
		this.one = new Matrix<GF>(3, Arrays.asList(new GF[] {one, zero, zero,
				zero, one, zero, zero, zero, one }));
		this.two = new Matrix<GF>(3, Arrays.asList(new GF[] {two, zero, zero,
				zero, two, zero, zero, zero, two }));
		this.minusTwo = new Matrix<GF>(3, Arrays.asList(new GF[] {minusTwo,
				zero, zero, zero, minusTwo, zero, zero, zero, minusTwo }));
		this.aHalf = new Matrix<GF>(3, Arrays.asList(new GF[] {aHalf, zero,
				zero, zero, aHalf, zero, zero, zero, aHalf }));

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
	public void testTwoTimesAHalfEqualsOne() {

		assertEquals(one, two.multiply(aHalf));
		assertEquals(one, aHalf.multiply(two));
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
	public void testOnePlusOneEqualsTwo() {

		assertEquals(two, one.add(one));
	}

}
