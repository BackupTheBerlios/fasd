package org.elbe.flow.bom;

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

import java.sql.SQLException;

import org.elbe.flow.tasks.impl.QuestionnaireContext;
import org.hip.kernel.bom.impl.DomainObjectImpl;
import org.hip.kernel.exc.VException;

/**
 * Pretest
 * 
 * Created on 02.05.2003
 * @author Luthiger
 */
public class QuestionnairePreImpl extends DomainObjectImpl implements QuestionnairePre {
	private final static String HOME_CLASS_NAME = "org.elbe.flow.bom.QuestionnairePreHomeImpl";

	public QuestionnairePreImpl() {
		super();
	}

	public String getHomeClassName() {
		return HOME_CLASS_NAME;
	}
	
	public void saveData(QuestionnaireContext inContext) throws VException, SQLException {
		String[] lQuestions = {"q1_pre", "q3_pre", "q5_pre", "q6_pre", "q10_pre", "q11_pre", "q13_1_pre", "q13_2_pre", "q21_pre", "q29_pre", "q30_pre", "q31_1_pre", "q31_2_pre", "q33_pre", "q35f_pre", "q35_pre", "q36a_pre", "q36e_pre", "q36_pre", "q36_pre2", "q37_1_pre", "q37_2_pre", "q38_pre", "q39_1_pre", "q39_2_pre", "q40_pre", "q41_pre", "q46_pre", "q47_pre", "q_pre_1", "q_pre_2", "q_pre_3", "q_pre_4"};
		for (int i = 0; i < lQuestions.length; i++) {
			set(lQuestions[i], inContext.getParameterValue(lQuestions[i]));
		}
		update(true);
	}
}
