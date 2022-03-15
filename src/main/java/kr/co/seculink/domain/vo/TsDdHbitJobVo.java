package kr.co.seculink.domain.vo;

import java.io.Serializable;

/**
 * ts_dd_hbit_job Value Object
 */
public class TsDdHbitJobVo implements Serializable {

	/* stdt_no 학생_번호 numeric(null) */
	private double stdtNo;

	/* stnd_dt 기준_일자 character(8) */
	private String stndDt;

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

} // end of class
