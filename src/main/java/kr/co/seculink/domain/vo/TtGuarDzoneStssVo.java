package kr.co.seculink.domain.vo;

import java.io.Serializable;
import lombok.ToString;
/**
 * tt_guar_dzone_stss Value Object
 */
 @ToString
public class TtGuarDzoneStssVo implements Serializable {

	/* stnd_dt 기준_일자 character(8) */
	private String stndDt;

	/* plc_clss_cd 장소_분류_코드 character varying(20) */
	private String plcClssCd;

	/* lat_val 위도_값 numeric(null) */
	private Double latVal;

	/* lon_val 경도_값 numeric(null) */
	private Double lonVal;

	/* near_addr 인근_주소 character varying(200) */
	private String nearAddr;

	/* dup_apnt_cnt 중복_지정_건수 numeric(null) */
	private Double dupApntCnt;

	/* addr_head_1 주소_헤더_1 character varying(30) */
	private String addrHead1;

	/* addr_head_2 주소_헤더_2 character varying(30) */
	private String addrHead2;


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
	 * Get near_addr 인근_주소 character varying(200)
	 * @Return String nearAddr
	 */
	public String getNearAddr() {
		return this.nearAddr;
	}
	
	/**
	 * Set near_addr 인근_주소 character varying(200)
	 * @Param String nearAddr
	 */
	public void setNearAddr(String nearAddr) {
		this.nearAddr = nearAddr;
	}
	/**
	 * Get dup_apnt_cnt 중복_지정_건수 numeric(null)
	 * @Return Double dupApntCnt
	 */
	public Double getDupApntCnt() {
		return this.dupApntCnt;
	}
	
	/**
	 * Set dup_apnt_cnt 중복_지정_건수 numeric(null)
	 * @Param Double dupApntCnt
	 */
	public void setDupApntCnt(Double dupApntCnt) {
		this.dupApntCnt = dupApntCnt;
	}
	/**
	 * Get addr_head_1 주소_헤더_1 character varying(30)
	 * @Return String addrHead1
	 */
	public String getAddrHead1() {
		return this.addrHead1;
	}
	
	/**
	 * Set addr_head_1 주소_헤더_1 character varying(30)
	 * @Param String addrHead1
	 */
	public void setAddrHead1(String addrHead1) {
		this.addrHead1 = addrHead1;
	}
	/**
	 * Get addr_head_2 주소_헤더_2 character varying(30)
	 * @Return String addrHead2
	 */
	public String getAddrHead2() {
		return this.addrHead2;
	}
	
	/**
	 * Set addr_head_2 주소_헤더_2 character varying(30)
	 * @Param String addrHead2
	 */
	public void setAddrHead2(String addrHead2) {
		this.addrHead2 = addrHead2;
	}

} // end of class
