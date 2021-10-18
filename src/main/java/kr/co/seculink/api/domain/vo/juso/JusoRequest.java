package kr.co.seculink.api.domain.vo.juso;

import lombok.Data;

@Data
public class JusoRequest {

	/** 신청시 발급받은 승인키 */
	private String confmKey;
	
	/** 현재 페이지 번호 */
	private String currentPage;
	
	/** 페이지당 출력할 결과 Row 수 */
	private String countPerPage;
	
	/** 주소 검색어 */
	private String keyword;
	
	/** 검색결과형식 설정(xml, json) */
	private String resultType;
}
