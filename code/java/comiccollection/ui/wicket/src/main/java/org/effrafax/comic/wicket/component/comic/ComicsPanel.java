/**
 * 
 */
package org.effrafax.comic.wicket.component.comic;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.effrafax.comiccollection.domain.model.Comic;
import org.effrafax.comiccollection.domain.model.Omnibus;
import org.effrafax.comiccollection.domain.model.interfaces.Nameable;
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
		List<Comic> comics = omnibus.getComics();
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

class NameableComparator<T extends Nameable> implements Comparator<T>
{

	@Override
	public int compare(T aNameable, T otherNameable)
	{
		if (aNameable == null && otherNameable == null)
		{
			return 0;
		}
		else if (aNameable == null && otherNameable != null)
		{
			return -1;
		}
		else if (aNameable != null && otherNameable == null)
		{
			return 1;
		}
		else
		{
			return aNameable.getName().compareTo(otherNameable.getName());
		}
	}

}
