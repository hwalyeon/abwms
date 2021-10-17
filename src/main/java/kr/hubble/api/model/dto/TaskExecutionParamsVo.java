package kr.hubble.api.model.dto;

import java.io.Serializable;

/**
 * TASK_EXECUTION_PARAMS Value Object
 */
public class TaskExecutionParamsVo implements Serializable {

	/* TASK_EXECUTION_ID bigint(0,0) */
	private String taskExecutionId;

	/* TASK_PARAM varchar(2500) */
	private String taskParam;


	/**
	 * Get TASK_EXECUTION_ID bigint(0,0)
	 * @Return String taskExecutionId
	 */
	public String getTaskExecutionId() {
		return this.taskExecutionId;
	}
	
	/**
	 * Set TASK_EXECUTION_ID bigint(0,0)
	 * @Param String taskExecutionId
	 */
	public void setTaskExecutionId(String taskExecutionId) {
		this.taskExecutionId = taskExecutionId;
	}
	/**
	 * Get TASK_PARAM varchar(2500)
	 * @Return String taskParam
	 */
	public String getTaskParam() {
		return this.taskParam;
	}
	
	/**
	 * Set TASK_PARAM varchar(2500)
	 * @Param String taskParam
	 */
	public void setTaskParam(String taskParam) {
		this.taskParam = taskParam;
	}

} // end of class
