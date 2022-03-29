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

	// 종합관제현황_조회
	public Map<String, String> searchTotMonStat(Map<String, String> params) {
		return dao.selectOne("oper.cmon.totMonStat.searchTotMonStat", params);
	}

	// 종합관제현황_위험감정_이력_조회
	public List<Map<String, String>> searchTotMonStatDgemHist(Map<String, String> params) {
		return dao.selectList("oper.cmon.totMonStat.searchTotMonStatDgemHist", params);
	}
}
