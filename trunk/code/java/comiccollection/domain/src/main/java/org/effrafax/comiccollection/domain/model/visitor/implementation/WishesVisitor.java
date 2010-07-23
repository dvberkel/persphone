/**
 * 
 */
package org.effrafax.comiccollection.domain.model.visitor.implementation;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.effrafax.comiccollection.domain.model.Album;
import org.effrafax.comiccollection.domain.model.Comic;
import org.effrafax.comiccollection.domain.model.visitor.AlbumVisitor;

/**
 * @author dvberkel
 */
public class WishesVisitor implements AlbumVisitor
{

	/**
	 * List the indices visited.
	 */
	private final Set<Integer> indices = new HashSet<Integer>();

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.effrafax.comiccollection.domain.model.visitor.AlbumVisitor#visit(org.effrafax.comiccollection.domain.model.Album)
	 */
	@Override
	public void visit(Album album)
	{

		indices.add(album.getIndex());
	}

	/**
	 * The prime result for this {@Link AlbumVisitor}.
	 * 
	 * @return the indices not in a {@link Comic}.
	 */
	public Set<Integer> getWishes()
	{

		Integer maximum = indices.size() > 0 ? Collections.max(indices) : 0;
		Set<Integer> wishes = range(maximum + 1);
		wishes.removeAll(indices);

		return wishes;
	}

	/**
	 * Returns a set of integer in the range 1 to {@code maximum}.
	 * 
	 * @param maximum
	 *            the maximal element in the range.
	 * @return set of integers.
	 */
	private Set<Integer> range(int maximum)
	{

		Set<Integer> range = new HashSet<Integer>();
		for (int i = 1; i <= maximum; i++)
		{
			range.add(Integer.valueOf(i));
		}
		return range;
	}
}
