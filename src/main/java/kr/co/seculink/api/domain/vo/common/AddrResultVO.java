package kr.co.seculink.api.domain.vo.common;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("주소 검색 Output")
public class AddrResultVO {

	@ApiModelProperty(notes = "총 건수")
	private int totCnt;
	@ApiModelProperty(notes = "현재페이지")
	private int curPage;
	@ApiModelProperty(notes = "페이지당 건수")
	private int cntPerPage;
	
	@ApiModelProperty(notes = "조회 결과 목록")
	private List<AddrDetail> list;
}
