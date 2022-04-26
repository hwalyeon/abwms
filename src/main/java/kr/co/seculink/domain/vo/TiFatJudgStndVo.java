package kr.co.seculink.domain.vo;

import java.io.Serializable;
import lombok.ToString;
/**
 * ti_fat_judg_stnd Value Object
 */
 @ToString
public class TiFatJudgStndVo implements Serializable {

	/* fat_judg_cd 비만_판정_코드 character varying(20) */
	private String fatJudgCd;

	/* bmi_fr BMI_FROM numeric(null) */
	private Double bmiFr;

	/* bmi_to BMI_TO numeric(null) */
	private Double bmiTo;

	/* fidx_fr 비만지수_FROM numeric(null) */
	private Double fidxFr;

	/* fidx_to 비만지수_TO numeric(null) */
	private Double fidxTo;

	/* curr_eval_cntn 현재_평가_내용 character varying(4000) */
	private String currEvalCntn;

	/* prdt_eval_cntn 예측_평가_내용 character varying(4000) */
	private String prdtEvalCntn;

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
	 * Get bmi_fr BMI_FROM numeric(null)
	 * @Return Double bmiFr
	 */
	public Double getBmiFr() {
		return this.bmiFr;
	}
	
	/**
	 * Set bmi_fr BMI_FROM numeric(null)
	 * @Param Double bmiFr
	 */
	public void setBmiFr(Double bmiFr) {
		this.bmiFr = bmiFr;
	}
	/**
	 * Get bmi_to BMI_TO numeric(null)
	 * @Return Double bmiTo
	 */
	public Double getBmiTo() {
		return this.bmiTo;
	}
	
	/**
	 * Set bmi_to BMI_TO numeric(null)
	 * @Param Double bmiTo
	 */
	public void setBmiTo(Double bmiTo) {
		this.bmiTo = bmiTo;
	}
	/**
	 * Get fidx_fr 비만지수_FROM numeric(null)
	 * @Return Double fidxFr
	 */
	public Double getFidxFr() {
		return this.fidxFr;
	}
	
	/**
	 * Set fidx_fr 비만지수_FROM numeric(null)
	 * @Param Double fidxFr
	 */
	public void setFidxFr(Double fidxFr) {
		this.fidxFr = fidxFr;
	}
	/**
	 * Get fidx_to 비만지수_TO numeric(null)
	 * @Return Double fidxTo
	 */
	public Double getFidxTo() {
		return this.fidxTo;
	}
	
	/**
	 * Set fidx_to 비만지수_TO numeric(null)
	 * @Param Double fidxTo
	 */
	public void setFidxTo(Double fidxTo) {
		this.fidxTo = fidxTo;
	}
	/**
	 * Get curr_eval_cntn 현재_평가_내용 character varying(4000)
	 * @Return String currEvalCntn
	 */
	public String getCurrEvalCntn() {
		return this.currEvalCntn;
	}
	
	/**
	 * Set curr_eval_cntn 현재_평가_내용 character varying(4000)
	 * @Param String currEvalCntn
	 */
	public void setCurrEvalCntn(String currEvalCntn) {
		this.currEvalCntn = currEvalCntn;
	}
	/**
	 * Get prdt_eval_cntn 예측_평가_내용 character varying(4000)
	 * @Return String prdtEvalCntn
	 */
	public String getPrdtEvalCntn() {
		return this.prdtEvalCntn;
	}
	
	/**
	 * Set prdt_eval_cntn 예측_평가_내용 character varying(4000)
	 * @Param String prdtEvalCntn
	 */
	public void setPrdtEvalCntn(String prdtEvalCntn) {
		this.prdtEvalCntn = prdtEvalCntn;
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
