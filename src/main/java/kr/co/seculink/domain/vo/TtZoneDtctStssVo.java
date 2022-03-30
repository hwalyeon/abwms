package kr.co.seculink.domain.vo;

import java.io.Serializable;

/**
 * tt_zone_dtct_stss Value Object
 */
public class TtZoneDtctStssVo implements Serializable {

	/* stnd_dt 기준_일자 character(8) */
	private String stndDt;

	/* sex_cd 성별_코드 character varying(20) */
	private String sexCd;

	/* age_ycnt 나이_년수 numeric(null) */
	private double ageYcnt;

	/* loc_apnt_cd 위치_지정_코드 character varying(20) */
	private String locApntCd;

	/* plc_clss_cd 장소_분류_코드 character varying(20) */
	private String plcClssCd;

	/* loc_no 위치_번호 numeric(null) */
	private double locNo;

	/* stnd_yymm 기준_년월 character(6) */
	private String stndYymm;

	/* mnth_week_seq 월별_주차 numeric(null) */
	private double mnthWeekSeq;

	/* week_nm 요일_명 character varying(10) */
	private String weekNm;

	/* occr_cnt 발생_건수 numeric(null) */
	private double occrCnt;

	/* stdt_cnt 학생_수 numeric(null) */
	private double stdtCnt;

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
	 * @Return double ageYcnt
	 */
	public double getAgeYcnt() {
		return this.ageYcnt;
	}
	
	/**
	 * Set age_ycnt 나이_년수 numeric(null)
	 * @Param double ageYcnt
	 */
	public void setAgeYcnt(double ageYcnt) {
		this.ageYcnt = ageYcnt;
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
	 * Get loc_no 위치_번호 numeric(null)
	 * @Return double locNo
	 */
	public double getLocNo() {
		return this.locNo;
	}
	
	/**
	 * Set loc_no 위치_번호 numeric(null)
	 * @Param double locNo
	 */
	public void setLocNo(double locNo) {
		this.locNo = locNo;
	}
	/**
	 * Get stnd_yymm 기준_년월 character(6)
	 * @Return String stndYymm
	 */
	public String getStndYymm() {
		return this.stndYymm;
	}
	
	/**
	 * Set stnd_yymm 기준_년월 character(6)
	 * @Param String stndYymm
	 */
	public void setStndYymm(String stndYymm) {
		this.stndYymm = stndYymm;
	}
	/**
	 * Get mnth_week_seq 월별_주차 numeric(null)
	 * @Return double mnthWeekSeq
	 */
	public double getMnthWeekSeq() {
		return this.mnthWeekSeq;
	}
	
	/**
	 * Set mnth_week_seq 월별_주차 numeric(null)
	 * @Param double mnthWeekSeq
	 */
	public void setMnthWeekSeq(double mnthWeekSeq) {
		this.mnthWeekSeq = mnthWeekSeq;
	}
	/**
	 * Get week_nm 요일_명 character varying(10)
	 * @Return String weekNm
	 */
	public String getWeekNm() {
		return this.weekNm;
	}
	
	/**
	 * Set week_nm 요일_명 character varying(10)
	 * @Param String weekNm
	 */
	public void setWeekNm(String weekNm) {
		this.weekNm = weekNm;
	}
	/**
	 * Get occr_cnt 발생_건수 numeric(null)
	 * @Return double occrCnt
	 */
	public double getOccrCnt() {
		return this.occrCnt;
	}
	
	/**
	 * Set occr_cnt 발생_건수 numeric(null)
	 * @Param double occrCnt
	 */
	public void setOccrCnt(double occrCnt) {
		this.occrCnt = occrCnt;
	}
	/**
	 * Get stdt_cnt 학생_수 numeric(null)
	 * @Return double stdtCnt
	 */
	public double getStdtCnt() {
		return this.stdtCnt;
	}
	
	/**
	 * Set stdt_cnt 학생_수 numeric(null)
	 * @Param double stdtCnt
	 */
	public void setStdtCnt(double stdtCnt) {
		this.stdtCnt = stdtCnt;
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
