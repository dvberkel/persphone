/**
 * 
 */
package org.effrafax.math.algebra.implementations;

import org.effrafax.math.algebra.interfaces.Field;

/**
 * @author Daan van Berkel
 */
public abstract class AbstractField<E extends Field<E>> extends AbstractRing<E>
		implements Field<E> {

	/*
	 * (non-Javadoc)
	 * @see
	 * org.effrafax.math.algebra.interfaces.Field#divide(org.effrafax.math.algebra
	 * .interfaces.Field)
	 */
	@Override
	public E divide(E that) {

		return this.multiply(that.inverse());
	}

}
