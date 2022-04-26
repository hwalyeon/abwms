package kr.co.seculink.domain.vo;

import java.io.Serializable;
import lombok.ToString;
/**
 * ts_dzone_data_03 Value Object
 */
 @ToString
public class TsDzoneData03Vo implements Serializable {

	/* job_dt 작업_일자 character(8) */
	private String jobDt;

	/* seq 순번 numeric(null) */
	private Double seq;

	/* pjt_cd 사업_코드 character varying(20) */
	private String pjtCd;

	/* pjt_name 사업_명 character varying(1000) */
	private String pjtName;

	/* pjt_fin_yn 준공_여부_구분 character varying(5) */
	private String pjtFinYn;

	/* pjt_fin_yn_nm 준공_여부 character varying(10) */
	private String pjtFinYnNm;

	/* plan_rt 계획공정율 numeric(null) */
	private Double planRt;

	/* real_rt 실적공정율 numeric(null) */
	private Double realRt;

	/* per_rt 대비_율 numeric(null) */
	private Double perRt;

	/* basic_dt 기준_일자 character varying(8) */
	private String basicDt;

	/* dt1 총_공기 numeric(null) */
	private Double dt1;

	/* dt2 경과일 numeric(null) */
	private Double dt2;

	/* dt3 D-Day numeric(null) */
	private Double dt3;

	/* tot_cntrt_amt 도급_금액 numeric(null) */
	private Double totCntrtAmt;

	/* tot_pjt_amt 사업비 numeric(null) */
	private Double totPjtAmt;

	/* du_date 공사기간 character varying(22) */
	private String duDate;

	/* office_addr 공사_위치 character varying(1000) */
	private String officeAddr;

	/* lat 위도 numeric(null) */
	private Double lat;

	/* lng 경도 numeric(null) */
	private Double lng;

	/* user_1 발주처_담당자_명 character varying(100) */
	private String user1;

	/* user_2 책임_감리원_명 character varying(100) */
	private String user2;

	/* user_3 현장_대리인_명 character varying(100) */
	private String user3;

	/* org_1 발주처_기관_명 character varying(100) */
	private String org1;

	/* org_2 감리사_업체_명 character varying(100) */
	private String org2;

	/* org_3 시공사_업체_명 character varying(100) */
	private String org3;

	/* pjt_scale 사업규모 character varying(2000) */
	private String pjtScale;

	/* rtsp_addr 웹카메라_RTSP_주소 character varying(200) */
	private String rtspAddr;

	/* cnrt_addr 계약정보_링크_주소 character varying(1000) */
	private String cnrtAddr;

	/* billpay_addr 집행정보_링크_주소 character varying(1000) */
	private String billpayAddr;

	/* air_view_img 조감도_이미지_링크_주소 character varying(1000) */
	private String airViewImg;

	/* alimi_addr 공사_개요_홈페이지 character varying(1000) */
	private String alimiAddr;

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
	 * Get pjt_cd 사업_코드 character varying(20)
	 * @Return String pjtCd
	 */
	public String getPjtCd() {
		return this.pjtCd;
	}
	
	/**
	 * Set pjt_cd 사업_코드 character varying(20)
	 * @Param String pjtCd
	 */
	public void setPjtCd(String pjtCd) {
		this.pjtCd = pjtCd;
	}
	/**
	 * Get pjt_name 사업_명 character varying(1000)
	 * @Return String pjtName
	 */
	public String getPjtName() {
		return this.pjtName;
	}
	
	/**
	 * Set pjt_name 사업_명 character varying(1000)
	 * @Param String pjtName
	 */
	public void setPjtName(String pjtName) {
		this.pjtName = pjtName;
	}
	/**
	 * Get pjt_fin_yn 준공_여부_구분 character varying(5)
	 * @Return String pjtFinYn
	 */
	public String getPjtFinYn() {
		return this.pjtFinYn;
	}
	
	/**
	 * Set pjt_fin_yn 준공_여부_구분 character varying(5)
	 * @Param String pjtFinYn
	 */
	public void setPjtFinYn(String pjtFinYn) {
		this.pjtFinYn = pjtFinYn;
	}
	/**
	 * Get pjt_fin_yn_nm 준공_여부 character varying(10)
	 * @Return String pjtFinYnNm
	 */
	public String getPjtFinYnNm() {
		return this.pjtFinYnNm;
	}
	
	/**
	 * Set pjt_fin_yn_nm 준공_여부 character varying(10)
	 * @Param String pjtFinYnNm
	 */
	public void setPjtFinYnNm(String pjtFinYnNm) {
		this.pjtFinYnNm = pjtFinYnNm;
	}
	/**
	 * Get plan_rt 계획공정율 numeric(null)
	 * @Return Double planRt
	 */
	public Double getPlanRt() {
		return this.planRt;
	}
	
