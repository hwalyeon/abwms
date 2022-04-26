package kr.co.seculink.domain.vo;

import java.io.Serializable;
import lombok.ToString;
/**
 * ts_dzone_data_06 Value Object
 */
 @ToString
public class TsDzoneData06Vo implements Serializable {

	/* job_dt 작업_일자 character(8) */
	private String jobDt;

	/* seq 순번 numeric(null) */
	private Double seq;

	/* fclty_nm 시설_명 character varying(100) */
	private String fcltyNm;

	/* rdnmadr 소재지_도로명_주소 character varying(400) */
	private String rdnmadr;

	/* inmadr 소재지_지번_주소 character varying(400) */
	private String inmadr;

	/* fclty_type 시설_유형 character varying(50) */
	private String fcltyType;

	/* appn_ntfc_no 위험_시설_지정_고시_번호 character varying(100) */
	private String appnNtfcNo;

	/* appn_date 위험_시설_지정_일자 character varying(10) */
	private String appnDate;

	/* appn_resn 위험_시설_지정_사유 character varying(400) */
	private String appnResn;

	/* relis_date 위험_시설_해제_일자 character varying(10) */
	private String relisDate;

	/* latitude 위도_값 numeric(null) */
	private Double latitude;

	/* longitude 경도_값 numeric(null) */
	private Double longitude;

	/* et 연장 character varying(20) */
	private String et;

	/* bt 폭 character varying(20) */
	private String bt;

	/* fclty_adjncts 시설_부속물 character varying(100) */
	private String fcltyAdjncts;

	/* phone_number 관리_기관_전화번호 character varying(20) */
	private String phoneNumber;

	/* institution_nm 관리_기관_명 character varying(200) */
	private String institutionNm;

	/* reference_date 데이터_기준_일자 character varying(10) */
	private String referenceDate;

	/* instt_code 제공_기관_코드 character varying(20) */
	private String insttCode;

	/* instt_nm 제공_기관_명 character varying(50) */
	private String insttNm;

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
	 * Get fclty_nm 시설_명 character varying(100)
	 * @Return String fcltyNm
	 */
	public String getFcltyNm() {
		return this.fcltyNm;
	}
	
	/**
	 * Set fclty_nm 시설_명 character varying(100)
	 * @Param String fcltyNm
	 */
	public void setFcltyNm(String fcltyNm) {
		this.fcltyNm = fcltyNm;
	}
	/**
	 * Get rdnmadr 소재지_도로명_주소 character varying(400)
	 * @Return String rdnmadr
	 */
	public String getRdnmadr() {
		return this.rdnmadr;
	}
	
	/**
	 * Set rdnmadr 소재지_도로명_주소 character varying(400)
	 * @Param String rdnmadr
	 */
	public void setRdnmadr(String rdnmadr) {
		this.rdnmadr = rdnmadr;
	}
	/**
	 * Get inmadr 소재지_지번_주소 character varying(400)
	 * @Return String inmadr
	 */
	public String getInmadr() {
		return this.inmadr;
	}
	
	/**
	 * Set inmadr 소재지_지번_주소 character varying(400)
	 * @Param String inmadr
	 */
	public void setInmadr(String inmadr) {
		this.inmadr = inmadr;
	}
	/**
	 * Get fclty_type 시설_유형 character varying(50)
	 * @Return String fcltyType
	 */
	public String getFcltyType() {
		return this.fcltyType;
	}
	
	/**
	 * Set fclty_type 시설_유형 character varying(50)
	 * @Param String fcltyType
	 */
	public void setFcltyType(String fcltyType) {
		this.fcltyType = fcltyType;
	}
	/**
	 * Get appn_ntfc_no 위험_시설_지정_고시_번호 character varying(100)
	 * @Return String appnNtfcNo
	 */
	public String getAppnNtfcNo() {
		return this.appnNtfcNo;
	}
	
	/**
	 * Set appn_ntfc_no 위험_시설_지정_고시_번호 character varying(100)
	 * @Param String appnNtfcNo
	 */
	public void setAppnNtfcNo(String appnNtfcNo) {
		this.appnNtfcNo = appnNtfcNo;
	}
	/**
	 * Get appn_date 위험_시설_지정_일자 character varying(10)
	 * @Return String appnDate
	 */
	public String getAppnDate() {
		return this.appnDate;
	}
	
