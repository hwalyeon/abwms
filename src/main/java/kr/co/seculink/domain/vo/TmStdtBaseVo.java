package kr.co.seculink.domain.vo;

import java.io.Serializable;

/**
 * tm_stdt_base Value Object
 */
public class TmStdtBaseVo implements Serializable {

	/* stdt_no 학생_번호 numeric(null) */
	private double stdtNo;

	/* stdt_nm 학생_명 character varying(20) */
	private String stdtNm;

	/* guar_no 보호자_번호 numeric(null) */
	private double guarNo;

	/* schl_eorg_no 학교_교육시설_번호 numeric(null) */
	private double schlEorgNo;

	/* band_id 밴드_ID character varying(40) */
	private String bandId;

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

	/* grow_hist_seq 성장_기록_순번 numeric(null) */
	private double growHistSeq;

	/* dact_judg_no 위험활동_판정_번호 numeric(null) */
	private double dactJudgNo;

	/* dgem_hist_seq 위험감정_이력_순번 character(18) */
	private String dgemHistSeq;

	/* strs_hist_seq 스트레스_이력_순번 numeric(null) */
	private double strsHistSeq;

	/* loc_hist_no 위치_이력_번호 character(18) */
	private String locHistNo;

	/* cbee_hist_no 캐시비_이력_번호 character(18) */
	private String cbeeHistNo;

	/* gfix_dt 성장비만지수_일자 numeric(null) */
	private double gfixDt;

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
	 * Get stdt_nm 학생_명 character varying(20)
	 * @Return String stdtNm
	 */
	public String getStdtNm() {
		return this.stdtNm;
	}
	
	/**
	 * Set stdt_nm 학생_명 character varying(20)
	 * @Param String stdtNm
	 */
	public void setStdtNm(String stdtNm) {
		this.stdtNm = stdtNm;
	}
	/**
	 * Get guar_no 보호자_번호 numeric(null)
	 * @Return double guarNo
	 */
	public double getGuarNo() {
		return this.guarNo;
	}
	
	/**
	 * Set guar_no 보호자_번호 numeric(null)
	 * @Param double guarNo
	 */
	public void setGuarNo(double guarNo) {
		this.guarNo = guarNo;
	}
	/**
	 * Get schl_eorg_no 학교_교육시설_번호 numeric(null)
	 * @Return double schlEorgNo
	 */
	public double getSchlEorgNo() {
		return this.schlEorgNo;
	}
	
	/**
	 * Set schl_eorg_no 학교_교육시설_번호 numeric(null)
	 * @Param double schlEorgNo
	 */
	public void setSchlEorgNo(double schlEorgNo) {
		this.schlEorgNo = schlEorgNo;
	}
	/**
	 * Get band_id 밴드_ID character varying(40)
	 * @Return String bandId
	 */
	public String getBandId() {
		return this.bandId;
	}
	
	/**
	 * Set band_id 밴드_ID character varying(40)
	 * @Param String bandId
	 */
	public void setBandId(String bandId) {
		this.bandId = bandId;
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
	 * Get grow_hist_seq 성장_기록_순번 numeric(null)
	 * @Return double growHistSeq
	 */
	public double getGrowHistSeq() {
		return this.growHistSeq;
	}
	
	/**
	 * Set grow_hist_seq 성장_기록_순번 numeric(null)
	 * @Param double growHistSeq
	 */
	public void setGrowHistSeq(double growHistSeq) {
		this.growHistSeq = growHistSeq;
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
	 * Get dgem_hist_seq 위험감정_이력_순번 character(18)
	 * @Return String dgemHistSeq
	 */
	public String getDgemHistSeq() {
		return this.dgemHistSeq;
	}
	
	/**
	 * Set dgem_hist_seq 위험감정_이력_순번 character(18)
	 * @Param String dgemHistSeq
	 */
	public void setDgemHistSeq(String dgemHistSeq) {
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
	 * Get loc_hist_no 위치_이력_번호 character(18)
	 * @Return String locHistNo
	 */
	public String getLocHistNo() {
		return this.locHistNo;
	}
	
	/**
	 * Set loc_hist_no 위치_이력_번호 character(18)
	 * @Param String locHistNo
	 */
	public void setLocHistNo(String locHistNo) {
		this.locHistNo = locHistNo;
	}
	/**
	 * Get cbee_hist_no 캐시비_이력_번호 character(18)
	 * @Return String cbeeHistNo
	 */
	public String getCbeeHistNo() {
		return this.cbeeHistNo;
	}
	
	/**
	 * Set cbee_hist_no 캐시비_이력_번호 character(18)
	 * @Param String cbeeHistNo
	 */
	public void setCbeeHistNo(String cbeeHistNo) {
		this.cbeeHistNo = cbeeHistNo;
	}
	/**
	 * Get gfix_dt 성장비만지수_일자 numeric(null)
	 * @Return double gfixDt
	 */
	public double getGfixDt() {
		return this.gfixDt;
	}
	
	/**
	 * Set gfix_dt 성장비만지수_일자 numeric(null)
	 * @Param double gfixDt
	 */
	public void setGfixDt(double gfixDt) {
		this.gfixDt = gfixDt;
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
