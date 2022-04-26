package kr.co.seculink.domain.vo;

import lombok.ToString;

import java.io.Serializable;
/**
 * tc_api_stnd Value Object
 */
 @ToString
public class TcApiStndVo implements Serializable {

	/* svr_id 서버_ID character varying(20) */
	private String svrId;

	/* svr_nm 서버_명 character varying(100) */
	private String svrNm;

	/* api_url API_URL character varying(200) */
	private String apiUrl;

	/* gps_base_cycl GPS정기핑_기본_주기 numeric(null) */
	private Double gpsBaseCycl;

	/* gps_next_cycl GPS정기핑_다음_주기 numeric(null) */
	private Double gpsNextCycl;

	/* rdet_next_cycl 정기판정_다음_주기 numeric(null) */
	private Double rdetNextCycl;

	/* rdet_base_cycl 정기판정_기본_주기 numeric(null) */
	private Double rdetBaseCycl;

	/* led_slep_tcnt LED_슬립_시간 numeric(null) */
	private Double ledSlepTcnt;

	/* msor_ssng_levl 모션센서_감지_레벨 numeric(null) */
	private Double msorSsngLevl;

	/* hsor_isng_cycl 심박센서_내부감지_주기 numeric(null) */
	private Double hsorIsngCycl;

	/* tsor_isng_cycl 체온센서_내부감지_주기 numeric(null) */
	private Double tsorIsngCycl;

	/* tsor_evnt_minval 체온센서_이벤트_하한값 numeric(null) */
	private Double tsorEvntMinval;

	/* tsor_evnt_maxval 체온센서_이벤트_상한값 numeric(null) */
	private Double tsorEvntMaxval;

	/* hbitcnt_mdan_minval 심박수_중간값_하한값 numeric(null) */
	private Double hbitcntMdanMinval;

	/* hbitcnt_mdan_maxval 심박수_중간값_상한값 numeric(null) */
	private Double hbitcntMdanMaxval;

	/* msor_evnt_minval 모션센서_이벤트_하한값 numeric(null) */
	private Double msorEvntMinval;

	/* msor_evnt_maxval 모션센서_이벤트_상한값 numeric(null) */
	private Double msorEvntMaxval;

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
	 * Get svr_id 서버_ID character varying(20)
	 * @Return String svrId
	 */
	public String getSvrId() {
		return this.svrId;
	}
	
	/**
	 * Set svr_id 서버_ID character varying(20)
	 * @Param String svrId
	 */
	public void setSvrId(String svrId) {
		this.svrId = svrId;
	}
	/**
	 * Get svr_nm 서버_명 character varying(100)
	 * @Return String svrNm
	 */
	public String getSvrNm() {
		return this.svrNm;
	}
	
	/**
	 * Set svr_nm 서버_명 character varying(100)
	 * @Param String svrNm
	 */
	public void setSvrNm(String svrNm) {
		this.svrNm = svrNm;
	}
	/**
	 * Get api_url API_URL character varying(200)
	 * @Return String apiUrl
	 */
	public String getApiUrl() {
		return this.apiUrl;
	}
	
	/**
	 * Set api_url API_URL character varying(200)
	 * @Param String apiUrl
	 */
	public void setApiUrl(String apiUrl) {
		this.apiUrl = apiUrl;
	}
	/**
	 * Get gps_base_cycl GPS정기핑_기본_주기 numeric(null)
	 * @Return Double gpsBaseCycl
	 */
	public Double getGpsBaseCycl() {
		return this.gpsBaseCycl;
	}
	
	/**
	 * Set gps_base_cycl GPS정기핑_기본_주기 numeric(null)
	 * @Param Double gpsBaseCycl
	 */
	public void setGpsBaseCycl(Double gpsBaseCycl) {
		this.gpsBaseCycl = gpsBaseCycl;
	}
	/**
	 * Get gps_next_cycl GPS정기핑_다음_주기 numeric(null)
	 * @Return Double gpsNextCycl
	 */
	public Double getGpsNextCycl() {
		return this.gpsNextCycl;
	}
	
	/**
	 * Set gps_next_cycl GPS정기핑_다음_주기 numeric(null)
	 * @Param Double gpsNextCycl
	 */
	public void setGpsNextCycl(Double gpsNextCycl) {
		this.gpsNextCycl = gpsNextCycl;
	}
	/**
	 * Get rdet_next_cycl 정기판정_다음_주기 numeric(null)
	 * @Return Double rdetNextCycl
	 */
	public Double getRdetNextCycl() {
		return this.rdetNextCycl;
	}
	
	/**
	 * Set rdet_next_cycl 정기판정_다음_주기 numeric(null)
	 * @Param Double rdetNextCycl
	 */
	public void setRdetNextCycl(Double rdetNextCycl) {
		this.rdetNextCycl = rdetNextCycl;
	}
	/**
	 * Get rdet_base_cycl 정기판정_기본_주기 numeric(null)
	 * @Return Double rdetBaseCycl
	 */
	public Double getRdetBaseCycl() {
		return this.rdetBaseCycl;
	}
	
	/**
	 * Set rdet_base_cycl 정기판정_기본_주기 numeric(null)
	 * @Param Double rdetBaseCycl
	 */
	public void setRdetBaseCycl(Double rdetBaseCycl) {
		this.rdetBaseCycl = rdetBaseCycl;
	}
	/**
	 * Get led_slep_tcnt LED_슬립_시간 numeric(null)
	 * @Return Double ledSlepTcnt
	 */
	public Double getLedSlepTcnt() {
		return this.ledSlepTcnt;
	}
	
