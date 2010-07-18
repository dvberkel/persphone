package org.effrafax.comic.wicket;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.effrafax.comic.wicket.component.OmnibusLink;
import org.effrafax.comiccollection.domain.model.Omnibus;
import org.effrafax.comiccollection.domain.service.RetrievalService;

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

		List<Omnibus> omnibusses = new ArrayList<Omnibus>();
		omnibusses.addAll(RetrievalService.getAllOmnibusses());
		add(new ListView<Omnibus>("omnibusses", omnibusses)
		{

			/** */
			private static final long serialVersionUID = 37L;

			@Override
			protected void populateItem(ListItem<Omnibus> item)
			{
				item.add(new OmnibusLink("omnibusLink", item.getModel()));
			}
		});
	}
}
