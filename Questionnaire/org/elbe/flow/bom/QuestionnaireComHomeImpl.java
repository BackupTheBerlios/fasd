package org.elbe.flow.bom;

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

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Vector;

import org.elbe.flow.exc.QbomException;
import org.elbe.flow.util.Developer;
import org.elbe.flow.util.UnixCrypt;
import org.hip.kernel.bom.DomainObject;
import org.hip.kernel.bom.KeyObject;
import org.hip.kernel.bom.impl.DomainObjectHomeImpl;
import org.hip.kernel.bom.impl.KeyObjectImpl;
import org.hip.kernel.exc.VException;

/**
 * 
 * Created on 02.05.2003
 * @author Luthiger
 */
public class QuestionnaireComHomeImpl extends DomainObjectHomeImpl implements QuestionnaireComHome {
	private final static String OBJECT_CLASS_NAME = "org.elbe.flow.bom.QuestionnaireComImpl";

	private final static String XML_OBJECT_DEF = 
		"<?xml version='1.0' encoding='ISO-8859-1'?>	\n" +
		"<objectDef objectName='QuestionnaireCom' parent='org.hip.kernel.bom.DomainObject' version='1.0'>	\n" +
		"	<keyDefs>	\n" +
		"		<keyDef>	\n" +
		"			<keyItemDef seq='0' keyPropertyName='" + KEY_ID + "'/>	\n" +
		"		</keyDef>	\n" +
		"	</keyDefs>	\n" +
		"	<propertyDefs>	\n" +
		"		<propertyDef propertyName='" + KEY_ID + "' valueType='Number' propertyType='simple'>	\n" +
		"			<mappingDef tableName='tblQuestionnaireCom' columnName='QuestionnaireID'/>	\n" +
		"		</propertyDef>	\n" +
		"		<propertyDef propertyName='" + KEY_NAME + "' valueType='String' propertyType='simple'>	\n" +
		"			<mappingDef tableName='tblQuestionnaireCom' columnName='sName'/>	\n" +
		"		</propertyDef>	\n" +
		"		<propertyDef propertyName='" + KEY_MAIL + "' valueType='String' propertyType='simple'>	\n" +
		"			<mappingDef tableName='tblQuestionnaireCom' columnName='sMail'/>	\n" +
		"		</propertyDef>	\n" +
		"		<propertyDef propertyName='" + KEY_PASSWRD + "' valueType='String' propertyType='simple'>	\n" +
		"			<mappingDef tableName='tblQuestionnaireCom' columnName='sPasswrd'/>	\n" +
		"		</propertyDef>	\n" +
		"		<propertyDef propertyName='" + KEY_LANGUAGE + "' valueType='String' propertyType='simple'>	\n" +
		"			<mappingDef tableName='tblQuestionnaireCom' columnName='sLanguage'/>	\n" +
		"		</propertyDef>	\n" +
		"		<propertyDef propertyName='" + KEY_FIRM + "' valueType='Number' propertyType='simple'>	\n" +
		"			<mappingDef tableName='tblQuestionnaireCom' columnName='nFirm'/>	\n" +
		"		</propertyDef>	\n" +
		"		<propertyDef propertyName='" + KEY_GENDER + "' valueType='Number' propertyType='simple'>	\n" +
		"			<mappingDef tableName='tblQuestionnaireCom' columnName='bGender'/>	\n" +
		"		</propertyDef>	\n" +
		"		<propertyDef propertyName='" + KEY_ANSWERED + "' valueType='Number' propertyType='simple'>	\n" +
		"			<mappingDef tableName='tblQuestionnaireCom' columnName='bAnswered'/>	\n" +
		"		</propertyDef>	\n" +
		"		<propertyDef propertyName='" + KEY_RESPONSE + "' valueType='Number' propertyType='simple'>	\n" +
		"			<mappingDef tableName='tblQuestionnaireCom' columnName='nResponseTime'/>	\n" +
		"		</propertyDef>	\n" +
		"  <propertyDef propertyName='q1' valueType='Number' propertyType='simple'> \n" +
		"   <mappingDef tableName='tblQuestionnaireCom' columnName='q1'/> \n" +
		"  </propertyDef> \n" +
		"  <propertyDef propertyName='q2' valueType='Number' propertyType='simple'> \n" +
		"   <mappingDef tableName='tblQuestionnaireCom' columnName='q2'/> \n" +
		"  </propertyDef> \n" +
		"  <propertyDef propertyName='q3' valueType='Number' propertyType='simple'> \n" +
		"   <mappingDef tableName='tblQuestionnaireCom' columnName='q3'/> \n" +
		"  </propertyDef> \n" +
		"  <propertyDef propertyName='q4' valueType='Number' propertyType='simple'> \n" +
		"   <mappingDef tableName='tblQuestionnaireCom' columnName='q4'/> \n" +
		"  </propertyDef> \n" +
		"  <propertyDef propertyName='q5' valueType='Number' propertyType='simple'> \n" +
		"   <mappingDef tableName='tblQuestionnaireCom' columnName='q5'/> \n" +
		"  </propertyDef> \n" +
		"  <propertyDef propertyName='q6' valueType='Number' propertyType='simple'> \n" +
		"   <mappingDef tableName='tblQuestionnaireCom' columnName='q6'/> \n" +
		"  </propertyDef> \n" +
		"  <propertyDef propertyName='q7' valueType='Number' propertyType='simple'> \n" +
		"   <mappingDef tableName='tblQuestionnaireCom' columnName='q7'/> \n" +
		"  </propertyDef> \n" +
		"  <propertyDef propertyName='q8' valueType='Number' propertyType='simple'> \n" +
		"   <mappingDef tableName='tblQuestionnaireCom' columnName='q8'/> \n" +
		"  </propertyDef> \n" +
		"  <propertyDef propertyName='q9' valueType='Number' propertyType='simple'> \n" +
		"   <mappingDef tableName='tblQuestionnaireCom' columnName='q9'/> \n" +
		"  </propertyDef> \n" +
		"  <propertyDef propertyName='q10' valueType='Number' propertyType='simple'> \n" +
		"   <mappingDef tableName='tblQuestionnaireCom' columnName='q10'/> \n" +
		"  </propertyDef> \n" +
		"  <propertyDef propertyName='q11' valueType='Number' propertyType='simple'> \n" +
		"   <mappingDef tableName='tblQuestionnaireCom' columnName='q11'/> \n" +
		"  </propertyDef> \n" +
		"  <propertyDef propertyName='q12' valueType='Number' propertyType='simple'> \n" +
		"   <mappingDef tableName='tblQuestionnaireCom' columnName='q12'/> \n" +
		"  </propertyDef> \n" +
		"  <propertyDef propertyName='q13' valueType='Number' propertyType='simple'> \n" +
		"   <mappingDef tableName='tblQuestionnaireCom' columnName='q13'/> \n" +
		"  </propertyDef> \n" +
		"  <propertyDef propertyName='q14' valueType='Number' propertyType='simple'> \n" +
		"   <mappingDef tableName='tblQuestionnaireCom' columnName='q14'/> \n" +
		"  </propertyDef> \n" +
		"  <propertyDef propertyName='q15' valueType='Number' propertyType='simple'> \n" +
		"   <mappingDef tableName='tblQuestionnaireCom' columnName='q15'/> \n" +
		"  </propertyDef> \n" +
		"  <propertyDef propertyName='q16' valueType='Number' propertyType='simple'> \n" +
		"   <mappingDef tableName='tblQuestionnaireCom' columnName='q16'/> \n" +
		"  </propertyDef> \n" +
		"  <propertyDef propertyName='q17' valueType='Number' propertyType='simple'> \n" +
		"   <mappingDef tableName='tblQuestionnaireCom' columnName='q17'/> \n" +
		"  </propertyDef> \n" +
		"  <propertyDef propertyName='q18' valueType='Number' propertyType='simple'> \n" +
		"   <mappingDef tableName='tblQuestionnaireCom' columnName='q18'/> \n" +
		"  </propertyDef> \n" +
		"  <propertyDef propertyName='q19' valueType='Number' propertyType='simple'> \n" +
		"   <mappingDef tableName='tblQuestionnaireCom' columnName='q19'/> \n" +
		"  </propertyDef> \n" +
		"  <propertyDef propertyName='q20' valueType='Number' propertyType='simple'> \n" +
		"   <mappingDef tableName='tblQuestionnaireCom' columnName='q20'/> \n" +
		"  </propertyDef> \n" +
		"  <propertyDef propertyName='q21' valueType='Number' propertyType='simple'> \n" +
		"   <mappingDef tableName='tblQuestionnaireCom' columnName='q21'/> \n" +
		"  </propertyDef> \n" +
		"  <propertyDef propertyName='q22' valueType='Number' propertyType='simple'> \n" +
		"   <mappingDef tableName='tblQuestionnaireCom' columnName='q22'/> \n" +
		"  </propertyDef> \n" +
		"  <propertyDef propertyName='q23' valueType='Number' propertyType='simple'> \n" +
		"   <mappingDef tableName='tblQuestionnaireCom' columnName='q23'/> \n" +
		"  </propertyDef> \n" +
		"  <propertyDef propertyName='q24' valueType='Number' propertyType='simple'> \n" +
		"   <mappingDef tableName='tblQuestionnaireCom' columnName='q24'/> \n" +
		"  </propertyDef> \n" +
		"  <propertyDef propertyName='q25' valueType='Number' propertyType='simple'> \n" +
		"   <mappingDef tableName='tblQuestionnaireCom' columnName='q25'/> \n" +
		"  </propertyDef> \n" +
		"  <propertyDef propertyName='q26' valueType='Number' propertyType='simple'> \n" +
		"   <mappingDef tableName='tblQuestionnaireCom' columnName='q26'/> \n" +
		"  </propertyDef> \n" +
		"  <propertyDef propertyName='q27' valueType='Number' propertyType='simple'> \n" +
		"   <mappingDef tableName='tblQuestionnaireCom' columnName='q27'/> \n" +
		"  </propertyDef> \n" +
		"  <propertyDef propertyName='q28' valueType='Number' propertyType='simple'> \n" +
		"   <mappingDef tableName='tblQuestionnaireCom' columnName='q28'/> \n" +
		"  </propertyDef> \n" +
		"  <propertyDef propertyName='q29' valueType='Number' propertyType='simple'> \n" +
		"   <mappingDef tableName='tblQuestionnaireCom' columnName='q29'/> \n" +
		"  </propertyDef> \n" +
		"  <propertyDef propertyName='q30' valueType='Number' propertyType='simple'> \n" +
		"   <mappingDef tableName='tblQuestionnaireCom' columnName='q30'/> \n" +
		"  </propertyDef> \n" +
		"  <propertyDef propertyName='q31' valueType='Number' propertyType='simple'> \n" +
		"   <mappingDef tableName='tblQuestionnaireCom' columnName='q31'/> \n" +
		"  </propertyDef> \n" +
		"  <propertyDef propertyName='q32' valueType='Number' propertyType='simple'> \n" +
		"   <mappingDef tableName='tblQuestionnaireCom' columnName='q32'/> \n" +
		"  </propertyDef> \n" +
		"  <propertyDef propertyName='q33' valueType='Number' propertyType='simple'> \n" +
		"   <mappingDef tableName='tblQuestionnaireCom' columnName='q33'/> \n" +
		"  </propertyDef> \n" +
		"  <propertyDef propertyName='q34' valueType='Number' propertyType='simple'> \n" +
		"   <mappingDef tableName='tblQuestionnaireCom' columnName='q34'/> \n" +
		"  </propertyDef> \n" +
		"  <propertyDef propertyName='q35' valueType='Number' propertyType='simple'> \n" +
		"   <mappingDef tableName='tblQuestionnaireCom' columnName='q35'/> \n" +
		"  </propertyDef> \n" +
		"  <propertyDef propertyName='q36' valueType='Number' propertyType='simple'> \n" +
		"   <mappingDef tableName='tblQuestionnaireCom' columnName='q36'/> \n" +
		"  </propertyDef> \n" +
		"  <propertyDef propertyName='q37' valueType='Number' propertyType='simple'> \n" +
		"   <mappingDef tableName='tblQuestionnaireCom' columnName='q37'/> \n" +
		"  </propertyDef> \n" +
		"  <propertyDef propertyName='q38' valueType='Number' propertyType='simple'> \n" +
		"   <mappingDef tableName='tblQuestionnaireCom' columnName='q38'/> \n" +
		"  </propertyDef> \n" +
		"  <propertyDef propertyName='q39' valueType='Number' propertyType='simple'> \n" +
		"   <mappingDef tableName='tblQuestionnaireCom' columnName='q39'/> \n" +
		"  </propertyDef> \n" +
		"  <propertyDef propertyName='q40' valueType='Number' propertyType='simple'> \n" +
		"   <mappingDef tableName='tblQuestionnaireCom' columnName='q40'/> \n" +
		"  </propertyDef> \n" +
		"  <propertyDef propertyName='q41' valueType='Number' propertyType='simple'> \n" +
		"   <mappingDef tableName='tblQuestionnaireCom' columnName='q41'/> \n" +
		"  </propertyDef> \n" +
		"  <propertyDef propertyName='q42' valueType='Number' propertyType='simple'> \n" +
		"   <mappingDef tableName='tblQuestionnaireCom' columnName='q42'/> \n" +
		"  </propertyDef> \n" +
		"  <propertyDef propertyName='q43' valueType='Number' propertyType='simple'> \n" +
		"   <mappingDef tableName='tblQuestionnaireCom' columnName='q43'/> \n" +
		"  </propertyDef> \n" +
		"  <propertyDef propertyName='q44' valueType='String' propertyType='simple'> \n" +
		"   <mappingDef tableName='tblQuestionnaireCom' columnName='q44'/> \n" +
		"  </propertyDef> \n" +
		"  <propertyDef propertyName='q45' valueType='Number' propertyType='simple'> \n" +
		"   <mappingDef tableName='tblQuestionnaireCom' columnName='q45'/> \n" +
		"  </propertyDef> \n" +
		"  <propertyDef propertyName='q46' valueType='Number' propertyType='simple'> \n" +
		"   <mappingDef tableName='tblQuestionnaireCom' columnName='q46'/> \n" +
		"  </propertyDef> \n" +
		"  <propertyDef propertyName='q47' valueType='String' propertyType='simple'> \n" +
		"   <mappingDef tableName='tblQuestionnaireCom' columnName='q47'/> \n" +
		"  </propertyDef> \n" +
		"		<propertyDef propertyName='Creation' valueType='Timestamp' propertyType='simple'>	\n" +
		"			<mappingDef tableName='tblQuestionnaireCom' columnName='dtCreation'/>	\n" +
		"		</propertyDef>	\n" +
		"	</propertyDefs>	\n" +
		"</objectDef>";

