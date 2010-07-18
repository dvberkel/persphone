/**
 * 
 */
package org.effrafax.comic.wicket;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;
import org.effrafax.comic.wicket.component.comic.ComicsPanel;
import org.effrafax.comiccollection.domain.model.Omnibus;

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
	private void addComics(Long omnibusId)
	{
		add(new ComicsPanel("comics", omnibusId));
	}
}
