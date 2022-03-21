package kr.co.seculink.domain.vo;

import java.io.Serializable;

/**
 * tc_job_base Value Object
 */
public class TcJobBaseVo implements Serializable {

	/* job_id 작업_ID character varying(20) */
	private String jobId;

	/* job_nm 작업_명 character varying(100) */
	private String jobNm;

	/* rmrk 비고 text(null) */
	private String rmrk;

	/* job_hist_no 작업_이력_번호 character varying(20) */
	private String jobHistNo;

	/* reg_dt 등록_일자 character(18) */
	private String regDt;

	/* reg_tm 등록_시각 character(18) */
	private String regTm;

	/* reg_user_id 등록_사용자_ID character(9999) */
	private String regUserId;

	/* upt_dt 수정_일자 character(18) */
	private String uptDt;

	/* upt_tm 수정_시각 character(18) */
	private String uptTm;

	/* upt_user_id 수정_사용자_ID character(9999) */
	private String uptUserId;


	/**
	 * Get job_id 작업_ID character varying(20)
	 * @Return String jobId
	 */
	public String getJobId() {
		return this.jobId;
	}
	
	/**
	 * Set job_id 작업_ID character varying(20)
	 * @Param String jobId
	 */
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	/**
	 * Get job_nm 작업_명 character varying(100)
	 * @Return String jobNm
	 */
	public String getJobNm() {
		return this.jobNm;
	}
	
	/**
	 * Set job_nm 작업_명 character varying(100)
	 * @Param String jobNm
	 */
	public void setJobNm(String jobNm) {
		this.jobNm = jobNm;
	}
	/**
	 * Get rmrk 비고 text(null)
	 * @Return String rmrk
	 */
	public String getRmrk() {
		return this.rmrk;
	}
	
	/**
	 * Set rmrk 비고 text(null)
	 * @Param String rmrk
	 */
	public void setRmrk(String rmrk) {
		this.rmrk = rmrk;
	}
	/**
	 * Get job_hist_no 작업_이력_번호 character varying(20)
	 * @Return String jobHistNo
	 */
	public String getJobHistNo() {
		return this.jobHistNo;
	}
	
	/**
	 * Set job_hist_no 작업_이력_번호 character varying(20)
	 * @Param String jobHistNo
	 */
	public void setJobHistNo(String jobHistNo) {
		this.jobHistNo = jobHistNo;
	}
	/**
	 * Get reg_dt 등록_일자 character(18)
	 * @Return String regDt
	 */
	public String getRegDt() {
		return this.regDt;
	}
	
	/**
	 * Set reg_dt 등록_일자 character(18)
	 * @Param String regDt
	 */
	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}
	/**
	 * Get reg_tm 등록_시각 character(18)
	 * @Return String regTm
	 */
	public String getRegTm() {
		return this.regTm;
	}
	
	/**
	 * Set reg_tm 등록_시각 character(18)
	 * @Param String regTm
	 */
	public void setRegTm(String regTm) {
		this.regTm = regTm;
	}
	/**
	 * Get reg_user_id 등록_사용자_ID character(9999)
	 * @Return String regUserId
	 */
	public String getRegUserId() {
		return this.regUserId;
	}
	
	/**
	 * Set reg_user_id 등록_사용자_ID character(9999)
	 * @Param String regUserId
	 */
	public void setRegUserId(String regUserId) {
		this.regUserId = regUserId;
	}
	/**
	 * Get upt_dt 수정_일자 character(18)
	 * @Return String uptDt
	 */
	public String getUptDt() {
		return this.uptDt;
	}
	
	/**
	 * Set upt_dt 수정_일자 character(18)
	 * @Param String uptDt
	 */
	public void setUptDt(String uptDt) {
		this.uptDt = uptDt;
	}
	/**
	 * Get upt_tm 수정_시각 character(18)
	 * @Return String uptTm
	 */
	public String getUptTm() {
		return this.uptTm;
	}
	
	/**
	 * Set upt_tm 수정_시각 character(18)
	 * @Param String uptTm
	 */
	public void setUptTm(String uptTm) {
		this.uptTm = uptTm;
	}
	/**
	 * Get upt_user_id 수정_사용자_ID character(9999)
	 * @Return String uptUserId
	 */
	public String getUptUserId() {
		return this.uptUserId;
	}
	
	/**
	 * Set upt_user_id 수정_사용자_ID character(9999)
	 * @Param String uptUserId
	 */
	public void setUptUserId(String uptUserId) {
		this.uptUserId = uptUserId;
	}

} // end of class
