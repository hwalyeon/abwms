package kr.hubble.api.model.dto;

import java.io.Serializable;

/**
 * ASCT_BASE Value Object
 */
public class AsctBaseVo implements Serializable {

	/* ASCT_ID AS센터_ID varchar(10) */
	private String asctId;

	/* ALLC_ID 제휴사_ID varchar(10) */
	private String allcId;

	/* ASCT_NM AS센터_명 varchar(50) */
	private String asctNm;

	/* LOGO_FILE_SEQ 로고_파일_순번 int(0,0) */
	private String logoFileSeq;

	/* INTR_TXT 소개_내용 mediumtext(16777215) */
	private String intrTxt;

	/* TRT_LIST_TAG 취급_목록_태그 varchar(500) */
	private String trtListTag;

	/* TEL 연락처 varchar(15) */
	private String tel;

	/* ZIP 우편번호 varchar(6) */
	private String zip;

	/* DTL_ADDR 상세_주소 varchar(100) */
	private String dtlAddr;

	/* LOCT_LAT 위치_위도 varchar(10) */
	private String loctLat;

	/* LOCT_LON 위치_경도 varchar(10) */
	private String loctLon;

	/* CITY_CD 시_코드 varchar(10) */
	private String cityCd;

	/* GU_CD 구_코드 varchar(10) */
	private String guCd;

	/* MON_YN 월_여부 char(1) */
	private String monYn;

	/* TUE_YN 화_여부 char(1) */
	private String tueYn;

	/* WED_YN 수_여부 char(1) */
	private String wedYn;

	/* THU_YN 목_여부 char(1) */
	private String thuYn;

	/* FRI_YN 금_여부 char(1) */
	private String friYn;

	/* SAT_YN 토_여부 char(1) */
	private String satYn;

	/* SUN_YN 일_여부 char(1) */
	private String sunYn;

	/* REG_USER_ID 등록_사용자_ID varchar(50) */
	private String regUserId;

	/* REG_DTTM 등록_일시 char(14) */
	private String regDttm;

	/* UPT_USER_ID 수정_사용자_ID varchar(50) */
	private String uptUserId;

	/* UPT_DTTM 수정_일시 char(14) */
	private String uptDttm;


	/**
	 * Get ASCT_ID AS센터_ID varchar(10)
	 * @Return String asctId
	 */
	public String getAsctId() {
		return this.asctId;
	}
	
	/**
	 * Set ASCT_ID AS센터_ID varchar(10)
	 * @Param String asctId
	 */
	public void setAsctId(String asctId) {
		this.asctId = asctId;
	}
	/**
	 * Get ALLC_ID 제휴사_ID varchar(10)
	 * @Return String allcId
	 */
	public String getAllcId() {
		return this.allcId;
	}
	
	/**
	 * Set ALLC_ID 제휴사_ID varchar(10)
	 * @Param String allcId
	 */
	public void setAllcId(String allcId) {
		this.allcId = allcId;
	}
	/**
	 * Get ASCT_NM AS센터_명 varchar(50)
	 * @Return String asctNm
	 */
	public String getAsctNm() {
		return this.asctNm;
	}
	
	/**
	 * Set ASCT_NM AS센터_명 varchar(50)
	 * @Param String asctNm
	 */
	public void setAsctNm(String asctNm) {
		this.asctNm = asctNm;
	}
	/**
	 * Get LOGO_FILE_SEQ 로고_파일_순번 int(0,0)
	 * @Return String logoFileSeq
	 */
	public String getLogoFileSeq() {
		return this.logoFileSeq;
	}
	
	/**
	 * Set LOGO_FILE_SEQ 로고_파일_순번 int(0,0)
	 * @Param String logoFileSeq
	 */
	public void setLogoFileSeq(String logoFileSeq) {
		this.logoFileSeq = logoFileSeq;
	}
	/**
	 * Get INTR_TXT 소개_내용 mediumtext(16777215)
	 * @Return String intrTxt
	 */
	public String getIntrTxt() {
		return this.intrTxt;
	}
	
	/**
	 * Set INTR_TXT 소개_내용 mediumtext(16777215)
	 * @Param String intrTxt
	 */
	public void setIntrTxt(String intrTxt) {
		this.intrTxt = intrTxt;
	}
	/**
	 * Get TRT_LIST_TAG 취급_목록_태그 varchar(500)
	 * @Return String trtListTag
	 */
	public String getTrtListTag() {
		return this.trtListTag;
	}
	
	/**
	 * Set TRT_LIST_TAG 취급_목록_태그 varchar(500)
	 * @Param String trtListTag
	 */
	public void setTrtListTag(String trtListTag) {
		this.trtListTag = trtListTag;
	}
	/**
	 * Get TEL 연락처 varchar(15)
	 * @Return String tel
	 */
	public String getTel() {
		return this.tel;
	}
	
