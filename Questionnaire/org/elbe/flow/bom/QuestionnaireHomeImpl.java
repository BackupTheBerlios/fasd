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

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Vector;

import org.elbe.flow.tasks.impl.QuestionnaireContext;
import org.hip.kernel.bom.BOMException;
import org.hip.kernel.bom.DomainObject;
import org.hip.kernel.bom.SettingException;
import org.hip.kernel.bom.impl.DomainObjectHomeImpl;

/**
 * 
 * Created on 02.05.2003
 * @author Luthiger
 */
public class QuestionnaireHomeImpl extends DomainObjectHomeImpl implements QuestionnaireHome {
	private final static String OBJECT_CLASS_NAME = "org.elbe.flow.bom.QuestionnaireImpl";
	private int site_code = 0;

	private final static String XML_OBJECT_DEF = 
		"<?xml version='1.0' encoding='ISO-8859-1'?>	" +
		"<objectDef objectName='TempImpl' parent='org.hip.kernel.bom.DomainObject' version='1.0'>	" +
		"	<keyDefs>	" +
		"		<keyDef>	" +
		"			<keyItemDef seq='0' keyPropertyName='" + KEY_ID + "'/>	" +
		"		</keyDef>	" +
		"	</keyDefs>	" +
		"	<propertyDefs>	" +
		"		<propertyDef propertyName='" + KEY_ID + "' valueType='Number' propertyType='simple'>	" +
		"			<mappingDef tableName='tblQuestionnaire' columnName='QuestionnaireID'/>	" +
		"		</propertyDef>	" +
		"		<propertyDef propertyName='" + KEY_USERID + "' valueType='String' propertyType='simple'>	" +
		"			<mappingDef tableName='tblQuestionnaire' columnName='sUserID'/>	" +
		"		</propertyDef>	" +
		"		<propertyDef propertyName='" + KEY_LANGUAGE + "' valueType='String' propertyType='simple'>	" +
		"			<mappingDef tableName='tblQuestionnaire' columnName='sLanguage'/>	" +
		"		</propertyDef>	" +
		"		<propertyDef propertyName='" + KEY_ANONYMOUS + "' valueType='Number' propertyType='simple'>	" +
		"			<mappingDef tableName='tblQuestionnaire' columnName='bAnonymous'/>	" +
		"		</propertyDef>	" +
		"		<propertyDef propertyName='" + KEY_RESPONSETIME + "' valueType='Number' propertyType='simple'>	" +
		"			<mappingDef tableName='tblQuestionnaire' columnName='nResponseTime'/>	" +
		"		</propertyDef>	" +
		"		<propertyDef propertyName='" + KEY_SITE + "' valueType='Number' propertyType='simple'>	" +
		"			<mappingDef tableName='tblQuestionnaire' columnName='nSite'/>	" +
		"		</propertyDef>	" +
		"		<propertyDef propertyName='" + KEY_Q1 + "' valueType='Number' propertyType='simple'>	" +
		"			<mappingDef tableName='tblQuestionnaire' columnName='q1'/>	" +
		"		</propertyDef>	" +
		"		<propertyDef propertyName='" + KEY_Q2 + "' valueType='Number' propertyType='simple'>	" +
		"			<mappingDef tableName='tblQuestionnaire' columnName='q2'/>	" +
		"		</propertyDef>	" +
		"		<propertyDef propertyName='" + KEY_Q3 + "' valueType='Number' propertyType='simple'>	" +
		"			<mappingDef tableName='tblQuestionnaire' columnName='q3'/>	" +
		"		</propertyDef>	" +
		"		<propertyDef propertyName='" + KEY_Q4 + "' valueType='Number' propertyType='simple'>	" +
		"			<mappingDef tableName='tblQuestionnaire' columnName='q4'/>	" +
		"		</propertyDef>	" +
		"		<propertyDef propertyName='" + KEY_Q5 + "' valueType='Number' propertyType='simple'>	" +
		"			<mappingDef tableName='tblQuestionnaire' columnName='q5'/>	" +
		"		</propertyDef>	" +
		"		<propertyDef propertyName='" + KEY_Q6 + "' valueType='Number' propertyType='simple'>	" +
		"			<mappingDef tableName='tblQuestionnaire' columnName='q6'/>	" +
		"		</propertyDef>	" +
		"		<propertyDef propertyName='" + KEY_Q7 + "' valueType='Number' propertyType='simple'>	" +
		"			<mappingDef tableName='tblQuestionnaire' columnName='q7'/>	" +
		"		</propertyDef>	" +
		"		<propertyDef propertyName='" + KEY_Q8 + "' valueType='Number' propertyType='simple'>	" +
		"			<mappingDef tableName='tblQuestionnaire' columnName='q8'/>	" +
		"		</propertyDef>	" +
		"		<propertyDef propertyName='" + KEY_Q9 + "' valueType='Number' propertyType='simple'>	" +
		"			<mappingDef tableName='tblQuestionnaire' columnName='q9'/>	" +
		"		</propertyDef>	" +
		"		<propertyDef propertyName='" + KEY_Q10 + "' valueType='Number' propertyType='simple'>	" +
		"			<mappingDef tableName='tblQuestionnaire' columnName='q10'/>	" +
		"		</propertyDef>	" +
		"		<propertyDef propertyName='" + KEY_Q11 + "' valueType='Number' propertyType='simple'>	" +
		"			<mappingDef tableName='tblQuestionnaire' columnName='q11'/>	" +
		"		</propertyDef>	" +
		"		<propertyDef propertyName='" + KEY_Q12 + "' valueType='Number' propertyType='simple'>	" +
		"			<mappingDef tableName='tblQuestionnaire' columnName='q12'/>	" +
		"		</propertyDef>	" +
		"		<propertyDef propertyName='" + KEY_Q13 + "' valueType='Number' propertyType='simple'>	" +
		"			<mappingDef tableName='tblQuestionnaire' columnName='q13'/>	" +
		"		</propertyDef>	" +
		"		<propertyDef propertyName='" + KEY_Q14 + "' valueType='Number' propertyType='simple'>	" +
		"			<mappingDef tableName='tblQuestionnaire' columnName='q14'/>	" +
		"		</propertyDef>	" +
		"		<propertyDef propertyName='" + KEY_Q15 + "' valueType='Number' propertyType='simple'>	" +
		"			<mappingDef tableName='tblQuestionnaire' columnName='q15'/>	" +
		"		</propertyDef>	" +
		"		<propertyDef propertyName='" + KEY_Q16 + "' valueType='Number' propertyType='simple'>	" +
		"			<mappingDef tableName='tblQuestionnaire' columnName='q16'/>	" +
		"		</propertyDef>	" +
		"		<propertyDef propertyName='" + KEY_Q17 + "' valueType='Number' propertyType='simple'>	" +
		"			<mappingDef tableName='tblQuestionnaire' columnName='q17'/>	" +
		"		</propertyDef>	" +
		"		<propertyDef propertyName='" + KEY_Q18 + "' valueType='Number' propertyType='simple'>	" +
		"			<mappingDef tableName='tblQuestionnaire' columnName='q18'/>	" +
		"		</propertyDef>	" +
		"		<propertyDef propertyName='" + KEY_Q19 + "' valueType='Number' propertyType='simple'>	" +
		"			<mappingDef tableName='tblQuestionnaire' columnName='q19'/>	" +
		"		</propertyDef>	" +
		"		<propertyDef propertyName='" + KEY_Q20 + "' valueType='Number' propertyType='simple'>	" +
		"			<mappingDef tableName='tblQuestionnaire' columnName='q20'/>	" +
		"		</propertyDef>	" +
		"		<propertyDef propertyName='" + KEY_Q21 + "' valueType='Number' propertyType='simple'>	" +
		"			<mappingDef tableName='tblQuestionnaire' columnName='q21'/>	" +
		"		</propertyDef>	" +
		"		<propertyDef propertyName='" + KEY_Q22 + "' valueType='Number' propertyType='simple'>	" +
		"			<mappingDef tableName='tblQuestionnaire' columnName='q22'/>	" +
		"		</propertyDef>	" +
		"		<propertyDef propertyName='" + KEY_Q23 + "' valueType='Number' propertyType='simple'>	" +
		"			<mappingDef tableName='tblQuestionnaire' columnName='q23'/>	" +
		"		</propertyDef>	" +
		"		<propertyDef propertyName='" + KEY_Q24 + "' valueType='Number' propertyType='simple'>	" +
		"			<mappingDef tableName='tblQuestionnaire' columnName='q24'/>	" +
		"		</propertyDef>	" +
		"		<propertyDef propertyName='" + KEY_Q25 + "' valueType='Number' propertyType='simple'>	" +
		"			<mappingDef tableName='tblQuestionnaire' columnName='q25'/>	" +
		"		</propertyDef>	" +
		"		<propertyDef propertyName='" + KEY_Q26 + "' valueType='Number' propertyType='simple'>	" +
		"			<mappingDef tableName='tblQuestionnaire' columnName='q26'/>	" +
		"		</propertyDef>	" +
		"		<propertyDef propertyName='" + KEY_Q27 + "' valueType='Number' propertyType='simple'>	" +
		"			<mappingDef tableName='tblQuestionnaire' columnName='q27'/>	" +
		"		</propertyDef>	" +
		"		<propertyDef propertyName='" + KEY_Q28 + "' valueType='Number' propertyType='simple'>	" +
		"			<mappingDef tableName='tblQuestionnaire' columnName='q28'/>	" +
		"		</propertyDef>	" +
		"		<propertyDef propertyName='" + KEY_Q29 + "' valueType='Number' propertyType='simple'>	" +
		"			<mappingDef tableName='tblQuestionnaire' columnName='q29'/>	" +
		"		</propertyDef>	" +
		"		<propertyDef propertyName='" + KEY_Q30 + "' valueType='Number' propertyType='simple'>	" +
		"			<mappingDef tableName='tblQuestionnaire' columnName='q30'/>	" +
		"		</propertyDef>	" +
		"		<propertyDef propertyName='" + KEY_Q31 + "' valueType='Number' propertyType='simple'>	" +
		"			<mappingDef tableName='tblQuestionnaire' columnName='q31'/>	" +
		"		</propertyDef>	" +
		"		<propertyDef propertyName='" + KEY_Q32 + "' valueType='Number' propertyType='simple'>	" +
		"			<mappingDef tableName='tblQuestionnaire' columnName='q32'/>	" +
		"		</propertyDef>	" +
		"		<propertyDef propertyName='" + KEY_Q33 + "' valueType='Number' propertyType='simple'>	" +
		"			<mappingDef tableName='tblQuestionnaire' columnName='q33'/>	" +
		"		</propertyDef>	" +
		"		<propertyDef propertyName='" + KEY_Q34 + "' valueType='Number' propertyType='simple'>	" +
		"			<mappingDef tableName='tblQuestionnaire' columnName='q34'/>	" +
		"		</propertyDef>	" +
		"		<propertyDef propertyName='" + KEY_Q35 + "' valueType='Number' propertyType='simple'>	" +
		"			<mappingDef tableName='tblQuestionnaire' columnName='q35'/>	" +
		"		</propertyDef>	" +
		"		<propertyDef propertyName='" + KEY_Q36_1 + "' valueType='Number' propertyType='simple'>	" +
		"			<mappingDef tableName='tblQuestionnaire' columnName='q36_1'/>	" +
		"		</propertyDef>	" +
		"		<propertyDef propertyName='" + KEY_Q36_2 + "' valueType='Number' propertyType='simple'>	" +
		"			<mappingDef tableName='tblQuestionnaire' columnName='q36_2'/>	" +
		"		</propertyDef>	" +
		"		<propertyDef propertyName='" + KEY_Q36_3 + "' valueType='Number' propertyType='simple'>	" +
		"			<mappingDef tableName='tblQuestionnaire' columnName='q36_3'/>	" +
		"		</propertyDef>	" +
		"		<propertyDef propertyName='" + KEY_Q36_4 + "' valueType='Number' propertyType='simple'>	" +
		"			<mappingDef tableName='tblQuestionnaire' columnName='q36_4'/>	" +
		"		</propertyDef>	" +
		"		<propertyDef propertyName='" + KEY_Q36_5 + "' valueType='Number' propertyType='simple'>	" +
		"			<mappingDef tableName='tblQuestionnaire' columnName='q36_5'/>	" +
		"		</propertyDef>	" +
		"		<propertyDef propertyName='" + KEY_Q36_6 + "' valueType='Number' propertyType='simple'>	" +
		"			<mappingDef tableName='tblQuestionnaire' columnName='q36_6'/>	" +
		"		</propertyDef>	" +
		"		<propertyDef propertyName='" + KEY_Q36_7 + "' valueType='Number' propertyType='simple'>	" +
		"			<mappingDef tableName='tblQuestionnaire' columnName='q36_7'/>	" +
		"		</propertyDef>	" +
		"		<propertyDef propertyName='" + KEY_Q37_1 + "' valueType='Number' propertyType='simple'>	" +
		"			<mappingDef tableName='tblQuestionnaire' columnName='q37_1'/>	" +
		"		</propertyDef>	" +
		"		<propertyDef propertyName='" + KEY_Q37_2 + "' valueType='Number' propertyType='simple'>	" +
		"			<mappingDef tableName='tblQuestionnaire' columnName='q37_2'/>	" +
		"		</propertyDef>	" +
		"		<propertyDef propertyName='" + KEY_Q37_3 + "' valueType='Number' propertyType='simple'>	" +
		"			<mappingDef tableName='tblQuestionnaire' columnName='q37_3'/>	" +
		"		</propertyDef>	" +
		"		<propertyDef propertyName='" + KEY_Q37_4 + "' valueType='Number' propertyType='simple'>	" +
		"			<mappingDef tableName='tblQuestionnaire' columnName='q37_4'/>	" +
		"		</propertyDef>	" +
		"		<propertyDef propertyName='" + KEY_Q37_5 + "' valueType='Number' propertyType='simple'>	" +
		"			<mappingDef tableName='tblQuestionnaire' columnName='q37_5'/>	" +
		"		</propertyDef>	" +
		"		<propertyDef propertyName='" + KEY_Q37_6 + "' valueType='Number' propertyType='simple'>	" +
		"			<mappingDef tableName='tblQuestionnaire' columnName='q37_6'/>	" +
		"		</propertyDef>	" +
		"		<propertyDef propertyName='" + KEY_Q37_7 + "' valueType='Number' propertyType='simple'>	" +
		"			<mappingDef tableName='tblQuestionnaire' columnName='q37_7'/>	" +
		"		</propertyDef>	" +
		"		<propertyDef propertyName='" + KEY_Q37_8 + "' valueType='Number' propertyType='simple'>	" +
		"			<mappingDef tableName='tblQuestionnaire' columnName='q37_8'/>	" +
		"		</propertyDef>	" +
		"		<propertyDef propertyName='" + KEY_Q38 + "' valueType='Number' propertyType='simple'>	" +
		"			<mappingDef tableName='tblQuestionnaire' columnName='q38'/>	" +
		"		</propertyDef>	" +
		"		<propertyDef propertyName='" + KEY_Q39 + "' valueType='Number' propertyType='simple'>	" +
		"			<mappingDef tableName='tblQuestionnaire' columnName='q39'/>	" +
		"		</propertyDef>	" +
		"		<propertyDef propertyName='" + KEY_Q40 + "' valueType='Number' propertyType='simple'>	" +
		"			<mappingDef tableName='tblQuestionnaire' columnName='q40'/>	" +
		"		</propertyDef>	" +
		"		<propertyDef propertyName='" + KEY_Q41 + "' valueType='Number' propertyType='simple'>	" +
		"			<mappingDef tableName='tblQuestionnaire' columnName='q41'/>	" +
		"		</propertyDef>	" +
		"		<propertyDef propertyName='" + KEY_Q42 + "' valueType='Number' propertyType='simple'>	" +
		"			<mappingDef tableName='tblQuestionnaire' columnName='q42'/>	" +
		"		</propertyDef>	" +
		"		<propertyDef propertyName='" + KEY_Q43 + "' valueType='Number' propertyType='simple'>	" +
		"			<mappingDef tableName='tblQuestionnaire' columnName='q43'/>	" +
		"		</propertyDef>	" +
		"		<propertyDef propertyName='" + KEY_Q44 + "' valueType='Number' propertyType='simple'>	" +
		"			<mappingDef tableName='tblQuestionnaire' columnName='q44'/>	" +
		"		</propertyDef>	" +
		"		<propertyDef propertyName='" + KEY_Q45 + "' valueType='Number' propertyType='simple'>	" +
		"			<mappingDef tableName='tblQuestionnaire' columnName='q45'/>	" +
		"		</propertyDef>	" +
		"		<propertyDef propertyName='" + KEY_Q46 + "' valueType='Number' propertyType='simple'>	" +
		"			<mappingDef tableName='tblQuestionnaire' columnName='q46'/>	" +
		"		</propertyDef>	" +
		"		<propertyDef propertyName='" + KEY_Q47 + "' valueType='Number' propertyType='simple'>	" +
		"			<mappingDef tableName='tblQuestionnaire' columnName='q47'/>	" +
		"		</propertyDef>	" +
		"		<propertyDef propertyName='" + KEY_Q48 + "' valueType='Number' propertyType='simple'>	" +
		"			<mappingDef tableName='tblQuestionnaire' columnName='q48'/>	" +
		"		</propertyDef>	" +
		"		<propertyDef propertyName='" + KEY_Q49 + "' valueType='Number' propertyType='simple'>	" +
		"			<mappingDef tableName='tblQuestionnaire' columnName='q49'/>	" +
		"		</propertyDef>	" +
		"		<propertyDef propertyName='" + KEY_Q50 + "' valueType='String' propertyType='simple'>	" +
		"			<mappingDef tableName='tblQuestionnaire' columnName='q50'/>	" +
		"		</propertyDef>	" +
		"		<propertyDef propertyName='" + KEY_Q51 + "' valueType='Number' propertyType='simple'>	" +
		"			<mappingDef tableName='tblQuestionnaire' columnName='q51'/>	" +
		"		</propertyDef>	" +
		"		<propertyDef propertyName='" + KEY_Q52 + "' valueType='Number' propertyType='simple'>	" +
		"			<mappingDef tableName='tblQuestionnaire' columnName='q52'/>	" +
		"		</propertyDef>	" +
		"		<propertyDef propertyName='" + KEY_Q53 + "' valueType='String' propertyType='simple'>	" +
		"			<mappingDef tableName='tblQuestionnaire' columnName='q53'/>	" +
		"		</propertyDef>	" +
		"		<propertyDef propertyName='" + KEY_CREATION + "' valueType='Timestamp' propertyType='simple'>	" +
		"			<mappingDef tableName='tblQuestionnaire' columnName='dtCreation'/>	" +
		"		</propertyDef>	" +
		"	</propertyDefs>	" +
		"</objectDef>";

