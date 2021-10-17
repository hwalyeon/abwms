package kr.hubble.api.model.dto;

import java.io.Serializable;

/**
 * TASK_SEQ Value Object
 */
public class TaskSeqVo implements Serializable {

	/* ID bigint(0,0) */
	private String id;

	/* UNIQUE_KEY char(1) */
	private String uniqueKey;


	/**
	 * Get ID bigint(0,0)
	 * @Return String id
	 */
	public String getId() {
		return this.id;
	}
	
	/**
	 * Set ID bigint(0,0)
	 * @Param String id
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * Get UNIQUE_KEY char(1)
	 * @Return String uniqueKey
	 */
	public String getUniqueKey() {
		return this.uniqueKey;
	}
	
	/**
	 * Set UNIQUE_KEY char(1)
	 * @Param String uniqueKey
	 */
	public void setUniqueKey(String uniqueKey) {
		this.uniqueKey = uniqueKey;
	}

} // end of class
