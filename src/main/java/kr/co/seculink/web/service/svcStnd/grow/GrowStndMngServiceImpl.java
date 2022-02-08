package kr.co.seculink.web.service.svcStnd.grow;

import kr.co.seculink.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Slf4j
@Service("growStndMngService")
public class GrowStndMngServiceImpl implements GrowStndMngService
{
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate dao;
	
	public List<Map<String, String>> growStndVerList(Map<String, String> params) throws BizException
	{
		List<Map<String, String>> result = dao.selectList("svcStnd.grow.growStndMng.searchGrowStndVerList", params);
		
		return result;
	}

	public List<Map<String, String>> ageYcntList(Map<String, String> params) throws BizException
	{
		List<Map<String, String>> result = dao.selectList("svcStnd.grow.growStndMng.searchAgeYcntList", params);
		return result;
	}

	public List<Map<String, String>> growStndList(Map<String, String> params) throws BizException
	{
		List<Map<String, String>> result = dao.selectList("svcStnd.grow.growStndMng.searchGrowStndList", params);
		return result;
	}

}
