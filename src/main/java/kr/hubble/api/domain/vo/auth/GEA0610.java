package kr.hubble.api.domain.vo.auth;

import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@ApiModel("SNS 로그인 Input")
public class GEA0610 {

	@ApiModelProperty(notes = "유저ID(이메일주소)", required = true)
	@NotEmpty
	private String userId;
	
	@ApiModelProperty(notes = "SNS 구분 코드 [10-카카오, 20-네이버, 30-페북]", required = true)
	@NotEmpty
	private String snsDivCd;
	
	@ApiModelProperty(notes = "SNS 인증 토큰", required = true)
	@NotEmpty
	private String snsTokn;
	
	@ApiModelProperty(notes = "Client ID", required = true)
	@NotEmpty
	private String clientId;
	
	@ApiModelProperty(notes = "사용자 명")
	private String userNm;
	
	@ApiModelProperty(notes = "휴대폰 번호")
	private String hp;
	
	@ApiModelProperty(notes = "FCM Token")
	private String fcmTokn;
}
