package org.effrafax.underground.util.test;

import static org.junit.Assert.assertNotNull;

import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;

public class UndergroundWicketTest
{

	private WicketTester tester;

	public UndergroundWicketTest()
	{
		super();
	}

	@Before
	public void createWicketTester()
	{
		tester = new WicketTester();
	}

	public final WicketTester getTester()
	{
		return tester;
	}

	@Test
	public void shouldCreateAWicketTester()
	{
		assertNotNull(getTester());
	}

}