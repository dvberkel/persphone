/**
 * 
 */
package org.effrafax.math.tsp.instance.implementation;

import org.effrafax.math.tsp.instance.Metric;
import org.junit.Test;

/**
 * @author dvberkel
 * 
 */
public class AbstractPointTest
{
	@Test(expected = IllegalArgumentException.class)
	public void testPointConstructionMetricFailure()
	{
		new AbstractPoint<Integer>(null, null)
		{
			/**
			 * Anonymous class instantiation which will throw an error.
			 */
		};
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPointConstructionCoordinatesFailure()
	{
		Metric<Integer> metric = new EuclideanMetric<Integer>();
		new AbstractPoint<Integer>(metric, null)
		{
			/**
			 * Anonymous class instantiation which will throw an error.
			 */
		};
	}
}
