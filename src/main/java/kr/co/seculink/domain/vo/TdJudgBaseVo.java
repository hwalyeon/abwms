package kr.co.seculink.domain.vo;

import java.io.Serializable;

/**
 * td_judg_base Value Object
 */
public class TdJudgBaseVo implements Serializable {

	/* judg_no 판정_번호 numeric(null) */
	private Double judgNo;

	/* evnt_div_cd 이벤트_구분_코드 character varying(20) */
	private String evntDivCd;

	/* band_id 밴드_ID character varying(20) */
	private String bandId;

	/* judg_dt 판정_일자 character(8) */
	private String judgDt;

	/* judg_tm 판정_시각 character(6) */
	private String judgTm;

	/* lat_val 위도_값 numeric(null) */
	private Double latVal;

	/* lon_val 경도_값 numeric(null) */
	private Double lonVal;

	/* hbit_stat_cd 심박_상태_코드 character varying(20) */
	private String hbitStatCd;

	/* min_hbit_cnt 최소_심박_수 numeric(null) */
	private Double minHbitCnt;

	/* max_hbit_cnt 최대_심박_수 numeric(null) */
	private Double maxHbitCnt;

	/* hbit_mdan 심박_중간값 numeric(null) */
	private Double hbitMdan;

	/* abnm_hbit_cnt 이상_심박_수 numeric(null) */
	private Double abnmHbitCnt;

	/* min1_hbit_cntn 1분_심박_내용 character varying(4000) */
	private String min1HbitCntn;

	/* temp_val 체온_값 numeric(null) */
	private Double tempVal;

	/* act_div_cd 활동_구분_코드 character varying(20) */
	private String actDivCd;

	/* cbee_bal 캐시비_잔액 numeric(null) */
	private Double cbeeBal;

	/* accu_run_tcnt_cnt 누적_달리기_시간_수 numeric(null) */
	private Double accuRunTcntCnt;

	/* accu_walk_tcnt_cnt 누적_걸음_시간_수 numeric(null) */
	private Double accuWalkTcntCnt;

	/* accu_walk_cnt 누적_걸음_수 numeric(null) */
	private Double accuWalkCnt;

	/* gram_no 전문_번호 numeric(null) */
	private Double gramNo;

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
	 * Get evnt_div_cd 이벤트_구분_코드 character varying(20)
	 * @Return String evntDivCd
	 */
	public String getEvntDivCd() {
		return this.evntDivCd;
	}
	
	/**
	 * Set evnt_div_cd 이벤트_구분_코드 character varying(20)
	 * @Param String evntDivCd
	 */
	public void setEvntDivCd(String evntDivCd) {
		this.evntDivCd = evntDivCd;
	}
	/**
	 * Get band_id 밴드_ID character varying(20)
	 * @Return String bandId
	 */
	public String getBandId() {
		return this.bandId;
	}
	
	/**
	 * Set band_id 밴드_ID character varying(20)
	 * @Param String bandId
	 */
	public void setBandId(String bandId) {
		this.bandId = bandId;
	}
	/**
	 * Get judg_dt 판정_일자 character(8)
	 * @Return String judgDt
	 */
	public String getJudgDt() {
		return this.judgDt;
	}
	
	/**
	 * Set judg_dt 판정_일자 character(8)
	 * @Param String judgDt
	 */
	public void setJudgDt(String judgDt) {
		this.judgDt = judgDt;
	}
	/**
	 * Get judg_tm 판정_시각 character(6)
	 * @Return String judgTm
	 */
	public String getJudgTm() {
		return this.judgTm;
	}
	
	/**
	 * Set judg_tm 판정_시각 character(6)
	 * @Param String judgTm
	 */
	public void setJudgTm(String judgTm) {
		this.judgTm = judgTm;
	}
	/**
	 * Get lat_val 위도_값 numeric(null)
	 * @Return Double latVal
	 */
	public Double getLatVal() {
		return this.latVal;
	}
	
	/**
	 * Set lat_val 위도_값 numeric(null)
	 * @Param Double latVal
	 */
	public void setLatVal(Double latVal) {
		this.latVal = latVal;
	}
	/**
	 * Get lon_val 경도_값 numeric(null)
	 * @Return Double lonVal
	 */
	public Double getLonVal() {
		return this.lonVal;
	}
	
