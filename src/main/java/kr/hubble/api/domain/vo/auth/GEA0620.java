package kr.hubble.api.domain.vo.auth;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@ApiModel("SNS 로그인 Output")
public class GEA0620 {

	@ApiModelProperty(notes = "사용자ID")
	private String userId;
	
	@ApiModelProperty(notes = "사용자명")
	private String userNm;
	
	@ApiModelProperty(notes = "닉네임")
	private String nick;
	
	@ApiModelProperty(notes = "이메일")
	private String emal;
	
	@ApiModelProperty(notes = "휴대폰 번호")
	private String hp;
	
	@ApiModelProperty(notes = "이벤트 알림 여부")
	private String evntNotiYn;
	
	@ApiModelProperty(notes = "리뷰 알림 여부")
	private String revwNotiYn;
	
	@ApiModelProperty(notes = "댓글 알림 여부")
	private String repyNotiYn;
	
	@ApiModelProperty(notes = "AS센터 댓글 알림 여부")
	private String asctNotiYn;
	
	@ApiModelProperty(notes = "SNS 구분 코드 [10-카카오, 20-네이버, 30-페북]")
	private String snsDivCd;
	
	@ApiModelProperty(notes = "신규 가입 여부")
	private String newUserYn;
	
	@ApiModelProperty(notes = "SNS토큰")
	private String snsTokn;
	
	@ApiModelProperty(notes = "사진URL")
	private String photUrl;
	
	
	@ApiModelProperty(notes = "Access Token")
	private String accToken;
}
