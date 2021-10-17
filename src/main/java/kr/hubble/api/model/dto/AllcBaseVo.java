package kr.hubble.api.model.dto;

import java.io.Serializable;

/**
 * ALLC_BASE Value Object
 */
public class AllcBaseVo implements Serializable {

	/* ALLC_ID 제휴사_ID varchar(10) */
	private String allcId;

	/* ALLC_NM 제휴사_명 varchar(50) */
	private String allcNm;

	/* ALLC_NM_RT 제휴사_명_초성 varchar(50) */
	private String allcNmRt;

	/* BIZ_NM 사업자_명 varchar(50) */
	private String bizNm;

	/* CEO_NM 대표자_명 varchar(50) */
	private String ceoNm;

	/* BIZ_REG_NO 사업자_등록_번호 varchar(13) */
	private String bizRegNo;

	/* LOGO_FILE_SEQ 로고_파일_순번 int(0,0) */
	private String logoFileSeq;

	/* AS_YN AS_여부 char(1) */
	private String asYn;

	/* AR_YN AR_여부 char(1) */
	private String arYn;

	/* TAG 태그 varchar(100) */
	private String tag;

	/* SRCH_CNT 조회_횟수 int(0,0) */
	private String srchCnt;

	/* OP_TM 운영_시간 mediumtext(16777215) */
	private String opTm;

	/* TEL 연락처 varchar(15) */
	private String tel;

	/* SHOP_ZIP 매장_우편번호 varchar(6) */
	private String shopZip;

	/* SHOP_ADDR 매장_주소 varchar(100) */
	private String shopAddr;

	/* SHOP_ADDR_DTL 매장_주소_상세 varchar(100) */
	private String shopAddrDtl;

	/* SHOP_LAT 매장_위도 varchar(10) */
	private String shopLat;

	/* SHOP_LON 매장_경도 varchar(10) */
	private String shopLon;

	/* ONEL_INTR 한줄_소개 varchar(50) */
	private String onelIntr;

	/* SVC_FEE 서비스_요금 mediumtext(16777215) */
	private String svcFee;

	/* REPR_STND 수리_기준 mediumtext(16777215) */
	private String reprStnd;

	/* WRRT_PIRD 보증_기간 mediumtext(16777215) */
	private String wrrtPird;

	/* DEL_YN 삭제_여부 char(1) */
	private String delYn;

	/* ASCT_REPR_YN AS센터_수리_여부 varchar(1) */
	private String asctReprYn;

	/* RPMN_REPR_YN 수리기사_수리_여부 varchar(1) */
	private String rpmnReprYn;

	/* SEND_REPR_YN 발송_수리_여부 varchar(100) */
	private String sendReprYn;

	/* REG_DT 등록_일자 char(8) */
	private String regDt;

	/* REG_USER_ID 등록_사용자_ID varchar(50) */
	private String regUserId;

	/* REG_DTTM 등록_일시 char(14) */
	private String regDttm;

	/* UPT_USER_ID 수정_사용자_ID varchar(50) */
	private String uptUserId;

	/* UPT_DTTM 수정_일시 char(14) */
	private String uptDttm;


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
	 * Get ALLC_NM 제휴사_명 varchar(50)
	 * @Return String allcNm
	 */
	public String getAllcNm() {
		return this.allcNm;
	}
	
	/**
	 * Set ALLC_NM 제휴사_명 varchar(50)
	 * @Param String allcNm
	 */
	public void setAllcNm(String allcNm) {
		this.allcNm = allcNm;
	}
	/**
	 * Get ALLC_NM_RT 제휴사_명_초성 varchar(50)
	 * @Return String allcNmRt
	 */
	public String getAllcNmRt() {
		return this.allcNmRt;
	}
	
	/**
	 * Set ALLC_NM_RT 제휴사_명_초성 varchar(50)
	 * @Param String allcNmRt
	 */
	public void setAllcNmRt(String allcNmRt) {
		this.allcNmRt = allcNmRt;
	}
	/**
	 * Get BIZ_NM 사업자_명 varchar(50)
	 * @Return String bizNm
	 */
	public String getBizNm() {
		return this.bizNm;
	}
	
