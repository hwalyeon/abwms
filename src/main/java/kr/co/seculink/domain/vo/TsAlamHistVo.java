package kr.co.seculink.domain.vo;

import java.io.Serializable;

/**
 * ts_alam_hist Value Object
 */
public class TsAlamHistVo implements Serializable {

	/* alam_no 알림_번호 numeric(null) */
	private double alamNo;

	/* guar_no 보호자_번호 numeric(null) */
	private double guarNo;

	/* stdt_no 학생_번호 numeric(null) */
	private double stdtNo;

	/* alam_chnl_cd 알림_채널_코드 character varying(20) */
	private String alamChnlCd;

	/* alam_type_cd 알림_유형_코드 character varying(20) */
	private String alamTypeCd;

	/* alam_titl 알림_제목 character varying(200) */
	private String alamTitl;

	/* alam_cntn 알림_내용 text(null) */
	private String alamCntn;

	/* ref_url 참조_URL character varying(500) */
	private String refUrl;

	/* ref_data 참조_데이터 character(18) */
	private String refData;

	/* send_dttm 발송_일시 character(14) */
	private String sendDttm;

	/* send_rslt_cd 발송_결과_코드 character varying(20) */
	private String sendRsltCd;

	/* reg_dt 등록_일자 character(8) */
	private String regDt;

	/* reg_tm 등록_시각 character(6) */
	private String regTm;

	/* reg_user_id 등록_사용자_ID character varying(20) */
	private String regUserId;

	/* upt_dt 수정_일자 character(8) */
	private String uptDt;

	/* upt_tm 수정_시각 character(6) */
	private String uptTm;

	/* upt_user_id 수정_사용자_ID character varying(20) */
	private String uptUserId;


	/**
	 * Get alam_no 알림_번호 numeric(null)
	 * @Return double alamNo
	 */
	public double getAlamNo() {
		return this.alamNo;
	}
	
	/**
	 * Set alam_no 알림_번호 numeric(null)
	 * @Param double alamNo
	 */
	public void setAlamNo(double alamNo) {
		this.alamNo = alamNo;
	}
	/**
	 * Get guar_no 보호자_번호 numeric(null)
	 * @Return double guarNo
	 */
	public double getGuarNo() {
		return this.guarNo;
	}
	
	/**
	 * Set guar_no 보호자_번호 numeric(null)
	 * @Param double guarNo
	 */
	public void setGuarNo(double guarNo) {
		this.guarNo = guarNo;
	}
	/**
	 * Get stdt_no 학생_번호 numeric(null)
	 * @Return double stdtNo
	 */
	public double getStdtNo() {
		return this.stdtNo;
	}
	
	/**
	 * Set stdt_no 학생_번호 numeric(null)
	 * @Param double stdtNo
	 */
	public void setStdtNo(double stdtNo) {
		this.stdtNo = stdtNo;
	}
	/**
	 * Get alam_chnl_cd 알림_채널_코드 character varying(20)
	 * @Return String alamChnlCd
	 */
	public String getAlamChnlCd() {
		return this.alamChnlCd;
	}
	
	/**
	 * Set alam_chnl_cd 알림_채널_코드 character varying(20)
	 * @Param String alamChnlCd
	 */
	public void setAlamChnlCd(String alamChnlCd) {
		this.alamChnlCd = alamChnlCd;
	}
	/**
	 * Get alam_type_cd 알림_유형_코드 character varying(20)
	 * @Return String alamTypeCd
	 */
	public String getAlamTypeCd() {
		return this.alamTypeCd;
	}
	
	/**
	 * Set alam_type_cd 알림_유형_코드 character varying(20)
	 * @Param String alamTypeCd
	 */
	public void setAlamTypeCd(String alamTypeCd) {
		this.alamTypeCd = alamTypeCd;
	}
	/**
	 * Get alam_titl 알림_제목 character varying(200)
	 * @Return String alamTitl
	 */
	public String getAlamTitl() {
		return this.alamTitl;
	}
	
