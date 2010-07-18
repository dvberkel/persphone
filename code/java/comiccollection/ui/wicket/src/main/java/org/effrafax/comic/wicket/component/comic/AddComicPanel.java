/**
 * 
 */
package org.effrafax.comic.wicket.component.comic;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.effrafax.comiccollection.domain.builder.ComicBuilder;
import org.effrafax.comiccollection.domain.service.CreationService;

/**
 * @author dvberkel
 * 
 */
public class AddComicPanel extends Panel
{
	/** */
	private static final long serialVersionUID = 37L;

	public AddComicPanel(String id, Long omnibusId)
	{
		super(id);
		createAddComicForm(omnibusId);
	}

	private void createAddComicForm(final Long omnibusId)
	{
		final ComicBuilder comicBuilder = new ComicBuilder();

		Form<ComicBuilder> form = new Form<ComicBuilder>("addComicForm", new CompoundPropertyModel<ComicBuilder>(
			comicBuilder))
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
				CreationService.addComic(omnibusId, getModelObject().getName());
			}
		};
		form.add(new TextField<String>("name"));

		add(form);
	}
}
