package org.elbe.flow.util;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.elbe.flow.exc.QuestionnaireWarningException;
import org.hip.kernel.servlet.Context;

/**
 * This class sends a HTTP Request to the BerliOS site (berlios.de)
 *  
 * Created on 30.04.2003
 * @author Luthiger
 */
public class BORequest extends AbstractHTTPRequest implements UserCheck {
	private final static String PROTOCOL = "http";
	private final static String HOST = "developer.berlios.de";
	private final static int PORT = 80;
	private final static String FILE = "/users/";
	private final static int SITE_CODE = 3;

	/**
	 * BORequest default constructor.
	 * 
	 */
	public BORequest() {
		super();
	}
	
	/**
	 * Checks the user's user id.
	 * 
	 * @param inUserId java.lang.String
	 * @param inContext org.hip.kernel.servlet.Context
	 * @return boolean
	 * @throws QuestionnaireWarningException
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public boolean checkUser(String inUserId, Context inContext) throws QuestionnaireWarningException {
		String lWarning = getMessage("org.elbe.flow.msg.noVerification", inContext);

		String lResponse = getResponse(inUserId, inContext);
		
		Pattern lPattern = Pattern.compile("Personal Information", Pattern.CASE_INSENSITIVE);
		Matcher lMatcher = lPattern.matcher(lResponse);
		if (!lMatcher.find()) {
			throw new QuestionnaireWarningException(lWarning);
		}
		
		lPattern = Pattern.compile("User ID:", Pattern.CASE_INSENSITIVE);
		lMatcher = lPattern.matcher(lResponse);
		if (!lMatcher.find()) {
			throw new QuestionnaireWarningException(lWarning);
		}
		
		lPattern = Pattern.compile("Login Name:", Pattern.CASE_INSENSITIVE);
		lMatcher = lPattern.matcher(lResponse);
		if (!lMatcher.find()) {
			throw new QuestionnaireWarningException(lWarning);
		}
		
		lPattern = Pattern.compile(inUserId, Pattern.CASE_INSENSITIVE);
		lMatcher = lPattern.matcher(lResponse);
		if (!lMatcher.find()) {
			throw new QuestionnaireWarningException(lWarning);
		}
		
		return true;
	}

	/**
	 * Returns the response when the specified user name is requested.
	 * 
	 * @param inUserName java.lang.String
	 * @return java.lang.String
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public String getResponse(String inUserName, Context inContext) throws QuestionnaireWarningException {
		String outResponse = "";
		try {
			HttpURLConnection lConnection = createConnection(FILE + inUserName);
			outResponse = new String(readResponse(lConnection));
		}
		catch (MalformedURLException exc) {
			throw new QuestionnaireWarningException(getMessage("org.elbe.flow.msg.noCorrectInput", inContext));
		}
		catch (IOException exc) {
			String lMessage = getMessage("org.elbe.flow.msg.noConnection1", inContext) + " BerliOS " + getMessage("org.elbe.flow.msg.noConnection2", inContext);
			throw new QuestionnaireWarningException(lMessage);
		}
		return outResponse;
	}

	/**
	 * @return
	 */
	protected String getFILE() {
		return FILE;
	}

	/**
	 * @return
	 */
	protected String getHOST() {
		return HOST;
	}

	/**
	 * @return
	 */
	protected int getPORT() {
		return PORT;
	}

	/**
	 * @return
	 */
	protected String getPROTOCOL() {
		return PROTOCOL;
	}
	
	/**
	 * Returns the code identifying the site.
	 * 
	 * @return int
	 */
	public int getSiteCode() {
		return SITE_CODE;
	}
}
