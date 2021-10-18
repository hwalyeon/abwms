package kr.co.seculink.api.domain.vo.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@ApiModel("코드 list")
public class GEC0621 {

	@ApiModelProperty(notes = "코드", required = true, position = -1)
	private String cd;
	@ApiModelProperty(notes = "코드명")
	private String cdNm;
	@ApiModelProperty(notes = "상위코드")
	private String upCd;
	@ApiModelProperty(notes = "기타정보1")
	private String etcInfo1;
	@ApiModelProperty(notes = "기타정보2")
	private String etcInfo2;
	@ApiModelProperty(notes = "기타정보3")
	private String etcInfo3;
}
