/**
 * 
 */
package org.effrafax.comiccollection.domain.model;

import static org.junit.Assert.assertEquals;

import org.effrafax.comiccollection.domain.model.implementation.SimpleAlbum;
import org.effrafax.comiccollection.domain.model.interfaces.implementation.SimpleIndexable;
import org.effrafax.comiccollection.domain.model.interfaces.implementation.SimpleNameable;
import org.junit.Before;
import org.junit.Test;

/**
 * @author dvberkel
 */
public class SimpleAlbumTest {

	/**
	 * The expected index for {@code simpleAlbum}.
	 */
	private final Integer expectedIndex = 0;
	/**
	 * The expected name for {@code simpleAlbum}.
	 */
	private final String expectedName = "Expected Name";
	/**
	 * The {@link SimpleAlbum} under test.
	 */
	private Album simpleAlbum;

	/**
	 * The method which will construct the {@link Album} under test.
	 */
	@Before
	public void createSimpleAlbum() {

		simpleAlbum = new SimpleAlbum(expectedIndex, expectedName);
	}

	/**
	 * test if creation of {@link SimpleIndexable} produces expected result.
	 */
	@Test
	public void testIfSimpleIndexableReturnsTheCorrectIndex() {

		assertEquals(expectedIndex, simpleAlbum.getIndex());
	}

	/**
	 * test if the construction of {@link SimpleIndexable} fails if the argument
	 * is null.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testForConstructorFailureIfIndexArgumentIsNull() {

		new SimpleAlbum(null, expectedName);
	}

	/**
	 * test if the construction of {@link SimpleNameable} works as expected.
	 */
	@Test
	public void testSimpleNameableReturnsCorrectName() {

		assertEquals(expectedName, simpleAlbum.getName());
	}

	/**
	 * test if the construction of {@link SimpleNameable} fails if the argument
	 * is null.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testForConstructorFailureIfNameArgumentIsNull() {

		new SimpleAlbum(expectedIndex, null);
	}

	/**
	 * test if the construction of {@link SimpleNameable} fails if the argument
	 * is null.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testForConstructorFailureIfBothArgumentsAreNull() {

		new SimpleAlbum(null, null);
	}

}
