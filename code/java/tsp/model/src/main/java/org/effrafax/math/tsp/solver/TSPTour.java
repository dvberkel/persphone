/**
 * 
 */
package org.effrafax.math.tsp.solver;

import java.util.List;

import org.effrafax.math.tsp.instance.Point;

/**
 * This interface provides a means to record a tour.
 * 
 * @author dvberkel
 * 
 */
public interface TSPTour<N extends Number>
{
	/**
	 * Add a point to visit along this tour.
	 * 
	 * @param point
	 *            The point to visit.
	 */
	public void visit(Point<N> point);

	/**
	 * Add all {@code points}.
	 * 
	 * @param points
	 *            The list of points to visit.
	 */
	public void visitAll(List<Point<N>> points);

	/**
	 * Determines the distance of this {@code TSPTour}.
	 * 
	 * @return the distance of this {@code TSPTour}.
	 */
	public double distance();
}
