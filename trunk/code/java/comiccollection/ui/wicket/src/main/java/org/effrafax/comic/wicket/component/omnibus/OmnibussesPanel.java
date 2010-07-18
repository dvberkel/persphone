/**
 * 
 */
package org.effrafax.comic.wicket.component.omnibus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.effrafax.comiccollection.domain.model.Omnibus;
import org.effrafax.comiccollection.domain.service.RetrievalService;

/**
 * @author dvberkel
 * 
 */
public class OmnibussesPanel extends Panel
{

	/** */
	private static final long serialVersionUID = 37L;

	public OmnibussesPanel(String id)
	{
		super(id);
		List<Omnibus> omnibusses = new ArrayList<Omnibus>();
		omnibusses.addAll(RetrievalService.getAllOmnibusses());
		Collections.sort(omnibusses, new OmnibusComparator());
		add(new ListView<Omnibus>("omnibusses", omnibusses)
		{

			/** */
			private static final long serialVersionUID = 37L;

			@Override
			protected void populateItem(ListItem<Omnibus> item)
			{
				item.add(new OmnibusLink("omnibusLink", item.getModel()));
			}
		});
	}
}

class OmnibusComparator implements Comparator<Omnibus>
{

	@Override
	public int compare(Omnibus thisOmnibus, Omnibus thatOmnibus)
	{
		if (thisOmnibus == null && thatOmnibus == null)
		{
			return 0;
		}
		else if (thisOmnibus == null && thatOmnibus != null)
		{
			return -1;
		}
		else if (thisOmnibus != null && thatOmnibus == null)
		{
			return 1;
		}
		else
		{
			return thisOmnibus.getId().compareTo(thatOmnibus.getId());
		}
	}
}