/**
 * 
 */
package org.effrafax.comiccollection.domain.model.interfaces.implementation;

import static org.junit.Assert.assertEquals;

import org.effrafax.comiccollection.domain.model.interfaces.Nameable;
import org.junit.Test;

/**
 * @author dvberkel
 */
public class SimpleNameableTest {

	/**
	 * test if the construction of {@link SimpleNameable} works as expected.
	 */
	@Test
	public void testSimpleNameableReturnsCorrectName() {

		String name = "expected name";
		Nameable nameable = new SimpleNameable(name);

		assertEquals(name, nameable.getName());
	}

}
