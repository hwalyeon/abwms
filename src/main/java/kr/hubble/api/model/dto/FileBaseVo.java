package kr.hubble.api.model.dto;

import java.io.Serializable;

/**
 * FILE_BASE Value Object
 */
public class FileBaseVo implements Serializable {

	/* FILE_SEQ 파일_순번 int(0,0) */
	private String fileSeq;

	/* BKIT_NM 버킷_명 varchar(50) */
	private String bkitNm;

	/* KEY_NM KEY_명 varchar(255) */
	private String keyNm;

	/* ETAG ETAG varchar(50) */
	private String etag;

	/* PHYS_NM 물리_명 varchar(255) */
	private String physNm;

	/* FILE_URL 파일_URL varchar(1000) */
	private String fileUrl;

	/* THMB_FILE_SEQ_01 썸네일_파일_순번_01 int(0,0) */
	private String thmbFileSeq01;

	/* THMB_FILE_SEQ_02 썸네일_파일_순번_02 int(0,0) */
	private String thmbFileSeq02;

	/* THMB_FILE_SEQ_03 썸네일_파일_순번_03 int(0,0) */
	private String thmbFileSeq03;

	/* REG_USER_ID 등록_사용자_ID varchar(50) */
	private String regUserId;

	/* REG_DTTM 등록_일시 char(14) */
	private String regDttm;

	/* UPT_USER_ID 수정_사용자_ID varchar(50) */
	private String uptUserId;

	/* UPT_DTTM 수정_일시 char(14) */
	private String uptDttm;


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
	 * Get BKIT_NM 버킷_명 varchar(50)
	 * @Return String bkitNm
	 */
	public String getBkitNm() {
		return this.bkitNm;
	}
	
	/**
	 * Set BKIT_NM 버킷_명 varchar(50)
	 * @Param String bkitNm
	 */
	public void setBkitNm(String bkitNm) {
		this.bkitNm = bkitNm;
	}
	/**
	 * Get KEY_NM KEY_명 varchar(255)
	 * @Return String keyNm
	 */
	public String getKeyNm() {
		return this.keyNm;
	}
	
	/**
	 * Set KEY_NM KEY_명 varchar(255)
	 * @Param String keyNm
	 */
	public void setKeyNm(String keyNm) {
		this.keyNm = keyNm;
	}
	/**
	 * Get ETAG ETAG varchar(50)
	 * @Return String etag
	 */
	public String getEtag() {
		return this.etag;
	}
	
	/**
	 * Set ETAG ETAG varchar(50)
	 * @Param String etag
	 */
	public void setEtag(String etag) {
		this.etag = etag;
	}
	/**
	 * Get PHYS_NM 물리_명 varchar(255)
	 * @Return String physNm
	 */
	public String getPhysNm() {
		return this.physNm;
	}
	
	/**
	 * Set PHYS_NM 물리_명 varchar(255)
	 * @Param String physNm
	 */
	public void setPhysNm(String physNm) {
		this.physNm = physNm;
	}
	/**
	 * Get FILE_URL 파일_URL varchar(1000)
	 * @Return String fileUrl
	 */
	public String getFileUrl() {
		return this.fileUrl;
	}
	
	/**
	 * Set FILE_URL 파일_URL varchar(1000)
	 * @Param String fileUrl
	 */
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	/**
	 * Get THMB_FILE_SEQ_01 썸네일_파일_순번_01 int(0,0)
	 * @Return String thmbFileSeq01
	 */
	public String getThmbFileSeq01() {
		return this.thmbFileSeq01;
	}
	
	/**
	 * Set THMB_FILE_SEQ_01 썸네일_파일_순번_01 int(0,0)
	 * @Param String thmbFileSeq01
	 */
	public void setThmbFileSeq01(String thmbFileSeq01) {
		this.thmbFileSeq01 = thmbFileSeq01;
	}
	/**
	 * Get THMB_FILE_SEQ_02 썸네일_파일_순번_02 int(0,0)
	 * @Return String thmbFileSeq02
	 */
	public String getThmbFileSeq02() {
		return this.thmbFileSeq02;
	}
	
	/**
	 * Set THMB_FILE_SEQ_02 썸네일_파일_순번_02 int(0,0)
	 * @Param String thmbFileSeq02
	 */
	public void setThmbFileSeq02(String thmbFileSeq02) {
		this.thmbFileSeq02 = thmbFileSeq02;
	}
	/**
	 * Get THMB_FILE_SEQ_03 썸네일_파일_순번_03 int(0,0)
	 * @Return String thmbFileSeq03
	 */
	public String getThmbFileSeq03() {
		return this.thmbFileSeq03;
	}
	
	/**
	 * Set THMB_FILE_SEQ_03 썸네일_파일_순번_03 int(0,0)
	 * @Param String thmbFileSeq03
	 */
	public void setThmbFileSeq03(String thmbFileSeq03) {
		this.thmbFileSeq03 = thmbFileSeq03;
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
