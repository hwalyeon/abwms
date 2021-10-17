package kr.hubble.api.model.dto;

import java.io.Serializable;

/**
 * ADMIN_BASE Value Object
 */
public class AdminBaseVo implements Serializable {

	/* ADMIN_ID 관리자_ID varchar(50) */
	private String adminId;

	/* USER_NM 사용자_명 varchar(10) */
	private String userNm;

	/* PASS 패스워드 varchar(256) */
	private String pass;

	/* NICK 닉네임 varchar(10) */
	private String nick;

	/* EMAL 이메일 varchar(50) */
	private String emal;

	/* HP 휴대폰 varchar(15) */
	private String hp;

	/* USE_YN 사용_여부 char(1) */
	private String useYn;

	/* REG_USER_ID 등록_사용자_ID varchar(50) */
	private String regUserId;

	/* REG_DTTM 등록_일시 char(14) */
	private String regDttm;

	/* UPT_USER_ID 수정_사용자_ID varchar(50) */
	private String uptUserId;

	/* UPT_DTTM 수정_일시 char(14) */
	private String uptDttm;


	/**
	 * Get ADMIN_ID 관리자_ID varchar(50)
	 * @Return String adminId
	 */
	public String getAdminId() {
		return this.adminId;
	}
	
	/**
	 * Set ADMIN_ID 관리자_ID varchar(50)
	 * @Param String adminId
	 */
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	/**
	 * Get USER_NM 사용자_명 varchar(10)
	 * @Return String userNm
	 */
	public String getUserNm() {
		return this.userNm;
	}
	
	/**
	 * Set USER_NM 사용자_명 varchar(10)
	 * @Param String userNm
	 */
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}
	/**
	 * Get PASS 패스워드 varchar(256)
	 * @Return String pass
	 */
	public String getPass() {
		return this.pass;
	}
	
	/**
	 * Set PASS 패스워드 varchar(256)
	 * @Param String pass
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}
	/**
	 * Get NICK 닉네임 varchar(10)
	 * @Return String nick
	 */
	public String getNick() {
		return this.nick;
	}
	
	/**
	 * Set NICK 닉네임 varchar(10)
	 * @Param String nick
	 */
	public void setNick(String nick) {
		this.nick = nick;
	}
	/**
	 * Get EMAL 이메일 varchar(50)
	 * @Return String emal
	 */
	public String getEmal() {
		return this.emal;
	}
	
	/**
	 * Set EMAL 이메일 varchar(50)
	 * @Param String emal
	 */
	public void setEmal(String emal) {
		this.emal = emal;
	}
	/**
	 * Get HP 휴대폰 varchar(15)
	 * @Return String hp
	 */
	public String getHp() {
		return this.hp;
	}
	
	/**
	 * Set HP 휴대폰 varchar(15)
	 * @Param String hp
	 */
	public void setHp(String hp) {
		this.hp = hp;
	}
	/**
	 * Get USE_YN 사용_여부 char(1)
	 * @Return String useYn
	 */
	public String getUseYn() {
		return this.useYn;
	}
	
	/**
	 * Set USE_YN 사용_여부 char(1)
	 * @Param String useYn
	 */
	public void setUseYn(String useYn) {
		this.useYn = useYn;
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
