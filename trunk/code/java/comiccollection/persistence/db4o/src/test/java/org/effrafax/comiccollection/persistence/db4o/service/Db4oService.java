/**
 * 
 */
package org.effrafax.comiccollection.persistence.db4o.service;

/**
 * @author dvberkel
 * 
 */
public class Db4oService
{
	private static Db4oService service = null;

	private static Db4oService getDb4oService()
	{
		if (service == null)
		{
			service = new Db4oService();
		}
		return service;
	}

	private Db4oService()
	{

	}
}
