/**
 * 
 */
package org.effrafax.comiccollection.domain.factory.implementation;

import org.effrafax.comiccollection.domain.builder.AlbumBuilder;
import org.effrafax.comiccollection.domain.builder.ComicBuilder;
import org.effrafax.comiccollection.domain.builder.OmnibusBuilder;
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
	 * @return a {@link Album}.
	 */
	@Override
	public Album createAlbum(AlbumBuilder albumBuilder) {

		return new SimpleAlbum(albumBuilder);
	}

	/**
	 * Creates a {@link Comic}
	 * 
	 * @return a {@link Comic}.
	 */
	@Override
	public Comic createComic(ComicBuilder comicBuilder) {

		return new SimpleComic(comicBuilder);
	}

	/**
	 * Creates a {@link Omnibus}
	 * 
	 * @return a {@link Omnibus}.
	 */
	@Override
	public Omnibus createOmnibus(OmnibusBuilder omnibusBuilder) {

		return new SimpleOmnibus(omnibusBuilder);
	}
}
