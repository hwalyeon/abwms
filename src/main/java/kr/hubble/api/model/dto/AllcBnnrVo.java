package kr.hubble.api.model.dto;

import java.io.Serializable;

/**
 * ALLC_BNNR Value Object
 */
public class AllcBnnrVo implements Serializable {

	/* BNNR_SEQ 배너_순번 int(0,0) */
	private String bnnrSeq;

	/* ALLC_ID 제휴사_ID varchar(10) */
	private String allcId;

	/* BNNR_TITL 배너_제목 varchar(50) */
	private String bnnrTitl;

	/* SORT_SEQ 정렬_순번 int(0,0) */
	private String sortSeq;

	/* APPL_STRT_DT 적용_시작_일자 char(8) */
	private String applStrtDt;

	/* APPL_END_DT 적용_종료_일자 char(8) */
	private String applEndDt;

	/* BNNR_FILE_SEQ 배너_파일_순번 int(0,0) */
	private String bnnrFileSeq;

	/* REG_DT 등록_일자 char(8) */
	private String regDt;

	/* REG_USER_ID 등록_사용자_ID varchar(50) */
	private String regUserId;

	/* REG_DTTM 등록_일시 char(14) */
	private String regDttm;

	/* UPT_USER_ID 수정_사용자_ID varchar(50) */
	private String uptUserId;

	/* UPT_DTTM 수정_일시 char(14) */
	private String uptDttm;


	/**
	 * Get BNNR_SEQ 배너_순번 int(0,0)
	 * @Return String bnnrSeq
	 */
	public String getBnnrSeq() {
		return this.bnnrSeq;
	}
	
	/**
	 * Set BNNR_SEQ 배너_순번 int(0,0)
	 * @Param String bnnrSeq
	 */
	public void setBnnrSeq(String bnnrSeq) {
		this.bnnrSeq = bnnrSeq;
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
	 * Get BNNR_TITL 배너_제목 varchar(50)
	 * @Return String bnnrTitl
	 */
	public String getBnnrTitl() {
		return this.bnnrTitl;
	}
	
	/**
	 * Set BNNR_TITL 배너_제목 varchar(50)
	 * @Param String bnnrTitl
	 */
	public void setBnnrTitl(String bnnrTitl) {
		this.bnnrTitl = bnnrTitl;
	}
	/**
	 * Get SORT_SEQ 정렬_순번 int(0,0)
	 * @Return String sortSeq
	 */
	public String getSortSeq() {
		return this.sortSeq;
	}
	
	/**
	 * Set SORT_SEQ 정렬_순번 int(0,0)
	 * @Param String sortSeq
	 */
	public void setSortSeq(String sortSeq) {
		this.sortSeq = sortSeq;
	}
	/**
	 * Get APPL_STRT_DT 적용_시작_일자 char(8)
	 * @Return String applStrtDt
	 */
	public String getApplStrtDt() {
		return this.applStrtDt;
	}
	
	/**
	 * Set APPL_STRT_DT 적용_시작_일자 char(8)
	 * @Param String applStrtDt
	 */
	public void setApplStrtDt(String applStrtDt) {
		this.applStrtDt = applStrtDt;
	}
	/**
	 * Get APPL_END_DT 적용_종료_일자 char(8)
	 * @Return String applEndDt
	 */
	public String getApplEndDt() {
		return this.applEndDt;
	}
	
	/**
	 * Set APPL_END_DT 적용_종료_일자 char(8)
	 * @Param String applEndDt
	 */
	public void setApplEndDt(String applEndDt) {
		this.applEndDt = applEndDt;
	}
	/**
	 * Get BNNR_FILE_SEQ 배너_파일_순번 int(0,0)
	 * @Return String bnnrFileSeq
	 */
	public String getBnnrFileSeq() {
		return this.bnnrFileSeq;
	}
	
	/**
	 * Set BNNR_FILE_SEQ 배너_파일_순번 int(0,0)
	 * @Param String bnnrFileSeq
	 */
	public void setBnnrFileSeq(String bnnrFileSeq) {
		this.bnnrFileSeq = bnnrFileSeq;
	}
	/**
	 * Get REG_DT 등록_일자 char(8)
	 * @Return String regDt
	 */
	public String getRegDt() {
		return this.regDt;
	}
	
	/**
	 * Set REG_DT 등록_일자 char(8)
	 * @Param String regDt
	 */
	public void setRegDt(String regDt) {
		this.regDt = regDt;
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
