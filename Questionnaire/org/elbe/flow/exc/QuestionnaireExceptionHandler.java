package org.elbe.flow.exc;

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

import java.util.Locale;

import org.elbe.flow.servlets.impl.HtmlErrorPageImpl;
import org.hip.kernel.exc.DefaultExceptionHandler;
import org.hip.kernel.exc.ExceptionHandler;
import org.hip.kernel.exc.VException;
import org.hip.kernel.exc.VThrowable;
import org.hip.kernel.servlet.Context;
import org.hip.kernel.servlet.impl.AbstractHtmlPage;
import org.hip.kernel.sys.Assert;
import org.hip.kernel.sys.VSys;

/**
 * 	A implementation for an exception handler specific for the questionnaire application.
 * 
 * Created on 16.04.2003
 * @author Luthiger
 */
public class QuestionnaireExceptionHandler extends DefaultExceptionHandler {
	Context context = null;

	/**
	 * QuestionnaireExceptionHandler default constructor.
	 */
	public QuestionnaireExceptionHandler() {
		super();
	}

	/**
	 * Converts a Throwable to a QuestionnaireFatalException
	 * 
	 * @return java.lang.Throwable
	 * @param inThrowableToBeConverted java.lang.Throwable
	 * @see org.elbe.flow.exc.QuestionnaireFatalException
	 */
	public Throwable convert(Throwable inThrowableToBeConverted) {	
		return postProcess(inThrowableToBeConverted, new QuestionnaireFatalException(inThrowableToBeConverted.getMessage()));		
	}
	
	/**
	 * Converts a Throwable to a QuestionnaireFatalException
	 * 
	 * @return java.lang.Throwable
	 * @param inThrowableToBeConverted java.lang.Throwable
	 * @param inId java.lang.String Key/ID for localized exception message.
	 * @see org.elbe.flow.exc.QuestionnaireFatalException
	 */ 
	public Throwable convert(Throwable inThrowableToBeConverted, String inId) {
		return postProcess(inThrowableToBeConverted, new QuestionnaireFatalException(inId, null));
	}
	
	/**
	 * Converts a Throwable to a QuestionnaireWarningException
	 * 
	 * @return java.lang.Throwable
	 * @param inThrowableToBeConverted java.lang.Throwable
	 * @see org.elbe.flow.exc.QuestionnaireWarningException
	 */
	public Throwable convertToWarning(Throwable inThrowableToBeConverted) {
		return postProcess(inThrowableToBeConverted, new QuestionnaireWarningException(inThrowableToBeConverted.getMessage()));		
	}
	
	/**
	 * Converts a Throwable to a QuestionnaireWarningException
	 * 
	 * @return java.lang.Throwable
	 * @param inThrowableToBeConverted java.lang.Throwable
	 * @param inId java.lang.String
	 * @see org.elbe.flow.exc.QuestionnaireWarningException
	 */
	public Throwable convertToWarning(Throwable inThrowableToBeConverted, String inId) {
		return postProcess(inThrowableToBeConverted, new QuestionnaireWarningException(inId, null));
	}
	
	/**
	 * @param inThrowableToBeConverted java.lang.Throwable
	 * @param inVException org.hip.kernel.exc.VException
	 * @return java.lang.Throwable
	 */
	private Throwable postProcess(Throwable inThrowableToBeConverted, VException inVException) {
		inVException.setRootCause(inThrowableToBeConverted);
		inVException.fillInStackTrace();
		return (Throwable)inVException;
	}
	
	/**
	 * @return java.lang.String
	 * @param inThrowable java.lang.Throwable
	 */
	private String getLocalizedMessage(Throwable inThrowable) {
		
		//pre: throwable is of type VThrowable
		if (Assert.assert(this, "getLocalizedMessage", isVException(inThrowable))) return inThrowable.getMessage();
		
		return ((VThrowable)inThrowable).getLocalizedMessage(new Locale(context.getLanguage(), ""));
	}
	
	/**
	 * Method to handle all exceptions except warning exceptions.
	 * The ErrorPage is displayed with an accurate exception message.
	 * 
	 * @param inCatchingObject java.lang.Object
	 * @param inThrowable java.lang.Throwable
	 * @param inPrintStackTrace boolean
	 */
	private void handleOther(Object inCatchingObject, Throwable inThrowable, boolean inPrintStackTrace) {
		//log the error
		super.protectedHandle(null, inThrowable, inPrintStackTrace);
			
		String lMessage = (inThrowable instanceof VException ? getLocalizedMessage(inThrowable) : inThrowable.getMessage());
		context.setView(new HtmlErrorPageImpl(context, lMessage));
	}
	
	/**
	 * Method to handle warning exceptions. Such exceptions are handled by
	 * displaying the accurate warning message on the actual page.
	 * 
	 * @param inCatchingObject java.lang.Object
	 * @param inThrowable java.lang.Throwable
	 * @param inPrintStackTrace boolean
	 */
	private void handleWarningException(Object inCatchingObject, Throwable inThrowable, boolean inPrintStackTrace) {
	
		//no logging -> only tracing
		Throwable lThrowableToLog = inThrowable;
		
		if (inThrowable instanceof VException) {
			if (((VException)inThrowable).hasRootCause()) {
				lThrowableToLog = ((VException)inThrowable).getRootCause();
			}
		}
		VSys.tracer.trace(this, "handleWarningException", lThrowableToLog);
	
		//clear status message and generate error message on actual page
		AbstractHtmlPage lPage = (AbstractHtmlPage)context.getView();
		lPage.clearStatusMessage();
	
		if (inThrowable instanceof VException) {
			lPage.setErrorMessage(getLocalizedMessage(inThrowable));
		} 
		else {
			lPage.setErrorMessage(inThrowable.getMessage());
		}	
	}
	
	/**
	 * 	Returns an instance of this handler class.
	 * 
	 * 	@return org.hip.kernel.exc.ExceptionHandler
	 */
	static public ExceptionHandler instance() {	
		return new QuestionnaireExceptionHandler();
	}
	
	/**
	 * Implementation to handle the exceptions
	 *
	 * @param inCatchingObject java.lang.Object
	 * @param inThrowable java.lang.Throwable
	 * @param inPrintStackTrace boolean
	 */
	protected void protectedHandle(Object inCatchingObject, Throwable inThrowable, boolean inPrintStackTrace) {
	
		Assert.assert(this, "protectedHandle", context);
	
		//Dispatch exception type to belonging method.
		//
		//NOTE: if you add further handling for specific exception types
		//      pay attention to the order of the if statements.
		//      Specific exceptions type has to be detected first!
		
		if (inThrowable instanceof QuestionnaireWarningException) {
			handleWarningException(inCatchingObject, inThrowable, inPrintStackTrace);
		} 
		else {
			handleOther(inCatchingObject, inThrowable, inPrintStackTrace);
		}
	}
	
	/**
	 * @param inContext org.hip.kernel.servlet.Context
	 */
	public void setContext(Context inContext) {
		context = inContext;
	}
}
