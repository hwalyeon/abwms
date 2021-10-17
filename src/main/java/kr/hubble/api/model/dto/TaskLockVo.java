package kr.hubble.api.model.dto;

import java.io.Serializable;

/**
 * TASK_LOCK Value Object
 */
public class TaskLockVo implements Serializable {

	/* LOCK_KEY char(36) */
	private String lockKey;

	/* REGION varchar(100) */
	private String region;

	/* CLIENT_ID char(36) */
	private String clientId;

	/* CREATED_DATE datetime(null) */
	private String createdDate;


	/**
	 * Get LOCK_KEY char(36)
	 * @Return String lockKey
	 */
	public String getLockKey() {
		return this.lockKey;
	}
	
	/**
	 * Set LOCK_KEY char(36)
	 * @Param String lockKey
	 */
	public void setLockKey(String lockKey) {
		this.lockKey = lockKey;
	}
	/**
	 * Get REGION varchar(100)
	 * @Return String region
	 */
	public String getRegion() {
		return this.region;
	}
	
	/**
	 * Set REGION varchar(100)
	 * @Param String region
	 */
	public void setRegion(String region) {
		this.region = region;
	}
	/**
	 * Get CLIENT_ID char(36)
	 * @Return String clientId
	 */
	public String getClientId() {
		return this.clientId;
	}
	
	/**
	 * Set CLIENT_ID char(36)
	 * @Param String clientId
	 */
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	/**
	 * Get CREATED_DATE datetime(null)
	 * @Return String createdDate
	 */
	public String getCreatedDate() {
		return this.createdDate;
	}
	
	/**
	 * Set CREATED_DATE datetime(null)
	 * @Param String createdDate
	 */
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

} // end of class
