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

import org.elbe.flow.bom.QuestionnairePre;
import org.elbe.flow.tasks.impl.QuestionnaireContext;
import org.hip.kernel.bom.impl.XMLSerializer;
import org.hip.kernel.servlet.Context;
import org.hip.kernel.servlet.impl.AbstractXSLView;
import org.hip.kernel.util.XMLRepresentation;

/**
 * Displays the proper pretest view.
 * 
 * Created on 02.05.2003
 * @author Luthiger
 */
public class PretestView extends AbstractXSLView {
	//constants
	private static final String XSL_FILE = "pre/pretest.xsl";

	public PretestView(Context inContext, QuestionnairePre inQuestionnaire) {
		super(inContext);
		prepareTransformation(new XMLRepresentation(createXML(inQuestionnaire)));
	}

	protected String getXMLName() {
		return XSL_FILE;
	}

	private String createXML(QuestionnairePre inQuestionnaire) {
		XMLSerializer lVisitor = new XMLSerializer();
		inQuestionnaire.accept(lVisitor);

		StringBuffer outXML = new StringBuffer(QuestionnaireContext.HEADER);
		outXML.append(QuestionnaireContext.ROOT_BEGIN);
		outXML.append("<Questions>").append(lVisitor.toString()).append("</Questions>");
		outXML.append(QuestionnaireContext.ROOT_END);
		return new String(outXML);
	}
}
