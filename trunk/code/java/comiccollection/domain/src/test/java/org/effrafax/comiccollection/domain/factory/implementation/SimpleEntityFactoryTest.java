package org.effrafax.comiccollection.domain.factory.implementation;

import static org.junit.Assert.assertEquals;

import org.effrafax.comiccollection.domain.builder.ComicBuilder;
import org.effrafax.comiccollection.domain.factory.EntityFactory;
import org.effrafax.comiccollection.domain.model.Comic;
import org.junit.Before;
import org.junit.Test;

public class SimpleEntityFactoryTest {

	private EntityFactory entityFactory;

	@Before
	public void createSimpleEntityFactory() {

		entityFactory = new SimpleEntityFactory();
	}

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
