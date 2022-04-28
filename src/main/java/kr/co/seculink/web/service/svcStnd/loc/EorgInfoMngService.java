package kr.co.seculink.web.service.svcStnd.loc;

import kr.co.seculink.exception.BizException;

import java.util.List;
import java.util.Map;

public interface EorgInfoMngService
{
	// 위치정보_관리_지역_리스트_조회
	List<Map<String, String>> searchEorgInfoList(Map<String, String> params) throws BizException;

	//	주소_헤더_단어_1_리스트_조회
	List<Map<String, String>> searchWordHead1List(Map<String, String> params) throws BizException;

	//	주소_헤더_단어_2_리스트_조회
	List<Map<String, String>> searchWordHead2List(Map<String, String> params) throws BizException;

	//	장소_코드_리스트_조회
	List<Map<String, String>> searchPlcCdList(Map<String, String> params) throws BizException;
}
