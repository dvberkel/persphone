/**
 * 
 */
package org.effrafax.comiccollection.domain.builder;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * @author dvberkel
 */
public class OmnibusBuilderTest {

	/**
	 * Holds the {@link OmnibusBuilder}.
	 */
	private OmnibusBuilder omnibusBuilder;

	/**
	 * Creates the {@link OmnibusBuilder} under test.
	 */
	@Before
	public void creatOmnibusBuilder() {

		omnibusBuilder = new OmnibusBuilder();
	}

	/**
	 * Test to see if the Id is set.
	 */
	@Test
	public void testIfIdIsProperlySet() {

		Long expected = 1L;
		omnibusBuilder.setId(expected);
		assertEquals(expected, omnibusBuilder.getId());

	}
}
