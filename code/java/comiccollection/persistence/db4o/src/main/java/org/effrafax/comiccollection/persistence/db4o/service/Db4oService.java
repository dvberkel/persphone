/**
 * 
 */
package org.effrafax.comiccollection.persistence.db4o.service;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

/**
 * @author dvberkel
 * 
 */
public class Db4oService
{
	private static Db4oService service = null;

	private ObjectContainer objectContainer = null;

	private static synchronized Db4oService getDb4oService()
	{
		if (service == null)
		{
			service = new Db4oService();
		}
		return service;
	}

	private Db4oService()
	{
		objectContainer = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "test.db4o");
	}
}
