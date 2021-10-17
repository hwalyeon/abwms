package kr.hubble.api.model.dto;

import java.io.Serializable;

/**
 * PRDT_AR_MANL Value Object
 */
public class PrdtArManlVo implements Serializable {

	/* PRDT_ID 제품_ID varchar(10) */
	private String prdtId;

	/* MANL_TITL 설명서_제목 varchar(50) */
	private String manlTitl;

	/* SORT_SEQ 정렬_순번 int(0,0) */
	private String sortSeq;

	/* MANL_TXT 설명서_내용 mediumtext(16777215) */
	private String manlTxt;

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
	 * Get MANL_TITL 설명서_제목 varchar(50)
	 * @Return String manlTitl
	 */
	public String getManlTitl() {
		return this.manlTitl;
	}
	
	/**
	 * Set MANL_TITL 설명서_제목 varchar(50)
	 * @Param String manlTitl
	 */
	public void setManlTitl(String manlTitl) {
		this.manlTitl = manlTitl;
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
	 * Get MANL_TXT 설명서_내용 mediumtext(16777215)
	 * @Return String manlTxt
	 */
	public String getManlTxt() {
		return this.manlTxt;
	}
	
	/**
	 * Set MANL_TXT 설명서_내용 mediumtext(16777215)
	 * @Param String manlTxt
	 */
	public void setManlTxt(String manlTxt) {
		this.manlTxt = manlTxt;
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
