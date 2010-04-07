/**
 * 
 */
package org.effrafax.delegate.implementation;

import java.util.HashMap;
import java.util.Map;

import org.effrafax.delegate.DelegateInvocationHandlerBuilder;
import org.effrafax.delegate.util.ArgumentChecker;

/**
 * @author dvberkel
 */
public class InMemoryDelegateInvocationHandlerBuilder implements DelegateInvocationHandlerBuilder {

	private Map<Class, Class> declaringInterfaceToDelegateClassMap;

	public InMemoryDelegateInvocationHandlerBuilder() {

		setDeclaringInterfaceToDelegateClassMap(new HashMap<Class, Class>());
	}

	public DelegateInvocationHandlerBuilder mapInterfaceToDelegateClass(Class declaringInterface, Class delegateClass) {

		ArgumentChecker.checkIfArgumentsAreNotNull(declaringInterface);
		getDeclaringInterfaceToDelegateClassMap().put(declaringInterface, delegateClass);
		return this;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * org.effrafax.delegate.DelegateInvocationHandlerBuilder#getDeclaringInterfaces
	 * ()
	 */
	public Iterable<Class> getDeclaringInterfaces() {

		return getDeclaringInterfaceToDelegateClassMap().keySet();
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * org.effrafax.delegate.DelegateInvocationHandlerBuilder#getDelegateClassFor
	 * (java.lang.Class)
	 */
	public Class getDelegateClassFor(Class declaringInterface) {

		throwExceptionIfMapDoesNotContainDelegateFor(declaringInterface);

		return getDeclaringInterfaceToDelegateClassMap().get(declaringInterface);
	}

	private void throwExceptionIfMapDoesNotContainDelegateFor(Class declaringInterface) {

		if (!interfaceToDelegateMapContainsAsKey(declaringInterface)) {
			throw new IllegalStateException("no delegate found for " + declaringInterface.getName());
		}
	}

	private boolean interfaceToDelegateMapContainsAsKey(Class declaringInterface) {

		boolean argumentIsNotNull = !ArgumentChecker.isNull(declaringInterface);
		boolean interfaceToDelegateMapContainsArgument = getDeclaringInterfaceToDelegateClassMap().containsKey(
				declaringInterface);

		return argumentIsNotNull && interfaceToDelegateMapContainsArgument;
	}

	private Map<Class, Class> getDeclaringInterfaceToDelegateClassMap() {

		return declaringInterfaceToDelegateClassMap;
	}

	private void setDeclaringInterfaceToDelegateClassMap(Map<Class, Class> declaringInterfaceToDelegateClassMap) {

		this.declaringInterfaceToDelegateClassMap = declaringInterfaceToDelegateClassMap;
	}
}
