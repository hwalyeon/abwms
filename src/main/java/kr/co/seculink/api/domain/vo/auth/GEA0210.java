package kr.co.seculink.api.domain.vo.auth;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@ApiModel("회원가입 Input")
public class GEA0210 {

	@ApiModelProperty(notes = "사용자 명")
	private String userNm;
	
	@ApiModelProperty(notes = "사용자 ID")
	private String userId;
	
	@ApiModelProperty(notes = "패스워드")
	private String pass;
	
	@ApiModelProperty(notes = "휴대폰 번호")
	private String hp;
}
