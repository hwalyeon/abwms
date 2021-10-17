package kr.hubble.api.model.dto;

import java.io.Serializable;

/**
 * REVW_BASE Value Object
 */
public class RevwBaseVo implements Serializable {

	/* REVW_SEQ 리뷰_순번 int(0,0) */
	private String revwSeq;

	/* USER_ID 사용자_ID varchar(50) */
	private String userId;

	/* CRTD_DTTM 작성_일시 char(14) */
	private String crtdDttm;

	/* AS_SEQ AS_순번 int(0,0) */
	private String asSeq;

	/* REVW_TXT 리뷰_내용 mediumtext(16777215) */
	private String revwTxt;

	/* REVW_RPLY 리뷰_답변 mediumtext(16777215) */
	private String revwRply;

	/* RATE 평점 varchar(10) */
	private String rate;

	/* KIND_PNT 친절_점수 varchar(10) */
	private String kindPnt;

	/* FAST_PNT 신속_점수 varchar(10) */
	private String fastPnt;

	/* STSF_PNT 만족_점수 varchar(10) */
	private String stsfPnt;

	/* REG_USER_ID 등록_사용자_ID varchar(50) */
	private String regUserId;

	/* REG_DTTM 등록_일시 char(14) */
	private String regDttm;

	/* UPT_USER_ID 수정_사용자_ID varchar(50) */
	private String uptUserId;

	/* UPT_DTTM 수정_일시 char(14) */
	private String uptDttm;


	/**
	 * Get REVW_SEQ 리뷰_순번 int(0,0)
	 * @Return String revwSeq
	 */
	public String getRevwSeq() {
		return this.revwSeq;
	}
	
	/**
	 * Set REVW_SEQ 리뷰_순번 int(0,0)
	 * @Param String revwSeq
	 */
	public void setRevwSeq(String revwSeq) {
		this.revwSeq = revwSeq;
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
	 * Get AS_SEQ AS_순번 int(0,0)
	 * @Return String asSeq
	 */
	public String getAsSeq() {
		return this.asSeq;
	}
	
	/**
	 * Set AS_SEQ AS_순번 int(0,0)
	 * @Param String asSeq
	 */
	public void setAsSeq(String asSeq) {
		this.asSeq = asSeq;
	}
	/**
	 * Get REVW_TXT 리뷰_내용 mediumtext(16777215)
	 * @Return String revwTxt
	 */
	public String getRevwTxt() {
		return this.revwTxt;
	}
	
	/**
	 * Set REVW_TXT 리뷰_내용 mediumtext(16777215)
	 * @Param String revwTxt
	 */
	public void setRevwTxt(String revwTxt) {
		this.revwTxt = revwTxt;
	}
	/**
	 * Get REVW_RPLY 리뷰_답변 mediumtext(16777215)
	 * @Return String revwRply
	 */
	public String getRevwRply() {
		return this.revwRply;
	}
	
	/**
	 * Set REVW_RPLY 리뷰_답변 mediumtext(16777215)
	 * @Param String revwRply
	 */
	public void setRevwRply(String revwRply) {
		this.revwRply = revwRply;
	}
	/**
	 * Get RATE 평점 varchar(10)
	 * @Return String rate
	 */
	public String getRate() {
		return this.rate;
	}
	
	/**
	 * Set RATE 평점 varchar(10)
	 * @Param String rate
	 */
	public void setRate(String rate) {
		this.rate = rate;
	}
	/**
	 * Get KIND_PNT 친절_점수 varchar(10)
	 * @Return String kindPnt
	 */
	public String getKindPnt() {
		return this.kindPnt;
	}
	
	/**
	 * Set KIND_PNT 친절_점수 varchar(10)
	 * @Param String kindPnt
	 */
	public void setKindPnt(String kindPnt) {
		this.kindPnt = kindPnt;
	}
	/**
	 * Get FAST_PNT 신속_점수 varchar(10)
	 * @Return String fastPnt
	 */
	public String getFastPnt() {
		return this.fastPnt;
	}
	
	/**
	 * Set FAST_PNT 신속_점수 varchar(10)
	 * @Param String fastPnt
	 */
	public void setFastPnt(String fastPnt) {
		this.fastPnt = fastPnt;
	}
	/**
	 * Get STSF_PNT 만족_점수 varchar(10)
	 * @Return String stsfPnt
	 */
	public String getStsfPnt() {
		return this.stsfPnt;
	}
	
	/**
	 * Set STSF_PNT 만족_점수 varchar(10)
	 * @Param String stsfPnt
	 */
	public void setStsfPnt(String stsfPnt) {
		this.stsfPnt = stsfPnt;
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
