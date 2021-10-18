package kr.co.seculink.api.domain.vo.common;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@ApiModel("코드 검색 Output")
public class GEC0620 {

	@ApiModelProperty(notes = "코드 list")
	private List<GEC0621> list;
	
}
