/**
 * 
 */
package org.effrafax.comic.wicket.component.comic;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.effrafax.comic.wicket.ComicPage;
import org.effrafax.comiccollection.domain.model.Comic;

/**
 * @author dvberkel
 * 
 */
public class ComicLink extends Panel
{

	/** */
	private static final long serialVersionUID = 37L;

	public ComicLink(String id, final Long omnibusId, IModel<Comic> comicModel)
	{
		super(id, comicModel);
		Comic comic = comicModel.getObject();
		final Long comicId = comic.getId();
		Link<Void> comicLink = new Link<Void>("comicLink")
		{

			/** */
			private static final long serialVersionUID = 37L;

			@Override
			public void onClick()
			{

				setResponsePage(new ComicPage(omnibusId, comicId));
			}
		};
		comicLink.add(new Label("name", comic.getName()));
		add(comicLink);
	}

}
