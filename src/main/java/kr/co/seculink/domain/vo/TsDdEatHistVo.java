package kr.co.seculink.domain.vo;

import java.io.Serializable;
import lombok.ToString;
/**
 * ts_dd_eat_hist Value Object
 */
 @ToString
public class TsDdEatHistVo implements Serializable {

	/* stnd_dt 기준_일자 character(8) */
	private String stndDt;

	/* stdt_no 학생_번호 numeric(null) */
	private Double stdtNo;

	/* eat_seq 섭취_순번 numeric(null) */
	private Double eatSeq;

	/* guar_no 보호자_번호 numeric(null) */
	private Double guarNo;

	/* fmenu_seq 식단표_순번 numeric(null) */
	private Double fmenuSeq;

	/* etim_div_cd 식때_구분_코드 character(18) */
	private String etimDivCd;

	/* eat_qty 섭취_용량 numeric(null) */
	private Double eatQty;

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
	 * Get eat_seq 섭취_순번 numeric(null)
	 * @Return Double eatSeq
	 */
	public Double getEatSeq() {
		return this.eatSeq;
	}
	
	/**
	 * Set eat_seq 섭취_순번 numeric(null)
	 * @Param Double eatSeq
	 */
	public void setEatSeq(Double eatSeq) {
		this.eatSeq = eatSeq;
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
	 * Get fmenu_seq 식단표_순번 numeric(null)
	 * @Return Double fmenuSeq
	 */
	public Double getFmenuSeq() {
		return this.fmenuSeq;
	}
	
	/**
	 * Set fmenu_seq 식단표_순번 numeric(null)
	 * @Param Double fmenuSeq
	 */
	public void setFmenuSeq(Double fmenuSeq) {
		this.fmenuSeq = fmenuSeq;
	}
	/**
	 * Get etim_div_cd 식때_구분_코드 character(18)
	 * @Return String etimDivCd
	 */
	public String getEtimDivCd() {
		return this.etimDivCd;
	}
	
	/**
	 * Set etim_div_cd 식때_구분_코드 character(18)
	 * @Param String etimDivCd
	 */
	public void setEtimDivCd(String etimDivCd) {
		this.etimDivCd = etimDivCd;
	}
	/**
	 * Get eat_qty 섭취_용량 numeric(null)
	 * @Return Double eatQty
	 */
	public Double getEatQty() {
		return this.eatQty;
	}
	
	/**
	 * Set eat_qty 섭취_용량 numeric(null)
	 * @Param Double eatQty
	 */
	public void setEatQty(Double eatQty) {
		this.eatQty = eatQty;
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
