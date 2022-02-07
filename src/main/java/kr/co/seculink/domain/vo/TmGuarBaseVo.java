package kr.co.seculink.domain.vo;

import java.io.Serializable;

/**
 * tm_guar_base Value Object
 */
public class TmGuarBaseVo implements Serializable {

	/* guar_no 보호자_번호 numeric(null) */
	private double guarNo;

	/* guar_nm 보호자_명 character varying(20) */
	private String guarNm;

	/* guar_tel_no 보호자_전화_번호 character varying(20) */
	private String guarTelNo;

	/* guar_pw 보호자_비밀번호 character varying(1000) */
	private String guarPw;

	/* self_cert_dttm 본인_인증_일시 character(14) */
	private String selfCertDttm;

	/* race_div_cd 인종_구분_코드 character varying(20) */
	private String raceDivCd;

	/* sex_cd 성별_코드 character varying(20) */
	private String sexCd;

	/* hght_val 키_값 numeric(null) */
	private double hghtVal;

	/* wght_val 체중_값 numeric(null) */
	private double wghtVal;

	/* bmi_val BMI_값 numeric(null) */
	private double bmiVal;

	/* spos_no 배우자_번호 numeric(null) */
	private double sposNo;

	/* dzone_moin_alam_yn 위험지역_진입_알림_여부 character(1) */
	private String dzoneMoinAlamYn;

	/* dzone_mout_alam_yn 위험지역_이탈_알림_여부 character(1) */
	private String dzoneMoutAlamYn;

	/* szone_moin_alam_yn 세이프존_진입_알림_여부 character(1) */
	private String szoneMoinAlamYn;

	/* szone_mout_alam_yn 세이프존_이탈_알림_여부 character(1) */
	private String szoneMoutAlamYn;

	/* fall_occr_alam_yn 낙상_발생_알림_여부 character(1) */
	private String fallOccrAlamYn;

	/* strs_abnm_alam_yn 스트레스_이상_알림_여부 character(1) */
	private String strsAbnmAlamYn;

	/* entr_dt 가입_일자 character(8) */
	private String entrDt;

	/* rels_dt 해지_일자 character(8) */
	private String relsDt;

	/* rels_resn_cd 해지_사유_코드 character varying(20) */
	private String relsResnCd;

	/* rels_resn_cntn 해지_사유_내용 character varying(400) */
	private String relsResnCntn;

	/* entr_stat_cd 가입_상태_코드 character varying(20) */
	private String entrStatCd;

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
	 * Get guar_nm 보호자_명 character varying(20)
	 * @Return String guarNm
	 */
	public String getGuarNm() {
		return this.guarNm;
	}
	
	/**
	 * Set guar_nm 보호자_명 character varying(20)
	 * @Param String guarNm
	 */
	public void setGuarNm(String guarNm) {
		this.guarNm = guarNm;
	}
	/**
	 * Get guar_tel_no 보호자_전화_번호 character varying(20)
	 * @Return String guarTelNo
	 */
	public String getGuarTelNo() {
		return this.guarTelNo;
	}
	
	/**
	 * Set guar_tel_no 보호자_전화_번호 character varying(20)
	 * @Param String guarTelNo
	 */
	public void setGuarTelNo(String guarTelNo) {
		this.guarTelNo = guarTelNo;
	}
	/**
	 * Get guar_pw 보호자_비밀번호 character varying(1000)
	 * @Return String guarPw
	 */
	public String getGuarPw() {
		return this.guarPw;
	}
	
	/**
	 * Set guar_pw 보호자_비밀번호 character varying(1000)
	 * @Param String guarPw
	 */
	public void setGuarPw(String guarPw) {
		this.guarPw = guarPw;
	}
	/**
	 * Get self_cert_dttm 본인_인증_일시 character(14)
	 * @Return String selfCertDttm
	 */
	public String getSelfCertDttm() {
		return this.selfCertDttm;
	}
	
