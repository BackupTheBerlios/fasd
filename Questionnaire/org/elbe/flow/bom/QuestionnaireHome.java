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

import org.elbe.flow.tasks.impl.QuestionnaireContext;
import org.hip.kernel.bom.BOMException;
import org.hip.kernel.bom.DomainObjectHome;

/**
 * 
 * Created on 02.05.2003
 * @author Luthiger
 */
public interface QuestionnaireHome extends DomainObjectHome {
	public final static String KEY_ID = "ID";
	public final static String KEY_USERID = "UserID";
	public final static String KEY_LANGUAGE = "Language";
	public final static String KEY_ANONYMOUS = "Anonymous";
	public final static String KEY_RESPONSETIME = "ResponseTime";
	public final static String KEY_SITE = "Site";
	public final static String KEY_Q1 = "q1";
	public final static String KEY_Q2 = "q2";
	public final static String KEY_Q3 = "q3";
	public final static String KEY_Q4 = "q4";
	public final static String KEY_Q5 = "q5";
	public final static String KEY_Q6 = "q6";
	public final static String KEY_Q7 = "q7";
	public final static String KEY_Q8 = "q8";
	public final static String KEY_Q9 = "q9";
	public final static String KEY_Q10 = "q10";
	public final static String KEY_Q11 = "q11";
	public final static String KEY_Q12 = "q12";
	public final static String KEY_Q13 = "q13";
	public final static String KEY_Q14 = "q14";
	public final static String KEY_Q15 = "q15";
	public final static String KEY_Q16 = "q16";
	public final static String KEY_Q17 = "q17";
	public final static String KEY_Q18 = "q18";
	public final static String KEY_Q19 = "q19";
	public final static String KEY_Q20 = "q20";
	public final static String KEY_Q21 = "q21";
	public final static String KEY_Q22 = "q22";
	public final static String KEY_Q23 = "q23";
	public final static String KEY_Q24 = "q24";
	public final static String KEY_Q25 = "q25";
	public final static String KEY_Q26 = "q26";
	public final static String KEY_Q27 = "q27";
	public final static String KEY_Q28 = "q28";
	public final static String KEY_Q29 = "q29";
	public final static String KEY_Q30 = "q30";
	public final static String KEY_Q31 = "q31";
	public final static String KEY_Q32 = "q32";
	public final static String KEY_Q33 = "q33";
	public final static String KEY_Q34 = "q34";
	public final static String KEY_Q35 = "q35";
	public final static String KEY_Q36_1 = "q36_1";
	public final static String KEY_Q36_2 = "q36_2";
	public final static String KEY_Q36_3 = "q36_3";
	public final static String KEY_Q36_4 = "q36_4";
	public final static String KEY_Q36_5 = "q36_5";
	public final static String KEY_Q36_6 = "q36_6";
	public final static String KEY_Q36_7 = "q36_7";
	public final static String KEY_Q37_1 = "q37_1";
	public final static String KEY_Q37_2 = "q37_2";
	public final static String KEY_Q37_3 = "q37_3";
	public final static String KEY_Q37_4 = "q37_4";
	public final static String KEY_Q37_5 = "q37_5";
	public final static String KEY_Q37_6 = "q37_6";
	public final static String KEY_Q37_7 = "q37_7";
	public final static String KEY_Q37_8 = "q37_8";
	public final static String KEY_Q38 = "q38";
	public final static String KEY_Q39 = "q39";
	public final static String KEY_Q40 = "q40";
	public final static String KEY_Q41 = "q41";
	public final static String KEY_Q42 = "q42";
	public final static String KEY_Q43 = "q43";
	public final static String KEY_Q44 = "q44";
	public final static String KEY_Q45 = "q45";
	public final static String KEY_Q46 = "q46";
	public final static String KEY_Q47 = "q47";
	public final static String KEY_Q48 = "q48";
	public final static String KEY_Q49 = "q49";
	public final static String KEY_Q50 = "q50";
	public final static String KEY_Q51 = "q51";
	public final static String KEY_Q52 = "q52";
	public final static String KEY_Q53 = "q53";
	public final static String KEY_CREATION = "Creation";

	void saveData(QuestionnaireContext inContext) throws BOMException;
}
