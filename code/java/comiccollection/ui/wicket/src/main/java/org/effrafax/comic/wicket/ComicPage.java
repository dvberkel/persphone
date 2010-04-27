/**
 * 
 */
package org.effrafax.comic.wicket;

import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.effrafax.comiccollection.domain.model.Album;
import org.effrafax.comiccollection.domain.model.Comic;
import org.effrafax.comiccollection.domain.service.RetrievalService;

/**
 * @author dvberkel
 */
public class ComicPage extends WebPage {

	/**
	 * Shows the comic with {@code comicId}.
	 * 
	 * @param comicId
	 *            the id of the {@link Comic} shown.
	 */
	public ComicPage(Long comicId) {

		Comic comic = RetrievalService.getComic(comicId);
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
