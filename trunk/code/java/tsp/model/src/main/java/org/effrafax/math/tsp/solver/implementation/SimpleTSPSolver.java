/**
 * 
 */
package org.effrafax.math.tsp.solver.implementation;

import java.util.Iterator;
import java.util.List;

import org.effrafax.math.tsp.instance.Point;
import org.effrafax.math.tsp.instance.TSPInstance;
import org.effrafax.math.tsp.solver.TSPSolver;
import org.effrafax.math.tsp.solver.TSPTour;
import org.effrafax.math.tsp.solver.util.PermutationIterator;

/**
 * @author dvberkel
 * 
 */
public class SimpleTSPSolver<N extends Number> implements TSPSolver<N>
{
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.effrafax.math.tsp.solver.TSPSolver#createTour(org.effrafax.math.tsp.instance.TSPInstance)
	 */
	@Override
	public TSPTour<N> createTour(TSPInstance<N> tspInstance)
	{
		TSPTour<N> minimalTour = null;

		for (TSPTour<N> tour : new AllTSPTours<N>(tspInstance))
		{
			minimalTour = minimalTour(minimalTour, tour);
		}

		return minimalTour;
	}

	/**
	 * Returns the {@link TSPTour} with the smallest distance.
	 * 
	 * @param aTour
	 *            a {@link TSPTour} under scrutiny.
	 * @param anotherTour
	 *            another {@link TSPTour} under scrutiny.
	 * @return the {@link TSPTour} with the smallest distance.
	 */
	private TSPTour<N> minimalTour(TSPTour<N> aTour, TSPTour<N> anotherTour)
	{
		TSPTour<N> minimalTour = null;

		if (aTour == null)
		{
			minimalTour = anotherTour;
		}
		else if (anotherTour == null)
		{
			minimalTour = aTour;
		}
		else
		{
			int compareValue = Double.compare(aTour.distance(), anotherTour.distance());
			if (compareValue <= 0)
			{
				minimalTour = aTour;
			}
			else
			{
				minimalTour = anotherTour;
			}
		}

		return minimalTour;
	}

	/**
	 * An {@link Iterable} which produces an {@link TSPTourIterator}.
	 * 
	 * @author dvberkel
	 * 
	 * @param <M>
	 *            the kind of points in {@link TSPTourIterator}.
	 */
	private class AllTSPTours<M extends Number> implements Iterable<TSPTour<M>>
	{
		private TSPInstance<M> instance = null;

		/**
		 * Constructor which takes an {@link TSPInstance}.
		 * 
		 * @param instance
		 *            the {@link TSPInstance} which gets used to created {@link Iterator}.
		 */
		public AllTSPTours(TSPInstance<M> instance)
		{
			if (instance == null)
			{
				throw new IllegalArgumentException("instance should not be null");
			}
			this.instance = instance;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Iterable#iterator()
		 */
		@Override
		public Iterator<TSPTour<M>> iterator()
		{
			return new TSPTourIterator<M>(instance);
		}
	}

	/**
	 * An {@Link Iterator} that iterates over all the possible tours of a {@link TSPInstance}.
	 * 
	 * @author dvberkel
	 * 
	 * @param <M>
	 *            The kind of points in {@link TSPInstance}.
	 */
	private class TSPTourIterator<M extends Number> implements Iterator<TSPTour<M>>
	{
		/**
		 * The points in the {@link TSPInstance}.
		 */
		private Iterator<List<Point<M>>> iterator = null;

		/**
		 * Constructor which takes an {@link TSPInstance}.
		 * 
		 * @param instance
		 *            the {@link TSPInstance} over which the {@link TSPTour}s are taken.
		 */
		public TSPTourIterator(TSPInstance<M> instance)
		{
			if (instance == null)
			{
				throw new IllegalArgumentException("instance should not be null");
			}
			setIterator(new PermutationIterator<Point<M>>(instance.getAllPoints()));
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.util.Iterator#hasNext()
		 */
		@Override
		public boolean hasNext()
		{
			return getIterator().hasNext();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.util.Iterator#next()
		 */
		@Override
		public TSPTour<M> next()
		{
			return new SimpleTSPTour<M>(getIterator().next());
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.util.Iterator#remove()
		 */
		@Override
		public void remove()
		{
			getIterator().remove();
		}

		/**
		 * @return the iterator
		 */
		private Iterator<List<Point<M>>> getIterator()
		{
			return iterator;
		}

		/**
		 * @param iterator
		 *            the iterator to set
		 */
		private void setIterator(Iterator<List<Point<M>>> iterator)
		{
			this.iterator = iterator;
		}
	}

}
