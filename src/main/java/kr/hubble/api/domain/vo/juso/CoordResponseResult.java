package kr.hubble.api.domain.vo.juso;

import java.util.List;

import lombok.Data;

@Data
public class CoordResponseResult {

	private CoordResponseCommon common;
	
	private List<CoordResponseDetail> juso;
	
}
