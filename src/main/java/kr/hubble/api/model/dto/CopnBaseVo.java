package kr.hubble.api.model.dto;

import java.io.Serializable;

/**
 * COPN_BASE Value Object
 */
public class CopnBaseVo implements Serializable {

	/* COPN_ID 쿠폰_ID varchar(10) */
	private String copnId;

	/* COPN_NM 쿠폰_명 varchar(50) */
	private String copnNm;

	/* DSCT_CD 할인_코드 varchar(10) */
	private String dsctCd;

	/* COPN_VAL 쿠폰_값 float(12) */
	private String copnVal;

	/* COPN_PIRD 쿠폰_기간 int(0,0) */
	private String copnPird;

	/* REG_USER_ID 등록_사용자_ID varchar(50) */
	private String regUserId;

	/* REG_DTTM 등록_일시 char(14) */
	private String regDttm;

	/* UPT_USER_ID 수정_사용자_ID varchar(50) */
	private String uptUserId;

	/* UPT_DTTM 수정_일시 char(14) */
	private String uptDttm;


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
	 * Get COPN_NM 쿠폰_명 varchar(50)
	 * @Return String copnNm
	 */
	public String getCopnNm() {
		return this.copnNm;
	}
	
	/**
	 * Set COPN_NM 쿠폰_명 varchar(50)
	 * @Param String copnNm
	 */
	public void setCopnNm(String copnNm) {
		this.copnNm = copnNm;
	}
	/**
	 * Get DSCT_CD 할인_코드 varchar(10)
	 * @Return String dsctCd
	 */
	public String getDsctCd() {
		return this.dsctCd;
	}
	
	/**
	 * Set DSCT_CD 할인_코드 varchar(10)
	 * @Param String dsctCd
	 */
	public void setDsctCd(String dsctCd) {
		this.dsctCd = dsctCd;
	}
	/**
	 * Get COPN_VAL 쿠폰_값 float(12)
	 * @Return String copnVal
	 */
	public String getCopnVal() {
		return this.copnVal;
	}
	
	/**
	 * Set COPN_VAL 쿠폰_값 float(12)
	 * @Param String copnVal
	 */
	public void setCopnVal(String copnVal) {
		this.copnVal = copnVal;
	}
	/**
	 * Get COPN_PIRD 쿠폰_기간 int(0,0)
	 * @Return String copnPird
	 */
	public String getCopnPird() {
		return this.copnPird;
	}
	
	/**
	 * Set COPN_PIRD 쿠폰_기간 int(0,0)
	 * @Param String copnPird
	 */
	public void setCopnPird(String copnPird) {
		this.copnPird = copnPird;
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
