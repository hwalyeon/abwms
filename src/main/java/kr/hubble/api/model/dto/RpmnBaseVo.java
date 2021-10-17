package kr.hubble.api.model.dto;

import java.io.Serializable;

/**
 * RPMN_BASE Value Object
 */
public class RpmnBaseVo implements Serializable {

	/* RPMN_ID 수리기사_ID varchar(10) */
	private String rpmnId;

	/* ASCT_ID AS센터_ID varchar(10) */
	private String asctId;

	/* RPMN_NM 수리기사_명 varchar(10) */
	private String rpmnNm;

	/* RPMN_TEL 수리기사_연락처 varchar(15) */
	private String rpmnTel;

	/* REG_USER_ID 등록_사용자_ID varchar(50) */
	private String regUserId;

	/* REG_DTTM 등록_일시 char(14) */
	private String regDttm;

	/* UPT_USER_ID 수정_사용자_ID varchar(50) */
	private String uptUserId;

	/* UPT_DTTM 수정_일시 char(14) */
	private String uptDttm;


	/**
	 * Get RPMN_ID 수리기사_ID varchar(10)
	 * @Return String rpmnId
	 */
	public String getRpmnId() {
		return this.rpmnId;
	}
	
	/**
	 * Set RPMN_ID 수리기사_ID varchar(10)
	 * @Param String rpmnId
	 */
	public void setRpmnId(String rpmnId) {
		this.rpmnId = rpmnId;
	}
	/**
	 * Get ASCT_ID AS센터_ID varchar(10)
	 * @Return String asctId
	 */
	public String getAsctId() {
		return this.asctId;
	}
	
	/**
	 * Set ASCT_ID AS센터_ID varchar(10)
	 * @Param String asctId
	 */
	public void setAsctId(String asctId) {
		this.asctId = asctId;
	}
	/**
	 * Get RPMN_NM 수리기사_명 varchar(10)
	 * @Return String rpmnNm
	 */
	public String getRpmnNm() {
		return this.rpmnNm;
	}
	
	/**
	 * Set RPMN_NM 수리기사_명 varchar(10)
	 * @Param String rpmnNm
	 */
	public void setRpmnNm(String rpmnNm) {
		this.rpmnNm = rpmnNm;
	}
	/**
	 * Get RPMN_TEL 수리기사_연락처 varchar(15)
	 * @Return String rpmnTel
	 */
	public String getRpmnTel() {
		return this.rpmnTel;
	}
	
	/**
	 * Set RPMN_TEL 수리기사_연락처 varchar(15)
	 * @Param String rpmnTel
	 */
	public void setRpmnTel(String rpmnTel) {
		this.rpmnTel = rpmnTel;
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
