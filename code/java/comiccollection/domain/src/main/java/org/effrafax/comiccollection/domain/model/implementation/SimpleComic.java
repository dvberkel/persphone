/**
 * 
 */
package org.effrafax.comiccollection.domain.model.implementation;

import java.util.ArrayList;
import java.util.Collection;

import org.effrafax.comiccollection.domain.model.Album;
import org.effrafax.comiccollection.domain.model.Comic;
import org.effrafax.comiccollection.domain.model.interfaces.Nameable;
import org.effrafax.comiccollection.domain.model.interfaces.implementation.ComicCollectionEntity;
import org.effrafax.comiccollection.domain.model.interfaces.implementation.SimpleNameable;
import org.effrafax.comiccollection.util.ArgumentChecker;
import org.effrafax.comiccollection.util.Copier;

/**
 * @author dvberkel
 */
public class SimpleComic extends ComicCollectionEntity implements Comic {

	/**
	 * The nameable delegate for this {@link SimpleComic}.
	 */
	private Nameable nameableDelegate;

	/**
	 * The collection of albums for this {@link SimpleAlbum}.
	 */
	private Collection<Album> albums;

	/**
	 * The constructor for this {@code SimpleAlbum}.
	 * 
	 * @param name
	 *            the name associated with this album.
	 */
	public SimpleComic(String name) {

		setNameableDelegate(new SimpleNameable(name));
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
	public Collection<Album> getAlbums() {

		return Copier.aCopyOf(getPrivateAlbums());
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
	private void setAlbums(Collection<Album> albums) {

		ArgumentChecker.throwExceptionIfAnyArgumentIsNull(albums);
		this.albums = albums;
	}

	/**
	 * A private getter for the albums. For internal use only!
	 * 
	 * @return the {@code albums} for this {@link SimpleComic}.
	 */
	private Collection<Album> getPrivateAlbums() {

		return albums;
	}

}
