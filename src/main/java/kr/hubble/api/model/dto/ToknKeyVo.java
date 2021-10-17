package kr.hubble.api.model.dto;

import java.io.Serializable;

/**
 * TOKN_KEY Value Object
 */
public class ToknKeyVo implements Serializable {

	/* USER_ID 사용자_ID varchar(50) */
	private String userId;

	/* CLNT_ID 클라이언트_ID varchar(20) */
	private String clntId;

	/* KEY_VAL 키_값 varchar(32) */
	private String keyVal;


	/**
	 * Get USER_ID 사용자_ID varchar(50)
	 * @Return String userId
	 */
	public String getUserId() {
		return this.userId;
	}
	
	/**
	 * Set USER_ID 사용자_ID varchar(50)
	 * @Param String userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * Get CLNT_ID 클라이언트_ID varchar(20)
	 * @Return String clntId
	 */
	public String getClntId() {
		return this.clntId;
	}
	
	/**
	 * Set CLNT_ID 클라이언트_ID varchar(20)
	 * @Param String clntId
	 */
	public void setClntId(String clntId) {
		this.clntId = clntId;
	}
	/**
	 * Get KEY_VAL 키_값 varchar(32)
	 * @Return String keyVal
	 */
	public String getKeyVal() {
		return this.keyVal;
	}
	
	/**
	 * Set KEY_VAL 키_값 varchar(32)
	 * @Param String keyVal
	 */
	public void setKeyVal(String keyVal) {
		this.keyVal = keyVal;
	}

} // end of class
