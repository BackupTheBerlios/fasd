package org.elbe.flow.bom.test;

import java.math.BigDecimal;

import org.elbe.flow.bom.QuestionnaireCom;
import org.elbe.flow.bom.QuestionnaireComHome;
import org.elbe.flow.util.Developer;
import org.hip.kernel.sys.VSys;

import junit.framework.TestCase;

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
 * 
 * Created on 15.09.2003
 * @author Luthiger
 */
public class QuestionnaireComHomeImplTest extends TestCase {
	private final static String QUESTIONNARE_HOME_CLASS_NAME	= "org.elbe.flow.bom.QuestionnaireComHomeImpl";

	/**
	 * Constructor for QuestionnaireComHomeImplTest.
	 * @param arg0
	 */
	public QuestionnaireComHomeImplTest(String arg0) {
		super(arg0);
	}

	/*
	 * @see TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
	}

	/*
	 * @see TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testCreateEntry() {
		String lMail = "test@dplanet.ch";
		String lName = "Gordon Bleu";		
		try {
			QuestionnaireComHome lHome = getQuestionnaireHome();
			int lCount = lHome.getCount();
			
			Developer lDeveloper = new Developer("Herr", lName, lMail, "pwrd"); 
			lHome.createEntry(lDeveloper, new BigDecimal(88));
			assertEquals("count", lCount + 1, lHome.getCount());
			
			QuestionnaireCom lQuestionnaire = lHome.getQuestionnaire(lMail);
			assertEquals("mail", lMail, (String)lQuestionnaire.get(QuestionnaireComHome.KEY_MAIL));
			assertEquals("name", lName, (String)lQuestionnaire.get(QuestionnaireComHome.KEY_NAME));
			
			BigDecimal lID = lHome.getMax(QuestionnaireComHome.KEY_ID);
			String lDelete = "DELETE FROM tblQuestionnaireCom WHERE QuestionnaireID = " + lID.toString();
			System.out.println(lDelete);
			lHome.select(lDelete);
		}
		catch (Exception exc) {
			fail(exc.getMessage());
		}
	}

	private QuestionnaireComHome getQuestionnaireHome() {
		return (QuestionnaireComHome)VSys.homeManager.getHome(QUESTIONNARE_HOME_CLASS_NAME);
	}
}
