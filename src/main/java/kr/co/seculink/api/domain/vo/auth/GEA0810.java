package kr.co.seculink.api.domain.vo.auth;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Data;

@Data
@ApiModel("사용자 비밀번호 찾기 Input")
public class GEA0810 {

	@ApiModelProperty(notes = "사용자ID", required = true)
	@NotBlank
	private String userId;
	
	@ApiModelProperty(notes = "사용자명", required = true)
	@NotBlank
	private String userNm;
	
	@ApiModelProperty(notes = "휴대폰 번호", required = true)
	@NotBlank
	private String hp;
}
