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

import org.hip.kernel.servlet.Task;
import org.hip.kernel.servlet.TaskManager;
import org.hip.kernel.servlet.impl.AbstractTaskManager;

/**
 * Task manager of the questionnaire administration.
 * 
 * Created on 16.04.2003
 * @author Luthiger
 */
public class TaskManagerImpl extends AbstractTaskManager {
	private static final String DEFAULT_TASK_NAME 	= "startup";
	private static final String ERROR_TASK_NAME 	= "error";

	/**
	 * TaskManagerImpl singleton constructor.
	 */
	private TaskManagerImpl() {
		super();
		initialize();
	}

	/**
	 * Returns singelton of taskmanager.
	 *
	 * @return org.hip.kernel.servlet.TaskManager instance of task manager
	 */ 
	public static synchronized TaskManager getInstance() {
		if (cManager == null) {
			cManager = (TaskManager)new TaskManagerImpl();
		}
		return cManager;
	}
	
	/**
	 * Mapping of requested type to task which can handle the request
	 */
	protected void initialize() {
		taskMappingTable().put(DEFAULT_TASK_NAME, 	"org.elbe.flow.tasks.impl.StartupTask");
		taskMappingTable().put(ERROR_TASK_NAME, 	"org.elbe.flow.exc.ErrorTask");
		taskMappingTable().put("checkLogin", 		"org.elbe.flow.tasks.impl.LoginCheckTask");
		taskMappingTable().put("showQuestions", 	"org.elbe.flow.tasks.impl.QuestionsShowTask");
		taskMappingTable().put("followUp", 			"org.elbe.flow.tasks.impl.FollowUpCheckTask");
		taskMappingTable().put("saveData", 			"org.elbe.flow.tasks.impl.QuestionsSaveTask");
		//pretest
		taskMappingTable().put("checkLoginPre", 	"org.elbe.flow.tasks.impl.LoginCheckPreTask");
		taskMappingTable().put("saveDataPre", 		"org.elbe.flow.tasks.impl.QuestionsSavePreTask");
		taskMappingTable().put("savePretest", 		"org.elbe.flow.tasks.impl.QuestionsSavePre2Task");
		//qcom
		taskMappingTable().put("checkLoginQcom", 	"org.elbe.flow.tasks.impl.LoginCheckQcomTask");
		taskMappingTable().put("showQuestionsCom", 	"org.elbe.flow.tasks.impl.QuestionsComShowTask");
		taskMappingTable().put("saveQcom", 			"org.elbe.flow.tasks.impl.QuestionsComSaveTask");
	}

	/**
	 * Returns an instance of the default task.
	 *
	 * @return org.hip.kernel.servlet.Task
	 */
	public Task getDefaultTask() {
		return create(DEFAULT_TASK_NAME);
	}

	/**
	 * Returns an instance of the error task.
	 *
	 * @return org.hip.kernel.servlet.Task
	 */
	public Task getErrorTask() {
		return create(ERROR_TASK_NAME);
	}
}
