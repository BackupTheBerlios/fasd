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

import org.elbe.flow.bom.QuestionnaireComHome;
import org.elbe.flow.bom.QuestionnaireHome;
import org.elbe.flow.bom.QuestionnairePreHome;
import org.elbe.flow.util.QuestionnaireSys;
import org.hip.kernel.servlet.impl.AbstractTask;
import org.hip.kernel.sys.VSys;

/**
 * 
 * Created on 01.05.2003
 * @author Luthiger
 */
abstract public class AbstractQuestionnaireTask extends AbstractTask {
	//constants
	private static final String QUESTIONNAIRE_HOME_CLASS_NAME 		= "org.elbe.flow.bom.QuestionnaireHomeImpl";
	private static final String QUESTIONNAIRE_PRE_HOME_CLASS_NAME 	= "org.elbe.flow.bom.QuestionnairePreHomeImpl";
	private static final String QUESTIONNAIRE_COM_HOME_CLASS_NAME 	= "org.elbe.flow.bom.QuestionnaireComHomeImpl";

	/**
	 * AbstractQuestionnaireTask default constructor.
	 * 
	 */
	public AbstractQuestionnaireTask() {
		super();
	}

	/**
	 * Returns a message to a given ID, language dependent
	 *
	 * @return java.lang.String
	 * @param inMsgId java.lang.String
	 */
	protected String getMessage(String inMsgId) {
		return QuestionnaireSys.getMessage(getContext().getLanguage(), inMsgId);
	}
	
	protected QuestionnaireHome getQuestionnaireHome() {
		return (QuestionnaireHome)VSys.homeManager.getHome(QUESTIONNAIRE_HOME_CLASS_NAME);
	}

	protected QuestionnairePreHome getQuestionnairePreHome() {
		return (QuestionnairePreHome)VSys.homeManager.getHome(QUESTIONNAIRE_PRE_HOME_CLASS_NAME);
	}

	protected QuestionnaireComHome getQuestionnaireComHome() {
		return (QuestionnaireComHome)VSys.homeManager.getHome(QUESTIONNAIRE_COM_HOME_CLASS_NAME);
	}
}
