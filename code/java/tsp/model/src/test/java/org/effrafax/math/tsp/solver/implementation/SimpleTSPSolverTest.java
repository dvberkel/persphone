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
import org.junit.Before;
import org.junit.Test;

/**
 * @author dvberkel
 * 
 */
public class SimpleTSPSolverTest
{
	private double tolerance = 0.01d;

	private TSPInstance<Integer> instance = null;

	@Before
	public void createTSPInstance()
	{
		instance = new AbstractTSPInstance<Integer>()
		{
			/** default implementation will suffice. */
		};
	}

	@Test
	public void testSquareArrangement()
	{

		instance.addPoint(new EuclideanPoint<Integer>(Arrays.asList(new Integer[] { 0, 0 })));
		instance.addPoint(new EuclideanPoint<Integer>(Arrays.asList(new Integer[] { 1, 0 })));
		instance.addPoint(new EuclideanPoint<Integer>(Arrays.asList(new Integer[] { 1, 1 })));
		instance.addPoint(new EuclideanPoint<Integer>(Arrays.asList(new Integer[] { 0, 1 })));

		SimpleTSPSolver<Integer> solver = new SimpleTSPSolver<Integer>();
		TSPTour<Integer> tour = solver.createTour(instance);

		assertNotNull(tour);
		assertEquals(4.0d, tour.distance(), tolerance);
	}

	@Test
	public void testDisjointSquaresArrangement()
	{

		instance.addPoint(new EuclideanPoint<Integer>(Arrays.asList(new Integer[] { 0, 0 })));
		instance.addPoint(new EuclideanPoint<Integer>(Arrays.asList(new Integer[] { 1, 0 })));
		instance.addPoint(new EuclideanPoint<Integer>(Arrays.asList(new Integer[] { 1, 1 })));
		instance.addPoint(new EuclideanPoint<Integer>(Arrays.asList(new Integer[] { 0, 1 })));

		instance.addPoint(new EuclideanPoint<Integer>(Arrays.asList(new Integer[] { 5, 0 })));
		instance.addPoint(new EuclideanPoint<Integer>(Arrays.asList(new Integer[] { 6, 0 })));
		instance.addPoint(new EuclideanPoint<Integer>(Arrays.asList(new Integer[] { 6, 1 })));
		instance.addPoint(new EuclideanPoint<Integer>(Arrays.asList(new Integer[] { 5, 1 })));

		SimpleTSPSolver<Integer> solver = new SimpleTSPSolver<Integer>();
		TSPTour<Integer> tour = solver.createTour(instance);

		assertNotNull(tour);
		assertEquals(14.0d, tour.distance(), tolerance);
	}
}
