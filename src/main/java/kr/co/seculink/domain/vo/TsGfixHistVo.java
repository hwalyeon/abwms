package kr.co.seculink.domain.vo;

import java.io.Serializable;
import lombok.ToString;
/**
 * ts_gfix_hist Value Object
 */
 @ToString
public class TsGfixHistVo implements Serializable {

	/* stdt_no 학생_번호 numeric(null) */
	private Double stdtNo;

	/* gfix_dt 성장비만지수_일자 character(8) */
	private String gfixDt;

	/* sex_cd 성별_코드 character varying(20) */
	private String sexCd;

	/* age_ycnt 나이_년수 numeric(null) */
	private Double ageYcnt;

	/* age_mcnt 나이_개월수 numeric(null) */
	private Double ageMcnt;

	/* hght_val 키_값 numeric(null) */
	private Double hghtVal;

	/* wght_val 몸무게_값 numeric(null) */
	private Double wghtVal;

	/* bmi_val BMI_값 numeric(null) */
	private Double bmiVal;

	/* wast_size 허리_사이즈 numeric(null) */
	private Double wastSize;

	/* cal_eat_qty 칼로리_섭취_량 numeric(null) */
	private Double calEatQty;

	/* cal_csum_qty 칼로리_소모_량 numeric(null) */
	private Double calCsumQty;

	/* mom_hght_val 엄마_키_값 numeric(null) */
	private Double momHghtVal;

	/* mom_wght_val 엄마_몸무게_값 numeric(null) */
	private Double momWghtVal;

	/* mom_bmi_val 엄마_BMI_값 numeric(null) */
	private Double momBmiVal;

	/* dad_hght_val 아빠_키_값 numeric(null) */
	private Double dadHghtVal;

	/* dad_wght_val 아빠_몸무게_값 numeric(null) */
	private Double dadWghtVal;

	/* dad_bmi_val 아빠_BMI_값 numeric(null) */
	private Double dadBmiVal;

	/* grow_stnd_ver 성장_기준_버전 character varying(20) */
	private String growStndVer;

	/* grow_stnd_no 성장_기준_번호 numeric(null) */
	private Double growStndNo;

	/* gidx 성장지수 numeric(null) */
	private Double gidx;

	/* grow_judg_cd 성장_판정_코드 character varying(20) */
	private String growJudgCd;

	/* grow_judg_desc 성장_판정_설명 character varying(4000) */
	private String growJudgDesc;

	/* grow_prdt_idx 성장_예측_지수 numeric(null) */
	private Double growPrdtIdx;

	/* grow_prdt_cd 성장_예측_코드 character varying(20) */
	private String growPrdtCd;

	/* grow_prdt_desc 성장_예측_설명 character varying(4000) */
	private String growPrdtDesc;

	/* unit_gidx 단위_성장지수 numeric(null) */
	private Double unitGidx;

	/* unit_grow_judg_cd 단위_성장_판정_코드 character varying(20) */
	private String unitGrowJudgCd;

	/* fat_stnd_ver 비만_기준_버전 character varying(20) */
	private String fatStndVer;

	/* fat_stnd_no 비만_기준_번호 numeric(null) */
	private Double fatStndNo;

	/* nutr_eat_qty 영양소_섭취_량 numeric(null) */
	private Double nutrEatQty;

	/* fidx 비만지수 numeric(null) */
	private Double fidx;

	/* fat_judg_cd 비만_판정_코드 character varying(20) */
	private String fatJudgCd;

	/* fat_judg_desc 비만_판정_설명 character varying(4000) */
	private String fatJudgDesc;

	/* unit_fidx 단위_비만지수 numeric(null) */
	private Double unitFidx;

	/* unit_fat_judg_cd 단위_비만_판정_코드 character varying(20) */
	private String unitFatJudgCd;

	/* fatp_qust_stnd_dt 비만예측_설문_기준_일자 character(8) */
	private String fatpQustStndDt;

	/* fatp_bmi_val 비만예측_BMI_값 numeric(null) */
	private Double fatpBmiVal;

