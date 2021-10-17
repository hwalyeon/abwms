package kr.hubble.api.model.dto;

import java.io.Serializable;

/**
 * CD Value Object
 */
public class CdVo implements Serializable {

	/* CD_GRP 코드_그룹 varchar(20) */
	private String cdGrp;

	/* CD 코드 varchar(10) */
	private String cd;

	/* CD_NM 코드_명 varchar(100) */
	private String cdNm;

	/* SORT_SEQ 정렬_순번 int(0,0) */
	private String sortSeq;

	/* UP_CD 상위_코드 varchar(10) */
	private String upCd;

	/* ETC_INFO_1 기타_정보_1 varchar(100) */
	private String etcInfo1;

	/* ETC_INFO_2 기타_정보_2 varchar(100) */
	private String etcInfo2;

	/* ETC_INFO_3 기타_정보_3 varchar(100) */
	private String etcInfo3;

	/* REG_USER_ID 등록_사용자_ID varchar(50) */
	private String regUserId;

	/* REG_DTTM 등록_일시 char(14) */
	private String regDttm;

	/* UPT_USER_ID 수정_사용자_ID varchar(50) */
	private String uptUserId;

	/* UPT_DTTM 수정_일시 char(14) */
	private String uptDttm;


	/**
	 * Get CD_GRP 코드_그룹 varchar(20)
	 * @Return String cdGrp
	 */
	public String getCdGrp() {
		return this.cdGrp;
	}
	
	/**
	 * Set CD_GRP 코드_그룹 varchar(20)
	 * @Param String cdGrp
	 */
	public void setCdGrp(String cdGrp) {
		this.cdGrp = cdGrp;
	}
	/**
	 * Get CD 코드 varchar(10)
	 * @Return String cd
	 */
	public String getCd() {
		return this.cd;
	}
	
	/**
	 * Set CD 코드 varchar(10)
	 * @Param String cd
	 */
	public void setCd(String cd) {
		this.cd = cd;
	}
	/**
	 * Get CD_NM 코드_명 varchar(100)
	 * @Return String cdNm
	 */
	public String getCdNm() {
		return this.cdNm;
	}
	
	/**
	 * Set CD_NM 코드_명 varchar(100)
	 * @Param String cdNm
	 */
	public void setCdNm(String cdNm) {
		this.cdNm = cdNm;
	}
	/**
	 * Get SORT_SEQ 정렬_순번 int(0,0)
	 * @Return String sortSeq
	 */
	public String getSortSeq() {
		return this.sortSeq;
	}
	
	/**
	 * Set SORT_SEQ 정렬_순번 int(0,0)
	 * @Param String sortSeq
	 */
	public void setSortSeq(String sortSeq) {
		this.sortSeq = sortSeq;
	}
	/**
	 * Get UP_CD 상위_코드 varchar(10)
	 * @Return String upCd
	 */
	public String getUpCd() {
		return this.upCd;
	}
	
	/**
	 * Set UP_CD 상위_코드 varchar(10)
	 * @Param String upCd
	 */
	public void setUpCd(String upCd) {
		this.upCd = upCd;
	}
	/**
	 * Get ETC_INFO_1 기타_정보_1 varchar(100)
	 * @Return String etcInfo1
	 */
	public String getEtcInfo1() {
		return this.etcInfo1;
	}
	
	/**
	 * Set ETC_INFO_1 기타_정보_1 varchar(100)
	 * @Param String etcInfo1
	 */
	public void setEtcInfo1(String etcInfo1) {
		this.etcInfo1 = etcInfo1;
	}
	/**
	 * Get ETC_INFO_2 기타_정보_2 varchar(100)
	 * @Return String etcInfo2
	 */
	public String getEtcInfo2() {
		return this.etcInfo2;
	}
	
	/**
	 * Set ETC_INFO_2 기타_정보_2 varchar(100)
	 * @Param String etcInfo2
	 */
	public void setEtcInfo2(String etcInfo2) {
		this.etcInfo2 = etcInfo2;
	}
	/**
	 * Get ETC_INFO_3 기타_정보_3 varchar(100)
	 * @Return String etcInfo3
	 */
	public String getEtcInfo3() {
		return this.etcInfo3;
	}
	
	/**
	 * Set ETC_INFO_3 기타_정보_3 varchar(100)
	 * @Param String etcInfo3
	 */
	public void setEtcInfo3(String etcInfo3) {
		this.etcInfo3 = etcInfo3;
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
