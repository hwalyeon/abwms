package kr.co.seculink.domain.vo;

import java.io.Serializable;
import lombok.ToString;
/**
 * ts_dzone_data_07 Value Object
 */
 @ToString
public class TsDzoneData07Vo implements Serializable {

	/* job_dt 작업_일자 character(8) */
	private String jobDt;

	/* seq 순번 numeric(null) */
	private Double seq;

	/* opn_svc_nm 개방_서비스_명 character varying(100) */
	private String opnSvcNm;

	/* opn_svc_id 개방_서비스_아이디 character varying(20) */
	private String opnSvcId;

	/* opn_mncplty_cd 개방_자치단체_코드 character varying(20) */
	private String opnMncpltyCd;

	/* mngno 관리번호 character varying(40) */
	private String mngno;

	/* lcns_dt 인허가_일자 character varying(8) */
	private String lcnsDt;

	/* lcns_cncl_dt 인허가_취소_일자 character varying(8) */
	private String lcnsCnclDt;

	/* bs_stat_div_cd 영업_상태_구분_코드 character varying(1) */
	private String bsStatDivCd;

	/* bs_stat 영업_상태 character varying(20) */
	private String bsStat;

	/* spec_bs_stat_cd 상세_영업_상태_코드 character varying(1) */
	private String specBsStatCd;

	/* spec_bs_stat_nm 상세_영업_상태_명 character varying(20) */
	private String specBsStatNm;

	/* close_dt 폐업_일자 character varying(8) */
	private String closeDt;

	/* clsing_strt_dt 휴업_시작_일자 character varying(8) */
	private String clsingStrtDt;

	/* clsing_end_dt 휴업_종료_일자 character varying(8) */
	private String clsingEndDt;

	/* reopen_dt 재개업_일자 character varying(8) */
	private String reopenDt;

	/* loc_tel 소재지_전화 character varying(20) */
	private String locTel;

	/* loc_sqre 소재지_면적 character varying(20) */
	private String locSqre;

	/* loc_pstno 소재지_우편번호 character varying(6) */
	private String locPstno;

	/* loc_whole_addr 소재지_전체+주소 character varying(500) */
	private String locWholeAddr;

	/* road_whole_addr 도로명_전체_주소 character varying(500) */
	private String roadWholeAddr;

	/* road_pstno 도로명_우편번호 character varying(5) */
	private String roadPstno;

	/* bsplc_nm 사업장_명 character varying(300) */
	private String bsplcNm;

	/* last_upt_ptme 최종_수정_시점 character varying(14) */
	private String lastUptPtme;

	/* data_rnwl_div 데이터_갱신_구분 character varying(1) */
	private String dataRnwlDiv;

	/* data_rnwl_dt 데이터_갱신_일자 character varying(20) */
	private String dataRnwlDt;

	/* biz_cond_div_nm 업태_구분_명 character varying(20) */
	private String bizCondDivNm;

	/* cood_info_x 좌표_정보_X numeric(null) */
	private Double coodInfoX;

	/* cood_info_y 좌표_정보_Y numeric(null) */
	private Double coodInfoY;

	/* hygn_biz_cond_nm 위생_업태_명 character varying(20) */
	private String hygnBizCondNm;

	/* male_prctn_cnt 남성_종사자_수 numeric(null) */
	private Double malePrctnCnt;

	/* female_prctn_cnt 여성_종사자_수 numeric(null) */
	private Double femalePrctnCnt;

	/* bsnpc_arnd_div_nm 영업장_주변_구분_명 character varying(200) */
	private String bsnpcArndDivNm;

	/* rank_div_nm 등급_구분_명 character varying(20) */
	private String rankDivNm;

	/* rating_fclty_div_nm 급수_시설_구분_명 character varying(200) */
	private String ratingFcltyDivNm;

	/* tot_empl_cnt 총_종업원_수 numeric(null) */
	private Double totEmplCnt;

