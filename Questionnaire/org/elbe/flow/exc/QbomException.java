package org.elbe.flow.exc;

import org.hip.kernel.exc.VException;

/*
	This package is part of the application VIF.
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
 * BOM Exception within the Questionnaire application.
 *  
 * Created on 15.09.2003
 * @author Luthiger
 */
public class QbomException extends VException {

	/**
	 * QbomException default constructor.
	 * 
	 */
	public QbomException() {
		super();
	}

	/**
	 * QbomException default constructor.
	 * @param inSimpleMessage
	 */
	public QbomException(String inSimpleMessage) {
		super(inSimpleMessage);
	}

	/**
	 * QbomException default constructor.
	 * @param inMsgKey
	 * @param inMsgParameters
	 */
	public QbomException(String inMsgKey, Object[] inMsgParameters) {
		super(inMsgKey, inMsgParameters);
	}

	/**
	 * QbomException default constructor.
	 * @param inMsgSource
	 * @param inMsgKey
	 * @param inMsgParameters
	 */
	public QbomException(
		String inMsgSource,
		String inMsgKey,
		Object[] inMsgParameters) {
		super(inMsgSource, inMsgKey, inMsgParameters);
	}
}
