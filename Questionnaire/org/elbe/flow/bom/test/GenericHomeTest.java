package org.elbe.flow.bom.test;

/*
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

import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

import org.elbe.flow.bom.FirmsHome;
import org.elbe.flow.bom.QuestionnaireComHome;
import org.elbe.flow.bom.QuestionnaireHome;
import org.hip.kernel.bom.DomainObject;
import org.hip.kernel.bom.DomainObjectHome;
import org.hip.kernel.bom.KeyObject;
import org.hip.kernel.bom.impl.KeyObjectImpl;
import org.hip.kernel.exc.VException;
import org.hip.kernel.sys.VSys;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * 
 * Created on 03.05.2003
 * @author Luthiger
 */
public class GenericHomeTest extends TestCase {

	/**
	 * Inner class for a single test.
	 * Holds information to create a home and 
	 * to initialize a domain object with test values.
	 */
	private class SingleTest extends Object {
		String homeName = "";
		Map values = null;

		private SingleTest(String inHomeName) {
			homeName = inHomeName;
			values = new HashMap();
		}
		
		public void setValue(String inKey, Object inValue) {
			values.put(inKey, inValue);
		}
		
		public String getHome() {
			return homeName;
		}
		
		public Iterator getKeys() {
			return values.keySet().iterator();
		}
		
		public Object getValue(String inKey) {
			return values.get(inKey);
		}
	}

	/**
	 * GenericHomeTest default constructor.
	 * @param arg0
	 */
	public GenericHomeTest(String arg0) {
		super(arg0);
	}

	public static Test suite() {
		return new TestSuite(GenericHomeTest.class);
	}

	public void testDo() {
		//Collection containing the information for the homes to test.
		Collection lSimpleTests = new Vector();
		SingleTest lSingleTest;
		
		//load test for org.elbe.flow.bom.QuestionnaireHomeImpl
		lSingleTest = new SingleTest("org.elbe.flow.bom.QuestionnaireHomeImpl");
		for (int i = 1; i < 35; i++) {
			lSingleTest.setValue("q" + String.valueOf(i), new Integer(i));
		}
		lSingleTest.setValue(QuestionnaireHome.KEY_Q52, new Double(15.5));
		lSingleTest.setValue(QuestionnaireHome.KEY_Q53, "Hallo Velo!!!");
		lSimpleTests.add(lSingleTest);

		//load test for org.elbe.flow.bom.FirmsHomeImpl
		lSingleTest = new SingleTest("org.elbe.flow.bom.FirmsHomeImpl");
		lSingleTest.setValue(FirmsHome.KEY_FIRM_NAME, "Hallo Velo!!!");
		lSimpleTests.add(lSingleTest);

		//load test for org.elbe.flow.bom.QuestionnaireComHomeImpl
		lSingleTest = new SingleTest("org.elbe.flow.bom.QuestionnaireComHomeImpl");
		lSingleTest.setValue(QuestionnaireComHome.KEY_FIRM, new Integer(88));
		lSingleTest.setValue(QuestionnaireComHome.KEY_GENDER, new Integer(2));
		lSingleTest.setValue(QuestionnaireComHome.KEY_MAIL, "test@dplanet.ch");
		lSingleTest.setValue(QuestionnaireComHome.KEY_NAME, "Balduin Test");
		lSingleTest.setValue(QuestionnaireComHome.KEY_PASSWRD, "asdfafd");
		for (int i = 1; i < 44; i++) {
			lSingleTest.setValue("q" + String.valueOf(i), new Integer(i));
		}
		lSingleTest.setValue("q46", new Double(15.5));
		lSingleTest.setValue("q47", "Hallo Velo!!!");
		lSimpleTests.add(lSingleTest);
		
		doSimpleTests(lSimpleTests);
	}

	private void doSimpleTests(Collection inSimpleTests) {
		try {
			int i = 0;
			for (Iterator lSimpleTests = inSimpleTests.iterator(); lSimpleTests.hasNext();) {
				SingleTest lSingleTest = (SingleTest)lSimpleTests.next();
				
				//create home
				DomainObjectHome lHome = (DomainObjectHome)VSys.homeManager.getHome(lSingleTest.getHome());
				//get count
				int lCount = lHome.getCount();

				//create key object
				KeyObject lKey = new KeyObjectImpl();
				
				//create object
				DomainObject lEntry = lHome.create();
				for (Iterator lKeys = lSingleTest.getKeys(); lKeys.hasNext();) {
					String lName = (String)lKeys.next();
					lEntry.set(lName, lSingleTest.getValue(lName));
					lKey.setValue(lName, lSingleTest.getValue(lName));
				}

				//insert
				lEntry.insert(true);
				//assert count + 1
				assertEquals(lHome.getObjectClassName() + ": entry added", lCount + 1, lHome.getCount());
				//find
				lEntry = lHome.findByKey(lKey);
				//delete
				lEntry.delete(true);
				//assert count
				assertEquals(lHome.getObjectClassName() + ": entry deleted", lCount, lHome.getCount());
				
				System.out.println(String.valueOf(i) + ": Test of " + lHome.getObjectClassName() + " sucessful.");
				i++;
			}
			System.out.println("Ended " + i + " sucessful simple tests with domain objects.");
		}
		catch (VException exc) {
			fail(exc.getMessage());
		}
		catch (SQLException exc) {
			fail(exc.getMessage());
		}
	}
}