	/* fatp_idx 비만예측_지수 numeric(null) */
	private Double fatpIdx;

	/* fatp_judg_cd 비만예측_판정_코드 character varying(20) */
	private String fatpJudgCd;

	/* fatp_judg_desc 비만예측_판정_설명 character varying(4000) */
	private String fatpJudgDesc;

	/* pal_val 신체활동수준_값 numeric(null) */
	private Double palVal;

	/* bcsm_val 기초에너지소모량_값 numeric(null) */
	private Double bcsmVal;

	/* acsm_val 활동에너지소모량_값 numeric(null) */
	private Double acsmVal;

	/* pal_cd 신체활동수준_코드 character varying(20) */
	private String palCd;

	/* cal_nutr_stat_cd 칼로리_영양섭취_상태_코드 character varying(20) */
	private String calNutrStatCd;

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
	 * @Return Double ageYcnt
	 */
	public Double getAgeYcnt() {
		return this.ageYcnt;
	}
	
	/**
	 * Set age_ycnt 나이_년수 numeric(null)
	 * @Param Double ageYcnt
	 */
	public void setAgeYcnt(Double ageYcnt) {
		this.ageYcnt = ageYcnt;
	}
	/**
	 * Get age_mcnt 나이_개월수 numeric(null)
	 * @Return Double ageMcnt
	 */
	public Double getAgeMcnt() {
		return this.ageMcnt;
	}
	
	/**
	 * Set age_mcnt 나이_개월수 numeric(null)
	 * @Param Double ageMcnt
	 */
	public void setAgeMcnt(Double ageMcnt) {
		this.ageMcnt = ageMcnt;
	}
	/**
	 * Get hght_val 키_값 numeric(null)
	 * @Return Double hghtVal
	 */
	public Double getHghtVal() {
		return this.hghtVal;
	}
	
	/**
	 * Set hght_val 키_값 numeric(null)
	 * @Param Double hghtVal
	 */
	public void setHghtVal(Double hghtVal) {
		this.hghtVal = hghtVal;
	}
	/**
	 * Get wght_val 몸무게_값 numeric(null)
	 * @Return Double wghtVal
	 */
	public Double getWghtVal() {
		return this.wghtVal;
	}
	
	/**
	 * Set wght_val 몸무게_값 numeric(null)
	 * @Param Double wghtVal
	 */
	public void setWghtVal(Double wghtVal) {
		this.wghtVal = wghtVal;
	}
	/**
	 * Get bmi_val BMI_값 numeric(null)
	 * @Return Double bmiVal
	 */
	public Double getBmiVal() {
		return this.bmiVal;
	}
	
	/**
	 * Set bmi_val BMI_값 numeric(null)
	 * @Param Double bmiVal
	 */
	public void setBmiVal(Double bmiVal) {
		this.bmiVal = bmiVal;
	}
	/**
	 * Get wast_size 허리_사이즈 numeric(null)
	 * @Return Double wastSize
	 */
	public Double getWastSize() {
		return this.wastSize;
	}
	
	/**
	 * Set wast_size 허리_사이즈 numeric(null)
	 * @Param Double wastSize
	 */
	public void setWastSize(Double wastSize) {
		this.wastSize = wastSize;
	}
	/**
	 * Get cal_eat_qty 칼로리_섭취_량 numeric(null)
	 * @Return Double calEatQty
	 */
	public Double getCalEatQty() {
		return this.calEatQty;
	}
	
	/**
	 * Set cal_eat_qty 칼로리_섭취_량 numeric(null)
	 * @Param Double calEatQty
	 */
	public void setCalEatQty(Double calEatQty) {
		this.calEatQty = calEatQty;
	}
	/**
	 * Get cal_csum_qty 칼로리_소모_량 numeric(null)
	 * @Return Double calCsumQty
	 */
	public Double getCalCsumQty() {
		return this.calCsumQty;
	}
	
