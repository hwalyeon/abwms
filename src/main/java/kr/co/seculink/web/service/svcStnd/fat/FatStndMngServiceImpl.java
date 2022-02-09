package kr.co.seculink.web.service.svcStnd.fat;

import kr.co.seculink.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Slf4j
@Service("fatStndMngService")
public class FatStndMngServiceImpl implements FatStndMngService
{
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate dao;
	
    //비만_기준_리스트 조회
	public List<Map<String, String>> searchFatStndList(Map<String, String> params) throws BizException
	{
		List<Map<String, String>> result = dao.selectList("svcStnd.fat.fatStndMng.searchFatStndList", params);
		return result;
	}
    //비만_기준_버전_리스트 조회
	public List<Map<String, String>> fatStndVerList(Map<String, String> params) throws BizException
	{
		List<Map<String, String>> result = dao.selectList("svcStnd.fat.fatStndMng.searchFatStndVerList", params);
		return result;
	}
    //나이_년수_리스트 조회
	public List<Map<String, String>> ageYcntList(Map<String, String> params) throws BizException
	{
		List<Map<String, String>> result = dao.selectList("svcStnd.fat.fatStndMng.searchAgeYcntList", params);
		return result;
	}


}
