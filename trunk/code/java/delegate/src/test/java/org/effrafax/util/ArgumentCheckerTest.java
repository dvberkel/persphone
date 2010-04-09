/**
 * 
 */
package org.effrafax.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.effrafax.util.ArgumentChecker;
import org.junit.Test;

/**
 * @author dvberkel
 */
public class ArgumentCheckerTest {

	@Test
	public void testIfIsNullDetectsANull() {

		assertTrue(ArgumentChecker.isNull(null));
	}

	@Test
	public void testIfIsNullDoesNotDetectsANonNull() {

		assertFalse(ArgumentChecker.isNull(new Object()));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testIfCheckIfArgumentsAreNotNullThrowsException() {

		ArgumentChecker.checkIfArgumentsAreNotNull(null);
	}
}
