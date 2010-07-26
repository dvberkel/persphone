/**
 * 
 */
package org.effrafax.comiccollection.domain.model.interfaces.comparators;

import static org.junit.Assert.assertTrue;

import org.effrafax.comiccollection.domain.model.interfaces.Identifiable;
import org.effrafax.comiccollection.domain.model.interfaces.Indexable;
import org.effrafax.comiccollection.domain.model.interfaces.Nameable;
import org.junit.Before;
import org.junit.Test;

/**
 * @author dvberkel
 * 
 */
public class ComparatorTest
{
	private AbstractComparator<Integer> comparator;

	@Before
	public void createComparator()
	{
		comparator = new AbstractComparator<Integer>()
		{

			@Override
			protected int nonNullCompare(Integer anObject, Integer otherObject)
			{
				return anObject.compareTo(otherObject);
			}
		};
	}

	@Test
	public void testNullElements()
	{
		assertIsZero(comparator.compare(null, null));
	}

	@Test
	public void testOneNullElement()
	{
		assertIsNegative(comparator.compare(null, 1));
		assertIsPositive(comparator.compare(1, null));
	}

	@Test
	public void testIdentifiable()
	{
		assertIsNegative(new IdentifiableComparator<Identifiable>().compare(identifiableBy(1L), identifiableBy(2L)));
	}

	@Test
	public void testNameable()
	{
		assertIsNegative(new NameableComparator<Nameable>().compare(namedBy("a"), namedBy("b")));
	}

	@Test
	public void testIndexable()
	{
		assertIsNegative(new IndexableComparator<Indexable>().compare(indexedBy(1), indexedBy(2)));
	}

	private static Identifiable identifiableBy(final Long id)
	{
		return new Identifiable()
		{

			/** */
			private static final long serialVersionUID = 37L;

			@Override
			public void setId(Long id)
			{
				// no implementation is necessary for it's use.
			}

			@Override
			public Long getId()
			{
				return id;
			}
		};
	}

	private Nameable namedBy(final String name)
	{
		return new Nameable()
		{

			@Override
			public String getName()
			{
				return name;
			}
		};
	}

	private Indexable indexedBy(final Integer index)
	{
		return new Indexable()
		{

			@Override
			public Integer getIndex()
			{
				return index;
			}
		};
	}

	private void assertIsPositive(int value)
	{
		assertTrue(value > 0);
	}

	private void assertIsNegative(int value)
	{
		assertTrue(value < 0);
	}

	private void assertIsZero(int value)
	{
		assertTrue(value == 0);

	}
}
