/**
 * 
 */
package org.effrafax.comic.wicket.component.album;

import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.effrafax.comiccollection.domain.model.Album;
import org.effrafax.comiccollection.domain.model.Comic;

/**
 * @author dvberkel
 * 
 */
public class AlbumsPanel extends Panel
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 37L;

	public AlbumsPanel(String id, IModel<Comic> comicModel)
	{
		super(id, comicModel);
		List<Album> albums = comicModel.getObject().getAlbums();
		add(new ListView<Album>("albums", albums)
		{

			/** */
			private static final long serialVersionUID = 37L;

			@Override
			protected void populateItem(ListItem<Album> item)
			{

				Album album = item.getModelObject();
				item.add(new Label("index", String.format("%d", album.getIndex())));
				item.add(new Label("name", album.getName()));
			}
		});
	}

}
