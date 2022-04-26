package kr.co.seculink.domain.vo;

import java.io.Serializable;
import lombok.ToString;
/**
 * tc_cd_spec Value Object
 */
 @ToString
public class TcCdSpecVo implements Serializable {

	/* cd_grp 코드_그룹 character varying(40) */
	private String cdGrp;

	/* cd_val 코드_값 character varying(40) */
	private String cdVal;

	/* cd_nm 코드_명 character varying(100) */
	private String cdNm;

	/* cd_desc 코드_설명 character varying(2000) */
	private String cdDesc;

	/* fltr_val_1 필터_값_1 character varying(50) */
	private String fltrVal1;

	/* fltr_val_2 필터_값_2 character varying(50) */
	private String fltrVal2;

	/* fltr_val_3 필터_값_3 character varying(50) */
	private String fltrVal3;

	/* sort_ord 정렬_순서 numeric(null) */
	private Double sortOrd;

	/* use_yn 사용_여부 character(1) */
	private String useYn;

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
	 * Get cd_grp 코드_그룹 character varying(40)
	 * @Return String cdGrp
	 */
	public String getCdGrp() {
		return this.cdGrp;
	}
	
	/**
	 * Set cd_grp 코드_그룹 character varying(40)
	 * @Param String cdGrp
	 */
	public void setCdGrp(String cdGrp) {
		this.cdGrp = cdGrp;
	}
	/**
	 * Get cd_val 코드_값 character varying(40)
	 * @Return String cdVal
	 */
	public String getCdVal() {
		return this.cdVal;
	}
	
	/**
	 * Set cd_val 코드_값 character varying(40)
	 * @Param String cdVal
	 */
	public void setCdVal(String cdVal) {
		this.cdVal = cdVal;
	}
	/**
	 * Get cd_nm 코드_명 character varying(100)
	 * @Return String cdNm
	 */
	public String getCdNm() {
		return this.cdNm;
	}
	
	/**
	 * Set cd_nm 코드_명 character varying(100)
	 * @Param String cdNm
	 */
	public void setCdNm(String cdNm) {
		this.cdNm = cdNm;
	}
	/**
	 * Get cd_desc 코드_설명 character varying(2000)
	 * @Return String cdDesc
	 */
	public String getCdDesc() {
		return this.cdDesc;
	}
	
	/**
	 * Set cd_desc 코드_설명 character varying(2000)
	 * @Param String cdDesc
	 */
	public void setCdDesc(String cdDesc) {
		this.cdDesc = cdDesc;
	}
	/**
	 * Get fltr_val_1 필터_값_1 character varying(50)
	 * @Return String fltrVal1
	 */
	public String getFltrVal1() {
		return this.fltrVal1;
	}
	
	/**
	 * Set fltr_val_1 필터_값_1 character varying(50)
	 * @Param String fltrVal1
	 */
	public void setFltrVal1(String fltrVal1) {
		this.fltrVal1 = fltrVal1;
	}
	/**
	 * Get fltr_val_2 필터_값_2 character varying(50)
	 * @Return String fltrVal2
	 */
	public String getFltrVal2() {
		return this.fltrVal2;
	}
	
	/**
	 * Set fltr_val_2 필터_값_2 character varying(50)
	 * @Param String fltrVal2
	 */
	public void setFltrVal2(String fltrVal2) {
		this.fltrVal2 = fltrVal2;
	}
	/**
	 * Get fltr_val_3 필터_값_3 character varying(50)
	 * @Return String fltrVal3
	 */
	public String getFltrVal3() {
		return this.fltrVal3;
	}
	
	/**
	 * Set fltr_val_3 필터_값_3 character varying(50)
	 * @Param String fltrVal3
	 */
	public void setFltrVal3(String fltrVal3) {
		this.fltrVal3 = fltrVal3;
	}
	/**
	 * Get sort_ord 정렬_순서 numeric(null)
	 * @Return Double sortOrd
	 */
	public Double getSortOrd() {
		return this.sortOrd;
	}
	
	/**
	 * Set sort_ord 정렬_순서 numeric(null)
	 * @Param Double sortOrd
	 */
	public void setSortOrd(Double sortOrd) {
		this.sortOrd = sortOrd;
	}
	/**
	 * Get use_yn 사용_여부 character(1)
	 * @Return String useYn
	 */
	public String getUseYn() {
		return this.useYn;
	}
	
	/**
	 * Set use_yn 사용_여부 character(1)
	 * @Param String useYn
	 */
	public void setUseYn(String useYn) {
		this.useYn = useYn;
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
