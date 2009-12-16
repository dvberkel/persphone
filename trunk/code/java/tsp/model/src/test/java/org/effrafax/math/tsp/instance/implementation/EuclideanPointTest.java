/**
 * 
 */
package org.effrafax.math.tsp.instance.implementation;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.effrafax.math.tsp.instance.Point;
import org.junit.Test;

/**
 * @author dvberkel
 * 
 */
public class EuclideanPointTest
{
	private static final double ACCURACY = 0.001d;

	@Test
	public void testIntegerEclideanPointDistance()
	{
		Point<Integer> origin = new EuclideanPoint<Integer>(Arrays.asList(new Integer[] { 0, 0 }));
		Point<Integer> pointA = new EuclideanPoint<Integer>(Arrays.asList(new Integer[] { 1, 0 }));
		Point<Integer> pointB = new EuclideanPoint<Integer>(Arrays.asList(new Integer[] { 0, 1 }));

		assertEquals(0d, origin.distance(origin), ACCURACY);
		assertEquals(1d, origin.distance(pointA), ACCURACY);
		assertEquals(1d, pointA.distance(origin), ACCURACY);
		assertEquals(1d, origin.distance(pointB), ACCURACY);
		assertEquals(1d, pointB.distance(origin), ACCURACY);
		assertEquals(Math.sqrt(2), pointA.distance(pointB), ACCURACY);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testFailWithZeroCoordinates()
	{
		new EuclideanPoint<Integer>(Arrays.asList(new Integer[] {}));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testFailWithNullCoordinate()
	{
		new EuclideanPoint<Integer>(Arrays.asList(new Integer[] { 0, null }));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testFailWithDifferentDimension()
	{
		Point<Integer> pointA = new EuclideanPoint<Integer>(Arrays.asList(new Integer[] { 0 }));
		Point<Integer> pointB = new EuclideanPoint<Integer>(Arrays.asList(new Integer[] { 0, 0 }));

		pointA.distance(pointB);
	}
}
