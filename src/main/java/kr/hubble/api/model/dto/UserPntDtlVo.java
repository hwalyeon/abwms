package kr.hubble.api.model.dto;

import java.io.Serializable;

/**
 * USER_PNT_DTL Value Object
 */
public class UserPntDtlVo implements Serializable {

	/* PNT_SEQ 포인트_순번 int(0,0) */
	private String pntSeq;

	/* USER_ID 사용자_ID varchar(50) */
	private String userId;

	/* PNT_VAL 포인트_값 int(0,0) */
	private String pntVal;

	/* EARN_USE_DTTM 적립_사용_일시 char(14) */
	private String earnUseDttm;

	/* EARN_LIST 적립_내역 varchar(50) */
	private String earnList;

	/* REG_USER_ID 등록_사용자_ID varchar(50) */
	private String regUserId;

	/* REG_DTTM 등록_일시 char(14) */
	private String regDttm;

	/* UPT_USER_ID 수정_사용자_ID varchar(50) */
	private String uptUserId;

	/* UPT_DTTM 수정_일시 char(14) */
	private String uptDttm;


	/**
	 * Get PNT_SEQ 포인트_순번 int(0,0)
	 * @Return String pntSeq
	 */
	public String getPntSeq() {
		return this.pntSeq;
	}
	
	/**
	 * Set PNT_SEQ 포인트_순번 int(0,0)
	 * @Param String pntSeq
	 */
	public void setPntSeq(String pntSeq) {
		this.pntSeq = pntSeq;
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
	 * Get PNT_VAL 포인트_값 int(0,0)
	 * @Return String pntVal
	 */
	public String getPntVal() {
		return this.pntVal;
	}
	
	/**
	 * Set PNT_VAL 포인트_값 int(0,0)
	 * @Param String pntVal
	 */
	public void setPntVal(String pntVal) {
		this.pntVal = pntVal;
	}
	/**
	 * Get EARN_USE_DTTM 적립_사용_일시 char(14)
	 * @Return String earnUseDttm
	 */
	public String getEarnUseDttm() {
		return this.earnUseDttm;
	}
	
	/**
	 * Set EARN_USE_DTTM 적립_사용_일시 char(14)
	 * @Param String earnUseDttm
	 */
	public void setEarnUseDttm(String earnUseDttm) {
		this.earnUseDttm = earnUseDttm;
	}
	/**
	 * Get EARN_LIST 적립_내역 varchar(50)
	 * @Return String earnList
	 */
	public String getEarnList() {
		return this.earnList;
	}
	
	/**
	 * Set EARN_LIST 적립_내역 varchar(50)
	 * @Param String earnList
	 */
	public void setEarnList(String earnList) {
		this.earnList = earnList;
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
