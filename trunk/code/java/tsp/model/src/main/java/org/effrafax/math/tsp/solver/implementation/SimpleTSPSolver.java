/**
 * 
 */
package org.effrafax.math.tsp.solver.implementation;

import java.util.List;

import org.effrafax.math.tsp.instance.Point;
import org.effrafax.math.tsp.instance.TSPInstance;
import org.effrafax.math.tsp.solver.TSPSolver;
import org.effrafax.math.tsp.solver.TSPTour;

/**
 * @author dvberkel
 * 
 */
public class SimpleTSPSolver<N extends Number> implements TSPSolver<N>
{

	@Override
	public TSPTour<N> createTour(TSPInstance<N> tspInstance)
	{
		List<Point<N>> points = tspInstance.getAllPoints();
		return null;
	}

}
