package kr.co.seculink.domain.vo;

import java.io.Serializable;
import lombok.ToString;
/**
 * ts_dzone_data_01 Value Object
 */
 @ToString
public class TsDzoneData01Vo implements Serializable {

	/* job_dt 작업_일자 character(8) */
	private String jobDt;

	/* seq 순번 numeric(null) */
	private Double seq;

	/* afos_fid 다발지역FID character varying(22) */
	private String afosFid;

	/* afos_id 다발지역ID character varying(7) */
	private String afosId;

	/* bjd_cd 법정동코드 character varying(10) */
	private String bjdCd;

	/* spot_cd 지점코드 character varying(10) */
	private String spotCd;

	/* sido_sgg_nm 시도시군구명 character varying(40) */
	private String sidoSggNm;

	/* spot_nm 지점명 character varying(100) */
	private String spotNm;

	/* occrcnt 발생건수 numeric(null) */
	private Double occrcnt;

	/* occrrnc_cnt 사상자수 numeric(null) */
	private Double occrrncCnt;

	/* caslt_cnt 사망자수 numeric(null) */
	private Double casltCnt;

	/* dth_dnv_cnt 중상자수 numeric(null) */
	private Double dthDnvCnt;

	/* se_dnv_cnt 경상자수 numeric(null) */
	private Double seDnvCnt;

	/* wnd_dnv_cnt 부상신고자수 numeric(null) */
	private Double wndDnvCnt;

	/* geom_json 다발지역폴리곤 character varying(4000) */
	private String geomJson;

	/* lo_crd 경도 numeric(null) */
	private Double loCrd;

	/* la_crd 위도 numeric(null) */
	private Double laCrd;

	/* loc_no 위치_번호 numeric(null) */
	private Double locNo;

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
	 * Get job_dt 작업_일자 character(8)
	 * @Return String jobDt
	 */
	public String getJobDt() {
		return this.jobDt;
	}
	
	/**
	 * Set job_dt 작업_일자 character(8)
	 * @Param String jobDt
	 */
	public void setJobDt(String jobDt) {
		this.jobDt = jobDt;
	}
	/**
	 * Get seq 순번 numeric(null)
	 * @Return Double seq
	 */
	public Double getSeq() {
		return this.seq;
	}
	
	/**
	 * Set seq 순번 numeric(null)
	 * @Param Double seq
	 */
	public void setSeq(Double seq) {
		this.seq = seq;
	}
	/**
	 * Get afos_fid 다발지역FID character varying(22)
	 * @Return String afosFid
	 */
	public String getAfosFid() {
		return this.afosFid;
	}
	
	/**
	 * Set afos_fid 다발지역FID character varying(22)
	 * @Param String afosFid
	 */
	public void setAfosFid(String afosFid) {
		this.afosFid = afosFid;
	}
	/**
	 * Get afos_id 다발지역ID character varying(7)
	 * @Return String afosId
	 */
	public String getAfosId() {
		return this.afosId;
	}
	
	/**
	 * Set afos_id 다발지역ID character varying(7)
	 * @Param String afosId
	 */
	public void setAfosId(String afosId) {
		this.afosId = afosId;
	}
	/**
	 * Get bjd_cd 법정동코드 character varying(10)
	 * @Return String bjdCd
	 */
	public String getBjdCd() {
		return this.bjdCd;
	}
	
	/**
	 * Set bjd_cd 법정동코드 character varying(10)
	 * @Param String bjdCd
	 */
	public void setBjdCd(String bjdCd) {
		this.bjdCd = bjdCd;
	}
	/**
	 * Get spot_cd 지점코드 character varying(10)
	 * @Return String spotCd
	 */
	public String getSpotCd() {
		return this.spotCd;
	}
	
	/**
	 * Set spot_cd 지점코드 character varying(10)
	 * @Param String spotCd
	 */
	public void setSpotCd(String spotCd) {
		this.spotCd = spotCd;
	}
	/**
	 * Get sido_sgg_nm 시도시군구명 character varying(40)
	 * @Return String sidoSggNm
	 */
	public String getSidoSggNm() {
		return this.sidoSggNm;
	}
	
