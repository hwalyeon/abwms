package kr.co.seculink.web.service.svcStnd.loc;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Slf4j
@Service("eorgInfoMngService")
public class EorgInfoMngServiceImpl implements EorgInfoMngService
{
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate dao;

	// 교육시설_정보_조회
	public List<Map<String, String>> searchEorgInfoList(Map<String, String> params) {
		return dao.selectList("svcStnd.loc.eorgInfoMng.selectEorgInfoList", params);
	}

	//	주소_헤더_단어_1_리스트_조회
	public List<Map<String, String>> searchWordHead1List(Map<String, String> params) {
		return dao.selectList("svcStnd.loc.eorgInfoMng.selectWordHead1List", params);
	}

	//	주소_헤더_단어_2_리스트_조회
	public List<Map<String, String>> searchWordHead2List(Map<String, String> params) {
		return dao.selectList("svcStnd.loc.eorgInfoMng.selectWordHead2List", params);
	}

	//	장소코드_리스트_조회
	public List<Map<String, String>> searchPlcCdList(Map<String, String> params) {
		return dao.selectList("svcStnd.loc.eorgInfoMng.selectPlcCdList", params);
	}
}