	/**
	 * Set self_cert_dttm 본인_인증_일시 character(14)
	 * @Param String selfCertDttm
	 */
	public void setSelfCertDttm(String selfCertDttm) {
		this.selfCertDttm = selfCertDttm;
	}
	/**
	 * Get race_div_cd 인종_구분_코드 character varying(20)
	 * @Return String raceDivCd
	 */
	public String getRaceDivCd() {
		return this.raceDivCd;
	}
	
	/**
	 * Set race_div_cd 인종_구분_코드 character varying(20)
	 * @Param String raceDivCd
	 */
	public void setRaceDivCd(String raceDivCd) {
		this.raceDivCd = raceDivCd;
	}
	/**
	 * Get sex_cd 성별_코드 character varying(20)
	 * @Return String sexCd
	 */
	public String getSexCd() {
		return this.sexCd;
	}
	
	/**
	 * Set sex_cd 성별_코드 character varying(20)
	 * @Param String sexCd
	 */
	public void setSexCd(String sexCd) {
		this.sexCd = sexCd;
	}
	/**
	 * Get hght_val 키_값 numeric(null)
	 * @Return double hghtVal
	 */
	public double getHghtVal() {
		return this.hghtVal;
	}
	
	/**
	 * Set hght_val 키_값 numeric(null)
	 * @Param double hghtVal
	 */
	public void setHghtVal(double hghtVal) {
		this.hghtVal = hghtVal;
	}
	/**
	 * Get wght_val 체중_값 numeric(null)
	 * @Return double wghtVal
	 */
	public double getWghtVal() {
		return this.wghtVal;
	}
	
	/**
	 * Set wght_val 체중_값 numeric(null)
	 * @Param double wghtVal
	 */
	public void setWghtVal(double wghtVal) {
		this.wghtVal = wghtVal;
	}
	/**
	 * Get bmi_val BMI_값 numeric(null)
	 * @Return double bmiVal
	 */
	public double getBmiVal() {
		return this.bmiVal;
	}
	
	/**
	 * Set bmi_val BMI_값 numeric(null)
	 * @Param double bmiVal
	 */
	public void setBmiVal(double bmiVal) {
		this.bmiVal = bmiVal;
	}
	/**
	 * Get spos_no 배우자_번호 numeric(null)
	 * @Return double sposNo
	 */
	public double getSposNo() {
		return this.sposNo;
	}
	
	/**
	 * Set spos_no 배우자_번호 numeric(null)
	 * @Param double sposNo
	 */
	public void setSposNo(double sposNo) {
		this.sposNo = sposNo;
	}
	/**
	 * Get dzone_moin_alam_yn 위험지역_진입_알림_여부 character(1)
	 * @Return String dzoneMoinAlamYn
	 */
	public String getDzoneMoinAlamYn() {
		return this.dzoneMoinAlamYn;
	}
	
	/**
	 * Set dzone_moin_alam_yn 위험지역_진입_알림_여부 character(1)
	 * @Param String dzoneMoinAlamYn
	 */
	public void setDzoneMoinAlamYn(String dzoneMoinAlamYn) {
		this.dzoneMoinAlamYn = dzoneMoinAlamYn;
	}
	/**
	 * Get dzone_mout_alam_yn 위험지역_이탈_알림_여부 character(1)
	 * @Return String dzoneMoutAlamYn
	 */
	public String getDzoneMoutAlamYn() {
		return this.dzoneMoutAlamYn;
	}
	
	/**
	 * Set dzone_mout_alam_yn 위험지역_이탈_알림_여부 character(1)
	 * @Param String dzoneMoutAlamYn
	 */
	public void setDzoneMoutAlamYn(String dzoneMoutAlamYn) {
		this.dzoneMoutAlamYn = dzoneMoutAlamYn;
	}
	/**
	 * Get szone_moin_alam_yn 세이프존_진입_알림_여부 character(1)
	 * @Return String szoneMoinAlamYn
	 */
	public String getSzoneMoinAlamYn() {
		return this.szoneMoinAlamYn;
	}
	
