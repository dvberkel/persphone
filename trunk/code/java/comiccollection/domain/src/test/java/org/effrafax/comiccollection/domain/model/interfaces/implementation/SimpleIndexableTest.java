/**
 * 
 */
package org.effrafax.comiccollection.domain.model.interfaces.implementation;

import static org.junit.Assert.assertEquals;

import org.effrafax.comiccollection.domain.model.interfaces.Indexable;
import org.junit.Test;

/**
 * @author dvberkel
 */
public class SimpleIndexableTest {

	/**
	 * test if creation of {@link SimpleIndexable} produces expected result.
	 */
	@Test
	public void testIfSimpleIndexableReturnsTheCorrectIndex() {

		Integer expectedIndex = 0;
		Indexable simpleIndexable = new SimpleIndexable(expectedIndex);

		assertEquals(expectedIndex, simpleIndexable.getIndex());
	}
}
