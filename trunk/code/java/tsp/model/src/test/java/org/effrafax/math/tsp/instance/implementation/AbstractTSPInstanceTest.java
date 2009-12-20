/**
 * 
 */
package org.effrafax.math.tsp.instance.implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.effrafax.math.tsp.instance.Point;
import org.effrafax.math.tsp.instance.TSPInstance;
import org.junit.Test;

/**
 * @author dvberkel
 * 
 */
public class AbstractTSPInstanceTest
{
	@Test(expected = IllegalArgumentException.class)
	public void testFailWithNullCollection()
	{
		new AbstractTSPInstance<Integer>(null)
		{
			/**
			 * The default implementation will suffice.
			 */
		};
	}

	@Test(expected = IllegalArgumentException.class)
	public void testFailWithCollectionContainingNull()
	{
		List<Point<Integer>> points = new ArrayList<Point<Integer>>();
		points.add(new EuclideanPoint<Integer>(Arrays.asList(new Integer[] { 1, 0 })));
		points.add(null);
		new AbstractTSPInstance<Integer>(points)
		{
			/**
			 * The default implementation will suffice.
			 */
		};
	}

	@Test(expected = IllegalArgumentException.class)
	public void testFailWhenAddingNull()
	{
		TSPInstance<Integer> instance = new AbstractTSPInstance<Integer>()
		{
			/**
			 * The default implementation will suffice.
			 */
		};

		instance.addPoint(null);
	}

}
