/**
 * 
 */
package org.effrafax.comiccollection.domain.repository;

import java.util.Collection;

import org.effrafax.comiccollection.domain.model.Album;
import org.effrafax.comiccollection.domain.model.Comic;
import org.effrafax.comiccollection.domain.model.Omnibus;

/**
 * Repository for objects in this domain.
 * 
 * @author dvberkel
 */
public interface Repository {

	/**
	 * Saves a {@link Omnibus}.
	 * 
	 * @param omnibus
	 *            the {@link Omnibus} saved.
	 * @return the id of {@code omnibus}.
	 */
	public Long saveOmnibus(Omnibus omnibus);

	/**
	 * Loads a {@link Omnibus}.
	 * 
	 * @param id
	 *            the id of the loaded object
	 * @return the object with {@code id}.
	 */
	public Omnibus loadOmnibus(Long id);

	/**
	 * Returns all the {@link Omnibus}ses known to the {@link Repository}.
	 * 
	 * @return all {@link Omnibus}ses.
	 */
	public Collection<Omnibus> loadAllOmnibusses();

	/**
	 * Saves a {@link Comic}.
	 * 
	 * @param comic
	 *            the {@link Comic} saved.
	 * @return the id of {@code comic}.
	 */
	public Long saveComic(Comic comic);

	/**
	 * Loads a {@link Comic}.
	 * 
	 * @param id
	 *            the id of the loaded object
	 * @return the object with {@code id}.
	 */
	public Comic loadComic(Long id);

	/**
	 * Saves an {@link Album}.
	 * 
	 * @param album
	 *            the {@link Album} saved.
	 * @return the id of {@code album}.
	 */
	public Long saveAlbum(Album album);

	/**
	 * Loads a {@link Album}.
	 * 
	 * @param id
	 *            the id of the loaded object
	 * @return the object with {@code id}.
	 */
	public Album loadAlbum(Long id);
}
