package org.elbe.flow.util;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.hip.kernel.servlet.Context;

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

/**
 * Abstract class for HTTP Requests.
 * 
 * Created on 30.04.2003
 * @author Luthiger
 */
public abstract class AbstractHTTPRequest {

	/**
	 * AbstractHTTPRequest default constructor.
	 * 
	 */
	public AbstractHTTPRequest() {
		super();
	}
	
	protected HttpURLConnection createConnection(String inFile) throws MalformedURLException, IOException {
		HttpURLConnection outConnection = null;
		URL lUrl = new URL(getPROTOCOL(), getHOST(), getPORT(), inFile);
		outConnection = (HttpURLConnection)lUrl.openConnection();
		outConnection.setRequestProperty("Connection", "close");
		outConnection.setRequestMethod("GET");
		return outConnection;
	}
	
	protected byte[] readResponse(HttpURLConnection inConnection) throws IOException {
		byte[] lBuffer = new byte[4096];
		BufferedInputStream lInStream;
		try	{
			lInStream = new BufferedInputStream(inConnection.getInputStream());
		}
		catch (Exception exc) {
			lInStream = new BufferedInputStream(inConnection.getErrorStream());
		}
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		int i = 0;
		while ((i = lInStream.read(lBuffer)) > -1) {
			outStream.write(lBuffer, 0, i);
		}
		lInStream.close();
		outStream.flush();
		outStream.close();
		return outStream.toByteArray();		
	}
	
	/**
	 * @return
	 */
	abstract protected String getFILE();

	/**
	 * @return
	 */
	abstract protected String getHOST();

	/**
	 * @return
	 */
	abstract protected int getPORT();

	/**
	 * @return
	 */
	abstract protected String getPROTOCOL();
	

	/**
	 * Returns a message to a given ID, language dependent
	 *
	 * @return java.lang.String
	 * @param inMsgId java.lang.String
	 * @param inContext org.hip.kernel.servlet.Context
	 */
	protected String getMessage(String inMsgId, Context inContext) {
		return QuestionnaireSys.getMessage(inContext.getLanguage(), inMsgId);
	}
}
