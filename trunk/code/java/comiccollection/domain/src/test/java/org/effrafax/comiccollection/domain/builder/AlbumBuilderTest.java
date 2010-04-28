package org.effrafax.comiccollection.domain.builder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Test the {@link AlbumBuilder}.
 * 
 * @author dvberkel
 */
public class AlbumBuilderTest {

	/**
	 * Holds the {@link AlbumBuilder}.
	 */
	private AlbumBuilder albumBuilder;

	/**
	 * Creates the {@link AlbumBuilder} under tests.
	 */
	@Before
	public void createAlbumBuilder() {

		albumBuilder = new AlbumBuilder();
	}

	/**
	 * Part of the completeness test.
	 */
	@Test
	public void testBuilderIsNotCompleteWhenNameAndIndexAreNull() {

		assertFalse(albumBuilder.isComplete());
	}

	/**
	 * Part of the completeness test.
	 */
	@Test
	public void testBuilderIsNotCompleteWhenNameIsNull() {

		albumBuilder.setIndex(1);
		assertFalse(albumBuilder.isComplete());
	}

	/**
	 * Part of the completeness test.
	 */
	@Test
	public void testBuilderIsNotCompleteWhenNameIsEmpty() {

		albumBuilder.setName("");
		assertFalse(albumBuilder.isComplete());

		albumBuilder.setIndex(1);
		assertFalse(albumBuilder.isComplete());
	}

	/**
	 * Part of the completeness test.
	 */
	@Test
	public void testBuilderIsNotCompleteWhenIndexIsNull() {

		albumBuilder.setName("");
		assertFalse(albumBuilder.isComplete());

		albumBuilder.setName("a Name");
		assertFalse(albumBuilder.isComplete());
	}

	/**
	 * Part of the completeness test.
	 */
	@Test
	public void testBuilderIsCompleteWhenNameAndIndexAreNotNull() {

		albumBuilder.setIndex(1);
		albumBuilder.setName("a Name");
		assertTrue(albumBuilder.isComplete());
	}

	/**
	 * Test to see if the id get set.
	 */
	@Test
	public void testIdGetProperlySet() {

		Long expected = 1L;
		albumBuilder.setId(expected);
		assertEquals(expected, albumBuilder.getId());
	}

}
