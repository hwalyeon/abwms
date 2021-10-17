package kr.hubble.api.model.dto;

import java.io.Serializable;

/**
 * EVT_BASE Value Object
 */
public class EvtBaseVo implements Serializable {

	/* EVT_SEQ 이벤트_순번 int(0,0) */
	private String evtSeq;

	/* EVT_TITL 이벤트_제목 varchar(50) */
	private String evtTitl;

	/* EVT_TXT 이벤트_내용 mediumtext(16777215) */
	private String evtTxt;

	/* BNNR_SEQ 배너_순번 int(0,0) */
	private String bnnrSeq;

	/* STRT_DTTM 시작_일시 char(14) */
	private String strtDttm;

	/* END_DTTM 종료_일시 char(14) */
	private String endDttm;

	/* SRCH_CNT 조회_횟수 int(0,0) */
	private String srchCnt;

	/* REG_USER_ID 등록_사용자_ID varchar(50) */
	private String regUserId;

	/* REG_DTTM 등록_일시 char(14) */
	private String regDttm;

	/* UPT_USER_ID 수정_사용자_ID varchar(50) */
	private String uptUserId;

	/* UPT_DTTM 수정_일시 char(14) */
	private String uptDttm;


	/**
	 * Get EVT_SEQ 이벤트_순번 int(0,0)
	 * @Return String evtSeq
	 */
	public String getEvtSeq() {
		return this.evtSeq;
	}
	
	/**
	 * Set EVT_SEQ 이벤트_순번 int(0,0)
	 * @Param String evtSeq
	 */
	public void setEvtSeq(String evtSeq) {
		this.evtSeq = evtSeq;
	}
	/**
	 * Get EVT_TITL 이벤트_제목 varchar(50)
	 * @Return String evtTitl
	 */
	public String getEvtTitl() {
		return this.evtTitl;
	}
	
	/**
	 * Set EVT_TITL 이벤트_제목 varchar(50)
	 * @Param String evtTitl
	 */
	public void setEvtTitl(String evtTitl) {
		this.evtTitl = evtTitl;
	}
	/**
	 * Get EVT_TXT 이벤트_내용 mediumtext(16777215)
	 * @Return String evtTxt
	 */
	public String getEvtTxt() {
		return this.evtTxt;
	}
	
	/**
	 * Set EVT_TXT 이벤트_내용 mediumtext(16777215)
	 * @Param String evtTxt
	 */
	public void setEvtTxt(String evtTxt) {
		this.evtTxt = evtTxt;
	}
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
	 * Get STRT_DTTM 시작_일시 char(14)
	 * @Return String strtDttm
	 */
	public String getStrtDttm() {
		return this.strtDttm;
	}
	
	/**
	 * Set STRT_DTTM 시작_일시 char(14)
	 * @Param String strtDttm
	 */
	public void setStrtDttm(String strtDttm) {
		this.strtDttm = strtDttm;
	}
	/**
	 * Get END_DTTM 종료_일시 char(14)
	 * @Return String endDttm
	 */
	public String getEndDttm() {
		return this.endDttm;
	}
	
	/**
	 * Set END_DTTM 종료_일시 char(14)
	 * @Param String endDttm
	 */
	public void setEndDttm(String endDttm) {
		this.endDttm = endDttm;
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
