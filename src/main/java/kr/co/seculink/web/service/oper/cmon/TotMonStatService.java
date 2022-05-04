package kr.co.seculink.web.service.oper.cmon;

import kr.co.seculink.exception.BizException;

import java.util.List;
import java.util.Map;

public interface TotMonStatService
{
	// 위험안전발생
	Map<String, String> searchDgsfOccr(Map<String, String> params) throws BizException;

	// 위험감정_카운트
	Map<String, String> searchDgemCnt(Map<String, String> params) throws BizException;

	// 위험감정_이력
	List<Map<String, String>> searchDgemHist(Map<String, String> params) throws BizException;

	// 종합관제현황_메뉴_리스트_조회
	List<Map<String, String>> searchTotMonStatMenuList(Map<String, String> params) throws BizException;

}
