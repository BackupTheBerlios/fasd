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

import java.math.BigDecimal;

import org.elbe.flow.tasks.impl.QuestionnaireContext;
import org.hip.kernel.bom.BOMException;
import org.hip.kernel.bom.DomainObjectHome;
import org.hip.kernel.exc.VException;

/**
 * Pretest
 * 
 * Created on 02.05.2003
 * @author Luthiger
 */
public interface QuestionnairePreHome extends DomainObjectHome {
	public final static String KEY_ID = "QuestionnaireID";

	BigDecimal saveData(QuestionnaireContext inContext) throws BOMException;
	QuestionnairePre getQuestionnaire(BigDecimal inQuestionnaireID) throws VException;
	QuestionnairePre initQuestionnaire() throws VException;
}
