package kr.co.seculink.domain.vo;

import java.io.Serializable;

/**
 * ts_dd_hbit_temp Value Object
 */
public class TsDdHbitTempVo implements Serializable {

	/* stdt_no 학생_번호 numeric(null) */
	private Double stdtNo;

	/* stnd_dt 기준_일자 character(8) */
	private String stndDt;

	/* bot_blck_val 최하위_구간_값 numeric(null) */
	private Double botBlckVal;

	/* down_blck_val 하위_구간_값 numeric(null) */
	private Double downBlckVal;

	/* uppr_blck_val 상위_구간_값 numeric(null) */
	private Double upprBlckVal;

	/* top_blck_val 최상위_구간_값 numeric(null) */
	private Double topBlckVal;


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

} // end of class
