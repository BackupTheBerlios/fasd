package org.elbe.flow.util;

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

import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import org.hip.kernel.sys.VSys;

/**
 * 
 * Created on 01.05.2003
 * @author Luthiger
 */
public class QuestionnaireSys extends VSys {
	//constants
	private static final String ERR_MSG_BUNDLE_BASENAME = "FLOWErrMessages";
	private static final String MSG_BUNDLE_BASENAME 	= "FLOWMessages";
	
	/** a default Locale */
	private static final Locale cDefaultLocale = new Locale(dftLanguage, "");

	/**
	 * Returns a Message bundle for a specific locale.
	 * 
	 * @return java.util.ResourceBundle
	 * @param inLocale java.util.Locale the desired locale
	 */
	public static ResourceBundle getMessageBundle(Locale inLocale) {
		return PropertyResourceBundle.getBundle(MSG_BUNDLE_BASENAME, inLocale);
	}
	
	/**
	 * Returns a Message in a specific language.
	 * 
	 * @return java.lang.String
	 * @param inLanguage java.lang.String the desired language
	 * @param inId java.lang.String
	 */
	public static String getMessage(String inLanguage, String inId) {
		return getMessageBundle(new Locale(inLanguage, "")).getString(inId);
	}
}
