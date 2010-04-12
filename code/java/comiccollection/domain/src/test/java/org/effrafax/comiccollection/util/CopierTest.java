/**
 * 
 */
package org.effrafax.comiccollection.util;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

/**
 * @author dvberkel
 */
public class CopierTest {

	/**
	 * Test to see if {@link Copier} can copy an empty {@link Collection}.
	 */
	@Test
	public void testCopierCopiesAnEmptyCollection() {

		Collection<Integer> original = new ArrayList<Integer>();
		assertEquals(original, Copier.aCopyOf(original));
	}
}
