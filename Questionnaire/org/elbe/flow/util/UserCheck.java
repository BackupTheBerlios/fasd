package org.elbe.flow.util;

import org.elbe.flow.exc.QuestionnaireWarningException;
import org.hip.kernel.servlet.Context;

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

/**
 * Interface for classes to check the user's user id.
 *  
 * Created on 08.05.2003
 * @author Luthiger
 */
public interface UserCheck {
	
	/**
	 * Checks the user's user id.
	 * 
	 * @param inUserId java.lang.String
	 * @param inContext org.hip.kernel.servlet.Context
	 * @return boolean
	 * @throws QuestionnaireWarningException
	 */
	boolean checkUser(String inUserId, Context inContext) throws QuestionnaireWarningException;
	
	/**
	 * Returns the code identifying the site.
	 * 
	 * @return int
	 */
	int getSiteCode();
}
