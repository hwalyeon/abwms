package kr.co.seculink.domain.vo;

import java.io.Serializable;
import lombok.ToString;
/**
 * ti_temp_stat_stnd Value Object
 */
 @ToString
public class TiTempStatStndVo implements Serializable {

	/* age_ycnt 나이_년수 numeric(null) */
	private Double ageYcnt;

	/* temp_val_fr 체온_값_FROM numeric(null) */
	private Double tempValFr;

	/* temp_val_to 체온_값_TO numeric(null) */
	private Double tempValTo;

	/* temp_stat_cd 체온_상태_코드 character varying(20) */
	private String tempStatCd;

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
	 * Get temp_val_fr 체온_값_FROM numeric(null)
	 * @Return Double tempValFr
	 */
	public Double getTempValFr() {
		return this.tempValFr;
	}
	
	/**
	 * Set temp_val_fr 체온_값_FROM numeric(null)
	 * @Param Double tempValFr
	 */
	public void setTempValFr(Double tempValFr) {
		this.tempValFr = tempValFr;
	}
	/**
	 * Get temp_val_to 체온_값_TO numeric(null)
	 * @Return Double tempValTo
	 */
	public Double getTempValTo() {
		return this.tempValTo;
	}
	
	/**
	 * Set temp_val_to 체온_값_TO numeric(null)
	 * @Param Double tempValTo
	 */
	public void setTempValTo(Double tempValTo) {
		this.tempValTo = tempValTo;
	}
	/**
	 * Get temp_stat_cd 체온_상태_코드 character varying(20)
	 * @Return String tempStatCd
	 */
	public String getTempStatCd() {
		return this.tempStatCd;
	}
	
	/**
	 * Set temp_stat_cd 체온_상태_코드 character varying(20)
	 * @Param String tempStatCd
	 */
	public void setTempStatCd(String tempStatCd) {
		this.tempStatCd = tempStatCd;
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
