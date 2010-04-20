package org.effrafax.comiccollection.persistence.jdbc;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class MockitoTest {

	private InterfaceA interfaceA;

	@Test
	public void testUsageOfMockito() {

		InterfaceA interfaceA = mock(InterfaceA.class);
		when(interfaceA.getLong()).thenReturn(0L);

		assertEquals(new Long(0L), interfaceA.getLong());
	}
}

interface InterfaceA {

	public Long getLong();
}
