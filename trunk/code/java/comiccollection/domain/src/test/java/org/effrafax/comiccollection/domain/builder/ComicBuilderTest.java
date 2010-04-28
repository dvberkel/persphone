/**
 * 
 */
package org.effrafax.comiccollection.domain.builder;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * @author dvberkel
 */
public class ComicBuilderTest {

	/**
	 * Holds the {@link ComicBuilder} under test.
	 */
	private ComicBuilder comicBuilder;

	/**
	 * Creates the {@link ComicBuilder} under test.
	 */
	@Before
	public void createComicBuilder() {

		comicBuilder = new ComicBuilder();
	}

	/**
	 * Part of the completeness test.
	 */
	@Test
	public void testComicBuilderIsNotCompleteWhenNameIsNull() {

		assertFalse(comicBuilder.isComplete());
	}

	/**
	 * Part of the completeness test.
	 */
	@Test
	public void testComicBuilderIsNotCompleteWhenNameIsEmpty() {

		comicBuilder.setName("");
		assertFalse(comicBuilder.isComplete());
	}

	/**
	 * Part of the completeness test.
	 */
	@Test
	public void testComicBuilderNotCompleteWhenNameIsNotEmpty() {

		comicBuilder.setName("a Name");
		assertTrue(comicBuilder.isComplete());
	}
}
