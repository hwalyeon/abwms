package kr.hubble.api.domain.vo.juso;

import lombok.Data;

@Data
public class CoordResponseCommon {

	/** 총 검색 데이터수 */
	private String totalCount;
	
	/** 에러 코드 */
	private String errorCode;
	
	/** 에러 메시지 */
	private String errorMessage;
	
}
