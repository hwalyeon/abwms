package kr.co.seculink.domain.vo;

import java.io.Serializable;
import lombok.ToString;
/**
 * ts_dzone_data_04 Value Object
 */
 @ToString
public class TsDzoneData04Vo implements Serializable {

	/* job_dt 작업_일자 character(8) */
	private String jobDt;

	/* seq 순번 numeric(null) */
	private Double seq;

	/* cnstrc_no 계약_번호 numeric(null) */
	private Double cnstrcNo;

	/* cnstrc_nm 공사_명 character varying(200) */
	private String cnstrcNm;

	/* ddays 공정_현황 numeric(null) */
	private Double ddays;

	/* totdays 공정현황_총공기 numeric(null) */
	private Double totdays;

	/* pastdays 공정현황_경과일 numeric(null) */
	private Double pastdays;

	/* acmslt_rt 총공정률 numeric(null) */
	private Double acmsltRt;

	/* plan_rt 공정현황_계획 numeric(null) */
	private Double planRt;

	/* achiv_rt 공정_현황_달성 numeric(null) */
	private Double achivRt;

	/* bsr 사업분야 character varying(3) */
	private String bsr;

	/* cnstrc_lc 공사위치 character varying(3000) */
	private String cnstrcLc;

	/* bgnde 공사기간_시작 character varying(50) */
	private String bgnde;

	/* endde 공사기간_끝 character varying(50) */
	private String endde;

	/* sumry 사업개요 character varying(4000) */
	private String sumry;

	/* prtn_dept 추진_부서 character varying(3) */
	private String prtnDept;

	/* charger_nm 담당자 character varying(200) */
	private String chargerNm;

	/* charger_telno 전화번호 character varying(200) */
	private String chargerTelno;

	/* sprvisor 감리사 character varying(1000) */
	private String sprvisor;

	/* wct 사업비 character varying(100) */
	private String wct;

	/* cnstrtr 시공사 character varying(1000) */
	private String cnstrtr;

	/* marker_x MARKER_X character varying(20) */
	private String markerX;

	/* marker_y MARKER_Y character varying(20) */
	private String markerY;

	/* marker_s MARKER_S character varying(4000) */
	private String markerS;

	/* marker_p MARKER_P character varying(4000) */
	private String markerP;

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
	 * Get cnstrc_no 계약_번호 numeric(null)
	 * @Return Double cnstrcNo
	 */
	public Double getCnstrcNo() {
		return this.cnstrcNo;
	}
	
	/**
	 * Set cnstrc_no 계약_번호 numeric(null)
	 * @Param Double cnstrcNo
	 */
	public void setCnstrcNo(Double cnstrcNo) {
		this.cnstrcNo = cnstrcNo;
	}
	/**
	 * Get cnstrc_nm 공사_명 character varying(200)
	 * @Return String cnstrcNm
	 */
	public String getCnstrcNm() {
		return this.cnstrcNm;
	}
	
	/**
	 * Set cnstrc_nm 공사_명 character varying(200)
	 * @Param String cnstrcNm
	 */
	public void setCnstrcNm(String cnstrcNm) {
		this.cnstrcNm = cnstrcNm;
	}
	/**
	 * Get ddays 공정_현황 numeric(null)
	 * @Return Double ddays
	 */
	public Double getDdays() {
		return this.ddays;
	}
	
	/**
	 * Set ddays 공정_현황 numeric(null)
	 * @Param Double ddays
	 */
	public void setDdays(Double ddays) {
		this.ddays = ddays;
	}
	/**
	 * Get totdays 공정현황_총공기 numeric(null)
	 * @Return Double totdays
	 */
	public Double getTotdays() {
		return this.totdays;
	}
	
	/**
	 * Set totdays 공정현황_총공기 numeric(null)
	 * @Param Double totdays
	 */
	public void setTotdays(Double totdays) {
		this.totdays = totdays;
	}
	/**
	 * Get pastdays 공정현황_경과일 numeric(null)
	 * @Return Double pastdays
	 */
	public Double getPastdays() {
		return this.pastdays;
	}
	
	/**
	 * Set pastdays 공정현황_경과일 numeric(null)
	 * @Param Double pastdays
	 */
	public void setPastdays(Double pastdays) {
		this.pastdays = pastdays;
	}
	/**
	 * Get acmslt_rt 총공정률 numeric(null)
	 * @Return Double acmsltRt
	 */
	public Double getAcmsltRt() {
		return this.acmsltRt;
	}
	
	/**
	 * Set acmslt_rt 총공정률 numeric(null)
	 * @Param Double acmsltRt
	 */
	public void setAcmsltRt(Double acmsltRt) {
		this.acmsltRt = acmsltRt;
	}
	/**
	 * Get plan_rt 공정현황_계획 numeric(null)
	 * @Return Double planRt
	 */
	public Double getPlanRt() {
		return this.planRt;
	}
	
	/**
	 * Set plan_rt 공정현황_계획 numeric(null)
	 * @Param Double planRt
	 */
	public void setPlanRt(Double planRt) {
		this.planRt = planRt;
	}
	/**
	 * Get achiv_rt 공정_현황_달성 numeric(null)
	 * @Return Double achivRt
	 */
	public Double getAchivRt() {
		return this.achivRt;
	}
	
	/**
	 * Set achiv_rt 공정_현황_달성 numeric(null)
	 * @Param Double achivRt
	 */
	public void setAchivRt(Double achivRt) {
		this.achivRt = achivRt;
	}
	/**
	 * Get bsr 사업분야 character varying(3)
	 * @Return String bsr
	 */
	public String getBsr() {
		return this.bsr;
	}
	