	/* hoffice_empl_cnt 본사_종업원_수 numeric(null) */
	private Double hofficeEmplCnt;

	/* fact_clrk_empl_cnt 공장_사무직_종업원_수 numeric(null) */
	private Double factClrkEmplCnt;

	/* fact_saljb_empl_cnt 공장_판매직_종업원_수 numeric(null) */
	private Double factSaljbEmplCnt;

	/* fact_prdj_empl_cnt 공장_생산직_종업원_수 numeric(null) */
	private Double factPrdjEmplCnt;

	/* build_posse_div_nm 건물_소유_구분_명 character varying(100) */
	private String buildPosseDivNm;

	/* grnt_amt 보증_금액 numeric(null) */
	private Double grntAmt;

	/* mrent_amt 월세_금액 numeric(null) */
	private Double mrentAmt;

	/* multi_use_busi_yn 다중_이용_업소_여부 character varying(1) */
	private String multiUseBusiYn;

	/* fclty_tot_scal 시설_총_규모 numeric(null) */
	private Double fcltyTotScal;

	/* trdtn_busi_apnt_no 전통_업소_지정_번호 character varying(40) */
	private String trdtnBusiApntNo;

	/* trdtn_busi_main_food 전통_업소_주된_음식 character varying(20) */
	private String trdtnBusiMainFood;

	/* hpge 홈페이지 character varying(200) */
	private String hpge;

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
	 * Get opn_svc_nm 개방_서비스_명 character varying(100)
	 * @Return String opnSvcNm
	 */
	public String getOpnSvcNm() {
		return this.opnSvcNm;
	}
	
	/**
	 * Set opn_svc_nm 개방_서비스_명 character varying(100)
	 * @Param String opnSvcNm
	 */
	public void setOpnSvcNm(String opnSvcNm) {
		this.opnSvcNm = opnSvcNm;
	}
	/**
	 * Get opn_svc_id 개방_서비스_아이디 character varying(20)
	 * @Return String opnSvcId
	 */
	public String getOpnSvcId() {
		return this.opnSvcId;
	}
	
	/**
	 * Set opn_svc_id 개방_서비스_아이디 character varying(20)
	 * @Param String opnSvcId
	 */
	public void setOpnSvcId(String opnSvcId) {
		this.opnSvcId = opnSvcId;
	}
	/**
	 * Get opn_mncplty_cd 개방_자치단체_코드 character varying(20)
	 * @Return String opnMncpltyCd
	 */
	public String getOpnMncpltyCd() {
		return this.opnMncpltyCd;
	}
	
	/**
	 * Set opn_mncplty_cd 개방_자치단체_코드 character varying(20)
	 * @Param String opnMncpltyCd
	 */
	public void setOpnMncpltyCd(String opnMncpltyCd) {
		this.opnMncpltyCd = opnMncpltyCd;
	}
	/**
	 * Get mngno 관리번호 character varying(40)
	 * @Return String mngno
	 */
	public String getMngno() {
		return this.mngno;
	}
	
	/**
	 * Set mngno 관리번호 character varying(40)
	 * @Param String mngno
	 */
	public void setMngno(String mngno) {
		this.mngno = mngno;
	}
	/**
	 * Get lcns_dt 인허가_일자 character varying(8)
	 * @Return String lcnsDt
	 */
	public String getLcnsDt() {
		return this.lcnsDt;
	}
	
	/**
	 * Set lcns_dt 인허가_일자 character varying(8)
	 * @Param String lcnsDt
	 */
	public void setLcnsDt(String lcnsDt) {
		this.lcnsDt = lcnsDt;
	}
	/**
	 * Get lcns_cncl_dt 인허가_취소_일자 character varying(8)
	 * @Return String lcnsCnclDt
	 */
	public String getLcnsCnclDt() {
		return this.lcnsCnclDt;
	}
	
