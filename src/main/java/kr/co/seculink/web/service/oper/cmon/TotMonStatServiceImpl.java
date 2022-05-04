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

	// 위험안전발생
	public Map<String, String> searchDgsfOccr(Map<String, String> params) {
		return dao.selectOne("oper.cmon.totMonStat.searchDgsfOccr", params);
	}

	// 위험감정_카운트
	public Map<String, String> searchDgemCnt(Map<String, String> params) {
		return dao.selectOne("oper.cmon.totMonStat.searchDgemCnt", params);
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
