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

import org.elbe.flow.servlets.impl.HtmlErrorPageImpl;
import org.hip.kernel.exc.VException;
import org.hip.kernel.servlet.Context;
import org.hip.kernel.servlet.impl.AbstractContext;
import org.hip.kernel.servlet.impl.AbstractTask;

/**
 * Basic error task for the questionnaire application.
 * 
 * Created on 16.04.2003
 * @author Luthiger
 */
public class ErrorTask extends AbstractTask {

	/**
	 * ErrorTask default constructor.
	 */
	public ErrorTask() {
		super();
	}

	/**
	 * Shows the error message on an HtmlErrorPageImpl
	 *
	 * @see org.hip.vif.servlets.HtmlErrorPageImpl
	 */
	public void run() throws VException {
		Context lContext = getContext();
		lContext.setView(new HtmlErrorPageImpl(lContext, (String)lContext.get(AbstractContext.ERROR_MESSAGE_KEY)));
	}
}