	/**
	 * Set cal_csum_qty 칼로리_소모_량 numeric(null)
	 * @Param Double calCsumQty
	 */
	public void setCalCsumQty(Double calCsumQty) {
		this.calCsumQty = calCsumQty;
	}
	/**
	 * Get mom_hght_val 엄마_키_값 numeric(null)
	 * @Return Double momHghtVal
	 */
	public Double getMomHghtVal() {
		return this.momHghtVal;
	}
	
	/**
	 * Set mom_hght_val 엄마_키_값 numeric(null)
	 * @Param Double momHghtVal
	 */
	public void setMomHghtVal(Double momHghtVal) {
		this.momHghtVal = momHghtVal;
	}
	/**
	 * Get mom_wght_val 엄마_몸무게_값 numeric(null)
	 * @Return Double momWghtVal
	 */
	public Double getMomWghtVal() {
		return this.momWghtVal;
	}
	
	/**
	 * Set mom_wght_val 엄마_몸무게_값 numeric(null)
	 * @Param Double momWghtVal
	 */
	public void setMomWghtVal(Double momWghtVal) {
		this.momWghtVal = momWghtVal;
	}
	/**
	 * Get mom_bmi_val 엄마_BMI_값 numeric(null)
	 * @Return Double momBmiVal
	 */
	public Double getMomBmiVal() {
		return this.momBmiVal;
	}
	
	/**
	 * Set mom_bmi_val 엄마_BMI_값 numeric(null)
	 * @Param Double momBmiVal
	 */
	public void setMomBmiVal(Double momBmiVal) {
		this.momBmiVal = momBmiVal;
	}
	/**
	 * Get dad_hght_val 아빠_키_값 numeric(null)
	 * @Return Double dadHghtVal
	 */
	public Double getDadHghtVal() {
		return this.dadHghtVal;
	}
	
	/**
	 * Set dad_hght_val 아빠_키_값 numeric(null)
	 * @Param Double dadHghtVal
	 */
	public void setDadHghtVal(Double dadHghtVal) {
		this.dadHghtVal = dadHghtVal;
	}
	/**
	 * Get dad_wght_val 아빠_몸무게_값 numeric(null)
	 * @Return Double dadWghtVal
	 */
	public Double getDadWghtVal() {
		return this.dadWghtVal;
	}
	
	/**
	 * Set dad_wght_val 아빠_몸무게_값 numeric(null)
	 * @Param Double dadWghtVal
	 */
	public void setDadWghtVal(Double dadWghtVal) {
		this.dadWghtVal = dadWghtVal;
	}
	/**
	 * Get dad_bmi_val 아빠_BMI_값 numeric(null)
	 * @Return Double dadBmiVal
	 */
	public Double getDadBmiVal() {
		return this.dadBmiVal;
	}
	
	/**
	 * Set dad_bmi_val 아빠_BMI_값 numeric(null)
	 * @Param Double dadBmiVal
	 */
	public void setDadBmiVal(Double dadBmiVal) {
		this.dadBmiVal = dadBmiVal;
	}
	/**
	 * Get grow_stnd_ver 성장_기준_버전 character varying(20)
	 * @Return String growStndVer
	 */
	public String getGrowStndVer() {
		return this.growStndVer;
	}
	
	/**
	 * Set grow_stnd_ver 성장_기준_버전 character varying(20)
	 * @Param String growStndVer
	 */
	public void setGrowStndVer(String growStndVer) {
		this.growStndVer = growStndVer;
	}
	/**
	 * Get grow_stnd_no 성장_기준_번호 numeric(null)
	 * @Return Double growStndNo
	 */
	public Double getGrowStndNo() {
		return this.growStndNo;
	}
	
	/**
	 * Set grow_stnd_no 성장_기준_번호 numeric(null)
	 * @Param Double growStndNo
	 */
	public void setGrowStndNo(Double growStndNo) {
		this.growStndNo = growStndNo;
	}
	/**
	 * Get gidx 성장지수 numeric(null)
	 * @Return Double gidx
	 */
	public Double getGidx() {
		return this.gidx;
	}
	
