package kr.hubble.api.model.dto;

import java.io.Serializable;

/**
 * USER_BASE Value Object
 */
public class UserBaseVo implements Serializable {

	/* USER_ID 사용자_ID varchar(50) */
	private String userId;

	/* USER_NM 사용자_명 varchar(10) */
	private String userNm;

	/* PASS 패스워드 varchar(256) */
	private String pass;

	/* SNS_TOKN SNS_토큰 varchar(255) */
	private String snsTokn;

	/* SNS_DIV_CD SNS_구분_코드 varchar(10) */
	private String snsDivCd;

	/* NICK 닉네임 varchar(10) */
	private String nick;

	/* EMAL 이메일 varchar(50) */
	private String emal;

	/* HP 휴대폰 varchar(15) */
	private String hp;

	/* USER_PHOT_FILE 사용자_사진_파일 int(0,0) */
	private String userPhotFile;

	/* USE_TRMS_DTTM 이용_약관_일시 char(14) */
	private String useTrmsDttm;

	/* PRIV_TRMS_DTTM 개인정보_약관_일시 char(14) */
	private String privTrmsDttm;

	/* AD_TRMS_DTTM 광고_약관_일시 char(14) */
	private String adTrmsDttm;

	/* ME_VRFY_DTTM 본인_인증_일시 char(14) */
	private String meVrfyDttm;

	/* EVNT_NOTI_YN 이벤트_알림_여부 char(1) */
	private String evntNotiYn;

	/* REVW_NOTI_YN 리뷰_알림_여부 char(1) */
	private String revwNotiYn;

	/* REPY_NOTI_YN 댓글_알림_여부 char(1) */
	private String repyNotiYn;

	/* ASCT_NOTI_YN AS센터_알림_여부 char(1) */
	private String asctNotiYn;

	/* JOIN_DTTM 가입_일시 char(14) */
	private String joinDttm;

	/* REG_USER_ID 등록_사용자_ID varchar(50) */
	private String regUserId;

	/* REG_DTTM 등록_일시 char(14) */
	private String regDttm;

	/* UPT_USER_ID 수정_사용자_ID varchar(50) */
	private String uptUserId;

	/* UPT_DTTM 수정_일시 char(14) */
	private String uptDttm;


	/**
	 * Get USER_ID 사용자_ID varchar(50)
	 * @Return String userId
	 */
	public String getUserId() {
		return this.userId;
	}
	
	/**
	 * Set USER_ID 사용자_ID varchar(50)
	 * @Param String userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
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
	 * Get SNS_TOKN SNS_토큰 varchar(255)
	 * @Return String snsTokn
	 */
	public String getSnsTokn() {
		return this.snsTokn;
	}
	
	/**
	 * Set SNS_TOKN SNS_토큰 varchar(255)
	 * @Param String snsTokn
	 */
	public void setSnsTokn(String snsTokn) {
		this.snsTokn = snsTokn;
	}
	/**
	 * Get SNS_DIV_CD SNS_구분_코드 varchar(10)
	 * @Return String snsDivCd
	 */
	public String getSnsDivCd() {
		return this.snsDivCd;
	}
	
