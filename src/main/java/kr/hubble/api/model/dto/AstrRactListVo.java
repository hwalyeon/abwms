package kr.hubble.api.model.dto;

import java.io.Serializable;

/**
 * ASTR_RACT_LIST Value Object
 */
public class AstrRactListVo implements Serializable {

	/* ASTR_SEQ A스토리_순번 int(0,0) */
	private String astrSeq;

	/* USER_ID 사용자_ID varchar(50) */
	private String userId;

	/* RACT_DIV_CD 반응_구분_코드 varchar(10) */
	private String ractDivCd;

	/* REG_USER_ID 등록_사용자_ID varchar(50) */
	private String regUserId;

	/* REG_DTTM 등록_일시 char(14) */
	private String regDttm;

	/* UPT_USER_ID 수정_사용자_ID varchar(50) */
	private String uptUserId;

	/* UPT_DTTM 수정_일시 char(14) */
	private String uptDttm;


	/**
	 * Get ASTR_SEQ A스토리_순번 int(0,0)
	 * @Return String astrSeq
	 */
	public String getAstrSeq() {
		return this.astrSeq;
	}
	
	/**
	 * Set ASTR_SEQ A스토리_순번 int(0,0)
	 * @Param String astrSeq
	 */
	public void setAstrSeq(String astrSeq) {
		this.astrSeq = astrSeq;
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
	 * Get RACT_DIV_CD 반응_구분_코드 varchar(10)
	 * @Return String ractDivCd
	 */
	public String getRactDivCd() {
		return this.ractDivCd;
	}
	
	/**
	 * Set RACT_DIV_CD 반응_구분_코드 varchar(10)
	 * @Param String ractDivCd
	 */
	public void setRactDivCd(String ractDivCd) {
		this.ractDivCd = ractDivCd;
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
