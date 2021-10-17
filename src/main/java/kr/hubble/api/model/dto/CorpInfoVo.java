package kr.hubble.api.model.dto;

import java.io.Serializable;

/**
 * CORP_INFO Value Object
 */
public class CorpInfoVo implements Serializable {

	/* SEQ 순번 int(0,0) */
	private String seq;

	/* CORP_NM 기업_명 varchar(10) */
	private String corpNm;

	/* CORP_NM_ENG 기업_명_영문 varchar(10) */
	private String corpNmEng;

	/* SITE_URL 사이트_URL varchar(255) */
	private String siteUrl;

	/* REPR_TEL 대표_연락처 varchar(15) */
	private String reprTel;

	/* FAX_NO 팩스_번호 varchar(15) */
	private String faxNo;

	/* ZIP 우편번호 varchar(6) */
	private String zip;

	/* ADDR 주소 varchar(100) */
	private String addr;

	/* BIZ_INFO 사업자_정보 varchar(200) */
	private String bizInfo;

	/* BIZ_REG_NO 사업자_등록_번호 varchar(13) */
	private String bizRegNo;

	/* CORP_NO 법인_번호 varchar(14) */
	private String corpNo;

	/* BRND 상호 varchar(10) */
	private String brnd;

	/* CEO_NM 대표자_명 varchar(10) */
	private String ceoNm;

	/* BDIV 업태 varchar(50) */
	private String bdiv;

	/* BTYP 종목 varchar(50) */
	private String btyp;

	/* ANDR_VER 안드로이드_버전 varchar(50) */
	private String andrVer;

	/* ANDR_DTTM 안드로이드_일시 varchar(14) */
	private String andrDttm;

	/* IOS_VER IOS_버전 varchar(50) */
	private String iosVer;

	/* IOS_DTTM IOS_일시 varchar(14) */
	private String iosDttm;

	/* USE_TRMS_TXT 이용_약관_내용 mediumtext(16777215) */
	private String useTrmsTxt;

	/* PRIV_TRMS_TXT 개인정보_약관_내용 mediumtext(16777215) */
	private String privTrmsTxt;

	/* AD_TRMS_TXT 광고_약관_내용 mediumtext(16777215) */
	private String adTrmsTxt;

	/* REG_USER_ID 등록_사용자_ID varchar(50) */
	private String regUserId;

	/* REG_DTTM 등록_일시 char(14) */
	private String regDttm;

	/* UPT_USER_ID 수정_사용자_ID varchar(50) */
	private String uptUserId;

	/* UPT_DTTM 수정_일시 char(14) */
	private String uptDttm;


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
	 * Get CORP_NM 기업_명 varchar(10)
	 * @Return String corpNm
	 */
	public String getCorpNm() {
		return this.corpNm;
	}
	
	/**
	 * Set CORP_NM 기업_명 varchar(10)
	 * @Param String corpNm
	 */
	public void setCorpNm(String corpNm) {
		this.corpNm = corpNm;
	}
	/**
	 * Get CORP_NM_ENG 기업_명_영문 varchar(10)
	 * @Return String corpNmEng
	 */
	public String getCorpNmEng() {
		return this.corpNmEng;
	}
	
	/**
	 * Set CORP_NM_ENG 기업_명_영문 varchar(10)
	 * @Param String corpNmEng
	 */
	public void setCorpNmEng(String corpNmEng) {
		this.corpNmEng = corpNmEng;
	}
	/**
	 * Get SITE_URL 사이트_URL varchar(255)
	 * @Return String siteUrl
	 */
	public String getSiteUrl() {
		return this.siteUrl;
	}
	
	/**
	 * Set SITE_URL 사이트_URL varchar(255)
	 * @Param String siteUrl
	 */
	public void setSiteUrl(String siteUrl) {
		this.siteUrl = siteUrl;
	}
	/**
	 * Get REPR_TEL 대표_연락처 varchar(15)
	 * @Return String reprTel
	 */
	public String getReprTel() {
		return this.reprTel;
	}
	
	/**
	 * Set REPR_TEL 대표_연락처 varchar(15)
	 * @Param String reprTel
	 */
	public void setReprTel(String reprTel) {
		this.reprTel = reprTel;
	}
	/**
	 * Get FAX_NO 팩스_번호 varchar(15)
	 * @Return String faxNo
	 */
	public String getFaxNo() {
		return this.faxNo;
	}
	