	/**
	 * Set SNS_DIV_CD SNS_구분_코드 varchar(10)
	 * @Param String snsDivCd
	 */
	public void setSnsDivCd(String snsDivCd) {
		this.snsDivCd = snsDivCd;
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
	 * Get USER_PHOT_FILE 사용자_사진_파일 int(0,0)
	 * @Return String userPhotFile
	 */
	public String getUserPhotFile() {
		return this.userPhotFile;
	}
	
	/**
	 * Set USER_PHOT_FILE 사용자_사진_파일 int(0,0)
	 * @Param String userPhotFile
	 */
	public void setUserPhotFile(String userPhotFile) {
		this.userPhotFile = userPhotFile;
	}
	/**
	 * Get USE_TRMS_DTTM 이용_약관_일시 char(14)
	 * @Return String useTrmsDttm
	 */
	public String getUseTrmsDttm() {
		return this.useTrmsDttm;
	}
	
	/**
	 * Set USE_TRMS_DTTM 이용_약관_일시 char(14)
	 * @Param String useTrmsDttm
	 */
	public void setUseTrmsDttm(String useTrmsDttm) {
		this.useTrmsDttm = useTrmsDttm;
	}
	/**
	 * Get PRIV_TRMS_DTTM 개인정보_약관_일시 char(14)
	 * @Return String privTrmsDttm
	 */
	public String getPrivTrmsDttm() {
		return this.privTrmsDttm;
	}
	
	/**
	 * Set PRIV_TRMS_DTTM 개인정보_약관_일시 char(14)
	 * @Param String privTrmsDttm
	 */
	public void setPrivTrmsDttm(String privTrmsDttm) {
		this.privTrmsDttm = privTrmsDttm;
	}
	/**
	 * Get AD_TRMS_DTTM 광고_약관_일시 char(14)
	 * @Return String adTrmsDttm
	 */
	public String getAdTrmsDttm() {
		return this.adTrmsDttm;
	}
	
	/**
	 * Set AD_TRMS_DTTM 광고_약관_일시 char(14)
	 * @Param String adTrmsDttm
	 */
	public void setAdTrmsDttm(String adTrmsDttm) {
		this.adTrmsDttm = adTrmsDttm;
	}
	/**
	 * Get ME_VRFY_DTTM 본인_인증_일시 char(14)
	 * @Return String meVrfyDttm
	 */
	public String getMeVrfyDttm() {
		return this.meVrfyDttm;
	}
	
	/**
	 * Set ME_VRFY_DTTM 본인_인증_일시 char(14)
	 * @Param String meVrfyDttm
	 */
	public void setMeVrfyDttm(String meVrfyDttm) {
		this.meVrfyDttm = meVrfyDttm;
	}
	/**
	 * Get EVNT_NOTI_YN 이벤트_알림_여부 char(1)
	 * @Return String evntNotiYn
	 */
	public String getEvntNotiYn() {
		return this.evntNotiYn;
	}
	
	/**
	 * Set EVNT_NOTI_YN 이벤트_알림_여부 char(1)
	 * @Param String evntNotiYn
	 */
	public void setEvntNotiYn(String evntNotiYn) {
		this.evntNotiYn = evntNotiYn;
	}
	/**
	 * Get REVW_NOTI_YN 리뷰_알림_여부 char(1)
	 * @Return String revwNotiYn
	 */
	public String getRevwNotiYn() {
		return this.revwNotiYn;
	}
	
	/**
	 * Set REVW_NOTI_YN 리뷰_알림_여부 char(1)
	 * @Param String revwNotiYn
	 */
	public void setRevwNotiYn(String revwNotiYn) {
		this.revwNotiYn = revwNotiYn;
	}
	/**
	 * Get REPY_NOTI_YN 댓글_알림_여부 char(1)
	 * @Return String repyNotiYn
	 */
	public String getRepyNotiYn() {
		return this.repyNotiYn;
	}
	
	/**
	 * Set REPY_NOTI_YN 댓글_알림_여부 char(1)
	 * @Param String repyNotiYn
	 */
	public void setRepyNotiYn(String repyNotiYn) {
		this.repyNotiYn = repyNotiYn;
	}
	/**
	 * Get ASCT_NOTI_YN AS센터_알림_여부 char(1)
	 * @Return String asctNotiYn
	 */
	public String getAsctNotiYn() {
		return this.asctNotiYn;
	}
	
	/**
	 * Set ASCT_NOTI_YN AS센터_알림_여부 char(1)
	 * @Param String asctNotiYn
	 */
	public void setAsctNotiYn(String asctNotiYn) {
		this.asctNotiYn = asctNotiYn;
	}
	/**
	 * Get JOIN_DTTM 가입_일시 char(14)
	 * @Return String joinDttm
	 */
	public String getJoinDttm() {
		return this.joinDttm;
	}
	
	/**
	 * Set JOIN_DTTM 가입_일시 char(14)
	 * @Param String joinDttm
	 */
	public void setJoinDttm(String joinDttm) {
		this.joinDttm = joinDttm;
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
