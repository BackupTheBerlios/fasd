package org.elbe.flow.exc;

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

/**
 * Warning questionnaire application exception.
 * 
 * Created on 16.04.2003
 * @author Luthiger
 */
public class QuestionnaireWarningException extends VException {

	/**
	 * QuestionnaireWarningException default constructor.
	 * 
	 */
	public QuestionnaireWarningException() {
		super("no message text provided");
	}

	/**
	 * QuestionnaireWarningException default constructor.
	 * @param inSimpleMessage
	 */
	public QuestionnaireWarningException(String inSimpleMessage) {
		super(inSimpleMessage);
	}

	/**
	 * QuestionnaireWarningException default constructor.
	 * @param inMsgKey
	 * @param inMsgParameters
	 */
	public QuestionnaireWarningException(String inMsgKey, Object[] inMsgParameters) {
		super(inMsgKey, inMsgParameters);
	}

	/**
	 * QuestionnaireWarningException default constructor.
	 * @param inMsgSource
	 * @param inMsgKey
	 * @param inMsgParameters
	 */
	public QuestionnaireWarningException(String inMsgSource, String inMsgKey, Object[] inMsgParameters) {
		super(inMsgSource, inMsgKey, inMsgParameters);
	}
}
