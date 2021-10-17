package kr.hubble.api.domain.vo.auth;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("사용자ID찾기 Output")
public class GEA0720 {

	@ApiModelProperty(notes = "사용자ID")
	private String userId;
	
	@ApiModelProperty(notes = "가입일자")
	private String joinDt;
	
	@ApiModelProperty(notes = "SNS구분코드")
	private String sndDivCd;
}
