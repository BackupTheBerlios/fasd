package org.elbe.flow.servlets.impl;

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

import org.hip.kernel.servlet.Context;
import org.hip.kernel.servlet.impl.AbstractHtmlView;

/**
 * View to display the questions.
 * 
 * Created on 22.04.2003
 * @author Luthiger
 */
public class QuestionsView extends AbstractHtmlView {
	//constants
	private static final String HTML_FILE 		= "pages/questionnaire.htm";
	private static final String HTML_FILE_QCOM 	= "pages/questionnaire_qcom.htm";
	
	private String html_file;

	/**
	 * QuestionsView constructor.
	 * 
	 * @param inContext Context
	 * @param isOSS boolean 
	 */
	public QuestionsView(Context inContext, boolean isOSS) {
		super(inContext);
		html_file = isOSS ? HTML_FILE : HTML_FILE_QCOM;
		setHTMLString(readHTML());
	}

	/**
	 * @see org.hip.kernel.servlet.impl.AbstractHtmlView#getXMLName()
	 */
	protected String getXMLName() {
		return html_file;
	}
}
