package kr.co.seculink.api.domain.vo.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@ApiModel("제품 list")
public class GEC0121 {

	@ApiModelProperty(notes = "제품ID", required = true, position = -1)
	private String prdtId;
	@ApiModelProperty(notes = "제휴사ID")
	private String allcId;
	@ApiModelProperty(notes = "제휴사명")
	private String allcNm;
	@ApiModelProperty(notes = "제품명")
	private String prdtNm;
	@ApiModelProperty(notes = "모델명")
	private String modlNm;
	@ApiModelProperty(notes = "AS기간")
	private String asPird;
	@ApiModelProperty(notes = "제품사진URL")
	private String prdtPhtoUrl;
}
