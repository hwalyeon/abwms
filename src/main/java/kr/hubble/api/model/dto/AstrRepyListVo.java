package kr.hubble.api.model.dto;

import java.io.Serializable;

/**
 * ASTR_REPY_LIST Value Object
 */
public class AstrRepyListVo implements Serializable {

	/* ASTR_SEQ A스토리_순번 int(0,0) */
	private String astrSeq;

	/* SEQ 순번 int(0,0) */
	private String seq;

	/* USER_ID 사용자_ID varchar(50) */
	private String userId;

	/* REPY_TXT 댓글_내용 mediumtext(16777215) */
	private String repyTxt;

	/* CRTD_DTTM 작성_일시 char(14) */
	private String crtdDttm;

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
	 * Get REPY_TXT 댓글_내용 mediumtext(16777215)
	 * @Return String repyTxt
	 */
	public String getRepyTxt() {
		return this.repyTxt;
	}
	
	/**
	 * Set REPY_TXT 댓글_내용 mediumtext(16777215)
	 * @Param String repyTxt
	 */
	public void setRepyTxt(String repyTxt) {
		this.repyTxt = repyTxt;
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
