package kr.co.seculink.domain.vo;

import java.io.Serializable;

/**
 * ti_fat_stnd Value Object
 */
public class TiFatStndVo implements Serializable {

	/* fat_stnd_ver 비만_기준_버전 character varying(500) */
	private String fatStndVer;

	/* fat_stnd_no 비만_기준_번호 numeric(null) */
	private Double fatStndNo;

	/* sex_cd 성별_코드 character varying(20) */
	private String sexCd;

	/* age_ycnt 나이_년수 numeric(null) */
	private Double ageYcnt;

	/* age_mcnt 나이_개월수 numeric(null) */
	private Double ageMcnt;

	/* p5_fidx 백분위5_비만지수 numeric(null) */
	private Double p5Fidx;

	/* p50_fidx 백분위50_비만지수 numeric(null) */
	private Double p50Fidx;

	/* p95_fidx 백분위95_비만지수 numeric(null) */
	private Double p95Fidx;

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
	 * Get fat_stnd_ver 비만_기준_버전 character varying(500)
	 * @Return String fatStndVer
	 */
	public String getFatStndVer() {
		return this.fatStndVer;
	}
	
	/**
	 * Set fat_stnd_ver 비만_기준_버전 character varying(500)
	 * @Param String fatStndVer
	 */
	public void setFatStndVer(String fatStndVer) {
		this.fatStndVer = fatStndVer;
	}
	/**
	 * Get fat_stnd_no 비만_기준_번호 numeric(null)
	 * @Return Double fatStndNo
	 */
	public Double getFatStndNo() {
		return this.fatStndNo;
	}
	
	/**
	 * Set fat_stnd_no 비만_기준_번호 numeric(null)
	 * @Param Double fatStndNo
	 */
	public void setFatStndNo(Double fatStndNo) {
		this.fatStndNo = fatStndNo;
	}
	/**
	 * Get sex_cd 성별_코드 character varying(20)
	 * @Return String sexCd
	 */
	public String getSexCd() {
		return this.sexCd;
	}
	
	/**
	 * Set sex_cd 성별_코드 character varying(20)
	 * @Param String sexCd
	 */
	public void setSexCd(String sexCd) {
		this.sexCd = sexCd;
	}
	/**
	 * Get age_ycnt 나이_년수 numeric(null)
	 * @Return Double ageYcnt
	 */
	public Double getAgeYcnt() {
		return this.ageYcnt;
	}
	
	/**
	 * Set age_ycnt 나이_년수 numeric(null)
	 * @Param Double ageYcnt
	 */
	public void setAgeYcnt(Double ageYcnt) {
		this.ageYcnt = ageYcnt;
	}
	/**
	 * Get age_mcnt 나이_개월수 numeric(null)
	 * @Return Double ageMcnt
	 */
	public Double getAgeMcnt() {
		return this.ageMcnt;
	}
	
	/**
	 * Set age_mcnt 나이_개월수 numeric(null)
	 * @Param Double ageMcnt
	 */
	public void setAgeMcnt(Double ageMcnt) {
		this.ageMcnt = ageMcnt;
	}
	/**
	 * Get p5_fidx 백분위5_비만지수 numeric(null)
	 * @Return Double p5Fidx
	 */
	public Double getP5Fidx() {
		return this.p5Fidx;
	}
	
	/**
	 * Set p5_fidx 백분위5_비만지수 numeric(null)
	 * @Param Double p5Fidx
	 */
	public void setP5Fidx(Double p5Fidx) {
		this.p5Fidx = p5Fidx;
	}
	/**
	 * Get p50_fidx 백분위50_비만지수 numeric(null)
	 * @Return Double p50Fidx
	 */
	public Double getP50Fidx() {
		return this.p50Fidx;
	}
	
	/**
	 * Set p50_fidx 백분위50_비만지수 numeric(null)
	 * @Param Double p50Fidx
	 */
	public void setP50Fidx(Double p50Fidx) {
		this.p50Fidx = p50Fidx;
	}
	/**
	 * Get p95_fidx 백분위95_비만지수 numeric(null)
	 * @Return Double p95Fidx
	 */
	public Double getP95Fidx() {
		return this.p95Fidx;
	}
	
	/**
	 * Set p95_fidx 백분위95_비만지수 numeric(null)
	 * @Param Double p95Fidx
	 */
	public void setP95Fidx(Double p95Fidx) {
		this.p95Fidx = p95Fidx;
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
