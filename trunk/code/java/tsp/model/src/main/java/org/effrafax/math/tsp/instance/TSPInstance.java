/**
 * 
 */
package org.effrafax.math.tsp.instance;

import java.util.List;

/**
 * This interface provides a means to represant a traveling salesman problem instance.
 * 
 * @author dvberkel
 * 
 */
public interface TSPInstance<N extends Number>
{
	/**
	 * Adds a point to this {@code TSPInstance}
	 * 
	 * @param point
	 *            The {@code point} that is added to this {@code TSPInstance}.
	 */
	public void addPoint(Point<N> point);

	/**
	 * Removes {@code point} from this {@code TSPInstance}. This {@code TSPInstance} does not have to contain {@code
	 * point}. A flag is returned to indicate if {@code point} was present or not.
	 * 
	 * @param point
	 *            the {@link Point} removed from this {@code TSPInstance}.
	 * @return {@code true} if {@code point} was removed, {@code false} otherwise.
	 */
	public boolean removePoint(Point<N> point);

	/**
	 * Returns all the points in this {@code TSPInstance}.
	 * 
	 * @return a {@code List} of all the {@link Point}s in the {@code TSPInstance}
	 */
	public List<Point<N>> getAllPoints();
}
