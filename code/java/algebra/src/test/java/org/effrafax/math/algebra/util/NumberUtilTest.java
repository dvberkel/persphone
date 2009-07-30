/**
 * 
 */
package org.effrafax.math.algebra.util;

import junit.framework.TestCase;

import org.junit.Test;

/**
 * @author Daan van Berkel
 */
public class NumberUtilTest extends TestCase {

	@Test
	public void testGCDFiveAndThreeIsOne() {

		assertEquals(1, NumberUtil.gcd(5, 3));
	}

	@Test
	public void testGCDFourAndTwoIsTwo() {

		assertEquals(2, NumberUtil.gcd(4, 2));
	}

	@Test
	public void testGCDSevenAndZeroIsSeven() {

		assertEquals(7, NumberUtil.gcd(7, 0));
		assertEquals(7, NumberUtil.gcd(0, 7));
	}

	@Test
	public void testGCDArgumentFailure() {

		try {

			NumberUtil.gcd(0, 0);
		} catch (Exception e) {

			/* This is the expected behavior */
			assertEquals(IllegalArgumentException.class, e.getClass());
		}
	}

	@Test
	public void testEGCDForSevenAndFive() {

		int[] result = NumberUtil.egcd(7, 5);

		assertEquals(result[0], result[1] * 7 + result[2] * 5);
	}
}
