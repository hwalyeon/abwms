package kr.co.seculink.web.service.oper.cmon;

import kr.co.seculink.exception.BizException;

import java.util.List;
import java.util.Map;

public interface TotMonStatService
{

	// 위험안전발생
	Map<String, String> searchDgsfOccr(Map<String, String> params) throws BizException;

	// 위험지역_추이
	Map<String, String> searchDzonTrnd(Map<String, String> params) throws BizException;

	// 안전위험지역_탐지율
	Map<String, String> searchDgsfDtct(Map<String, String> params) throws BizException;

	// 위험감정_카운트
	Map<String, String> searchDgemCnt(Map<String, String> params) throws BizException;

	// 위험지역_TOP3_공공
	Map<String, String> searchDngrTop3Gorg(Map<String, String> params) throws BizException;

	// 보호자_지정_위험지역_TOP3
	Map<String, String> searchGuarApntDngrTop3(Map<String, String> params) throws BizException;

	// 위험감정_이력
	List<Map<String, String>> searchDgemHist(Map<String, String> params) throws BizException;

	// 종합관제현황_메뉴_리스트_조회
	List<Map<String, String>> searchTotMonStatMenuList(Map<String, String> params) throws BizException;

}
