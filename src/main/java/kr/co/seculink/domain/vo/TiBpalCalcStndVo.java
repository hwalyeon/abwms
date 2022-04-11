package kr.co.seculink.domain.vo;

import java.io.Serializable;

/**
 * ti_bpal_calc_stnd Value Object
 */
public class TiBpalCalcStndVo implements Serializable {

	/* sex_cd 성별_코드 character varying(20) */
	private String sexCd;

	/* age_ycnt_fr 나이_년수_FROM numeric(null) */
	private Double ageYcntFr;

	/* age_ycnt_to 나이_년수_TO numeric(null) */
	private Double ageYcntTo;

	/* calc_frml 계산_식 character varying(2000) */
	private String calcFrml;

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
	 * Get age_ycnt_fr 나이_년수_FROM numeric(null)
	 * @Return Double ageYcntFr
	 */
	public Double getAgeYcntFr() {
		return this.ageYcntFr;
	}
	
	/**
	 * Set age_ycnt_fr 나이_년수_FROM numeric(null)
	 * @Param Double ageYcntFr
	 */
	public void setAgeYcntFr(Double ageYcntFr) {
		this.ageYcntFr = ageYcntFr;
	}
	/**
	 * Get age_ycnt_to 나이_년수_TO numeric(null)
	 * @Return Double ageYcntTo
	 */
	public Double getAgeYcntTo() {
		return this.ageYcntTo;
	}
	
	/**
	 * Set age_ycnt_to 나이_년수_TO numeric(null)
	 * @Param Double ageYcntTo
	 */
	public void setAgeYcntTo(Double ageYcntTo) {
		this.ageYcntTo = ageYcntTo;
	}
	/**
	 * Get calc_frml 계산_식 character varying(2000)
	 * @Return String calcFrml
	 */
	public String getCalcFrml() {
		return this.calcFrml;
	}
	
	/**
	 * Set calc_frml 계산_식 character varying(2000)
	 * @Param String calcFrml
	 */
	public void setCalcFrml(String calcFrml) {
		this.calcFrml = calcFrml;
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
