package kr.co.seculink.api.domain.vo.common;

import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@ApiModel("제품 검색 Input")
public class GEC0110 {

	@ApiModelProperty(notes = "검색어", required = true)
	@NotEmpty
	private String srchWord;
	
}
