package kr.hubble.api.model.dto;

import java.io.Serializable;

/**
 * PRDT_AR_META Value Object
 */
public class PrdtArMetaVo implements Serializable {

	/* PRDT_ID 제품_ID varchar(10) */
	private String prdtId;

	/* AR_META_ID AR_메타_ID varchar(50) */
	private String arMetaId;

	/* META_FILE_SEQ 메타_파일_순번 int(0,0) */
	private String metaFileSeq;

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
	 * Get AR_META_ID AR_메타_ID varchar(50)
	 * @Return String arMetaId
	 */
	public String getArMetaId() {
		return this.arMetaId;
	}
	
	/**
	 * Set AR_META_ID AR_메타_ID varchar(50)
	 * @Param String arMetaId
	 */
	public void setArMetaId(String arMetaId) {
		this.arMetaId = arMetaId;
	}
	/**
	 * Get META_FILE_SEQ 메타_파일_순번 int(0,0)
	 * @Return String metaFileSeq
	 */
	public String getMetaFileSeq() {
		return this.metaFileSeq;
	}
	
	/**
	 * Set META_FILE_SEQ 메타_파일_순번 int(0,0)
	 * @Param String metaFileSeq
	 */
	public void setMetaFileSeq(String metaFileSeq) {
		this.metaFileSeq = metaFileSeq;
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
