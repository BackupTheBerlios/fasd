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
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Vector;

import org.elbe.flow.tasks.impl.QuestionnaireContext;
import org.hip.kernel.bom.BOMException;
import org.hip.kernel.bom.DomainObject;
import org.hip.kernel.bom.KeyObject;
import org.hip.kernel.bom.SettingException;
import org.hip.kernel.bom.impl.DomainObjectHomeImpl;
import org.hip.kernel.bom.impl.KeyObjectImpl;
import org.hip.kernel.exc.VException;

/**
 * Pretest
 * 
 * Created on 02.05.2003
 * @author Luthiger
 */
public class QuestionnairePreHomeImpl extends DomainObjectHomeImpl implements QuestionnairePreHome {
	private final static String OBJECT_CLASS_NAME = "org.elbe.flow.bom.QuestionnairePreImpl";
	private int site_code = 0;

	private final static String XML_OBJECT_DEF = 
	"<?xml version='1.0' encoding='ISO-8859-1'?>	\n" +
	"<objectDef objectName='QuestionnairePre' parent='org.hip.kernel.bom.DomainObject' version='1.0'>	\n" +
	"	<keyDefs>	\n" +
	"		<keyDef>	\n" +
	"			<keyItemDef seq='0' keyPropertyName='" + KEY_ID + "'/>	\n" +
	"		</keyDef>	\n" +
	"	</keyDefs>	\n" +
	"	<propertyDefs>	\n" +
	"		<propertyDef propertyName='" + KEY_ID + "' valueType='Number' propertyType='simple'>	\n" +
	"			<mappingDef tableName='tblQuestionnairePre' columnName='QuestionnaireID'/>	\n" +
	"		</propertyDef>	\n" +
	"		<propertyDef propertyName='UserID' valueType='String' propertyType='simple'>	\n" +
	"			<mappingDef tableName='tblQuestionnairePre' columnName='sUserID'/>	\n" +
	"		</propertyDef>	\n" +
	"		<propertyDef propertyName='Language' valueType='String' propertyType='simple'>	\n" +
	"			<mappingDef tableName='tblQuestionnairePre' columnName='sLanguage'/>	\n" +
	"		</propertyDef>	\n" +
	"		<propertyDef propertyName='Anonymous' valueType='Number' propertyType='simple'>	\n" +
	"			<mappingDef tableName='tblQuestionnairePre' columnName='bAnonymous'/>	\n" +
	"		</propertyDef>	\n" +
	"		<propertyDef propertyName='ResponseTime' valueType='Number' propertyType='simple'>	\n" +
	"			<mappingDef tableName='tblQuestionnairePre' columnName='nResponseTime'/>	\n" +
	"		</propertyDef>	\n" +
	"		<propertyDef propertyName='Site' valueType='Number' propertyType='simple'>	\n" +
	"			<mappingDef tableName='tblQuestionnairePre' columnName='nSite'/>	\n" +
	"		</propertyDef>	\n" +
	"  <propertyDef propertyName='q1' valueType='Number' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q1'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q2' valueType='Number' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q2'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q3' valueType='Number' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q3'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q4' valueType='Number' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q4'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q5' valueType='Number' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q5'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q6' valueType='Number' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q6'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q7' valueType='Number' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q7'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q8' valueType='Number' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q8'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q9' valueType='Number' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q9'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q10' valueType='Number' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q10'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q11' valueType='Number' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q11'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q12' valueType='Number' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q12'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q13' valueType='Number' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q13'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q14' valueType='Number' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q14'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q15' valueType='Number' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q15'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q16' valueType='Number' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q16'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q17' valueType='Number' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q17'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q18' valueType='Number' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q18'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q19' valueType='Number' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q19'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q20' valueType='Number' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q20'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q21' valueType='Number' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q21'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q22' valueType='Number' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q22'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q23' valueType='Number' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q23'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q24' valueType='Number' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q24'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q25' valueType='Number' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q25'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q26' valueType='Number' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q26'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q27' valueType='Number' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q27'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q28' valueType='Number' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q28'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q29' valueType='Number' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q29'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q30' valueType='Number' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q30'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q31' valueType='Number' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q31'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q32' valueType='Number' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q32'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q33' valueType='Number' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q33'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q34' valueType='Number' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q34'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q35_1' valueType='Number' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q35_1'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q35_2' valueType='Number' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q35_2'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q35_3' valueType='Number' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q35_3'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q35_4' valueType='Number' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q35_4'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q35_5' valueType='Number' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q35_5'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q35_6' valueType='Number' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q35_6'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q35_7' valueType='Number' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q35_7'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q36_1' valueType='Number' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q36_1'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q36_2' valueType='Number' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q36_2'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q36_3' valueType='Number' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q36_3'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q36_4' valueType='Number' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q36_4'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q36_5' valueType='Number' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q36_5'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q36_6' valueType='Number' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q36_6'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q36_7' valueType='Number' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q36_7'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q36_8' valueType='Number' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q36_8'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q37' valueType='Number' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q37'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q38' valueType='Number' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q38'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q39' valueType='Number' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q39'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q40' valueType='Number' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q40'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q41' valueType='Number' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q41'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q42' valueType='Number' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q42'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q43' valueType='Number' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q43'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q44' valueType='Number' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q44'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q45' valueType='Number' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q45'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q46' valueType='Number' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q46'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q47' valueType='Number' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q47'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q48' valueType='Number' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q48'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q49' valueType='String' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q49'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q50' valueType='Number' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q50'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q51' valueType='Number' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q51'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q52' valueType='String' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q52'/> \n" +
	"  </propertyDef> \n" +
	"		<propertyDef propertyName='Creation' valueType='Timestamp' propertyType='simple'>	\n" +
	"			<mappingDef tableName='tblQuestionnairePre' columnName='dtCreation'/>	\n" +
	"		</propertyDef>	\n" +
	"	</propertyDefs>	\n" +
	"  <propertyDef propertyName='q1_pre' valueType='String' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q1_pre'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q3_pre' valueType='String' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q3_pre'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q5_pre' valueType='String' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q5_pre'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q6_pre' valueType='String' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q6_pre'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q10_pre' valueType='String' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q10_pre'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q11_pre' valueType='String' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q11_pre'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q13_1_pre' valueType='String' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q13_1_pre'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q13_2_pre' valueType='String' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q13_2_pre'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q21_pre' valueType='String' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q21_pre'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q29_pre' valueType='String' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q29_pre'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q30_pre' valueType='String' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q30_pre'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q31_1_pre' valueType='String' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q31_1_pre'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q31_2_pre' valueType='String' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q31_2_pre'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q33_pre' valueType='String' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q33_pre'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q35f_pre' valueType='String' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q35f_pre'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q35_pre' valueType='String' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q35_pre'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q36a_pre' valueType='String' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q36a_pre'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q36e_pre' valueType='String' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q36e_pre'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q36_pre' valueType='String' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q36_pre'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q36_pre2' valueType='String' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q36_pre2'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q37_1_pre' valueType='String' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q37_1_pre'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q37_2_pre' valueType='String' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q37_2_pre'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q38_pre' valueType='String' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q38_pre'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q39_1_pre' valueType='String' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q39_1_pre'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q39_2_pre' valueType='String' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q39_2_pre'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q40_pre' valueType='String' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q40_pre'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q41_pre' valueType='String' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q41_pre'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q46_pre' valueType='String' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q46_pre'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q47_pre' valueType='String' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q47_pre'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q_pre_1' valueType='String' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q_pre_1'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q_pre_2' valueType='String' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q_pre_2'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q_pre_3' valueType='String' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q_pre_3'/> \n" +
	"  </propertyDef> \n" +
	"  <propertyDef propertyName='q_pre_4' valueType='String' propertyType='simple'> \n" +
	"   <mappingDef tableName='tblQuestionnairePre' columnName='q_pre_4'/> \n" +
	"  </propertyDef> \n" +
	"</objectDef>";

