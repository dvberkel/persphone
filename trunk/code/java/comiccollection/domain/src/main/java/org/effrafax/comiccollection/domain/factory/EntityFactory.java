package org.effrafax.comiccollection.domain.factory;

import org.effrafax.comiccollection.domain.model.Album;
import org.effrafax.comiccollection.domain.model.Comic;
import org.effrafax.comiccollection.domain.model.Omnibus;

/**
 * This interface exposes the means to create various entities.
 * 
 * @author dvberkel
 */
public interface EntityFactory {

	/**
	 * Creates a {@link Album}
	 * 
	 * @param index
	 *            the index of the {@link Album}.
	 * @param name
	 *            the name of the {@link Album}.
	 * @return a {@link Album}.
	 */
	public Album createAlbum(Integer index, String name);

	/**
	 * Creates a {@link Comic}
	 * 
	 * @param name
	 *            the name of the {@link Comic}.
	 * @return a {@link Comic}.
	 */
	public Comic createComic(String name);

	/**
	 * Creates a {@link Omnibus}
	 * 
	 * @return a {@link Omnibus}.
	 */
	public Omnibus createOmnibus();

}