	/**
	 * Set gidx 성장지수 numeric(null)
	 * @Param Double gidx
	 */
	public void setGidx(Double gidx) {
		this.gidx = gidx;
	}
	/**
	 * Get grow_judg_cd 성장_판정_코드 character varying(20)
	 * @Return String growJudgCd
	 */
	public String getGrowJudgCd() {
		return this.growJudgCd;
	}
	
	/**
	 * Set grow_judg_cd 성장_판정_코드 character varying(20)
	 * @Param String growJudgCd
	 */
	public void setGrowJudgCd(String growJudgCd) {
		this.growJudgCd = growJudgCd;
	}
	/**
	 * Get grow_judg_desc 성장_판정_설명 character varying(4000)
	 * @Return String growJudgDesc
	 */
	public String getGrowJudgDesc() {
		return this.growJudgDesc;
	}
	
	/**
	 * Set grow_judg_desc 성장_판정_설명 character varying(4000)
	 * @Param String growJudgDesc
	 */
	public void setGrowJudgDesc(String growJudgDesc) {
		this.growJudgDesc = growJudgDesc;
	}
	/**
	 * Get grow_prdt_idx 성장_예측_지수 numeric(null)
	 * @Return Double growPrdtIdx
	 */
	public Double getGrowPrdtIdx() {
		return this.growPrdtIdx;
	}
	
	/**
	 * Set grow_prdt_idx 성장_예측_지수 numeric(null)
	 * @Param Double growPrdtIdx
	 */
	public void setGrowPrdtIdx(Double growPrdtIdx) {
		this.growPrdtIdx = growPrdtIdx;
	}
	/**
	 * Get grow_prdt_cd 성장_예측_코드 character varying(20)
	 * @Return String growPrdtCd
	 */
	public String getGrowPrdtCd() {
		return this.growPrdtCd;
	}
	
	/**
	 * Set grow_prdt_cd 성장_예측_코드 character varying(20)
	 * @Param String growPrdtCd
	 */
	public void setGrowPrdtCd(String growPrdtCd) {
		this.growPrdtCd = growPrdtCd;
	}
	/**
	 * Get grow_prdt_desc 성장_예측_설명 character varying(4000)
	 * @Return String growPrdtDesc
	 */
	public String getGrowPrdtDesc() {
		return this.growPrdtDesc;
	}
	
	/**
	 * Set grow_prdt_desc 성장_예측_설명 character varying(4000)
	 * @Param String growPrdtDesc
	 */
	public void setGrowPrdtDesc(String growPrdtDesc) {
		this.growPrdtDesc = growPrdtDesc;
	}
	/**
	 * Get unit_gidx 단위_성장지수 numeric(null)
	 * @Return Double unitGidx
	 */
	public Double getUnitGidx() {
		return this.unitGidx;
	}
	
	/**
	 * Set unit_gidx 단위_성장지수 numeric(null)
	 * @Param Double unitGidx
	 */
	public void setUnitGidx(Double unitGidx) {
		this.unitGidx = unitGidx;
	}
	/**
	 * Get unit_grow_judg_cd 단위_성장_판정_코드 character varying(20)
	 * @Return String unitGrowJudgCd
	 */
	public String getUnitGrowJudgCd() {
		return this.unitGrowJudgCd;
	}
	
	/**
	 * Set unit_grow_judg_cd 단위_성장_판정_코드 character varying(20)
	 * @Param String unitGrowJudgCd
	 */
	public void setUnitGrowJudgCd(String unitGrowJudgCd) {
		this.unitGrowJudgCd = unitGrowJudgCd;
	}
	/**
	 * Get fat_stnd_ver 비만_기준_버전 character varying(20)
	 * @Return String fatStndVer
	 */
	public String getFatStndVer() {
		return this.fatStndVer;
	}
	
