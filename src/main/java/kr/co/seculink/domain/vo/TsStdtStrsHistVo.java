package kr.co.seculink.domain.vo;

import java.io.Serializable;
import lombok.ToString;
/**
 * ts_stdt_strs_hist Value Object
 */
 @ToString
public class TsStdtStrsHistVo implements Serializable {

	/* stdt_no 학생_번호 numeric(null) */
	private Double stdtNo;

	/* strs_hist_seq 스트레스_이력_순번 numeric(null) */
	private Double strsHistSeq;

	/* strs_judg_dttm 스트레스_판정_일시 character(14) */
	private String strsJudgDttm;

	/* strs_idx 스트레스_지수 numeric(null) */
	private Double strsIdx;

	/* hbit_mdan 심박_중간값 numeric(null) */
	private Double hbitMdan;

	/* mind_strs_pnt 정신적_스트레스_점수 numeric(null) */
	private Double mindStrsPnt;

	/* mind_strs_stat_cd 정신적_스트레스_상태_코드 character varying(20) */
	private String mindStrsStatCd;

	/* phys_strs_pnt 신체적_스트레스_점수 numeric(null) */
	private Double physStrsPnt;

	/* phys_strs_stat_cd 신체적_스트레스_상태_코드 character varying(20) */
	private String physStrsStatCd;

	/* strs_cope_pnt 스트레스_대처_점수 numeric(null) */
	private Double strsCopePnt;

	/* strs_cope_stat_cd 스트레스_대처_상태_코드 character varying(20) */
	private String strsCopeStatCd;

	/* avg_hbit_cnt 평균_심박_수 numeric(null) */
	private Double avgHbitCnt;

	/* abnm_hbit_cnt 이상_심박_수 numeric(null) */
	private Double abnmHbitCnt;

	/* strs_stat_cd 스트레스_상태_코드 character varying(20) */
	private String strsStatCd;

	/* strs_proc_stat_cd 스트레스_처리_상태_코드 character varying(20) */
	private String strsProcStatCd;

	/* judg_no 판정_번호 numeric(null) */
	private Double judgNo;

	/* strs_alam_no 스트레스_알림_번호 numeric(null) */
	private Double strsAlamNo;

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
	 * Get strs_judg_dttm 스트레스_판정_일시 character(14)
	 * @Return String strsJudgDttm
	 */
	public String getStrsJudgDttm() {
		return this.strsJudgDttm;
	}
	
	/**
	 * Set strs_judg_dttm 스트레스_판정_일시 character(14)
	 * @Param String strsJudgDttm
	 */
	public void setStrsJudgDttm(String strsJudgDttm) {
		this.strsJudgDttm = strsJudgDttm;
	}
	/**
	 * Get strs_idx 스트레스_지수 numeric(null)
	 * @Return Double strsIdx
	 */
	public Double getStrsIdx() {
		return this.strsIdx;
	}
	
