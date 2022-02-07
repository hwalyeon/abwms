package kr.co.seculink.domain.vo;

import java.io.Serializable;

/**
 * ti_dgem_stnd Value Object
 */
public class TiDgemStndVo implements Serializable {

	/* dgem_stat_cd 위험감정_상태_코드 character varying(20) */
	private String dgemStatCd;

	/* dgem_stat_cntn 위험감정_상태_내용 text(null) */
	private String dgemStatCntn;

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
	 * Get dgem_stat_cd 위험감정_상태_코드 character varying(20)
	 * @Return String dgemStatCd
	 */
	public String getDgemStatCd() {
		return this.dgemStatCd;
	}
	
	/**
	 * Set dgem_stat_cd 위험감정_상태_코드 character varying(20)
	 * @Param String dgemStatCd
	 */
	public void setDgemStatCd(String dgemStatCd) {
		this.dgemStatCd = dgemStatCd;
	}
	/**
	 * Get dgem_stat_cntn 위험감정_상태_내용 text(null)
	 * @Return String dgemStatCntn
	 */
	public String getDgemStatCntn() {
		return this.dgemStatCntn;
	}
	
	/**
	 * Set dgem_stat_cntn 위험감정_상태_내용 text(null)
	 * @Param String dgemStatCntn
	 */
	public void setDgemStatCntn(String dgemStatCntn) {
		this.dgemStatCntn = dgemStatCntn;
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
