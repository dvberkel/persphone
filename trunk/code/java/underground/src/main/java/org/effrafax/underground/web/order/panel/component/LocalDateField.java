package org.effrafax.underground.web.order.panel.component;

import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;
import org.joda.time.LocalDate;

public class LocalDateField extends TextField<LocalDate>
{
	private static final long serialVersionUID = 37L;

	public LocalDateField(String id)
	{
		super(id);
	}

	public LocalDateField(String id, PropertyModel<LocalDate> propertyModel)
	{
		super(id, propertyModel);
	}
}
