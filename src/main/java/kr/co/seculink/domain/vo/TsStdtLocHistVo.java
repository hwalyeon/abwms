package kr.co.seculink.domain.vo;

import java.io.Serializable;
import lombok.ToString;
/**
 * ts_stdt_loc_hist Value Object
 */
 @ToString
public class TsStdtLocHistVo implements Serializable {

	/* loc_hist_no 위치_이력_번호 numeric(null) */
	private Double locHistNo;

	/* loc_nm 위치_명 character varying(200) */
	private String locNm;

	/* stdt_no 학생_번호 numeric(null) */
	private Double stdtNo;

	/* occr_dttm 발생_일시 character(14) */
	private String occrDttm;

	/* lat_val 위도_값 numeric(null) */
	private Double latVal;

	/* lon_val 경도_값 numeric(null) */
	private Double lonVal;

	/* plc_cd 장소_코드 character varying(20) */
	private String plcCd;

	/* plc_clss_cd 장소_분류_코드 character varying(20) */
	private String plcClssCd;

	/* near_loc_no 인근_위치_번호 numeric(null) */
	private Double nearLocNo;

	/* enl_div_cd 등하원_구분_코드 character varying(20) */
	private String enlDivCd;

	/* ble_id BLE_ID character varying(40) */
	private String bleId;

	/* loc_alam_no 위치_알림_번호 numeric(null) */
	private Double locAlamNo;

	/* judg_no 판정_번호 numeric(null) */
	private Double judgNo;

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
	 * Get loc_hist_no 위치_이력_번호 numeric(null)
	 * @Return Double locHistNo
	 */
	public Double getLocHistNo() {
		return this.locHistNo;
	}
	
	/**
	 * Set loc_hist_no 위치_이력_번호 numeric(null)
	 * @Param Double locHistNo
	 */
	public void setLocHistNo(Double locHistNo) {
		this.locHistNo = locHistNo;
	}
	/**
	 * Get loc_nm 위치_명 character varying(200)
	 * @Return String locNm
	 */
	public String getLocNm() {
		return this.locNm;
	}
	
	/**
	 * Set loc_nm 위치_명 character varying(200)
	 * @Param String locNm
	 */
	public void setLocNm(String locNm) {
		this.locNm = locNm;
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
	 * Get occr_dttm 발생_일시 character(14)
	 * @Return String occrDttm
	 */
	public String getOccrDttm() {
		return this.occrDttm;
	}
	
	/**
	 * Set occr_dttm 발생_일시 character(14)
	 * @Param String occrDttm
	 */
	public void setOccrDttm(String occrDttm) {
		this.occrDttm = occrDttm;
	}
	/**
	 * Get lat_val 위도_값 numeric(null)
	 * @Return Double latVal
	 */
	public Double getLatVal() {
		return this.latVal;
	}
	
	/**
	 * Set lat_val 위도_값 numeric(null)
	 * @Param Double latVal
	 */
	public void setLatVal(Double latVal) {
		this.latVal = latVal;
	}
	/**
	 * Get lon_val 경도_값 numeric(null)
	 * @Return Double lonVal
	 */
	public Double getLonVal() {
		return this.lonVal;
	}
	
	/**
	 * Set lon_val 경도_값 numeric(null)
	 * @Param Double lonVal
	 */
	public void setLonVal(Double lonVal) {
		this.lonVal = lonVal;
	}
	/**
	 * Get plc_cd 장소_코드 character varying(20)
	 * @Return String plcCd
	 */
	public String getPlcCd() {
		return this.plcCd;
	}
	
	/**
	 * Set plc_cd 장소_코드 character varying(20)
	 * @Param String plcCd
	 */
	public void setPlcCd(String plcCd) {
		this.plcCd = plcCd;
	}
	/**
	 * Get plc_clss_cd 장소_분류_코드 character varying(20)
	 * @Return String plcClssCd
	 */
	public String getPlcClssCd() {
		return this.plcClssCd;
	}
	
	/**
	 * Set plc_clss_cd 장소_분류_코드 character varying(20)
	 * @Param String plcClssCd
	 */
	public void setPlcClssCd(String plcClssCd) {
		this.plcClssCd = plcClssCd;
	}
	/**
	 * Get near_loc_no 인근_위치_번호 numeric(null)
	 * @Return Double nearLocNo
	 */
	public Double getNearLocNo() {
		return this.nearLocNo;
	}
	
	/**
	 * Set near_loc_no 인근_위치_번호 numeric(null)
	 * @Param Double nearLocNo
	 */
	public void setNearLocNo(Double nearLocNo) {
		this.nearLocNo = nearLocNo;
	}
	/**
	 * Get enl_div_cd 등하원_구분_코드 character varying(20)
	 * @Return String enlDivCd
	 */
	public String getEnlDivCd() {
		return this.enlDivCd;
	}
	
	/**
	 * Set enl_div_cd 등하원_구분_코드 character varying(20)
	 * @Param String enlDivCd
	 */
	public void setEnlDivCd(String enlDivCd) {
		this.enlDivCd = enlDivCd;
	}
	/**
	 * Get ble_id BLE_ID character varying(40)
	 * @Return String bleId
	 */
	public String getBleId() {
		return this.bleId;
	}
	
	/**
	 * Set ble_id BLE_ID character varying(40)
	 * @Param String bleId
	 */
	public void setBleId(String bleId) {
		this.bleId = bleId;
	}
	/**
	 * Get loc_alam_no 위치_알림_번호 numeric(null)
	 * @Return Double locAlamNo
	 */
	public Double getLocAlamNo() {
		return this.locAlamNo;
	}
	
	/**
	 * Set loc_alam_no 위치_알림_번호 numeric(null)
	 * @Param Double locAlamNo
	 */
	public void setLocAlamNo(Double locAlamNo) {
		this.locAlamNo = locAlamNo;
	}
	/**
	 * Get judg_no 판정_번호 numeric(null)
	 * @Return Double judgNo
	 */
	public Double getJudgNo() {
		return this.judgNo;
	}
	
	/**
	 * Set judg_no 판정_번호 numeric(null)
	 * @Param Double judgNo
	 */
	public void setJudgNo(Double judgNo) {
		this.judgNo = judgNo;
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