	/**
	 * Set lcns_cncl_dt 인허가_취소_일자 character varying(8)
	 * @Param String lcnsCnclDt
	 */
	public void setLcnsCnclDt(String lcnsCnclDt) {
		this.lcnsCnclDt = lcnsCnclDt;
	}
	/**
	 * Get bs_stat_div_cd 영업_상태_구분_코드 character varying(1)
	 * @Return String bsStatDivCd
	 */
	public String getBsStatDivCd() {
		return this.bsStatDivCd;
	}
	
	/**
	 * Set bs_stat_div_cd 영업_상태_구분_코드 character varying(1)
	 * @Param String bsStatDivCd
	 */
	public void setBsStatDivCd(String bsStatDivCd) {
		this.bsStatDivCd = bsStatDivCd;
	}
	/**
	 * Get bs_stat 영업_상태 character varying(20)
	 * @Return String bsStat
	 */
	public String getBsStat() {
		return this.bsStat;
	}
	
	/**
	 * Set bs_stat 영업_상태 character varying(20)
	 * @Param String bsStat
	 */
	public void setBsStat(String bsStat) {
		this.bsStat = bsStat;
	}
	/**
	 * Get spec_bs_stat_cd 상세_영업_상태_코드 character varying(1)
	 * @Return String specBsStatCd
	 */
	public String getSpecBsStatCd() {
		return this.specBsStatCd;
	}
	
	/**
	 * Set spec_bs_stat_cd 상세_영업_상태_코드 character varying(1)
	 * @Param String specBsStatCd
	 */
	public void setSpecBsStatCd(String specBsStatCd) {
		this.specBsStatCd = specBsStatCd;
	}
	/**
	 * Get spec_bs_stat_nm 상세_영업_상태_명 character varying(20)
	 * @Return String specBsStatNm
	 */
	public String getSpecBsStatNm() {
		return this.specBsStatNm;
	}
	
	/**
	 * Set spec_bs_stat_nm 상세_영업_상태_명 character varying(20)
	 * @Param String specBsStatNm
	 */
	public void setSpecBsStatNm(String specBsStatNm) {
		this.specBsStatNm = specBsStatNm;
	}
	/**
	 * Get close_dt 폐업_일자 character varying(8)
	 * @Return String closeDt
	 */
	public String getCloseDt() {
		return this.closeDt;
	}
	
	/**
	 * Set close_dt 폐업_일자 character varying(8)
	 * @Param String closeDt
	 */
	public void setCloseDt(String closeDt) {
		this.closeDt = closeDt;
	}
	/**
	 * Get clsing_strt_dt 휴업_시작_일자 character varying(8)
	 * @Return String clsingStrtDt
	 */
	public String getClsingStrtDt() {
		return this.clsingStrtDt;
	}
	
	/**
	 * Set clsing_strt_dt 휴업_시작_일자 character varying(8)
	 * @Param String clsingStrtDt
	 */
	public void setClsingStrtDt(String clsingStrtDt) {
		this.clsingStrtDt = clsingStrtDt;
	}
	/**
	 * Get clsing_end_dt 휴업_종료_일자 character varying(8)
	 * @Return String clsingEndDt
	 */
	public String getClsingEndDt() {
		return this.clsingEndDt;
	}
	
	/**
	 * Set clsing_end_dt 휴업_종료_일자 character varying(8)
	 * @Param String clsingEndDt
	 */
	public void setClsingEndDt(String clsingEndDt) {
		this.clsingEndDt = clsingEndDt;
	}
	/**
	 * Get reopen_dt 재개업_일자 character varying(8)
	 * @Return String reopenDt
	 */
	public String getReopenDt() {
		return this.reopenDt;
	}
	
	/**
	 * Set reopen_dt 재개업_일자 character varying(8)
	 * @Param String reopenDt
	 */
	public void setReopenDt(String reopenDt) {
		this.reopenDt = reopenDt;
	}
	/**
	 * Get loc_tel 소재지_전화 character varying(20)
	 * @Return String locTel
	 */
	public String getLocTel() {
		return this.locTel;
	}
	
