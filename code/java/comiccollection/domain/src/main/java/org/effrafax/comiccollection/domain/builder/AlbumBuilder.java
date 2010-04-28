/**
 * 
 */
package org.effrafax.comiccollection.domain.builder;

import org.effrafax.comiccollection.domain.model.interfaces.Identifiable;
import org.effrafax.comiccollection.domain.model.interfaces.Indexable;
import org.effrafax.comiccollection.domain.model.interfaces.Nameable;
import org.effrafax.comiccollection.util.ArgumentChecker;

/**
 * @author dvberkel
 */
public class AlbumBuilder implements Indexable, Identifiable, Nameable {

	/** */
	private static final long serialVersionUID = 37L;

	/**
	 * Reference to the id
	 */
	private Long id;
	/**
	 * Reference to the index
	 */
	private Integer index;
	/**
	 * reference to the name.
	 */
	private String name;

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
	 * Setter for index
	 * 
	 * @param index
	 *            the index set.
	 */
	public void setIndex(Integer index) {

		this.index = index;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.effrafax.comiccollection.domain.model.interfaces.Identifiable#getId()
	 */
	@Override
	public Long getId() {

		return id;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.effrafax.comiccollection.domain.model.interfaces.Identifiable#setId
	 *      (java.lang.Long)
	 */
	@Override
	public void setId(Long id) {

		this.id = id;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.effrafax.comiccollection.domain.model.interfaces.Nameable#getName()
	 */
	@Override
	public String getName() {

		return name;
	}

	/**
	 * Setter for name.
	 * 
	 * @param name
	 *            the name set.
	 */
	public void setName(String name) {

		this.name = name;
	}

	/**
	 * Determines if this builder is complete.
	 * 
	 * @return {@true} if {@code name} and {@code index} are set.
	 */
	public boolean isComplete() {

		return !ArgumentChecker.isNull(getName()) && !getName().isEmpty() && !ArgumentChecker.isNull(getIndex());
	}
}
