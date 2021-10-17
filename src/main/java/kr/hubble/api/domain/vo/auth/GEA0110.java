package kr.hubble.api.domain.vo.auth;

import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@ApiModel("로그인 Input")
public class GEA0110 {

	@ApiModelProperty(notes = "사용자 ID", required = true)
	@NotEmpty
	private String userId;
	
	@ApiModelProperty(notes = "패스워드", required = true)
	@NotEmpty
	private String pass;
	
	@ApiModelProperty(notes = "Client ID", required = true)
	@NotEmpty
	private String clientId;
	
	@ApiModelProperty(notes = "FCM Token")
	private String fcmTokn;
}
