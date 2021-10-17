package kr.hubble.api.model.dto;

import java.io.Serializable;

/**
 * NOTI_BASE Value Object
 */
public class NotiBaseVo implements Serializable {

	/* NOTI_SEQ 공지사항_순번 int(0,0) */
	private String notiSeq;

	/* NOTI_TITL 공지사항_제목 varchar(50) */
	private String notiTitl;

	/* NOTI_TXT 공지사항_내용 mediumtext(16777215) */
	private String notiTxt;

	/* REG_USER_ID 등록_사용자_ID varchar(50) */
	private String regUserId;

	/* REG_DTTM 등록_일시 char(14) */
	private String regDttm;

	/* UPT_USER_ID 수정_사용자_ID varchar(50) */
	private String uptUserId;

	/* UPT_DTTM 수정_일시 char(14) */
	private String uptDttm;

	/* CRTD_DTTM 작성_일자 char(14) */
	private String crtdDttm;


	/**
	 * Get NOTI_SEQ 공지사항_순번 int(0,0)
	 * @Return String notiSeq
	 */
	public String getNotiSeq() {
		return this.notiSeq;
	}
	
	/**
	 * Set NOTI_SEQ 공지사항_순번 int(0,0)
	 * @Param String notiSeq
	 */
	public void setNotiSeq(String notiSeq) {
		this.notiSeq = notiSeq;
	}
	/**
	 * Get NOTI_TITL 공지사항_제목 varchar(50)
	 * @Return String notiTitl
	 */
	public String getNotiTitl() {
		return this.notiTitl;
	}
	
	/**
	 * Set NOTI_TITL 공지사항_제목 varchar(50)
	 * @Param String notiTitl
	 */
	public void setNotiTitl(String notiTitl) {
		this.notiTitl = notiTitl;
	}
	/**
	 * Get NOTI_TXT 공지사항_내용 mediumtext(16777215)
	 * @Return String notiTxt
	 */
	public String getNotiTxt() {
		return this.notiTxt;
	}
	
	/**
	 * Set NOTI_TXT 공지사항_내용 mediumtext(16777215)
	 * @Param String notiTxt
	 */
	public void setNotiTxt(String notiTxt) {
		this.notiTxt = notiTxt;
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
	/**
	 * Get CRTD_DTTM 작성_일자 char(14)
	 * @Return String crtdDttm
	 */
	public String getCrtdDttm() {
		return this.crtdDttm;
	}
	
	/**
	 * Set CRTD_DTTM 작성_일자 char(14)
	 * @Param String crtdDttm
	 */
	public void setCrtdDttm(String crtdDttm) {
		this.crtdDttm = crtdDttm;
	}

} // end of class
