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

import java.io.IOException;

import org.elbe.flow.exc.QuestionnaireWarningException;
import org.elbe.flow.servlets.impl.AskAnonymousView;
import org.elbe.flow.servlets.impl.DefaultHtmlPage;
import org.elbe.flow.util.UserCheck;
import org.hip.kernel.exc.VException;
import org.hip.kernel.servlet.HtmlView;
import org.hip.kernel.servlet.Task;
import org.hip.kernel.servlet.impl.CssLink;
import org.hip.kernel.sys.VSys;

/**
 * Task to process the login data.
 * 
 * Created on 22.04.2003
 * @author Luthiger
 */
public class LoginCheckTask extends AbstractQuestionnaireTask {
	//constants
	private static final String SF_SITE 			= "org.elbe.flow.util.SFRequest";
	private static final String USER_CHECK_PROPERTY = "org.hip.vif.login.check";

	/**
	 * LoginCheckTask default constructor.
	 * 
	 */
	public LoginCheckTask() {
		super();
	}

	/**
	 * @see org.hip.kernel.servlet.Task#run()
	 */
	public void run() throws VException {
		QuestionnaireContext lContext = (QuestionnaireContext)getContext();
		boolean lAnonymous = "on".equals(lContext.getParameterValue("anonymous"));
		String lUserId = lContext.getParameterValue("userId").trim();
		lAnonymous = (lUserId.length() == 0) || lAnonymous;
		String lLanguageCode = lContext.getParameterValue("language");
		lContext.setLanguage(lLanguageCode);
		lContext.setUserID(lUserId);
		lContext.setIsAnonymous(lAnonymous);
		UserCheck lCheck = setSite(lContext);
		
		try {
			if (!lAnonymous) {
				lCheck.checkUser(lUserId, lContext);
			}
			
			lContext.setTime(System.currentTimeMillis());
			
			//call the task after login
			Task lTask = TaskManagerImpl.getInstance().create("showQuestions");
			lTask.setContext(lContext);
			lTask.run();
		}
		catch (QuestionnaireWarningException exc) {
			//askAnonyomust
			DefaultHtmlPage lPage = new DefaultHtmlPage();
			HtmlView lView = new AskAnonymousView(lContext, exc.getMessage());
			lPage.add(lView);
			lPage.setCssLink(new CssLink("css/questionnaire.css"));
			lContext.setView(lPage);		
		}
	}
	
	private UserCheck setSite(QuestionnaireContext inContext) throws QuestionnaireWarningException {
		try {
			int lSiteCode = 0;
			String lSiteClass = VSys.getVSysProperties().getProperty(USER_CHECK_PROPERTY);
			Class lClass = Class.forName(lSiteClass);
			UserCheck outCheck = (UserCheck)lClass.newInstance();
			inContext.setSite(outCheck.getSiteCode());
			return outCheck;
		}
		catch (ClassNotFoundException exc) {
			throw new QuestionnaireWarningException(getMessage("org.elbe.flow.msg.wrongConfiguration"));			
		}
		catch (InstantiationException exc) {
			throw new QuestionnaireWarningException(getMessage("org.elbe.flow.msg.wrongConfiguration"));			
		}
		catch (IllegalAccessException exc) {
			throw new QuestionnaireWarningException(getMessage("org.elbe.flow.msg.wrongConfiguration"));			
		}
		catch (IOException exc) {
			throw new QuestionnaireWarningException(getMessage("org.elbe.flow.msg.wrongConfiguration"));
		}
	}
}
