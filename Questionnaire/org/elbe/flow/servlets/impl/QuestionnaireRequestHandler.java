package org.elbe.flow.servlets.impl;

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

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.elbe.flow.exc.QuestionnaireExceptionHandler;
import org.elbe.flow.tasks.impl.TaskManagerImpl;

import org.hip.kernel.exc.ExceptionHandler;
import org.hip.kernel.servlet.Context;
import org.hip.kernel.servlet.HtmlView;
import org.hip.kernel.servlet.TaskManager;
import org.hip.kernel.servlet.impl.AbstractContext;
import org.hip.kernel.servlet.impl.AbstractHtmlPage;
import org.hip.kernel.servlet.impl.AbstractHtmlView;
import org.hip.kernel.servlet.impl.AbstractRequestHandler;
import org.hip.kernel.sys.VSys;

/**
 * Request handler for the flow questionnaire.
 * This class wraps the servlet object.
 * 
 * Created on 16.04.2003
 * @author Luthiger
 */
public class QuestionnaireRequestHandler extends AbstractRequestHandler {
	//constants
	private static final String SYS_NAME = "flow";
	private static final String CONTEXT_CLASSNAME = "org.elbe.flow.tasks.impl.QuestionnaireContext";	
	private static final String SMOKE_REQUEST = "smoke";

	/**
	 * QuestionnaireRequestHandler default constructor.
	 */
	public QuestionnaireRequestHandler() {
		super();
	}

	/**
	 * Returns class name of the Context-class used in the VIF administration.
	 *
	 * @return java.lang.String
	 */
	protected String getContextClassName() {
		return CONTEXT_CLASSNAME;
	}

	/**
	 * Returns singelton task manager of the sample.
	 *
	 * @return org.hip.kernel.servlet.TaskManager
	 */
	protected TaskManager getTaskManager() {
		return TaskManagerImpl.getInstance();
	}

	/**
	 * Handles GET-Requests.
	 *
	 * @param inRequest javax.servlet.http.HttpServletRequest
	 * @param inResponse javax.servlet.http.HttpServletResponse
	 * @exception javax.servlet.ServletException
	 * @exception java.io.IOException
	 */ 
	public void doGet(HttpServletRequest inRequest, HttpServletResponse inResponse) throws ServletException, IOException {
		try {
			super.doGet(inRequest, inResponse);
		} 
		catch (Throwable exc) {
			this.handle(getContext(inRequest), exc);
		}
	}
	
	/**
	 * Handles POST-Requests.
	 *
	 * @param inRequest javax.servlet.http.HttpServletRequest
	 * @param inResponse javax.servlet.http.HttpServletResponse
	 * @exception javax.servlet.ServletException
	 * @exception java.io.IOException
	 */
	public void doPost(HttpServletRequest inRequest, HttpServletResponse inResponse) throws ServletException, IOException {
		try {
			super.doPost(inRequest, inResponse);
		} 
		catch (Throwable ex) {
			this.handle(getContext(inRequest), ex);
		}
	}

	/**
	 * @param inHandler 	org.hip.kernel.exc.ExceptionHandler
	 * @param inContext		org.hip.kernel.servlet.Context
	 * @param inThrowable 	java.lang.Throwable
	 */
	private void callExceptionHandler(ExceptionHandler inHandler, Context inContext, Throwable inThrowable) {
	
		QuestionnaireExceptionHandler lHandler = (QuestionnaireExceptionHandler)inHandler;
		
		lHandler.setContext(inContext);
		lHandler.handle(inContext, inThrowable);	
	}
	
	/**
	 * @param inContext 	org.hip.kernel.servlet.Context
	 * @param inThrowable 	java.lang.Throwable
	 */
	protected void handle(org.hip.kernel.servlet.Context inContext, Throwable inThrowable) {
		
		//handling of errors
		if(inThrowable instanceof org.hip.kernel.exc.VException) {
			callExceptionHandler(QuestionnaireExceptionHandler.instance(), inContext, inThrowable);
		}
		else if(inThrowable instanceof org.hip.kernel.exc.VRuntimeException) {
			callExceptionHandler(QuestionnaireExceptionHandler.instance(), inContext, inThrowable);				
		} 
		else if(inThrowable instanceof org.hip.kernel.exc.VError) {
			callExceptionHandler(QuestionnaireExceptionHandler.instance(), inContext, inThrowable);		
		} 
		else {
			callExceptionHandler(QuestionnaireExceptionHandler.instance(), inContext, inThrowable);
		}
	}