	/**
	 * Set loc_tel 소재지_전화 character varying(20)
	 * @Param String locTel
	 */
	public void setLocTel(String locTel) {
		this.locTel = locTel;
	}
	/**
	 * Get loc_sqre 소재지_면적 character varying(20)
	 * @Return String locSqre
	 */
	public String getLocSqre() {
		return this.locSqre;
	}
	
	/**
	 * Set loc_sqre 소재지_면적 character varying(20)
	 * @Param String locSqre
	 */
	public void setLocSqre(String locSqre) {
		this.locSqre = locSqre;
	}
	/**
	 * Get loc_pstno 소재지_우편번호 character varying(6)
	 * @Return String locPstno
	 */
	public String getLocPstno() {
		return this.locPstno;
	}
	
	/**
	 * Set loc_pstno 소재지_우편번호 character varying(6)
	 * @Param String locPstno
	 */
	public void setLocPstno(String locPstno) {
		this.locPstno = locPstno;
	}
	/**
	 * Get loc_whole_addr 소재지_전체+주소 character varying(500)
	 * @Return String locWholeAddr
	 */
	public String getLocWholeAddr() {
		return this.locWholeAddr;
	}
	
	/**
	 * Set loc_whole_addr 소재지_전체+주소 character varying(500)
	 * @Param String locWholeAddr
	 */
	public void setLocWholeAddr(String locWholeAddr) {
		this.locWholeAddr = locWholeAddr;
	}
	/**
	 * Get road_whole_addr 도로명_전체_주소 character varying(500)
	 * @Return String roadWholeAddr
	 */
	public String getRoadWholeAddr() {
		return this.roadWholeAddr;
	}
	
	/**
	 * Set road_whole_addr 도로명_전체_주소 character varying(500)
	 * @Param String roadWholeAddr
	 */
	public void setRoadWholeAddr(String roadWholeAddr) {
		this.roadWholeAddr = roadWholeAddr;
	}
	/**
	 * Get road_pstno 도로명_우편번호 character varying(5)
	 * @Return String roadPstno
	 */
	public String getRoadPstno() {
		return this.roadPstno;
	}
	
	/**
	 * Set road_pstno 도로명_우편번호 character varying(5)
	 * @Param String roadPstno
	 */
	public void setRoadPstno(String roadPstno) {
		this.roadPstno = roadPstno;
	}
	/**
	 * Get bsplc_nm 사업장_명 character varying(300)
	 * @Return String bsplcNm
	 */
	public String getBsplcNm() {
		return this.bsplcNm;
	}
	
	/**
	 * Set bsplc_nm 사업장_명 character varying(300)
	 * @Param String bsplcNm
	 */
	public void setBsplcNm(String bsplcNm) {
		this.bsplcNm = bsplcNm;
	}
	/**
	 * Get last_upt_ptme 최종_수정_시점 character varying(14)
	 * @Return String lastUptPtme
	 */
	public String getLastUptPtme() {
		return this.lastUptPtme;
	}
	
	/**
	 * Set last_upt_ptme 최종_수정_시점 character varying(14)
	 * @Param String lastUptPtme
	 */
	public void setLastUptPtme(String lastUptPtme) {
		this.lastUptPtme = lastUptPtme;
	}
	/**
	 * Get data_rnwl_div 데이터_갱신_구분 character varying(1)
	 * @Return String dataRnwlDiv
	 */
	public String getDataRnwlDiv() {
		return this.dataRnwlDiv;
	}
	
	/**
	 * Set data_rnwl_div 데이터_갱신_구분 character varying(1)
	 * @Param String dataRnwlDiv
	 */
	public void setDataRnwlDiv(String dataRnwlDiv) {
		this.dataRnwlDiv = dataRnwlDiv;
	}
	/**
	 * Get data_rnwl_dt 데이터_갱신_일자 character varying(20)
	 * @Return String dataRnwlDt
	 */
	public String getDataRnwlDt() {
		return this.dataRnwlDt;
	}
	
