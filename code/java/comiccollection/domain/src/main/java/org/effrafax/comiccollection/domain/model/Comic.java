/**
 * 
 */
package org.effrafax.comiccollection.domain.model;

import java.util.Collection;

import org.effrafax.comiccollection.domain.model.interfaces.Nameable;

/**
 * This class represants a comic series.
 * 
 * @author dvberkel
 */
public interface Comic extends Nameable {

	/**
	 * Adds an @{link Album} to this comic.
	 * 
	 * @param album
	 *            the {@link Album} added to this {@link Comic}.
	 */
	public void addAlbum(Album album);

	/**
	 * Returns the {@link Album}s collected in this {@code Comic}.
	 * 
	 * @return the {@link Album}s.
	 */
	public Collection<Album> getAlbums();
}
