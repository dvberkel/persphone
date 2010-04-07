package org.effrafax.delegate;

public interface DelegateInvocationHandlerBuilder {

	public abstract Iterable<Class> getDeclaringInterfaces();

	public abstract Class getDelegateClassFor(Class declaringInterface);

}