	/**
	 * Set szone_moin_alam_yn 세이프존_진입_알림_여부 character(1)
	 * @Param String szoneMoinAlamYn
	 */
	public void setSzoneMoinAlamYn(String szoneMoinAlamYn) {
		this.szoneMoinAlamYn = szoneMoinAlamYn;
	}
	/**
	 * Get szone_mout_alam_yn 세이프존_이탈_알림_여부 character(1)
	 * @Return String szoneMoutAlamYn
	 */
	public String getSzoneMoutAlamYn() {
		return this.szoneMoutAlamYn;
	}
	
	/**
	 * Set szone_mout_alam_yn 세이프존_이탈_알림_여부 character(1)
	 * @Param String szoneMoutAlamYn
	 */
	public void setSzoneMoutAlamYn(String szoneMoutAlamYn) {
		this.szoneMoutAlamYn = szoneMoutAlamYn;
	}
	/**
	 * Get fall_occr_alam_yn 낙상_발생_알림_여부 character(1)
	 * @Return String fallOccrAlamYn
	 */
	public String getFallOccrAlamYn() {
		return this.fallOccrAlamYn;
	}
	
	/**
	 * Set fall_occr_alam_yn 낙상_발생_알림_여부 character(1)
	 * @Param String fallOccrAlamYn
	 */
	public void setFallOccrAlamYn(String fallOccrAlamYn) {
		this.fallOccrAlamYn = fallOccrAlamYn;
	}
	/**
	 * Get strs_abnm_alam_yn 스트레스_이상_알림_여부 character(1)
	 * @Return String strsAbnmAlamYn
	 */
	public String getStrsAbnmAlamYn() {
		return this.strsAbnmAlamYn;
	}
	
	/**
	 * Set strs_abnm_alam_yn 스트레스_이상_알림_여부 character(1)
	 * @Param String strsAbnmAlamYn
	 */
	public void setStrsAbnmAlamYn(String strsAbnmAlamYn) {
		this.strsAbnmAlamYn = strsAbnmAlamYn;
	}
	/**
	 * Get entr_dt 가입_일자 character(8)
	 * @Return String entrDt
	 */
	public String getEntrDt() {
		return this.entrDt;
	}
	
	/**
	 * Set entr_dt 가입_일자 character(8)
	 * @Param String entrDt
	 */
	public void setEntrDt(String entrDt) {
		this.entrDt = entrDt;
	}
	/**
	 * Get rels_dt 해지_일자 character(8)
	 * @Return String relsDt
	 */
	public String getRelsDt() {
		return this.relsDt;
	}
	
	/**
	 * Set rels_dt 해지_일자 character(8)
	 * @Param String relsDt
	 */
	public void setRelsDt(String relsDt) {
		this.relsDt = relsDt;
	}
	/**
	 * Get rels_resn_cd 해지_사유_코드 character varying(20)
	 * @Return String relsResnCd
	 */
	public String getRelsResnCd() {
		return this.relsResnCd;
	}
	
	/**
	 * Set rels_resn_cd 해지_사유_코드 character varying(20)
	 * @Param String relsResnCd
	 */
	public void setRelsResnCd(String relsResnCd) {
		this.relsResnCd = relsResnCd;
	}
	/**
	 * Get rels_resn_cntn 해지_사유_내용 character varying(400)
	 * @Return String relsResnCntn
	 */
	public String getRelsResnCntn() {
		return this.relsResnCntn;
	}
	
	/**
	 * Set rels_resn_cntn 해지_사유_내용 character varying(400)
	 * @Param String relsResnCntn
	 */
	public void setRelsResnCntn(String relsResnCntn) {
		this.relsResnCntn = relsResnCntn;
	}
	/**
	 * Get entr_stat_cd 가입_상태_코드 character varying(20)
	 * @Return String entrStatCd
	 */
	public String getEntrStatCd() {
		return this.entrStatCd;
	}
	
	/**
	 * Set entr_stat_cd 가입_상태_코드 character varying(20)
	 * @Param String entrStatCd
	 */
	public void setEntrStatCd(String entrStatCd) {
		this.entrStatCd = entrStatCd;
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
