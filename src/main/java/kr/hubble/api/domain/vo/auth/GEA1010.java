package kr.hubble.api.domain.vo.auth;

import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@ApiModel("패스워드 찾기 패스워드 변경 Input")
public class GEA1010 {

	@ApiModelProperty(notes = "유저ID", required = true)
	@NotEmpty
	private String userId;
	
	@ApiModelProperty(notes = "패스워드", required = true)
	@NotEmpty
	private String pass;
}
