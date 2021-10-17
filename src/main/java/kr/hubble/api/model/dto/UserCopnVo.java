package kr.hubble.api.model.dto;

import java.io.Serializable;

/**
 * USER_COPN Value Object
 */
public class UserCopnVo implements Serializable {

	/* COPN_CD 쿠폰_코드 varchar(30) */
	private String copnCd;

	/* USER_ID 사용자_ID varchar(50) */
	private String userId;

	/* COPN_ID 쿠폰_ID varchar(10) */
	private String copnId;

	/* ISS_DTTM 발급_일시 char(14) */
	private String issDttm;

	/* USE_DTTM 사용_일시 char(14) */
	private String useDttm;

	/* REG_USER_ID 등록_사용자_ID varchar(50) */
	private String regUserId;

	/* REG_DTTM 등록_일시 char(14) */
	private String regDttm;

	/* UPT_USER_ID 수정_사용자_ID varchar(50) */
	private String uptUserId;

	/* UPT_DTTM 수정_일시 char(14) */
	private String uptDttm;


	/**
	 * Get COPN_CD 쿠폰_코드 varchar(30)
	 * @Return String copnCd
	 */
	public String getCopnCd() {
		return this.copnCd;
	}
	
	/**
	 * Set COPN_CD 쿠폰_코드 varchar(30)
	 * @Param String copnCd
	 */
	public void setCopnCd(String copnCd) {
		this.copnCd = copnCd;
	}
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
	 * Get COPN_ID 쿠폰_ID varchar(10)
	 * @Return String copnId
	 */
	public String getCopnId() {
		return this.copnId;
	}
	
	/**
	 * Set COPN_ID 쿠폰_ID varchar(10)
	 * @Param String copnId
	 */
	public void setCopnId(String copnId) {
		this.copnId = copnId;
	}
	/**
	 * Get ISS_DTTM 발급_일시 char(14)
	 * @Return String issDttm
	 */
	public String getIssDttm() {
		return this.issDttm;
	}
	
	/**
	 * Set ISS_DTTM 발급_일시 char(14)
	 * @Param String issDttm
	 */
	public void setIssDttm(String issDttm) {
		this.issDttm = issDttm;
	}
	/**
	 * Get USE_DTTM 사용_일시 char(14)
	 * @Return String useDttm
	 */
	public String getUseDttm() {
		return this.useDttm;
	}
	
	/**
	 * Set USE_DTTM 사용_일시 char(14)
	 * @Param String useDttm
	 */
	public void setUseDttm(String useDttm) {
		this.useDttm = useDttm;
	}
	/**
	 * Get REG_USER_ID 등록_사용자_ID varchar(50)
	 * @Return String regUserId
	 */
	public String getRegUserId() {
		return this.regUserId;
	}
	
	/**
	 * Set REG_USER_ID 등록_사용자_ID varchar(50)
	 * @Param String regUserId
	 */
	public void setRegUserId(String regUserId) {
		this.regUserId = regUserId;
	}
	/**
	 * Get REG_DTTM 등록_일시 char(14)
	 * @Return String regDttm
	 */
	public String getRegDttm() {
		return this.regDttm;
	}
	
	/**
	 * Set REG_DTTM 등록_일시 char(14)
	 * @Param String regDttm
	 */
	public void setRegDttm(String regDttm) {
		this.regDttm = regDttm;
	}
	/**
	 * Get UPT_USER_ID 수정_사용자_ID varchar(50)
	 * @Return String uptUserId
	 */
	public String getUptUserId() {
		return this.uptUserId;
	}
	
	/**
	 * Set UPT_USER_ID 수정_사용자_ID varchar(50)
	 * @Param String uptUserId
	 */
	public void setUptUserId(String uptUserId) {
		this.uptUserId = uptUserId;
	}
	/**
	 * Get UPT_DTTM 수정_일시 char(14)
	 * @Return String uptDttm
	 */
	public String getUptDttm() {
		return this.uptDttm;
	}
	
	/**
	 * Set UPT_DTTM 수정_일시 char(14)
	 * @Param String uptDttm
	 */
	public void setUptDttm(String uptDttm) {
		this.uptDttm = uptDttm;
	}

} // end of class
