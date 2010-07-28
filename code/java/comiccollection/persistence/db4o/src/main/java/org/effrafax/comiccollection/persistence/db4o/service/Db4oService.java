/**
 * 
 */
package org.effrafax.comiccollection.persistence.db4o.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Properties;

import org.effrafax.comiccollection.domain.model.Album;
import org.effrafax.comiccollection.domain.model.Comic;
import org.effrafax.comiccollection.domain.model.Omnibus;
import org.effrafax.comiccollection.domain.model.interfaces.Identifiable;
import org.effrafax.comiccollection.persistence.db4o.service.predicate.IdentifiablePredicate;
import org.effrafax.comiccollection.persistence.db4o.service.predicate.IndiscriminatePredicate;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;

/**
 * @author dvberkel
 * 
 */
public class Db4oService
{
	private Properties properties;

	public Db4oService()
	{
		loadProperties();
	}

	private void loadProperties()
	{
		Properties properties = new Properties();
		try
		{
			InputStream inputStream = getClass().getClassLoader().getResourceAsStream("db4o.properties");
			properties.load(inputStream);
			inputStream.close();
		}
		catch (FileNotFoundException exception)
		{
			throw new IllegalStateException(exception);
		}
		catch (IOException exception)
		{
			throw new IllegalStateException(exception);
		}
		setProperties(properties);
	}

	private void setProperties(Properties properties)
	{
		this.properties = properties;
	}

	public ObjectContainer getObjectContainer()
	{
		return Db4oEmbedded.openFile(getDatabaseFile());
	}

	private String getDatabaseFile()
	{
		return properties.getProperty("db4o.databaseFile");
	}

	public void saveOmnibus(Omnibus omnibus)
	{
		assignIdTo(omnibus);
		ObjectContainer container = getObjectContainer();
		container.store(omnibus);
	}

	public void saveComic(Comic comic)
	{
		assignIdTo(comic);
		ObjectContainer container = getObjectContainer();
		container.store(comic);
	}

	public void saveAlbum(Album album)
	{
		assignIdTo(album);
		ObjectContainer container = getObjectContainer();
		container.store(album);
	}

	private void assignIdTo(Omnibus omnibus)
	{
		assignId(omnibus);
		for (Comic comic : omnibus.getComics())
		{
			assignIdTo(comic);
		}

	}

	private void assignIdTo(Comic comic)
	{
		assignId(comic);
		for (Album album : comic.getAlbums())
		{
			assignIdTo(album);
		}
	}

	private void assignIdTo(Album album)
	{
		assignId(album);
	}

	private <I extends Identifiable> void assignId(I identifiable)
	{
		if (identifiable.getId() == null)
		{
			Sequence sequence = retrieveSequence();
			identifiable.setId(sequence.getNextId());
			storeSequence(sequence);
		}
	}

	private Sequence retrieveSequence()
	{
		ObjectContainer container = getObjectContainer();
		Query query = container.query();
		query.constrain(Sequence.class);
		ObjectSet<Sequence> resultSet = query.execute();

		if (resultSet.size() == 0)
		{
			return new Sequence();
		}
		else
		{
			return resultSet.next();
		}
	}

	private void storeSequence(Sequence sequence)
	{
		ObjectContainer container = getObjectContainer();
		container.store(sequence);
	}

	public <T extends Identifiable> T loadIdentifiable(Long id)
	{
		ObjectContainer container = getObjectContainer();
		ObjectSet<T> resultSet = container.query(new IdentifiablePredicate<T>(id));

		if (resultSet.hasNext())
		{
			return resultSet.next();
		}
		else
		{
			return null;
		}
	}

	public <T extends Identifiable> Collection<T> loadAllIdentifiable()
	{
		ObjectContainer container = getObjectContainer();
		ObjectSet<T> resultSet = container.query(new IndiscriminatePredicate<T>());

		return resultSet;

	}
}

class Sequence
{
	private Long nextId = 0L;

	public Long getNextId()
	{
		return nextId++;
	}
}