package kr.co.seculink.domain.vo;

import java.io.Serializable;

/**
 * tm_stdt_base Value Object
 */
public class TmStdtBaseVo implements Serializable {

	/* stdt_no 학생_번호 numeric(null) */
	private double stdtNo;

	/* stdt_nm 학생_명 character varying(40) */
	private String stdtNm;

	/* band_id 밴드_ID character varying(20) */
	private String bandId;

	/* eorg_loc_no 교육시설_위치_번호 numeric(null) */
	private double eorgLocNo;

	/* sgrd_cd 학년_코드 character varying(20) */
	private String sgrdCd;

	/* sex_cd 성별_코드 character varying(20) */
	private String sexCd;

	/* bith_dt 생일_일자 character(8) */
	private String bithDt;

	/* race_div_cd 인종_구분_코드 character varying(20) */
	private String raceDivCd;

	/* band_stat_cd 밴드_상태_코드 character varying(20) */
	private String bandStatCd;

	/* band_comm_dttm 밴드_통신_일시 character(14) */
	private String bandCommDttm;

	/* band_chrg_qty 밴드_충전_량 numeric(null) */
	private double bandChrgQty;

	/* band_alam_no 밴드_알림_번호 numeric(null) */
	private double bandAlamNo;

	/* judg_no 판정_번호 numeric(null) */
	private double judgNo;

	/* dact_judg_no 위험활동_판정_번호 numeric(null) */
	private double dactJudgNo;

	/* dgem_hist_seq 위험감정_이력_순번 numeric(null) */
	private double dgemHistSeq;

	/* strs_hist_seq 스트레스_이력_순번 numeric(null) */
	private double strsHistSeq;

	/* loc_hist_no 위치_이력_번호 numeric(null) */
	private double locHistNo;

	/* cbee_hist_no 캐시비_이력_번호 numeric(null) */
	private double cbeeHistNo;

	/* gfix_dt 성장비만지수_일자 character(8) */
	private String gfixDt;

	/* grow_mesu_dt 성장_측정_일자 character(8) */
	private String growMesuDt;

	/* ambr_yn 미아_여부 character(1) */
	private String ambrYn;

	/* ambr_dtct_dttm 미아_탐지_일시 character(14) */
	private String ambrDtctDttm;

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
	 * Get stdt_no 학생_번호 numeric(null)
	 * @Return double stdtNo
	 */
	public double getStdtNo() {
		return this.stdtNo;
	}
	
	/**
	 * Set stdt_no 학생_번호 numeric(null)
	 * @Param double stdtNo
	 */
	public void setStdtNo(double stdtNo) {
		this.stdtNo = stdtNo;
	}
	/**
	 * Get stdt_nm 학생_명 character varying(40)
	 * @Return String stdtNm
	 */
	public String getStdtNm() {
		return this.stdtNm;
	}
	
	/**
	 * Set stdt_nm 학생_명 character varying(40)
	 * @Param String stdtNm
	 */
	public void setStdtNm(String stdtNm) {
		this.stdtNm = stdtNm;
	}
	/**
	 * Get band_id 밴드_ID character varying(20)
	 * @Return String bandId
	 */
	public String getBandId() {
		return this.bandId;
	}
	
	/**
	 * Set band_id 밴드_ID character varying(20)
	 * @Param String bandId
	 */
	public void setBandId(String bandId) {
		this.bandId = bandId;
	}
	/**
	 * Get eorg_loc_no 교육시설_위치_번호 numeric(null)
	 * @Return double eorgLocNo
	 */
	public double getEorgLocNo() {
		return this.eorgLocNo;
	}
	
	/**
	 * Set eorg_loc_no 교육시설_위치_번호 numeric(null)
	 * @Param double eorgLocNo
	 */
	public void setEorgLocNo(double eorgLocNo) {
		this.eorgLocNo = eorgLocNo;
	}
	/**
	 * Get sgrd_cd 학년_코드 character varying(20)
	 * @Return String sgrdCd
	 */
	public String getSgrdCd() {
		return this.sgrdCd;
	}
	
