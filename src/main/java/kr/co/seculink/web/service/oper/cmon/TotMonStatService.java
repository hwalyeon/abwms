package kr.co.seculink.web.service.oper.cmon;

import kr.co.seculink.exception.BizException;

import java.util.List;
import java.util.Map;

public interface TotMonStatService
{
	// 가동_현황
	Map<String, String> searchBandOperStat(Map<String, String> params) throws BizException;

	// 개통_현황
	Map<String, String> searchBandOpenStat(Map<String, String> params) throws BizException;

	// 헬스케어_활용율
	Map<String, String> searchHcUseRt(Map<String, String> params) throws BizException;

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

	// 헬스케어_BMI_체질량지수
	Map<String, String> searchHcBmiIdx(Map<String, String> params) throws BizException;

	// 헬스케어_성장지수
	Map<String, String> searchHcGidx(Map<String, String> params) throws BizException;

	// 헬스케어_비만지수
	Map<String, String> searchHcFidx(Map<String, String> params) throws BizException;

	// 헬스케어_비만예측
	Map<String, String> searchHcFpidx(Map<String, String> params) throws BizException;

	// 헬스케어_스트레스
	Map<String, String> searchHcStrs(Map<String, String> params) throws BizException;

	// 헬스케어_평균_운동시간
	Map<String, String> searchHcAvgAct(Map<String, String> params) throws BizException;

	// 헬스케어_평균_칼로리_섭취
	Map<String, String> searchHcAvgCalEat(Map<String, String> params) throws BizException;

	// 헬스케어_주요식단_TOP3
	Map<String, String> searchHcFmenuTop3(Map<String, String> params) throws BizException;

	// 헬스케어_아침식사_결식율
	Map<String, String> searchHcMmelNeat(Map<String, String> params) throws BizException;

	// 종합관제현황_메뉴_리스트_조회
	List<Map<String, String>> searchTotMonStatMenuList(Map<String, String> params) throws BizException;

}
