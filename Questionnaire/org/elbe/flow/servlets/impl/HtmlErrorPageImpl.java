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
import org.hip.kernel.servlet.impl.AbstractHtmlPage;
import org.hip.kernel.servlet.impl.CssLink;

/**
 * Implements a html error page that contains a HtmlErrorView object.
 * 
 * Created on 16.04.2003
 * @author Luthiger
 */
public class HtmlErrorPageImpl extends AbstractHtmlPage {

	/**
	 * HtmlErrorPageImpl default constructor with given message
	 *
	 * @param inMessage java.lang.String
	 */
	public HtmlErrorPageImpl(String inMessage) {
		this(null, inMessage);
	}
	
	/**
	 * HtmlErrorPageImpl constructor with given context and message
	 *
	 * @param inContext org.hip.kernel.servlet.Context
	 * @param inMessage java.lang.String
	 */
	public HtmlErrorPageImpl(Context inContext, String inMessage) {
		super(inContext);
		add(new HtmlErrorViewImpl(inContext, inMessage));
		setCssLink(new CssLink("css/questionnaire.css"));
	}

	/**
	 * @see org.hip.kernel.servlet.impl.AbstractHtmlView#getXMLName()
	 */
	protected String getXMLName() {
		return null;
	}
}
