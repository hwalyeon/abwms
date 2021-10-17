package kr.hubble.api.model.dto;

import java.io.Serializable;

/**
 * PRDT_AR_BTN Value Object
 */
public class PrdtArBtnVo implements Serializable {

	/* PRDT_ID 제품_ID varchar(10) */
	private String prdtId;

	/* BTN_ID 버튼_ID varchar(50) */
	private String btnId;

	/* BTN_NM 버튼_명 varchar(50) */
	private String btnNm;

	/* BTN_INFO 버튼_정보 mediumtext(16777215) */
	private String btnInfo;

	/* SEQ 순번 int(0,0) */
	private String seq;

	/* REG_USER_ID 등록_사용자_ID varchar(50) */
	private String regUserId;

	/* REG_DTTM 등록_일시 char(14) */
	private String regDttm;

	/* UPT_USER_ID 수정_사용자_ID varchar(50) */
	private String uptUserId;

	/* UPT_DTTM 수정_일시 char(14) */
	private String uptDttm;


	/**
	 * Get PRDT_ID 제품_ID varchar(10)
	 * @Return String prdtId
	 */
	public String getPrdtId() {
		return this.prdtId;
	}
	
	/**
	 * Set PRDT_ID 제품_ID varchar(10)
	 * @Param String prdtId
	 */
	public void setPrdtId(String prdtId) {
		this.prdtId = prdtId;
	}
	/**
	 * Get BTN_ID 버튼_ID varchar(50)
	 * @Return String btnId
	 */
	public String getBtnId() {
		return this.btnId;
	}
	
	/**
	 * Set BTN_ID 버튼_ID varchar(50)
	 * @Param String btnId
	 */
	public void setBtnId(String btnId) {
		this.btnId = btnId;
	}
	/**
	 * Get BTN_NM 버튼_명 varchar(50)
	 * @Return String btnNm
	 */
	public String getBtnNm() {
		return this.btnNm;
	}
	
	/**
	 * Set BTN_NM 버튼_명 varchar(50)
	 * @Param String btnNm
	 */
	public void setBtnNm(String btnNm) {
		this.btnNm = btnNm;
	}
	/**
	 * Get BTN_INFO 버튼_정보 mediumtext(16777215)
	 * @Return String btnInfo
	 */
	public String getBtnInfo() {
		return this.btnInfo;
	}
	
	/**
	 * Set BTN_INFO 버튼_정보 mediumtext(16777215)
	 * @Param String btnInfo
	 */
	public void setBtnInfo(String btnInfo) {
		this.btnInfo = btnInfo;
	}
	/**
	 * Get SEQ 순번 int(0,0)
	 * @Return String seq
	 */
	public String getSeq() {
		return this.seq;
	}
	
	/**
	 * Set SEQ 순번 int(0,0)
	 * @Param String seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
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
