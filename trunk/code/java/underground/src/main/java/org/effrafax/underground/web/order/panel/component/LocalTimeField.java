package org.effrafax.underground.web.order.panel.component;

import org.apache.wicket.markup.html.form.TextField;
import org.joda.time.LocalTime;

public class LocalTimeField extends TextField<LocalTime>
{
	private static final long serialVersionUID = 37L;

	public LocalTimeField(String id)
	{
		super(id);
	}

}
