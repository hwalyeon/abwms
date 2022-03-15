package kr.co.seculink.domain.vo;

import java.io.Serializable;

/**
 * ts_dd_hbit_temp Value Object
 */
public class TsDdHbitTempVo implements Serializable {

	/* stdt_no 학생_번호 numeric(null) */
	private double stdtNo;

	/* stnd_dt 기준_일자 character(8) */
	private String stndDt;

	/* bot_blck_val 최하위_구간_값 numeric(null) */
	private double botBlckVal;

	/* down_blck_val 하위_구간_값 numeric(null) */
	private double downBlckVal;

	/* uppr_blck_val 상위_구간_값 numeric(null) */
	private double upprBlckVal;

	/* top_blck_val 최상위_구간_값 numeric(null) */
	private double topBlckVal;


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
	 * Get bot_blck_val 최하위_구간_값 numeric(null)
	 * @Return double botBlckVal
	 */
	public double getBotBlckVal() {
		return this.botBlckVal;
	}
	
	/**
	 * Set bot_blck_val 최하위_구간_값 numeric(null)
	 * @Param double botBlckVal
	 */
	public void setBotBlckVal(double botBlckVal) {
		this.botBlckVal = botBlckVal;
	}
	/**
	 * Get down_blck_val 하위_구간_값 numeric(null)
	 * @Return double downBlckVal
	 */
	public double getDownBlckVal() {
		return this.downBlckVal;
	}
	
	/**
	 * Set down_blck_val 하위_구간_값 numeric(null)
	 * @Param double downBlckVal
	 */
	public void setDownBlckVal(double downBlckVal) {
		this.downBlckVal = downBlckVal;
	}
	/**
	 * Get uppr_blck_val 상위_구간_값 numeric(null)
	 * @Return double upprBlckVal
	 */
	public double getUpprBlckVal() {
		return this.upprBlckVal;
	}
	
	/**
	 * Set uppr_blck_val 상위_구간_값 numeric(null)
	 * @Param double upprBlckVal
	 */
	public void setUpprBlckVal(double upprBlckVal) {
		this.upprBlckVal = upprBlckVal;
	}
	/**
	 * Get top_blck_val 최상위_구간_값 numeric(null)
	 * @Return double topBlckVal
	 */
	public double getTopBlckVal() {
		return this.topBlckVal;
	}
	
	/**
	 * Set top_blck_val 최상위_구간_값 numeric(null)
	 * @Param double topBlckVal
	 */
	public void setTopBlckVal(double topBlckVal) {
		this.topBlckVal = topBlckVal;
	}

} // end of class