	/**
	 * Set plan_rt 계획공정율 numeric(null)
	 * @Param Double planRt
	 */
	public void setPlanRt(Double planRt) {
		this.planRt = planRt;
	}
	/**
	 * Get real_rt 실적공정율 numeric(null)
	 * @Return Double realRt
	 */
	public Double getRealRt() {
		return this.realRt;
	}
	
	/**
	 * Set real_rt 실적공정율 numeric(null)
	 * @Param Double realRt
	 */
	public void setRealRt(Double realRt) {
		this.realRt = realRt;
	}
	/**
	 * Get per_rt 대비_율 numeric(null)
	 * @Return Double perRt
	 */
	public Double getPerRt() {
		return this.perRt;
	}
	
	/**
	 * Set per_rt 대비_율 numeric(null)
	 * @Param Double perRt
	 */
	public void setPerRt(Double perRt) {
		this.perRt = perRt;
	}
	/**
	 * Get basic_dt 기준_일자 character varying(8)
	 * @Return String basicDt
	 */
	public String getBasicDt() {
		return this.basicDt;
	}
	
	/**
	 * Set basic_dt 기준_일자 character varying(8)
	 * @Param String basicDt
	 */
	public void setBasicDt(String basicDt) {
		this.basicDt = basicDt;
	}
	/**
	 * Get dt1 총_공기 numeric(null)
	 * @Return Double dt1
	 */
	public Double getDt1() {
		return this.dt1;
	}
	
	/**
	 * Set dt1 총_공기 numeric(null)
	 * @Param Double dt1
	 */
	public void setDt1(Double dt1) {
		this.dt1 = dt1;
	}
	/**
	 * Get dt2 경과일 numeric(null)
	 * @Return Double dt2
	 */
	public Double getDt2() {
		return this.dt2;
	}
	
	/**
	 * Set dt2 경과일 numeric(null)
	 * @Param Double dt2
	 */
	public void setDt2(Double dt2) {
		this.dt2 = dt2;
	}
	/**
	 * Get dt3 D-Day numeric(null)
	 * @Return Double dt3
	 */
	public Double getDt3() {
		return this.dt3;
	}
	
	/**
	 * Set dt3 D-Day numeric(null)
	 * @Param Double dt3
	 */
	public void setDt3(Double dt3) {
		this.dt3 = dt3;
	}
	/**
	 * Get tot_cntrt_amt 도급_금액 numeric(null)
	 * @Return Double totCntrtAmt
	 */
	public Double getTotCntrtAmt() {
		return this.totCntrtAmt;
	}
	
	/**
	 * Set tot_cntrt_amt 도급_금액 numeric(null)
	 * @Param Double totCntrtAmt
	 */
	public void setTotCntrtAmt(Double totCntrtAmt) {
		this.totCntrtAmt = totCntrtAmt;
	}
	/**
	 * Get tot_pjt_amt 사업비 numeric(null)
	 * @Return Double totPjtAmt
	 */
	public Double getTotPjtAmt() {
		return this.totPjtAmt;
	}
	
	/**
	 * Set tot_pjt_amt 사업비 numeric(null)
	 * @Param Double totPjtAmt
	 */
	public void setTotPjtAmt(Double totPjtAmt) {
		this.totPjtAmt = totPjtAmt;
	}
	/**
	 * Get du_date 공사기간 character varying(22)
	 * @Return String duDate
	 */
	public String getDuDate() {
		return this.duDate;
	}
	
	/**
	 * Set du_date 공사기간 character varying(22)
	 * @Param String duDate
	 */
	public void setDuDate(String duDate) {
		this.duDate = duDate;
	}
	/**
	 * Get office_addr 공사_위치 character varying(1000)
	 * @Return String officeAddr
	 */
	public String getOfficeAddr() {
		return this.officeAddr;
	}
	
	/**
	 * Set office_addr 공사_위치 character varying(1000)
	 * @Param String officeAddr
	 */
	public void setOfficeAddr(String officeAddr) {
		this.officeAddr = officeAddr;
	}
	/**
	 * Get lat 위도 numeric(null)
	 * @Return Double lat
	 */
	public Double getLat() {
		return this.lat;
	}
	
	/**
	 * Set lat 위도 numeric(null)
	 * @Param Double lat
	 */
	public void setLat(Double lat) {
		this.lat = lat;
	}
	/**
	 * Get lng 경도 numeric(null)
	 * @Return Double lng
	 */
	public Double getLng() {
		return this.lng;
	}
	
	/**
	 * Set lng 경도 numeric(null)
	 * @Param Double lng
	 */
	public void setLng(Double lng) {
		this.lng = lng;
	}
	/**
	 * Get user_1 발주처_담당자_명 character varying(100)
	 * @Return String user1
	 */
	public String getUser1() {
		return this.user1;
	}
	
