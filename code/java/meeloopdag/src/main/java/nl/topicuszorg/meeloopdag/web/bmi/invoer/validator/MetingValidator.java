package nl.topicuszorg.meeloopdag.web.bmi.invoer.validator;

import nl.topicuszorg.meeloopdag.domain.meting.Meting;
import nl.topicuszorg.meeloopdag.domain.meting.eenheid.Eenheid;

import org.apache.wicket.validation.IValidatable;
import org.apache.wicket.validation.validator.AbstractValidator;

public class MetingValidator<T extends Eenheid> extends AbstractValidator<Meting<T>>
{
	private static final long serialVersionUID = 37L;

	public static <E extends Eenheid> MetingValidator<E> minimaal(Meting<E> meting)
	{
		return new MetingValidator<E>(meting);
	}

	private Meting<T> minimum;

	private MetingValidator(Meting<T> minimum)
	{
		this.minimum = minimum;
	}

	@Override
	protected void onValidate(IValidatable<Meting<T>> validatable)
	{
		Meting<T> value = validatable.getValue();
		if (value.compareTo(minimum) < 0)
		{
			error(validatable);
		}
	}
}
