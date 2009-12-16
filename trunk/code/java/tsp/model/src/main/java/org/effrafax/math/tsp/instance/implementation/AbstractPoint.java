/**
 * 
 */
package org.effrafax.math.tsp.instance.implementation;

import java.util.ArrayList;
import java.util.List;

import org.effrafax.math.tsp.instance.Metric;
import org.effrafax.math.tsp.instance.Point;

/**
 * This abstract class provides default implementation of {@link Point} interface.
 * 
 * @author dvberkel
 * 
 */
public abstract class AbstractPoint<N extends Number> implements Point<N>
{
	/**
	 * The metric used to determine distances.
	 */
	private Metric<N> metric = null;

	/**
	 * The coordinates of this {@code AbstractPoint}.
	 */
	private List<N> coordinates = null;

	/**
	 * Constructor for {@code AbstractPoint}. Takes a {@code Metric} to determine distances between {@code Points}.
	 * 
	 * @param metric
	 *            the {@code Metric} used to determines distances.
	 * @param coordinates
	 *            the coordinates of this {@code AbstractPoint}.
	 */
	public AbstractPoint(Metric<N> metric, List<N> coordinates)
	{
		setMetric(metric);
		setCoordinates(coordinates);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.effrafax.math.tsp.instance.Point#distance(org.effrafax.math.tsp.instance.Point)
	 */
	@Override
	public double distance(Point<N> point)
	{
		return getMetric().distance(this, point);
	}

	/**
	 * @return the metric
	 */
	private Metric<N> getMetric()
	{
		return metric;
	}

	/**
	 * @param metric
	 *            the metric to set
	 */
	private void setMetric(Metric<N> metric)
	{
		if (metric == null)
		{
			throw new IllegalArgumentException("metric should not be null");
		}
		this.metric = metric;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.effrafax.math.tsp.instance.Point#getCoordinates()
	 */
	@Override
	public List<N> getCoordinates()
	{
		List<N> copy = new ArrayList<N>();
		copy.addAll(coordinates);

		return copy;
	}

	/**
	 * Creates a private copy of the {@code coordinates}.
	 * 
	 * @param coordinates
	 *            The coordinates for this {@code AbstractPoint}.
	 */
	private void setCoordinates(List<N> coordinates)
	{
		if (coordinates.contains(null))
		{
			throw new IllegalArgumentException("coordinats should not contain null");
		}
		if (coordinates.size() == 0)
		{
			throw new IllegalArgumentException("coordinates should contain at least one coordinate");
		}
		this.coordinates = new ArrayList<N>();
		this.coordinates.addAll(coordinates);
	}
}
