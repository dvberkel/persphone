package org.effrafax.comiccollection.domain.factory;

import org.effrafax.comiccollection.domain.builder.AlbumBuilder;
import org.effrafax.comiccollection.domain.builder.ComicBuilder;
import org.effrafax.comiccollection.domain.builder.OmnibusBuilder;
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
	 * @param albumBuilder
	 *            the {@link AlbumBuilder} for this {@link Album}.
	 * @return a {@link Album}.
	 */
	public Album createAlbum(AlbumBuilder albumBuilder);

	/**
	 * Creates a {@link Comic}
	 * 
	 * @param comicBuilder
	 *            the {@link ComicBuilder} for this {@link Comic}.
	 * @return a {@link Comic}.
	 */
	public Comic createComic(ComicBuilder comicBuilder);

	/**
	 * Creates a {@link Omnibus}
	 * 
	 * @param omnibusBuilder
	 *            the {@link OmnibusBuilder} for this {@link Omnibus}
	 * @return a {@link Omnibus}.
	 */
	public Omnibus createOmnibus(OmnibusBuilder omnibusBuilder);

}