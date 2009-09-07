/**
 * 
 */
package org.effrafax.math.algebra;

import org.effrafax.math.algebra.implementations.AbstractField;
import org.effrafax.math.algebra.interfaces.Field;
import org.effrafax.math.algebra.util.NumberUtil;

/**
 * This class provides an element of a finite field. Currently only fields of
 * prime order are supported.
 * 
 * @author Daan van Berkel
 */
public class GF extends AbstractField<GF> implements Field<GF> {

	private static final String DIFFERENT_FIELDS = "the arguments come frome different fields.";

	private final int residue;
	private final int modulus;

	/**
	 * Constructor for a finite field.
	 * 
	 * @param residue
	 *            the particular representative of the residue class.
	 * @param modulus
	 *            the order of the field. Should be a prime number.
	 * @throws IllegalArgumentException
	 *             if {@code modulus} is not a prime.
	 */
	public GF(int residue, int modulus) throws IllegalArgumentException {

		if (!NumberUtil.isPrime(modulus)) {

			throw new IllegalArgumentException("modulus is not a prime.");
		}

		this.residue = residue % modulus;
		this.modulus = modulus;
	}

	/*
	 * (non-Javadoc)
	 * @see org.effrafax.math.algebra.interfaces.Ring#getOne()
	 */
	@Override
	public GF getOne() {

		return new GF(1, modulus);
	}

	/*
	 * (non-Javadoc)
	 * @see org.effrafax.math.algebra.interfaces.Ring#getZero()
	 */
	@Override
	public GF getZero() {

		return new GF(0, modulus);
	}

	/**
	 * This method throws an exception if the element and {@code that} element
	 * do not have the same modulus.
	 * 
	 * @param that
	 *            the element under scrutiny.
	 * @throws IllegalArgumentException
	 */
	private void checkModuli(GF that) throws IllegalArgumentException {

		if (this.modulus != that.modulus) {

			throw new IllegalArgumentException(DIFFERENT_FIELDS);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see org.effrafax.math.algebra.interfaces.Field#inverse()
	 */
	@Override
	public GF inverse() {

		/* TODO use extended euclidean algorithm. */
		int guess = 1;
		while (guess < modulus) {

			if ((guess * residue) % modulus == 1) {

				break;
			}
			guess++;
		}

		return new GF(guess, modulus);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * org.effrafax.math.algebra.interfaces.Ring#add(org.effrafax.math.algebra
	 * .interfaces.Ring)
	 */
	@Override
	public GF add(GF that) {

		checkModuli(that);

		return new GF(this.residue + that.residue, this.modulus);
	}

	/*
	 * (non-Javadoc)
	 * @see org.effrafax.math.algebra.interfaces.Ring#isOne()
	 */
	@Override
	public boolean isOne() {

		return residue == 1;
	}

	/*
	 * (non-Javadoc)
	 * @see org.effrafax.math.algebra.interfaces.Ring#isZero()
	 */
	@Override
	public boolean isZero() {

		return residue == 0;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * org.effrafax.math.algebra.interfaces.Ring#multiply(org.effrafax.math.
	 * algebra.interfaces.Ring)
	 */
	@Override
	public GF multiply(GF that) {

		checkModuli(that);

		return new GF(this.residue * that.residue, this.modulus);
	}

	/*
	 * (non-Javadoc)
	 * @see org.effrafax.math.algebra.interfaces.Ring#negative()
	 */
	@Override
	public GF negative() {

		return new GF(modulus - residue, modulus);
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		return "" + residue;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {

		final int prime = 37;

		int result = 1;
		result = prime * result + modulus;
		result = prime * result + residue;

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

		GF other = (GF) obj;
		if (modulus != other.modulus) {

			return false;
		}
		if (residue != other.residue) {

			return false;
		}

		return true;
	}

}
