package org.elbe.flow.bom;

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

import java.math.BigDecimal;

import org.elbe.flow.exc.QbomException;
import org.hip.kernel.bom.DomainObjectHome;

/**
 * 
 * Created on 12.09.2003
 * @author Luthiger
 */
public interface FirmsHome extends DomainObjectHome {
	public static final String KEY_ID 				= "ID";
	public static final String KEY_FIRM_NAME 		= "FirmName";
	public static final String KEY_SAMPLE_SIZE 		= "SampleSize";
	public static final String KEY_RESPONSE_SIZE 	= "ResponseSize";
	
	/**
	 * Creates new firm entry.
	 * 
	 * @param inFirmName String
	 * @param inSampleSize Integer
	 * @return BigDecimal
	 * @throws QcomException
	 */	
	BigDecimal createNewFirm(String inFirmName, Integer inSampleSize) throws QbomException;
}
