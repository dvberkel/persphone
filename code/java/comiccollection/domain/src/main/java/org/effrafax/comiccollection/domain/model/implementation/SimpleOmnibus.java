/**
 * 
 */
package org.effrafax.comiccollection.domain.model.implementation;

import java.util.ArrayList;
import java.util.Collection;

import org.effrafax.comiccollection.domain.builder.OmnibusBuilder;
import org.effrafax.comiccollection.domain.model.Comic;
import org.effrafax.comiccollection.domain.model.Omnibus;
import org.effrafax.comiccollection.domain.model.interfaces.implementation.ComicCollectionEntity;
import org.effrafax.comiccollection.util.ArgumentChecker;
import org.effrafax.comiccollection.util.Copier;

/**
 * @author dvberkel
 */
public class SimpleOmnibus extends ComicCollectionEntity implements Omnibus {

	/**
	 * A collection to hold the {@link Comic}s associated with this
	 * {@link Omnibus}.
	 */
	private Collection<Comic> comics;

	/**
	 * The constructor for this {@link Omnibus}.
	 * 
	 * @param builder
	 *            the builder for this entity.
	 */
	public SimpleOmnibus(OmnibusBuilder builder) {

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
	public Collection<Comic> getComics() {

		return Copier.aCopyOf(getPrivateComics());
	}

	/**
	 * @param comics
	 *            the comics to set
	 */
	private void setComics(Collection<Comic> comics) {

		ArgumentChecker.throwExceptionIfAnyArgumentIsNull(comics);
		this.comics = comics;
	}

	/**
	 * Returns {@code comics}. This is for internal use only.
	 * 
	 * @return returns {@code comics}.
	 */
	private Collection<Comic> getPrivateComics() {

		return comics;
	}

}
