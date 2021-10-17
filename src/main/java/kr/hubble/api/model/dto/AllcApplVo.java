package kr.hubble.api.model.dto;

import java.io.Serializable;

/**
 * ALLC_APPL Value Object
 */
public class AllcApplVo implements Serializable {

	/* ALLC_APPL_SEQ 제휴_신청_순번 int(0,0) */
	private String allcApplSeq;

	/* ALLC_DIV_CD 제휴_구분_코드 varchar(10) */
	private String allcDivCd;

	/* COMP_NM 업체_명 varchar(50) */
	private String compNm;

	/* SVC_INTR 서비스_소개 mediumtext(16777215) */
	private String svcIntr;

	/* GODS_CTNT 상품_설명 mediumtext(16777215) */
	private String godsCtnt;

	/* USE_PRIC 이용_가격 mediumtext(16777215) */
	private String usePric;

	/* Q_TXT 질문_내용 mediumtext(16777215) */
	private String qTxt;

	/* TEL 연락처 varchar(15) */
	private String tel;

	/* REG_USER_ID 등록_사용자_ID varchar(50) */
	private String regUserId;

	/* REG_DTTM 등록_일시 char(14) */
	private String regDttm;

	/* UPT_USER_ID 수정_사용자_ID varchar(50) */
	private String uptUserId;

	/* UPT_DTTM 수정_일시 char(14) */
	private String uptDttm;


	/**
	 * Get ALLC_APPL_SEQ 제휴_신청_순번 int(0,0)
	 * @Return String allcApplSeq
	 */
	public String getAllcApplSeq() {
		return this.allcApplSeq;
	}
	
	/**
	 * Set ALLC_APPL_SEQ 제휴_신청_순번 int(0,0)
	 * @Param String allcApplSeq
	 */
	public void setAllcApplSeq(String allcApplSeq) {
		this.allcApplSeq = allcApplSeq;
	}
	/**
	 * Get ALLC_DIV_CD 제휴_구분_코드 varchar(10)
	 * @Return String allcDivCd
	 */
	public String getAllcDivCd() {
		return this.allcDivCd;
	}
	
	/**
	 * Set ALLC_DIV_CD 제휴_구분_코드 varchar(10)
	 * @Param String allcDivCd
	 */
	public void setAllcDivCd(String allcDivCd) {
		this.allcDivCd = allcDivCd;
	}
	/**
	 * Get COMP_NM 업체_명 varchar(50)
	 * @Return String compNm
	 */
	public String getCompNm() {
		return this.compNm;
	}
	
	/**
	 * Set COMP_NM 업체_명 varchar(50)
	 * @Param String compNm
	 */
	public void setCompNm(String compNm) {
		this.compNm = compNm;
	}
	/**
	 * Get SVC_INTR 서비스_소개 mediumtext(16777215)
	 * @Return String svcIntr
	 */
	public String getSvcIntr() {
		return this.svcIntr;
	}
	
	/**
	 * Set SVC_INTR 서비스_소개 mediumtext(16777215)
	 * @Param String svcIntr
	 */
	public void setSvcIntr(String svcIntr) {
		this.svcIntr = svcIntr;
	}
	/**
	 * Get GODS_CTNT 상품_설명 mediumtext(16777215)
	 * @Return String godsCtnt
	 */
	public String getGodsCtnt() {
		return this.godsCtnt;
	}
	
	/**
	 * Set GODS_CTNT 상품_설명 mediumtext(16777215)
	 * @Param String godsCtnt
	 */
	public void setGodsCtnt(String godsCtnt) {
		this.godsCtnt = godsCtnt;
	}
	/**
	 * Get USE_PRIC 이용_가격 mediumtext(16777215)
	 * @Return String usePric
	 */
	public String getUsePric() {
		return this.usePric;
	}
	
	/**
	 * Set USE_PRIC 이용_가격 mediumtext(16777215)
	 * @Param String usePric
	 */
	public void setUsePric(String usePric) {
		this.usePric = usePric;
	}
	/**
	 * Get Q_TXT 질문_내용 mediumtext(16777215)
	 * @Return String qTxt
	 */
	public String getQTxt() {
		return this.qTxt;
	}
	
	/**
	 * Set Q_TXT 질문_내용 mediumtext(16777215)
	 * @Param String qTxt
	 */
	public void setQTxt(String qTxt) {
		this.qTxt = qTxt;
	}
	/**
	 * Get TEL 연락처 varchar(15)
	 * @Return String tel
	 */
	public String getTel() {
		return this.tel;
	}
	
	/**
	 * Set TEL 연락처 varchar(15)
	 * @Param String tel
	 */
	public void setTel(String tel) {
		this.tel = tel;
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