	/**
	 * Set user_1 발주처_담당자_명 character varying(100)
	 * @Param String user1
	 */
	public void setUser1(String user1) {
		this.user1 = user1;
	}
	/**
	 * Get user_2 책임_감리원_명 character varying(100)
	 * @Return String user2
	 */
	public String getUser2() {
		return this.user2;
	}
	
	/**
	 * Set user_2 책임_감리원_명 character varying(100)
	 * @Param String user2
	 */
	public void setUser2(String user2) {
		this.user2 = user2;
	}
	/**
	 * Get user_3 현장_대리인_명 character varying(100)
	 * @Return String user3
	 */
	public String getUser3() {
		return this.user3;
	}
	
	/**
	 * Set user_3 현장_대리인_명 character varying(100)
	 * @Param String user3
	 */
	public void setUser3(String user3) {
		this.user3 = user3;
	}
	/**
	 * Get org_1 발주처_기관_명 character varying(100)
	 * @Return String org1
	 */
	public String getOrg1() {
		return this.org1;
	}
	
	/**
	 * Set org_1 발주처_기관_명 character varying(100)
	 * @Param String org1
	 */
	public void setOrg1(String org1) {
		this.org1 = org1;
	}
	/**
	 * Get org_2 감리사_업체_명 character varying(100)
	 * @Return String org2
	 */
	public String getOrg2() {
		return this.org2;
	}
	
	/**
	 * Set org_2 감리사_업체_명 character varying(100)
	 * @Param String org2
	 */
	public void setOrg2(String org2) {
		this.org2 = org2;
	}
	/**
	 * Get org_3 시공사_업체_명 character varying(100)
	 * @Return String org3
	 */
	public String getOrg3() {
		return this.org3;
	}
	
	/**
	 * Set org_3 시공사_업체_명 character varying(100)
	 * @Param String org3
	 */
	public void setOrg3(String org3) {
		this.org3 = org3;
	}
	/**
	 * Get pjt_scale 사업규모 character varying(2000)
	 * @Return String pjtScale
	 */
	public String getPjtScale() {
		return this.pjtScale;
	}
	
	/**
	 * Set pjt_scale 사업규모 character varying(2000)
	 * @Param String pjtScale
	 */
	public void setPjtScale(String pjtScale) {
		this.pjtScale = pjtScale;
	}
	/**
	 * Get rtsp_addr 웹카메라_RTSP_주소 character varying(200)
	 * @Return String rtspAddr
	 */
	public String getRtspAddr() {
		return this.rtspAddr;
	}
	
	/**
	 * Set rtsp_addr 웹카메라_RTSP_주소 character varying(200)
	 * @Param String rtspAddr
	 */
	public void setRtspAddr(String rtspAddr) {
		this.rtspAddr = rtspAddr;
	}
	/**
	 * Get cnrt_addr 계약정보_링크_주소 character varying(1000)
	 * @Return String cnrtAddr
	 */
	public String getCnrtAddr() {
		return this.cnrtAddr;
	}
	
	/**
	 * Set cnrt_addr 계약정보_링크_주소 character varying(1000)
	 * @Param String cnrtAddr
	 */
	public void setCnrtAddr(String cnrtAddr) {
		this.cnrtAddr = cnrtAddr;
	}
	/**
	 * Get billpay_addr 집행정보_링크_주소 character varying(1000)
	 * @Return String billpayAddr
	 */
	public String getBillpayAddr() {
		return this.billpayAddr;
	}
	
	/**
	 * Set billpay_addr 집행정보_링크_주소 character varying(1000)
	 * @Param String billpayAddr
	 */
	public void setBillpayAddr(String billpayAddr) {
		this.billpayAddr = billpayAddr;
	}
	/**
	 * Get air_view_img 조감도_이미지_링크_주소 character varying(1000)
	 * @Return String airViewImg
	 */
	public String getAirViewImg() {
		return this.airViewImg;
	}
	
	/**
	 * Set air_view_img 조감도_이미지_링크_주소 character varying(1000)
	 * @Param String airViewImg
	 */
	public void setAirViewImg(String airViewImg) {
		this.airViewImg = airViewImg;
	}
	/**
	 * Get alimi_addr 공사_개요_홈페이지 character varying(1000)
	 * @Return String alimiAddr
	 */
	public String getAlimiAddr() {
		return this.alimiAddr;
	}
	
	/**
	 * Set alimi_addr 공사_개요_홈페이지 character varying(1000)
	 * @Param String alimiAddr
	 */
	public void setAlimiAddr(String alimiAddr) {
		this.alimiAddr = alimiAddr;
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
