package org.elbe.flow.tasks.impl;

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

import org.elbe.flow.exc.QuestionnaireExceptionHandler;
import org.elbe.flow.servlets.impl.DefaultHtmlPage;
import org.elbe.flow.servlets.impl.LoginView;
import org.hip.kernel.exc.VException;
import org.hip.kernel.servlet.HtmlView;
import org.hip.kernel.servlet.impl.AbstractHtmlPage;
import org.hip.kernel.servlet.impl.AbstractTask;
import org.hip.kernel.servlet.impl.CssLink;

/**
 * This task creates the login - view. 
 * 
 * Created on 16.04.2003
 * @author Luthiger
 */
public class LoginShowTask extends AbstractTask {

	/**
	 * LoginShowTask default constructor.
	 * 
	 */
	public LoginShowTask() {
		super();
	}

	/**
	 *	Creates a Login Mask View. 
	 */
	public void run() throws VException {
	
		HtmlView lView = null;
		QuestionnaireContext lContext = (QuestionnaireContext)getContext();
	
		try {
			lView = new LoginView(lContext);
			
			AbstractHtmlPage lPage = new DefaultHtmlPage();
			lPage.setCssLink(new CssLink("css/questionnaire.css"));
			lPage.add(lView);
	
			getContext().setView(lPage);
		} 
		catch (Exception exc) {
			throw (VException)QuestionnaireExceptionHandler.instance().convert(exc, "org.elbe.flow.errmsg.error.contactAdmin");
		}
	}
}
