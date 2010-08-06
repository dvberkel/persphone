/**
 * 
 */
package org.effrafax.backgammon.proto;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @author dvberkel
 * 
 */
public class ProtoPositionIterator implements Iterator<ProtoPosition>
{
	private final int numberOfPoints;

	private final int numberOfStones;

	private ProtoPosition next;

	public ProtoPositionIterator(int numberOfPoints, int numberOfStones)
	{
		this.numberOfPoints = numberOfPoints;
		this.numberOfStones = numberOfStones;
		next = initialPosition(0);
	}

	private ProtoPosition initialPosition(int stones)
	{
		int[] position = new int[numberOfPoints + stones - 1];
		Arrays.fill(position, 0);
		Arrays.fill(position, 0, stones, 1);
		return new ProtoPosition(position);
	}

	@Override
	public boolean hasNext()
	{
		return next != null;
	}

	@Override
	public ProtoPosition next()
	{
		ProtoPosition result = next;
		next = next.next();
		if (next == null && result.numberOfStones() < numberOfStones)
		{
			next = initialPosition(result.numberOfStones() + 1);
		}
		return result;
	}

	@Override
	public void remove()
	{
		throw new UnsupportedOperationException();
	}

}
