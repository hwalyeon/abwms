package kr.hubble.api.model.dto;

import java.io.Serializable;

/**
 * SRCH_HIST Value Object
 */
public class SrchHistVo implements Serializable {

	/* SRCH_HIST_SEQ 검색_기록_순번 int(0,0) */
	private String srchHistSeq;

	/* USER_ID 사용자_ID varchar(50) */
	private String userId;

	/* SRCH_DIV_CD 검색_구분_코드 varchar(10) */
	private String srchDivCd;

	/* SRCH_TXT 검색_내용 varchar(200) */
	private String srchTxt;

	/* REG_USER_ID 등록_사용자_ID varchar(50) */
	private String regUserId;

	/* REG_DTTM 등록_일시 char(14) */
	private String regDttm;

	/* UPT_USER_ID 수정_사용자_ID varchar(50) */
	private String uptUserId;

	/* UPT_DTTM 수정_일시 char(14) */
	private String uptDttm;


	/**
	 * Get SRCH_HIST_SEQ 검색_기록_순번 int(0,0)
	 * @Return String srchHistSeq
	 */
	public String getSrchHistSeq() {
		return this.srchHistSeq;
	}
	
	/**
	 * Set SRCH_HIST_SEQ 검색_기록_순번 int(0,0)
	 * @Param String srchHistSeq
	 */
	public void setSrchHistSeq(String srchHistSeq) {
		this.srchHistSeq = srchHistSeq;
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
	 * Get SRCH_DIV_CD 검색_구분_코드 varchar(10)
	 * @Return String srchDivCd
	 */
	public String getSrchDivCd() {
		return this.srchDivCd;
	}
	
	/**
	 * Set SRCH_DIV_CD 검색_구분_코드 varchar(10)
	 * @Param String srchDivCd
	 */
	public void setSrchDivCd(String srchDivCd) {
		this.srchDivCd = srchDivCd;
	}
	/**
	 * Get SRCH_TXT 검색_내용 varchar(200)
	 * @Return String srchTxt
	 */
	public String getSrchTxt() {
		return this.srchTxt;
	}
	
	/**
	 * Set SRCH_TXT 검색_내용 varchar(200)
	 * @Param String srchTxt
	 */
	public void setSrchTxt(String srchTxt) {
		this.srchTxt = srchTxt;
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
