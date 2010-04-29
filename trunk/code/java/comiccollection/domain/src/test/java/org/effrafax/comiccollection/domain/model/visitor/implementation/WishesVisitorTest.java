package org.effrafax.comiccollection.domain.model.visitor.implementation;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.effrafax.comiccollection.domain.builder.AlbumBuilder;
import org.effrafax.comiccollection.domain.model.Album;
import org.effrafax.comiccollection.domain.provider.Provider;
import org.junit.Test;

/**
 * Test for the {@link WishesVisitor}.
 * 
 * @author dvberkel
 */
public class WishesVisitorTest {

	/**
	 * Test is the wishlist is correct.
	 */
	@Test
	public void testWishesVisitor() {

		AlbumBuilder albumBuilder = new AlbumBuilder();
		albumBuilder.setIndex(2);
		albumBuilder.setName("a Name");

		Album album = Provider.PROVIDER.getEntityFactory().createAlbum(albumBuilder);

		WishesVisitor wishesVisitor = new WishesVisitor();
		album.accept(wishesVisitor);

		Set<Integer> expected = new HashSet<Integer>();
		expected.add(1);
		expected.add(3);
		assertEquals(expected, wishesVisitor.getWishes());

	}
}
