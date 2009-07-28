/**
 * 
 */
package org.effrafax.math.algebra.implementations;

import org.effrafax.math.algebra.interfaces.Ring;

/**
 * @author Daan van Berkel
 */
public abstract class AbstractRing<E extends Ring<E>> implements Ring<E> {

	/*
	 * (non-Javadoc)
	 * @see
	 * org.effrafax.math.algebra.interfaces.Ring#subtract(org.effrafax.math.
	 * algebra.interfaces.Ring)
	 */
	@Override
	public E subtract(E that) {

		return this.add(that.negative());
	}

}
