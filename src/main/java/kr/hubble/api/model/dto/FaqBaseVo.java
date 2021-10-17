package kr.hubble.api.model.dto;

import java.io.Serializable;

/**
 * FAQ_BASE Value Object
 */
public class FaqBaseVo implements Serializable {

	/* FAQ_SEQ FAQ_순번 int(0,0) */
	private String faqSeq;

	/* FAQ_DIV_CD FAQ_구분_코드 varchar(10) */
	private String faqDivCd;

	/* FAQ_TITL FAQ_제목 varchar(50) */
	private String faqTitl;

	/* FAQ_Q_TXT FAQ_질문_내용 mediumtext(16777215) */
	private String faqQTxt;

	/* FAQ_RPLY_TXT FAQ_답변_내용 mediumtext(16777215) */
	private String faqRplyTxt;

	/* REG_USER_ID 등록_사용자_ID varchar(50) */
	private String regUserId;

	/* REG_DTTM 등록_일시 char(14) */
	private String regDttm;

	/* UPT_USER_ID 수정_사용자_ID varchar(50) */
	private String uptUserId;

	/* UPT_DTTM 수정_일시 char(14) */
	private String uptDttm;


	/**
	 * Get FAQ_SEQ FAQ_순번 int(0,0)
	 * @Return String faqSeq
	 */
	public String getFaqSeq() {
		return this.faqSeq;
	}
	
	/**
	 * Set FAQ_SEQ FAQ_순번 int(0,0)
	 * @Param String faqSeq
	 */
	public void setFaqSeq(String faqSeq) {
		this.faqSeq = faqSeq;
	}
	/**
	 * Get FAQ_DIV_CD FAQ_구분_코드 varchar(10)
	 * @Return String faqDivCd
	 */
	public String getFaqDivCd() {
		return this.faqDivCd;
	}
	
	/**
	 * Set FAQ_DIV_CD FAQ_구분_코드 varchar(10)
	 * @Param String faqDivCd
	 */
	public void setFaqDivCd(String faqDivCd) {
		this.faqDivCd = faqDivCd;
	}
	/**
	 * Get FAQ_TITL FAQ_제목 varchar(50)
	 * @Return String faqTitl
	 */
	public String getFaqTitl() {
		return this.faqTitl;
	}
	
	/**
	 * Set FAQ_TITL FAQ_제목 varchar(50)
	 * @Param String faqTitl
	 */
	public void setFaqTitl(String faqTitl) {
		this.faqTitl = faqTitl;
	}
	/**
	 * Get FAQ_Q_TXT FAQ_질문_내용 mediumtext(16777215)
	 * @Return String faqQTxt
	 */
	public String getFaqQTxt() {
		return this.faqQTxt;
	}
	
	/**
	 * Set FAQ_Q_TXT FAQ_질문_내용 mediumtext(16777215)
	 * @Param String faqQTxt
	 */
	public void setFaqQTxt(String faqQTxt) {
		this.faqQTxt = faqQTxt;
	}
	/**
	 * Get FAQ_RPLY_TXT FAQ_답변_내용 mediumtext(16777215)
	 * @Return String faqRplyTxt
	 */
	public String getFaqRplyTxt() {
		return this.faqRplyTxt;
	}
	
	/**
	 * Set FAQ_RPLY_TXT FAQ_답변_내용 mediumtext(16777215)
	 * @Param String faqRplyTxt
	 */
	public void setFaqRplyTxt(String faqRplyTxt) {
		this.faqRplyTxt = faqRplyTxt;
	}
	/**
	 * Get REG_USER_ID 등록_사용자_ID varchar(50)
	 * @Return String regUserId
	 */
	public String getRegUserId() {
		return this.regUserId;
	}
	
	/**
	 * Set REG_USER_ID 등록_사용자_ID varchar(50)
	 * @Param String regUserId
	 */
	public void setRegUserId(String regUserId) {
		this.regUserId = regUserId;
	}
	/**
	 * Get REG_DTTM 등록_일시 char(14)
	 * @Return String regDttm
	 */
	public String getRegDttm() {
		return this.regDttm;
	}
	
	/**
	 * Set REG_DTTM 등록_일시 char(14)
	 * @Param String regDttm
	 */
	public void setRegDttm(String regDttm) {
		this.regDttm = regDttm;
	}
	/**
	 * Get UPT_USER_ID 수정_사용자_ID varchar(50)
	 * @Return String uptUserId
	 */
	public String getUptUserId() {
		return this.uptUserId;
	}
	
	/**
	 * Set UPT_USER_ID 수정_사용자_ID varchar(50)
	 * @Param String uptUserId
	 */
	public void setUptUserId(String uptUserId) {
		this.uptUserId = uptUserId;
	}
	/**
	 * Get UPT_DTTM 수정_일시 char(14)
	 * @Return String uptDttm
	 */
	public String getUptDttm() {
		return this.uptDttm;
	}
	
	/**
	 * Set UPT_DTTM 수정_일시 char(14)
	 * @Param String uptDttm
	 */
	public void setUptDttm(String uptDttm) {
		this.uptDttm = uptDttm;
	}

} // end of class
