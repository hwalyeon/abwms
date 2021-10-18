package kr.co.seculink.api.domain.vo.common;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("좌표 검색 Output")
public class CoordResultVO {

	@ApiModelProperty(notes = "총 건수")
	private int totCnt;

	@ApiModelProperty(notes = "조회 결과 목록")
	private List<CoordDetail> list;
}
