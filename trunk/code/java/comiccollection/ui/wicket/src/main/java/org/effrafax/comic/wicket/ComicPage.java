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
import org.effrafax.comiccollection.domain.model.Album;
import org.effrafax.comiccollection.domain.model.Comic;
import org.effrafax.comiccollection.domain.model.Omnibus;
import org.effrafax.comiccollection.domain.service.RetrievalService;

/**
 * @author dvberkel
 */
public class ComicPage extends WebPage {

	/**
	 * Shows the comic with {@code comicId}.
	 * @param omnibusId the id of the containing {@link Omnibus}.
	 * 
	 * @param comicId
	 *            the id of the {@link Comic} shown.
	 */
	public ComicPage(final Long omnibusId, Long comicId) {

		Comic comic = RetrievalService.getComic(comicId);
		addComicName(comic);
		addBackLink(omnibusId);
		addAlbums(comic);

	}

	/**
	 * Adds the name of {@code comic}.
	 * 
	 * @param comic
	 *            the {@link Comic} on this page.
	 */
	private void addComicName(Comic comic) {

		add(new Label("comicName", comic.getName()));
	}

	/**
	 * Adds the link back to the containing {@link Omnibus}.
	 * 
	 * @param omnibusId
	 *            the id of the containing {@link Omnibus}
	 */
	private void addBackLink(final Long omnibusId) {

		add(new Link<Void>("backLink") {

			/** */
			private static final long serialVersionUID = 37L;

			@Override
			public void onClick() {

				setResponsePage(new OmnibusPage(omnibusId));
			}

		});
	}

	/**
	 * Adds all the {@link Album}s to this {@link ComicPage}.
	 * 
	 * @param comic
	 *            the containing {@link Comic}.
	 */
	private void addAlbums(Comic comic) {

		List<Album> albums = comic.getAlbums();
		add(new ListView<Album>("albums", albums) {

			/** */
			private static final long serialVersionUID = 37L;

			@Override
			protected void populateItem(ListItem<Album> item) {

				Album album = item.getModelObject();
				item.add(new Label("index", String.format("%d", album.getIndex())));
				item.add(new Label("name", album.getName()));
			}
		});
	}
}