	public QuestionnairePreHomeImpl() {
		super();
	}

	public String getObjectClassName() {
		return OBJECT_CLASS_NAME;
	}

	protected String getObjectDefString() {
		return XML_OBJECT_DEF;
	}

	protected Vector createTestObjects() {
		return null;
	}

	public BigDecimal saveData(QuestionnaireContext inContext) throws BOMException {
		try {
			DomainObject lEntry = create();
			
			String lQuestionId = "q";
			for (int i = 1; i < 35; i++) {
				lQuestionId = "q" + String.valueOf(i);
				lEntry.set(lQuestionId, parseInt(inContext.getParameterValue(lQuestionId)));
			}
			saveGroup("q35_", 7, lEntry, inContext);
			saveGroup("q36_", 8, lEntry, inContext);
			lQuestionId = "q37";
			lEntry.set(lQuestionId, parseInt(inContext.getParameterValue(lQuestionId)));
			lQuestionId = "q38";
			lEntry.set(lQuestionId, parseDouble(inContext.getParameterValue(lQuestionId)));
			lQuestionId = "q39";
			lEntry.set(lQuestionId, parseDouble(inContext.getParameterValue(lQuestionId)));

			for (int i = 40; i < 49; i++) {
				lQuestionId = "q" + String.valueOf(i);
				lEntry.set(lQuestionId, parseInt(inContext.getParameterValue(lQuestionId)));
			}
			lQuestionId = "q49";
			lEntry.set(lQuestionId, inContext.getParameterValue(lQuestionId));
			lQuestionId = "q50";
			lEntry.set(lQuestionId, parseInt(inContext.getParameterValue(lQuestionId)));
			lQuestionId = "q51";
			lEntry.set(lQuestionId, parseDouble(inContext.getParameterValue(lQuestionId)));
			lQuestionId = "q52";
			lEntry.set(lQuestionId, inContext.getParameterValue(lQuestionId));
			
			lEntry.set("UserID", inContext.getUserID());
			lEntry.set("Language", inContext.getLanguage());
			lEntry.set("Anonymous", inContext.getAnonymous());
			lEntry.set("ResponseTime", calculateResponseTime(inContext.getTime()));
			lEntry.set("Site", inContext.getSite());
			
			lEntry.insert(true);
			return getMax(KEY_ID);
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
	
	public QuestionnairePre getQuestionnaire(BigDecimal inQuestionnaireID) throws VException {
		KeyObject lKeyObject = new KeyObjectImpl();
		lKeyObject.setValue(KEY_ID, inQuestionnaireID);
		return (QuestionnairePre)findByKey(lKeyObject);
	}
	
	public QuestionnairePre initQuestionnaire() throws VException {
		try {
			DomainObject lEntry = create();
			lEntry.set("UserID", "Recovery");
			lEntry.insert(true);
			return getQuestionnaire(getMax(KEY_ID));
		}
		catch (SQLException exc) {
			throw new BOMException(exc.getMessage());
		}
	}
}
