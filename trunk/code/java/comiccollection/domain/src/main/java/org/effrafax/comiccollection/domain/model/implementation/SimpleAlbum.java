/**
 * 
 */
package org.effrafax.comiccollection.domain.model.implementation;

import org.effrafax.comiccollection.domain.model.Album;
import org.effrafax.comiccollection.domain.model.interfaces.Indexable;
import org.effrafax.comiccollection.domain.model.interfaces.Nameable;
import org.effrafax.comiccollection.domain.model.interfaces.implementation.SimpleIndexable;
import org.effrafax.comiccollection.domain.model.interfaces.implementation.SimpleNameable;
import org.effrafax.comiccollection.util.ArgumentChecker;

/**
 * @author dvberkel
 */
public class SimpleAlbum implements Album {

	/**
	 * Delegate for the {@link Indexable} interface.
	 */
	private Indexable indexableDelegate;

	/**
	 * Delegate for the {@link Nameable} interface.
	 */
	private Nameable nameableDelegate;

	/**
	 * Constructor for this {@link SimpleAlbum}
	 * 
	 * @param index
	 *            the index of this {@link SimpleAlbum}.
	 * @param name
	 *            the name of this {@link SimpleAlbum}.
	 */
	public SimpleAlbum(Integer index, String name) {

		setIndexableDelegate(new SimpleIndexable(index));
		setNameableDelegate(new SimpleNameable(name));
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.effrafax.comiccollection.domain.model.interfaces.Nameable#getName()
	 */
	@Override
	public String getName() {

		return getNameableDelegate().getName();
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.effrafax.comiccollection.domain.model.interfaces.Indexable#getIndex()
	 */
	@Override
	public Integer getIndex() {

		return getIndexableDelegate().getIndex();
	}

	/**
	 * Getter for the {@link Nameable} delegate.
	 * 
	 * @return the {@link Nameable} delegate.
	 */
	private Nameable getNameableDelegate() {

		return nameableDelegate;
	}

	/**
	 * Setter for the {@link Nameable} delegate.
	 * 
	 * @param nameableDelegate
	 *            a {@link Nameable} delegate.
	 * @throws IllegalArgumentException
	 *             if {@code nameableDelegate} is null.
	 */
	private void setNameableDelegate(Nameable nameableDelegate) {

		ArgumentChecker.throwExceptionIfAnyArgumentIsNull(nameableDelegate);
		this.nameableDelegate = nameableDelegate;
	}

	/**
	 * Getter for the {@link Indexable} delegate.
	 * 
	 * @return the {@link Indexable} delegate.
	 */
	private Indexable getIndexableDelegate() {

		return indexableDelegate;
	}

	/**
	 * Setter for the {@link Indexable} delegate.
	 * 
	 * @param indexableDelegate
	 *            a {@link Indexable} delegate.
	 * @throws IllegalArgumentException
	 *             if {@code indexableDelegate} is null.
	 */
	private void setIndexableDelegate(Indexable indexableDelegate) {

		ArgumentChecker.throwExceptionIfAnyArgumentIsNull(indexableDelegate);
		this.indexableDelegate = indexableDelegate;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {

		final int prime = 37;
		int result = 1;
		result = prime * result + (getIndex().hashCode());
		result = prime * result + (getName().hashCode());
		return result;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object object) {

		if (this == object) return true;
		if (object == null) return false;
		if (!(object instanceof Album)) return false;
		Album other = (Album) object;
		if (other.getIndex() == null || !other.getIndex().equals(getIndex())) return false;
		if (other.getName() == null || !other.getName().equals(getName())) return false;
		return true;
	}
}
