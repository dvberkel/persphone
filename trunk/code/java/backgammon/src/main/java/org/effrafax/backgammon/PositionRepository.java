/**
 * 
 */
package org.effrafax.backgammon;

import java.util.HashMap;
import java.util.Map;

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
}
