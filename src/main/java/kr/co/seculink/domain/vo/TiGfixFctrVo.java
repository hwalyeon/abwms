package kr.co.seculink.domain.vo;

import java.io.Serializable;
import lombok.ToString;
/**
 * ti_gfix_fctr Value Object
 */
 @ToString
public class TiGfixFctrVo implements Serializable {

	/* gfix_div_cd 성장비만지수_구분_코드 character varying(20) */
	private String gfixDivCd;

	/* sex_cd 성별_코드 character varying(20) */
	private String sexCd;

	/* age_mcnt 나이_개월수 numeric(null) */
	private Double ageMcnt;

	/* fctr_1 팩터_1 numeric(null) */
	private Double fctr1;

	/* fctr_2 팩터_2 numeric(null) */
	private Double fctr2;

	/* fctr_3 팩터_3 numeric(null) */
	private Double fctr3;

	/* fctr_4 팩터_4 numeric(null) */
	private Double fctr4;

	/* fctr_5 팩터_5 numeric(null) */
	private Double fctr5;

	/* fctr_6 팩터_6 numeric(null) */
	private Double fctr6;

	/* fctr_7 팩터_7 numeric(null) */
	private Double fctr7;

	/* idx_frml_cd 지수_공식_코드 character varying(500) */
	private String idxFrmlCd;

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
	 * Get gfix_div_cd 성장비만지수_구분_코드 character varying(20)
	 * @Return String gfixDivCd
	 */
	public String getGfixDivCd() {
		return this.gfixDivCd;
	}
	
	/**
	 * Set gfix_div_cd 성장비만지수_구분_코드 character varying(20)
	 * @Param String gfixDivCd
	 */
	public void setGfixDivCd(String gfixDivCd) {
		this.gfixDivCd = gfixDivCd;
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
	 * Get age_mcnt 나이_개월수 numeric(null)
	 * @Return Double ageMcnt
	 */
	public Double getAgeMcnt() {
		return this.ageMcnt;
	}
	
	/**
	 * Set age_mcnt 나이_개월수 numeric(null)
	 * @Param Double ageMcnt
	 */
	public void setAgeMcnt(Double ageMcnt) {
		this.ageMcnt = ageMcnt;
	}
	/**
	 * Get fctr_1 팩터_1 numeric(null)
	 * @Return Double fctr1
	 */
	public Double getFctr1() {
		return this.fctr1;
	}
	
	/**
	 * Set fctr_1 팩터_1 numeric(null)
	 * @Param Double fctr1
	 */
	public void setFctr1(Double fctr1) {
		this.fctr1 = fctr1;
	}
	/**
	 * Get fctr_2 팩터_2 numeric(null)
	 * @Return Double fctr2
	 */
	public Double getFctr2() {
		return this.fctr2;
	}
	
	/**
	 * Set fctr_2 팩터_2 numeric(null)
	 * @Param Double fctr2
	 */
	public void setFctr2(Double fctr2) {
		this.fctr2 = fctr2;
	}
	/**
	 * Get fctr_3 팩터_3 numeric(null)
	 * @Return Double fctr3
	 */
	public Double getFctr3() {
		return this.fctr3;
	}
	
	/**
	 * Set fctr_3 팩터_3 numeric(null)
	 * @Param Double fctr3
	 */
	public void setFctr3(Double fctr3) {
		this.fctr3 = fctr3;
	}
	/**
	 * Get fctr_4 팩터_4 numeric(null)
	 * @Return Double fctr4
	 */
	public Double getFctr4() {
		return this.fctr4;
	}
	
	/**
	 * Set fctr_4 팩터_4 numeric(null)
	 * @Param Double fctr4
	 */
	public void setFctr4(Double fctr4) {
		this.fctr4 = fctr4;
	}
	/**
	 * Get fctr_5 팩터_5 numeric(null)
	 * @Return Double fctr5
	 */
	public Double getFctr5() {
		return this.fctr5;
	}
	
	/**
	 * Set fctr_5 팩터_5 numeric(null)
	 * @Param Double fctr5
	 */
	public void setFctr5(Double fctr5) {
		this.fctr5 = fctr5;
	}
	/**
	 * Get fctr_6 팩터_6 numeric(null)
	 * @Return Double fctr6
	 */
	public Double getFctr6() {
		return this.fctr6;
	}
	
	/**
	 * Set fctr_6 팩터_6 numeric(null)
	 * @Param Double fctr6
	 */
	public void setFctr6(Double fctr6) {
		this.fctr6 = fctr6;
	}
	/**
	 * Get fctr_7 팩터_7 numeric(null)
	 * @Return Double fctr7
	 */
	public Double getFctr7() {
		return this.fctr7;
	}
	
	/**
	 * Set fctr_7 팩터_7 numeric(null)
	 * @Param Double fctr7
	 */
	public void setFctr7(Double fctr7) {
		this.fctr7 = fctr7;
	}
	/**
	 * Get idx_frml_cd 지수_공식_코드 character varying(500)
	 * @Return String idxFrmlCd
	 */
	public String getIdxFrmlCd() {
		return this.idxFrmlCd;
	}
	
	/**
	 * Set idx_frml_cd 지수_공식_코드 character varying(500)
	 * @Param String idxFrmlCd
	 */
	public void setIdxFrmlCd(String idxFrmlCd) {
		this.idxFrmlCd = idxFrmlCd;
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
