/**
 * 
 */
package org.effrafax.comiccollection.domain.model.interfaces.implementation;

import org.effrafax.comiccollection.domain.model.interfaces.Indexable;
import org.effrafax.comiccollection.util.ArgumentChecker;

/**
 * @author dvberkel
 */
public class SimpleIndexable implements Indexable {

	/**
	 * This field will hold the index associated with this
	 * {@link SimpleIndexable}.
	 */
	private Integer index;

	/**
	 * The constructor for this {@link SimpleIndexable}.
	 * 
	 * @param index
	 *            the index associated with this {@link SimpleIndexable}
	 */
	public SimpleIndexable(Integer index) {

		setIndex(index);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.effrafax.comiccollection.domain.model.interfaces.Indexable#getIndex()
	 */
	@Override
	public Integer getIndex() {

		return index;
	}

	/**
	 * Sets the index associated with this {@link SimpleIndexable}.
	 * 
	 * @param index
	 *            the index for this {@link SimpleIndexable}.
	 * @throws IllegalArgumentException
	 *             if {@code index} is null.
	 */
	private void setIndex(Integer index) {

		ArgumentChecker.throwExceptionIfAnyArgumentIsNull(index);
		this.index = index;
	}
}