	/**
	 * Set data_rnwl_dt 데이터_갱신_일자 character varying(20)
	 * @Param String dataRnwlDt
	 */
	public void setDataRnwlDt(String dataRnwlDt) {
		this.dataRnwlDt = dataRnwlDt;
	}
	/**
	 * Get biz_cond_div_nm 업태_구분_명 character varying(20)
	 * @Return String bizCondDivNm
	 */
	public String getBizCondDivNm() {
		return this.bizCondDivNm;
	}
	
	/**
	 * Set biz_cond_div_nm 업태_구분_명 character varying(20)
	 * @Param String bizCondDivNm
	 */
	public void setBizCondDivNm(String bizCondDivNm) {
		this.bizCondDivNm = bizCondDivNm;
	}
	/**
	 * Get cood_info_x 좌표_정보_X numeric(null)
	 * @Return Double coodInfoX
	 */
	public Double getCoodInfoX() {
		return this.coodInfoX;
	}
	
	/**
	 * Set cood_info_x 좌표_정보_X numeric(null)
	 * @Param Double coodInfoX
	 */
	public void setCoodInfoX(Double coodInfoX) {
		this.coodInfoX = coodInfoX;
	}
	/**
	 * Get cood_info_y 좌표_정보_Y numeric(null)
	 * @Return Double coodInfoY
	 */
	public Double getCoodInfoY() {
		return this.coodInfoY;
	}
	
	/**
	 * Set cood_info_y 좌표_정보_Y numeric(null)
	 * @Param Double coodInfoY
	 */
	public void setCoodInfoY(Double coodInfoY) {
		this.coodInfoY = coodInfoY;
	}
	/**
	 * Get hygn_biz_cond_nm 위생_업태_명 character varying(20)
	 * @Return String hygnBizCondNm
	 */
	public String getHygnBizCondNm() {
		return this.hygnBizCondNm;
	}
	
	/**
	 * Set hygn_biz_cond_nm 위생_업태_명 character varying(20)
	 * @Param String hygnBizCondNm
	 */
	public void setHygnBizCondNm(String hygnBizCondNm) {
		this.hygnBizCondNm = hygnBizCondNm;
	}
	/**
	 * Get male_prctn_cnt 남성_종사자_수 numeric(null)
	 * @Return Double malePrctnCnt
	 */
	public Double getMalePrctnCnt() {
		return this.malePrctnCnt;
	}
	
	/**
	 * Set male_prctn_cnt 남성_종사자_수 numeric(null)
	 * @Param Double malePrctnCnt
	 */
	public void setMalePrctnCnt(Double malePrctnCnt) {
		this.malePrctnCnt = malePrctnCnt;
	}
	/**
	 * Get female_prctn_cnt 여성_종사자_수 numeric(null)
	 * @Return Double femalePrctnCnt
	 */
	public Double getFemalePrctnCnt() {
		return this.femalePrctnCnt;
	}
	
	/**
	 * Set female_prctn_cnt 여성_종사자_수 numeric(null)
	 * @Param Double femalePrctnCnt
	 */
	public void setFemalePrctnCnt(Double femalePrctnCnt) {
		this.femalePrctnCnt = femalePrctnCnt;
	}
	/**
	 * Get bsnpc_arnd_div_nm 영업장_주변_구분_명 character varying(200)
	 * @Return String bsnpcArndDivNm
	 */
	public String getBsnpcArndDivNm() {
		return this.bsnpcArndDivNm;
	}
	
