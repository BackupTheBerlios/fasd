package org.elbe.flow.bom.test;

import java.math.BigDecimal;

import org.elbe.flow.bom.QuestionnaireCom;
import org.elbe.flow.bom.QuestionnaireComHome;
import org.elbe.flow.tasks.impl.QuestionnaireContext;
import org.elbe.flow.util.Developer;
import org.hip.kernel.sys.VSys;

import junit.framework.TestCase;

/**
 * Created on 19.09.2003
 * @author Luthiger
 */
public class QuestionnaireComImplTest extends TestCase {
	private final static String QUESTIONNARE_HOME_CLASS_NAME	= "org.elbe.flow.bom.QuestionnaireComHomeImpl";
	private final static String MAIL = "test@dplanet.ch";
	private final static String NAME = "Gordon Bleu";		
	private final static String PASSWRD = "passwrdchze";		

	private BigDecimal questionnaire_id;

	/**
	 * Constructor for QuestionnaireComImplTest.
	 * @param arg0
	 */
	public QuestionnaireComImplTest(String arg0) {
		super(arg0);
	}

	protected void setUp() throws Exception {
		QuestionnaireComHome lHome = getQuestionnaireHome();
		Developer lDeveloper = new Developer("Herr", NAME, MAIL, PASSWRD); 
		lHome.createEntry(lDeveloper, new BigDecimal(88));
	}

	protected void tearDown() throws Exception {
		QuestionnaireComHome lHome = getQuestionnaireHome();
		BigDecimal lID = lHome.getMax(QuestionnaireComHome.KEY_ID);
		String lDelete = "DELETE FROM tblQuestionnaireCom WHERE QuestionnaireID = " + lID.toString();
//		System.out.println(lDelete);
		lHome.select(lDelete);
	}

	public void testCheckPasswrd() {
		try {
			QuestionnaireCom lQuestionnaire = getQuestionnaireHome().getQuestionnaire(MAIL);
			assertTrue("passwrd", lQuestionnaire.checkPasswrd(PASSWRD));
			assertFalse("not passwrd", lQuestionnaire.checkPasswrd("!" + PASSWRD));
		}
		catch (Exception exc) {
			fail(exc.getMessage());
		}
	}

	public void testCheckNotAnswered() {
		try {
			QuestionnaireComHome lHome = getQuestionnaireHome();
			QuestionnaireCom lQuestionnaire = lHome.getQuestionnaire(MAIL);
			assertTrue("not answered", lQuestionnaire.checkNotAnswered());
			lQuestionnaire.saveData(getContext());

			lQuestionnaire = lHome.getQuestionnaire(MAIL);
			assertFalse("answered", lQuestionnaire.checkNotAnswered());
		}
		catch (Exception exc) {
			fail(exc.getMessage());
		}
	}

	public void testSaveData() {
		try {
			QuestionnaireComHome lHome = getQuestionnaireHome();
			QuestionnaireCom lQuestionnaire = lHome.getQuestionnaire(MAIL);
			assertNull("q17", lQuestionnaire.get("q17"));
			lQuestionnaire.saveData(getContext());
			
			lQuestionnaire = lHome.getQuestionnaire(MAIL);
			assertEquals("q17 value", 17, ((BigDecimal)lQuestionnaire.get("q17")).intValue());
		}
		catch (Exception exc) {
			fail(exc.getMessage());
		}
	}

	private QuestionnaireComHome getQuestionnaireHome() {
		return (QuestionnaireComHome)VSys.homeManager.getHome(QUESTIONNARE_HOME_CLASS_NAME);
	}
	
	private QuestionnaireContext getContext() {
		QuestionnaireContext outContext = new QuestionnaireContext();
		String lQuestionId = "q";
		for (int i = 1; i < 44; i++) {
			lQuestionId = "q" + String.valueOf(i);
			outContext.setParameter(lQuestionId, String.valueOf(i));
		}
		outContext.setLanguage("de");
		outContext.setTime(System.currentTimeMillis());
		return outContext;
	}
}
