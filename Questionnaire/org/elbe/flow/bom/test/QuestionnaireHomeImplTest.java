package org.elbe.flow.bom.test;

import java.text.DecimalFormat;
import java.text.ParseException;

import junit.framework.TestCase;

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

/**
 * 
 * Created on 09.05.2003
 * @author Luthiger
 */
public class QuestionnaireHomeImplTest extends TestCase {
	private long start = 0; 

	/**
	 * Constructor for QuestionnaireHomeImplTest.
	 * @param arg0
	 */
	public QuestionnaireHomeImplTest(String arg0) {
		super(arg0);
		start = System.currentTimeMillis();
	}

	public void testParseDouble() {
		String lInput1 = "9.5";
		String lInput2 = "9,5";
		String lInput3 = "1'009.5";
		String lInput4 = "1'009,5";
		String lInput5 = "10'09,5";
		
		String lExpected1 = "9.5";
		String lExpected2 = "1009.5";
		
		assertEquals("double 1", lExpected1, parseDouble(lInput1).toString());
		assertEquals("double 2", lExpected1, parseDouble(lInput2).toString());
		assertEquals("double 3", lExpected2, parseDouble(lInput3).toString());
		assertEquals("double 4", lExpected2, parseDouble(lInput4).toString());
		assertEquals("double 5", lExpected2, parseDouble(lInput5).toString());
	}

	private Double parseDouble(String inNumberString) {
		double lDouble = 0;
		try {
			lDouble = DecimalFormat.getInstance().parse(inNumberString.replaceAll(",", ".")).doubleValue();
		}
		catch (ParseException exc) {
			lDouble = -1;
		}
		return new Double(lDouble);
	}
	
	public void testCalculateResponseTime() {
		long lTime = System.currentTimeMillis() - start;
		System.out.println((new Double(lTime / 60000)).toString());
		
		double lTime2 = System.currentTimeMillis() - start;
		System.out.println((new Double(lTime2 / 60000)).toString());
	}
}
