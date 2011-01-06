package nl.topicuszorg.experience.web.bmi.invoer;

import static nl.topicuszorg.experience.domain.meting.eenheid.Eenheid.gram;
import nl.topicuszorg.experience.domain.meting.eenheid.Gram;

public class GewichtMetingInvoerPanel extends AbstractMetingInvoerPanel<Gram>
{
	private static final long serialVersionUID = 37L;

	public GewichtMetingInvoerPanel(String id)
	{
		super(id);
		init();
	}

	@Override
	protected Gram getEenheid()
	{
		return gram();
	}
}
