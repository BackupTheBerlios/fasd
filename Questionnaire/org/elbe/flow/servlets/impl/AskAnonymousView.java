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

import org.elbe.flow.tasks.impl.QuestionnaireContext;
import org.hip.kernel.servlet.Context;
import org.hip.kernel.servlet.impl.AbstractXSLView;
import org.hip.kernel.util.XMLRepresentation;

/**
 * View to display question for anonymous processing.
 * 
 * Created on 01.05.2003
 * @author Luthiger
 */
public class AskAnonymousView extends AbstractXSLView {
	private static final String XSL_FILE = "stylesheets/anonymous.xsl";

	/**
	 * AskAnonymousView constructor.
	 * 
	 * @param inContext Context
	 * @param inMessage String
	 */
	public AskAnonymousView(Context inContext, String inMessage) {
		super(inContext);
		prepareTransformation(new XMLRepresentation(createXML(inMessage)));
	}

	/**
	 * @see org.hip.kernel.servlet.impl.AbstractHtmlView#getXMLName()
	 */
	protected String getXMLName() {
		return XSL_FILE;
	}
	
	private String createXML(String inMessage) {
		StringBuffer outXML = new StringBuffer(QuestionnaireContext.HEADER);
		outXML.append(QuestionnaireContext.ROOT_BEGIN);
		outXML.append("<Message>").append(inMessage).append("</Message>");
		outXML.append(QuestionnaireContext.ROOT_END);
		return new String(outXML);
	}
}
