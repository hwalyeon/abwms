package kr.co.seculink.domain.vo;

import java.io.Serializable;
import lombok.ToString;
/**
 * ti_dd_pal_blck Value Object
 */
 @ToString
public class TiDdPalBlckVo implements Serializable {

	/* fat_judg_cd 비만_판정_코드 character varying(20) */
	private String fatJudgCd;

	/* fatp_judg_cd 비만예측_판정_코드 character varying(20) */
	private String fatpJudgCd;

	/* sex_cd 성별_코드 character varying(20) */
	private String sexCd;

	/* age_ycnt 나이_년수 numeric(null) */
	private Double ageYcnt;

	/* pal_cd 신체활동수준_코드 character varying(20) */
	private String palCd;

	/* cal_qty_fr 칼로리_량_FROM numeric(null) */
	private Double calQtyFr;

	/* cal_qty_to 칼로리_량_TO numeric(null) */
	private Double calQtyTo;

	/* dd_cal_qty 일일_칼로리_량 numeric(null) */
	private Double ddCalQty;

	/* nutr_cd 영양소_코드 character varying(20) */
	private String nutrCd;

	/* nutr_stat_cd 영양섭취_상태_코드 character varying(20) */
	private String nutrStatCd;

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
	 * Get fat_judg_cd 비만_판정_코드 character varying(20)
	 * @Return String fatJudgCd
	 */
	public String getFatJudgCd() {
		return this.fatJudgCd;
	}
	
	/**
	 * Set fat_judg_cd 비만_판정_코드 character varying(20)
	 * @Param String fatJudgCd
	 */
	public void setFatJudgCd(String fatJudgCd) {
		this.fatJudgCd = fatJudgCd;
	}
	/**
	 * Get fatp_judg_cd 비만예측_판정_코드 character varying(20)
	 * @Return String fatpJudgCd
	 */
	public String getFatpJudgCd() {
		return this.fatpJudgCd;
	}
	
	/**
	 * Set fatp_judg_cd 비만예측_판정_코드 character varying(20)
	 * @Param String fatpJudgCd
	 */
	public void setFatpJudgCd(String fatpJudgCd) {
		this.fatpJudgCd = fatpJudgCd;
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
	 * Get age_ycnt 나이_년수 numeric(null)
	 * @Return Double ageYcnt
	 */
	public Double getAgeYcnt() {
		return this.ageYcnt;
	}
	
	/**
	 * Set age_ycnt 나이_년수 numeric(null)
	 * @Param Double ageYcnt
	 */
	public void setAgeYcnt(Double ageYcnt) {
		this.ageYcnt = ageYcnt;
	}
	/**
	 * Get pal_cd 신체활동수준_코드 character varying(20)
	 * @Return String palCd
	 */
	public String getPalCd() {
		return this.palCd;
	}
	
	/**
	 * Set pal_cd 신체활동수준_코드 character varying(20)
	 * @Param String palCd
	 */
	public void setPalCd(String palCd) {
		this.palCd = palCd;
	}
	/**
	 * Get cal_qty_fr 칼로리_량_FROM numeric(null)
	 * @Return Double calQtyFr
	 */
	public Double getCalQtyFr() {
		return this.calQtyFr;
	}
	
	/**
	 * Set cal_qty_fr 칼로리_량_FROM numeric(null)
	 * @Param Double calQtyFr
	 */
	public void setCalQtyFr(Double calQtyFr) {
		this.calQtyFr = calQtyFr;
	}
	/**
	 * Get cal_qty_to 칼로리_량_TO numeric(null)
	 * @Return Double calQtyTo
	 */
	public Double getCalQtyTo() {
		return this.calQtyTo;
	}
	
	/**
	 * Set cal_qty_to 칼로리_량_TO numeric(null)
	 * @Param Double calQtyTo
	 */
	public void setCalQtyTo(Double calQtyTo) {
		this.calQtyTo = calQtyTo;
	}
	/**
	 * Get dd_cal_qty 일일_칼로리_량 numeric(null)
	 * @Return Double ddCalQty
	 */
	public Double getDdCalQty() {
		return this.ddCalQty;
	}
	
	/**
	 * Set dd_cal_qty 일일_칼로리_량 numeric(null)
	 * @Param Double ddCalQty
	 */
	public void setDdCalQty(Double ddCalQty) {
		this.ddCalQty = ddCalQty;
	}
	/**
	 * Get nutr_cd 영양소_코드 character varying(20)
	 * @Return String nutrCd
	 */
	public String getNutrCd() {
		return this.nutrCd;
	}
	
	/**
	 * Set nutr_cd 영양소_코드 character varying(20)
	 * @Param String nutrCd
	 */
	public void setNutrCd(String nutrCd) {
		this.nutrCd = nutrCd;
	}
	/**
	 * Get nutr_stat_cd 영양섭취_상태_코드 character varying(20)
	 * @Return String nutrStatCd
	 */
	public String getNutrStatCd() {
		return this.nutrStatCd;
	}
	
	/**
	 * Set nutr_stat_cd 영양섭취_상태_코드 character varying(20)
	 * @Param String nutrStatCd
	 */
	public void setNutrStatCd(String nutrStatCd) {
		this.nutrStatCd = nutrStatCd;
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
