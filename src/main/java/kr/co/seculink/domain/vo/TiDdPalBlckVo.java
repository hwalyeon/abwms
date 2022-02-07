package kr.co.seculink.domain.vo;

import java.io.Serializable;

/**
 * ti_dd_pal_blck Value Object
 */
public class TiDdPalBlckVo implements Serializable {

	/* curr_fat_judg_cd 현재_비만_판정_코드 character varying(20) */
	private String currFatJudgCd;

	/* prdt_fat_judg_cd 예측_비만_판정_코드 character varying(20) */
	private String prdtFatJudgCd;

	/* sex_cd 성별_코드 character varying(20) */
	private String sexCd;

	/* age_ycnt_fr 나이_년수_FROM numeric(null) */
	private double ageYcntFr;

	/* age_ycnt_to 나이_년수_TO numeric(null) */
	private double ageYcntTo;

	/* pal_val_fr 신체활동수준_값_FROM numeric(null) */
	private double palValFr;

	/* pal_val_to 신체활동수준_값_TO numeric(null) */
	private double palValTo;

	/* dd_cal_qty 일일_칼로리_량 numeric(null) */
	private double ddCalQty;

	/* pal_cd 신체활동수준_코드 character(18) */
	private String palCd;

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
	 * Get curr_fat_judg_cd 현재_비만_판정_코드 character varying(20)
	 * @Return String currFatJudgCd
	 */
	public String getCurrFatJudgCd() {
		return this.currFatJudgCd;
	}
	
	/**
	 * Set curr_fat_judg_cd 현재_비만_판정_코드 character varying(20)
	 * @Param String currFatJudgCd
	 */
	public void setCurrFatJudgCd(String currFatJudgCd) {
		this.currFatJudgCd = currFatJudgCd;
	}
	/**
	 * Get prdt_fat_judg_cd 예측_비만_판정_코드 character varying(20)
	 * @Return String prdtFatJudgCd
	 */
	public String getPrdtFatJudgCd() {
		return this.prdtFatJudgCd;
	}
	
	/**
	 * Set prdt_fat_judg_cd 예측_비만_판정_코드 character varying(20)
	 * @Param String prdtFatJudgCd
	 */
	public void setPrdtFatJudgCd(String prdtFatJudgCd) {
		this.prdtFatJudgCd = prdtFatJudgCd;
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
	 * Get age_ycnt_fr 나이_년수_FROM numeric(null)
	 * @Return double ageYcntFr
	 */
	public double getAgeYcntFr() {
		return this.ageYcntFr;
	}
	
	/**
	 * Set age_ycnt_fr 나이_년수_FROM numeric(null)
	 * @Param double ageYcntFr
	 */
	public void setAgeYcntFr(double ageYcntFr) {
		this.ageYcntFr = ageYcntFr;
	}
	/**
	 * Get age_ycnt_to 나이_년수_TO numeric(null)
	 * @Return double ageYcntTo
	 */
	public double getAgeYcntTo() {
		return this.ageYcntTo;
	}
	
	/**
	 * Set age_ycnt_to 나이_년수_TO numeric(null)
	 * @Param double ageYcntTo
	 */
	public void setAgeYcntTo(double ageYcntTo) {
		this.ageYcntTo = ageYcntTo;
	}
	/**
	 * Get pal_val_fr 신체활동수준_값_FROM numeric(null)
	 * @Return double palValFr
	 */
	public double getPalValFr() {
		return this.palValFr;
	}
	
	/**
	 * Set pal_val_fr 신체활동수준_값_FROM numeric(null)
	 * @Param double palValFr
	 */
	public void setPalValFr(double palValFr) {
		this.palValFr = palValFr;
	}
	/**
	 * Get pal_val_to 신체활동수준_값_TO numeric(null)
	 * @Return double palValTo
	 */
	public double getPalValTo() {
		return this.palValTo;
	}
	
	/**
	 * Set pal_val_to 신체활동수준_값_TO numeric(null)
	 * @Param double palValTo
	 */
	public void setPalValTo(double palValTo) {
		this.palValTo = palValTo;
	}
	/**
	 * Get dd_cal_qty 일일_칼로리_량 numeric(null)
	 * @Return double ddCalQty
	 */
	public double getDdCalQty() {
		return this.ddCalQty;
	}
	
	/**
	 * Set dd_cal_qty 일일_칼로리_량 numeric(null)
	 * @Param double ddCalQty
	 */
	public void setDdCalQty(double ddCalQty) {
		this.ddCalQty = ddCalQty;
	}
	/**
	 * Get pal_cd 신체활동수준_코드 character(18)
	 * @Return String palCd
	 */
	public String getPalCd() {
		return this.palCd;
	}
	
	/**
	 * Set pal_cd 신체활동수준_코드 character(18)
	 * @Param String palCd
	 */
	public void setPalCd(String palCd) {
		this.palCd = palCd;
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
