package org.effrafax.comiccollection.domain.repository.implementation;

import static org.junit.Assert.assertEquals;

import org.effrafax.comiccollection.domain.builder.AlbumBuilder;
import org.effrafax.comiccollection.domain.builder.ComicBuilder;
import org.effrafax.comiccollection.domain.builder.OmnibusBuilder;
import org.effrafax.comiccollection.domain.model.Album;
import org.effrafax.comiccollection.domain.model.Comic;
import org.effrafax.comiccollection.domain.model.Omnibus;
import org.effrafax.comiccollection.domain.provider.Provider;
import org.effrafax.comiccollection.domain.repository.Repository;
import org.junit.Before;
import org.junit.Test;

/**
 * This is a test for {@link InMemoryRepository}.
 * 
 * @author dvberkel
 */
public class InMemoryRepositoryTest {

	/**
	 * The {@link Repository} under test.
	 */
	private Repository inMemoryRepository;

	/**
	 * Creates the {@link Repository} under test.
	 */
	@Before
	public void createInMemoryRepository() {

		inMemoryRepository = new InMemoryRepository();
	}

	/**
	 * Tests if an {@link Album} can be saved and loaded.
	 */
	@Test
	public void testAlbumCanBeSavedAndLoaded() {

		AlbumBuilder albumBuilder = new AlbumBuilder();
		albumBuilder.setName("album name");
		albumBuilder.setIndex(0);

		Album album = Provider.PROVIDER.getEntityFactory().createAlbum(albumBuilder);
		Long id = inMemoryRepository.saveAlbum(album);
		Album otherAlbum = inMemoryRepository.loadAlbum(id);

		assertEquals(album, otherAlbum);

	}

	/**
	 * Tests if an {@link Comic} can be saved and loaded.
	 */
	@Test
	public void testComicCanBeSavedAndLoaded() {

		ComicBuilder comicBuilder = new ComicBuilder();
		comicBuilder.setName("comic name");

		Comic comic = Provider.PROVIDER.getEntityFactory().createComic(comicBuilder);
		Long id = inMemoryRepository.saveComic(comic);
		Comic otherComic = inMemoryRepository.loadComic(id);

		assertEquals(comic, otherComic);

	}

	/**
	 * Tests if an {@link Omnibus} can be saved and loaded.
	 */
	@Test
	public void testOmnibusCanBeSavedAndLoaded() {

		Omnibus omnibus = Provider.PROVIDER.getEntityFactory().createOmnibus(new OmnibusBuilder());
		Long id = inMemoryRepository.saveOmnibus(omnibus);
		Omnibus otherOmnibus = inMemoryRepository.loadOmnibus(id);

		assertEquals(omnibus, otherOmnibus);

	}
}
