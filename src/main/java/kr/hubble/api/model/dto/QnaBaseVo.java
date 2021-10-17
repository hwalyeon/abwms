package kr.hubble.api.model.dto;

import java.io.Serializable;

/**
 * QNA_BASE Value Object
 */
public class QnaBaseVo implements Serializable {

	/* QNA_SEQ 문의_순번 int(0,0) */
	private String qnaSeq;

	/* USER_ID 사용자_ID varchar(50) */
	private String userId;

	/* QNA_NM 문의_이름 varchar(10) */
	private String qnaNm;

	/* QNA_TEL 문의_연락처 varchar(15) */
	private String qnaTel;

	/* QNA_EMAL 문의_이메일 varchar(50) */
	private String qnaEmal;

	/* CNST_DIV_CD 상담_구분_코드 varchar(10) */
	private String cnstDivCd;

	/* CNST_STAT_CD 상담_상태_코드 varchar(10) */
	private String cnstStatCd;

	/* QNA_TITL 문의_제목 varchar(50) */
	private String qnaTitl;

	/* QNA_TXT 문의_내용 mediumtext(16777215) */
	private String qnaTxt;

	/* QNA_DTTM 문의_일시 char(14) */
	private String qnaDttm;

	/* TRMS_DTTM 약관_일시 char(14) */
	private String trmsDttm;

	/* RPLY_TXT 답변_내용 mediumtext(16777215) */
	private String rplyTxt;

	/* RPLY_DTTM 답변_일시 char(14) */
	private String rplyDttm;

	/* REG_USER_ID 등록_사용자_ID varchar(50) */
	private String regUserId;

	/* REG_DTTM 등록_일시 char(14) */
	private String regDttm;

	/* UPT_USER_ID 수정_사용자_ID varchar(50) */
	private String uptUserId;

	/* UPT_DTTM 수정_일시 char(14) */
	private String uptDttm;


	/**
	 * Get QNA_SEQ 문의_순번 int(0,0)
	 * @Return String qnaSeq
	 */
	public String getQnaSeq() {
		return this.qnaSeq;
	}
	
	/**
	 * Set QNA_SEQ 문의_순번 int(0,0)
	 * @Param String qnaSeq
	 */
	public void setQnaSeq(String qnaSeq) {
		this.qnaSeq = qnaSeq;
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
	 * Get QNA_NM 문의_이름 varchar(10)
	 * @Return String qnaNm
	 */
	public String getQnaNm() {
		return this.qnaNm;
	}
	
	/**
	 * Set QNA_NM 문의_이름 varchar(10)
	 * @Param String qnaNm
	 */
	public void setQnaNm(String qnaNm) {
		this.qnaNm = qnaNm;
	}
	/**
	 * Get QNA_TEL 문의_연락처 varchar(15)
	 * @Return String qnaTel
	 */
	public String getQnaTel() {
		return this.qnaTel;
	}
	
	/**
	 * Set QNA_TEL 문의_연락처 varchar(15)
	 * @Param String qnaTel
	 */
	public void setQnaTel(String qnaTel) {
		this.qnaTel = qnaTel;
	}
	/**
	 * Get QNA_EMAL 문의_이메일 varchar(50)
	 * @Return String qnaEmal
	 */
	public String getQnaEmal() {
		return this.qnaEmal;
	}
	
	/**
	 * Set QNA_EMAL 문의_이메일 varchar(50)
	 * @Param String qnaEmal
	 */
	public void setQnaEmal(String qnaEmal) {
		this.qnaEmal = qnaEmal;
	}
	/**
	 * Get CNST_DIV_CD 상담_구분_코드 varchar(10)
	 * @Return String cnstDivCd
	 */
	public String getCnstDivCd() {
		return this.cnstDivCd;
	}
	
	/**
	 * Set CNST_DIV_CD 상담_구분_코드 varchar(10)
	 * @Param String cnstDivCd
	 */
	public void setCnstDivCd(String cnstDivCd) {
		this.cnstDivCd = cnstDivCd;
	}
	/**
	 * Get CNST_STAT_CD 상담_상태_코드 varchar(10)
	 * @Return String cnstStatCd
	 */
	public String getCnstStatCd() {
		return this.cnstStatCd;
	}
	
	/**
	 * Set CNST_STAT_CD 상담_상태_코드 varchar(10)
	 * @Param String cnstStatCd
	 */
	public void setCnstStatCd(String cnstStatCd) {
		this.cnstStatCd = cnstStatCd;
	}
	/**
	 * Get QNA_TITL 문의_제목 varchar(50)
	 * @Return String qnaTitl
	 */
	public String getQnaTitl() {
		return this.qnaTitl;
	}
	
	/**
	 * Set QNA_TITL 문의_제목 varchar(50)
	 * @Param String qnaTitl
	 */
	public void setQnaTitl(String qnaTitl) {
		this.qnaTitl = qnaTitl;
	}
	/**
	 * Get QNA_TXT 문의_내용 mediumtext(16777215)
	 * @Return String qnaTxt
	 */
	public String getQnaTxt() {
		return this.qnaTxt;
	}
	
	/**
	 * Set QNA_TXT 문의_내용 mediumtext(16777215)
	 * @Param String qnaTxt
	 */
	public void setQnaTxt(String qnaTxt) {
		this.qnaTxt = qnaTxt;
	}
	/**
	 * Get QNA_DTTM 문의_일시 char(14)
	 * @Return String qnaDttm
	 */
	public String getQnaDttm() {
		return this.qnaDttm;
	}
	
	/**
	 * Set QNA_DTTM 문의_일시 char(14)
	 * @Param String qnaDttm
	 */
	public void setQnaDttm(String qnaDttm) {
		this.qnaDttm = qnaDttm;
	}
	/**
	 * Get TRMS_DTTM 약관_일시 char(14)
	 * @Return String trmsDttm
	 */
	public String getTrmsDttm() {
		return this.trmsDttm;
	}
	
	/**
	 * Set TRMS_DTTM 약관_일시 char(14)
	 * @Param String trmsDttm
	 */
	public void setTrmsDttm(String trmsDttm) {
		this.trmsDttm = trmsDttm;
	}
	/**
	 * Get RPLY_TXT 답변_내용 mediumtext(16777215)
	 * @Return String rplyTxt
	 */
	public String getRplyTxt() {
		return this.rplyTxt;
	}
	
	/**
	 * Set RPLY_TXT 답변_내용 mediumtext(16777215)
	 * @Param String rplyTxt
	 */
	public void setRplyTxt(String rplyTxt) {
		this.rplyTxt = rplyTxt;
	}
	/**
	 * Get RPLY_DTTM 답변_일시 char(14)
	 * @Return String rplyDttm
	 */
	public String getRplyDttm() {
		return this.rplyDttm;
	}
	
	/**
	 * Set RPLY_DTTM 답변_일시 char(14)
	 * @Param String rplyDttm
	 */
	public void setRplyDttm(String rplyDttm) {
		this.rplyDttm = rplyDttm;
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
