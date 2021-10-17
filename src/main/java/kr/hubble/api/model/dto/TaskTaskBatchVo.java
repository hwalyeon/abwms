package kr.hubble.api.model.dto;

import java.io.Serializable;

/**
 * TASK_TASK_BATCH Value Object
 */
public class TaskTaskBatchVo implements Serializable {

	/* TASK_EXECUTION_ID bigint(0,0) */
	private String taskExecutionId;

	/* JOB_EXECUTION_ID bigint(0,0) */
	private String jobExecutionId;


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
	 * Get JOB_EXECUTION_ID bigint(0,0)
	 * @Return String jobExecutionId
	 */
	public String getJobExecutionId() {
		return this.jobExecutionId;
	}
	
	/**
	 * Set JOB_EXECUTION_ID bigint(0,0)
	 * @Param String jobExecutionId
	 */
	public void setJobExecutionId(String jobExecutionId) {
		this.jobExecutionId = jobExecutionId;
	}

} // end of class
