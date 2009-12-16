/**
 * 
 */
package org.effrafax.math.tsp.instance;

/**
 * This interface provides a means to implementing metrics.
 * 
 * @author dvberkel
 * 
 */
public interface Metric<N extends Number>
{
	/**
	 * Determines the distance between {@code pointA} and {@code pointB} determined by this {@code Metric}.
	 * 
	 * @param pointA
	 *            one of the {@code Point} of which the distance is determined.
	 * @param pointB
	 *            the other {@code Point} of which the distance is determined.
	 * @return the distance between {@code pointA} and {@code pointB}.
	 */
	public double distance(Point<N> pointA, Point<N> pointB);
}