	/**
	 * Set sgrd_cd 학년_코드 character varying(20)
	 * @Param String sgrdCd
	 */
	public void setSgrdCd(String sgrdCd) {
		this.sgrdCd = sgrdCd;
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
	 * Get bith_dt 생일_일자 character(8)
	 * @Return String bithDt
	 */
	public String getBithDt() {
		return this.bithDt;
	}
	
	/**
	 * Set bith_dt 생일_일자 character(8)
	 * @Param String bithDt
	 */
	public void setBithDt(String bithDt) {
		this.bithDt = bithDt;
	}
	/**
	 * Get race_div_cd 인종_구분_코드 character varying(20)
	 * @Return String raceDivCd
	 */
	public String getRaceDivCd() {
		return this.raceDivCd;
	}
	
	/**
	 * Set race_div_cd 인종_구분_코드 character varying(20)
	 * @Param String raceDivCd
	 */
	public void setRaceDivCd(String raceDivCd) {
		this.raceDivCd = raceDivCd;
	}
	/**
	 * Get band_stat_cd 밴드_상태_코드 character varying(20)
	 * @Return String bandStatCd
	 */
	public String getBandStatCd() {
		return this.bandStatCd;
	}
	
	/**
	 * Set band_stat_cd 밴드_상태_코드 character varying(20)
	 * @Param String bandStatCd
	 */
	public void setBandStatCd(String bandStatCd) {
		this.bandStatCd = bandStatCd;
	}
	/**
	 * Get band_comm_dttm 밴드_통신_일시 character(14)
	 * @Return String bandCommDttm
	 */
	public String getBandCommDttm() {
		return this.bandCommDttm;
	}
	
	/**
	 * Set band_comm_dttm 밴드_통신_일시 character(14)
	 * @Param String bandCommDttm
	 */
	public void setBandCommDttm(String bandCommDttm) {
		this.bandCommDttm = bandCommDttm;
	}
	/**
	 * Get band_chrg_qty 밴드_충전_량 numeric(null)
	 * @Return double bandChrgQty
	 */
	public double getBandChrgQty() {
		return this.bandChrgQty;
	}
	
	/**
	 * Set band_chrg_qty 밴드_충전_량 numeric(null)
	 * @Param double bandChrgQty
	 */
	public void setBandChrgQty(double bandChrgQty) {
		this.bandChrgQty = bandChrgQty;
	}
	/**
	 * Get band_alam_no 밴드_알림_번호 numeric(null)
	 * @Return double bandAlamNo
	 */
	public double getBandAlamNo() {
		return this.bandAlamNo;
	}
	
	/**
	 * Set band_alam_no 밴드_알림_번호 numeric(null)
	 * @Param double bandAlamNo
	 */
	public void setBandAlamNo(double bandAlamNo) {
		this.bandAlamNo = bandAlamNo;
	}
	/**
	 * Get judg_no 판정_번호 numeric(null)
	 * @Return double judgNo
	 */
	public double getJudgNo() {
		return this.judgNo;
	}
	
	/**
	 * Set judg_no 판정_번호 numeric(null)
	 * @Param double judgNo
	 */
	public void setJudgNo(double judgNo) {
		this.judgNo = judgNo;
	}
	/**
	 * Get dact_judg_no 위험활동_판정_번호 numeric(null)
	 * @Return double dactJudgNo
	 */
	public double getDactJudgNo() {
		return this.dactJudgNo;
	}
	
	/**
	 * Set dact_judg_no 위험활동_판정_번호 numeric(null)
	 * @Param double dactJudgNo
	 */
	public void setDactJudgNo(double dactJudgNo) {
		this.dactJudgNo = dactJudgNo;
	}
	/**
	 * Get dgem_hist_seq 위험감정_이력_순번 numeric(null)
	 * @Return double dgemHistSeq
	 */
	public double getDgemHistSeq() {
		return this.dgemHistSeq;
	}
	
	/**
	 * Set dgem_hist_seq 위험감정_이력_순번 numeric(null)
	 * @Param double dgemHistSeq
	 */
	public void setDgemHistSeq(double dgemHistSeq) {
		this.dgemHistSeq = dgemHistSeq;
	}
	/**
	 * Get strs_hist_seq 스트레스_이력_순번 numeric(null)
	 * @Return double strsHistSeq
	 */
	public double getStrsHistSeq() {
		return this.strsHistSeq;
	}
	
	/**
	 * Set strs_hist_seq 스트레스_이력_순번 numeric(null)
	 * @Param double strsHistSeq
	 */
	public void setStrsHistSeq(double strsHistSeq) {
		this.strsHistSeq = strsHistSeq;
	}
	/**
	 * Get loc_hist_no 위치_이력_번호 numeric(null)
	 * @Return double locHistNo
	 */
	public double getLocHistNo() {
		return this.locHistNo;
	}
	
	/**
	 * Set loc_hist_no 위치_이력_번호 numeric(null)
	 * @Param double locHistNo
	 */
	public void setLocHistNo(double locHistNo) {
		this.locHistNo = locHistNo;
	}
	/**
	 * Get cbee_hist_no 캐시비_이력_번호 numeric(null)
	 * @Return double cbeeHistNo
	 */
	public double getCbeeHistNo() {
		return this.cbeeHistNo;
	}
	
	/**
	 * Set cbee_hist_no 캐시비_이력_번호 numeric(null)
	 * @Param double cbeeHistNo
	 */
	public void setCbeeHistNo(double cbeeHistNo) {
		this.cbeeHistNo = cbeeHistNo;
	}
	/**
	 * Get gfix_dt 성장비만지수_일자 character(8)
	 * @Return String gfixDt
	 */
	public String getGfixDt() {
		return this.gfixDt;
	}
	
	/**
	 * Set gfix_dt 성장비만지수_일자 character(8)
	 * @Param String gfixDt
	 */
	public void setGfixDt(String gfixDt) {
		this.gfixDt = gfixDt;
	}
	/**
	 * Get grow_mesu_dt 성장_측정_일자 character(8)
	 * @Return String growMesuDt
	 */
	public String getGrowMesuDt() {
		return this.growMesuDt;
	}
	
	/**
	 * Set grow_mesu_dt 성장_측정_일자 character(8)
	 * @Param String growMesuDt
	 */
	public void setGrowMesuDt(String growMesuDt) {
		this.growMesuDt = growMesuDt;
	}
	/**
	 * Get ambr_yn 미아_여부 character(1)
	 * @Return String ambrYn
	 */
	public String getAmbrYn() {
		return this.ambrYn;
	}
	
	/**
	 * Set ambr_yn 미아_여부 character(1)
	 * @Param String ambrYn
	 */
	public void setAmbrYn(String ambrYn) {
		this.ambrYn = ambrYn;
	}
	/**
	 * Get ambr_dtct_dttm 미아_탐지_일시 character(14)
	 * @Return String ambrDtctDttm
	 */
	public String getAmbrDtctDttm() {
		return this.ambrDtctDttm;
	}
	
	/**
	 * Set ambr_dtct_dttm 미아_탐지_일시 character(14)
	 * @Param String ambrDtctDttm
	 */
	public void setAmbrDtctDttm(String ambrDtctDttm) {
		this.ambrDtctDttm = ambrDtctDttm;
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
