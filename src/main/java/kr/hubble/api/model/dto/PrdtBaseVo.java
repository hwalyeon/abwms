package kr.hubble.api.model.dto;

import java.io.Serializable;

/**
 * PRDT_BASE Value Object
 */
public class PrdtBaseVo implements Serializable {

	/* PRDT_ID 제품_ID varchar(10) */
	private String prdtId;

	/* ALLC_ID 제휴사_ID varchar(10) */
	private String allcId;

	/* PRDT_NM 제품_명 varchar(50) */
	private String prdtNm;

	/* PRDT_NM_RT 제품_명_초성 varchar(50) */
	private String prdtNmRt;

	/* MODL_NM 모델_명 varchar(50) */
	private String modlNm;

	/* AS_PIRD AS_기간 int(0,0) */
	private String asPird;

	/* AR_YN AR_여부 char(1) */
	private String arYn;

	/* PRDT_CTNT 제품_설명 mediumtext(16777215) */
	private String prdtCtnt;

	/* DEL_YN 삭제_여부 char(1) */
	private String delYn;

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
	 * Get ALLC_ID 제휴사_ID varchar(10)
	 * @Return String allcId
	 */
	public String getAllcId() {
		return this.allcId;
	}
	
	/**
	 * Set ALLC_ID 제휴사_ID varchar(10)
	 * @Param String allcId
	 */
	public void setAllcId(String allcId) {
		this.allcId = allcId;
	}
	/**
	 * Get PRDT_NM 제품_명 varchar(50)
	 * @Return String prdtNm
	 */
	public String getPrdtNm() {
		return this.prdtNm;
	}
	
	/**
	 * Set PRDT_NM 제품_명 varchar(50)
	 * @Param String prdtNm
	 */
	public void setPrdtNm(String prdtNm) {
		this.prdtNm = prdtNm;
	}
	/**
	 * Get PRDT_NM_RT 제품_명_초성 varchar(50)
	 * @Return String prdtNmRt
	 */
	public String getPrdtNmRt() {
		return this.prdtNmRt;
	}
	
	/**
	 * Set PRDT_NM_RT 제품_명_초성 varchar(50)
	 * @Param String prdtNmRt
	 */
	public void setPrdtNmRt(String prdtNmRt) {
		this.prdtNmRt = prdtNmRt;
	}
	/**
	 * Get MODL_NM 모델_명 varchar(50)
	 * @Return String modlNm
	 */
	public String getModlNm() {
		return this.modlNm;
	}
	
	/**
	 * Set MODL_NM 모델_명 varchar(50)
	 * @Param String modlNm
	 */
	public void setModlNm(String modlNm) {
		this.modlNm = modlNm;
	}
	/**
	 * Get AS_PIRD AS_기간 int(0,0)
	 * @Return String asPird
	 */
	public String getAsPird() {
		return this.asPird;
	}
	
	/**
	 * Set AS_PIRD AS_기간 int(0,0)
	 * @Param String asPird
	 */
	public void setAsPird(String asPird) {
		this.asPird = asPird;
	}
	/**
	 * Get AR_YN AR_여부 char(1)
	 * @Return String arYn
	 */
	public String getArYn() {
		return this.arYn;
	}
	
	/**
	 * Set AR_YN AR_여부 char(1)
	 * @Param String arYn
	 */
	public void setArYn(String arYn) {
		this.arYn = arYn;
	}
	/**
	 * Get PRDT_CTNT 제품_설명 mediumtext(16777215)
	 * @Return String prdtCtnt
	 */
	public String getPrdtCtnt() {
		return this.prdtCtnt;
	}
	
	/**
	 * Set PRDT_CTNT 제품_설명 mediumtext(16777215)
	 * @Param String prdtCtnt
	 */
	public void setPrdtCtnt(String prdtCtnt) {
		this.prdtCtnt = prdtCtnt;
	}
	/**
	 * Get DEL_YN 삭제_여부 char(1)
	 * @Return String delYn
	 */
	public String getDelYn() {
		return this.delYn;
	}
	
	/**
	 * Set DEL_YN 삭제_여부 char(1)
	 * @Param String delYn
	 */
	public void setDelYn(String delYn) {
		this.delYn = delYn;
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
