package org.effrafax.comic.wicket;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.effrafax.comiccollection.domain.model.Omnibus;
import org.effrafax.comiccollection.domain.service.RetrievalService;

/**
 * Homepage
 */
public class ComicCollection extends WebPage {

	/** */
	private static final long serialVersionUID = 37L;

	/**
	 * Constructor that is invoked when page is invoked without a session.
	 * 
	 * @param parameters
	 *            Page parameters
	 */
	public ComicCollection(final PageParameters parameters) {

		add(new Label("message", "If you see this message wicket is properly configured and running"));

		showOmnibusses();
	}

	/**
	 * Shows all the {@link Omnibus}ses.
	 */
	private void showOmnibusses() {

		List<Omnibus> omnibusses = new ArrayList<Omnibus>();
		omnibusses.addAll(RetrievalService.getAllOmnibusses());
		add(new ListView<Omnibus>("omnibusses", omnibusses) {

			/** */
			private static final long serialVersionUID = 37L;

			@Override
			protected void populateItem(ListItem<Omnibus> item) {

				Omnibus omnibus = item.getModelObject();
				final Long omnibusId = omnibus.getId();
				Link<Void> omnibusLink = new Link<Void>("omnibusLink") {

					/** */
					private static final long serialVersionUID = 37L;

					@Override
					public void onClick() {

						setResponsePage(new OmnibusPage(omnibusId));
					}
				};
				omnibusLink.add(new Label("omnibus", String.format("Omnibus %d", omnibus.getId())));

				item.add(omnibusLink);
			}
		});
	}
}
