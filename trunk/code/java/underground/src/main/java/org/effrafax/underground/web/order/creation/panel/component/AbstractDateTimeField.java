package org.effrafax.underground.web.order.creation.panel.component;

import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;
import org.apache.wicket.util.convert.IConverter;
import org.effrafax.underground.web.order.creation.panel.component.converter.AbstractDateTimeConverter;

public abstract class AbstractDateTimeField<T> extends TextField<T>
{
	private static final long serialVersionUID = 37L;

	private AbstractDateTimeConverter<T> converter;

	public AbstractDateTimeField(String id)
	{
		super(id);
	}

	public AbstractDateTimeField(String id, IModel<T> model)
	{
		super(id, model);
	}

	@Override
	public final IConverter getConverter(Class<?> type)
	{
		return converter;
	}

	@Override
	protected final void onInitialize()
	{
		super.onInitialize();
		converter = initializeConverter();
	}

	protected abstract AbstractDateTimeConverter<T> initializeConverter();
}