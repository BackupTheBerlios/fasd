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

/**
 * Implementation of a default html page for the Questionnaire application.
 * 
 * Created on 21.04.2003
 * @author Luthiger
 */
public class DefaultHtmlPage extends AbstractHtmlPage {
	protected static String HEAD_TITLE	= "<title>FASD Survey</title>\n";
	protected static String BODY_BEGIN_1	= "<body bgcolor='#FFFFFF' text='#000000' onLoad=";

	/**
	 * DefaultHtmlPage default constructor.
	 * 
	 */
	public DefaultHtmlPage() {
		super();
	}

	/**
	 * DefaultHtmlPage default constructor.
	 * @param inContext
	 */
	public DefaultHtmlPage(Context inContext) {
		super(inContext);
	}

	/* (non-Javadoc)
	 * @see org.hip.kernel.servlet.impl.AbstractHtmlView#getXMLName()
	 */
	protected String getXMLName() {
		return null;
	}
	
	/**
	 * Returns the title of the page.
	 * <pre><title>getTitle()</title></pre>
	 * 
	 * @return java.lang.String
	 */
	protected String getTitle() {
		return HEAD_TITLE;
	}

	/**
	 * Returns begin of this page as html-string. Contains stylesheet-include and onLoad-script.
	 *
	 * @return java.lang.String
	 */ 
	protected String createBegin() {
		return HTML_BEGIN + HEAD_BEGIN + getTitle() + cssStyle() + cssLinks() + HEAD_END + BODY_BEGIN_1+'"'+getOnLoad()+'"'+BODY_BEGIN_2;
	}
}
