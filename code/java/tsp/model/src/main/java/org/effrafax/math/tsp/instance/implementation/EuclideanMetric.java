/**
 * 
 */
package org.effrafax.math.tsp.instance.implementation;

import java.util.List;

/**
 * This class implements the euclidean metric.
 * 
 * @author dvberkel
 * 
 */
public class EuclideanMetric<N extends Number> extends AbstractMetric<N>
{

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.effrafax.math.tsp.instance.implementation.AbstractMetric#distance(java.util.List, java.util.List)
	 */
	@Override
	protected double distance(List<N> coordinatesA, List<N> coordinatesB)
	{
		double squareSum = 0;
		for (int index = 0; index < coordinatesA.size(); index++)
		{
			double valueA = coordinatesA.get(index).doubleValue();
			double valueB = coordinatesB.get(index).doubleValue();

			squareSum += Math.pow(valueA - valueB, 2);
		}
		return Math.sqrt(squareSum);
	}

}
