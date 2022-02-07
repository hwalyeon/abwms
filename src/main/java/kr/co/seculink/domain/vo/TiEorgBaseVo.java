package kr.co.seculink.domain.vo;

import java.io.Serializable;

/**
 * ti_eorg_base Value Object
 */
public class TiEorgBaseVo implements Serializable {

	/* eorg_no 교육시설_번호 numeric(null) */
	private double eorgNo;

	/* eorg_nm 교육시설_명 character varying(200) */
	private String eorgNm;

	/* eorg_tel_no 교육시설_전화_번호 character varying(20) */
	private String eorgTelNo;

	/* cctv_inst_yn CCTV_설치_여부 character(1) */
	private String cctvInstYn;

	/* cctv_inst_cnt CCTV_설치_대수 numeric(null) */
	private double cctvInstCnt;

	/* morg_nm 관리기관_명 character varying(100) */
	private String morgNm;

	/* morg_tel_no 관리기관_전화_번호 character varying(20) */
	private String morgTelNo;

	/* loc_no 위치_번호 numeric(null) */
	private double locNo;

	/* rmrk 비고 character varying(4000) */
	private String rmrk;

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
	 * Get eorg_no 교육시설_번호 numeric(null)
	 * @Return double eorgNo
	 */
	public double getEorgNo() {
		return this.eorgNo;
	}
	
	/**
	 * Set eorg_no 교육시설_번호 numeric(null)
	 * @Param double eorgNo
	 */
	public void setEorgNo(double eorgNo) {
		this.eorgNo = eorgNo;
	}
	/**
	 * Get eorg_nm 교육시설_명 character varying(200)
	 * @Return String eorgNm
	 */
	public String getEorgNm() {
		return this.eorgNm;
	}
	
	/**
	 * Set eorg_nm 교육시설_명 character varying(200)
	 * @Param String eorgNm
	 */
	public void setEorgNm(String eorgNm) {
		this.eorgNm = eorgNm;
	}
	/**
	 * Get eorg_tel_no 교육시설_전화_번호 character varying(20)
	 * @Return String eorgTelNo
	 */
	public String getEorgTelNo() {
		return this.eorgTelNo;
	}
	
	/**
	 * Set eorg_tel_no 교육시설_전화_번호 character varying(20)
	 * @Param String eorgTelNo
	 */
	public void setEorgTelNo(String eorgTelNo) {
		this.eorgTelNo = eorgTelNo;
	}
	/**
	 * Get cctv_inst_yn CCTV_설치_여부 character(1)
	 * @Return String cctvInstYn
	 */
	public String getCctvInstYn() {
		return this.cctvInstYn;
	}
	
	/**
	 * Set cctv_inst_yn CCTV_설치_여부 character(1)
	 * @Param String cctvInstYn
	 */
	public void setCctvInstYn(String cctvInstYn) {
		this.cctvInstYn = cctvInstYn;
	}
	/**
	 * Get cctv_inst_cnt CCTV_설치_대수 numeric(null)
	 * @Return double cctvInstCnt
	 */
	public double getCctvInstCnt() {
		return this.cctvInstCnt;
	}
	
	/**
	 * Set cctv_inst_cnt CCTV_설치_대수 numeric(null)
	 * @Param double cctvInstCnt
	 */
	public void setCctvInstCnt(double cctvInstCnt) {
		this.cctvInstCnt = cctvInstCnt;
	}
	/**
	 * Get morg_nm 관리기관_명 character varying(100)
	 * @Return String morgNm
	 */
	public String getMorgNm() {
		return this.morgNm;
	}
	
	/**
	 * Set morg_nm 관리기관_명 character varying(100)
	 * @Param String morgNm
	 */
	public void setMorgNm(String morgNm) {
		this.morgNm = morgNm;
	}
	/**
	 * Get morg_tel_no 관리기관_전화_번호 character varying(20)
	 * @Return String morgTelNo
	 */
	public String getMorgTelNo() {
		return this.morgTelNo;
	}
	
	/**
	 * Set morg_tel_no 관리기관_전화_번호 character varying(20)
	 * @Param String morgTelNo
	 */
	public void setMorgTelNo(String morgTelNo) {
		this.morgTelNo = morgTelNo;
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
	 * Get rmrk 비고 character varying(4000)
	 * @Return String rmrk
	 */
	public String getRmrk() {
		return this.rmrk;
	}
	
	/**
	 * Set rmrk 비고 character varying(4000)
	 * @Param String rmrk
	 */
	public void setRmrk(String rmrk) {
		this.rmrk = rmrk;
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
