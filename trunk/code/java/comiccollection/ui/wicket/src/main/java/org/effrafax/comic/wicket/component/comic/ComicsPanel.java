/**
 * 
 */
package org.effrafax.comic.wicket.component.comic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.effrafax.comiccollection.domain.model.Comic;
import org.effrafax.comiccollection.domain.model.Omnibus;
import org.effrafax.comiccollection.domain.model.interfaces.comparators.NameableComparator;
import org.effrafax.comiccollection.domain.service.RetrievalService;

/**
 * @author dvberkel
 * 
 */
public class ComicsPanel extends Panel
{

	/** */
	private static final long serialVersionUID = 37L;

	public ComicsPanel(String id, final Long omnibusId)
	{
		super(id);
		addComicPanel(omnibusId);
		listComics(omnibusId);
	}

	private void addComicPanel(Long omnibusId)
	{
		add(new AddComicPanel("addComic", omnibusId));
	}

	private void listComics(final Long omnibusId)
	{
		Omnibus omnibus = RetrievalService.getOmnibus(omnibusId);
		List<Comic> comics = new ArrayList<Comic>(omnibus.getComics());
		Collections.sort(comics, new NameableComparator<Comic>());
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