	/**
	 * Set strs_idx 스트레스_지수 numeric(null)
	 * @Param Double strsIdx
	 */
	public void setStrsIdx(Double strsIdx) {
		this.strsIdx = strsIdx;
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
	 * Get mind_strs_pnt 정신적_스트레스_점수 numeric(null)
	 * @Return Double mindStrsPnt
	 */
	public Double getMindStrsPnt() {
		return this.mindStrsPnt;
	}
	
	/**
	 * Set mind_strs_pnt 정신적_스트레스_점수 numeric(null)
	 * @Param Double mindStrsPnt
	 */
	public void setMindStrsPnt(Double mindStrsPnt) {
		this.mindStrsPnt = mindStrsPnt;
	}
	/**
	 * Get mind_strs_stat_cd 정신적_스트레스_상태_코드 character varying(20)
	 * @Return String mindStrsStatCd
	 */
	public String getMindStrsStatCd() {
		return this.mindStrsStatCd;
	}
	
	/**
	 * Set mind_strs_stat_cd 정신적_스트레스_상태_코드 character varying(20)
	 * @Param String mindStrsStatCd
	 */
	public void setMindStrsStatCd(String mindStrsStatCd) {
		this.mindStrsStatCd = mindStrsStatCd;
	}
	/**
	 * Get phys_strs_pnt 신체적_스트레스_점수 numeric(null)
	 * @Return Double physStrsPnt
	 */
	public Double getPhysStrsPnt() {
		return this.physStrsPnt;
	}
	
	/**
	 * Set phys_strs_pnt 신체적_스트레스_점수 numeric(null)
	 * @Param Double physStrsPnt
	 */
	public void setPhysStrsPnt(Double physStrsPnt) {
		this.physStrsPnt = physStrsPnt;
	}
	/**
	 * Get phys_strs_stat_cd 신체적_스트레스_상태_코드 character varying(20)
	 * @Return String physStrsStatCd
	 */
	public String getPhysStrsStatCd() {
		return this.physStrsStatCd;
	}
	
	/**
	 * Set phys_strs_stat_cd 신체적_스트레스_상태_코드 character varying(20)
	 * @Param String physStrsStatCd
	 */
	public void setPhysStrsStatCd(String physStrsStatCd) {
		this.physStrsStatCd = physStrsStatCd;
	}
	/**
	 * Get strs_cope_pnt 스트레스_대처_점수 numeric(null)
	 * @Return Double strsCopePnt
	 */
	public Double getStrsCopePnt() {
		return this.strsCopePnt;
	}
	
	/**
	 * Set strs_cope_pnt 스트레스_대처_점수 numeric(null)
	 * @Param Double strsCopePnt
	 */
	public void setStrsCopePnt(Double strsCopePnt) {
		this.strsCopePnt = strsCopePnt;
	}
	/**
	 * Get strs_cope_stat_cd 스트레스_대처_상태_코드 character varying(20)
	 * @Return String strsCopeStatCd
	 */
	public String getStrsCopeStatCd() {
		return this.strsCopeStatCd;
	}
	
	/**
	 * Set strs_cope_stat_cd 스트레스_대처_상태_코드 character varying(20)
	 * @Param String strsCopeStatCd
	 */
	public void setStrsCopeStatCd(String strsCopeStatCd) {
		this.strsCopeStatCd = strsCopeStatCd;
	}
	/**
	 * Get avg_hbit_cnt 평균_심박_수 numeric(null)
	 * @Return Double avgHbitCnt
	 */
	public Double getAvgHbitCnt() {
		return this.avgHbitCnt;
	}
	
	/**
	 * Set avg_hbit_cnt 평균_심박_수 numeric(null)
	 * @Param Double avgHbitCnt
	 */
	public void setAvgHbitCnt(Double avgHbitCnt) {
		this.avgHbitCnt = avgHbitCnt;
	}
	/**
	 * Get abnm_hbit_cnt 이상_심박_수 numeric(null)
	 * @Return Double abnmHbitCnt
	 */
	public Double getAbnmHbitCnt() {
		return this.abnmHbitCnt;
	}
	
	/**
	 * Set abnm_hbit_cnt 이상_심박_수 numeric(null)
	 * @Param Double abnmHbitCnt
	 */
	public void setAbnmHbitCnt(Double abnmHbitCnt) {
		this.abnmHbitCnt = abnmHbitCnt;
	}
	/**
	 * Get strs_stat_cd 스트레스_상태_코드 character varying(20)
	 * @Return String strsStatCd
	 */
	public String getStrsStatCd() {
		return this.strsStatCd;
	}
	
	/**
	 * Set strs_stat_cd 스트레스_상태_코드 character varying(20)
	 * @Param String strsStatCd
	 */
	public void setStrsStatCd(String strsStatCd) {
		this.strsStatCd = strsStatCd;
	}
	/**
	 * Get strs_proc_stat_cd 스트레스_처리_상태_코드 character varying(20)
	 * @Return String strsProcStatCd
	 */
	public String getStrsProcStatCd() {
		return this.strsProcStatCd;
	}
	
	/**
	 * Set strs_proc_stat_cd 스트레스_처리_상태_코드 character varying(20)
	 * @Param String strsProcStatCd
	 */
	public void setStrsProcStatCd(String strsProcStatCd) {
		this.strsProcStatCd = strsProcStatCd;
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
	 * Get strs_alam_no 스트레스_알림_번호 numeric(null)
	 * @Return Double strsAlamNo
	 */
	public Double getStrsAlamNo() {
		return this.strsAlamNo;
	}
	
	/**
	 * Set strs_alam_no 스트레스_알림_번호 numeric(null)
	 * @Param Double strsAlamNo
	 */
	public void setStrsAlamNo(Double strsAlamNo) {
		this.strsAlamNo = strsAlamNo;
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
