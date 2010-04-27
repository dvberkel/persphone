package org.effrafax.comiccollection.persistence.jdbc;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

/**
 * This test is used to get familiar with the mockito test framework.
 * 
 * @author dvberkel
 */
public class MockitoTest {

	/**
	 * The {@link InterfaceA} that will be mocked.
	 */
	private InterfaceA interfaceA;

	/**
	 * Tests the mockito framwork.
	 */
	@Test
	public void testUsageOfMockito() {

		interfaceA = mock(InterfaceA.class);
		when(interfaceA.getLong()).thenReturn(0L);

		assertEquals(new Long(0L), interfaceA.getLong());
	}
}

/**
 * This interface will be mocked.
 * 
 * @author dvberkel
 */
interface InterfaceA {

	/**
	 * A method to impement.
	 * 
	 * @return a Long
	 */
	public Long getLong();
}
