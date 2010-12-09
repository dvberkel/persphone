package nl.topicuszorg.meeloopdag;

import nl.topicuszorg.meeloopdag.web.BMIPage;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;

/**
 * Homepage
 */
public class HomePage extends WebPage
{

	private static final long serialVersionUID = 1L;

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

		add(new Link<Void>("bmipage")
		{
			private static final long serialVersionUID = 37L;

			@Override
			public void onClick()
			{
				setResponsePage(BMIPage.class);
			}
		});
	}
}
