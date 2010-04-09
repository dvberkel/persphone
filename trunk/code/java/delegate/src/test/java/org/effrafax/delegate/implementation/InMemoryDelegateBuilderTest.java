package org.effrafax.delegate.implementation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.effrafax.delegate.DelegateBuilder;
import org.effrafax.interfaces.A;
import org.effrafax.interfaces.B;
import org.effrafax.interfaces.C;
import org.effrafax.interfaces.D;
import org.effrafax.interfaces.implementation.AImpl;
import org.effrafax.interfaces.implementation.BImpl;
import org.junit.Before;
import org.junit.Test;

public class InMemoryDelegateBuilderTest {

	private DelegateBuilder<D> builder = null;

	@Before
	public void createInMemoryDelegateBuilder() {

		DelegateBuilder<D> builder = new InMemoryDelegateBuilder<D>(D.class);
		builder.mapInterfaceToDelegateClass(A.class, AImpl.class);
		builder.mapInterfaceToDelegateClass(B.class, BImpl.class);
		setBuilder(builder);
	}

	@Test
	public void testGetDeclaringInterfacesReturnsCorrectInterfaces() {

		List<Class> interfaces = new ArrayList<Class>();
		for (Class declaringInterface : getBuilder().getDeclaringInterfaces()) {
			interfaces.add(declaringInterface);
		}

		assertTrue(2 == interfaces.size());
		assertTrue(interfaces.contains(A.class));
		assertTrue(interfaces.contains(B.class));
	}

	@Test
	public void testGetDelegateClassForReturnsCorrectClass() {

		assertEquals(AImpl.class, getBuilder().getDelegateClassFor(A.class));
		assertEquals(BImpl.class, getBuilder().getDelegateClassFor(B.class));
	}

	@Test(expected = IllegalStateException.class)
	public void testExceptionIsThrownWhenNoDelegateIsKnownForAInterface() {

		getBuilder().getDelegateClassFor(C.class);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testMappingInterfaceToNullThrowsAnException() {

		getBuilder().mapInterfaceToDelegateClass(C.class, null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testMappingNullToADelegateClassThrowsAnException() {

		getBuilder().mapInterfaceToDelegateClass(null, AImpl.class);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testMappingNullToNullThrowsAnException() {

		getBuilder().mapInterfaceToDelegateClass(null, null);
	}

	@Test
	public void testGetTargetInterfaceReturnsCorrectClass() {

		assertEquals(D.class, getBuilder().getTargetInterface());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCreateInMemoryDelegateBuilderWithNullArgumentThrowsException() {

		new InMemoryDelegateBuilder(null);
	}

	private DelegateBuilder<D> getBuilder() {

		return builder;
	}

	private void setBuilder(DelegateBuilder<D> builder) {

		this.builder = builder;
	}
}