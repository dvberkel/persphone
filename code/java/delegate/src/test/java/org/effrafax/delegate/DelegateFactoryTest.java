package org.effrafax.delegate;

import static org.junit.Assert.assertEquals;

import org.effrafax.delegate.implementation.InMemoryDelegateBuilder;
import org.effrafax.interfaces.A;
import org.effrafax.interfaces.B;
import org.effrafax.interfaces.D;
import org.effrafax.interfaces.implementation.AImpl;
import org.effrafax.interfaces.implementation.BImpl;
import org.junit.Before;
import org.junit.Test;

public class DelegateFactoryTest {

	private D instancesOfD;

	@Before
	public void createInstanceOfD() {

		DelegateBuilder<D> delegateBuilder = new InMemoryDelegateBuilder<D>(D.class);
		delegateBuilder.mapInterfaceToDelegateClass(A.class, AImpl.class).mapInterfaceToDelegateClass(B.class,
				BImpl.class);
		setInstancesOfD(DelegateFactory.createDelegate(delegateBuilder));
	}

	@Test
	public void testDelegateGetCorrectlyCreated() {

		assertEquals(new Integer(0), getInstancesOfD().getZero());
		assertEquals(new Integer(1), getInstancesOfD().getOne());
	}

	private D getInstancesOfD() {

		return instancesOfD;
	}

	private void setInstancesOfD(D instancesOfD) {

		this.instancesOfD = instancesOfD;
	}
}
