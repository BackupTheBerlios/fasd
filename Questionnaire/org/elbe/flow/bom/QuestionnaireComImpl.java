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

import org.elbe.flow.tasks.impl.QuestionnaireContext;
import org.elbe.flow.util.UnixCrypt;
import org.hip.kernel.bom.BOMException;
import org.hip.kernel.bom.SettingException;
import org.hip.kernel.bom.impl.DomainObjectImpl;
import org.hip.kernel.exc.VException;

/**
 * 
 * Created on 02.05.2003
 * @author Luthiger
 */
public class QuestionnaireComImpl extends DomainObjectImpl implements QuestionnaireCom {
	private final static String HOME_CLASS_NAME = "org.elbe.flow.bom.QuestionnaireComHomeImpl";

	/**
	 * QuestionnaireImpl default constructor.
	 * 
	 */
	public QuestionnaireComImpl() {
		super();
	}

	/**
	 * @see org.hip.kernel.bom.GeneralDomainObject#getHomeClassName()
	 */
	public String getHomeClassName() {
		return HOME_CLASS_NAME;
	}
	
	/**
	 * Checks the login credentials.
	 * 
	 * @param inPasswrd String
	 * @return boolean
	 * @throws VException
	 */
	public boolean checkPasswrd(String inPasswrd) throws VException {
		return UnixCrypt.matches((String)get(QuestionnaireComHome.KEY_PASSWRD), inPasswrd);
	}
	
	/**
	 * Checks whether this questionnaire is answered yet.
	 * 
	 * @return boolean
	 * @throws VException
	 */
	public boolean checkNotAnswered() throws VException {
		return ((BigDecimal)get(QuestionnaireComHome.KEY_ANSWERED)).intValue() == 0;
	}
	
	public void saveData(QuestionnaireContext inContext) throws BOMException {
		try {
			String lQuestionId = "q";
			for (int i = 1; i < 44; i++) {
				lQuestionId = "q" + String.valueOf(i);
				set(lQuestionId, parseInt(inContext.getParameterValue(lQuestionId)));
			}
			lQuestionId = "q44";
			set(lQuestionId, inContext.getParameterValue(lQuestionId));
			lQuestionId = "q45";
			set(lQuestionId, parseInt(inContext.getParameterValue(lQuestionId)));
			lQuestionId = "q46";
			set(lQuestionId, parseDouble(inContext.getParameterValue(lQuestionId)));
			lQuestionId = "q47";
			set(lQuestionId, inContext.getParameterValue(lQuestionId));
			
			set(QuestionnaireComHome.KEY_LANGUAGE, inContext.getLanguage());
			set(QuestionnaireComHome.KEY_RESPONSE, calculateResponseTime(inContext.getTime()));
			set(QuestionnaireComHome.KEY_ANSWERED, new Integer(1));
			
			update(true);
		}
		catch (SettingException exc) {
			throw new BOMException(exc.getMessage());
		}
		catch (SQLException exc) {
			throw new BOMException(exc.getMessage());
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
