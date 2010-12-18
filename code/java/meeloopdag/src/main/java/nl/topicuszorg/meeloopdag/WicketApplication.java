package nl.topicuszorg.meeloopdag;

import java.util.Locale;

import org.apache.wicket.Page;
import org.apache.wicket.Request;
import org.apache.wicket.Response;
import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebApplication;

/**
 * Application object for your web application. If you want to run this application without deploying, run the Start
 * class.
 * 
 * @see wicket.myproject.Start#main(String[])
 */
public class WicketApplication extends WebApplication
{
	/**
	 * Constructor
	 */
	public WicketApplication()
	{
	}

	/**
	 * @see wicket.Application#getHomePage()
	 */
	@Override
	public Class<? extends Page> getHomePage()
	{
		return HomePage.class;
	}

	@Override
	public Session newSession(Request request, Response response)
	{
		Session newSession = super.newSession(request, response);
		newSession.setLocale(new Locale("NL", "NL"));
		return newSession;
	}

}
