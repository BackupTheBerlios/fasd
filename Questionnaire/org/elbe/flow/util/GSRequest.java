package org.elbe.flow.util;

/*
	This package is part of the questionnaire application.
	Copyright (C) 2003, Benno Luthiger

	This program is free software; you can redistribute it and/or modify
	it under the terms of the GNU General Public License as published by
	the Free Software Foundation; either version 2 of the License, or
	(at your option) any later version.

	This program is distributed in the hope that it will be useful,
	but WITHOUT ANY WARRANTY; without even the implied warranty of
	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
	GNU General Public License for more details.

	You should have received a copy of the GNU General Public License
	along with this program; if not, write to the Free Software
	Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
*/

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.elbe.flow.exc.QuestionnaireWarningException;
import org.hip.kernel.servlet.Context;

/**
 * This class sends a HTTP Request to the GNU Savannah site (savannah.gnu.org)
 *  
 * Created on 30.04.2003
 * @author Luthiger
 */
public class GSRequest extends AbstractHTTPRequest implements UserCheck {
	private final static String PROTOCOL = "http";
	private final static String HOST = "savannah.gnu.org";
	private final static int PORT = 80;
	private final static String FILE = "/users/";
	private final static int SITE_CODE = 2;

	/**
	 * SFRequest default constructor.
	 * 
	 */
	public GSRequest() {
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
		
		Pattern lPattern = Pattern.compile("General Information", Pattern.CASE_INSENSITIVE);
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
			String lMessage = getMessage("org.elbe.flow.msg.noConnection1", inContext) + " GNU Savannah " + getMessage("org.elbe.flow.msg.noConnection2", inContext);
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