	/**
	 * Set FAX_NO 팩스_번호 varchar(15)
	 * @Param String faxNo
	 */
	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}
	/**
	 * Get ZIP 우편번호 varchar(6)
	 * @Return String zip
	 */
	public String getZip() {
		return this.zip;
	}
	
	/**
	 * Set ZIP 우편번호 varchar(6)
	 * @Param String zip
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}
	/**
	 * Get ADDR 주소 varchar(100)
	 * @Return String addr
	 */
	public String getAddr() {
		return this.addr;
	}
	
	/**
	 * Set ADDR 주소 varchar(100)
	 * @Param String addr
	 */
	public void setAddr(String addr) {
		this.addr = addr;
	}
	/**
	 * Get BIZ_INFO 사업자_정보 varchar(200)
	 * @Return String bizInfo
	 */
	public String getBizInfo() {
		return this.bizInfo;
	}
	
	/**
	 * Set BIZ_INFO 사업자_정보 varchar(200)
	 * @Param String bizInfo
	 */
	public void setBizInfo(String bizInfo) {
		this.bizInfo = bizInfo;
	}
	/**
	 * Get BIZ_REG_NO 사업자_등록_번호 varchar(13)
	 * @Return String bizRegNo
	 */
	public String getBizRegNo() {
		return this.bizRegNo;
	}
	
	/**
	 * Set BIZ_REG_NO 사업자_등록_번호 varchar(13)
	 * @Param String bizRegNo
	 */
	public void setBizRegNo(String bizRegNo) {
		this.bizRegNo = bizRegNo;
	}
	/**
	 * Get CORP_NO 법인_번호 varchar(14)
	 * @Return String corpNo
	 */
	public String getCorpNo() {
		return this.corpNo;
	}
	
	/**
	 * Set CORP_NO 법인_번호 varchar(14)
	 * @Param String corpNo
	 */
	public void setCorpNo(String corpNo) {
		this.corpNo = corpNo;
	}
	/**
	 * Get BRND 상호 varchar(10)
	 * @Return String brnd
	 */
	public String getBrnd() {
		return this.brnd;
	}
	
	/**
	 * Set BRND 상호 varchar(10)
	 * @Param String brnd
	 */
	public void setBrnd(String brnd) {
		this.brnd = brnd;
	}
	/**
	 * Get CEO_NM 대표자_명 varchar(10)
	 * @Return String ceoNm
	 */
	public String getCeoNm() {
		return this.ceoNm;
	}
	
	/**
	 * Set CEO_NM 대표자_명 varchar(10)
	 * @Param String ceoNm
	 */
	public void setCeoNm(String ceoNm) {
		this.ceoNm = ceoNm;
	}
	/**
	 * Get BDIV 업태 varchar(50)
	 * @Return String bdiv
	 */
	public String getBdiv() {
		return this.bdiv;
	}
	
	/**
	 * Set BDIV 업태 varchar(50)
	 * @Param String bdiv
	 */
	public void setBdiv(String bdiv) {
		this.bdiv = bdiv;
	}
	/**
	 * Get BTYP 종목 varchar(50)
	 * @Return String btyp
	 */
	public String getBtyp() {
		return this.btyp;
	}
	
	/**
	 * Set BTYP 종목 varchar(50)
	 * @Param String btyp
	 */
	public void setBtyp(String btyp) {
		this.btyp = btyp;
	}
	/**
	 * Get ANDR_VER 안드로이드_버전 varchar(50)
	 * @Return String andrVer
	 */
	public String getAndrVer() {
		return this.andrVer;
	}
	
	/**
	 * Set ANDR_VER 안드로이드_버전 varchar(50)
	 * @Param String andrVer
	 */
	public void setAndrVer(String andrVer) {
		this.andrVer = andrVer;
	}
	/**
	 * Get ANDR_DTTM 안드로이드_일시 varchar(14)
	 * @Return String andrDttm
	 */
	public String getAndrDttm() {
		return this.andrDttm;
	}
	
	/**
	 * Set ANDR_DTTM 안드로이드_일시 varchar(14)
	 * @Param String andrDttm
	 */
	public void setAndrDttm(String andrDttm) {
		this.andrDttm = andrDttm;
	}
	/**
	 * Get IOS_VER IOS_버전 varchar(50)
	 * @Return String iosVer
	 */
	public String getIosVer() {
		return this.iosVer;
	}
	
	/**
	 * Set IOS_VER IOS_버전 varchar(50)
	 * @Param String iosVer
	 */
	public void setIosVer(String iosVer) {
		this.iosVer = iosVer;
	}
	/**
	 * Get IOS_DTTM IOS_일시 varchar(14)
	 * @Return String iosDttm
	 */
	public String getIosDttm() {
		return this.iosDttm;
	}
	
	/**
	 * Set IOS_DTTM IOS_일시 varchar(14)
	 * @Param String iosDttm
	 */
	public void setIosDttm(String iosDttm) {
		this.iosDttm = iosDttm;
	}
	/**
	 * Get USE_TRMS_TXT 이용_약관_내용 mediumtext(16777215)
	 * @Return String useTrmsTxt
	 */
	public String getUseTrmsTxt() {
		return this.useTrmsTxt;
	}
	
	/**
	 * Set USE_TRMS_TXT 이용_약관_내용 mediumtext(16777215)
	 * @Param String useTrmsTxt
	 */
	public void setUseTrmsTxt(String useTrmsTxt) {
		this.useTrmsTxt = useTrmsTxt;
	}
	/**
	 * Get PRIV_TRMS_TXT 개인정보_약관_내용 mediumtext(16777215)
	 * @Return String privTrmsTxt
	 */
	public String getPrivTrmsTxt() {
		return this.privTrmsTxt;
	}
	
	/**
	 * Set PRIV_TRMS_TXT 개인정보_약관_내용 mediumtext(16777215)
	 * @Param String privTrmsTxt
	 */
	public void setPrivTrmsTxt(String privTrmsTxt) {
		this.privTrmsTxt = privTrmsTxt;
	}
	/**
	 * Get AD_TRMS_TXT 광고_약관_내용 mediumtext(16777215)
	 * @Return String adTrmsTxt
	 */
	public String getAdTrmsTxt() {
		return this.adTrmsTxt;
	}
	
	/**
	 * Set AD_TRMS_TXT 광고_약관_내용 mediumtext(16777215)
	 * @Param String adTrmsTxt
	 */
	public void setAdTrmsTxt(String adTrmsTxt) {
		this.adTrmsTxt = adTrmsTxt;
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
