/**
 * 
 */
package org.effrafax.comiccollection.util;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author dvberkel
 */
public abstract class Copier {

	/**
	 * Returns a copy of the {@code original} {@link Collection}.
	 * 
	 * @param <E>
	 *            the generic type of the {@code original}.
	 * @param original
	 *            the {@link Collection} being copied.
	 * @return a copy of {@code original}.
	 */
	public static <E> Collection<E> aCopyOf(Collection<E> original) {

		Collection<E> copy = new ArrayList<E>();
		copy.addAll(original);
		return copy;
	}
}
