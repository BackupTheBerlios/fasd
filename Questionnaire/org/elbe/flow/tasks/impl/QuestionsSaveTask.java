package org.elbe.flow.tasks.impl;

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

import javax.servlet.http.HttpSession;

import org.elbe.flow.bom.QuestionnaireHome;
import org.elbe.flow.exc.QuestionnaireExceptionHandler;
import org.elbe.flow.servlets.impl.DefaultHtmlPage;
import org.elbe.flow.servlets.impl.FeedbackView;
import org.hip.kernel.bom.BOMException;
import org.hip.kernel.exc.VException;
import org.hip.kernel.servlet.HtmlView;
import org.hip.kernel.servlet.Task;
import org.hip.kernel.servlet.impl.AbstractContext;
import org.hip.kernel.servlet.impl.AbstractHtmlPage;
import org.hip.kernel.servlet.impl.CssLink;

/**
 * Task to save the inputed data (i.e. the answers to the questions) 
 * to the database.
 * 
 * Created on 02.05.2003
 * @author Luthiger
 */
public class QuestionsSaveTask extends AbstractQuestionnaireTask {
	private final static int ANONYMOUS_SITE = 4;

	/**
	 * QuestionsSaveTask default constructor.
	 * 
	 */
	public QuestionsSaveTask() {
		super();
	}

	/**
	 * @see org.hip.kernel.servlet.Task#run()
	 */
	public void run() throws VException {
		QuestionnaireContext lContext = (QuestionnaireContext)getContext();
		try {
			if (((Boolean)lContext.get("newSession")).booleanValue()) {
				initAnonymous(lContext);
			}
			else {
				if (lContext.getSite() == null) {
					throw new VException("org.elbe.flow.errmsg.error.savedYet", null);
				}
			}

			//pretest
			if (lContext.getSite().intValue() == 5) {
				Task lTask = TaskManagerImpl.getInstance().create("saveDataPre");
				lTask.setContext(lContext);
				lTask.run();
				return;
			}
			
			//save data
			QuestionnaireHome lHome = getQuestionnaireHome();
			lHome.saveData(lContext);
			
			//logout: invalidate session and remove all references
			HttpSession lSession = (HttpSession)lContext.get(AbstractContext.SESSION_NAME);
			lSession.removeAttribute(AbstractContext.CONTEXT);
			lSession.invalidate();

			//show feedback view
			HtmlView lView = new FeedbackView(lContext);
			
			AbstractHtmlPage lPage = new DefaultHtmlPage();
			lPage.setCssLink(new CssLink("css/questionnaire.css"));
			lPage.add(lView);
	
			getContext().setView(lPage);
		}
		catch (BOMException exc) {
			throw (VException)QuestionnaireExceptionHandler.instance().convert(exc, "org.elbe.flow.errmsg.error.notSaved");
		}
		catch (VException exc) {
			throw exc;
		}
		catch (Exception exc) {
			throw (VException)QuestionnaireExceptionHandler.instance().convert(exc, "org.elbe.flow.errmsg.error.contactAdmin");
		}
	}
	
	private void initAnonymous(QuestionnaireContext inContext) {
		inContext.setSite(ANONYMOUS_SITE);
		inContext.setLanguage(inContext.getParameterValue("language"));
		inContext.setUserID("anonymous_non_cookies");
		inContext.setIsAnonymous(true);
		inContext.setTime(System.currentTimeMillis());
	}
}
