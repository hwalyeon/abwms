package kr.hubble.api.domain.vo.juso;

import lombok.Data;

@Data
public class JusoResponseCommon {

	/** 총 검색 데이터수 */
	private String totalCount;
	
	/** 페이지 번호 */
	private int currentPage;
	
	/** 페이지당 출력할 결과 Row 수 */
	private int countPerPage;
	
	/** 에러 코드 */
	private String errorCode;
	
	/** 에러 메시지 */
	private String errorMessage;
	
}
