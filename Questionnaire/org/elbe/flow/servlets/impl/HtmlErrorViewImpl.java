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
import org.hip.kernel.servlet.impl.AbstractXSLView;
import org.hip.kernel.util.XMLRepresentation;

/**
 * Implements an error view.<br>
 * This view will be generated based on XML and XSL.
 * 
 * Created on 16.04.2003
 * @author Luthiger
 */
public class HtmlErrorViewImpl extends AbstractXSLView {
	//constants
	private static final String XSL_NAME = "err_msg/body.xsl";

	/**
	 * HtmlErrorViewImpl constructor with given message
	 *
	 * @param inMessage java.lang.String
	 */
	public HtmlErrorViewImpl(String inMessage) {
		this(null, inMessage);
	}
	/**
	 * HtmlErrorViewImpl constructor with given context and message
	 *
	 * @param inContext org.hip.kernel.servlet.Context
	 * @param inMessage java.lang.String
	 */
	public HtmlErrorViewImpl(Context inContext, String inMessage) {
		super(inContext);
		this.prepareTransformation(new XMLRepresentation(getXMLString(inMessage)));
	}
	protected String getXMLName() {
		return XSL_NAME;
	}
	/**
	 * Returns the XML-String to generate view
	 *
	 * @return java.lang.String
	 * @param inMessage java.lang.String
	 */
	private String getXMLString(String inMessage) {
		StringBuffer lBuffer = new StringBuffer();

		lBuffer.append("<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>");
		lBuffer.append("<Root>");
		lBuffer.append("<Error>");
		lBuffer.append("<Message>");
		lBuffer.append(inMessage);
		lBuffer.append("</Message>");	
		lBuffer.append("</Error>");
		lBuffer.append("</Root>");
		
		return lBuffer.toString();
	}
}
