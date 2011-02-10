package org.effrafax.underground.web.order.panel.component;

import org.apache.wicket.model.IModel;
import org.effrafax.underground.web.order.panel.component.converter.AbstractDateTimeConverter;
import org.effrafax.underground.web.order.panel.component.converter.LocalTimeConverter;
import org.joda.time.LocalTime;

public class LocalTimeField extends AbstractDateTimeField<LocalTime>
{
	private static final long serialVersionUID = 37L;

	public LocalTimeField(String id)
	{
		super(id);
	}

	public LocalTimeField(String id, IModel<LocalTime> localTimeModel)
	{
		super(id, localTimeModel);
	}

	@Override
	protected AbstractDateTimeConverter<LocalTime> initializeConverter()
	{
		return new LocalTimeConverter();
	}

}
