/**
 * 
 */
package org.effrafax.comic.wicket.component.album;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.effrafax.comiccollection.domain.model.Album;
import org.effrafax.comiccollection.domain.model.Comic;
import org.effrafax.comiccollection.domain.model.interfaces.Indexable;

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

	public AlbumsPanel(String id, Long omnibusId, IModel<Comic> comicModel)
	{
		super(id, comicModel);
		addAlbumPanel(omnibusId, comicModel);
		listAlbums(comicModel);
	}

	private void addAlbumPanel(Long omnibusId, IModel<Comic> comicModel)
	{
		add(new AddAlbumPanel("addAlbum", omnibusId, comicModel));
	}

	private void listAlbums(IModel<Comic> comicModel)
	{
		List<Album> albums = new ArrayList<Album>(comicModel.getObject().getAlbums());
		Collections.sort(albums, new IndexableComparator<Album>());
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

class IndexableComparator<T extends Indexable> implements Comparator<T>
{

	@Override
	public int compare(T aIndexable, T otherIndexable)
	{
		if (aIndexable == null && otherIndexable == null)
		{
			return 0;
		}
		else if (aIndexable == null && otherIndexable != null)
		{
			return -1;
		}
		else if (aIndexable != null && otherIndexable == null)
		{
			return 1;
		}
		else
		{
			return aIndexable.getIndex().compareTo(otherIndexable.getIndex());
		}
	}

}