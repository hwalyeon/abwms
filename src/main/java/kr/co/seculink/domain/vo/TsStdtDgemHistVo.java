package kr.co.seculink.domain.vo;

import java.io.Serializable;

/**
 * ts_stdt_dgem_hist Value Object
 */
public class TsStdtDgemHistVo implements Serializable {

	/* stdt_no 학생_번호 numeric(null) */
	private double stdtNo;

	/* dgem_hist_seq 위험감정_이력_순번 numeric(null) */
	private double dgemHistSeq;

	/* dgem_dt 위험감정_일자 character(8) */
	private String dgemDt;

	/* dgem_tm 위험감정_시각 character(6) */
	private String dgemTm;

	/* dgem_idx 위험감정_지수 numeric(null) */
	private double dgemIdx;

	/* dgem_stat_cd 위험감정_상태_코드 character varying(20) */
	private String dgemStatCd;

	/* dgem_smry_cntn 위험감정_요약_내용 character varying(200) */
	private String dgemSmryCntn;

	/* dgem_stat_cntn 위험감정_상태_내용 text(null) */
	private String dgemStatCntn;

	/* loc_hist_no 위치_이력_번호 numeric(null) */
	private double locHistNo;

	/* act_div_cd 활동_구분_코드 character varying(20) */
	private String actDivCd;

	/* hbit_stat_cd 심박_상태_코드 character varying(20) */
	private String hbitStatCd;

	/* plc_clss_cd 장소_분류_코드 character varying(20) */
	private String plcClssCd;

	/* temp_stat_cd 체온_상태_코드 character varying(20) */
	private String tempStatCd;

	/* judg_no 판정_번호 numeric(null) */
	private double judgNo;

	/* rmrk 비고 character varying(4000) */
	private String rmrk;

	/* dgem_alam_no 위험감정_알림_번호 numeric(null) */
	private double dgemAlamNo;

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
	 * Get stdt_no 학생_번호 numeric(null)
	 * @Return double stdtNo
	 */
	public double getStdtNo() {
		return this.stdtNo;
	}
	
	/**
	 * Set stdt_no 학생_번호 numeric(null)
	 * @Param double stdtNo
	 */
	public void setStdtNo(double stdtNo) {
		this.stdtNo = stdtNo;
	}
	/**
	 * Get dgem_hist_seq 위험감정_이력_순번 numeric(null)
	 * @Return double dgemHistSeq
	 */
	public double getDgemHistSeq() {
		return this.dgemHistSeq;
	}
	
	/**
	 * Set dgem_hist_seq 위험감정_이력_순번 numeric(null)
	 * @Param double dgemHistSeq
	 */
	public void setDgemHistSeq(double dgemHistSeq) {
		this.dgemHistSeq = dgemHistSeq;
	}
	/**
	 * Get dgem_dt 위험감정_일자 character(8)
	 * @Return String dgemDt
	 */
	public String getDgemDt() {
		return this.dgemDt;
	}
	
	/**
	 * Set dgem_dt 위험감정_일자 character(8)
	 * @Param String dgemDt
	 */
	public void setDgemDt(String dgemDt) {
		this.dgemDt = dgemDt;
	}
	/**
	 * Get dgem_tm 위험감정_시각 character(6)
	 * @Return String dgemTm
	 */
	public String getDgemTm() {
		return this.dgemTm;
	}
	
	/**
	 * Set dgem_tm 위험감정_시각 character(6)
	 * @Param String dgemTm
	 */
	public void setDgemTm(String dgemTm) {
		this.dgemTm = dgemTm;
	}
	/**
	 * Get dgem_idx 위험감정_지수 numeric(null)
	 * @Return double dgemIdx
	 */
	public double getDgemIdx() {
		return this.dgemIdx;
	}
	
	/**
	 * Set dgem_idx 위험감정_지수 numeric(null)
	 * @Param double dgemIdx
	 */
	public void setDgemIdx(double dgemIdx) {
		this.dgemIdx = dgemIdx;
	}
	/**
	 * Get dgem_stat_cd 위험감정_상태_코드 character varying(20)
	 * @Return String dgemStatCd
	 */
	public String getDgemStatCd() {
		return this.dgemStatCd;
	}
	