	/**
	 * Set alam_titl 알림_제목 character varying(200)
	 * @Param String alamTitl
	 */
	public void setAlamTitl(String alamTitl) {
		this.alamTitl = alamTitl;
	}
	/**
	 * Get alam_cntn 알림_내용 text(null)
	 * @Return String alamCntn
	 */
	public String getAlamCntn() {
		return this.alamCntn;
	}
	
	/**
	 * Set alam_cntn 알림_내용 text(null)
	 * @Param String alamCntn
	 */
	public void setAlamCntn(String alamCntn) {
		this.alamCntn = alamCntn;
	}
	/**
	 * Get ref_url 참조_URL character varying(500)
	 * @Return String refUrl
	 */
	public String getRefUrl() {
		return this.refUrl;
	}
	
	/**
	 * Set ref_url 참조_URL character varying(500)
	 * @Param String refUrl
	 */
	public void setRefUrl(String refUrl) {
		this.refUrl = refUrl;
	}
	/**
	 * Get ref_data 참조_데이터 character(18)
	 * @Return String refData
	 */
	public String getRefData() {
		return this.refData;
	}
	
	/**
	 * Set ref_data 참조_데이터 character(18)
	 * @Param String refData
	 */
	public void setRefData(String refData) {
		this.refData = refData;
	}
	/**
	 * Get send_dttm 발송_일시 character(14)
	 * @Return String sendDttm
	 */
	public String getSendDttm() {
		return this.sendDttm;
	}
	
	/**
	 * Set send_dttm 발송_일시 character(14)
	 * @Param String sendDttm
	 */
	public void setSendDttm(String sendDttm) {
		this.sendDttm = sendDttm;
	}
	/**
	 * Get send_rslt_cd 발송_결과_코드 character varying(20)
	 * @Return String sendRsltCd
	 */
	public String getSendRsltCd() {
		return this.sendRsltCd;
	}
	
	/**
	 * Set send_rslt_cd 발송_결과_코드 character varying(20)
	 * @Param String sendRsltCd
	 */
	public void setSendRsltCd(String sendRsltCd) {
		this.sendRsltCd = sendRsltCd;
	}
	/**
	 * Get reg_dt 등록_일자 character(8)
	 * @Return String regDt
	 */
	public String getRegDt() {
		return this.regDt;
	}
	
	/**
	 * Set reg_dt 등록_일자 character(8)
	 * @Param String regDt
	 */
	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}
	/**
	 * Get reg_tm 등록_시각 character(6)
	 * @Return String regTm
	 */
	public String getRegTm() {
		return this.regTm;
	}
	
	/**
	 * Set reg_tm 등록_시각 character(6)
	 * @Param String regTm
	 */
	public void setRegTm(String regTm) {
		this.regTm = regTm;
	}
	/**
	 * Get reg_user_id 등록_사용자_ID character varying(20)
	 * @Return String regUserId
	 */
	public String getRegUserId() {
		return this.regUserId;
	}
	
	/**
	 * Set reg_user_id 등록_사용자_ID character varying(20)
	 * @Param String regUserId
	 */
	public void setRegUserId(String regUserId) {
		this.regUserId = regUserId;
	}
	/**
	 * Get upt_dt 수정_일자 character(8)
	 * @Return String uptDt
	 */
	public String getUptDt() {
		return this.uptDt;
	}
	
	/**
	 * Set upt_dt 수정_일자 character(8)
	 * @Param String uptDt
	 */
	public void setUptDt(String uptDt) {
		this.uptDt = uptDt;
	}
	/**
	 * Get upt_tm 수정_시각 character(6)
	 * @Return String uptTm
	 */
	public String getUptTm() {
		return this.uptTm;
	}
	
	/**
	 * Set upt_tm 수정_시각 character(6)
	 * @Param String uptTm
	 */
	public void setUptTm(String uptTm) {
		this.uptTm = uptTm;
	}
	/**
	 * Get upt_user_id 수정_사용자_ID character varying(20)
	 * @Return String uptUserId
	 */
	public String getUptUserId() {
		return this.uptUserId;
	}
	
	/**
	 * Set upt_user_id 수정_사용자_ID character varying(20)
	 * @Param String uptUserId
	 */
	public void setUptUserId(String uptUserId) {
		this.uptUserId = uptUserId;
	}

} // end of class
