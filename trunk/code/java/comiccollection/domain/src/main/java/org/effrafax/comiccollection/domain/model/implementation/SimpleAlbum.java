/**
 * 
 */
package org.effrafax.comiccollection.domain.model.implementation;

import org.effrafax.comiccollection.domain.builder.AlbumBuilder;
import org.effrafax.comiccollection.domain.model.Album;
import org.effrafax.comiccollection.domain.model.interfaces.Indexable;
import org.effrafax.comiccollection.domain.model.interfaces.Nameable;
import org.effrafax.comiccollection.domain.model.interfaces.implementation.ComicCollectionEntity;
import org.effrafax.comiccollection.domain.model.interfaces.implementation.SimpleIndexable;
import org.effrafax.comiccollection.domain.model.interfaces.implementation.SimpleNameable;
import org.effrafax.comiccollection.util.ArgumentChecker;

/**
 * @author dvberkel
 */
public class SimpleAlbum extends ComicCollectionEntity implements Album {

	/** */
	private static final long serialVersionUID = 37L;

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
	 * @param builder
	 *            the builder for this entity.
	 */
	public SimpleAlbum(AlbumBuilder builder) {

		if (ArgumentChecker.isNull(builder)) {
			throw new IllegalArgumentException("builder should not be null");
		}

		setIndexableDelegate(new SimpleIndexable(builder.getIndex()));
		setNameableDelegate(new SimpleNameable(builder.getName()));
		setId(builder.getId());
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