	/**
	 * Checks the request type.
	 * 
	 * @param inRequestType java.lang.String
	 * @return boolean true, if inRequestType is smoke test.
	 */
	protected boolean requestTypeCheck(String inRequestType) {
		return SMOKE_REQUEST.equals(inRequestType);
	}
	
	/**
	 * Returns the name of the application's properties file.
	 * 
	 * @return java.lang.String
	 */
	protected String getSysName() {
		return SYS_NAME;
	}
	
	/**
	 * Process the smoke test.
	 * 
	 * @param inContext org.hip.kernel.servlet.Context
	 * @param inResponse javax.servlet.http.HttpServletResponse
	 * @throws java.lang.Exception
	 */
	protected void subRequestTypeHandler(Context inContext, HttpServletResponse inResponse) throws Exception {
		HtmlView lView = new AbstractHtmlView() {
			public void renderToStream(ServletOutputStream inStream) {
				Version lVersion = new Version();
				try {
					ServletContext lContext = getServletContext();
					String lProperty = "";
					inStream.println("<h2>Version Questionnaire Application</h2>");
					inStream.println("<b>Questionnaire:</b> " + lVersion.getVersion() + "<br/>");
					inStream.println("<b>Framework:</b> " + lVersion.getFrameworkVersion() + "<br/>");
					inStream.println("<h3>Servlet Container: " + lContext.getServerInfo() + "</h3>");
					inStream.println("<b>Tomcat Home:</b> " + ((lProperty=System.getProperty("catalina.home"))==null ? "-" : lProperty) + "<br/>");
					inStream.println("<b>Tomcat Base:</b> " + ((lProperty=System.getProperty("catalina.base"))==null ? "-" : lProperty) + "<br/>");
					inStream.println("<b>User Home:</b> " + System.getProperty("user.dir") + "<br/>");
					inStream.println("<b>Servlet Context:</b> " + lContext.getRealPath("/") + "<br/>");
					
					inStream.println("<h3>Java</h3>");
					inStream.println("<p><b>Vendor:</b> " + System.getProperty("java.vendor") + "<br/>");
					inStream.println("<b>Version:</b> " + System.getProperty("java.version") + "<br/>");
					inStream.println("<b>Version Virtual Machine:</b> " + System.getProperty("java.vm.version") + "<br/>");
					inStream.println("<b>Version Runtime:</b> " + System.getProperty("java.runtime.version") + "<br/>");
					inStream.println("<b>Java Home:</b> " + System.getProperty("java.home") + "<br/>");
					inStream.println("<b>Class Path:</b> " + System.getProperty("java.class.path") + "<br/>");
					inStream.println("<b>Library Path:</b> " + System.getProperty("java.library.path") + "<br/>");
					inStream.println("<b>Packages:</b> " + getPackages() + "<br/>");
					inStream.println("<b>OS:</b> " + System.getProperty("os.name") + "</p>");
				} 
				catch (Exception exc) {
					VSys.tracer.trace(this, "showMemoryInfo", "error during preparing memory info");
					VSys.tracer.trace(this, "showMemoryInfo", exc);				
				}
			}
			protected String getXMLName() {
				return null;
			}
		};
		
		AbstractHtmlPage lPage = new DefaultHtmlPage();
		lPage.setCssStyle("<style type='text/css'><!-- body {font-family: Verdana, Arial, geneva, helvetica, sans-serif;} //--></style>\n");
		lPage.add(lView);
	
		inContext.set(AbstractContext.VIEW, lPage);
	}
	
	private String getPackages() {
		StringBuffer outPackages = new StringBuffer();
		Package[] lPackages = Package.getPackages();
		for (int i = 0; i < lPackages.length; i++) {
			Package lPackage = lPackages[i];
			outPackages.append(lPackage.getName());
			if (lPackage.isSealed()) {
				outPackages.append(" (*)");
			}
			outPackages.append("; ");
		}
		return new String(outPackages);
	}
}
