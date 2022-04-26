package kr.co.seculink.domain.vo;

import java.io.Serializable;
import lombok.ToString;
/**
 * tc_job_hist Value Object
 */
 @ToString
public class TcJobHistVo implements Serializable {

	/* job_hist_no 작업_이력_번호 numeric(null) */
	private Double jobHistNo;

	/* job_id 작업_ID character varying(200) */
	private String jobId;

	/* strt_dt 시작_일자 character(8) */
	private String strtDt;

	/* strt_tm 시작_시각 character(6) */
	private String strtTm;

	/* end_dt 종료_일자 character(8) */
	private String endDt;

	/* end_tm 종료_시각 character(6) */
	private String endTm;

	/* job_tcnt 작업_시간 numeric(null) */
	private Double jobTcnt;

	/* rslt_cd 결과_코드 character varying(20) */
	private String rsltCd;

	/* rslt_cntn 결과_내용 text(null) */
	private String rsltCntn;

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
	 * Get job_hist_no 작업_이력_번호 numeric(null)
	 * @Return Double jobHistNo
	 */
	public Double getJobHistNo() {
		return this.jobHistNo;
	}
	
	/**
	 * Set job_hist_no 작업_이력_번호 numeric(null)
	 * @Param Double jobHistNo
	 */
	public void setJobHistNo(Double jobHistNo) {
		this.jobHistNo = jobHistNo;
	}
	/**
	 * Get job_id 작업_ID character varying(200)
	 * @Return String jobId
	 */
	public String getJobId() {
		return this.jobId;
	}
	
	/**
	 * Set job_id 작업_ID character varying(200)
	 * @Param String jobId
	 */
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	/**
	 * Get strt_dt 시작_일자 character(8)
	 * @Return String strtDt
	 */
	public String getStrtDt() {
		return this.strtDt;
	}
	
	/**
	 * Set strt_dt 시작_일자 character(8)
	 * @Param String strtDt
	 */
	public void setStrtDt(String strtDt) {
		this.strtDt = strtDt;
	}
	/**
	 * Get strt_tm 시작_시각 character(6)
	 * @Return String strtTm
	 */
	public String getStrtTm() {
		return this.strtTm;
	}
	
	/**
	 * Set strt_tm 시작_시각 character(6)
	 * @Param String strtTm
	 */
	public void setStrtTm(String strtTm) {
		this.strtTm = strtTm;
	}
	/**
	 * Get end_dt 종료_일자 character(8)
	 * @Return String endDt
	 */
	public String getEndDt() {
		return this.endDt;
	}
	
	/**
	 * Set end_dt 종료_일자 character(8)
	 * @Param String endDt
	 */
	public void setEndDt(String endDt) {
		this.endDt = endDt;
	}
	/**
	 * Get end_tm 종료_시각 character(6)
	 * @Return String endTm
	 */
	public String getEndTm() {
		return this.endTm;
	}
	
	/**
	 * Set end_tm 종료_시각 character(6)
	 * @Param String endTm
	 */
	public void setEndTm(String endTm) {
		this.endTm = endTm;
	}
	/**
	 * Get job_tcnt 작업_시간 numeric(null)
	 * @Return Double jobTcnt
	 */
	public Double getJobTcnt() {
		return this.jobTcnt;
	}
	
	/**
	 * Set job_tcnt 작업_시간 numeric(null)
	 * @Param Double jobTcnt
	 */
	public void setJobTcnt(Double jobTcnt) {
		this.jobTcnt = jobTcnt;
	}
	/**
	 * Get rslt_cd 결과_코드 character varying(20)
	 * @Return String rsltCd
	 */
	public String getRsltCd() {
		return this.rsltCd;
	}
	
	/**
	 * Set rslt_cd 결과_코드 character varying(20)
	 * @Param String rsltCd
	 */
	public void setRsltCd(String rsltCd) {
		this.rsltCd = rsltCd;
	}
	/**
	 * Get rslt_cntn 결과_내용 text(null)
	 * @Return String rsltCntn
	 */
	public String getRsltCntn() {
		return this.rsltCntn;
	}
	
	/**
	 * Set rslt_cntn 결과_내용 text(null)
	 * @Param String rsltCntn
	 */
	public void setRsltCntn(String rsltCntn) {
		this.rsltCntn = rsltCntn;
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
