package kr.co.seculink.domain.vo;

import java.io.Serializable;

/**
 * ts_qna_base Value Object
 */
public class TsQnaBaseVo implements Serializable {

	/* qna_no 질의응답_번호 numeric(null) */
	private Double qnaNo;

	/* qust_guar_no 질문_보호자_번호 numeric(null) */
	private Double qustGuarNo;

	/* qust_dt 질문_일자 character(8) */
	private String qustDt;

	/* qust_tm 질문_시각 character(6) */
	private String qustTm;

	/* qust_titl 질문_제목 character varying(100) */
	private String qustTitl;

	/* qust_cntn 질문_내용 text(null) */
	private String qustCntn;

	/* ans_user_id 답변_사용자_ID character varying(20) */
	private String ansUserId;

	/* ans_dt 답변_일자 character(8) */
	private String ansDt;

	/* ans_tm 답변_시각 character(6) */
	private String ansTm;

	/* ans_cntn 답변_내용 text(null) */
	private String ansCntn;

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
	 * Get qna_no 질의응답_번호 numeric(null)
	 * @Return Double qnaNo
	 */
	public Double getQnaNo() {
		return this.qnaNo;
	}
	
	/**
	 * Set qna_no 질의응답_번호 numeric(null)
	 * @Param Double qnaNo
	 */
	public void setQnaNo(Double qnaNo) {
		this.qnaNo = qnaNo;
	}
	/**
	 * Get qust_guar_no 질문_보호자_번호 numeric(null)
	 * @Return Double qustGuarNo
	 */
	public Double getQustGuarNo() {
		return this.qustGuarNo;
	}
	
	/**
	 * Set qust_guar_no 질문_보호자_번호 numeric(null)
	 * @Param Double qustGuarNo
	 */
	public void setQustGuarNo(Double qustGuarNo) {
		this.qustGuarNo = qustGuarNo;
	}
	/**
	 * Get qust_dt 질문_일자 character(8)
	 * @Return String qustDt
	 */
	public String getQustDt() {
		return this.qustDt;
	}
	
	/**
	 * Set qust_dt 질문_일자 character(8)
	 * @Param String qustDt
	 */
	public void setQustDt(String qustDt) {
		this.qustDt = qustDt;
	}
	/**
	 * Get qust_tm 질문_시각 character(6)
	 * @Return String qustTm
	 */
	public String getQustTm() {
		return this.qustTm;
	}
	
	/**
	 * Set qust_tm 질문_시각 character(6)
	 * @Param String qustTm
	 */
	public void setQustTm(String qustTm) {
		this.qustTm = qustTm;
	}
	/**
	 * Get qust_titl 질문_제목 character varying(100)
	 * @Return String qustTitl
	 */
	public String getQustTitl() {
		return this.qustTitl;
	}
	
	/**
	 * Set qust_titl 질문_제목 character varying(100)
	 * @Param String qustTitl
	 */
	public void setQustTitl(String qustTitl) {
		this.qustTitl = qustTitl;
	}
	/**
	 * Get qust_cntn 질문_내용 text(null)
	 * @Return String qustCntn
	 */
	public String getQustCntn() {
		return this.qustCntn;
	}
	
	/**
	 * Set qust_cntn 질문_내용 text(null)
	 * @Param String qustCntn
	 */
	public void setQustCntn(String qustCntn) {
		this.qustCntn = qustCntn;
	}
	/**
	 * Get ans_user_id 답변_사용자_ID character varying(20)
	 * @Return String ansUserId
	 */
	public String getAnsUserId() {
		return this.ansUserId;
	}
	
	/**
	 * Set ans_user_id 답변_사용자_ID character varying(20)
	 * @Param String ansUserId
	 */
	public void setAnsUserId(String ansUserId) {
		this.ansUserId = ansUserId;
	}
	/**
	 * Get ans_dt 답변_일자 character(8)
	 * @Return String ansDt
	 */
	public String getAnsDt() {
		return this.ansDt;
	}
	
	/**
	 * Set ans_dt 답변_일자 character(8)
	 * @Param String ansDt
	 */
	public void setAnsDt(String ansDt) {
		this.ansDt = ansDt;
	}
	/**
	 * Get ans_tm 답변_시각 character(6)
	 * @Return String ansTm
	 */
	public String getAnsTm() {
		return this.ansTm;
	}
	
	/**
	 * Set ans_tm 답변_시각 character(6)
	 * @Param String ansTm
	 */
	public void setAnsTm(String ansTm) {
		this.ansTm = ansTm;
	}
	/**
	 * Get ans_cntn 답변_내용 text(null)
	 * @Return String ansCntn
	 */
	public String getAnsCntn() {
		return this.ansCntn;
	}
	
	/**
	 * Set ans_cntn 답변_내용 text(null)
	 * @Param String ansCntn
	 */
	public void setAnsCntn(String ansCntn) {
		this.ansCntn = ansCntn;
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
