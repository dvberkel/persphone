/**
 * 
 */
package org.effrafax.db40.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Predicate;
import com.db4o.query.Query;

/**
 * @author dvberkel
 * 
 */
public class Db4oTest
{
	private static String db4oFile = "src/test/resources/test.db4o";

	private ObjectContainer container;

	private StandardMessage message;

	@Before
	public void createObjectContainer()
	{
		container = Db4oEmbedded.openFile(db4oFile);

		message = new StandardMessage("first", "This is the first post");
		container.store(message);

		container.store(new StandardMessage("second", "This is an other post"));
	}

	@After
	public void destroyObjectContainer()
	{
		container.rollback();
		container.close();
	}

	@AfterClass
	public static void removeDb4oFile()
	{

	}

	@Test
	public void testRetrieveByExample()
	{

		StandardMessage proto = new StandardMessage("first", null);
		ObjectSet<StandardMessage> resultSet = container.queryByExample(proto);

		assertResultHasOnlyFirstMessage(resultSet);
	}

	private <M extends Message> void assertResultHasOnlyFirstMessage(ObjectSet<M> resultSet)
	{
		assertEquals(Integer.valueOf(1), Integer.valueOf(resultSet.size()));
		M result = resultSet.next();
		assertEquals(message, result);
	}

	@Test
	public void testRetrieveByNativeQeury()
	{
		Predicate<StandardMessage> predicate = new Predicate<StandardMessage>()
		{

			/** */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean match(StandardMessage message)
			{
				return message.getTitle().equals("first");
			}
		};

		ObjectSet<StandardMessage> resultSet = container.query(predicate);
		assertResultHasOnlyFirstMessage(resultSet);
	}

	@Test
	public void testRetrieveBySODA()
	{
		Query query = container.query();
		query.constrain(StandardMessage.class);
		query.descend("title").constrain("first");

		ObjectSet<StandardMessage> resultSet = query.execute();
		assertResultHasOnlyFirstMessage(resultSet);
	}

	@Test
	public void testRetrieveInterfaceByNativeQuery()
	{
		Predicate<Message> predicate = new Predicate<Message>()
		{

			/** */
			private static final long serialVersionUID = 37L;

			@Override
			public boolean match(Message message)
			{
				return message.getTitle().equals("first");
			}
		};

		ObjectSet<Message> resultSet = container.query(predicate);
		assertResultHasOnlyFirstMessage(resultSet);
	}

	@Test
	public void testIsChildRetrievable()
	{
		message.addComment(new StandardMessage("third", "a test"));
		container.store(message);

		StandardMessage proto = new StandardMessage("third", null);
		ObjectSet<StandardMessage> resultSet = container.queryByExample(proto);

		assertEquals(Integer.valueOf(1), Integer.valueOf(resultSet.size()));
	}
}

interface Message
{
	public String getTitle();

	public String getContent();

	public Message getComment();
}

class StandardMessage implements Message
{
	private String title;

	private String content;

	private Message comment;

	public StandardMessage(String title, String content)
	{
		this.title = title;
		this.content = content;
	}

	/**
	 * @return the title
	 */
	public String getTitle()
	{
		return title;
	}

	/**
	 * @return the content
	 */
	public String getContent()
	{
		return content;
	}

	public void addComment(Message comment)
	{
		this.comment = comment;
	}

	public Message getComment()
	{
		return comment;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StandardMessage other = (StandardMessage) obj;
		if (content == null)
		{
			if (other.content != null)
				return false;
		}
		else if (!content.equals(other.content))
			return false;
		if (title == null)
		{
			if (other.title != null)
				return false;
		}
		else if (!title.equals(other.title))
			return false;
		return true;
	}

}