package org.effrafax.delegate;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.effrafax.util.ArgumentChecker;

public class DelegateInvocationHandler implements InvocationHandler {

	private DelegateBuilder builder;

	private Map<Class, Object> delegateMap;

	public DelegateInvocationHandler(DelegateBuilder builder) {

		initializeDelegateInvocationHandler(builder);
	}

	private void initializeDelegateInvocationHandler(DelegateBuilder builder) {

		createAndInitializeProperties(builder);
	}

	private void createAndInitializeProperties(DelegateBuilder builder) {

		createProperties(builder);
		initializeProperties();
	}

	private void createProperties(DelegateBuilder builder) {

		setBuilder(builder);
		setDelegateMap(new HashMap<Class, Object>());
	}

	private void initializeProperties() {

		initializeDelegateMap();
	}

	private void initializeDelegateMap() {

		for (Class declaringInterface : getDeclaringInterfaces()) {
			initializeDelegateMapFor(declaringInterface);
		}
	}

	private Iterable<Class> getDeclaringInterfaces() {

		return getBuilder().getDeclaringInterfaces();
	}

	private void initializeDelegateMapFor(Class declaringInterface) {

		Object delegate = createDelegateFor(declaringInterface);
		enterDelegateInDelgateMap(declaringInterface, delegate);
	}

	private Object createDelegateFor(Class declaringInterface) {

		Class delegateClass = getDelegateClassFor(declaringInterface);
		return tryToCreateDelegateOfType(delegateClass);
	}

	private Class getDelegateClassFor(Class declaringInterface) {

		return getBuilder().getDelegateClassFor(declaringInterface);
	}

	private Object tryToCreateDelegateOfType(Class delegateClass) {

		Object delegate = null;
		try {
			delegate = delegateClass.newInstance();
		} catch (InstantiationException e) {
			throwExceptionIfDelegateCreationFailed(e);
		} catch (IllegalAccessException e) {
			throwExceptionIfDelegateCreationFailed(e);
		}

		return delegate;
	}

	private void throwExceptionIfDelegateCreationFailed(Exception e) {

		throw new IllegalStateException(e);
	}

	private void enterDelegateInDelgateMap(Class declaringInterface, Object delegate) {

		ArgumentChecker.checkIfArgumentsAreNotNull(declaringInterface, delegate);
		getDelegateMap().put(declaringInterface, delegate);
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object,
	 * java.lang.reflect.Method, java.lang.Object[])
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		Class declaringInterface = method.getDeclaringClass();
		if (knowsDelegateFor(declaringInterface)) {
			Object delegate = getDelegateFor(declaringInterface);
			return method.invoke(delegate, args);
		}
		return null;
	}

	private boolean knowsDelegateFor(Class declaringInterface) {

		return getDelegateMap().containsKey(declaringInterface);
	}

	private Object getDelegateFor(Class declaringInterface) {

		return getDelegateMap().get(declaringInterface);
	}

	private DelegateBuilder getBuilder() {

		return builder;
	}

	private void setBuilder(DelegateBuilder builder) {

		ArgumentChecker.checkIfArgumentsAreNotNull(builder);
		this.builder = builder;
	}

	private Map<Class, Object> getDelegateMap() {

		return delegateMap;
	}

	private void setDelegateMap(Map<Class, Object> delegateMap) {

		ArgumentChecker.checkIfArgumentsAreNotNull(delegateMap);
		this.delegateMap = delegateMap;
	}

}