	/**
	 * QuestionnaireHomeImpl default constructor.
	 * 
	 */
	public QuestionnaireComHomeImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see org.hip.kernel.bom.GeneralDomainObjectHome#getObjectClassName()
	 */
	public String getObjectClassName() {
		return OBJECT_CLASS_NAME;
	}

	/* (non-Javadoc)
	 * @see org.hip.kernel.bom.impl.AbstractDomainObjectHome#getObjectDefString()
	 */
	protected String getObjectDefString() {
		return XML_OBJECT_DEF;
	}

	/* (non-Javadoc)
	 * @see org.hip.kernel.bom.impl.AbstractDomainObjectHome#createTestObjects()
	 */
	protected Vector createTestObjects() {
		return null;
	}
	
	/**
	 * Creates and initializes a new entry in the questionnare-com table.
	 * 
	 * @param inDeveloper Developer
	 * @param inFirmID BigDecimal
	 * @throws QbomException
	 */
	public void createEntry(Developer inDeveloper, BigDecimal inFirmID) throws QbomException {
		try {
			DomainObject lEntry = create();
			lEntry.set(KEY_NAME, inDeveloper.getName());
			lEntry.set(KEY_MAIL, inDeveloper.getMail());
			lEntry.set(KEY_GENDER, inDeveloper.isMale() ? new Integer(1) : new Integer(0));
			lEntry.set(KEY_PASSWRD, UnixCrypt.crypt(inDeveloper.getPasswrd()));
			lEntry.set(KEY_FIRM, inFirmID);
			lEntry.set(KEY_ANSWERED, new Integer(0));
			
			lEntry.insert(true);
		}
		catch (VException exc) {
			throw new QbomException(exc.getMessage());		
		}
		catch (SQLException exc) {
			throw new QbomException(exc.getMessage());		
		}
	}
	
	/**
	 * Returns the user's questionnaire.
	 * 
	 * @param inUserId String
	 * @return QuestionnaireCom
	 * @throws VException
	 */
	public QuestionnaireCom getQuestionnaire(String inUserId) throws VException {
		KeyObject lKey = new KeyObjectImpl();
		lKey.setValue(KEY_MAIL, inUserId);
		return (QuestionnaireCom)findByKey(lKey);
	}
}
