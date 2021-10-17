package kr.hubble.api.domain.vo.auth;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("사용자ID찾기 Output")
public class GEA0820 {

	@ApiModelProperty(notes = "사용자ID")
	private String userId;
	
	@ApiModelProperty(notes = "휴대폰번호")
	private String hp;
	
	@ApiModelProperty(notes = "SNS구분코드")
	private String sndDivCd;
	
	@ApiModelProperty(notes = "인증번호 전송여부")
	private String sendSmsYn;
}
