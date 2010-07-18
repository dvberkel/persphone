package org.effrafax.comic.wicket;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.effrafax.comic.wicket.component.omnibus.OmnibussesPanel;
import org.effrafax.comiccollection.domain.model.Omnibus;

/**
 * Homepage
 */
public class ComicCollectionPage extends WebPage
{

	/** */
	private static final long serialVersionUID = 37L;

	/**
	 * Constructor that is invoked when page is invoked without a session.
	 * 
	 * @param parameters
	 *            Page parameters
	 */
	public ComicCollectionPage(final PageParameters parameters)
	{

		showOmnibusses();
	}

	/**
	 * Shows all the {@link Omnibus}ses.
	 */
	private void showOmnibusses()
	{
		add(new OmnibussesPanel("omnibussen"));
	}
}