	/**
	 * Set bsnpc_arnd_div_nm 영업장_주변_구분_명 character varying(200)
	 * @Param String bsnpcArndDivNm
	 */
	public void setBsnpcArndDivNm(String bsnpcArndDivNm) {
		this.bsnpcArndDivNm = bsnpcArndDivNm;
	}
	/**
	 * Get rank_div_nm 등급_구분_명 character varying(20)
	 * @Return String rankDivNm
	 */
	public String getRankDivNm() {
		return this.rankDivNm;
	}
	
	/**
	 * Set rank_div_nm 등급_구분_명 character varying(20)
	 * @Param String rankDivNm
	 */
	public void setRankDivNm(String rankDivNm) {
		this.rankDivNm = rankDivNm;
	}
	/**
	 * Get rating_fclty_div_nm 급수_시설_구분_명 character varying(200)
	 * @Return String ratingFcltyDivNm
	 */
	public String getRatingFcltyDivNm() {
		return this.ratingFcltyDivNm;
	}
	
	/**
	 * Set rating_fclty_div_nm 급수_시설_구분_명 character varying(200)
	 * @Param String ratingFcltyDivNm
	 */
	public void setRatingFcltyDivNm(String ratingFcltyDivNm) {
		this.ratingFcltyDivNm = ratingFcltyDivNm;
	}
	/**
	 * Get tot_empl_cnt 총_종업원_수 numeric(null)
	 * @Return Double totEmplCnt
	 */
	public Double getTotEmplCnt() {
		return this.totEmplCnt;
	}
	
	/**
	 * Set tot_empl_cnt 총_종업원_수 numeric(null)
	 * @Param Double totEmplCnt
	 */
	public void setTotEmplCnt(Double totEmplCnt) {
		this.totEmplCnt = totEmplCnt;
	}
	/**
	 * Get hoffice_empl_cnt 본사_종업원_수 numeric(null)
	 * @Return Double hofficeEmplCnt
	 */
	public Double getHofficeEmplCnt() {
		return this.hofficeEmplCnt;
	}
	
	/**
	 * Set hoffice_empl_cnt 본사_종업원_수 numeric(null)
	 * @Param Double hofficeEmplCnt
	 */
	public void setHofficeEmplCnt(Double hofficeEmplCnt) {
		this.hofficeEmplCnt = hofficeEmplCnt;
	}
	/**
	 * Get fact_clrk_empl_cnt 공장_사무직_종업원_수 numeric(null)
	 * @Return Double factClrkEmplCnt
	 */
	public Double getFactClrkEmplCnt() {
		return this.factClrkEmplCnt;
	}
	
	/**
	 * Set fact_clrk_empl_cnt 공장_사무직_종업원_수 numeric(null)
	 * @Param Double factClrkEmplCnt
	 */
	public void setFactClrkEmplCnt(Double factClrkEmplCnt) {
		this.factClrkEmplCnt = factClrkEmplCnt;
	}
	/**
	 * Get fact_saljb_empl_cnt 공장_판매직_종업원_수 numeric(null)
	 * @Return Double factSaljbEmplCnt
	 */
	public Double getFactSaljbEmplCnt() {
		return this.factSaljbEmplCnt;
	}
	
	/**
	 * Set fact_saljb_empl_cnt 공장_판매직_종업원_수 numeric(null)
	 * @Param Double factSaljbEmplCnt
	 */
	public void setFactSaljbEmplCnt(Double factSaljbEmplCnt) {
		this.factSaljbEmplCnt = factSaljbEmplCnt;
	}
	/**
	 * Get fact_prdj_empl_cnt 공장_생산직_종업원_수 numeric(null)
	 * @Return Double factPrdjEmplCnt
	 */
	public Double getFactPrdjEmplCnt() {
		return this.factPrdjEmplCnt;
	}
	
	/**
	 * Set fact_prdj_empl_cnt 공장_생산직_종업원_수 numeric(null)
	 * @Param Double factPrdjEmplCnt
	 */
	public void setFactPrdjEmplCnt(Double factPrdjEmplCnt) {
		this.factPrdjEmplCnt = factPrdjEmplCnt;
	}
	/**
	 * Get build_posse_div_nm 건물_소유_구분_명 character varying(100)
	 * @Return String buildPosseDivNm
	 */
	public String getBuildPosseDivNm() {
		return this.buildPosseDivNm;
	}
	
