package kr.co.seculink.domain.vo;

import java.io.Serializable;
import lombok.ToString;
/**
 * tm_prnt_base Value Object
 */
 @ToString
public class TmPrntBaseVo implements Serializable {

	/* prnt_no 학부모_번호 numeric(null) */
	private Double prntNo;

	/* sex_cd 성별_코드 character varying(20) */
	private String sexCd;

	/* prnt_nm 학부모_명 character varying(256) */
	private String prntNm;

	/* hght_val 키_값 numeric(null) */
	private Double hghtVal;

	/* wght_val 체중_값 numeric(null) */
	private Double wghtVal;

	/* bmi_val BMI_값 numeric(null) */
	private Double bmiVal;

	/* race_div_cd 인종_구분_코드 character varying(20) */
	private String raceDivCd;

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
	 * Get prnt_no 학부모_번호 numeric(null)
	 * @Return Double prntNo
	 */
	public Double getPrntNo() {
		return this.prntNo;
	}
	
	/**
	 * Set prnt_no 학부모_번호 numeric(null)
	 * @Param Double prntNo
	 */
	public void setPrntNo(Double prntNo) {
		this.prntNo = prntNo;
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
	 * Get prnt_nm 학부모_명 character varying(256)
	 * @Return String prntNm
	 */
	public String getPrntNm() {
		return this.prntNm;
	}
	
	/**
	 * Set prnt_nm 학부모_명 character varying(256)
	 * @Param String prntNm
	 */
	public void setPrntNm(String prntNm) {
		this.prntNm = prntNm;
	}
	/**
	 * Get hght_val 키_값 numeric(null)
	 * @Return Double hghtVal
	 */
	public Double getHghtVal() {
		return this.hghtVal;
	}
	
	/**
	 * Set hght_val 키_값 numeric(null)
	 * @Param Double hghtVal
	 */
	public void setHghtVal(Double hghtVal) {
		this.hghtVal = hghtVal;
	}
	/**
	 * Get wght_val 체중_값 numeric(null)
	 * @Return Double wghtVal
	 */
	public Double getWghtVal() {
		return this.wghtVal;
	}
	
	/**
	 * Set wght_val 체중_값 numeric(null)
	 * @Param Double wghtVal
	 */
	public void setWghtVal(Double wghtVal) {
		this.wghtVal = wghtVal;
	}
	/**
	 * Get bmi_val BMI_값 numeric(null)
	 * @Return Double bmiVal
	 */
	public Double getBmiVal() {
		return this.bmiVal;
	}
	
	/**
	 * Set bmi_val BMI_값 numeric(null)
	 * @Param Double bmiVal
	 */
	public void setBmiVal(Double bmiVal) {
		this.bmiVal = bmiVal;
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
