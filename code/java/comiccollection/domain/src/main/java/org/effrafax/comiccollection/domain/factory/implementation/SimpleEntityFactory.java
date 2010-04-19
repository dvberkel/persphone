/**
 * 
 */
package org.effrafax.comiccollection.domain.factory.implementation;

import org.effrafax.comiccollection.domain.builder.AlbumBuilder;
import org.effrafax.comiccollection.domain.factory.EntityFactory;
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
public class SimpleEntityFactory implements EntityFactory {

	/**
	 * Creates a {@link Album}
	 * 
	 * @param index
	 *            the index of the {@link Album}.
	 * @param name
	 *            the name of the {@link Album}.
	 * @return a {@link Album}.
	 */
	@Override
	public Album createAlbum(Integer index, String name) {

		AlbumBuilder builder = new AlbumBuilder();
		builder.setIndex(index);
		builder.setName(name);
		return new SimpleAlbum(builder);
	}

	/**
	 * Creates a {@link Comic}
	 * 
	 * @param name
	 *            the name of the {@link Comic}.
	 * @return a {@link Comic}.
	 */
	@Override
	public Comic createComic(String name) {

		return new SimpleComic(name);
	}

	/**
	 * Creates a {@link Omnibus}
	 * 
	 * @return a {@link Omnibus}.
	 */
	@Override
	public Omnibus createOmnibus() {

		return new SimpleOmnibus();
	}
}
