package org.effrafax.delegate.implementation;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class InMemoryDelegateInvocationHandlerBuilderTest {

	private InMemoryDelegateInvocationHandlerBuilder builder = null;

	@Before
	public void createInMemoryDelegateInvocationHandlerBuilder() {

		InMemoryDelegateInvocationHandlerBuilder builder = new InMemoryDelegateInvocationHandlerBuilder();
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

	}

	private InMemoryDelegateInvocationHandlerBuilder getBuilder() {

		return builder;
	}

	private void setBuilder(InMemoryDelegateInvocationHandlerBuilder builder) {

		this.builder = builder;
	}
}

interface A {}

class AImpl implements A {};

interface B {}

class BImpl implements B {};