	/**
	 * Set TEL 연락처 varchar(15)
	 * @Param String tel
	 */
	public void setTel(String tel) {
		this.tel = tel;
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
	 * Get DTL_ADDR 상세_주소 varchar(100)
	 * @Return String dtlAddr
	 */
	public String getDtlAddr() {
		return this.dtlAddr;
	}
	
	/**
	 * Set DTL_ADDR 상세_주소 varchar(100)
	 * @Param String dtlAddr
	 */
	public void setDtlAddr(String dtlAddr) {
		this.dtlAddr = dtlAddr;
	}
	/**
	 * Get LOCT_LAT 위치_위도 varchar(10)
	 * @Return String loctLat
	 */
	public String getLoctLat() {
		return this.loctLat;
	}
	
	/**
	 * Set LOCT_LAT 위치_위도 varchar(10)
	 * @Param String loctLat
	 */
	public void setLoctLat(String loctLat) {
		this.loctLat = loctLat;
	}
	/**
	 * Get LOCT_LON 위치_경도 varchar(10)
	 * @Return String loctLon
	 */
	public String getLoctLon() {
		return this.loctLon;
	}
	
	/**
	 * Set LOCT_LON 위치_경도 varchar(10)
	 * @Param String loctLon
	 */
	public void setLoctLon(String loctLon) {
		this.loctLon = loctLon;
	}
	/**
	 * Get CITY_CD 시_코드 varchar(10)
	 * @Return String cityCd
	 */
	public String getCityCd() {
		return this.cityCd;
	}
	
	/**
	 * Set CITY_CD 시_코드 varchar(10)
	 * @Param String cityCd
	 */
	public void setCityCd(String cityCd) {
		this.cityCd = cityCd;
	}
	/**
	 * Get GU_CD 구_코드 varchar(10)
	 * @Return String guCd
	 */
	public String getGuCd() {
		return this.guCd;
	}
	
	/**
	 * Set GU_CD 구_코드 varchar(10)
	 * @Param String guCd
	 */
	public void setGuCd(String guCd) {
		this.guCd = guCd;
	}
	/**
	 * Get MON_YN 월_여부 char(1)
	 * @Return String monYn
	 */
	public String getMonYn() {
		return this.monYn;
	}
	
	/**
	 * Set MON_YN 월_여부 char(1)
	 * @Param String monYn
	 */
	public void setMonYn(String monYn) {
		this.monYn = monYn;
	}
	/**
	 * Get TUE_YN 화_여부 char(1)
	 * @Return String tueYn
	 */
	public String getTueYn() {
		return this.tueYn;
	}
	
	/**
	 * Set TUE_YN 화_여부 char(1)
	 * @Param String tueYn
	 */
	public void setTueYn(String tueYn) {
		this.tueYn = tueYn;
	}
	/**
	 * Get WED_YN 수_여부 char(1)
	 * @Return String wedYn
	 */
	public String getWedYn() {
		return this.wedYn;
	}
	
	/**
	 * Set WED_YN 수_여부 char(1)
	 * @Param String wedYn
	 */
	public void setWedYn(String wedYn) {
		this.wedYn = wedYn;
	}
	/**
	 * Get THU_YN 목_여부 char(1)
	 * @Return String thuYn
	 */
	public String getThuYn() {
		return this.thuYn;
	}
	
	/**
	 * Set THU_YN 목_여부 char(1)
	 * @Param String thuYn
	 */
	public void setThuYn(String thuYn) {
		this.thuYn = thuYn;
	}
	/**
	 * Get FRI_YN 금_여부 char(1)
	 * @Return String friYn
	 */
	public String getFriYn() {
		return this.friYn;
	}
	
	/**
	 * Set FRI_YN 금_여부 char(1)
	 * @Param String friYn
	 */
	public void setFriYn(String friYn) {
		this.friYn = friYn;
	}
	/**
	 * Get SAT_YN 토_여부 char(1)
	 * @Return String satYn
	 */
	public String getSatYn() {
		return this.satYn;
	}
	
	/**
	 * Set SAT_YN 토_여부 char(1)
	 * @Param String satYn
	 */
	public void setSatYn(String satYn) {
		this.satYn = satYn;
	}
	/**
	 * Get SUN_YN 일_여부 char(1)
	 * @Return String sunYn
	 */
	public String getSunYn() {
		return this.sunYn;
	}
	
	/**
	 * Set SUN_YN 일_여부 char(1)
	 * @Param String sunYn
	 */
	public void setSunYn(String sunYn) {
		this.sunYn = sunYn;
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
