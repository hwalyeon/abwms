package kr.co.seculink.domain.vo;

import java.io.Serializable;
import lombok.ToString;
/**
 * ts_stdt_grow_hist Value Object
 */
 @ToString
public class TsStdtGrowHistVo implements Serializable {

	/* stdt_no 학생_번호 numeric(null) */
	private Double stdtNo;

	/* mesu_dt 측정_일자 character(8) */
	private String mesuDt;

	/* hght_unit_cd 키_단위_코드 character varying(20) */
	private String hghtUnitCd;

	/* hght_val 키_값 numeric(null) */
	private Double hghtVal;

	/* wght_unit_cd 체중_단위_코드 character varying(20) */
	private String wghtUnitCd;

	/* wght_val 체중_값 numeric(null) */
	private Double wghtVal;

	/* wast_unit_cd 허리_단위_코드 character varying(20) */
	private String wastUnitCd;

	/* wast_val 허리_값 numeric(null) */
	private Double wastVal;

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
	 * Get mesu_dt 측정_일자 character(8)
	 * @Return String mesuDt
	 */
	public String getMesuDt() {
		return this.mesuDt;
	}
	
	/**
	 * Set mesu_dt 측정_일자 character(8)
	 * @Param String mesuDt
	 */
	public void setMesuDt(String mesuDt) {
		this.mesuDt = mesuDt;
	}
	/**
	 * Get hght_unit_cd 키_단위_코드 character varying(20)
	 * @Return String hghtUnitCd
	 */
	public String getHghtUnitCd() {
		return this.hghtUnitCd;
	}
	
	/**
	 * Set hght_unit_cd 키_단위_코드 character varying(20)
	 * @Param String hghtUnitCd
	 */
	public void setHghtUnitCd(String hghtUnitCd) {
		this.hghtUnitCd = hghtUnitCd;
	}
	/**
	 * Get hght_val 키_값 numeric(null)
	 * @Return Double hghtVal
	 */
	public Double getHghtVal() {
		return this.hghtVal;
	}
	
	/**
	 * Set hght_val 키_값 numeric(null)
	 * @Param Double hghtVal
	 */
	public void setHghtVal(Double hghtVal) {
		this.hghtVal = hghtVal;
	}
	/**
	 * Get wght_unit_cd 체중_단위_코드 character varying(20)
	 * @Return String wghtUnitCd
	 */
	public String getWghtUnitCd() {
		return this.wghtUnitCd;
	}
	
	/**
	 * Set wght_unit_cd 체중_단위_코드 character varying(20)
	 * @Param String wghtUnitCd
	 */
	public void setWghtUnitCd(String wghtUnitCd) {
		this.wghtUnitCd = wghtUnitCd;
	}
	/**
	 * Get wght_val 체중_값 numeric(null)
	 * @Return Double wghtVal
	 */
	public Double getWghtVal() {
		return this.wghtVal;
	}
	
	/**
	 * Set wght_val 체중_값 numeric(null)
	 * @Param Double wghtVal
	 */
	public void setWghtVal(Double wghtVal) {
		this.wghtVal = wghtVal;
	}
	/**
	 * Get wast_unit_cd 허리_단위_코드 character varying(20)
	 * @Return String wastUnitCd
	 */
	public String getWastUnitCd() {
		return this.wastUnitCd;
	}
	
	/**
	 * Set wast_unit_cd 허리_단위_코드 character varying(20)
	 * @Param String wastUnitCd
	 */
	public void setWastUnitCd(String wastUnitCd) {
		this.wastUnitCd = wastUnitCd;
	}
	/**
	 * Get wast_val 허리_값 numeric(null)
	 * @Return Double wastVal
	 */
	public Double getWastVal() {
		return this.wastVal;
	}
	
	/**
	 * Set wast_val 허리_값 numeric(null)
	 * @Param Double wastVal
	 */
	public void setWastVal(Double wastVal) {
		this.wastVal = wastVal;
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
