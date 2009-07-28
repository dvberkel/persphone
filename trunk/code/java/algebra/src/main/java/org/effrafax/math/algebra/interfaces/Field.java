/**
 * 
 */
package org.effrafax.math.algebra.interfaces;

/**
 * This interface provides a means to define an element of a field. A field is a
 * ring in which any nonzero element has multiplicative inverse.
 * 
 * @author articles
 */
public interface Field<E extends Field<E>> extends Ring<E> {

	/**
	 * Returns the multiplicative inverse of this element in the field. This
	 * method should only be called on nonzero elements. That is only if {@code
	 * ! this.isZero()} is {@code true};
	 * 
	 * @return The multiplicative inverse of this element.
	 */
	public E inverse();

	/**
	 * Returns the division of this element with that element. This method
	 * should only be called with elements which are nonzero. That is, only if
	 * {@code ! that.isZero} is {@code true}.
	 * 
	 * @param that
	 *            The element which will divide this element.
	 * @return the division of this element with {@code that} element.
	 */
	public E divide(E that);

}
