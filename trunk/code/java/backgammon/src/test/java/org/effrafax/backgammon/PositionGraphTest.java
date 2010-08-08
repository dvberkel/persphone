package org.effrafax.backgammon;

import org.effrafax.util.Utils;
import org.junit.Before;
import org.junit.Test;

public class PositionGraphTest
{
	private PositionGraph positionGraph;

	@Before
	public void createPositionGraph()
	{
		positionGraph = new PositionGraph(2, 2);
	}

	@Test
	public void countPositions()
	{
		Utils.assertEqualInts(6, positionGraph.numberOfPositions());
	}

	@Test
	public void countMoves()
	{
		Utils.assertEqualInts(6, positionGraph.numberOfMoves());
	}
}
