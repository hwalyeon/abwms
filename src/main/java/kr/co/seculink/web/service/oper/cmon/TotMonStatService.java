package kr.co.seculink.web.service.oper.cmon;

import kr.co.seculink.exception.BizException;

import java.util.List;
import java.util.Map;

public interface TotMonStatService
{
	// 종합관제현황_조회
	Map<String, String> searchTotMonStat(Map<String, String> params) throws BizException;

	// 종합관제현황_조회
	List<Map<String, String>> searchTotMonStatDgemHist(Map<String, String> params) throws BizException;

	// 종합관제현황_메뉴_리스트_조회
	List<Map<String, String>> searchTotMonStatMenuList(Map<String, String> params) throws BizException;

}
