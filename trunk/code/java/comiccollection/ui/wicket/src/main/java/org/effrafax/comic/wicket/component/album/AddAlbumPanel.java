/**
 * 
 */
package org.effrafax.comic.wicket.component.album;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.effrafax.comic.wicket.ComicPage;
import org.effrafax.comiccollection.domain.builder.AlbumBuilder;
import org.effrafax.comiccollection.domain.model.Comic;
import org.effrafax.comiccollection.domain.service.CreationService;

/**
 * @author dvberkel
 * 
 */
public class AddAlbumPanel extends Panel
{

	/** */
	private static final long serialVersionUID = 37L;

	public AddAlbumPanel(String id, Long omnibusId, IModel<Comic> comicModel)
	{
		super(id);
		createAddAlbumForm(omnibusId, comicModel);
	}

	private void createAddAlbumForm(final Long omnibusId, final IModel<Comic> comicModel)
	{
		final AlbumBuilder albumBuilder = new AlbumBuilder();

		Form<AlbumBuilder> form = new Form<AlbumBuilder>("addAlbumForm", new CompoundPropertyModel<AlbumBuilder>(
			albumBuilder))
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
				CreationService.addAlbum(comicModel.getObject().getId(), getModelObject().getIndex(), getModelObject()
					.getName());
				setResponsePage(new ComicPage(omnibusId, comicModel.getObject().getId()));
			}
		};
		form.add(new TextField<Integer>("index").setRequired(true));
		form.add(new TextField<String>("name").setRequired(true));
		add(form);
	}
}
