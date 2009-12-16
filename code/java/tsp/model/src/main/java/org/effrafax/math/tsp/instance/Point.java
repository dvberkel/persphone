/**
 * 
 */
package org.effrafax.math.tsp.instance;

import java.util.List;

/**
 * This interface represents a point in a TSP problem.
 * 
 * @author dvberkel
 * 
 */
public interface Point<N extends Number>
{
	/**
	 * Determines the distance from this {@code Point} to {@code point}.
	 * 
	 * @param point
	 *            the {@code Point} to which distance is determined.
	 * @return The distance from this {@code Point} to {@code point}.
	 */
	public double distance(Point<N> point);

	/**
	 * Determines the coordinates of this {@code Point} to some coordinate system.
	 * 
	 * @return a list of coordinates.
	 */
	public List<N> getCoordinates();
}
