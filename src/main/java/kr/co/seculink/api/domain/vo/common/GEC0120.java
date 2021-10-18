package kr.co.seculink.api.domain.vo.common;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@ApiModel("제품 검색 Output")
public class GEC0120 {

	@ApiModelProperty(notes = "제품 list")
	private List<GEC0121> list;
	
}
