/**
 * 
 */
package org.effrafax.comiccollection.domain.model.implementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.effrafax.comiccollection.domain.builder.OmnibusBuilder;
import org.effrafax.comiccollection.domain.model.Comic;
import org.effrafax.comiccollection.domain.model.Omnibus;
import org.effrafax.comiccollection.domain.model.interfaces.implementation.ComicCollectionEntity;
import org.effrafax.comiccollection.util.ArgumentChecker;

/**
 * @author dvberkel
 */
public class SimpleOmnibus extends ComicCollectionEntity implements Omnibus {

	/** */
	private static final long serialVersionUID = 37L;

	/**
	 * A collection to hold the {@link Comic}s associated with this
	 * {@link Omnibus}.
	 */
	private List<Comic> comics;

	/**
	 * The constructor for this {@link Omnibus}.
	 * 
	 * @param builder
	 *            the builder for this entity.
	 */
	public SimpleOmnibus(OmnibusBuilder builder) {

		if (ArgumentChecker.isNull(builder)) {
			throw new IllegalArgumentException("builder should not be null");
		}

		setId(builder.getId());
		setComics(new ArrayList<Comic>());
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.effrafax.comiccollection.domain.model.Omnibus#addComic(org.effrafax.comiccollection.domain.model.Comic)
	 */
	@Override
	public void addComic(Comic comic) {

		getPrivateComics().add(comic);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.effrafax.comiccollection.domain.model.Omnibus#getComics()
	 */
	@Override
	public List<Comic> getComics() {

		return Collections.unmodifiableList(getPrivateComics());
	}

	/**
	 * @param comics
	 *            the comics to set
	 */
	private void setComics(List<Comic> comics) {

		ArgumentChecker.throwExceptionIfAnyArgumentIsNull(comics);
		this.comics = comics;
	}

	/**
	 * Returns {@code comics}. This is for internal use only.
	 * 
	 * @return returns {@code comics}.
	 */
	private List<Comic> getPrivateComics() {

		return comics;
	}

}