	/**
	 * Set bsr 사업분야 character varying(3)
	 * @Param String bsr
	 */
	public void setBsr(String bsr) {
		this.bsr = bsr;
	}
	/**
	 * Get cnstrc_lc 공사위치 character varying(3000)
	 * @Return String cnstrcLc
	 */
	public String getCnstrcLc() {
		return this.cnstrcLc;
	}
	
	/**
	 * Set cnstrc_lc 공사위치 character varying(3000)
	 * @Param String cnstrcLc
	 */
	public void setCnstrcLc(String cnstrcLc) {
		this.cnstrcLc = cnstrcLc;
	}
	/**
	 * Get bgnde 공사기간_시작 character varying(50)
	 * @Return String bgnde
	 */
	public String getBgnde() {
		return this.bgnde;
	}
	
	/**
	 * Set bgnde 공사기간_시작 character varying(50)
	 * @Param String bgnde
	 */
	public void setBgnde(String bgnde) {
		this.bgnde = bgnde;
	}
	/**
	 * Get endde 공사기간_끝 character varying(50)
	 * @Return String endde
	 */
	public String getEndde() {
		return this.endde;
	}
	
	/**
	 * Set endde 공사기간_끝 character varying(50)
	 * @Param String endde
	 */
	public void setEndde(String endde) {
		this.endde = endde;
	}
	/**
	 * Get sumry 사업개요 character varying(4000)
	 * @Return String sumry
	 */
	public String getSumry() {
		return this.sumry;
	}
	
	/**
	 * Set sumry 사업개요 character varying(4000)
	 * @Param String sumry
	 */
	public void setSumry(String sumry) {
		this.sumry = sumry;
	}
	/**
	 * Get prtn_dept 추진_부서 character varying(3)
	 * @Return String prtnDept
	 */
	public String getPrtnDept() {
		return this.prtnDept;
	}
	
	/**
	 * Set prtn_dept 추진_부서 character varying(3)
	 * @Param String prtnDept
	 */
	public void setPrtnDept(String prtnDept) {
		this.prtnDept = prtnDept;
	}
	/**
	 * Get charger_nm 담당자 character varying(200)
	 * @Return String chargerNm
	 */
	public String getChargerNm() {
		return this.chargerNm;
	}
	
	/**
	 * Set charger_nm 담당자 character varying(200)
	 * @Param String chargerNm
	 */
	public void setChargerNm(String chargerNm) {
		this.chargerNm = chargerNm;
	}
	/**
	 * Get charger_telno 전화번호 character varying(200)
	 * @Return String chargerTelno
	 */
	public String getChargerTelno() {
		return this.chargerTelno;
	}
	
	/**
	 * Set charger_telno 전화번호 character varying(200)
	 * @Param String chargerTelno
	 */
	public void setChargerTelno(String chargerTelno) {
		this.chargerTelno = chargerTelno;
	}
	/**
	 * Get sprvisor 감리사 character varying(1000)
	 * @Return String sprvisor
	 */
	public String getSprvisor() {
		return this.sprvisor;
	}
	
	/**
	 * Set sprvisor 감리사 character varying(1000)
	 * @Param String sprvisor
	 */
	public void setSprvisor(String sprvisor) {
		this.sprvisor = sprvisor;
	}
	/**
	 * Get wct 사업비 character varying(100)
	 * @Return String wct
	 */
	public String getWct() {
		return this.wct;
	}
	
	/**
	 * Set wct 사업비 character varying(100)
	 * @Param String wct
	 */
	public void setWct(String wct) {
		this.wct = wct;
	}
	/**
	 * Get cnstrtr 시공사 character varying(1000)
	 * @Return String cnstrtr
	 */
	public String getCnstrtr() {
		return this.cnstrtr;
	}
	
	/**
	 * Set cnstrtr 시공사 character varying(1000)
	 * @Param String cnstrtr
	 */
	public void setCnstrtr(String cnstrtr) {
		this.cnstrtr = cnstrtr;
	}
	/**
	 * Get marker_x MARKER_X character varying(20)
	 * @Return String markerX
	 */
	public String getMarkerX() {
		return this.markerX;
	}
	
	/**
	 * Set marker_x MARKER_X character varying(20)
	 * @Param String markerX
	 */
	public void setMarkerX(String markerX) {
		this.markerX = markerX;
	}
	/**
	 * Get marker_y MARKER_Y character varying(20)
	 * @Return String markerY
	 */
	public String getMarkerY() {
		return this.markerY;
	}
	
	/**
	 * Set marker_y MARKER_Y character varying(20)
	 * @Param String markerY
	 */
	public void setMarkerY(String markerY) {
		this.markerY = markerY;
	}
	/**
	 * Get marker_s MARKER_S character varying(4000)
	 * @Return String markerS
	 */
	public String getMarkerS() {
		return this.markerS;
	}
	
	/**
	 * Set marker_s MARKER_S character varying(4000)
	 * @Param String markerS
	 */
	public void setMarkerS(String markerS) {
		this.markerS = markerS;
	}
	/**
	 * Get marker_p MARKER_P character varying(4000)
	 * @Return String markerP
	 */
	public String getMarkerP() {
		return this.markerP;
	}
	
	/**
	 * Set marker_p MARKER_P character varying(4000)
	 * @Param String markerP
	 */
	public void setMarkerP(String markerP) {
		this.markerP = markerP;
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
