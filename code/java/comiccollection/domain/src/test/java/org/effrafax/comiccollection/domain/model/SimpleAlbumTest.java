/**
 * 
 */
package org.effrafax.comiccollection.domain.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.HashMap;
import java.util.Map;

import org.effrafax.comiccollection.domain.builder.AlbumBuilder;
import org.effrafax.comiccollection.domain.model.implementation.SimpleAlbum;
import org.effrafax.comiccollection.domain.model.interfaces.implementation.SimpleIndexable;
import org.effrafax.comiccollection.domain.model.interfaces.implementation.SimpleNameable;
import org.effrafax.comiccollection.domain.model.visitor.AlbumVisitor;
import org.effrafax.comiccollection.domain.provider.Provider;
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

		AlbumBuilder builder = new AlbumBuilder();
		builder.setIndex(expectedIndex);
		builder.setName(expectedName);
		simpleAlbum = new SimpleAlbum(builder);
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

		AlbumBuilder builder = new AlbumBuilder();
		builder.setName(expectedName);
		new SimpleAlbum(builder);
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

		AlbumBuilder builder = new AlbumBuilder();
		builder.setIndex(expectedIndex);
		new SimpleAlbum(builder);
	}

	/**
	 * test if the construction of {@link SimpleNameable} fails if the argument
	 * is null.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testForConstructorFailureIfBothArgumentsAreNull() {

		AlbumBuilder builder = new AlbumBuilder();
		new SimpleAlbum(builder);
	}

	/**
	 * Test the reflecive contract for equality.
	 */
	@Test
	public void testSelfForEquality() {

		assertTrue(simpleAlbum.equals(simpleAlbum));
	}

	/**
	 * Test if other album equals this {@link SimpleAlbum}.
	 */
	@Test
	public void testOtherSimiliarObjectIsEqual() {

		AlbumBuilder builder = new AlbumBuilder();
		builder.setName(expectedName);
		builder.setIndex(expectedIndex);

		Album other = Provider.PROVIDER.getEntityFactory().createAlbum(builder);
		assertTrue(simpleAlbum.equals(other));
	}

	/**
	 * Null should not be equal.
	 */
	@Test
	public void testNullIsNotEqual() {

		assertFalse(simpleAlbum.equals(null));
	}

	/**
	 * A non-Album should not be equal.
	 */
	@Test
	public void testObjectIsNotEqual() {

		assertFalse(simpleAlbum.equals(new Object()));
	}

	/**
	 * Builders should not be null
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorWithNullArgumentThrowsException() {

		new SimpleAlbum(null);

	}

	/**
	 * Way to test uses of hashcode.
	 */
	@Test
	public void testHashCodeIsUsed() {

		Map<Album, Long> map = new HashMap<Album, Long>();
		map.put(simpleAlbum, simpleAlbum.getId());

		assertEquals(simpleAlbum.getId(), map.get(simpleAlbum));
	}

	/**
	 * Part of equals contract.
	 */
	@Test
	public void testEqualsContractForIndexOtherIsNull() {

		AlbumBuilder builder = new AlbumBuilder();
		builder.setIndex(1);
		builder.setName("other name");
		SimpleAlbum otherAlbum = new SimpleAlbum(builder) {

			/** Serializable ID */
			private static final long serialVersionUID = 37L;

			/**
			 * (non-Javadoc)
			 * 
			 * @see org.effrafax.comiccollection.domain.model.implementation.SimpleAlbum#getIndex()
			 */
			@Override
			public Integer getIndex() {

				return null;
			}

		};

		assertFalse(simpleAlbum.equals(otherAlbum));
	}

	/**
	 * Part of equals contract.
	 */
	@Test
	public void testEqualsContractForIndexOtherIsDifferent() {

		AlbumBuilder builder = new AlbumBuilder();
		builder.setIndex(1);
		builder.setName("other name");
		SimpleAlbum otherAlbum = new SimpleAlbum(builder);

		assertFalse(simpleAlbum.equals(otherAlbum));
	}

	/**
	 * Part of equals contract.
	 */
	@Test
	public void testEqualsContractForNameOtherIsNull() {

		AlbumBuilder builder = new AlbumBuilder();
		builder.setIndex(expectedIndex);
		builder.setName("other name");
		SimpleAlbum otherAlbum = new SimpleAlbum(builder) {

			/** SerializableID */
			private static final long serialVersionUID = 37L;

			/**
			 * (non-Javadoc)
			 * 
			 * @see org.effrafax.comiccollection.domain.model.implementation.SimpleAlbum#getIndex()
			 */
			@Override
			public String getName() {

				return null;
			}

		};

		assertFalse(simpleAlbum.equals(otherAlbum));
	}

	/**
	 * Part of equals contract.
	 */
	@Test
	public void testEqualsContractForNameOtherIsDifferent() {

		AlbumBuilder builder = new AlbumBuilder();
		builder.setIndex(expectedIndex);
		builder.setName("other name");
		SimpleAlbum otherAlbum = new SimpleAlbum(builder);

		assertFalse(simpleAlbum.equals(otherAlbum));
	}

	/**
	 * Test the acceptance of a visitor
	 */
	@Test
	public void testAcceptVisitorTest() {

		AlbumVisitor visitor = mock(AlbumVisitor.class);

		simpleAlbum.accept(visitor);

		verify(visitor).visit(simpleAlbum);
	}

}
