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

import org.hip.kernel.exc.VException;
import org.hip.kernel.servlet.Task;
import org.hip.kernel.servlet.impl.AbstractContext;
import org.hip.kernel.servlet.impl.RedirectPage;

/**
 * Checks the input after the user has been asked whether she will continue
 * as anonymous.
 * 
 * Created on 01.05.2003
 * @author Luthiger
 */
public class FollowUpCheckTask extends AbstractQuestionnaireTask {

	/**
	 * FollowUpCheckTask default constructor.
	 * 
	 */
	public FollowUpCheckTask() {
		super();
	}

	/**
	 * @see org.hip.kernel.servlet.Task#run()
	 */
	public void run() throws VException {
		QuestionnaireContext lContext = (QuestionnaireContext)getContext();
		boolean lNext = (lContext.getParameterValue("back").length() == 0);
		
		if (lNext) {
			lContext.setTime(System.currentTimeMillis());
			lContext.setIsAnonymous(true);
			
			//show the questions
			Task lTask = TaskManagerImpl.getInstance().create("showQuestions");
			lTask.setContext(lContext);
			lTask.run();
		}
		else {
			//logout: invalidate session and remove all references
			HttpSession lSession = (HttpSession)lContext.get(AbstractContext.SESSION_NAME);
			lSession.removeAttribute(AbstractContext.CONTEXT);
			lSession.invalidate();

			//show login form again through the redirect page
			RedirectPage lPage = new RedirectPage(lContext, "./");
			lContext.setView(lPage);
		}
	}
}
