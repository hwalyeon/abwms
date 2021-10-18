package kr.co.seculink.api.domain.vo.common;

import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@ApiModel("주소 검색 Input")
public class GEC0310 {

	@ApiModelProperty(notes = "검색어", required = true)
	@NotEmpty
	private String srchWord;
	
	@ApiModelProperty(notes = "현재페이지", required = true)
	@NotEmpty
	private int curPage;
	
	@ApiModelProperty(notes = "페이지당 Count", required = true)
	@NotEmpty
	private int cntPerPage;
	
}