	/**
	 * Set build_posse_div_nm 건물_소유_구분_명 character varying(100)
	 * @Param String buildPosseDivNm
	 */
	public void setBuildPosseDivNm(String buildPosseDivNm) {
		this.buildPosseDivNm = buildPosseDivNm;
	}
	/**
	 * Get grnt_amt 보증_금액 numeric(null)
	 * @Return Double grntAmt
	 */
	public Double getGrntAmt() {
		return this.grntAmt;
	}
	
	/**
	 * Set grnt_amt 보증_금액 numeric(null)
	 * @Param Double grntAmt
	 */
	public void setGrntAmt(Double grntAmt) {
		this.grntAmt = grntAmt;
	}
	/**
	 * Get mrent_amt 월세_금액 numeric(null)
	 * @Return Double mrentAmt
	 */
	public Double getMrentAmt() {
		return this.mrentAmt;
	}
	
	/**
	 * Set mrent_amt 월세_금액 numeric(null)
	 * @Param Double mrentAmt
	 */
	public void setMrentAmt(Double mrentAmt) {
		this.mrentAmt = mrentAmt;
	}
	/**
	 * Get multi_use_busi_yn 다중_이용_업소_여부 character varying(1)
	 * @Return String multiUseBusiYn
	 */
	public String getMultiUseBusiYn() {
		return this.multiUseBusiYn;
	}
	
	/**
	 * Set multi_use_busi_yn 다중_이용_업소_여부 character varying(1)
	 * @Param String multiUseBusiYn
	 */
	public void setMultiUseBusiYn(String multiUseBusiYn) {
		this.multiUseBusiYn = multiUseBusiYn;
	}
	/**
	 * Get fclty_tot_scal 시설_총_규모 numeric(null)
	 * @Return Double fcltyTotScal
	 */
	public Double getFcltyTotScal() {
		return this.fcltyTotScal;
	}
	
	/**
	 * Set fclty_tot_scal 시설_총_규모 numeric(null)
	 * @Param Double fcltyTotScal
	 */
	public void setFcltyTotScal(Double fcltyTotScal) {
		this.fcltyTotScal = fcltyTotScal;
	}
	/**
	 * Get trdtn_busi_apnt_no 전통_업소_지정_번호 character varying(40)
	 * @Return String trdtnBusiApntNo
	 */
	public String getTrdtnBusiApntNo() {
		return this.trdtnBusiApntNo;
	}
	
	/**
	 * Set trdtn_busi_apnt_no 전통_업소_지정_번호 character varying(40)
	 * @Param String trdtnBusiApntNo
	 */
	public void setTrdtnBusiApntNo(String trdtnBusiApntNo) {
		this.trdtnBusiApntNo = trdtnBusiApntNo;
	}
	/**
	 * Get trdtn_busi_main_food 전통_업소_주된_음식 character varying(20)
	 * @Return String trdtnBusiMainFood
	 */
	public String getTrdtnBusiMainFood() {
		return this.trdtnBusiMainFood;
	}
	
	/**
	 * Set trdtn_busi_main_food 전통_업소_주된_음식 character varying(20)
	 * @Param String trdtnBusiMainFood
	 */
	public void setTrdtnBusiMainFood(String trdtnBusiMainFood) {
		this.trdtnBusiMainFood = trdtnBusiMainFood;
	}
	/**
	 * Get hpge 홈페이지 character varying(200)
	 * @Return String hpge
	 */
	public String getHpge() {
		return this.hpge;
	}
	
	/**
	 * Set hpge 홈페이지 character varying(200)
	 * @Param String hpge
	 */
	public void setHpge(String hpge) {
		this.hpge = hpge;
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
