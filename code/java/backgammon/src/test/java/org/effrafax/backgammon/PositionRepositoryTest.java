package org.effrafax.backgammon;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.effrafax.backgammon.proto.ProtoPosition;
import org.effrafax.backgammon.proto.ProtoPositionIterator;
import org.junit.Before;
import org.junit.Test;

public class PositionRepositoryTest
{
	private PositionRepository repository;

	private Position position;

	@Before
	public void initialize()
	{
		repository = new PositionRepository();
		position = repository.retrieve(new ProtoPosition(1, 0, 0));
	}

	@Test
	public void testRetrievalWithProtoPosition()
	{
		assertTrue(position == repository.retrieve(new ProtoPosition(1, 0, 0)));
	}

	@Test
	public void testRetrievalWithPosition()
	{
		assertTrue(position == repository.retrieve(new Position(new ProtoPosition(1, 0, 0))));
	}

	@Test
	public void testCreationSpeed()
	{
		long startMoment = new Date().getTime();
		ProtoPositionIterator iterator = new ProtoPositionIterator(6, 15);
		while (iterator.hasNext())
		{
			repository.retrieve(iterator.next());
		}
		long finishMoment = new Date().getTime();
		System.out.format("Fill time for repository: %d ms\n", finishMoment - startMoment);
	}
}
