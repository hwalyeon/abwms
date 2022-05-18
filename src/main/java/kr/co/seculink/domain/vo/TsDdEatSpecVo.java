package kr.co.seculink.domain.vo;

import java.io.Serializable;
import lombok.ToString;
/**
 * ts_dd_eat_spec Value Object
 */
 @ToString
public class TsDdEatSpecVo implements Serializable {

	/* stnd_dt 기준_일자 character(8) */
	private String stndDt;

	/* stdt_no 학생_번호 numeric(null) */
	private Double stdtNo;

	/* nutr_cd 영양소_코드 character varying(20) */
	private String nutrCd;

	/* nutr_eat_qty 영양소_섭취_량 numeric(null) */
	private Double nutrEatQty;

	/* nutr_stat_cd 영양섭취_상태_코드 character varying(20) */
	private String nutrStatCd;

	/* avg_nutr_eat_qty 평균_영양소_섭취_량 character(18) */
	private String avgNutrEatQty;

	/* avg_nutr_stat_cd 평균_영양섭취_상태_코드 character(18) */
	private String avgNutrStatCd;

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
	 * Get stnd_dt 기준_일자 character(8)
	 * @Return String stndDt
	 */
	public String getStndDt() {
		return this.stndDt;
	}
	
	/**
	 * Set stnd_dt 기준_일자 character(8)
	 * @Param String stndDt
	 */
	public void setStndDt(String stndDt) {
		this.stndDt = stndDt;
	}
	/**
	 * Get stdt_no 학생_번호 numeric(null)
	 * @Return Double stdtNo
	 */
	public Double getStdtNo() {
		return this.stdtNo;
	}
	
	/**
	 * Set stdt_no 학생_번호 numeric(null)
	 * @Param Double stdtNo
	 */
	public void setStdtNo(Double stdtNo) {
		this.stdtNo = stdtNo;
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
	 * Get nutr_eat_qty 영양소_섭취_량 numeric(null)
	 * @Return Double nutrEatQty
	 */
	public Double getNutrEatQty() {
		return this.nutrEatQty;
	}
	
	/**
	 * Set nutr_eat_qty 영양소_섭취_량 numeric(null)
	 * @Param Double nutrEatQty
	 */
	public void setNutrEatQty(Double nutrEatQty) {
		this.nutrEatQty = nutrEatQty;
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
	 * Get avg_nutr_eat_qty 평균_영양소_섭취_량 character(18)
	 * @Return String avgNutrEatQty
	 */
	public String getAvgNutrEatQty() {
		return this.avgNutrEatQty;
	}
	
	/**
	 * Set avg_nutr_eat_qty 평균_영양소_섭취_량 character(18)
	 * @Param String avgNutrEatQty
	 */
	public void setAvgNutrEatQty(String avgNutrEatQty) {
		this.avgNutrEatQty = avgNutrEatQty;
	}
	/**
	 * Get avg_nutr_stat_cd 평균_영양섭취_상태_코드 character(18)
	 * @Return String avgNutrStatCd
	 */
	public String getAvgNutrStatCd() {
		return this.avgNutrStatCd;
	}
	
	/**
	 * Set avg_nutr_stat_cd 평균_영양섭취_상태_코드 character(18)
	 * @Param String avgNutrStatCd
	 */
	public void setAvgNutrStatCd(String avgNutrStatCd) {
		this.avgNutrStatCd = avgNutrStatCd;
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
