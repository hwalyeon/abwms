package kr.hubble.api.model.dto;

import java.io.Serializable;

/**
 * AS_BASE Value Object
 */
public class AsBaseVo implements Serializable {

	/* AS_SEQ AS_순번 int(0,0) */
	private String asSeq;

	/* USER_ID 사용자_ID varchar(50) */
	private String userId;

	/* PRDT_ID 제품_ID varchar(10) */
	private String prdtId;

	/* MY_PRDT_SEQ MY제품_순번 int(0,0) */
	private String myPrdtSeq;

	/* ALLC_ID 제휴사_ID varchar(10) */
	private String allcId;

	/* MODL_NM 모델_명 varchar(50) */
	private String modlNm;

	/* BUY_YM 구매_년월 char(6) */
	private String buyYm;

	/* RCPT_DTTM 접수_일시 char(14) */
	private String rcptDttm;

	/* SYMP_CD 증상_코드 varchar(10) */
	private String sympCd;

	/* SYMP_TXT 증상_내용 varchar(50) */
	private String sympTxt;

	/* CRSH_TXT 고장_내용 mediumtext(16777215) */
	private String crshTxt;

	/* RCPT_STAT_CD 접수_상태_코드 varchar(10) */
	private String rcptStatCd;

	/* RCPT_NM 접수_명 varchar(10) */
	private String rcptNm;

	/* RCPT_TEL 접수_연락처 varchar(15) */
	private String rcptTel;

	/* RCPT_ZIP 접수_우편번호 varchar(6) */
	private String rcptZip;

	/* RCPT_ADDR 접수_주소 varchar(100) */
	private String rcptAddr;

	/* RCPT_ADDR_DTL 접수_주소_상세 varchar(100) */
	private String rcptAddrDtl;

	/* RCPT_MTHD_CD 접수_방법_코드 varchar(10) */
	private String rcptMthdCd;

	/* RCPT_PATH_CD 접수_경로_코드 varchar(10) */
	private String rcptPathCd;

	/* HOPE_DT 희망_일자 char(8) */
	private String hopeDt;

	/* HOPE_TM 희망_시간 char(6) */
	private String hopeTm;

	/* RESV_DTTM 예약_일시 char(14) */
	private String resvDttm;

	/* REG_USER_ID 등록_사용자_ID varchar(50) */
	private String regUserId;

	/* REG_DTTM 등록_일시 char(14) */
	private String regDttm;

	/* UPT_USER_ID 수정_사용자_ID varchar(50) */
	private String uptUserId;

	/* UPT_DTTM 수정_일시 char(14) */
	private String uptDttm;


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
	 * Get PRDT_ID 제품_ID varchar(10)
	 * @Return String prdtId
	 */
	public String getPrdtId() {
		return this.prdtId;
	}
	
	/**
	 * Set PRDT_ID 제품_ID varchar(10)
	 * @Param String prdtId
	 */
	public void setPrdtId(String prdtId) {
		this.prdtId = prdtId;
	}
	/**
	 * Get MY_PRDT_SEQ MY제품_순번 int(0,0)
	 * @Return String myPrdtSeq
	 */
	public String getMyPrdtSeq() {
		return this.myPrdtSeq;
	}
	