	/**
	 * Set sido_sgg_nm 시도시군구명 character varying(40)
	 * @Param String sidoSggNm
	 */
	public void setSidoSggNm(String sidoSggNm) {
		this.sidoSggNm = sidoSggNm;
	}
	/**
	 * Get spot_nm 지점명 character varying(100)
	 * @Return String spotNm
	 */
	public String getSpotNm() {
		return this.spotNm;
	}
	
	/**
	 * Set spot_nm 지점명 character varying(100)
	 * @Param String spotNm
	 */
	public void setSpotNm(String spotNm) {
		this.spotNm = spotNm;
	}
	/**
	 * Get occrcnt 발생건수 numeric(null)
	 * @Return Double occrcnt
	 */
	public Double getOccrcnt() {
		return this.occrcnt;
	}
	
	/**
	 * Set occrcnt 발생건수 numeric(null)
	 * @Param Double occrcnt
	 */
	public void setOccrcnt(Double occrcnt) {
		this.occrcnt = occrcnt;
	}
	/**
	 * Get occrrnc_cnt 사상자수 numeric(null)
	 * @Return Double occrrncCnt
	 */
	public Double getOccrrncCnt() {
		return this.occrrncCnt;
	}
	
	/**
	 * Set occrrnc_cnt 사상자수 numeric(null)
	 * @Param Double occrrncCnt
	 */
	public void setOccrrncCnt(Double occrrncCnt) {
		this.occrrncCnt = occrrncCnt;
	}
	/**
	 * Get caslt_cnt 사망자수 numeric(null)
	 * @Return Double casltCnt
	 */
	public Double getCasltCnt() {
		return this.casltCnt;
	}
	
	/**
	 * Set caslt_cnt 사망자수 numeric(null)
	 * @Param Double casltCnt
	 */
	public void setCasltCnt(Double casltCnt) {
		this.casltCnt = casltCnt;
	}
	/**
	 * Get dth_dnv_cnt 중상자수 numeric(null)
	 * @Return Double dthDnvCnt
	 */
	public Double getDthDnvCnt() {
		return this.dthDnvCnt;
	}
	
	/**
	 * Set dth_dnv_cnt 중상자수 numeric(null)
	 * @Param Double dthDnvCnt
	 */
	public void setDthDnvCnt(Double dthDnvCnt) {
		this.dthDnvCnt = dthDnvCnt;
	}
	/**
	 * Get se_dnv_cnt 경상자수 numeric(null)
	 * @Return Double seDnvCnt
	 */
	public Double getSeDnvCnt() {
		return this.seDnvCnt;
	}
	
	/**
	 * Set se_dnv_cnt 경상자수 numeric(null)
	 * @Param Double seDnvCnt
	 */
	public void setSeDnvCnt(Double seDnvCnt) {
		this.seDnvCnt = seDnvCnt;
	}
	/**
	 * Get wnd_dnv_cnt 부상신고자수 numeric(null)
	 * @Return Double wndDnvCnt
	 */
	public Double getWndDnvCnt() {
		return this.wndDnvCnt;
	}
	
	/**
	 * Set wnd_dnv_cnt 부상신고자수 numeric(null)
	 * @Param Double wndDnvCnt
	 */
	public void setWndDnvCnt(Double wndDnvCnt) {
		this.wndDnvCnt = wndDnvCnt;
	}
	/**
	 * Get geom_json 다발지역폴리곤 character varying(4000)
	 * @Return String geomJson
	 */
	public String getGeomJson() {
		return this.geomJson;
	}
	
	/**
	 * Set geom_json 다발지역폴리곤 character varying(4000)
	 * @Param String geomJson
	 */
	public void setGeomJson(String geomJson) {
		this.geomJson = geomJson;
	}
	/**
	 * Get lo_crd 경도 numeric(null)
	 * @Return Double loCrd
	 */
	public Double getLoCrd() {
		return this.loCrd;
	}
	
	/**
	 * Set lo_crd 경도 numeric(null)
	 * @Param Double loCrd
	 */
	public void setLoCrd(Double loCrd) {
		this.loCrd = loCrd;
	}
	/**
	 * Get la_crd 위도 numeric(null)
	 * @Return Double laCrd
	 */
	public Double getLaCrd() {
		return this.laCrd;
	}
	
	/**
	 * Set la_crd 위도 numeric(null)
	 * @Param Double laCrd
	 */
	public void setLaCrd(Double laCrd) {
		this.laCrd = laCrd;
	}
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
