/**
 * 
 */
package org.effrafax.combinatorial.iterator.filter;

/**
 * @author dvberkel
 * 
 */
public interface Filter<E>
{
	boolean pass(E element);
}
