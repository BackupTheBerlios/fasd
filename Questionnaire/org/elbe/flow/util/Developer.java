package org.elbe.flow.util;

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

import org.hip.kernel.sys.VObject;

/**
 * This class represents a developer. It holds the data read from the 
 * developers file.
 *  
 * Created on 13.09.2003
 * @author Luthiger
 */
public class Developer extends VObject {
	private static final String ADDRESS_F = "FRAU";
	
	private String address;
	private String name;
	private String mail;
	private String passwrd;
	private boolean gender_male;

	/**
	 * Developer constructor.
	 * 
	 * @param inAddress String
	 * @param inName String
	 * @param inMail String
	 */
	public Developer(String inAddress, String inName, String inMail, String inPasswrd) {
		super();
		address = inAddress.trim();
		name = inName.trim();
		mail = inMail.trim();
		passwrd = inPasswrd;
		
		gender_male = true;
		if (ADDRESS_F.equals(address.trim().toUpperCase())) {
			gender_male = false;
		}
	}

	/**
	 * @return String
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @return String
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @return String
	 */
	public String getName() {
		return name;
	}
	
	public boolean isMale() {
		return gender_male;
	}
	
	public String getPasswrd() {
		return passwrd;
	}

}
