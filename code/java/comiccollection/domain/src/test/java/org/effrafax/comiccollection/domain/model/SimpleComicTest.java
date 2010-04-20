/**
 * 
 */
package org.effrafax.comiccollection.domain.model;

import static org.junit.Assert.assertEquals;

import java.util.Collection;

import org.effrafax.comiccollection.domain.builder.AlbumBuilder;
import org.effrafax.comiccollection.domain.builder.ComicBuilder;
import org.effrafax.comiccollection.domain.model.implementation.SimpleAlbum;
import org.effrafax.comiccollection.domain.model.implementation.SimpleComic;
import org.effrafax.comiccollection.domain.model.interfaces.implementation.SimpleNameable;
import org.junit.Before;
import org.junit.Test;

/**
 * @author dvberkel
 */
public class SimpleComicTest {

	/**
	 * Expected name for this {@link SimpleComic}.
	 */
	private final String expectedComicName = "expected name";

	/**
	 * The {@link SimpleComic} under test.
	 */
	private Comic simpleComic;

	/**
	 * Create the {@link SimpleComic} under test.
	 */
	@Before
	public void createSimpleComic() {

		ComicBuilder builder = new ComicBuilder();
		builder.setName(expectedComicName);

		simpleComic = new SimpleComic(builder);
	}

	/**
	 * test if the construction of {@link SimpleComic} works as expected.
	 */
	@Test
	public void testSimpleNameableReturnsCorrectName() {

		assertEquals(expectedComicName, simpleComic.getName());
	}

	/**
	 * test if the construction of {@link SimpleNameable} fails if the argument
	 * is null.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testForConstructorFailureIfNameArgumentIsNull() {

		ComicBuilder builder = new ComicBuilder();
		builder.setName(null);
		new SimpleComic(builder);
	}

	/**
	 * test if {@code SimpleComic} returns the correct albums when a
	 * {@link Album} is added.
	 */
	@Test
	public void testAdditionOfAnAlbumRetunsCorrectAlbums() {

		AlbumBuilder builder = new AlbumBuilder();
		builder.setIndex(0);
		builder.setName("album name");
		Album album = new SimpleAlbum(builder);

		simpleComic.addAlbum(album);

		Collection<Album> albums = simpleComic.getAlbums();

		assertEquals(new Integer(1), new Integer(albums.size()));
		/* TODO make this test a little more elegant */
		for (Album otherAlbum : albums) {
			assertEquals(album, otherAlbum);
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructorWithNullArgumentThrowsException() {

		new SimpleComic(null);

	}

}
