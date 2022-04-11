package kr.co.seculink.domain.vo;

import java.io.Serializable;

/**
 * ts_loc_info_base Value Object
 */
public class TsLocInfoBaseVo implements Serializable {

	/* loc_no 위치_번호 numeric(null) */
	private Double locNo;

	/* loc_nm 위치_명 character varying(100) */
	private String locNm;

	/* plc_cd 장소_코드 character varying(20) */
	private String plcCd;

	/* plc_clss_cd 장소_분류_코드 character varying(20) */
	private String plcClssCd;

	/* loc_apnt_cd 위치_지정_코드 character varying(20) */
	private String locApntCd;

	/* lat_val 위도_값 numeric(null) */
	private Double latVal;

	/* lon_val 경도_값 numeric(null) */
	private Double lonVal;

	/* vald_rnge_dist 유효_반경_거리 numeric(null) */
	private Double valdRngeDist;

	/* swst_lat_val 남서_위도_값 numeric(null) */
	private Double swstLatVal;

	/* swst_lon_val 남서_경도_값 numeric(null) */
	private Double swstLonVal;

	/* nest_lat_val 북동_위도_값 numeric(null) */
	private Double nestLatVal;

	/* nest_lon_val 북동_경도_값 numeric(null) */
	private Double nestLonVal;

	/* pstno 우편번호 character varying(10) */
	private String pstno;

	/* addr_base 주소_기본 character varying(400) */
	private String addrBase;

	/* addr_spec 주소_상세 character varying(200) */
	private String addrSpec;

	/* del_yn 삭제_여부 character(1) */
	private String delYn;

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
	 * Get loc_no 위치_번호 numeric(null)
	 * @Return Double locNo
	 */
	public Double getLocNo() {
		return this.locNo;
	}
	
	/**
	 * Set loc_no 위치_번호 numeric(null)
	 * @Param Double locNo
	 */
	public void setLocNo(Double locNo) {
		this.locNo = locNo;
	}
	/**
	 * Get loc_nm 위치_명 character varying(100)
	 * @Return String locNm
	 */
	public String getLocNm() {
		return this.locNm;
	}
	
	/**
	 * Set loc_nm 위치_명 character varying(100)
	 * @Param String locNm
	 */
	public void setLocNm(String locNm) {
		this.locNm = locNm;
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
	 * Get loc_apnt_cd 위치_지정_코드 character varying(20)
	 * @Return String locApntCd
	 */
	public String getLocApntCd() {
		return this.locApntCd;
	}
	
	/**
	 * Set loc_apnt_cd 위치_지정_코드 character varying(20)
	 * @Param String locApntCd
	 */
	public void setLocApntCd(String locApntCd) {
		this.locApntCd = locApntCd;
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
	 * Get vald_rnge_dist 유효_반경_거리 numeric(null)
	 * @Return Double valdRngeDist
	 */
	public Double getValdRngeDist() {
		return this.valdRngeDist;
	}
	
	/**
	 * Set vald_rnge_dist 유효_반경_거리 numeric(null)
	 * @Param Double valdRngeDist
	 */
	public void setValdRngeDist(Double valdRngeDist) {
		this.valdRngeDist = valdRngeDist;
	}
	/**
	 * Get swst_lat_val 남서_위도_값 numeric(null)
	 * @Return Double swstLatVal
	 */
	public Double getSwstLatVal() {
		return this.swstLatVal;
	}
	
	/**
	 * Set swst_lat_val 남서_위도_값 numeric(null)
	 * @Param Double swstLatVal
	 */
	public void setSwstLatVal(Double swstLatVal) {
		this.swstLatVal = swstLatVal;
	}
	/**
	 * Get swst_lon_val 남서_경도_값 numeric(null)
	 * @Return Double swstLonVal
	 */
	public Double getSwstLonVal() {
		return this.swstLonVal;
	}
	
	/**
	 * Set swst_lon_val 남서_경도_값 numeric(null)
	 * @Param Double swstLonVal
	 */
	public void setSwstLonVal(Double swstLonVal) {
		this.swstLonVal = swstLonVal;
	}
	/**
	 * Get nest_lat_val 북동_위도_값 numeric(null)
	 * @Return Double nestLatVal
	 */
	public Double getNestLatVal() {
		return this.nestLatVal;
	}
	
	/**
	 * Set nest_lat_val 북동_위도_값 numeric(null)
	 * @Param Double nestLatVal
	 */
	public void setNestLatVal(Double nestLatVal) {
		this.nestLatVal = nestLatVal;
	}
	/**
	 * Get nest_lon_val 북동_경도_값 numeric(null)
	 * @Return Double nestLonVal
	 */
	public Double getNestLonVal() {
		return this.nestLonVal;
	}
	
	/**
	 * Set nest_lon_val 북동_경도_값 numeric(null)
	 * @Param Double nestLonVal
	 */
	public void setNestLonVal(Double nestLonVal) {
		this.nestLonVal = nestLonVal;
	}
	/**
	 * Get pstno 우편번호 character varying(10)
	 * @Return String pstno
	 */
	public String getPstno() {
		return this.pstno;
	}
	
	/**
	 * Set pstno 우편번호 character varying(10)
	 * @Param String pstno
	 */
	public void setPstno(String pstno) {
		this.pstno = pstno;
	}
	/**
	 * Get addr_base 주소_기본 character varying(400)
	 * @Return String addrBase
	 */
	public String getAddrBase() {
		return this.addrBase;
	}
	
	/**
	 * Set addr_base 주소_기본 character varying(400)
	 * @Param String addrBase
	 */
	public void setAddrBase(String addrBase) {
		this.addrBase = addrBase;
	}
	/**
	 * Get addr_spec 주소_상세 character varying(200)
	 * @Return String addrSpec
	 */
	public String getAddrSpec() {
		return this.addrSpec;
	}
	
	/**
	 * Set addr_spec 주소_상세 character varying(200)
	 * @Param String addrSpec
	 */
	public void setAddrSpec(String addrSpec) {
		this.addrSpec = addrSpec;
	}
	/**
	 * Get del_yn 삭제_여부 character(1)
	 * @Return String delYn
	 */
	public String getDelYn() {
		return this.delYn;
	}
	
	/**
	 * Set del_yn 삭제_여부 character(1)
	 * @Param String delYn
	 */
	public void setDelYn(String delYn) {
		this.delYn = delYn;
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
