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

import org.hip.kernel.exc.VException;
import org.hip.kernel.servlet.Task;

/**
 * Pretest: initialize questionnaire.
 * 
 * Created on 22.04.2003
 * @author Luthiger
 */
public class LoginCheckPreTask extends AbstractQuestionnaireTask {
	//constants
	private static final String SF_SITE 			= "org.elbe.flow.util.SFRequest";
	private static final String USER_CHECK_PROPERTY = "org.hip.vif.login.check";

	/**
	 * LoginCheckTask default constructor.
	 * 
	 */
	public LoginCheckPreTask() {
		super();
	}

	/**
	 * @see org.hip.kernel.servlet.Task#run()
	 */
	public void run() throws VException {
		QuestionnaireContext lContext = (QuestionnaireContext)getContext();
		boolean lAnonymous = "on".equals(lContext.getParameterValue("anonymous"));
		String lUserId = lContext.getParameterValue("userId").trim();
		lAnonymous = (lUserId.length() == 0);
		String lLanguageCode = lContext.getParameterValue("language");
		lContext.setLanguage(lLanguageCode);
		lContext.setUserID(lUserId);
		lContext.setIsAnonymous(lAnonymous);
		lContext.setSite(5);
		lContext.setTime(System.currentTimeMillis());
			
		//call the task after login
		Task lTask = TaskManagerImpl.getInstance().create("showQuestions");
		lTask.setContext(lContext);
		lTask.run();

	}
}
