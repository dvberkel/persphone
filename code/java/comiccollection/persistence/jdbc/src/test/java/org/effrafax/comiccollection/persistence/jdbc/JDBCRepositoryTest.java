/**
 * 
 */
package org.effrafax.comiccollection.persistence.jdbc;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.effrafax.comiccollection.domain.builder.AlbumBuilder;
import org.effrafax.comiccollection.domain.model.Album;
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
	 * Test is wrong input are signaled.
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
	public void testLoadAlbumReturnsCorrectAlbum() {

		AlbumBuilder builder = new AlbumBuilder();
		builder.setId(0L);
		builder.setIndex(1);
		builder.setName("a Name");

		JDBCService service = mock(JDBCService.class);
		when(service.loadAlbumBuilder(0L)).thenReturn(builder);

		repository.setJdbcService(service);

		Album album = repository.loadAlbum(0L);

		assertEquals(builder.getId(), album.getId());
		assertEquals(builder.getIndex(), album.getIndex());
		assertEquals(builder.getName(), album.getName());
	}
}
