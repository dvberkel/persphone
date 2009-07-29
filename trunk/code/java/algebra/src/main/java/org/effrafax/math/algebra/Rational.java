/**
 * 
 */
package org.effrafax.math.algebra;

import org.effrafax.math.algebra.implementations.AbstractField;
import org.effrafax.math.algebra.interfaces.Field;

/**
 * This class provides a Rational Field element.
 * 
 * @author Daan van Berkel
 */
public class Rational extends AbstractField<Rational> implements
		Field<Rational> {

	private final int numerator;
	private final int denominator;

	/**
	 * A utility class to determine the greatest common divisor of two integers.
	 * 
	 * @author Daan van Berkel
	 */
	public static class GCD {

		/**
		 * Determines the greatest common divisors of two integers using the
		 * euclidean algorithm. This algorithm is very efficient so no harm can
		 * come from using recursion.
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

			if (a == 0 && b == 0) {

				throw new IllegalArgumentException(
						"parameters should not both be zero.");
			}
			if (a == 0) {

				/* 0 * b = 0 so b divides a and is the greatest divisor of b. */
				return b;
			} else if (b == 0) {

				/* by a similar argument a is the greatest divisor of a and b. */
				return a;
			} else {

				/* otherwise use euclid. */
				return gcd(b, a % b);
			}
		}

	}

	/**
	 * Constructor for a {@code Rational} element.
	 * 
	 * @param numerator
	 *            The numerator of the {@code Rational element}.
	 * @param denominator
	 *            The denominator of the {@code Rational} element.
	 * @throws IllegalArgumentException
	 *             if the {@code denominator} is zero.
	 */
	public Rational(int numerator, int denominator)
			throws IllegalArgumentException {

		if (denominator == 0) {

			throw new IllegalArgumentException(
					"denominator should not be zero.");
		}

		int sign = numerator * denominator >= 0 ? 1 : -1;

		numerator = Math.abs(numerator);
		denominator = Math.abs(denominator);

		int gcd = GCD.gcd(numerator, denominator);

		this.numerator = sign * numerator / gcd;
		this.denominator = denominator / gcd;
	}

	/**
	 * Getter of the numerator.
	 * 
	 * @return the numerator of this {@code Rational}.
	 */
	public int getNumerator() {

		return numerator;
	}

	/**
	 * Getter of the denominator.
	 * 
	 * @return the denominator of this {@code Rational}.
	 */
	public int getDenominator() {

		return denominator;
	}

	/*
	 * (non-Javadoc)
	 * @see org.effrafax.math.polynomial.interfaces.Field#isZero()
	 */
	@Override
	public boolean isZero() {

		return numerator == 0;
	}

	/*
	 * (non-Javadoc)
	 * @see org.effrafax.math.polynomial.interfaces.Field#isOne()
	 */
	@Override
	public boolean isOne() {

		return numerator == denominator;
	}

	/**
	 * Determines if this {@code Rational} is an integer.
	 * 
	 * @return {@code true} if this {@code Rational} is an integer, {@code
	 *         false} otherwise.
	 */
	public boolean isInteger() {

		return denominator == 1;
	}

	/*
	 * (non-Javadoc)
	 * @see org.effrafax.math.polynomial.interfaces.Field#inverse()
	 */
	@Override
	public Rational inverse() {

		if (isZero()) {

			throw new IllegalStateException("zero has no inverse.");
		}

		return new Rational(denominator, numerator);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * org.effrafax.math.polynomial.interfaces.Field#multiply(org.effrafax.math
	 * .polynomial.interfaces.Field)
	 */
	@Override
	public Rational multiply(Rational that) {

		int n = this.numerator * that.numerator;
		int d = this.denominator * that.denominator;

		return new Rational(n, d);
	}

	/*
	 * (non-Javadoc)
	 * @see org.effrafax.math.polynomial.interfaces.Field#negative()
	 */
	@Override
	public Rational negative() {

		return new Rational(-numerator, denominator);
	}

	/*
	 * (non-Javadoc)
	 * @seeorg.effrafax.math.polynomial.interfaces.Field#add(org.effrafax.math.
	 * polynomial.interfaces.Field)
	 */
	@Override
	public Rational add(Rational that) {

		int n = this.numerator * that.denominator + this.denominator
				* that.numerator;
		int d = this.denominator * that.denominator;

		return new Rational(n, d);
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		if (isInteger()) {

			return numerator + "";
		} else {

			return numerator + "/" + denominator;
		}
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {

		final int prime = 37;
		int result = 1;

		result = prime * result + denominator;
		result = prime * result + numerator;

		return result;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {

		if (this == obj) {

			return true;
		}
		if (obj == null) {

			return false;
		}
		if (getClass() != obj.getClass()) {

			return false;
		}

		Rational that = (Rational) obj;
		if (this.getDenominator() != that.getDenominator()) {

			return false;
		}
		if (this.getNumerator() != that.getNumerator()) {
			return false;
		}

		return true;
	}

}