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

import org.elbe.flow.exc.QbomException;
import org.elbe.flow.util.Developer;
import org.hip.kernel.bom.DomainObjectHome;
import org.hip.kernel.exc.VException;

/**
 * 
 * Created on 02.05.2003
 * @author Luthiger
 */
public interface QuestionnaireComHome extends DomainObjectHome {
	public static final String KEY_ID 				= "ID";
	public static final String KEY_NAME 			= "Name";
	public static final String KEY_MAIL 			= "Mail";
	public static final String KEY_PASSWRD 			= "Passwrd";
	public static final String KEY_LANGUAGE 		= "Language";
	public static final String KEY_FIRM 			= "Firm";
	public static final String KEY_GENDER 			= "Gender";
	public static final String KEY_ANSWERED 		= "Answered";
	public static final String KEY_RESPONSE 		= "ResponseTime";

	/**
	 * Creates and initializes a new entry in the questionnare-com table.
	 * 
	 * @param inDeveloper Developer
	 * @param inFirmID BigDecimal
	 * @throws QbomException
	 */
	void createEntry(Developer inDeveloper, BigDecimal inFirmID) throws QbomException;

	/**
	 * Returns the user's questionnaire.
	 * 
	 * @param inUserId String
	 * @return QuestionnaireCom
	 * @throws VException
	 */
	QuestionnaireCom getQuestionnaire(String inUserId) throws VException;
}
