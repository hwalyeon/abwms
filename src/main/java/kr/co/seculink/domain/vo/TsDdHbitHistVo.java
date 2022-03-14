package kr.co.seculink.domain.vo;

import java.io.Serializable;

/**
 * ts_dd_hbit_hist Value Object
 */
public class TsDdHbitHistVo implements Serializable {

	/* stdt_no 학생_번호 numeric(null) */
	private double stdtNo;

	/* stnd_dt 기준_일자 character(8) */
	private String stndDt;

	/* mesu_cnt 측정_건수 numeric(null) */
	private double mesuCnt;

	/* max_hbit_cnt 최대_심박_수 numeric(null) */
	private double maxHbitCnt;

	/* min_hbit_cnt 최소_심박_수 numeric(null) */
	private double minHbitCnt;

	/* hbit_mdan 심박_중간값 numeric(null) */
	private double hbitMdan;

	/* vald_yn 유효_여부 character(1) */
	private String valdYn;

	/* accu_avg_val 누적_평균_값 numeric(null) */
	private double accuAvgVal;

	/* accu_sdev_val 누적_표준편차_값 numeric(null) */
	private double accuSdevVal;

	/* down_stnd_val 하위_기준_값 numeric(null) */
	private double downStndVal;

	/* uppr_stnd_val 상위_기준_값 numeric(null) */
	private double upprStndVal;

	/* bot_blck_val 최하위_구간_값 character(18) */
	private String botBlckVal;

	/* down_blck_val 하위_구간_값 character(18) */
	private String downBlckVal;

	/* uppr_blck_val 상위_구간_값 character(18) */
	private String upprBlckVal;

	/* top_blck_val 최상위_구간_값 character(18) */
	private String topBlckVal;

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
	 * @Return double mesuCnt
	 */
	public double getMesuCnt() {
		return this.mesuCnt;
	}
	
	/**
	 * Set mesu_cnt 측정_건수 numeric(null)
	 * @Param double mesuCnt
	 */
	public void setMesuCnt(double mesuCnt) {
		this.mesuCnt = mesuCnt;
	}
	/**
	 * Get max_hbit_cnt 최대_심박_수 numeric(null)
	 * @Return double maxHbitCnt
	 */
	public double getMaxHbitCnt() {
		return this.maxHbitCnt;
	}
	
	/**
	 * Set max_hbit_cnt 최대_심박_수 numeric(null)
	 * @Param double maxHbitCnt
	 */
	public void setMaxHbitCnt(double maxHbitCnt) {
		this.maxHbitCnt = maxHbitCnt;
	}
	/**
	 * Get min_hbit_cnt 최소_심박_수 numeric(null)
	 * @Return double minHbitCnt
	 */
	public double getMinHbitCnt() {
		return this.minHbitCnt;
	}
	
	/**
	 * Set min_hbit_cnt 최소_심박_수 numeric(null)
	 * @Param double minHbitCnt
	 */
	public void setMinHbitCnt(double minHbitCnt) {
		this.minHbitCnt = minHbitCnt;
	}
	/**
	 * Get hbit_mdan 심박_중간값 numeric(null)
	 * @Return double hbitMdan
	 */
	public double getHbitMdan() {
		return this.hbitMdan;
	}
	
	/**
	 * Set hbit_mdan 심박_중간값 numeric(null)
	 * @Param double hbitMdan
	 */
	public void setHbitMdan(double hbitMdan) {
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
	 * @Return double accuAvgVal
	 */
	public double getAccuAvgVal() {
		return this.accuAvgVal;
	}
	
	/**
	 * Set accu_avg_val 누적_평균_값 numeric(null)
	 * @Param double accuAvgVal
	 */
	public void setAccuAvgVal(double accuAvgVal) {
		this.accuAvgVal = accuAvgVal;
	}
	/**
	 * Get accu_sdev_val 누적_표준편차_값 numeric(null)
	 * @Return double accuSdevVal
	 */
	public double getAccuSdevVal() {
		return this.accuSdevVal;
	}
	
	/**
	 * Set accu_sdev_val 누적_표준편차_값 numeric(null)
	 * @Param double accuSdevVal
	 */
	public void setAccuSdevVal(double accuSdevVal) {
		this.accuSdevVal = accuSdevVal;
	}
	/**
	 * Get down_stnd_val 하위_기준_값 numeric(null)
	 * @Return double downStndVal
	 */
	public double getDownStndVal() {
		return this.downStndVal;
	}
	
	/**
	 * Set down_stnd_val 하위_기준_값 numeric(null)
	 * @Param double downStndVal
	 */
	public void setDownStndVal(double downStndVal) {
		this.downStndVal = downStndVal;
	}
	/**
	 * Get uppr_stnd_val 상위_기준_값 numeric(null)
	 * @Return double upprStndVal
	 */
	public double getUpprStndVal() {
		return this.upprStndVal;
	}
	
	/**
	 * Set uppr_stnd_val 상위_기준_값 numeric(null)
	 * @Param double upprStndVal
	 */
	public void setUpprStndVal(double upprStndVal) {
		this.upprStndVal = upprStndVal;
	}
	/**
	 * Get bot_blck_val 최하위_구간_값 character(18)
	 * @Return String botBlckVal
	 */
	public String getBotBlckVal() {
		return this.botBlckVal;
	}
	
	/**
	 * Set bot_blck_val 최하위_구간_값 character(18)
	 * @Param String botBlckVal
	 */
	public void setBotBlckVal(String botBlckVal) {
		this.botBlckVal = botBlckVal;
	}
	/**
	 * Get down_blck_val 하위_구간_값 character(18)
	 * @Return String downBlckVal
	 */
	public String getDownBlckVal() {
		return this.downBlckVal;
	}
	
	/**
	 * Set down_blck_val 하위_구간_값 character(18)
	 * @Param String downBlckVal
	 */
	public void setDownBlckVal(String downBlckVal) {
		this.downBlckVal = downBlckVal;
	}
	/**
	 * Get uppr_blck_val 상위_구간_값 character(18)
	 * @Return String upprBlckVal
	 */
	public String getUpprBlckVal() {
		return this.upprBlckVal;
	}
	
	/**
	 * Set uppr_blck_val 상위_구간_값 character(18)
	 * @Param String upprBlckVal
	 */
	public void setUpprBlckVal(String upprBlckVal) {
		this.upprBlckVal = upprBlckVal;
	}
	/**
	 * Get top_blck_val 최상위_구간_값 character(18)
	 * @Return String topBlckVal
	 */
	public String getTopBlckVal() {
		return this.topBlckVal;
	}
	
	/**
	 * Set top_blck_val 최상위_구간_값 character(18)
	 * @Param String topBlckVal
	 */
	public void setTopBlckVal(String topBlckVal) {
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
