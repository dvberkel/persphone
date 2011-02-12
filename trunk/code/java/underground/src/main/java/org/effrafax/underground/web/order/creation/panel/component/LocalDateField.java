package org.effrafax.underground.web.order.creation.panel.component;

import org.apache.wicket.model.IModel;
import org.effrafax.underground.web.order.creation.panel.component.converter.AbstractDateTimeConverter;
import org.effrafax.underground.web.order.creation.panel.component.converter.LocalDateConverter;
import org.joda.time.LocalDate;

public class LocalDateField extends AbstractDateTimeField<LocalDate>
{
	private static final long serialVersionUID = 37L;

	public LocalDateField(String id)
	{
		super(id);
	}

	public LocalDateField(String id, IModel<LocalDate> localDateModel)
	{
		super(id, localDateModel);
	}

	@Override
	protected AbstractDateTimeConverter<LocalDate> initializeConverter()
	{
		return new LocalDateConverter();
	}
}
