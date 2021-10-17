package kr.hubble.api.domain.vo.auth;

import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@ApiModel("휴대폰 인증 확인 Input")
public class GEA0510 {

	@NotEmpty
	@ApiModelProperty(notes = "휴대폰 번호", required = true)
	private String hp;
	
	@NotEmpty
	@ApiModelProperty(notes = "인증번호", required = true)
	private String authNo;
}
