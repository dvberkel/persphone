/**
 * 
 */
package org.effrafax.delegate.implementation;

import java.util.HashMap;
import java.util.Map;

import org.effrafax.delegate.DelegateBuilder;
import org.effrafax.util.ArgumentChecker;

/**
 * @author dvberkel
 */
public class InMemoryDelegateBuilder<T> implements DelegateBuilder<T> {

	private Class<T> targetInterface;

	private Map<Class, Class> declaringInterfaceToDelegateClassMap;

	public InMemoryDelegateBuilder(Class<T> targetInterface) {

		setTargetInterface(targetInterface);
		setDeclaringInterfaceToDelegateClassMap(new HashMap<Class, Class>());
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * org.effrafax.delegate.DelegateBuilder#mapInterfaceToDelegateClass(java
	 * .lang.Class, java.lang.Class)
	 */
	@Override
	public DelegateBuilder mapInterfaceToDelegateClass(Class declaringInterface, Class delegateClass) {

		ArgumentChecker.checkIfArgumentsAreNotNull(declaringInterface, delegateClass);
		getDeclaringInterfaceToDelegateClassMap().put(declaringInterface, delegateClass);
		return this;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * org.effrafax.delegate.DelegateInvocationHandlerBuilder#getDeclaringInterfaces
	 * ()
	 */
	@Override
	public Iterable<Class> getDeclaringInterfaces() {

		return getDeclaringInterfaceToDelegateClassMap().keySet();
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * org.effrafax.delegate.DelegateInvocationHandlerBuilder#getDelegateClassFor
	 * (java.lang.Class)
	 */
	@Override
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

	public Map<Class, Class> getDeclaringInterfaceToDelegateClassMap() {

		return declaringInterfaceToDelegateClassMap;
	}

	private void setDeclaringInterfaceToDelegateClassMap(Map<Class, Class> declaringInterfaceToDelegateClassMap) {

		this.declaringInterfaceToDelegateClassMap = declaringInterfaceToDelegateClassMap;
	}

	/*
	 * (non-Javadoc)
	 * @see org.effrafax.delegate.DelegateBuilder#getTargetInterface()
	 */
	@Override
	public Class getTargetInterface() {

		return targetInterface;
	}

	private void setTargetInterface(Class<T> targetInterface) {

		ArgumentChecker.checkIfArgumentsAreNotNull(targetInterface);
		this.targetInterface = targetInterface;
	}
}