	/**
	 * Set appn_date 위험_시설_지정_일자 character varying(10)
	 * @Param String appnDate
	 */
	public void setAppnDate(String appnDate) {
		this.appnDate = appnDate;
	}
	/**
	 * Get appn_resn 위험_시설_지정_사유 character varying(400)
	 * @Return String appnResn
	 */
	public String getAppnResn() {
		return this.appnResn;
	}
	
	/**
	 * Set appn_resn 위험_시설_지정_사유 character varying(400)
	 * @Param String appnResn
	 */
	public void setAppnResn(String appnResn) {
		this.appnResn = appnResn;
	}
	/**
	 * Get relis_date 위험_시설_해제_일자 character varying(10)
	 * @Return String relisDate
	 */
	public String getRelisDate() {
		return this.relisDate;
	}
	
	/**
	 * Set relis_date 위험_시설_해제_일자 character varying(10)
	 * @Param String relisDate
	 */
	public void setRelisDate(String relisDate) {
		this.relisDate = relisDate;
	}
	/**
	 * Get latitude 위도_값 numeric(null)
	 * @Return Double latitude
	 */
	public Double getLatitude() {
		return this.latitude;
	}
	
	/**
	 * Set latitude 위도_값 numeric(null)
	 * @Param Double latitude
	 */
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	/**
	 * Get longitude 경도_값 numeric(null)
	 * @Return Double longitude
	 */
	public Double getLongitude() {
		return this.longitude;
	}
	
	/**
	 * Set longitude 경도_값 numeric(null)
	 * @Param Double longitude
	 */
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	/**
	 * Get et 연장 character varying(20)
	 * @Return String et
	 */
	public String getEt() {
		return this.et;
	}
	
	/**
	 * Set et 연장 character varying(20)
	 * @Param String et
	 */
	public void setEt(String et) {
		this.et = et;
	}
	/**
	 * Get bt 폭 character varying(20)
	 * @Return String bt
	 */
	public String getBt() {
		return this.bt;
	}
	
	/**
	 * Set bt 폭 character varying(20)
	 * @Param String bt
	 */
	public void setBt(String bt) {
		this.bt = bt;
	}
	/**
	 * Get fclty_adjncts 시설_부속물 character varying(100)
	 * @Return String fcltyAdjncts
	 */
	public String getFcltyAdjncts() {
		return this.fcltyAdjncts;
	}
	
	/**
	 * Set fclty_adjncts 시설_부속물 character varying(100)
	 * @Param String fcltyAdjncts
	 */
	public void setFcltyAdjncts(String fcltyAdjncts) {
		this.fcltyAdjncts = fcltyAdjncts;
	}
	/**
	 * Get phone_number 관리_기관_전화번호 character varying(20)
	 * @Return String phoneNumber
	 */
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	
	/**
	 * Set phone_number 관리_기관_전화번호 character varying(20)
	 * @Param String phoneNumber
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/**
	 * Get institution_nm 관리_기관_명 character varying(200)
	 * @Return String institutionNm
	 */
	public String getInstitutionNm() {
		return this.institutionNm;
	}
	
	/**
	 * Set institution_nm 관리_기관_명 character varying(200)
	 * @Param String institutionNm
	 */
	public void setInstitutionNm(String institutionNm) {
		this.institutionNm = institutionNm;
	}
	/**
	 * Get reference_date 데이터_기준_일자 character varying(10)
	 * @Return String referenceDate
	 */
	public String getReferenceDate() {
		return this.referenceDate;
	}
	
	/**
	 * Set reference_date 데이터_기준_일자 character varying(10)
	 * @Param String referenceDate
	 */
	public void setReferenceDate(String referenceDate) {
		this.referenceDate = referenceDate;
	}
	/**
	 * Get instt_code 제공_기관_코드 character varying(20)
	 * @Return String insttCode
	 */
	public String getInsttCode() {
		return this.insttCode;
	}
	
	/**
	 * Set instt_code 제공_기관_코드 character varying(20)
	 * @Param String insttCode
	 */
	public void setInsttCode(String insttCode) {
		this.insttCode = insttCode;
	}
	/**
	 * Get instt_nm 제공_기관_명 character varying(50)
	 * @Return String insttNm
	 */
	public String getInsttNm() {
		return this.insttNm;
	}
	
	/**
	 * Set instt_nm 제공_기관_명 character varying(50)
	 * @Param String insttNm
	 */
	public void setInsttNm(String insttNm) {
		this.insttNm = insttNm;
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