	/**
	 * Set MY_PRDT_SEQ MY제품_순번 int(0,0)
	 * @Param String myPrdtSeq
	 */
	public void setMyPrdtSeq(String myPrdtSeq) {
		this.myPrdtSeq = myPrdtSeq;
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
	 * Get MODL_NM 모델_명 varchar(50)
	 * @Return String modlNm
	 */
	public String getModlNm() {
		return this.modlNm;
	}
	
	/**
	 * Set MODL_NM 모델_명 varchar(50)
	 * @Param String modlNm
	 */
	public void setModlNm(String modlNm) {
		this.modlNm = modlNm;
	}
	/**
	 * Get BUY_YM 구매_년월 char(6)
	 * @Return String buyYm
	 */
	public String getBuyYm() {
		return this.buyYm;
	}
	
	/**
	 * Set BUY_YM 구매_년월 char(6)
	 * @Param String buyYm
	 */
	public void setBuyYm(String buyYm) {
		this.buyYm = buyYm;
	}
	/**
	 * Get RCPT_DTTM 접수_일시 char(14)
	 * @Return String rcptDttm
	 */
	public String getRcptDttm() {
		return this.rcptDttm;
	}
	
	/**
	 * Set RCPT_DTTM 접수_일시 char(14)
	 * @Param String rcptDttm
	 */
	public void setRcptDttm(String rcptDttm) {
		this.rcptDttm = rcptDttm;
	}
	/**
	 * Get SYMP_CD 증상_코드 varchar(10)
	 * @Return String sympCd
	 */
	public String getSympCd() {
		return this.sympCd;
	}
	
	/**
	 * Set SYMP_CD 증상_코드 varchar(10)
	 * @Param String sympCd
	 */
	public void setSympCd(String sympCd) {
		this.sympCd = sympCd;
	}
	/**
	 * Get SYMP_TXT 증상_내용 varchar(50)
	 * @Return String sympTxt
	 */
	public String getSympTxt() {
		return this.sympTxt;
	}
	
	/**
	 * Set SYMP_TXT 증상_내용 varchar(50)
	 * @Param String sympTxt
	 */
	public void setSympTxt(String sympTxt) {
		this.sympTxt = sympTxt;
	}
	/**
	 * Get CRSH_TXT 고장_내용 mediumtext(16777215)
	 * @Return String crshTxt
	 */
	public String getCrshTxt() {
		return this.crshTxt;
	}
	
	/**
	 * Set CRSH_TXT 고장_내용 mediumtext(16777215)
	 * @Param String crshTxt
	 */
	public void setCrshTxt(String crshTxt) {
		this.crshTxt = crshTxt;
	}
	/**
	 * Get RCPT_STAT_CD 접수_상태_코드 varchar(10)
	 * @Return String rcptStatCd
	 */
	public String getRcptStatCd() {
		return this.rcptStatCd;
	}
	
	/**
	 * Set RCPT_STAT_CD 접수_상태_코드 varchar(10)
	 * @Param String rcptStatCd
	 */
	public void setRcptStatCd(String rcptStatCd) {
		this.rcptStatCd = rcptStatCd;
	}
	/**
	 * Get RCPT_NM 접수_명 varchar(10)
	 * @Return String rcptNm
	 */
	public String getRcptNm() {
		return this.rcptNm;
	}
	
	/**
	 * Set RCPT_NM 접수_명 varchar(10)
	 * @Param String rcptNm
	 */
	public void setRcptNm(String rcptNm) {
		this.rcptNm = rcptNm;
	}
	/**
	 * Get RCPT_TEL 접수_연락처 varchar(15)
	 * @Return String rcptTel
	 */
	public String getRcptTel() {
		return this.rcptTel;
	}
	
	/**
	 * Set RCPT_TEL 접수_연락처 varchar(15)
	 * @Param String rcptTel
	 */
	public void setRcptTel(String rcptTel) {
		this.rcptTel = rcptTel;
	}
	/**
	 * Get RCPT_ZIP 접수_우편번호 varchar(6)
	 * @Return String rcptZip
	 */
	public String getRcptZip() {
		return this.rcptZip;
	}
	
	/**
	 * Set RCPT_ZIP 접수_우편번호 varchar(6)
	 * @Param String rcptZip
	 */
	public void setRcptZip(String rcptZip) {
		this.rcptZip = rcptZip;
	}
	/**
	 * Get RCPT_ADDR 접수_주소 varchar(100)
	 * @Return String rcptAddr
	 */
	public String getRcptAddr() {
		return this.rcptAddr;
	}
	
	/**
	 * Set RCPT_ADDR 접수_주소 varchar(100)
	 * @Param String rcptAddr
	 */
	public void setRcptAddr(String rcptAddr) {
		this.rcptAddr = rcptAddr;
	}
	/**
	 * Get RCPT_ADDR_DTL 접수_주소_상세 varchar(100)
	 * @Return String rcptAddrDtl
	 */
	public String getRcptAddrDtl() {
		return this.rcptAddrDtl;
	}
	
	/**
	 * Set RCPT_ADDR_DTL 접수_주소_상세 varchar(100)
	 * @Param String rcptAddrDtl
	 */
	public void setRcptAddrDtl(String rcptAddrDtl) {
		this.rcptAddrDtl = rcptAddrDtl;
	}
	/**
	 * Get RCPT_MTHD_CD 접수_방법_코드 varchar(10)
	 * @Return String rcptMthdCd
	 */
	public String getRcptMthdCd() {
		return this.rcptMthdCd;
	}
	
	/**
	 * Set RCPT_MTHD_CD 접수_방법_코드 varchar(10)
	 * @Param String rcptMthdCd
	 */
	public void setRcptMthdCd(String rcptMthdCd) {
		this.rcptMthdCd = rcptMthdCd;
	}
	/**
	 * Get RCPT_PATH_CD 접수_경로_코드 varchar(10)
	 * @Return String rcptPathCd
	 */
	public String getRcptPathCd() {
		return this.rcptPathCd;
	}
	
	/**
	 * Set RCPT_PATH_CD 접수_경로_코드 varchar(10)
	 * @Param String rcptPathCd
	 */
	public void setRcptPathCd(String rcptPathCd) {
		this.rcptPathCd = rcptPathCd;
	}
	/**
	 * Get HOPE_DT 희망_일자 char(8)
	 * @Return String hopeDt
	 */
	public String getHopeDt() {
		return this.hopeDt;
	}
	
	/**
	 * Set HOPE_DT 희망_일자 char(8)
	 * @Param String hopeDt
	 */
	public void setHopeDt(String hopeDt) {
		this.hopeDt = hopeDt;
	}
	/**
	 * Get HOPE_TM 희망_시간 char(6)
	 * @Return String hopeTm
	 */
	public String getHopeTm() {
		return this.hopeTm;
	}
	
	/**
	 * Set HOPE_TM 희망_시간 char(6)
	 * @Param String hopeTm
	 */
	public void setHopeTm(String hopeTm) {
		this.hopeTm = hopeTm;
	}
	/**
	 * Get RESV_DTTM 예약_일시 char(14)
	 * @Return String resvDttm
	 */
	public String getResvDttm() {
		return this.resvDttm;
	}
	
	/**
	 * Set RESV_DTTM 예약_일시 char(14)
	 * @Param String resvDttm
	 */
	public void setResvDttm(String resvDttm) {
		this.resvDttm = resvDttm;
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
