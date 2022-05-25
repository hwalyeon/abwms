package kr.co.seculink.web.service.oper.cmon;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Slf4j
@Service("totMonStatService")
public class TotMonStatServiceImpl implements TotMonStatService
{
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate dao;

	// 가동_현황
	public Map<String, String> searchBandOperStat(Map<String, String> params) {
		return dao.selectOne("oper.cmon.totMonStat.searchBandOperStat", params);
	}

	// 개통_현황
	public Map<String, String> searchBandOpenStat(Map<String, String> params) {
		return dao.selectOne("oper.cmon.totMonStat.searchBandOpenStat", params);
	}

	// 헬스케어_활용율
	public Map<String, String> searchHcUseRt(Map<String, String> params) {
		return dao.selectOne("oper.cmon.totMonStat.searchHcUseRt", params);
	}

	// 위험안전발생
	public Map<String, String> searchDgsfOccr(Map<String, String> params) {
		return dao.selectOne("oper.cmon.totMonStat.searchDgsfOccr", params);
	}

	// 위험지역_추이
	public Map<String, String> searchDzonTrnd(Map<String, String> params) {
		return dao.selectOne("oper.cmon.totMonStat.searchDzonTrnd", params);
	}

	// 안전위험지역_탐지율
	public Map<String, String> searchDgsfDtct(Map<String, String> params) {
		return dao.selectOne("oper.cmon.totMonStat.searchDgsfDtct", params);
	}

	// 위험감정_카운트
	public Map<String, String> searchDgemCnt(Map<String, String> params) {
		return dao.selectOne("oper.cmon.totMonStat.searchDgemCnt", params);
	}

	// 위험지역_TOP3_공공
	public Map<String, String> searchDngrTop3Gorg(Map<String, String> params) {
		return dao.selectOne("oper.cmon.totMonStat.searchDngrTop3Gorg", params);
	}

	// 보호자_지정_위험지역_TOP3
	public Map<String, String> searchGuarApntDngrTop3(Map<String, String> params) {
		return dao.selectOne("oper.cmon.totMonStat.searchGuarApntDngrTop3", params);
	}

	// 위험감정_이력
	public List<Map<String, String>> searchDgemHist(Map<String, String> params) {
		return dao.selectList("oper.cmon.totMonStat.searchDgemHist", params);
	}

	// 헬스케어_성장지수
	public Map<String, String> searchHcGidx(Map<String, String> params) {
		return dao.selectOne("oper.cmon.totMonStat.searchHcGidx", params);
	}

	// 헬스케어_BMI_체질량지수
	public Map<String, String> searchHcBmiIdx(Map<String, String> params) {
		return dao.selectOne("oper.cmon.totMonStat.searchHcBmiIdx", params);
	}

	// 헬스케어_비만지수
	public Map<String, String> searchHcFidx(Map<String, String> params) {
		return dao.selectOne("oper.cmon.totMonStat.searchHcFidx", params);
	}

	// 헬스케어_비만예측
	public Map<String, String> searchHcFpidx(Map<String, String> params) {
		return dao.selectOne("oper.cmon.totMonStat.searchHcFpidx", params);
	}

	// 헬스케어_스트레스
	public Map<String, String> searchHcStrs(Map<String, String> params) {
		return dao.selectOne("oper.cmon.totMonStat.searchHcStrs", params);
	}

	// 헬스케어_평균_운동시간
	public Map<String, String> searchHcAvgAct(Map<String, String> params) {
		return dao.selectOne("oper.cmon.totMonStat.searchHcAvgAct", params);
	}

	// 헬스케어_평균_칼로리_섭취
	public Map<String, String> searchHcAvgCalEat(Map<String, String> params) {
		return dao.selectOne("oper.cmon.totMonStat.searchHcAvgCalEat", params);
	}

	// 헬스케어_주요식단_TOP3
	public Map<String, String> searchHcFmenuTop3(Map<String, String> params) {
		return dao.selectOne("oper.cmon.totMonStat.searchHcFmenuTop3", params);
	}

	// 헬스케어_아침식사_결식율
	public Map<String, String> searchHcMmelNeat(Map<String, String> params) {
		return dao.selectOne("oper.cmon.totMonStat.searchHcMmelNeat", params);
	}

	// 종합관제현황_메뉴_리스트_조회
	public List<Map<String, String>> searchTotMonStatMenuList(Map<String, String> params) {
		return dao.selectList("oper.cmon.totMonStat.searchTotMonStatMenuList", params);
	}

}
