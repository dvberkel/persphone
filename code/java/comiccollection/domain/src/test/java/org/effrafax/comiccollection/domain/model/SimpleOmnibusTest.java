/**
 * 
 */
package org.effrafax.comiccollection.domain.model;

import static org.junit.Assert.assertEquals;

import java.util.Collection;

import org.effrafax.comiccollection.domain.model.implementation.SimpleComic;
import org.effrafax.comiccollection.domain.model.implementation.SimpleOmnibus;
import org.junit.Before;
import org.junit.Test;

/**
 * @author dvberkel
 */
public class SimpleOmnibusTest {

	/**
	 * The {@link SimpleOmnibus} under test.
	 */
	private Omnibus simpleOmnibus;

	/**
	 * Create the {@link SimpleOmnibus} under test.
	 */
	@Before
	public void createSimpleOmnibus() {

		simpleOmnibus = new SimpleOmnibus();
	}

	/**
	 * test if {@code SimpleComic} returns the correct albums when a
	 * {@link Album} is added.
	 */
	@Test
	public void testAdditionOfAnComicRetunsCorrectComic() {

		Comic comic = new SimpleComic("expected Comic");

		simpleOmnibus.addComic(comic);

		Collection<Comic> comics = simpleOmnibus.getComics();

		assertEquals(new Integer(1), new Integer(comics.size()));
		/* TODO make this test a little more elegant */
		for (Comic otherComic : comics) {
			assertEquals(comic, otherComic);
		}
	}

}
