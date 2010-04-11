package org.effrafax.comiccollection.util;

import org.junit.Test;

/**
 * @author dvberkel
 */
public class ArgumentCheckerTest {

	/**
	 * test if {@link ArgumentChecker} throws correct exception when multiple
	 * arguments are null.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testIfExceptionIsThrownWithMultipleNullArguments() {

		ArgumentChecker.throwExceptionIfAnyArgumentIsNull(null, null);
	}

	/**
	 * test if {@link ArgumentChecker} throws correct exception when one
	 * argument is tested.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testIfExceptionIsThrownWithANullArgument() {

		ArgumentChecker.throwExceptionIfAnyArgumentIsNull((Object) null);
	}
}
