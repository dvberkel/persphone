package org.effrafax.underground;

import org.apache.wicket.protocol.http.HttpSessionStore;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.session.ISessionStore;

/**
 * Application object for your web application. If you want to run this application without deploying, run the Start
 * class.
 * 
 * @see org.effrafax.underground.Start#main(String[])
 */
public class WicketApplication extends WebApplication
{
	/**
	 * Constructor
	 */
	public WicketApplication()
	{
	}

	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	public Class<HomePage> getHomePage()
	{
		return HomePage.class;
	}

	@Override
	protected ISessionStore newSessionStore()
	{
		return new HttpSessionStore(this);
	}

	@Override
	protected void init()
	{
		super.init();
		this.getResourceSettings().setResourcePollFrequency(null);
	}

}
