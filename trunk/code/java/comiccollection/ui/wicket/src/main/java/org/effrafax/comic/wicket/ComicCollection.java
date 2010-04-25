package org.effrafax.comic.wicket;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;

/**
 * Homepage
 */
public class ComicCollection extends WebPage {

	private static final long serialVersionUID = 37L;

	// TODO Add any page properties or variables here

    /**
	 * Constructor that is invoked when page is invoked without a session.
	 * 
	 * @param parameters
	 *            Page parameters
	 */
    public ComicCollection(final PageParameters parameters) {

        // Add the simplest type of label
        add(new Label("message", "If you see this message wicket is properly configured and running"));

        // TODO Add your page's components here
    }
}
