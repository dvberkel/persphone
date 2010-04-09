package org.effrafax.delegate;

import java.lang.reflect.Proxy;

public class DelegateFactory {

	public static <T> T createDelegate(DelegateBuilder<T> builder) {

		DelegateInvocationHandler delegateInvocationHandler = new DelegateInvocationHandler(builder);
		Class<T> targetInterface = builder.getTargetInterface();
		Object proxy = Proxy.newProxyInstance(DelegateFactory.class.getClassLoader(), new Class[] {targetInterface },
				delegateInvocationHandler);
		return targetInterface.cast(proxy);
	}
}
