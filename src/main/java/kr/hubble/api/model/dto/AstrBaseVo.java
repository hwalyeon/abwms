package kr.hubble.api.model.dto;

import java.io.Serializable;

/**
 * ASTR_BASE Value Object
 */
public class AstrBaseVo implements Serializable {

	/* ASTR_SEQ A스토리_순번 int(0,0) */
	private String astrSeq;

	/* ASTR_TITL A스토리_제목 varchar(50) */
	private String astrTitl;

	/* ASTR_TXT A스토리_내용 mediumtext(16777215) */
	private String astrTxt;

	/* CRTD_DTTM 작성_일시 char(14) */
	private String crtdDttm;

	/* REPR_FILE_SEQ 대표_파일_순번 int(0,0) */
	private String reprFileSeq;

	/* SRCH_CNT 조회_횟수 int(0,0) */
	private String srchCnt;

	/* SHAR_CNT 공유_횟수 int(0,0) */
	private String sharCnt;

	/* REG_USER_ID 등록_사용자_ID varchar(50) */
	private String regUserId;

	/* REG_DTTM 등록_일시 char(14) */
	private String regDttm;

	/* UPT_USER_ID 수정_사용자_ID varchar(50) */
	private String uptUserId;

	/* UPT_DTTM 수정_일시 char(14) */
	private String uptDttm;


	/**
	 * Get ASTR_SEQ A스토리_순번 int(0,0)
	 * @Return String astrSeq
	 */
	public String getAstrSeq() {
		return this.astrSeq;
	}
	
	/**
	 * Set ASTR_SEQ A스토리_순번 int(0,0)
	 * @Param String astrSeq
	 */
	public void setAstrSeq(String astrSeq) {
		this.astrSeq = astrSeq;
	}
	/**
	 * Get ASTR_TITL A스토리_제목 varchar(50)
	 * @Return String astrTitl
	 */
	public String getAstrTitl() {
		return this.astrTitl;
	}
	
	/**
	 * Set ASTR_TITL A스토리_제목 varchar(50)
	 * @Param String astrTitl
	 */
	public void setAstrTitl(String astrTitl) {
		this.astrTitl = astrTitl;
	}
	/**
	 * Get ASTR_TXT A스토리_내용 mediumtext(16777215)
	 * @Return String astrTxt
	 */
	public String getAstrTxt() {
		return this.astrTxt;
	}
	
	/**
	 * Set ASTR_TXT A스토리_내용 mediumtext(16777215)
	 * @Param String astrTxt
	 */
	public void setAstrTxt(String astrTxt) {
		this.astrTxt = astrTxt;
	}
	/**
	 * Get CRTD_DTTM 작성_일시 char(14)
	 * @Return String crtdDttm
	 */
	public String getCrtdDttm() {
		return this.crtdDttm;
	}
	
	/**
	 * Set CRTD_DTTM 작성_일시 char(14)
	 * @Param String crtdDttm
	 */
	public void setCrtdDttm(String crtdDttm) {
		this.crtdDttm = crtdDttm;
	}
	/**
	 * Get REPR_FILE_SEQ 대표_파일_순번 int(0,0)
	 * @Return String reprFileSeq
	 */
	public String getReprFileSeq() {
		return this.reprFileSeq;
	}
	
	/**
	 * Set REPR_FILE_SEQ 대표_파일_순번 int(0,0)
	 * @Param String reprFileSeq
	 */
	public void setReprFileSeq(String reprFileSeq) {
		this.reprFileSeq = reprFileSeq;
	}
	/**
	 * Get SRCH_CNT 조회_횟수 int(0,0)
	 * @Return String srchCnt
	 */
	public String getSrchCnt() {
		return this.srchCnt;
	}
	
	/**
	 * Set SRCH_CNT 조회_횟수 int(0,0)
	 * @Param String srchCnt
	 */
	public void setSrchCnt(String srchCnt) {
		this.srchCnt = srchCnt;
	}
	/**
	 * Get SHAR_CNT 공유_횟수 int(0,0)
	 * @Return String sharCnt
	 */
	public String getSharCnt() {
		return this.sharCnt;
	}
	
	/**
	 * Set SHAR_CNT 공유_횟수 int(0,0)
	 * @Param String sharCnt
	 */
	public void setSharCnt(String sharCnt) {
		this.sharCnt = sharCnt;
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
