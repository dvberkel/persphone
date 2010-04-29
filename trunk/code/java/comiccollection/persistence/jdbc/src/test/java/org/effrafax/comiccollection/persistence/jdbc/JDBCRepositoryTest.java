/**
 * 
 */
package org.effrafax.comiccollection.persistence.jdbc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.effrafax.comiccollection.domain.builder.AlbumBuilder;
import org.effrafax.comiccollection.domain.builder.ComicBuilder;
import org.effrafax.comiccollection.domain.builder.OmnibusBuilder;
import org.effrafax.comiccollection.domain.model.Album;
import org.effrafax.comiccollection.domain.model.Comic;
import org.effrafax.comiccollection.domain.model.Omnibus;
import org.effrafax.comiccollection.persistence.jdbc.service.JDBCService;
import org.junit.Before;
import org.junit.Test;

/**
 * @author dvberkel
 */
public class JDBCRepositoryTest {

	/**
	 * The repository for this test.
	 */
	private JDBCRepository repository;

	/**
	 * Creates a {@link JDBCRepository}.
	 */
	@Before
	public void createJDBCRepository() {

		repository = new JDBCRepository();
	}

	/**
	 * Test if wrong input are signaled.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testSettingJDBCServiceWithNullThrowsException() {

		JDBCRepository repository = new JDBCRepository();
		repository.setJdbcService(null);
	}

	/**
	 * Test to see if a album is correctly returned.
	 */
	@Test
	public void testLoadAlbumWithNonExistingIDReturnsNull() {

		JDBCService service = mock(JDBCService.class);
		when(service.loadAlbumBuilder(0L)).thenReturn(null);

		repository.setJdbcService(service);

		assertNull(repository.loadAlbum(0L));
	}

	/**
	 * Test to see if a album is correctly returned.
	 */
	@Test
	public void testLoadComicWithNonExistingIDReturnsNull() {

		JDBCService service = mock(JDBCService.class);
		when(service.loadComicBuilder(0L)).thenReturn(null);

		repository.setJdbcService(service);

		assertNull(repository.loadComic(0L));
	}

	/**
	 * Test to see if a album is correctly returned.
	 */
	@Test
	public void testLoadOmnibusWithNonExistingIDReturnsNull() {

		JDBCService service = mock(JDBCService.class);
		when(service.loadOmnibusBuilder(0L)).thenReturn(null);

		repository.setJdbcService(service);

		assertNull(repository.loadOmnibus(0L));
	}

	/**
	 * Test to see if a album is correctly returned.
	 */
	@Test
	public void testLoadOmnibusReturnsCorrectOmnibus() {

		AlbumBuilder albumBuilder = new AlbumBuilder();
		albumBuilder.setId(0L);
		albumBuilder.setIndex(1);
		albumBuilder.setName("a Name");

		ComicBuilder comicBuilder = new ComicBuilder();
		comicBuilder.setId(0L);
		comicBuilder.setName("an other Name");

		OmnibusBuilder omnibusBuilder = new OmnibusBuilder();
		omnibusBuilder.setId(0L);

		JDBCService service = mock(JDBCService.class);
		when(service.loadAlbumBuilder(0L)).thenReturn(albumBuilder);
		when(service.loadComicBuilder(0L)).thenReturn(comicBuilder);
		when(service.loadOmnibusBuilder(0L)).thenReturn(omnibusBuilder);
		when(service.getContainedComicIDs(0L)).thenReturn(Arrays.asList(new Long[] {0L }));
		when(service.getContainedAlbumIDs(0L)).thenReturn(Arrays.asList(new Long[] {0L }));

		repository.setJdbcService(service);

		Omnibus omnibus = repository.loadOmnibus(0L);
		assertEquals(omnibusBuilder.getId(), omnibus.getId());

		List<Comic> comics = omnibus.getComics();
		assertTrue(1 == comics.size());

		Comic comic = comics.get(0);
		assertEquals(comicBuilder.getId(), comic.getId());
		assertEquals(comicBuilder.getName(), comic.getName());

		List<Album> albums = comic.getAlbums();
		assertTrue(1 == albums.size());

		Album album = albums.get(0);
		assertEquals(albumBuilder.getId(), album.getId());
		assertEquals(albumBuilder.getIndex(), album.getIndex());
		assertEquals(albumBuilder.getName(), album.getName());
	}

	/**
	 * Part of loading test
	 */
	@Test
	public void testLoadAllOmnibusses() {

		OmnibusBuilder omnibusBuilder = new OmnibusBuilder();
		omnibusBuilder.setId(0L);

		JDBCService service = mock(JDBCService.class);
		when(service.loadAllOmnibusBuilders()).thenReturn(Arrays.asList(new OmnibusBuilder[] {omnibusBuilder }));

		repository.setJdbcService(service);

		Collection<Omnibus> omnibusses = repository.loadAllOmnibusses();
		assertTrue(1 == omnibusses.size());

	}

	/**
	 * Part of saving test
	 */
	@Test
	public void testSaveAlbum() {

		JDBCService service = mock(JDBCService.class);

		repository.setJdbcService(service);

		repository.saveAlbum(null);

		verify(service).saveOrUpdateAlbum(null);
	}

	/**
	 * Part of saving test
	 */
	@Test
	public void testSaveComic() {

		JDBCService service = mock(JDBCService.class);

		repository.setJdbcService(service);

		repository.saveComic(null);

		verify(service).saveOrUpdateComic(null);
	}

	/**
	 * Part of saving test
	 */
	@Test
	public void testSaveOmnibus() {

		JDBCService service = mock(JDBCService.class);

		repository.setJdbcService(service);

		repository.saveOmnibus(null);

		verify(service).saveOrUpdateOmnibus(null);
	}
}
