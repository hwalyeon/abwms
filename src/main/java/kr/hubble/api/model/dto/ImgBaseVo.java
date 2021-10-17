package kr.hubble.api.model.dto;

import java.io.Serializable;

/**
 * IMG_BASE Value Object
 */
public class ImgBaseVo implements Serializable {

	/* IMG_SEQ 이미지_순번 int(0,0) */
	private String imgSeq;

	/* IMG_DIV_CD 이미지_구분_코드 varchar(10) */
	private String imgDivCd;

	/* IMG_TITL 이미지_제목 varchar(50) */
	private String imgTitl;

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
	 * Get IMG_SEQ 이미지_순번 int(0,0)
	 * @Return String imgSeq
	 */
	public String getImgSeq() {
		return this.imgSeq;
	}
	
	/**
	 * Set IMG_SEQ 이미지_순번 int(0,0)
	 * @Param String imgSeq
	 */
	public void setImgSeq(String imgSeq) {
		this.imgSeq = imgSeq;
	}
	/**
	 * Get IMG_DIV_CD 이미지_구분_코드 varchar(10)
	 * @Return String imgDivCd
	 */
	public String getImgDivCd() {
		return this.imgDivCd;
	}
	
	/**
	 * Set IMG_DIV_CD 이미지_구분_코드 varchar(10)
	 * @Param String imgDivCd
	 */
	public void setImgDivCd(String imgDivCd) {
		this.imgDivCd = imgDivCd;
	}
	/**
	 * Get IMG_TITL 이미지_제목 varchar(50)
	 * @Return String imgTitl
	 */
	public String getImgTitl() {
		return this.imgTitl;
	}
	
	/**
	 * Set IMG_TITL 이미지_제목 varchar(50)
	 * @Param String imgTitl
	 */
	public void setImgTitl(String imgTitl) {
		this.imgTitl = imgTitl;
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
