package kr.co.seculink.domain.vo;

import java.io.Serializable;
import lombok.ToString;
/**
 * tc_siml_data Value Object
 */
 @ToString
public class TcSimlDataVo implements Serializable {

	/* siml_no 시뮬레이션_번호 numeric(null) */
	private Double simlNo;

	/* siml_seq 시뮬레이션_순번 numeric(null) */
	private Double simlSeq;

	/* evnt_div_cd 이벤트_구분_코드 character varying(20) */
	private String evntDivCd;

	/* band_id 밴드_ID character varying(20) */
	private String bandId;

	/* occr_dttm 발생_일시 character(14) */
	private String occrDttm;

	/* lat_val 위도_값 numeric(null) */
	private Double latVal;

	/* lon_val 경도_값 numeric(null) */
	private Double lonVal;

	/* hbit_mdan 심박_중간값 numeric(null) */
	private Double hbitMdan;

	/* min1_hbit_cntn 1분_심박_내용 character varying(4000) */
	private String min1HbitCntn;

	/* temp_val 체온_값 numeric(null) */
	private Double tempVal;

	/* act_div_cd 활동_구분_코드 character varying(20) */
	private String actDivCd;

	/* cbee_bal 캐시비_잔액 numeric(null) */
	private Double cbeeBal;

	/* accu_run_tcnt_cnt 누적_달리기_시간_수 numeric(null) */
	private Double accuRunTcntCnt;

	/* accu_walk_tcnt_cnt 누적_걸음_시간_수 numeric(null) */
	private Double accuWalkTcntCnt;

	/* accu_walk_cnt 누적_걸음_수 numeric(null) */
	private Double accuWalkCnt;

	/* batr_chrg_qty 배터리_충전_량 numeric(null) */
	private Double batrChrgQty;


	/**
	 * Get siml_no 시뮬레이션_번호 numeric(null)
	 * @Return Double simlNo
	 */
	public Double getSimlNo() {
		return this.simlNo;
	}
	
	/**
	 * Set siml_no 시뮬레이션_번호 numeric(null)
	 * @Param Double simlNo
	 */
	public void setSimlNo(Double simlNo) {
		this.simlNo = simlNo;
	}
	/**
	 * Get siml_seq 시뮬레이션_순번 numeric(null)
	 * @Return Double simlSeq
	 */
	public Double getSimlSeq() {
		return this.simlSeq;
	}
	
	/**
	 * Set siml_seq 시뮬레이션_순번 numeric(null)
	 * @Param Double simlSeq
	 */
	public void setSimlSeq(Double simlSeq) {
		this.simlSeq = simlSeq;
	}
	/**
	 * Get evnt_div_cd 이벤트_구분_코드 character varying(20)
	 * @Return String evntDivCd
	 */
	public String getEvntDivCd() {
		return this.evntDivCd;
	}
	
	/**
	 * Set evnt_div_cd 이벤트_구분_코드 character varying(20)
	 * @Param String evntDivCd
	 */
	public void setEvntDivCd(String evntDivCd) {
		this.evntDivCd = evntDivCd;
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
	 * Get hbit_mdan 심박_중간값 numeric(null)
	 * @Return Double hbitMdan
	 */
	public Double getHbitMdan() {
		return this.hbitMdan;
	}
	
	/**
	 * Set hbit_mdan 심박_중간값 numeric(null)
	 * @Param Double hbitMdan
	 */
	public void setHbitMdan(Double hbitMdan) {
		this.hbitMdan = hbitMdan;
	}
	/**
	 * Get min1_hbit_cntn 1분_심박_내용 character varying(4000)
	 * @Return String min1HbitCntn
	 */
	public String getMin1HbitCntn() {
		return this.min1HbitCntn;
	}
	
	/**
	 * Set min1_hbit_cntn 1분_심박_내용 character varying(4000)
	 * @Param String min1HbitCntn
	 */
	public void setMin1HbitCntn(String min1HbitCntn) {
		this.min1HbitCntn = min1HbitCntn;
	}
	/**
	 * Get temp_val 체온_값 numeric(null)
	 * @Return Double tempVal
	 */
	public Double getTempVal() {
		return this.tempVal;
	}
	
	/**
	 * Set temp_val 체온_값 numeric(null)
	 * @Param Double tempVal
	 */
	public void setTempVal(Double tempVal) {
		this.tempVal = tempVal;
	}
	/**
	 * Get act_div_cd 활동_구분_코드 character varying(20)
	 * @Return String actDivCd
	 */
	public String getActDivCd() {
		return this.actDivCd;
	}
	
	/**
	 * Set act_div_cd 활동_구분_코드 character varying(20)
	 * @Param String actDivCd
	 */
	public void setActDivCd(String actDivCd) {
		this.actDivCd = actDivCd;
	}
	/**
	 * Get cbee_bal 캐시비_잔액 numeric(null)
	 * @Return Double cbeeBal
	 */
	public Double getCbeeBal() {
		return this.cbeeBal;
	}
	
	/**
	 * Set cbee_bal 캐시비_잔액 numeric(null)
	 * @Param Double cbeeBal
	 */
	public void setCbeeBal(Double cbeeBal) {
		this.cbeeBal = cbeeBal;
	}
	/**
	 * Get accu_run_tcnt_cnt 누적_달리기_시간_수 numeric(null)
	 * @Return Double accuRunTcntCnt
	 */
	public Double getAccuRunTcntCnt() {
		return this.accuRunTcntCnt;
	}
	
	/**
	 * Set accu_run_tcnt_cnt 누적_달리기_시간_수 numeric(null)
	 * @Param Double accuRunTcntCnt
	 */
	public void setAccuRunTcntCnt(Double accuRunTcntCnt) {
		this.accuRunTcntCnt = accuRunTcntCnt;
	}
	/**
	 * Get accu_walk_tcnt_cnt 누적_걸음_시간_수 numeric(null)
	 * @Return Double accuWalkTcntCnt
	 */
	public Double getAccuWalkTcntCnt() {
		return this.accuWalkTcntCnt;
	}
	
	/**
	 * Set accu_walk_tcnt_cnt 누적_걸음_시간_수 numeric(null)
	 * @Param Double accuWalkTcntCnt
	 */
	public void setAccuWalkTcntCnt(Double accuWalkTcntCnt) {
		this.accuWalkTcntCnt = accuWalkTcntCnt;
	}
	/**
	 * Get accu_walk_cnt 누적_걸음_수 numeric(null)
	 * @Return Double accuWalkCnt
	 */
	public Double getAccuWalkCnt() {
		return this.accuWalkCnt;
	}
	
	/**
	 * Set accu_walk_cnt 누적_걸음_수 numeric(null)
	 * @Param Double accuWalkCnt
	 */
	public void setAccuWalkCnt(Double accuWalkCnt) {
		this.accuWalkCnt = accuWalkCnt;
	}
	/**
	 * Get batr_chrg_qty 배터리_충전_량 numeric(null)
	 * @Return Double batrChrgQty
	 */
	public Double getBatrChrgQty() {
		return this.batrChrgQty;
	}
	
	/**
	 * Set batr_chrg_qty 배터리_충전_량 numeric(null)
	 * @Param Double batrChrgQty
	 */
	public void setBatrChrgQty(Double batrChrgQty) {
		this.batrChrgQty = batrChrgQty;
	}

} // end of class
