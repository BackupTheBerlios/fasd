package org.elbe.flow.tasks.impl;

import org.elbe.flow.exc.QuestionnaireExceptionHandler;
import org.elbe.flow.servlets.impl.DefaultHtmlPage;
import org.hip.kernel.exc.VException;
import org.hip.kernel.servlet.Context;
import org.hip.kernel.servlet.HtmlView;
import org.hip.kernel.servlet.impl.AbstractHtmlPage;
import org.hip.kernel.servlet.impl.AbstractTask;
import org.hip.kernel.servlet.impl.CssLink;

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
 * 
 * Created on 19.09.2003
 * @author Luthiger
 */
public abstract class AbstractQuestionsShowTask extends AbstractTask {

	/**
	 * AbstractQuestionsShowTask default constructor.
	 * 
	 */
	public AbstractQuestionsShowTask() {
		super();
	}

	/**
		 * @see org.hip.kernel.servlet.Task#run()
		 */
	public void run() throws VException {
		HtmlView lView = null;
		QuestionnaireContext lContext = (QuestionnaireContext)getContext();
	
		try {
			lView = getView(lContext);
			
			AbstractHtmlPage lPage = new DefaultHtmlPage();
			lPage.setCssLink(new CssLink("css/questionnaire.css"));
			lPage.add(lView);
	
			getContext().setView(lPage);
		} 
		catch (Exception exc) {
			throw (VException)QuestionnaireExceptionHandler.instance().convert(exc, "org.elbe.flow.errmsg.error.contactAdmin");
		}
	}
	
	abstract protected HtmlView getView(Context inContext);
}
