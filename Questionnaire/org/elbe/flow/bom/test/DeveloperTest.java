package org.elbe.flow.bom.test;

import org.elbe.flow.util.Developer;

import junit.framework.TestCase;

/**
 * 
 * Created on 15.09.2003
 * @author Luthiger
 */
public class DeveloperTest extends TestCase {

	/**
	 * Constructor for DeveloperTest.
	 * @param arg0
	 */
	public DeveloperTest(String arg0) {
		super(arg0);
	}

	public void testDo() {
		Developer lDeveloper = new Developer("Herr", "Gordon Test", "test@dplanet.ch", "pwrd");
		assertTrue("gender 1", lDeveloper.isMale());
		System.out.println(lDeveloper.getPasswrd());

		lDeveloper = new Developer("Frau", "Eva Test", "test@dplanet.ch", "pwrd");
		assertTrue("gender 2", !lDeveloper.isMale());
		System.out.println(lDeveloper.getPasswrd());
	}
}
