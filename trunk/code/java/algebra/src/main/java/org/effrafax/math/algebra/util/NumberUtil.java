/**
 * 
 */
package org.effrafax.math.algebra.util;

/**
 * This class provides static utility methods for various number theoretic
 * calculations.
 * 
 * @author Daan van Berkel
 */
public class NumberUtil {

	/**
	 * Determines the greatest common divisors of two integers using the
	 * euclidean algorithm. This algorithm is very efficient so no harm can come
	 * from using recursion.
	 * 
	 * @param a
	 *            one of the integers to in the computation of the gcd.
	 * @param b
	 *            an other integer in the computation.
	 * @return the greatest common divisor of {@code a} and {@code b}
	 * @throws IllegalArgumentException
	 *             if both {@code a} and {@code b} are zero.
	 */
	public static int gcd(int a, int b) throws IllegalArgumentException {

		int[] result = egcd(a, b);

		return result[0];
	}

	/**
	 * Determines the greatest common divisors of two integers using the
	 * extended euclidean algorithm. This algorithm is very efficient so no harm
	 * can come from using recursion. Furthermore this algorithm produces
	 * integers s and t such that gcd(a,b) = s*a + t*b.
	 * 
	 * @param a
	 *            one of the integers to in the computation of the gcd.
	 * @param b
	 *            an other integer in the computation.
	 * @return an integer array [g,s,t] such that g is the greatest common
	 *         divisor of {@code a} and {@code b} and g = s {@code a} + t*
	 *         {@code b}.
	 * @throws IllegalArgumentException
	 *             if both {@code a} and {@code b} are zero.
	 */
	public static int[] egcd(int a, int b) throws IllegalArgumentException {

		if (a == 0 && b == 0) {

			throw new IllegalArgumentException(
					"parameters should not both be zero.");
		}

		/*
		 * The g variables will hold the remainders and the s and t variables
		 * will hold the coefficients such that gN = sN * a + tN * b.
		 */
		int g0 = a;
		int s0 = 1;
		int t0 = 0;
		int g1 = b;
		int s1 = 0;
		int t1 = 1;

		while (g1 != 0) {

			int remainder = g0 % g1;
			int quotient = g0 / g1;

			g0 = g1;
			g1 = remainder;

			int tmp = s0 - quotient * s1;
			s0 = s1;
			s1 = tmp;

			tmp = t0 - quotient * t1;
			t0 = t1;
			t1 = tmp;
		}

		return new int[] {g0, s0, t0 };
	}

	/**
	 * Determines if an {@code suspect} is prime or not. Currently this
	 * implementation is broken.
	 * 
	 * @param suspect
	 *            an integer to test for primality.
	 * @return {@code true} if the {@code suspect} is prime, {@code false}
	 *         otherwise.
	 */
	public static boolean isPrime(int suspect) {

		return suspect != 0 && suspect != 1;
	}

}
