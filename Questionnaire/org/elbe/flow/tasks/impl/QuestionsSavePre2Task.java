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

import org.elbe.flow.bom.QuestionnairePre;
import org.elbe.flow.exc.QuestionnaireExceptionHandler;
import org.elbe.flow.servlets.impl.DefaultHtmlPage;
import org.elbe.flow.servlets.impl.FeedbackView;
import org.hip.kernel.bom.BOMException;
import org.hip.kernel.exc.VException;
import org.hip.kernel.servlet.HtmlView;
import org.hip.kernel.servlet.impl.AbstractContext;
import org.hip.kernel.servlet.impl.AbstractHtmlPage;
import org.hip.kernel.servlet.impl.CssLink;
import org.hip.kernel.sys.VSys;

/**
 * Pretest: Task to save the inputed data of the real pretest 
 * to the database.
 * 
 * Created on 02.05.2003
 * @author Luthiger
 */
public class QuestionsSavePre2Task extends AbstractQuestionnaireTask {

	public QuestionsSavePre2Task() {
		super();
	}

	public void run() throws VException {
		QuestionnaireContext lContext = (QuestionnaireContext)getContext();
		try {
			//save data
			QuestionnairePre lQuestionnaire = (QuestionnairePre)lContext.getQuestionnare();
			if (lQuestionnaire == null) {
				lQuestionnaire = getQuestionnairePreHome().initQuestionnaire();
			}
			lQuestionnaire.saveData(lContext);
			
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
			logQuestions(lContext);
			throw (VException)QuestionnaireExceptionHandler.instance().convert(exc, "org.elbe.flow.errmsg.error.notSaved");
		}
		catch (VException exc) {
			logQuestions(lContext);
			throw exc;
		}
		catch (Exception exc) {
			logQuestions(lContext);
			throw (VException)QuestionnaireExceptionHandler.instance().convert(exc, "org.elbe.flow.errmsg.error.contactAdmin");
		}
	}
	
	private void logQuestions(QuestionnaireContext inContext) {
		String lNL = System.getProperty("line.separator");
		StringBuffer lLog = new StringBuffer();
		String[] lQuestions = {"q1_pre", "q3_pre", "q5_pre", "q6_pre", "q10_pre", "q11_pre", "q13_1_pre", "q13_2_pre", "q21_pre", "q29_pre", "q30_pre", "q31_1_pre", "q31_2_pre", "q33_pre", "q35f_pre", "q35_pre", "q36a_pre", "q36e_pre", "q36_pre", "q36_pre2", "q37_1_pre", "q37_2_pre", "q38_pre", "q39_1_pre", "q39_2_pre", "q40_pre", "q41_pre", "q46_pre", "q47_pre", "q_pre_1", "q_pre_2", "q_pre_3", "q_pre_4"};
		for (int i = 0; i < lQuestions.length; i++) {
			lLog.append(lQuestions[i]).append(": ").append(inContext.getParameterValue(lQuestions[i])).append(lNL);
		}
		VSys.log(new String(lLog));
	}
}