	/**
	 * Set fat_stnd_ver 비만_기준_버전 character varying(20)
	 * @Param String fatStndVer
	 */
	public void setFatStndVer(String fatStndVer) {
		this.fatStndVer = fatStndVer;
	}
	/**
	 * Get fat_stnd_no 비만_기준_번호 numeric(null)
	 * @Return Double fatStndNo
	 */
	public Double getFatStndNo() {
		return this.fatStndNo;
	}
	
	/**
	 * Set fat_stnd_no 비만_기준_번호 numeric(null)
	 * @Param Double fatStndNo
	 */
	public void setFatStndNo(Double fatStndNo) {
		this.fatStndNo = fatStndNo;
	}
	/**
	 * Get nutr_eat_qty 영양소_섭취_량 numeric(null)
	 * @Return Double nutrEatQty
	 */
	public Double getNutrEatQty() {
		return this.nutrEatQty;
	}
	
	/**
	 * Set nutr_eat_qty 영양소_섭취_량 numeric(null)
	 * @Param Double nutrEatQty
	 */
	public void setNutrEatQty(Double nutrEatQty) {
		this.nutrEatQty = nutrEatQty;
	}
	/**
	 * Get fidx 비만지수 numeric(null)
	 * @Return Double fidx
	 */
	public Double getFidx() {
		return this.fidx;
	}
	
	/**
	 * Set fidx 비만지수 numeric(null)
	 * @Param Double fidx
	 */
	public void setFidx(Double fidx) {
		this.fidx = fidx;
	}
	/**
	 * Get fat_judg_cd 비만_판정_코드 character varying(20)
	 * @Return String fatJudgCd
	 */
	public String getFatJudgCd() {
		return this.fatJudgCd;
	}
	
	/**
	 * Set fat_judg_cd 비만_판정_코드 character varying(20)
	 * @Param String fatJudgCd
	 */
	public void setFatJudgCd(String fatJudgCd) {
		this.fatJudgCd = fatJudgCd;
	}
	/**
	 * Get fat_judg_desc 비만_판정_설명 character varying(4000)
	 * @Return String fatJudgDesc
	 */
	public String getFatJudgDesc() {
		return this.fatJudgDesc;
	}
	
	/**
	 * Set fat_judg_desc 비만_판정_설명 character varying(4000)
	 * @Param String fatJudgDesc
	 */
	public void setFatJudgDesc(String fatJudgDesc) {
		this.fatJudgDesc = fatJudgDesc;
	}
	/**
	 * Get unit_fidx 단위_비만지수 numeric(null)
	 * @Return Double unitFidx
	 */
	public Double getUnitFidx() {
		return this.unitFidx;
	}
	
	/**
	 * Set unit_fidx 단위_비만지수 numeric(null)
	 * @Param Double unitFidx
	 */
	public void setUnitFidx(Double unitFidx) {
		this.unitFidx = unitFidx;
	}
	/**
	 * Get unit_fat_judg_cd 단위_비만_판정_코드 character varying(20)
	 * @Return String unitFatJudgCd
	 */
	public String getUnitFatJudgCd() {
		return this.unitFatJudgCd;
	}
	
	/**
	 * Set unit_fat_judg_cd 단위_비만_판정_코드 character varying(20)
	 * @Param String unitFatJudgCd
	 */
	public void setUnitFatJudgCd(String unitFatJudgCd) {
		this.unitFatJudgCd = unitFatJudgCd;
	}
	/**
	 * Get fatp_qust_stnd_dt 비만예측_설문_기준_일자 character(8)
	 * @Return String fatpQustStndDt
	 */
	public String getFatpQustStndDt() {
		return this.fatpQustStndDt;
	}
	
	/**
	 * Set fatp_qust_stnd_dt 비만예측_설문_기준_일자 character(8)
	 * @Param String fatpQustStndDt
	 */
	public void setFatpQustStndDt(String fatpQustStndDt) {
		this.fatpQustStndDt = fatpQustStndDt;
	}
	/**
	 * Get fatp_bmi_val 비만예측_BMI_값 numeric(null)
	 * @Return Double fatpBmiVal
	 */
	public Double getFatpBmiVal() {
		return this.fatpBmiVal;
	}
	
