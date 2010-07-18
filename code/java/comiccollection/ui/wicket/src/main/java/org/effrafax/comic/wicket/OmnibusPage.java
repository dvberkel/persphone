/**
 * 
 */
package org.effrafax.comic.wicket;

import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.effrafax.comic.wicket.component.comic.ComicLink;
import org.effrafax.comiccollection.domain.model.Comic;
import org.effrafax.comiccollection.domain.model.Omnibus;
import org.effrafax.comiccollection.domain.service.RetrievalService;

/**
 * @author dvberkel
 */
public class OmnibusPage extends WebPage
{

	/**
	 * Shows the {@link Omnibus} with {@code omnibusId}.
	 * 
	 * @param omnibusId
	 *            the id of the {@link Omnibus} shown.
	 */
	public OmnibusPage(final Long omnibusId)
	{

		addBackLink();
		addComics(omnibusId);

	}

	/**
	 * Adds a link back to the {@Link ComicCollectionPage}.
	 */
	private void addBackLink()
	{

		add(new Link<Void>("backLink")
		{

			/** */
			private static final long serialVersionUID = 37L;

			@Override
			public void onClick()
			{

				setResponsePage(new ComicCollectionPage(null));
			}

		});
	}

	/**
	 * Adds all the comics for a {@link Omnibus}
	 * 
	 * @param omnibusId
	 *            the id of the {@link Omnibus}.
	 */
	private void addComics(final Long omnibusId)
	{

		Omnibus omnibus = RetrievalService.getOmnibus(omnibusId);
		List<Comic> comics = omnibus.getComics();
		add(new ListView<Comic>("comics", comics)
		{

			/** */
			private static final long serialVersionUID = 37L;

			@Override
			protected void populateItem(ListItem<Comic> item)
			{

				item.add(new ComicLink("comicLink", omnibusId, item.getModel()));
			}
		});
	}
}