	/**
	 * QuestionnaireHomeImpl default constructor.
	 * 
	 */
	public QuestionnaireHomeImpl() {
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

	public void saveData(QuestionnaireContext inContext) throws BOMException {
		try {
			DomainObject lEntry = create();
			
			String lQuestionId = "q";
			for (int i = 1; i < 36; i++) {
				lQuestionId = "q" + String.valueOf(i);
				lEntry.set(lQuestionId, parseInt(inContext.getParameterValue(lQuestionId)));
			}
			saveGroup("q36_", 7, lEntry, inContext);
			saveGroup("q37_", 8, lEntry, inContext);
			lQuestionId = "q38";
			lEntry.set(lQuestionId, parseInt(inContext.getParameterValue(lQuestionId)));
			lQuestionId = "q39";
			lEntry.set(lQuestionId, parseInt(inContext.getParameterValue(lQuestionId)));
			lQuestionId = "q40";
			lEntry.set(lQuestionId, parseDouble(inContext.getParameterValue(lQuestionId)));

			for (int i = 41; i < 50; i++) {
				lQuestionId = "q" + String.valueOf(i);
				lEntry.set(lQuestionId, parseInt(inContext.getParameterValue(lQuestionId)));
			}
			lQuestionId = "q50";
			lEntry.set(lQuestionId, inContext.getParameterValue(lQuestionId));
			lQuestionId = "q51";
			lEntry.set(lQuestionId, parseInt(inContext.getParameterValue(lQuestionId)));
			lQuestionId = "q52";
			lEntry.set(lQuestionId, parseDouble(inContext.getParameterValue(lQuestionId)));
			lQuestionId = "q53";
			lEntry.set(lQuestionId, inContext.getParameterValue(lQuestionId));
			
			lEntry.set("UserID", inContext.getUserID());
			lEntry.set("Language", inContext.getLanguage());
			lEntry.set("Anonymous", inContext.getAnonymous());
			lEntry.set("ResponseTime", calculateResponseTime(inContext.getTime()));
			lEntry.set("Site", inContext.getSite());
			
			lEntry.insert(true);
		}
		catch (SettingException exc) {
			throw new BOMException(exc.getMessage());
		}
		catch (SQLException exc) {
			throw new BOMException(exc.getMessage());
		}
	}
	
	private void saveGroup(String inQuestion, int inTo, DomainObject inEntry, QuestionnaireContext inContext) throws SettingException {
		String lQuestionId = "";
		for (int i = 1; i <= inTo; i++) {
			lQuestionId = inQuestion + String.valueOf(i);
			inEntry.set(lQuestionId, parseInt(inContext.getParameterValue(lQuestionId)));
		}
	}
	
	private Double calculateResponseTime(Long inStartTime) {
		double lTime = System.currentTimeMillis() - inStartTime.longValue();
		return new Double(lTime / 60000);
	}
	
	private Integer parseInt(String inIntegerString) {
		int lInteger = 0;
		try {
			lInteger = Integer.parseInt(inIntegerString);
		}
		catch (NumberFormatException exc) {
			lInteger = -1;
		}
		return new Integer(lInteger);
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
}
