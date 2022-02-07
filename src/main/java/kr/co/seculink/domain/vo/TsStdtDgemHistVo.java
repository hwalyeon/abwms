package kr.co.seculink.domain.vo;

import java.io.Serializable;

/**
 * ts_stdt_dgem_hist Value Object
 */
public class TsStdtDgemHistVo implements Serializable {

	/* stdt_no 학생_번호 numeric(null) */
	private double stdtNo;

	/* dgem_hist_seq 위험감정_이력_순번 character(18) */
	private String dgemHistSeq;

	/* loc_hist_no 위치_이력_번호 character(18) */
	private String locHistNo;

	/* curr_lat_val 현재_위도_값 numeric(null) */
	private double currLatVal;

	/* curr_lon_val 현재_경도_값 numeric(null) */
	private double currLonVal;

	/* loc_mesu_dttm 위치_측정_일시 character(14) */
	private String locMesuDttm;

	/* dgem_idx 위험감정_지수 numeric(null) */
	private double dgemIdx;

	/* dgem_stat_cd 위험감정_상태_코드 character varying(20) */
	private String dgemStatCd;

	/* rmrk 비고 character varying(1000) */
	private String rmrk;

	/* judg_no 판정_번호 numeric(null) */
	private double judgNo;

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
	 * Get dgem_hist_seq 위험감정_이력_순번 character(18)
	 * @Return String dgemHistSeq
	 */
	public String getDgemHistSeq() {
		return this.dgemHistSeq;
	}
	
	/**
	 * Set dgem_hist_seq 위험감정_이력_순번 character(18)
	 * @Param String dgemHistSeq
	 */
	public void setDgemHistSeq(String dgemHistSeq) {
		this.dgemHistSeq = dgemHistSeq;
	}
	/**
	 * Get loc_hist_no 위치_이력_번호 character(18)
	 * @Return String locHistNo
	 */
	public String getLocHistNo() {
		return this.locHistNo;
	}
	
	/**
	 * Set loc_hist_no 위치_이력_번호 character(18)
	 * @Param String locHistNo
	 */
	public void setLocHistNo(String locHistNo) {
		this.locHistNo = locHistNo;
	}
	/**
	 * Get curr_lat_val 현재_위도_값 numeric(null)
	 * @Return double currLatVal
	 */
	public double getCurrLatVal() {
		return this.currLatVal;
	}
	
	/**
	 * Set curr_lat_val 현재_위도_값 numeric(null)
	 * @Param double currLatVal
	 */
	public void setCurrLatVal(double currLatVal) {
		this.currLatVal = currLatVal;
	}
	/**
	 * Get curr_lon_val 현재_경도_값 numeric(null)
	 * @Return double currLonVal
	 */
	public double getCurrLonVal() {
		return this.currLonVal;
	}
	
	/**
	 * Set curr_lon_val 현재_경도_값 numeric(null)
	 * @Param double currLonVal
	 */
	public void setCurrLonVal(double currLonVal) {
		this.currLonVal = currLonVal;
	}
	/**
	 * Get loc_mesu_dttm 위치_측정_일시 character(14)
	 * @Return String locMesuDttm
	 */
	public String getLocMesuDttm() {
		return this.locMesuDttm;
	}
	
	/**
	 * Set loc_mesu_dttm 위치_측정_일시 character(14)
	 * @Param String locMesuDttm
	 */
	public void setLocMesuDttm(String locMesuDttm) {
		this.locMesuDttm = locMesuDttm;
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
	 * Get rmrk 비고 character varying(1000)
	 * @Return String rmrk
	 */
	public String getRmrk() {
		return this.rmrk;
	}
	
	/**
	 * Set rmrk 비고 character varying(1000)
	 * @Param String rmrk
	 */
	public void setRmrk(String rmrk) {
		this.rmrk = rmrk;
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
