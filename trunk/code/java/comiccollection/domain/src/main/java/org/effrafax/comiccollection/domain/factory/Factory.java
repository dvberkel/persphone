/**
 * 
 */
package org.effrafax.comiccollection.domain.factory;

import org.effrafax.comiccollection.domain.model.Album;
import org.effrafax.comiccollection.domain.model.Comic;
import org.effrafax.comiccollection.domain.model.Omnibus;
import org.effrafax.comiccollection.domain.model.implementation.SimpleAlbum;
import org.effrafax.comiccollection.domain.model.implementation.SimpleComic;
import org.effrafax.comiccollection.domain.model.implementation.SimpleOmnibus;

/**
 * This factor provides all the objects in our domain.
 * 
 * @author dvberkel
 */
public abstract class Factory {

	/**
	 * Creates a {@link Album}
	 * 
	 * @param index
	 *            the index of the {@link Album}.
	 * @param name
	 *            the name of the {@link Album}.
	 * @return a {@link Album}.
	 */
	public static Album createAlbum(Integer index, String name) {

		return new SimpleAlbum(index, name);
	}

	/**
	 * Creates a {@link Comic}
	 * 
	 * @param name
	 *            the name of the {@link Comic}.
	 * @return a {@link Comic}.
	 */
	public static Comic createComic(String name) {

		return new SimpleComic(name);
	}

	/**
	 * Creates a {@link Omnibus}
	 */
	public static Omnibus createOmnibus() {

		return new SimpleOmnibus();
	}
}
