/**
 * 
 */
package org.effrafax.math.algebra.interfaces;

/**
 * This interface provides a means to define an element of a ring.
 * 
 * @author Daan van Berkel
 */
public interface Ring<E extends Ring<E>> {

	/**
	 * Determines if this element is zero in the ring.
	 * 
	 * @return {@code true} if this element is zero, {@code false} otherwise
	 */
	public boolean isZero();

	/**
	 * Determines if this element is one in the ring.
	 * 
	 * @return {@code true} if this element is zero, {@code false} otherwise
	 */
	public boolean isOne();

	/**
	 * Returns the additive inverse of this element in the ring.
	 * 
	 * @return The additive inverse of this element.
	 */
	public E negative();

	/**
	 * Returns the sum of this element with {@code that} element in the ring.
	 * 
	 * @param that
	 *            The element in the ring for which the sum is formed.
	 * @return The sum of this element and that element.
	 */
	public E add(E that);

	/**
	 * Returns the subtraction of this element with {@code that} element in the
	 * ring.
	 * 
	 * @param that
	 *            The element which will be subtracted from this element.
	 * @return The subtraction of this element with {@code that} element.
	 */
	public E subtract(E that);

	/**
	 * The product of this element with {@code that} element in the ring.
	 * 
	 * @param that
	 *            The element which will be used in to form the product with
	 *            this element.
	 * @return The product of this element with that element.
	 */
	public E multiply(E that);

}
