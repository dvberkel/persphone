/**
 * 
 */
package org.effrafax.math.tsp.solver.implementation;

import java.util.ArrayList;
import java.util.List;

import org.effrafax.math.tsp.instance.Point;
import org.effrafax.math.tsp.solver.TSPTour;

/**
 * This class provides a means to construct a {@link TSPTour}.
 * 
 * @author dvberkel
 * 
 */
public class SimpleTSPTour<N extends Number> implements TSPTour<N>
{
	/**
	 * The ordered list of points to visit.
	 */
	private List<Point<N>> points = null;

	/**
	 * Default constructor.
	 */
	public SimpleTSPTour()
	{
		setPoints(new ArrayList<Point<N>>());
	}

	/**
	 * Constructor which visits all the points.
	 * 
	 * @param points
	 *            the {@link Point}s to visit.
	 */
	public SimpleTSPTour(List<Point<N>> points)
	{
		this();
		visitAll(points);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.effrafax.math.tsp.solver.TSPTour#distance()
	 */
	@Override
	public double distance()
	{
		double total = 0;
		int size = getPoints().size();
		for (int index = 0; index < size - 1; index++)
		{
			total += getPoints().get(index).distance(getPoints().get(index + 1));
		}
		total += getPoints().get(size - 1).distance(getPoints().get(0));

		return total;
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
		this.points = points;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.effrafax.math.tsp.solver.TSPTour#visit(org.effrafax.math.tsp.instance.Point)
	 */
	@Override
	public void visit(Point<N> point)
	{
		getPoints().add(point);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.effrafax.math.tsp.solver.TSPTour#visitAll(java.util.List)
	 */
	@Override
	public void visitAll(List<Point<N>> points)
	{
		for (Point<N> point : points)
		{
			visit(point);
		}
	}

}
