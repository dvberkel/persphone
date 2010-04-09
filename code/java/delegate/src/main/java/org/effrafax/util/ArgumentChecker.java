package org.effrafax.util;

/**
 * @author dvberkel
 */
public class ArgumentChecker {

	public static void checkIfArgumentsAreNotNull(Object... arguments) {

		for (Object argument : arguments) {
			throwExceptionIfArgumentIsNull(argument);
		}
	}

	private static void throwExceptionIfArgumentIsNull(Object argument) {

		if (isNull(argument)) {
			throw new IllegalArgumentException(String.format("Argument should not be null"));
		}
	}

	public static boolean isNull(Object argument) {

		return argument == null;
	}
}
