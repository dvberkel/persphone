/**
 * 
 */
package org.effrafax.math.tsp.instance.implementation;

import java.util.List;

import org.effrafax.math.tsp.instance.Metric;
import org.effrafax.math.tsp.instance.Point;

/**
 * This abstract class provides a default implementation of the {@link Metric} interface.
 * 
 * @author dvberkel
 * 
 */
public abstract class AbstractMetric<N extends Number> implements Metric<N>
{

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.effrafax.math.tsp.instance.Metric#distance(org.effrafax.math.tsp.instance.Point,
	 * org.effrafax.math.tsp.instance.Point)
	 */
	@Override
	public double distance(Point<N> pointA, Point<N> pointB)
	{
		if (!sameDimension(pointA, pointB))
		{
			throw new IllegalArgumentException("points should agree on dimension");
		}

		return distance(pointA.getCoordinates(), pointB.getCoordinates());
	}

	/**
	 * Determines if both {@code pointA} and {@code pointB} agree on dimension.
	 * 
	 * @param pointA
	 *            a {@link Point} in the test.
	 * @param pointB
	 *            an other {@link Point} in the test
	 * @return {@code true} if {@code pointA} and {@code pointB} agree on dimension, otherwise {@code false}.
	 */
	private boolean sameDimension(Point<N> pointA, Point<N> pointB)
	{
		int dimensionA = pointA.getCoordinates().size();
		int dimensionB = pointB.getCoordinates().size();

		return dimensionA == dimensionB;
	}

	/**
	 * When given to list of coordinates of equal size determines the distance according to this {@code Metric}.
	 * 
	 * @param coordinatesA
	 *            the coordinates of a {@link Point} of which the distance is to be determined.
	 * @param coordinatesB
	 *            the coordinates of an other {@link Point} of which the distance is to be determined.
	 * @return the distance between the two {@link Point}s.
	 */
	protected abstract double distance(List<N> coordinatesA, List<N> coordinatesB);

}
