package kr.hubble.api.model.dto;

import java.io.Serializable;

/**
 * SMS_SEND_LOG Value Object
 */
public class SmsSendLogVo implements Serializable {

	/* SMS_SEND_SEQ SMS_발송_순번 int(0,0) */
	private String smsSendSeq;

	/* RCPT_NO 수신_번호 varchar(15) */
	private String rcptNo;

	/* SEND_NO 발송_번호 varchar(15) */
	private String sendNo;

	/* SEND_DTTM 발송_일시 char(14) */
	private String sendDttm;

	/* SEND_TXT 발송_내용 varchar(100) */
	private String sendTxt;

	/* SMS_DIV_CD SMS_구분_코드 varchar(10) */
	private String smsDivCd;

	/* ETC_TXT 기타_내용 varchar(100) */
	private String etcTxt;

	/* BDR_ID 벤더_ID varchar(50) */
	private String bdrId;

	/* REG_USER_ID 등록_사용자_ID varchar(50) */
	private String regUserId;

	/* REG_DTTM 등록_일시 char(14) */
	private String regDttm;

	/* UPT_USER_ID 수정_사용자_ID varchar(50) */
	private String uptUserId;

	/* UPT_DTTM 수정_일시 char(14) */
	private String uptDttm;


	/**
	 * Get SMS_SEND_SEQ SMS_발송_순번 int(0,0)
	 * @Return String smsSendSeq
	 */
	public String getSmsSendSeq() {
		return this.smsSendSeq;
	}
	
	/**
	 * Set SMS_SEND_SEQ SMS_발송_순번 int(0,0)
	 * @Param String smsSendSeq
	 */
	public void setSmsSendSeq(String smsSendSeq) {
		this.smsSendSeq = smsSendSeq;
	}
	/**
	 * Get RCPT_NO 수신_번호 varchar(15)
	 * @Return String rcptNo
	 */
	public String getRcptNo() {
		return this.rcptNo;
	}
	
	/**
	 * Set RCPT_NO 수신_번호 varchar(15)
	 * @Param String rcptNo
	 */
	public void setRcptNo(String rcptNo) {
		this.rcptNo = rcptNo;
	}
	/**
	 * Get SEND_NO 발송_번호 varchar(15)
	 * @Return String sendNo
	 */
	public String getSendNo() {
		return this.sendNo;
	}
	
	/**
	 * Set SEND_NO 발송_번호 varchar(15)
	 * @Param String sendNo
	 */
	public void setSendNo(String sendNo) {
		this.sendNo = sendNo;
	}
	/**
	 * Get SEND_DTTM 발송_일시 char(14)
	 * @Return String sendDttm
	 */
	public String getSendDttm() {
		return this.sendDttm;
	}
	
	/**
	 * Set SEND_DTTM 발송_일시 char(14)
	 * @Param String sendDttm
	 */
	public void setSendDttm(String sendDttm) {
		this.sendDttm = sendDttm;
	}
	/**
	 * Get SEND_TXT 발송_내용 varchar(100)
	 * @Return String sendTxt
	 */
	public String getSendTxt() {
		return this.sendTxt;
	}
	
	/**
	 * Set SEND_TXT 발송_내용 varchar(100)
	 * @Param String sendTxt
	 */
	public void setSendTxt(String sendTxt) {
		this.sendTxt = sendTxt;
	}
	/**
	 * Get SMS_DIV_CD SMS_구분_코드 varchar(10)
	 * @Return String smsDivCd
	 */
	public String getSmsDivCd() {
		return this.smsDivCd;
	}
	
	/**
	 * Set SMS_DIV_CD SMS_구분_코드 varchar(10)
	 * @Param String smsDivCd
	 */
	public void setSmsDivCd(String smsDivCd) {
		this.smsDivCd = smsDivCd;
	}
	/**
	 * Get ETC_TXT 기타_내용 varchar(100)
	 * @Return String etcTxt
	 */
	public String getEtcTxt() {
		return this.etcTxt;
	}
	
	/**
	 * Set ETC_TXT 기타_내용 varchar(100)
	 * @Param String etcTxt
	 */
	public void setEtcTxt(String etcTxt) {
		this.etcTxt = etcTxt;
	}
	/**
	 * Get BDR_ID 벤더_ID varchar(50)
	 * @Return String bdrId
	 */
	public String getBdrId() {
		return this.bdrId;
	}
	
	/**
	 * Set BDR_ID 벤더_ID varchar(50)
	 * @Param String bdrId
	 */
	public void setBdrId(String bdrId) {
		this.bdrId = bdrId;
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