	/**
	 * Set BIZ_NM 사업자_명 varchar(50)
	 * @Param String bizNm
	 */
	public void setBizNm(String bizNm) {
		this.bizNm = bizNm;
	}
	/**
	 * Get CEO_NM 대표자_명 varchar(50)
	 * @Return String ceoNm
	 */
	public String getCeoNm() {
		return this.ceoNm;
	}
	
	/**
	 * Set CEO_NM 대표자_명 varchar(50)
	 * @Param String ceoNm
	 */
	public void setCeoNm(String ceoNm) {
		this.ceoNm = ceoNm;
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
	 * Get AS_YN AS_여부 char(1)
	 * @Return String asYn
	 */
	public String getAsYn() {
		return this.asYn;
	}
	
	/**
	 * Set AS_YN AS_여부 char(1)
	 * @Param String asYn
	 */
	public void setAsYn(String asYn) {
		this.asYn = asYn;
	}
	/**
	 * Get AR_YN AR_여부 char(1)
	 * @Return String arYn
	 */
	public String getArYn() {
		return this.arYn;
	}
	
	/**
	 * Set AR_YN AR_여부 char(1)
	 * @Param String arYn
	 */
	public void setArYn(String arYn) {
		this.arYn = arYn;
	}
	/**
	 * Get TAG 태그 varchar(100)
	 * @Return String tag
	 */
	public String getTag() {
		return this.tag;
	}
	
	/**
	 * Set TAG 태그 varchar(100)
	 * @Param String tag
	 */
	public void setTag(String tag) {
		this.tag = tag;
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
	 * Get OP_TM 운영_시간 mediumtext(16777215)
	 * @Return String opTm
	 */
	public String getOpTm() {
		return this.opTm;
	}
	
	/**
	 * Set OP_TM 운영_시간 mediumtext(16777215)
	 * @Param String opTm
	 */
	public void setOpTm(String opTm) {
		this.opTm = opTm;
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
	 * Get SHOP_ZIP 매장_우편번호 varchar(6)
	 * @Return String shopZip
	 */
	public String getShopZip() {
		return this.shopZip;
	}
	
	/**
	 * Set SHOP_ZIP 매장_우편번호 varchar(6)
	 * @Param String shopZip
	 */
	public void setShopZip(String shopZip) {
		this.shopZip = shopZip;
	}
	/**
	 * Get SHOP_ADDR 매장_주소 varchar(100)
	 * @Return String shopAddr
	 */
	public String getShopAddr() {
		return this.shopAddr;
	}
	
	/**
	 * Set SHOP_ADDR 매장_주소 varchar(100)
	 * @Param String shopAddr
	 */
	public void setShopAddr(String shopAddr) {
		this.shopAddr = shopAddr;
	}
	/**
	 * Get SHOP_ADDR_DTL 매장_주소_상세 varchar(100)
	 * @Return String shopAddrDtl
	 */
	public String getShopAddrDtl() {
		return this.shopAddrDtl;
	}
	
	/**
	 * Set SHOP_ADDR_DTL 매장_주소_상세 varchar(100)
	 * @Param String shopAddrDtl
	 */
	public void setShopAddrDtl(String shopAddrDtl) {
		this.shopAddrDtl = shopAddrDtl;
	}
	/**
	 * Get SHOP_LAT 매장_위도 varchar(10)
	 * @Return String shopLat
	 */
	public String getShopLat() {
		return this.shopLat;
	}
	
	/**
	 * Set SHOP_LAT 매장_위도 varchar(10)
	 * @Param String shopLat
	 */
	public void setShopLat(String shopLat) {
		this.shopLat = shopLat;
	}
	/**
	 * Get SHOP_LON 매장_경도 varchar(10)
	 * @Return String shopLon
	 */
	public String getShopLon() {
		return this.shopLon;
	}
	
	/**
	 * Set SHOP_LON 매장_경도 varchar(10)
	 * @Param String shopLon
	 */
	public void setShopLon(String shopLon) {
		this.shopLon = shopLon;
	}
	/**
	 * Get ONEL_INTR 한줄_소개 varchar(50)
	 * @Return String onelIntr
	 */
	public String getOnelIntr() {
		return this.onelIntr;
	}
	
	/**
	 * Set ONEL_INTR 한줄_소개 varchar(50)
	 * @Param String onelIntr
	 */
	public void setOnelIntr(String onelIntr) {
		this.onelIntr = onelIntr;
	}
	/**
	 * Get SVC_FEE 서비스_요금 mediumtext(16777215)
	 * @Return String svcFee
	 */
	public String getSvcFee() {
		return this.svcFee;
	}
	
	/**
	 * Set SVC_FEE 서비스_요금 mediumtext(16777215)
	 * @Param String svcFee
	 */
	public void setSvcFee(String svcFee) {
		this.svcFee = svcFee;
	}
	/**
	 * Get REPR_STND 수리_기준 mediumtext(16777215)
	 * @Return String reprStnd
	 */
	public String getReprStnd() {
		return this.reprStnd;
	}
	
	/**
	 * Set REPR_STND 수리_기준 mediumtext(16777215)
	 * @Param String reprStnd
	 */
	public void setReprStnd(String reprStnd) {
		this.reprStnd = reprStnd;
	}
	/**
	 * Get WRRT_PIRD 보증_기간 mediumtext(16777215)
	 * @Return String wrrtPird
	 */
	public String getWrrtPird() {
		return this.wrrtPird;
	}
	
	/**
	 * Set WRRT_PIRD 보증_기간 mediumtext(16777215)
	 * @Param String wrrtPird
	 */
	public void setWrrtPird(String wrrtPird) {
		this.wrrtPird = wrrtPird;
	}
	/**
	 * Get DEL_YN 삭제_여부 char(1)
	 * @Return String delYn
	 */
	public String getDelYn() {
		return this.delYn;
	}
	
	/**
	 * Set DEL_YN 삭제_여부 char(1)
	 * @Param String delYn
	 */
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	/**
	 * Get ASCT_REPR_YN AS센터_수리_여부 varchar(1)
	 * @Return String asctReprYn
	 */
	public String getAsctReprYn() {
		return this.asctReprYn;
	}
	
	/**
	 * Set ASCT_REPR_YN AS센터_수리_여부 varchar(1)
	 * @Param String asctReprYn
	 */
	public void setAsctReprYn(String asctReprYn) {
		this.asctReprYn = asctReprYn;
	}
	/**
	 * Get RPMN_REPR_YN 수리기사_수리_여부 varchar(1)
	 * @Return String rpmnReprYn
	 */
	public String getRpmnReprYn() {
		return this.rpmnReprYn;
	}
	
	/**
	 * Set RPMN_REPR_YN 수리기사_수리_여부 varchar(1)
	 * @Param String rpmnReprYn
	 */
	public void setRpmnReprYn(String rpmnReprYn) {
		this.rpmnReprYn = rpmnReprYn;
	}
	/**
	 * Get SEND_REPR_YN 발송_수리_여부 varchar(100)
	 * @Return String sendReprYn
	 */
	public String getSendReprYn() {
		return this.sendReprYn;
	}
	
	/**
	 * Set SEND_REPR_YN 발송_수리_여부 varchar(100)
	 * @Param String sendReprYn
	 */
	public void setSendReprYn(String sendReprYn) {
		this.sendReprYn = sendReprYn;
	}
	/**
	 * Get REG_DT 등록_일자 char(8)
	 * @Return String regDt
	 */
	public String getRegDt() {
		return this.regDt;
	}
	
	/**
	 * Set REG_DT 등록_일자 char(8)
	 * @Param String regDt
	 */
	public void setRegDt(String regDt) {
		this.regDt = regDt;
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
