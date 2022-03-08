package kr.co.seculink.web.service.svcStnd.strs;

import kr.co.seculink.exception.BizException;
import kr.co.seculink.util.GEUtil;
import kr.co.seculink.util.XUtil;
import kr.co.seculink.web.model.cmon.TcFileVO;
import kr.co.seculink.web.service.cmon.FileService;
import kr.co.seculink.web.service.svcStnd.dgem.DgemStndMngService;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service("strsStndMngService")
public class StrsStndMngServiceImpl implements StrsStndMngService
{
	@Autowired
	private FileService fileService;

	@Autowired
	private DgemStndMngService dgemStndMngService;
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate dao;
	
	public List<Map<String, String>> searchStrsList(Map<String, String> params) throws BizException
	{
		List<Map<String, String>> result = dao.selectList("svcStnd.strs.strsStndMng.searchStrsList", params);

		return result;
	}

	public List<Map<String, String>> searchCdSpecList(Map<String, String> params) throws BizException
	{
		List<Map<String, String>> result = dao.selectList("svcStnd.strs.strsStndMng.searchCdSpecList", params);

		return result;
	}

	public Map<String, String> searchmentphysCd(Map<String, String> params) throws BizException
	{

		Map<String, String> result = dao.selectOne("svcStnd.strs.strsStndMng.mentphysCd", params);

		Map<String, String> rtnMap = new HashMap<>();

		if ( result == null || GEUtil.isEmpty(result.get("mentStrsStatCd")) ) {
			rtnMap.put("existsYn", "N");
		} else {
			rtnMap.put("existsYn", "Y");
			rtnMap.put("mentStrsStatNm", result.get("mentStrsStatNm"));
			rtnMap.put("physStrsStatNm", result.get("physStrsStatNm"));
		}

		return rtnMap;
	}

}