	/**
	 * Set lon_val 경도_값 numeric(null)
	 * @Param Double lonVal
	 */
	public void setLonVal(Double lonVal) {
		this.lonVal = lonVal;
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
	 * Get min_hbit_cnt 최소_심박_수 numeric(null)
	 * @Return Double minHbitCnt
	 */
	public Double getMinHbitCnt() {
		return this.minHbitCnt;
	}
	
	/**
	 * Set min_hbit_cnt 최소_심박_수 numeric(null)
	 * @Param Double minHbitCnt
	 */
	public void setMinHbitCnt(Double minHbitCnt) {
		this.minHbitCnt = minHbitCnt;
	}
	/**
	 * Get max_hbit_cnt 최대_심박_수 numeric(null)
	 * @Return Double maxHbitCnt
	 */
	public Double getMaxHbitCnt() {
		return this.maxHbitCnt;
	}
	
	/**
	 * Set max_hbit_cnt 최대_심박_수 numeric(null)
	 * @Param Double maxHbitCnt
	 */
	public void setMaxHbitCnt(Double maxHbitCnt) {
		this.maxHbitCnt = maxHbitCnt;
	}
	/**
	 * Get hbit_mdan 심박_중간값 numeric(null)
	 * @Return Double hbitMdan
	 */
	public Double getHbitMdan() {
		return this.hbitMdan;
	}
	
	/**
	 * Set hbit_mdan 심박_중간값 numeric(null)
	 * @Param Double hbitMdan
	 */
	public void setHbitMdan(Double hbitMdan) {
		this.hbitMdan = hbitMdan;
	}
	/**
	 * Get abnm_hbit_cnt 이상_심박_수 numeric(null)
	 * @Return Double abnmHbitCnt
	 */
	public Double getAbnmHbitCnt() {
		return this.abnmHbitCnt;
	}
	
	/**
	 * Set abnm_hbit_cnt 이상_심박_수 numeric(null)
	 * @Param Double abnmHbitCnt
	 */
	public void setAbnmHbitCnt(Double abnmHbitCnt) {
		this.abnmHbitCnt = abnmHbitCnt;
	}
	/**
	 * Get min1_hbit_cntn 1분_심박_내용 character varying(4000)
	 * @Return String min1HbitCntn
	 */
	public String getMin1HbitCntn() {
		return this.min1HbitCntn;
	}
	
	/**
	 * Set min1_hbit_cntn 1분_심박_내용 character varying(4000)
	 * @Param String min1HbitCntn
	 */
	public void setMin1HbitCntn(String min1HbitCntn) {
		this.min1HbitCntn = min1HbitCntn;
	}
	/**
	 * Get temp_val 체온_값 numeric(null)
	 * @Return Double tempVal
	 */
	public Double getTempVal() {
		return this.tempVal;
	}
	
	/**
	 * Set temp_val 체온_값 numeric(null)
	 * @Param Double tempVal
	 */
	public void setTempVal(Double tempVal) {
		this.tempVal = tempVal;
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
	 * Get cbee_bal 캐시비_잔액 numeric(null)
	 * @Return Double cbeeBal
	 */
	public Double getCbeeBal() {
		return this.cbeeBal;
	}
	
	/**
	 * Set cbee_bal 캐시비_잔액 numeric(null)
	 * @Param Double cbeeBal
	 */
	public void setCbeeBal(Double cbeeBal) {
		this.cbeeBal = cbeeBal;
	}
	/**
	 * Get accu_run_tcnt_cnt 누적_달리기_시간_수 numeric(null)
	 * @Return Double accuRunTcntCnt
	 */
	public Double getAccuRunTcntCnt() {
		return this.accuRunTcntCnt;
	}
	
	/**
	 * Set accu_run_tcnt_cnt 누적_달리기_시간_수 numeric(null)
	 * @Param Double accuRunTcntCnt
	 */
	public void setAccuRunTcntCnt(Double accuRunTcntCnt) {
		this.accuRunTcntCnt = accuRunTcntCnt;
	}
	/**
	 * Get accu_walk_tcnt_cnt 누적_걸음_시간_수 numeric(null)
	 * @Return Double accuWalkTcntCnt
	 */
	public Double getAccuWalkTcntCnt() {
		return this.accuWalkTcntCnt;
	}
	
	/**
	 * Set accu_walk_tcnt_cnt 누적_걸음_시간_수 numeric(null)
	 * @Param Double accuWalkTcntCnt
	 */
	public void setAccuWalkTcntCnt(Double accuWalkTcntCnt) {
		this.accuWalkTcntCnt = accuWalkTcntCnt;
	}
	/**
	 * Get accu_walk_cnt 누적_걸음_수 numeric(null)
	 * @Return Double accuWalkCnt
	 */
	public Double getAccuWalkCnt() {
		return this.accuWalkCnt;
	}
	
	/**
	 * Set accu_walk_cnt 누적_걸음_수 numeric(null)
	 * @Param Double accuWalkCnt
	 */
	public void setAccuWalkCnt(Double accuWalkCnt) {
		this.accuWalkCnt = accuWalkCnt;
	}
	/**
	 * Get gram_no 전문_번호 numeric(null)
	 * @Return Double gramNo
	 */
	public Double getGramNo() {
		return this.gramNo;
	}
	
	/**
	 * Set gram_no 전문_번호 numeric(null)
	 * @Param Double gramNo
	 */
	public void setGramNo(Double gramNo) {
		this.gramNo = gramNo;
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
