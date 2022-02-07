package kr.co.seculink.domain.vo;

import java.io.Serializable;

/**
 * ti_dd_nutr_eat_blck Value Object
 */
public class TiDdNutrEatBlckVo implements Serializable {

	/* sex_cd 성별_코드 character varying(20) */
	private String sexCd;

	/* nutr_cd 영양소_코드 character varying(20) */
	private String nutrCd;

	/* age_ycnt_fr 나이_년수_FROM numeric(null) */
	private double ageYcntFr;

	/* age_ycnt_to 나이_년수_TO numeric(null) */
	private double ageYcntTo;

	/* eat_qty_fr 섭취_량_FROM numeric(null) */
	private double eatQtyFr;

	/* eat_qty_to 섭취_량_TO character(18) */
	private String eatQtyTo;

	/* nutr_stat_cd 영양섭취_상태_코드 character varying(4000) */
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
	 * Get eat_qty_fr 섭취_량_FROM numeric(null)
	 * @Return double eatQtyFr
	 */
	public double getEatQtyFr() {
		return this.eatQtyFr;
	}
	
	/**
	 * Set eat_qty_fr 섭취_량_FROM numeric(null)
	 * @Param double eatQtyFr
	 */
	public void setEatQtyFr(double eatQtyFr) {
		this.eatQtyFr = eatQtyFr;
	}
	/**
	 * Get eat_qty_to 섭취_량_TO character(18)
	 * @Return String eatQtyTo
	 */
	public String getEatQtyTo() {
		return this.eatQtyTo;
	}
	
	/**
	 * Set eat_qty_to 섭취_량_TO character(18)
	 * @Param String eatQtyTo
	 */
	public void setEatQtyTo(String eatQtyTo) {
		this.eatQtyTo = eatQtyTo;
	}
	/**
	 * Get nutr_stat_cd 영양섭취_상태_코드 character varying(4000)
	 * @Return String nutrStatCd
	 */
	public String getNutrStatCd() {
		return this.nutrStatCd;
	}
	
	/**
	 * Set nutr_stat_cd 영양섭취_상태_코드 character varying(4000)
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
