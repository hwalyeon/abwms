package kr.hubble.api.model.dto;

import java.io.Serializable;

/**
 * MY_PRDT Value Object
 */
public class MyPrdtVo implements Serializable {

	/* MY_PRDT_SEQ MY제품_순번 int(0,0) */
	private String myPrdtSeq;

	/* USER_ID 사용자_ID varchar(50) */
	private String userId;

	/* PRDT_ID 제품_ID varchar(10) */
	private String prdtId;

	/* PRDT_SN 제품_시리얼번호 varchar(50) */
	private String prdtSn;

	/* BUY_DT 구매_일자 char(8) */
	private String buyDt;

	/* BILL_FILE_SEQ 영수증_파일_순번 int(0,0) */
	private String billFileSeq;

	/* REG_USER_ID 등록_사용자_ID varchar(50) */
	private String regUserId;

	/* REG_DTTM 등록_일시 char(14) */
	private String regDttm;

	/* UPT_USER_ID 수정_사용자_ID varchar(50) */
	private String uptUserId;

	/* UPT_DTTM 수정_일시 char(14) */
	private String uptDttm;


	/**
	 * Get MY_PRDT_SEQ MY제품_순번 int(0,0)
	 * @Return String myPrdtSeq
	 */
	public String getMyPrdtSeq() {
		return this.myPrdtSeq;
	}
	
	/**
	 * Set MY_PRDT_SEQ MY제품_순번 int(0,0)
	 * @Param String myPrdtSeq
	 */
	public void setMyPrdtSeq(String myPrdtSeq) {
		this.myPrdtSeq = myPrdtSeq;
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
	 * Get PRDT_SN 제품_시리얼번호 varchar(50)
	 * @Return String prdtSn
	 */
	public String getPrdtSn() {
		return this.prdtSn;
	}
	
	/**
	 * Set PRDT_SN 제품_시리얼번호 varchar(50)
	 * @Param String prdtSn
	 */
	public void setPrdtSn(String prdtSn) {
		this.prdtSn = prdtSn;
	}
	/**
	 * Get BUY_DT 구매_일자 char(8)
	 * @Return String buyDt
	 */
	public String getBuyDt() {
		return this.buyDt;
	}
	
	/**
	 * Set BUY_DT 구매_일자 char(8)
	 * @Param String buyDt
	 */
	public void setBuyDt(String buyDt) {
		this.buyDt = buyDt;
	}
	/**
	 * Get BILL_FILE_SEQ 영수증_파일_순번 int(0,0)
	 * @Return String billFileSeq
	 */
	public String getBillFileSeq() {
		return this.billFileSeq;
	}
	
	/**
	 * Set BILL_FILE_SEQ 영수증_파일_순번 int(0,0)
	 * @Param String billFileSeq
	 */
	public void setBillFileSeq(String billFileSeq) {
		this.billFileSeq = billFileSeq;
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
