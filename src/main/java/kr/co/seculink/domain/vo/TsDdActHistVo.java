package kr.co.seculink.domain.vo;

import java.io.Serializable;

/**
 * ts_dd_act_hist Value Object
 */
public class TsDdActHistVo implements Serializable {

	/* stnd_dt 기준_일자 character(8) */
	private String stndDt;

	/* stdt_no 학생_번호 numeric(null) */
	private Double stdtNo;

	/* act_cd 활동_코드 character varying(20) */
	private String actCd;

	/* act_mcnt 활동_분수 numeric(null) */
	private Double actMcnt;

	/* rpet_act_cnt 반복_활동_수 numeric(null) */
	private Double rpetActCnt;

	/* acsm_val 활동에너지소모량_값 numeric(null) */
	private Double acsmVal;

	/* judg_no 판정_번호 numeric(null) */
	private Double judgNo;

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
	 * Get act_cd 활동_코드 character varying(20)
	 * @Return String actCd
	 */
	public String getActCd() {
		return this.actCd;
	}
	
	/**
	 * Set act_cd 활동_코드 character varying(20)
	 * @Param String actCd
	 */
	public void setActCd(String actCd) {
		this.actCd = actCd;
	}
	/**
	 * Get act_mcnt 활동_분수 numeric(null)
	 * @Return Double actMcnt
	 */
	public Double getActMcnt() {
		return this.actMcnt;
	}
	
	/**
	 * Set act_mcnt 활동_분수 numeric(null)
	 * @Param Double actMcnt
	 */
	public void setActMcnt(Double actMcnt) {
		this.actMcnt = actMcnt;
	}
	/**
	 * Get rpet_act_cnt 반복_활동_수 numeric(null)
	 * @Return Double rpetActCnt
	 */
	public Double getRpetActCnt() {
		return this.rpetActCnt;
	}
	
	/**
	 * Set rpet_act_cnt 반복_활동_수 numeric(null)
	 * @Param Double rpetActCnt
	 */
	public void setRpetActCnt(Double rpetActCnt) {
		this.rpetActCnt = rpetActCnt;
	}
	/**
	 * Get acsm_val 활동에너지소모량_값 numeric(null)
	 * @Return Double acsmVal
	 */
	public Double getAcsmVal() {
		return this.acsmVal;
	}
	
	/**
	 * Set acsm_val 활동에너지소모량_값 numeric(null)
	 * @Param Double acsmVal
	 */
	public void setAcsmVal(Double acsmVal) {
		this.acsmVal = acsmVal;
	}
	/**
	 * Get judg_no 판정_번호 numeric(null)
	 * @Return Double judgNo
	 */
	public Double getJudgNo() {
		return this.judgNo;
	}
	
	/**
	 * Set judg_no 판정_번호 numeric(null)
	 * @Param Double judgNo
	 */
	public void setJudgNo(Double judgNo) {
		this.judgNo = judgNo;
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
