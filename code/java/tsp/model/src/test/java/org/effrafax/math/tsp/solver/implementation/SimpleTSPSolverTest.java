/**
 * 
 */
package org.effrafax.math.tsp.solver.implementation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;

import org.effrafax.math.tsp.instance.TSPInstance;
import org.effrafax.math.tsp.instance.implementation.AbstractTSPInstance;
import org.effrafax.math.tsp.instance.implementation.EuclideanPoint;
import org.effrafax.math.tsp.solver.TSPTour;
import org.junit.Test;

/**
 * @author dvberkel
 * 
 */
public class SimpleTSPSolverTest
{
	@Test
	public void testSquareArrangement()
	{
		TSPInstance<Integer> instance = new AbstractTSPInstance<Integer>()
		{
			/** default implementation will suffice. */
		};

		instance.addPoint(new EuclideanPoint<Integer>(Arrays.asList(new Integer[] { 0, 0 })));
		instance.addPoint(new EuclideanPoint<Integer>(Arrays.asList(new Integer[] { 1, 0 })));
		instance.addPoint(new EuclideanPoint<Integer>(Arrays.asList(new Integer[] { 1, 1 })));
		instance.addPoint(new EuclideanPoint<Integer>(Arrays.asList(new Integer[] { 0, 1 })));

		SimpleTSPSolver<Integer> solver = new SimpleTSPSolver<Integer>();
		TSPTour<Integer> tour = solver.createTour(instance);

		assertNotNull(tour);
		assertEquals(4.0d, tour.distance(), 0.01d);

		System.out.println(tour);
	}
}
