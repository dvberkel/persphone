/**
 * 
 */
package org.effrafax.comic.wicket.component.omnibus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.effrafax.comiccollection.domain.model.Omnibus;
import org.effrafax.comiccollection.domain.model.interfaces.comparators.IdentifiableComparator;
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
		addOmnibusPanel();
		listOmnibusses();
	}

	private void addOmnibusPanel()
	{
		add(new AddOmnibusPanel("addOmnibus"));
	}

	private void listOmnibusses()
	{
		List<Omnibus> omnibusses = new ArrayList<Omnibus>();
		omnibusses.addAll(RetrievalService.getAllOmnibusses());
		Collections.sort(omnibusses, new IdentifiableComparator<Omnibus>());
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