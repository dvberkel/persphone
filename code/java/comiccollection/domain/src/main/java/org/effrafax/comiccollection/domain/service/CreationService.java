/**
 * 
 */
package org.effrafax.comiccollection.domain.service;

import org.effrafax.comiccollection.domain.factory.FactoryProvider;
import org.effrafax.comiccollection.domain.factory.RepositoryFactory;
import org.effrafax.comiccollection.domain.model.Album;
import org.effrafax.comiccollection.domain.model.Comic;
import org.effrafax.comiccollection.domain.model.Omnibus;
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

		Omnibus omnibus = FactoryProvider.PROVIDER.getEntityFactory().createOmnibus();
		Repository repository = RepositoryFactory.getRepository();
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

		Repository repository = RepositoryFactory.getRepository();
		Omnibus omnibus = repository.loadOmnibus(omnibusId);
		omnibus.addComic(FactoryProvider.PROVIDER.getEntityFactory().createComic(name));
		repository.saveOmnibus(omnibus);
	}

	/**
	 * Adds an album to the {@link Comic} with {@code comicId} in
	 * {@link Omnibus} with {@code omnibusId}. The album gets created with
	 * {@code index} and {@code name}.
	 * 
	 * @param omnibusId
	 *            id of the {@link Omnibus}.
	 * @param comicId
	 *            id of the {@link Comic}.
	 * @param index
	 *            index of the {@link Album} created.
	 * @param name
	 *            name of the {@link Album} created.
	 */
	public static void addAlbum(Long omnibusId, Long comicId, Integer index, String name) {

		Repository repository = RepositoryFactory.getRepository();
		Omnibus omnibus = repository.loadOmnibus(omnibusId);
		Comic comic = null;
		for (Comic otherComic : omnibus.getComics()) {
			if (otherComic.getId().equals(comicId)) {
				comic = otherComic;
				break;
			}
		}
		comic.addAlbum(FactoryProvider.PROVIDER.getEntityFactory().createAlbum(index, name));
		repository.saveOmnibus(omnibus);
	}
}
