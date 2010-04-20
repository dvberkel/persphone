/**
 * 
 */
package org.effrafax.comiccollection.domain.service;

import org.effrafax.comiccollection.domain.builder.AlbumBuilder;
import org.effrafax.comiccollection.domain.builder.ComicBuilder;
import org.effrafax.comiccollection.domain.builder.OmnibusBuilder;
import org.effrafax.comiccollection.domain.model.Album;
import org.effrafax.comiccollection.domain.model.Comic;
import org.effrafax.comiccollection.domain.model.Omnibus;
import org.effrafax.comiccollection.domain.provider.Provider;
import org.effrafax.comiccollection.domain.repository.Repository;

/**
 * @author dvberkel
 */
public class CreationService {

	/**
	 * Creates an omnibus and registers it with the repository.
	 * 
	 * @return an Omnibus.
	 */
	public static Omnibus createOmnibus() {

		Omnibus omnibus = Provider.PROVIDER.getEntityFactory().createOmnibus(new OmnibusBuilder());
		Repository repository = Provider.PROVIDER.getRepository();
		repository.saveOmnibus(omnibus);
		return omnibus;
	}

	/**
	 * Adds a {@link Comic} with {@code name} to the {@link Omnibus} with
	 * {@code omnibusId}.
	 * 
	 * @param omnibusId
	 *            the id of the {@link Omnibus}.
	 * @param name
	 *            the name of the {@link Comic} to add.
	 */
	public static void addComic(Long omnibusId, String name) {

		ComicBuilder builder = new ComicBuilder();
		builder.setName(name);

		Repository repository = Provider.PROVIDER.getRepository();
		Omnibus omnibus = repository.loadOmnibus(omnibusId);
		omnibus.addComic(Provider.PROVIDER.getEntityFactory().createComic(builder));
		repository.saveOmnibus(omnibus);
	}

	/**
	 * Adds an album to the {@link Comic} with {@code comicId} in
	 * {@link Omnibus} with {@code omnibusId}. The album gets created with
	 * {@code index} and {@code name}.
	 * @param comicId
	 *            id of the {@link Comic}.
	 * @param index
	 *            index of the {@link Album} created.
	 * @param name
	 *            name of the {@link Album} created.
	 */
	public static void addAlbum(Long comicId, Integer index, String name) {

		AlbumBuilder builder = new AlbumBuilder();
		builder.setIndex(index);
		builder.setName(name);

		Repository repository = Provider.PROVIDER.getRepository();
		Comic comic = repository.loadComic(comicId);
		comic.addAlbum(Provider.PROVIDER.getEntityFactory().createAlbum(builder));
		repository.saveComic(comic);
	}
}
