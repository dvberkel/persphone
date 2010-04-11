/**
 * 
 */
package org.effrafax.comiccollection.util;

/**
 * @author dvberkel
 */
public class ArgumentChecker {

	/**
	 * This method throws an {@link IllegalArgumentException} if any of the
	 * {@code arguments} is null.
	 * 
	 * @param arguments
	 *            the arguments under scrutiny.
	 * @throws IllegalArgumentException
	 *             if any of the {@code arguments} is null.
	 */
	public static void throwExceptionIfAnyArgumentIsNull(Object... arguments) {

		for (Object argument : arguments) {
			throwExceptionIfArgumentIsNull(argument);
		}
	}

	/**
	 * This method throws an {@link IllegalArgumentException} if the {@code
	 * argument} is null.
	 * 
	 * @param argument
	 *            the argument under scrutiny.
	 * @throws IllegalArgumentException
	 *             if {@code argument} is null.
	 */
	private static void throwExceptionIfArgumentIsNull(Object argument) {

		if (isNull(argument)) {
			throwIllegalArgumentException();
		}

	}

	/**
	 * This method checks if {@code argument} is null.
	 * 
	 * @param argument
	 *            the argument under scrutiny.
	 * @return {@code true} if {@code argument} is null, otherwise {@code false}
	 *         . .
	 */
	private static boolean isNull(Object argument) {

		return argument == null;
	}

	/**
	 * throws in {@link IllegalArgumentException}.
	 */
	private static void throwIllegalArgumentException() {

		throw new IllegalArgumentException("Argument is null");
	}
}
