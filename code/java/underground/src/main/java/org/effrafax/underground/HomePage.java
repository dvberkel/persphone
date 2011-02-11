package org.effrafax.underground;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.effrafax.underground.web.order.overview.OrderOverviewPage;

/**
 * Homepage
 */
public class HomePage extends WebPage
{

	private static final long serialVersionUID = 1L;

	// TODO Add any page properties or variables here

	/**
	 * Constructor that is invoked when page is invoked without a session.
	 * 
	 * @param parameters
	 *            Page parameters
	 */
	public HomePage(final PageParameters parameters)
	{

		// Add the simplest type of label
		add(new Label("message", "If you see this message wicket is properly configured and running"));

		// TODO Add your page's components here
		add(new Link<Void>("test-page")
		{
			private static final long serialVersionUID = 37L;

			@Override
			public void onClick()
			{
				setResponsePage(OrderOverviewPage.class);
			}
		});
	}
}
