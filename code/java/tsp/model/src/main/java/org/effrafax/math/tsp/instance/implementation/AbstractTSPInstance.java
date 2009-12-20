/**
 * 
 */
package org.effrafax.math.tsp.instance.implementation;

import java.util.ArrayList;
import java.util.List;

import org.effrafax.math.tsp.instance.Point;
import org.effrafax.math.tsp.instance.TSPInstance;

/**
 * @author dvberkel
 * 
 */
public abstract class AbstractTSPInstance<N extends Number> implements TSPInstance<N>
{
	/**
	 * This list of {@link Point}s which this {@code TSPInstance} contains.
	 */
	private List<Point<N>> points = null;

	/**
	 * Default constructor. Creates an {@code TSPInstance} with an empty collection of points.
	 */
	public AbstractTSPInstance()
	{
		this(new ArrayList<Point<N>>());
	}

	/**
	 * Constructor with a given collection of points.
	 * 
	 * @param points
	 */
	public AbstractTSPInstance(List<Point<N>> points)
	{
		setPoints(points);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.effrafax.math.tsp.instance.TSPInstance#addPoint(org.effrafax.math.tsp.instance.Point)
	 */
	@Override
	public void addPoint(Point<N> point)
	{
		if (!isProper(point))
		{
			throw new IllegalArgumentException("point should be proper");
		}
		getPoints().add(point);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.effrafax.math.tsp.instance.TSPInstance#removePoint(org.effrafax.math.tsp.instance.Point)
	 */
	@Override
	public boolean removePoint(Point<N> point)
	{
		return getPoints().remove(point);
	}

	/**
	 * @return the points
	 */
	private List<Point<N>> getPoints()
	{
		return points;
	}

	/**
	 * @param points
	 *            the points to set
	 */
	private void setPoints(List<Point<N>> points)
	{
		if (!isProper(points))
		{
			throw new IllegalArgumentException("points should be proper");
		}
		this.points = points;
	}

	/**
	 * Determines if {@code point} is a proper {@link Point} i.e. not null.
	 * 
	 * @param point
	 *            the {@link Point} under scrutiny.
	 * @return {@code true} if {@code point} is proper, {@code false} otherwise.
	 */
	private boolean isProper(Point<N> point)
	{
		return point != null;
	}

	/**
	 * Determines if {@code points} is a proper {@code List} of {@link Point} i.e. {@code points} is not null and
	 * contains proper {@code Point}s.
	 * 
	 * @param point
	 *            the {@code List} of {@link Point}s under scrutiny.
	 * @return {@code true} if {@code points} is proper, {@code false} otherwise.
	 * @see org.effrafax.math.tsp.instance.implementation.AbstractTSPInstance.isProper(Point<N>)
	 */
	private boolean isProper(List<Point<N>> points)
	{
		boolean isProper = true;
		if (points == null)
		{
			isProper = false;
		}
		else
		{
			for (Point<N> point : points)
			{
				if (!isProper(point))
				{
					isProper = false;
					break;
				}
			}
		}

		return isProper;
	}
}
