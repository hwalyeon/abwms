package kr.co.seculink.domain.vo;

import java.io.Serializable;

/**
 * ts_dd_hbit_hist Value Object
 */
public class TsDdHbitHistVo implements Serializable {

	/* stdt_no 학생_번호 numeric(null) */
	private Double stdtNo;

	/* stnd_dt 기준_일자 character(8) */
	private String stndDt;

	/* mesu_cnt 측정_건수 numeric(null) */
	private Double mesuCnt;

	/* max_hbit_cnt 최대_심박_수 numeric(null) */
	private Double maxHbitCnt;

	/* min_hbit_cnt 최소_심박_수 numeric(null) */
	private Double minHbitCnt;

	/* hbit_mdan 심박_중간값 numeric(null) */
	private Double hbitMdan;

	/* vald_yn 유효_여부 character(1) */
	private String valdYn;

	/* accu_avg_val 누적_평균_값 numeric(null) */
	private Double accuAvgVal;

	/* accu_sdev_val 누적_표준편차_값 numeric(null) */
	private Double accuSdevVal;

	/* down_stnd_val 하위_기준_값 numeric(null) */
	private Double downStndVal;

	/* uppr_stnd_val 상위_기준_값 numeric(null) */
	private Double upprStndVal;

	/* bot_blck_val 최하위_구간_값 numeric(null) */
	private Double botBlckVal;

	/* down_blck_val 하위_구간_값 numeric(null) */
	private Double downBlckVal;

	/* uppr_blck_val 상위_구간_값 numeric(null) */
	private Double upprBlckVal;

	/* top_blck_val 최상위_구간_값 numeric(null) */
	private Double topBlckVal;

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
	 * Get mesu_cnt 측정_건수 numeric(null)
	 * @Return Double mesuCnt
	 */
	public Double getMesuCnt() {
		return this.mesuCnt;
	}
	
	/**
	 * Set mesu_cnt 측정_건수 numeric(null)
	 * @Param Double mesuCnt
	 */
	public void setMesuCnt(Double mesuCnt) {
		this.mesuCnt = mesuCnt;
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
	 * Get vald_yn 유효_여부 character(1)
	 * @Return String valdYn
	 */
	public String getValdYn() {
		return this.valdYn;
	}
	
	/**
	 * Set vald_yn 유효_여부 character(1)
	 * @Param String valdYn
	 */
	public void setValdYn(String valdYn) {
		this.valdYn = valdYn;
	}
	/**
	 * Get accu_avg_val 누적_평균_값 numeric(null)
	 * @Return Double accuAvgVal
	 */
	public Double getAccuAvgVal() {
		return this.accuAvgVal;
	}
	
	/**
	 * Set accu_avg_val 누적_평균_값 numeric(null)
	 * @Param Double accuAvgVal
	 */
	public void setAccuAvgVal(Double accuAvgVal) {
		this.accuAvgVal = accuAvgVal;
	}
	/**
	 * Get accu_sdev_val 누적_표준편차_값 numeric(null)
	 * @Return Double accuSdevVal
	 */
	public Double getAccuSdevVal() {
		return this.accuSdevVal;
	}
	
	/**
	 * Set accu_sdev_val 누적_표준편차_값 numeric(null)
	 * @Param Double accuSdevVal
	 */
	public void setAccuSdevVal(Double accuSdevVal) {
		this.accuSdevVal = accuSdevVal;
	}
	/**
	 * Get down_stnd_val 하위_기준_값 numeric(null)
	 * @Return Double downStndVal
	 */
	public Double getDownStndVal() {
		return this.downStndVal;
	}
	
	/**
	 * Set down_stnd_val 하위_기준_값 numeric(null)
	 * @Param Double downStndVal
	 */
	public void setDownStndVal(Double downStndVal) {
		this.downStndVal = downStndVal;
	}
	/**
	 * Get uppr_stnd_val 상위_기준_값 numeric(null)
	 * @Return Double upprStndVal
	 */
	public Double getUpprStndVal() {
		return this.upprStndVal;
	}
	
	/**
	 * Set uppr_stnd_val 상위_기준_값 numeric(null)
	 * @Param Double upprStndVal
	 */
	public void setUpprStndVal(Double upprStndVal) {
		this.upprStndVal = upprStndVal;
	}
	/**
	 * Get bot_blck_val 최하위_구간_값 numeric(null)
	 * @Return Double botBlckVal
	 */
	public Double getBotBlckVal() {
		return this.botBlckVal;
	}
	
	/**
	 * Set bot_blck_val 최하위_구간_값 numeric(null)
	 * @Param Double botBlckVal
	 */
	public void setBotBlckVal(Double botBlckVal) {
		this.botBlckVal = botBlckVal;
	}
	/**
	 * Get down_blck_val 하위_구간_값 numeric(null)
	 * @Return Double downBlckVal
	 */
	public Double getDownBlckVal() {
		return this.downBlckVal;
	}
	
	/**
	 * Set down_blck_val 하위_구간_값 numeric(null)
	 * @Param Double downBlckVal
	 */
	public void setDownBlckVal(Double downBlckVal) {
		this.downBlckVal = downBlckVal;
	}
	/**
	 * Get uppr_blck_val 상위_구간_값 numeric(null)
	 * @Return Double upprBlckVal
	 */
	public Double getUpprBlckVal() {
		return this.upprBlckVal;
	}
	
	/**
	 * Set uppr_blck_val 상위_구간_값 numeric(null)
	 * @Param Double upprBlckVal
	 */
	public void setUpprBlckVal(Double upprBlckVal) {
		this.upprBlckVal = upprBlckVal;
	}
	/**
	 * Get top_blck_val 최상위_구간_값 numeric(null)
	 * @Return Double topBlckVal
	 */
	public Double getTopBlckVal() {
		return this.topBlckVal;
	}
	
	/**
	 * Set top_blck_val 최상위_구간_값 numeric(null)
	 * @Param Double topBlckVal
	 */
	public void setTopBlckVal(Double topBlckVal) {
		this.topBlckVal = topBlckVal;
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
