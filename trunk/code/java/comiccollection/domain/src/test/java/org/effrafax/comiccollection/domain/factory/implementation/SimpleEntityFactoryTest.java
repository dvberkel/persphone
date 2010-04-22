package org.effrafax.comiccollection.domain.factory.implementation;

import static org.junit.Assert.assertEquals;

import org.effrafax.comiccollection.domain.builder.ComicBuilder;
import org.effrafax.comiccollection.domain.factory.EntityFactory;
import org.effrafax.comiccollection.domain.model.Comic;
import org.junit.Before;
import org.junit.Test;

/**
 * A test for {@link SimpleEntityFactory}.
 * 
 * @author dvberkel
 */
public class SimpleEntityFactoryTest {

	/**
	 * The {@link EntityFactory} used in this test.
	 */
	private EntityFactory entityFactory;

	/**
	 * This method will assign a {@link SimpleEntityFactory} to {@code
	 * entityFactory}.
	 */
	@Before
	public void createSimpleEntityFactory() {

		entityFactory = new SimpleEntityFactory();
	}

	/**
	 * Test to see if the factory works.
	 */
	@Test
	public void testComicBuilderWithIdBuildsComicWithId() {

		Long expectedID = 1L;

		ComicBuilder builder = new ComicBuilder();
		builder.setId(expectedID);
		builder.setName("not important");

		Comic comic = entityFactory.createComic(builder);

		assertEquals(expectedID, comic.getId());
	}
}
