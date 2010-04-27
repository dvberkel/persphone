package org.effrafax.comic.wicket;

import org.apache.wicket.protocol.http.WebApplication;

/**
 * Application object for your web application. If you want to run this
 * application without deploying, run the Start class.
 */
public class WicketApplication extends WebApplication {

	/**
	 * Constructor
	 */
	public WicketApplication() {

	}

	/**
	 */
	@Override
	public Class<ComicCollection> getHomePage() {

		return ComicCollection.class;
	}

}
