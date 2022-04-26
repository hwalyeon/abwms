package kr.co.seculink.domain.vo;

import java.io.Serializable;
import lombok.ToString;
/**
 * tm_stdt_base Value Object
 */
 @ToString
public class TmStdtBaseVo implements Serializable {

	/* stdt_no 학생_번호 numeric(null) */
	private Double stdtNo;

	/* stdt_nm 학생_명 character varying(256) */
	private String stdtNm;

	/* band_id 밴드_ID character varying(20) */
	private String bandId;

	/* eorg_loc_no 교육시설_위치_번호 numeric(null) */
	private Double eorgLocNo;

	/* sgrd_cd 학년_코드 character varying(20) */
	private String sgrdCd;

	/* sex_cd 성별_코드 character varying(20) */
	private String sexCd;

	/* bith_dt 생일_일자 character(8) */
	private String bithDt;

	/* race_div_cd 인종_구분_코드 character varying(20) */
	private String raceDivCd;

	/* prnt_no 학부모_번호 numeric(null) */
	private Double prntNo;

	/* band_stat_cd 밴드_상태_코드 character varying(20) */
	private String bandStatCd;

	/* band_comm_dttm 밴드_통신_일시 character(14) */
	private String bandCommDttm;

	/* band_chrg_qty 밴드_충전_량 numeric(null) */
	private Double bandChrgQty;

	/* band_alam_no 밴드_알림_번호 numeric(null) */
	private Double bandAlamNo;

	/* judg_no 판정_번호 numeric(null) */
	private Double judgNo;

	/* dact_judg_no 위험활동_판정_번호 numeric(null) */
	private Double dactJudgNo;

	/* dgem_hist_seq 위험감정_이력_순번 numeric(null) */
	private Double dgemHistSeq;

	/* strs_hist_seq 스트레스_이력_순번 numeric(null) */
	private Double strsHistSeq;

	/* loc_hist_no 위치_이력_번호 numeric(null) */
	private Double locHistNo;

	/* cbee_hist_no 캐시비_이력_번호 numeric(null) */
	private Double cbeeHistNo;

	/* gfix_dt 성장비만지수_일자 character(8) */
	private String gfixDt;

	/* grow_mesu_dt 성장_측정_일자 character(8) */
	private String growMesuDt;

	/* act_stnd_dt 활동_기준_일자 character(8) */
	private String actStndDt;

	/* qust_stnd_dt 설문_기준_일자 character(8) */
	private String qustStndDt;

	/* ambr_yn 미아_여부 character(1) */
	private String ambrYn;

	/* ambr_dtct_dttm 미아_탐지_일시 character(14) */
	private String ambrDtctDttm;

	/* del_dt 삭제_일자 character(8) */
	private String delDt;

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
	 * Get stdt_nm 학생_명 character varying(256)
	 * @Return String stdtNm
	 */
	public String getStdtNm() {
		return this.stdtNm;
	}
	
	/**
	 * Set stdt_nm 학생_명 character varying(256)
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
	 * @Return Double eorgLocNo
	 */
	public Double getEorgLocNo() {
		return this.eorgLocNo;
	}
	
	/**
	 * Set eorg_loc_no 교육시설_위치_번호 numeric(null)
	 * @Param Double eorgLocNo
	 */
	public void setEorgLocNo(Double eorgLocNo) {
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
	 * Get prnt_no 학부모_번호 numeric(null)
	 * @Return Double prntNo
	 */
	public Double getPrntNo() {
		return this.prntNo;
	}
	
	/**
	 * Set prnt_no 학부모_번호 numeric(null)
	 * @Param Double prntNo
	 */
	public void setPrntNo(Double prntNo) {
		this.prntNo = prntNo;
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
	 * @Return Double bandChrgQty
	 */
	public Double getBandChrgQty() {
		return this.bandChrgQty;
	}
	
	/**
	 * Set band_chrg_qty 밴드_충전_량 numeric(null)
	 * @Param Double bandChrgQty
	 */
	public void setBandChrgQty(Double bandChrgQty) {
		this.bandChrgQty = bandChrgQty;
	}
	/**
	 * Get band_alam_no 밴드_알림_번호 numeric(null)
	 * @Return Double bandAlamNo
	 */
	public Double getBandAlamNo() {
		return this.bandAlamNo;
	}
	
	/**
	 * Set band_alam_no 밴드_알림_번호 numeric(null)
	 * @Param Double bandAlamNo
	 */
	public void setBandAlamNo(Double bandAlamNo) {
		this.bandAlamNo = bandAlamNo;
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
	 * Get dact_judg_no 위험활동_판정_번호 numeric(null)
	 * @Return Double dactJudgNo
	 */
	public Double getDactJudgNo() {
		return this.dactJudgNo;
	}
	
	/**
	 * Set dact_judg_no 위험활동_판정_번호 numeric(null)
	 * @Param Double dactJudgNo
	 */
	public void setDactJudgNo(Double dactJudgNo) {
		this.dactJudgNo = dactJudgNo;
	}
	/**
	 * Get dgem_hist_seq 위험감정_이력_순번 numeric(null)
	 * @Return Double dgemHistSeq
	 */
	public Double getDgemHistSeq() {
		return this.dgemHistSeq;
	}
	
	/**
	 * Set dgem_hist_seq 위험감정_이력_순번 numeric(null)
	 * @Param Double dgemHistSeq
	 */
	public void setDgemHistSeq(Double dgemHistSeq) {
		this.dgemHistSeq = dgemHistSeq;
	}
	/**
	 * Get strs_hist_seq 스트레스_이력_순번 numeric(null)
	 * @Return Double strsHistSeq
	 */
	public Double getStrsHistSeq() {
		return this.strsHistSeq;
	}
	
	/**
	 * Set strs_hist_seq 스트레스_이력_순번 numeric(null)
	 * @Param Double strsHistSeq
	 */
	public void setStrsHistSeq(Double strsHistSeq) {
		this.strsHistSeq = strsHistSeq;
	}
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
	 * Get cbee_hist_no 캐시비_이력_번호 numeric(null)
	 * @Return Double cbeeHistNo
	 */
	public Double getCbeeHistNo() {
		return this.cbeeHistNo;
	}
	
	/**
	 * Set cbee_hist_no 캐시비_이력_번호 numeric(null)
	 * @Param Double cbeeHistNo
	 */
	public void setCbeeHistNo(Double cbeeHistNo) {
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
	 * Get act_stnd_dt 활동_기준_일자 character(8)
	 * @Return String actStndDt
	 */
	public String getActStndDt() {
		return this.actStndDt;
	}
	
	/**
	 * Set act_stnd_dt 활동_기준_일자 character(8)
	 * @Param String actStndDt
	 */
	public void setActStndDt(String actStndDt) {
		this.actStndDt = actStndDt;
	}
	/**
	 * Get qust_stnd_dt 설문_기준_일자 character(8)
	 * @Return String qustStndDt
	 */
	public String getQustStndDt() {
		return this.qustStndDt;
	}
	
	/**
	 * Set qust_stnd_dt 설문_기준_일자 character(8)
	 * @Param String qustStndDt
	 */
	public void setQustStndDt(String qustStndDt) {
		this.qustStndDt = qustStndDt;
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
	 * Get del_dt 삭제_일자 character(8)
	 * @Return String delDt
	 */
	public String getDelDt() {
		return this.delDt;
	}
	
	/**
	 * Set del_dt 삭제_일자 character(8)
	 * @Param String delDt
	 */
	public void setDelDt(String delDt) {
		this.delDt = delDt;
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
