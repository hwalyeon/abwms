package kr.co.seculink.domain.vo;

import java.io.Serializable;
import lombok.ToString;
/**
 * ts_cert_detl Value Object
 */
 @ToString
public class TsCertDetlVo implements Serializable {

	/* cert_seq 인증_순번 numeric(null) */
	private Double certSeq;

	/* gen_dttm 생성_일시 character(14) */
	private String genDttm;

	/* cert_no 인증_번호 character varying(10) */
	private String certNo;

	/* guar_no 보호자_번호 numeric(null) */
	private Double guarNo;

	/* alam_no 알림_번호 numeric(null) */
	private Double alamNo;

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
	 * Get cert_seq 인증_순번 numeric(null)
	 * @Return Double certSeq
	 */
	public Double getCertSeq() {
		return this.certSeq;
	}
	
	/**
	 * Set cert_seq 인증_순번 numeric(null)
	 * @Param Double certSeq
	 */
	public void setCertSeq(Double certSeq) {
		this.certSeq = certSeq;
	}
	/**
	 * Get gen_dttm 생성_일시 character(14)
	 * @Return String genDttm
	 */
	public String getGenDttm() {
		return this.genDttm;
	}
	
	/**
	 * Set gen_dttm 생성_일시 character(14)
	 * @Param String genDttm
	 */
	public void setGenDttm(String genDttm) {
		this.genDttm = genDttm;
	}
	/**
	 * Get cert_no 인증_번호 character varying(10)
	 * @Return String certNo
	 */
	public String getCertNo() {
		return this.certNo;
	}
	
	/**
	 * Set cert_no 인증_번호 character varying(10)
	 * @Param String certNo
	 */
	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}
	/**
	 * Get guar_no 보호자_번호 numeric(null)
	 * @Return Double guarNo
	 */
	public Double getGuarNo() {
		return this.guarNo;
	}
	
	/**
	 * Set guar_no 보호자_번호 numeric(null)
	 * @Param Double guarNo
	 */
	public void setGuarNo(Double guarNo) {
		this.guarNo = guarNo;
	}
	/**
	 * Get alam_no 알림_번호 numeric(null)
	 * @Return Double alamNo
	 */
	public Double getAlamNo() {
		return this.alamNo;
	}
	
	/**
	 * Set alam_no 알림_번호 numeric(null)
	 * @Param Double alamNo
	 */
	public void setAlamNo(Double alamNo) {
		this.alamNo = alamNo;
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
