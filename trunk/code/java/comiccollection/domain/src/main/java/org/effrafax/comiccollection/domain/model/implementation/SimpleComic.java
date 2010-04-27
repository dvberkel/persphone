/**
 * 
 */
package org.effrafax.comiccollection.domain.model.implementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.effrafax.comiccollection.domain.builder.ComicBuilder;
import org.effrafax.comiccollection.domain.model.Album;
import org.effrafax.comiccollection.domain.model.Comic;
import org.effrafax.comiccollection.domain.model.interfaces.Nameable;
import org.effrafax.comiccollection.domain.model.interfaces.implementation.ComicCollectionEntity;
import org.effrafax.comiccollection.domain.model.interfaces.implementation.SimpleNameable;
import org.effrafax.comiccollection.util.ArgumentChecker;

/**
 * @author dvberkel
 */
public class SimpleComic extends ComicCollectionEntity implements Comic {

	/** */
	private static final long serialVersionUID = 37L;

	/**
	 * The nameable delegate for this {@link SimpleComic}.
	 */
	private Nameable nameableDelegate;

	/**
	 * The collection of albums for this {@link SimpleAlbum}.
	 */
	private List<Album> albums;

	/**
	 * The constructor for this {@code SimpleAlbum}.
	 * 
	 * @param builder
	 *            the builder for this entity.
	 */
	public SimpleComic(ComicBuilder builder) {

		if (ArgumentChecker.isNull(builder)) {
			throw new IllegalArgumentException("builder should not be null");
		}

		setId(builder.getId());
		setNameableDelegate(new SimpleNameable(builder.getName()));
		setAlbums(new ArrayList<Album>());
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.effrafax.comiccollection.domain.model.Comic#addAlbum(org.effrafax.comiccollection.domain.model.Album)
	 */
	@Override
	public void addAlbum(Album album) {

		ArgumentChecker.throwExceptionIfAnyArgumentIsNull(album);
		getPrivateAlbums().add(album);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.effrafax.comiccollection.domain.model.Comic#getAlbums()
	 */
	@Override
	public List<Album> getAlbums() {

		return Collections.unmodifiableList(getPrivateAlbums());
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
	 * @return the nameableDelegate
	 */
	private Nameable getNameableDelegate() {

		return nameableDelegate;
	}

	/**
	 * @param nameableDelegate
	 *            the nameableDelegate to set
	 */
	private void setNameableDelegate(Nameable nameableDelegate) {

		ArgumentChecker.throwExceptionIfAnyArgumentIsNull(nameableDelegate);
		this.nameableDelegate = nameableDelegate;
	}

	/**
	 * @param albums
	 *            the albums to set
	 */
	private void setAlbums(List<Album> albums) {

		ArgumentChecker.throwExceptionIfAnyArgumentIsNull(albums);
		this.albums = albums;
	}

	/**
	 * A private getter for the albums. For internal use only!
	 * 
	 * @return the {@code albums} for this {@link SimpleComic}.
	 */
	private List<Album> getPrivateAlbums() {

		return albums;
	}

}
