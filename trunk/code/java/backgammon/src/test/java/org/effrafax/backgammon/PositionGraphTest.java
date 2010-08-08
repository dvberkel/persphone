package org.effrafax.backgammon;

import java.util.Date;

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

	@Test
	public void creationTimeTest()
	{
		long startMoment = new Date().getTime();
		positionGraph = new PositionGraph(6, 2);
		long finishMoment = new Date().getTime();

		System.out.format("PositionGraph speed test: %d ms\n", finishMoment - startMoment);
		Utils.assertEqualInts(28, positionGraph.numberOfPositions());
		Utils.assertEqualInts(214, positionGraph.numberOfMoves());
	}
}
