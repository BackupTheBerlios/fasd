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

import org.elbe.flow.bom.QuestionnaireCom;
import org.elbe.flow.exc.QuestionnaireWarningException;
import org.elbe.flow.servlets.impl.AnsweredYetView;
import org.elbe.flow.servlets.impl.DefaultHtmlPage;
import org.elbe.flow.servlets.impl.LoginFailedView;
import org.hip.kernel.bom.BOMNotFoundException;
import org.hip.kernel.exc.VException;
import org.hip.kernel.servlet.Context;
import org.hip.kernel.servlet.HtmlView;
import org.hip.kernel.servlet.Task;
import org.hip.kernel.servlet.impl.AbstractContext;
import org.hip.kernel.servlet.impl.CssLink;

/**
 * Task to process the login data, qcom version.
 * 
 * Created on 22.04.2003
 * @author Luthiger
 */
public class LoginCheckQcomTask extends AbstractQuestionnaireTask {

	/**
	 * LoginCheckQcomTask default constructor.
	 * 
	 */
	public LoginCheckQcomTask() {
		super();
	}

	/**
	 * @see org.hip.kernel.servlet.Task#run()
	 */
	public void run() throws VException {
		QuestionnaireContext lContext = (QuestionnaireContext)getContext();
		String lUserId = lContext.getParameterValue("userLogin").trim();
		String lPasswrd = lContext.getParameterValue("userPwrd").trim();
		String lLanguageCode = lContext.getParameterValue("language");
		lContext.setLanguage(lLanguageCode);
		lContext.setUserID(lUserId);
		
		try {
			QuestionnaireCom lQuestionnaire  = getQuestionnaireComHome().getQuestionnaire(lUserId);
			if (lQuestionnaire.checkPasswrd(lPasswrd)) {
				if (lQuestionnaire.checkNotAnswered()) {
					lContext.setQuestionnare(lQuestionnaire);
					lContext.setTime(System.currentTimeMillis());
			
					//call the task after login
					Task lTask = TaskManagerImpl.getInstance().create("showQuestionsCom");
					lTask.setContext(lContext);
					lTask.run();
				}
				else {
					//showAnsweredYet view
					setView(new AnsweredYetView(lContext), lContext);
					logout(lContext);
				}
			}
			else {
				throw new QuestionnaireWarningException(getMessage("org.elbe.flow.msg.wrongCredentials"));
			}
		}
		catch (QuestionnaireWarningException exc) {
			//couldNotLogin view
			setView(new LoginFailedView(lContext, exc.getMessage()), lContext);
			logout(lContext);
		}
		catch (BOMNotFoundException exc) {
			setView(new LoginFailedView(lContext, getMessage("org.elbe.flow.msg.unknownUser")), lContext);
			logout(lContext);
		}
	}
	
	private void logout(Context inContext) {
		//logout: invalidate session and remove all references
		HttpSession lSession = (HttpSession)inContext.get(AbstractContext.SESSION_NAME);
		lSession.removeAttribute(AbstractContext.CONTEXT);
		lSession.invalidate();
	}
	
	private void setView(HtmlView inView, Context inContext) {
		DefaultHtmlPage lPage = new DefaultHtmlPage();
		lPage.add(inView);
		lPage.setCssLink(new CssLink("css/questionnaire.css"));
		inContext.setView(lPage);		
	}
}