	/**
	 * Set fatp_bmi_val 비만예측_BMI_값 numeric(null)
	 * @Param Double fatpBmiVal
	 */
	public void setFatpBmiVal(Double fatpBmiVal) {
		this.fatpBmiVal = fatpBmiVal;
	}
	/**
	 * Get fatp_idx 비만예측_지수 numeric(null)
	 * @Return Double fatpIdx
	 */
	public Double getFatpIdx() {
		return this.fatpIdx;
	}
	
	/**
	 * Set fatp_idx 비만예측_지수 numeric(null)
	 * @Param Double fatpIdx
	 */
	public void setFatpIdx(Double fatpIdx) {
		this.fatpIdx = fatpIdx;
	}
	/**
	 * Get fatp_judg_cd 비만예측_판정_코드 character varying(20)
	 * @Return String fatpJudgCd
	 */
	public String getFatpJudgCd() {
		return this.fatpJudgCd;
	}
	
	/**
	 * Set fatp_judg_cd 비만예측_판정_코드 character varying(20)
	 * @Param String fatpJudgCd
	 */
	public void setFatpJudgCd(String fatpJudgCd) {
		this.fatpJudgCd = fatpJudgCd;
	}
	/**
	 * Get fatp_judg_desc 비만예측_판정_설명 character varying(4000)
	 * @Return String fatpJudgDesc
	 */
	public String getFatpJudgDesc() {
		return this.fatpJudgDesc;
	}
	
	/**
	 * Set fatp_judg_desc 비만예측_판정_설명 character varying(4000)
	 * @Param String fatpJudgDesc
	 */
	public void setFatpJudgDesc(String fatpJudgDesc) {
		this.fatpJudgDesc = fatpJudgDesc;
	}
	/**
	 * Get pal_val 신체활동수준_값 numeric(null)
	 * @Return Double palVal
	 */
	public Double getPalVal() {
		return this.palVal;
	}
	
	/**
	 * Set pal_val 신체활동수준_값 numeric(null)
	 * @Param Double palVal
	 */
	public void setPalVal(Double palVal) {
		this.palVal = palVal;
	}
	/**
	 * Get bcsm_val 기초에너지소모량_값 numeric(null)
	 * @Return Double bcsmVal
	 */
	public Double getBcsmVal() {
		return this.bcsmVal;
	}
	
	/**
	 * Set bcsm_val 기초에너지소모량_값 numeric(null)
	 * @Param Double bcsmVal
	 */
	public void setBcsmVal(Double bcsmVal) {
		this.bcsmVal = bcsmVal;
	}
	/**
	 * Get acsm_val 활동에너지소모량_값 numeric(null)
	 * @Return Double acsmVal
	 */
	public Double getAcsmVal() {
		return this.acsmVal;
	}
	
	/**
	 * Set acsm_val 활동에너지소모량_값 numeric(null)
	 * @Param Double acsmVal
	 */
	public void setAcsmVal(Double acsmVal) {
		this.acsmVal = acsmVal;
	}
	/**
	 * Get pal_cd 신체활동수준_코드 character varying(20)
	 * @Return String palCd
	 */
	public String getPalCd() {
		return this.palCd;
	}
	
	/**
	 * Set pal_cd 신체활동수준_코드 character varying(20)
	 * @Param String palCd
	 */
	public void setPalCd(String palCd) {
		this.palCd = palCd;
	}
	/**
	 * Get cal_nutr_stat_cd 칼로리_영양섭취_상태_코드 character varying(20)
	 * @Return String calNutrStatCd
	 */
	public String getCalNutrStatCd() {
		return this.calNutrStatCd;
	}
	
	/**
	 * Set cal_nutr_stat_cd 칼로리_영양섭취_상태_코드 character varying(20)
	 * @Param String calNutrStatCd
	 */
	public void setCalNutrStatCd(String calNutrStatCd) {
		this.calNutrStatCd = calNutrStatCd;
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
