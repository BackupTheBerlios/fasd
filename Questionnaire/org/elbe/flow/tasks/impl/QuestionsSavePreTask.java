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

import java.math.BigDecimal;

import org.elbe.flow.bom.QuestionnairePre;
import org.elbe.flow.bom.QuestionnairePreHome;
import org.elbe.flow.exc.QuestionnaireExceptionHandler;
import org.elbe.flow.servlets.impl.DefaultHtmlPage;
import org.elbe.flow.servlets.impl.PretestView;
import org.hip.kernel.bom.BOMException;
import org.hip.kernel.exc.VException;
import org.hip.kernel.servlet.HtmlView;
import org.hip.kernel.servlet.impl.AbstractHtmlPage;
import org.hip.kernel.servlet.impl.CssLink;

/**
 * Pretest: Task to save the inputed data (i.e. the answers to the questions) 
 * to the database.
 * 
 * Created on 02.05.2003
 * @author Luthiger
 */
public class QuestionsSavePreTask extends AbstractQuestionnaireTask {

	/**
	 * QuestionsSaveTask default constructor.
	 * 
	 */
	public QuestionsSavePreTask() {
		super();
	}

	/**
	 * @see org.hip.kernel.servlet.Task#run()
	 */
	public void run() throws VException {
		QuestionnaireContext lContext = (QuestionnaireContext)getContext();
		try {
			//save data
			QuestionnairePreHome lHome = getQuestionnairePreHome();
			BigDecimal lID = lHome.saveData(lContext);
			QuestionnairePre lQuestionnaire = lHome.getQuestionnaire(lID);
			lContext.setQuestionnare(lQuestionnaire);
			
			//show pretest view
			HtmlView lView = new PretestView(lContext, lQuestionnaire);
			
			AbstractHtmlPage lPage = new DefaultHtmlPage();
			lPage.setCssLink(new CssLink("css/questionnaire.css"));
			lPage.add(lView);
	
			getContext().setView(lPage);
		}
		catch (BOMException exc) {
			throw (VException)QuestionnaireExceptionHandler.instance().convert(exc, "org.elbe.flow.errmsg.error.notSaved");
		}
		catch (Exception exc) {
			throw (VException)QuestionnaireExceptionHandler.instance().convert(exc, "org.elbe.flow.errmsg.error.contactAdmin");
		}
	}
}
