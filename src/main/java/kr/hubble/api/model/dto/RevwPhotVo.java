package kr.hubble.api.model.dto;

import java.io.Serializable;

/**
 * REVW_PHOT Value Object
 */
public class RevwPhotVo implements Serializable {

	/* REVW_SEQ 리뷰_순번 int(0,0) */
	private String revwSeq;

	/* SEQ 순번 int(0,0) */
	private String seq;

	/* FILE_SEQ 파일_순번 int(0,0) */
	private String fileSeq;

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
	 * Get FILE_SEQ 파일_순번 int(0,0)
	 * @Return String fileSeq
	 */
	public String getFileSeq() {
		return this.fileSeq;
	}
	
	/**
	 * Set FILE_SEQ 파일_순번 int(0,0)
	 * @Param String fileSeq
	 */
	public void setFileSeq(String fileSeq) {
		this.fileSeq = fileSeq;
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
