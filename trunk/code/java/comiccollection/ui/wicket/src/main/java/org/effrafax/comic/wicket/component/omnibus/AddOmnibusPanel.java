/**
 * 
 */
package org.effrafax.comic.wicket.component.omnibus;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.Panel;
import org.effrafax.comic.wicket.ComicCollectionPage;
import org.effrafax.comiccollection.domain.service.CreationService;

/**
 * @author dvberkel
 * 
 */
public class AddOmnibusPanel extends Panel
{

	/** */
	private static final long serialVersionUID = 37L;

	public AddOmnibusPanel(String id)
	{
		super(id);
		add(new Form<Void>("addOmnibusForm")
		{

			/** */
			private static final long serialVersionUID = 37L;

			/*
			 * (non-Javadoc)
			 * 
			 * @see org.apache.wicket.markup.html.form.Form#onSubmit()
			 */
			@Override
			protected void onSubmit()
			{
				super.onSubmit();
				CreationService.createOmnibus();
				setResponsePage(new ComicCollectionPage(null));
			}
		});
	}
}
