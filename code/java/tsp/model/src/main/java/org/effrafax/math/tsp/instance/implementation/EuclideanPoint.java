/**
 * 
 */
package org.effrafax.math.tsp.instance.implementation;

import java.util.List;

/**
 * This class construct point in the Euclidean metric.
 * 
 * @author dvberkel
 * 
 */
public class EuclideanPoint<N extends Number> extends AbstractPoint<N>
{
	/**
	 * Constructor of a {@code EuclideanPoint}.
	 * 
	 * @param coordinates
	 *            for the {@code EuclideanPoint}.
	 */
	public EuclideanPoint(List<N> coordinates)
	{
		super(new EuclideanMetric<N>(), coordinates);
	}
}
