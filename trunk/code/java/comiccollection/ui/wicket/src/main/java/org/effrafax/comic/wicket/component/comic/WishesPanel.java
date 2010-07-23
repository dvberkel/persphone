/**
 * 
 */
package org.effrafax.comic.wicket.component.comic;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.effrafax.comiccollection.domain.model.Comic;

/**
 * @author dvberkel
 * 
 */
public class WishesPanel extends Panel
{
	/** */
	private static final long serialVersionUID = 37L;

	public WishesPanel(String id, IModel<Comic> model)
	{
		super(id, model);
		addWishes(model);
	}

	private void addWishes(IModel<Comic> model)
	{
		List<Integer> indices = new ArrayList<Integer>(model.getObject().getWishes());
		add(new ListView<Integer>("wishList", indices)
		{
			/** */
			private static final long serialVersionUID = 37L;

			@Override
			protected void populateItem(ListItem<Integer> item)
			{
				item.add(new Label("index", item.getModelObject().toString()));
			}
		});
	}
}