	/**
	 * Set dgem_stat_cd 위험감정_상태_코드 character varying(20)
	 * @Param String dgemStatCd
	 */
	public void setDgemStatCd(String dgemStatCd) {
		this.dgemStatCd = dgemStatCd;
	}
	/**
	 * Get dgem_smry_cntn 위험감정_요약_내용 character varying(200)
	 * @Return String dgemSmryCntn
	 */
	public String getDgemSmryCntn() {
		return this.dgemSmryCntn;
	}
	
	/**
	 * Set dgem_smry_cntn 위험감정_요약_내용 character varying(200)
	 * @Param String dgemSmryCntn
	 */
	public void setDgemSmryCntn(String dgemSmryCntn) {
		this.dgemSmryCntn = dgemSmryCntn;
	}
	/**
	 * Get dgem_stat_cntn 위험감정_상태_내용 text(null)
	 * @Return String dgemStatCntn
	 */
	public String getDgemStatCntn() {
		return this.dgemStatCntn;
	}
	
	/**
	 * Set dgem_stat_cntn 위험감정_상태_내용 text(null)
	 * @Param String dgemStatCntn
	 */
	public void setDgemStatCntn(String dgemStatCntn) {
		this.dgemStatCntn = dgemStatCntn;
	}
	/**
	 * Get loc_hist_no 위치_이력_번호 numeric(null)
	 * @Return double locHistNo
	 */
	public double getLocHistNo() {
		return this.locHistNo;
	}
	
	/**
	 * Set loc_hist_no 위치_이력_번호 numeric(null)
	 * @Param double locHistNo
	 */
	public void setLocHistNo(double locHistNo) {
		this.locHistNo = locHistNo;
	}
	/**
	 * Get act_div_cd 활동_구분_코드 character varying(20)
	 * @Return String actDivCd
	 */
	public String getActDivCd() {
		return this.actDivCd;
	}
	
	/**
	 * Set act_div_cd 활동_구분_코드 character varying(20)
	 * @Param String actDivCd
	 */
	public void setActDivCd(String actDivCd) {
		this.actDivCd = actDivCd;
	}
	/**
	 * Get hbit_stat_cd 심박_상태_코드 character varying(20)
	 * @Return String hbitStatCd
	 */
	public String getHbitStatCd() {
		return this.hbitStatCd;
	}
	
	/**
	 * Set hbit_stat_cd 심박_상태_코드 character varying(20)
	 * @Param String hbitStatCd
	 */
	public void setHbitStatCd(String hbitStatCd) {
		this.hbitStatCd = hbitStatCd;
	}
	/**
	 * Get plc_clss_cd 장소_분류_코드 character varying(20)
	 * @Return String plcClssCd
	 */
	public String getPlcClssCd() {
		return this.plcClssCd;
	}
	
	/**
	 * Set plc_clss_cd 장소_분류_코드 character varying(20)
	 * @Param String plcClssCd
	 */
	public void setPlcClssCd(String plcClssCd) {
		this.plcClssCd = plcClssCd;
	}
	/**
	 * Get temp_stat_cd 체온_상태_코드 character varying(20)
	 * @Return String tempStatCd
	 */
	public String getTempStatCd() {
		return this.tempStatCd;
	}
	
	/**
	 * Set temp_stat_cd 체온_상태_코드 character varying(20)
	 * @Param String tempStatCd
	 */
	public void setTempStatCd(String tempStatCd) {
		this.tempStatCd = tempStatCd;
	}
	/**
	 * Get judg_no 판정_번호 numeric(null)
	 * @Return double judgNo
	 */
	public double getJudgNo() {
		return this.judgNo;
	}
	
	/**
	 * Set judg_no 판정_번호 numeric(null)
	 * @Param double judgNo
	 */
	public void setJudgNo(double judgNo) {
		this.judgNo = judgNo;
	}
	/**
	 * Get rmrk 비고 character varying(4000)
	 * @Return String rmrk
	 */
	public String getRmrk() {
		return this.rmrk;
	}
	
	/**
	 * Set rmrk 비고 character varying(4000)
	 * @Param String rmrk
	 */
	public void setRmrk(String rmrk) {
		this.rmrk = rmrk;
	}
	/**
	 * Get dgem_alam_no 위험감정_알림_번호 numeric(null)
	 * @Return double dgemAlamNo
	 */
	public double getDgemAlamNo() {
		return this.dgemAlamNo;
	}
	
	/**
	 * Set dgem_alam_no 위험감정_알림_번호 numeric(null)
	 * @Param double dgemAlamNo
	 */
	public void setDgemAlamNo(double dgemAlamNo) {
		this.dgemAlamNo = dgemAlamNo;
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
