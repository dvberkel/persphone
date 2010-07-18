/**
 * 
 */
package org.effrafax.comic.wicket.component.omnibus;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.effrafax.comic.wicket.OmnibusPage;
import org.effrafax.comiccollection.domain.model.Omnibus;

/**
 * @author dvberkel
 * 
 */
public class OmnibusLink extends Panel
{

	/** */
	private static final long serialVersionUID = 37L;

	public OmnibusLink(String id, IModel<Omnibus> omnibusModel)
	{
		super(id);
		final Long omnibusId = omnibusModel.getObject().getId();
		Link<Void> omnibusLink = new Link<Void>("omnibusLink")
		{

			/** */
			private static final long serialVersionUID = 37L;

			@Override
			public void onClick()
			{

				setResponsePage(new OmnibusPage(omnibusId));
			}
		};
		omnibusLink.add(new Label("omnibus", String.format("Omnibus %d", omnibusId)));

		add(omnibusLink);
	}
}
