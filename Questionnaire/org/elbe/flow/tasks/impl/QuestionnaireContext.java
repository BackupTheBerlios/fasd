package org.elbe.flow.tasks.impl;

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
 
import org.hip.kernel.bom.DomainObject;
import org.hip.kernel.servlet.impl.AbstractContext;

/**
 * Abstract context for the questionnaire application.
 * 
 * Created on 16.04.2003
 * @author Luthiger
 */
public class QuestionnaireContext extends AbstractContext {
	//constants
	public final static String PROCESSING_INSTRUCTION	= "version=\"1.0\" encoding=\"ISO-8859-1\"";
	public final static String HEADER		= "<?xml " + PROCESSING_INSTRUCTION + "?>";
	public final static String ROOT_BEGIN = "<Root>";
	public final static String ROOT_END 	= "</Root>";
	
	public final static String KEY_ANONYMOUS	= "IsAnonymous";
	public final static String KEY_TIME 		= "ResponseTime";
	public final static String KEY_SITE 		= "SiteCode";
	
	private final static String KEY_QUESTIONNAIRE = "ActualQuestionnare";

	/**
	 * Default constructor.
	 */
	public QuestionnaireContext() {
		super();
	}
	
	/**
	 * Sets the time of the first request a user made.
	 * This setting can be used to calculate the time the user needed to fill
	 * the questionnaire.
	 * 
	 * @param inTime long Current time in millies.
	 */
	public void setTime(long inTime) {
		set(KEY_TIME, new Long(inTime));
	}
	
	public Long getTime() {
		return (Long)get(KEY_TIME);
	}
	
	/**
	 * Sets whether the user is anonymous or not.
	 * 
	 * @param inIsAnonymous boolean
	 */
	public void	setIsAnonymous(boolean inIsAnonymous) {
		set(KEY_ANONYMOUS, new Integer(inIsAnonymous ? 1 : 0));
	}
	
	public Integer getAnonymous() {
		return (Integer)get(KEY_ANONYMOUS);
	}
	
	public void setSite(int inSiteCode) {
		set(KEY_SITE, new Integer(inSiteCode));
	}
	
	public Integer getSite() {
		return (Integer)get(KEY_SITE);
	}
	
	public void setQuestionnare(DomainObject inQuestionnare) {
		set(KEY_QUESTIONNAIRE, inQuestionnare);
	}
	
	public DomainObject getQuestionnare() {
		return (DomainObject)get(KEY_QUESTIONNAIRE);
	}
}
