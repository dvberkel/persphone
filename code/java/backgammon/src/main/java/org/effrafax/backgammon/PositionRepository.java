/**
 * 
 */
package org.effrafax.backgammon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.effrafax.backgammon.proto.ProtoPosition;

/**
 * @author dvberkel
 * 
 */
public class PositionRepository
{
	private Map<Position, Position> cache = new HashMap<Position, Position>();

	public Position retrieve(ProtoPosition protoPosition)
	{
		return retrieve(new Position(protoPosition));
	}

	public Position retrieve(Position position)
	{
		if (!cache.containsKey(position))
		{
			cache.put(position, position);
		}
		return cache.get(position);
	}

	public int numberOfPositions()
	{
		return cache.keySet().size();
	}

	public Iterable<Position> positions()
	{
		return cache.values();
	}

	public Set<Position> canonicalPositions(Set<Position> positions)
	{
		Set<Position> canonicalPositions = new HashSet<Position>();
		for (Position position : positions)
		{
			canonicalPositions.add(retrieve(position));
		}
		return canonicalPositions;
	}
}
