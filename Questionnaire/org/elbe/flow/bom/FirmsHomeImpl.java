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
import java.sql.SQLException;
import java.util.Vector;

import org.elbe.flow.exc.QbomException;
import org.hip.kernel.bom.DomainObject;
import org.hip.kernel.bom.impl.DomainObjectHomeImpl;
import org.hip.kernel.exc.VException;

/**
 * 
 * Created on 12.09.2003
 * @author Luthiger
 */
public class FirmsHomeImpl extends DomainObjectHomeImpl implements FirmsHome {
	private final static String OBJECT_CLASS_NAME = "org.elbe.flow.bom.FirmsImpl";

	private final static String XML_OBJECT_DEF = 
		"<?xml version='1.0' encoding='ISO-8859-1'?>	\n" +
		"<objectDef objectName='Firms' parent='org.hip.kernel.bom.DomainObject' version='1.0'>	\n" +
		"	<keyDefs>	\n" +
		"		<keyDef>	\n" +
		"			<keyItemDef seq='0' keyPropertyName='" + KEY_ID + "'/>	\n" +
		"		</keyDef>	\n" +
		"	</keyDefs>	\n" +
		"	<propertyDefs>	\n" +
		"		<propertyDef propertyName='" + KEY_ID + "' valueType='Number' propertyType='simple'>	\n" +
		"			<mappingDef tableName='tblFirms' columnName='FirmID'/>	\n" +
		"		</propertyDef>	\n" +
		"		<propertyDef propertyName='" + KEY_FIRM_NAME + "' valueType='String' propertyType='simple'>	\n" +
		"			<mappingDef tableName='tblFirms' columnName='sFirmName'/>	\n" +
		"		</propertyDef>	\n" +
		"		<propertyDef propertyName='" + KEY_SAMPLE_SIZE + "' valueType='Number' propertyType='simple'>	\n" +
		"			<mappingDef tableName='tblFirms' columnName='nSampleSize'/>	\n" +
		"		</propertyDef>	\n" +
		"		<propertyDef propertyName='" + KEY_RESPONSE_SIZE + "' valueType='Number' propertyType='simple'>	\n" +
		"			<mappingDef tableName='tblFirms' columnName='nResponseSize'/>	\n" +
		"		</propertyDef>	\n" +
		"	</propertyDefs>	\n" +
		"</objectDef>";

	/**
	 * FirmsHomeImpl default constructor.
	 */
	public FirmsHomeImpl() {
		super();
	}

	/**
	 * @see org.hip.kernel.bom.GeneralDomainObjectHome#getObjectClassName()
	 */
	public String getObjectClassName() {
		return OBJECT_CLASS_NAME;
	}

	/**
	 * @see org.hip.kernel.bom.impl.AbstractDomainObjectHome#getObjectDefString()
	 */
	protected String getObjectDefString() {
		return XML_OBJECT_DEF;
	}

	/**
	 * @see org.hip.kernel.bom.impl.AbstractDomainObjectHome#createTestObjects()
	 */
	protected Vector createTestObjects() {
		return null;
	}
	
	/**
	 * Creates new firm entry.
	 * 
	 * @param inFirmName String
	 * @param inSampleSize Integer
	 * @return BigDecimal
	 * @throws QcomException
	 */	
	public BigDecimal createNewFirm(String inFirmName, Integer inSampleSize) throws QbomException {
		try {
			DomainObject lFirm = create();
			lFirm.set(KEY_FIRM_NAME, inFirmName);
			lFirm.set(KEY_SAMPLE_SIZE, inSampleSize);
			lFirm.insert(true);
			
			return getMax(KEY_ID);
		}
		catch (VException exc) {
			throw new QbomException(exc.getMessage());		
		}
		catch (SQLException exc) {
			throw new QbomException(exc.getMessage());		
		}
	}
}