	/**
	 * Set led_slep_tcnt LED_슬립_시간 numeric(null)
	 * @Param Double ledSlepTcnt
	 */
	public void setLedSlepTcnt(Double ledSlepTcnt) {
		this.ledSlepTcnt = ledSlepTcnt;
	}
	/**
	 * Get msor_ssng_levl 모션센서_감지_레벨 numeric(null)
	 * @Return Double msorSsngLevl
	 */
	public Double getMsorSsngLevl() {
		return this.msorSsngLevl;
	}
	
	/**
	 * Set msor_ssng_levl 모션센서_감지_레벨 numeric(null)
	 * @Param Double msorSsngLevl
	 */
	public void setMsorSsngLevl(Double msorSsngLevl) {
		this.msorSsngLevl = msorSsngLevl;
	}
	/**
	 * Get hsor_isng_cycl 심박센서_내부감지_주기 numeric(null)
	 * @Return Double hsorIsngCycl
	 */
	public Double getHsorIsngCycl() {
		return this.hsorIsngCycl;
	}
	
	/**
	 * Set hsor_isng_cycl 심박센서_내부감지_주기 numeric(null)
	 * @Param Double hsorIsngCycl
	 */
	public void setHsorIsngCycl(Double hsorIsngCycl) {
		this.hsorIsngCycl = hsorIsngCycl;
	}
	/**
	 * Get tsor_isng_cycl 체온센서_내부감지_주기 numeric(null)
	 * @Return Double tsorIsngCycl
	 */
	public Double getTsorIsngCycl() {
		return this.tsorIsngCycl;
	}
	
	/**
	 * Set tsor_isng_cycl 체온센서_내부감지_주기 numeric(null)
	 * @Param Double tsorIsngCycl
	 */
	public void setTsorIsngCycl(Double tsorIsngCycl) {
		this.tsorIsngCycl = tsorIsngCycl;
	}
	/**
	 * Get tsor_evnt_minval 체온센서_이벤트_하한값 numeric(null)
	 * @Return Double tsorEvntMinval
	 */
	public Double getTsorEvntMinval() {
		return this.tsorEvntMinval;
	}
	
	/**
	 * Set tsor_evnt_minval 체온센서_이벤트_하한값 numeric(null)
	 * @Param Double tsorEvntMinval
	 */
	public void setTsorEvntMinval(Double tsorEvntMinval) {
		this.tsorEvntMinval = tsorEvntMinval;
	}
	/**
	 * Get tsor_evnt_maxval 체온센서_이벤트_상한값 numeric(null)
	 * @Return Double tsorEvntMaxval
	 */
	public Double getTsorEvntMaxval() {
		return this.tsorEvntMaxval;
	}
	
	/**
	 * Set tsor_evnt_maxval 체온센서_이벤트_상한값 numeric(null)
	 * @Param Double tsorEvntMaxval
	 */
	public void setTsorEvntMaxval(Double tsorEvntMaxval) {
		this.tsorEvntMaxval = tsorEvntMaxval;
	}
	/**
	 * Get hbitcnt_mdan_minval 심박수_중간값_하한값 numeric(null)
	 * @Return Double hbitcntMdanMinval
	 */
	public Double getHbitcntMdanMinval() {
		return this.hbitcntMdanMinval;
	}
	
	/**
	 * Set hbitcnt_mdan_minval 심박수_중간값_하한값 numeric(null)
	 * @Param Double hbitcntMdanMinval
	 */
	public void setHbitcntMdanMinval(Double hbitcntMdanMinval) {
		this.hbitcntMdanMinval = hbitcntMdanMinval;
	}
	/**
	 * Get hbitcnt_mdan_maxval 심박수_중간값_상한값 numeric(null)
	 * @Return Double hbitcntMdanMaxval
	 */
	public Double getHbitcntMdanMaxval() {
		return this.hbitcntMdanMaxval;
	}
	
	/**
	 * Set hbitcnt_mdan_maxval 심박수_중간값_상한값 numeric(null)
	 * @Param Double hbitcntMdanMaxval
	 */
	public void setHbitcntMdanMaxval(Double hbitcntMdanMaxval) {
		this.hbitcntMdanMaxval = hbitcntMdanMaxval;
	}
	/**
	 * Get msor_evnt_minval 모션센서_이벤트_하한값 numeric(null)
	 * @Return Double msorEvntMinval
	 */
	public Double getMsorEvntMinval() {
		return this.msorEvntMinval;
	}
	
	/**
	 * Set msor_evnt_minval 모션센서_이벤트_하한값 numeric(null)
	 * @Param Double msorEvntMinval
	 */
	public void setMsorEvntMinval(Double msorEvntMinval) {
		this.msorEvntMinval = msorEvntMinval;
	}
	/**
	 * Get msor_evnt_maxval 모션센서_이벤트_상한값 numeric(null)
	 * @Return Double msorEvntMaxval
	 */
	public Double getMsorEvntMaxval() {
		return this.msorEvntMaxval;
	}
	
	/**
	 * Set msor_evnt_maxval 모션센서_이벤트_상한값 numeric(null)
	 * @Param Double msorEvntMaxval
	 */
	public void setMsorEvntMaxval(Double msorEvntMaxval) {
		this.msorEvntMaxval = msorEvntMaxval;
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
