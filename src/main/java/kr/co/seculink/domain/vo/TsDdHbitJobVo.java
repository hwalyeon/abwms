package kr.co.seculink.domain.vo;

import java.io.Serializable;
import lombok.ToString;
/**
 * ts_dd_hbit_job Value Object
 */
 @ToString
public class TsDdHbitJobVo implements Serializable {

	/* stdt_no 학생_번호 numeric(null) */
	private Double stdtNo;

	/* stnd_dt 기준_일자 character(8) */
	private String stndDt;

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

} // end of class
