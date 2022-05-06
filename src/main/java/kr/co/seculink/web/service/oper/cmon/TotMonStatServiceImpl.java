package kr.co.seculink.web.service.oper.cmon;

import kr.co.seculink.exception.BizException;
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

	// 종합관제현황_메뉴_리스트_조회
	public List<Map<String, String>> searchTotMonStatMenuList(Map<String, String> params) {
		return dao.selectList("oper.cmon.totMonStat.searchTotMonStatMenuList", params);
	}

}
