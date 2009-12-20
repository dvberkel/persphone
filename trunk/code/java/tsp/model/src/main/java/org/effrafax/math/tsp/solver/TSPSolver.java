/**
 * 
 */
package org.effrafax.math.tsp.solver;

import org.effrafax.math.tsp.instance.TSPInstance;

/**
 * This interface provides a means to solve TSPInstances.
 * 
 * @author dvberkel
 * 
 */
public interface TSPSolver<N extends Number>
{
	/**
	 * Returns a {@link TSPTour} over all the points in {@code tspInstance}.
	 * 
	 * @param tspInstance
	 *            the {@link TSPInstance} used to construct the {@link TSPTour}
	 * @return a {@link TSPTour} over {@code tspInstance}
	 */
	public TSPTour<N> createTour(TSPInstance<N> tspInstance);
}
