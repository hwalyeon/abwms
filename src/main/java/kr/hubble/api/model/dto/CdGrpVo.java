package kr.hubble.api.model.dto;

import java.io.Serializable;

/**
 * CD_GRP Value Object
 */
public class CdGrpVo implements Serializable {

	/* CD_GRP 코드_그룹 varchar(20) */
	private String cdGrp;

	/* CD_GRP_NM 코드_그룹_명 varchar(50) */
	private String cdGrpNm;

	/* CD_CTNT 코드_설명 mediumtext(16777215) */
	private String cdCtnt;

	/* REG_USER_ID 등록_사용자_ID varchar(50) */
	private String regUserId;

	/* REG_DTTM 등록_일시 char(14) */
	private String regDttm;

	/* UPT_USER_ID 수정_사용자_ID varchar(50) */
	private String uptUserId;

	/* UPT_DTTM 수정_일시 char(14) */
	private String uptDttm;


	/**
	 * Get CD_GRP 코드_그룹 varchar(20)
	 * @Return String cdGrp
	 */
	public String getCdGrp() {
		return this.cdGrp;
	}
	
	/**
	 * Set CD_GRP 코드_그룹 varchar(20)
	 * @Param String cdGrp
	 */
	public void setCdGrp(String cdGrp) {
		this.cdGrp = cdGrp;
	}
	/**
	 * Get CD_GRP_NM 코드_그룹_명 varchar(50)
	 * @Return String cdGrpNm
	 */
	public String getCdGrpNm() {
		return this.cdGrpNm;
	}
	
	/**
	 * Set CD_GRP_NM 코드_그룹_명 varchar(50)
	 * @Param String cdGrpNm
	 */
	public void setCdGrpNm(String cdGrpNm) {
		this.cdGrpNm = cdGrpNm;
	}
	/**
	 * Get CD_CTNT 코드_설명 mediumtext(16777215)
	 * @Return String cdCtnt
	 */
	public String getCdCtnt() {
		return this.cdCtnt;
	}
	
	/**
	 * Set CD_CTNT 코드_설명 mediumtext(16777215)
	 * @Param String cdCtnt
	 */
	public void setCdCtnt(String cdCtnt) {
		this.cdCtnt = cdCtnt;
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
