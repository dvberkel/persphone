package org.effrafax.delegate;

public interface DelegateBuilder<T> {

	public Class<T> getTargetInterface();

	public Iterable<Class> getDeclaringInterfaces();

	public Class getDelegateClassFor(Class declaringInterface);

	public DelegateBuilder mapInterfaceToDelegateClass(Class declaringInterface, Class delegateClass);

}