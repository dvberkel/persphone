/**
 * 
 */
package org.effrafax.comic.wicket;

import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.effrafax.comiccollection.domain.model.Comic;
import org.effrafax.comiccollection.domain.model.Omnibus;
import org.effrafax.comiccollection.domain.service.RetrievalService;

/**
 * @author dvberkel
 */
public class OmnibusPage extends WebPage {

	/**
	 * Shows the {@link Omnibus} with {@code omnibusId}.
	 * 
	 * @param omnibusId
	 *            the id of the {@link Omnibus} shown.
	 */
	public OmnibusPage(Long omnibusId) {

		Omnibus omnibus = RetrievalService.getOmnibus(omnibusId);
		List<Comic> comics = omnibus.getComics();
		add(new ListView<Comic>("comics", comics) {

			/** */
			private static final long serialVersionUID = 37L;

			@Override
			protected void populateItem(ListItem<Comic> item) {

				Comic comic = item.getModelObject();
				final Long comicId = comic.getId();
				Link<Void> comicLink = new Link<Void>("comicLink") {

					/** */
					private static final long serialVersionUID = 37L;

					@Override
					public void onClick() {

						setResponsePage(new ComicPage(comicId));
					}
				};
				comicLink.add(new Label("name", comic.getName()));
				item.add(comicLink);
			}
		});

	}
}
