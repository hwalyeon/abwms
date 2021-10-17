package kr.hubble.api.model.dto;

import java.io.Serializable;

/**
 * TASK_EXECUTION Value Object
 */
public class TaskExecutionVo implements Serializable {

	/* TASK_EXECUTION_ID bigint(0,0) */
	private String taskExecutionId;

	/* START_TIME datetime(null) */
	private String startTime;

	/* END_TIME datetime(null) */
	private String endTime;

	/* TASK_NAME varchar(100) */
	private String taskName;

	/* EXIT_CODE int(0,0) */
	private String exitCode;

	/* EXIT_MESSAGE varchar(2500) */
	private String exitMessage;

	/* ERROR_MESSAGE varchar(2500) */
	private String errorMessage;

	/* LAST_UPDATED timestamp(null) */
	private String lastUpdated;

	/* EXTERNAL_EXECUTION_ID varchar(255) */
	private String externalExecutionId;

	/* PARENT_EXECUTION_ID bigint(0,0) */
	private String parentExecutionId;


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
	 * Get START_TIME datetime(null)
	 * @Return String startTime
	 */
	public String getStartTime() {
		return this.startTime;
	}
	
	/**
	 * Set START_TIME datetime(null)
	 * @Param String startTime
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	/**
	 * Get END_TIME datetime(null)
	 * @Return String endTime
	 */
	public String getEndTime() {
		return this.endTime;
	}
	
	/**
	 * Set END_TIME datetime(null)
	 * @Param String endTime
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	/**
	 * Get TASK_NAME varchar(100)
	 * @Return String taskName
	 */
	public String getTaskName() {
		return this.taskName;
	}
	
	/**
	 * Set TASK_NAME varchar(100)
	 * @Param String taskName
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	/**
	 * Get EXIT_CODE int(0,0)
	 * @Return String exitCode
	 */
	public String getExitCode() {
		return this.exitCode;
	}
	
	/**
	 * Set EXIT_CODE int(0,0)
	 * @Param String exitCode
	 */
	public void setExitCode(String exitCode) {
		this.exitCode = exitCode;
	}
	/**
	 * Get EXIT_MESSAGE varchar(2500)
	 * @Return String exitMessage
	 */
	public String getExitMessage() {
		return this.exitMessage;
	}
	
	/**
	 * Set EXIT_MESSAGE varchar(2500)
	 * @Param String exitMessage
	 */
	public void setExitMessage(String exitMessage) {
		this.exitMessage = exitMessage;
	}
	/**
	 * Get ERROR_MESSAGE varchar(2500)
	 * @Return String errorMessage
	 */
	public String getErrorMessage() {
		return this.errorMessage;
	}
	
	/**
	 * Set ERROR_MESSAGE varchar(2500)
	 * @Param String errorMessage
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	/**
	 * Get LAST_UPDATED timestamp(null)
	 * @Return String lastUpdated
	 */
	public String getLastUpdated() {
		return this.lastUpdated;
	}
	
	/**
	 * Set LAST_UPDATED timestamp(null)
	 * @Param String lastUpdated
	 */
	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	/**
	 * Get EXTERNAL_EXECUTION_ID varchar(255)
	 * @Return String externalExecutionId
	 */
	public String getExternalExecutionId() {
		return this.externalExecutionId;
	}
	
	/**
	 * Set EXTERNAL_EXECUTION_ID varchar(255)
	 * @Param String externalExecutionId
	 */
	public void setExternalExecutionId(String externalExecutionId) {
		this.externalExecutionId = externalExecutionId;
	}
	/**
	 * Get PARENT_EXECUTION_ID bigint(0,0)
	 * @Return String parentExecutionId
	 */
	public String getParentExecutionId() {
		return this.parentExecutionId;
	}
	
	/**
	 * Set PARENT_EXECUTION_ID bigint(0,0)
	 * @Param String parentExecutionId
	 */
	public void setParentExecutionId(String parentExecutionId) {
		this.parentExecutionId = parentExecutionId;
	}

} // end of class
