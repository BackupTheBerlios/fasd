package org.elbe.flow.bom.test;

import java.math.BigDecimal;

import org.elbe.flow.bom.FirmsHome;
import org.hip.kernel.bom.DomainObject;
import org.hip.kernel.bom.KeyObject;
import org.hip.kernel.bom.impl.KeyObjectImpl;
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
 * Created on 13.09.2003
 * @author Luthiger
 */
public class FirmsHomeImplTest extends TestCase {
	private final static String FIRMS_HOME_CLASS_NAME = "org.elbe.flow.bom.FirmsHomeImpl";

	/**
	 * Constructor for FirmsHomeImplTest.
	 * @param arg0
	 */
	public FirmsHomeImplTest(String arg0) {
		super(arg0);
	}

	protected void setUp() throws Exception {
	}

	protected void tearDown() throws Exception {
//		try {
//			getFirmsHome().select("delete from tblFirms");
//		}
//		catch (Exception exc) {
//			fail(exc.getMessage());
//		}
	}

	public void testCreateNewFirm() {
		String lExpectedName = "A Firm";
		Integer lExpectedSize = new Integer(77);
		try {
			FirmsHome lHome = getFirmsHome();
			int lCount = lHome.getCount();
			
			BigDecimal lId = lHome.createNewFirm(lExpectedName, lExpectedSize);
			assertTrue("greater null", lId.intValue() > 0);
			assertEquals("count 1", lCount + 1, lHome.getCount());
			
			KeyObject lKey = new KeyObjectImpl();
			lKey.setValue(FirmsHome.KEY_ID, lId);
			DomainObject lFirm = lHome.findByKey(lKey);
			
			assertEquals("name", lExpectedName, lFirm.get(FirmsHome.KEY_FIRM_NAME));
			assertEquals("size", lExpectedSize.intValue(), ((BigDecimal)lFirm.get(FirmsHome.KEY_SAMPLE_SIZE)).intValue());
			
			lFirm.delete(true);
		}
		catch (Exception exc) {
			fail(exc.getMessage());
		}
	}

	private FirmsHome getFirmsHome() {
		return (FirmsHome)VSys.homeManager.getHome(FIRMS_HOME_CLASS_NAME);
	}
}
