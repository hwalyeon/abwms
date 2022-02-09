package kr.co.seculink.web.service.svcStnd.grow;

import kr.co.seculink.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Slf4j
@Service("actStndMngService")
public class ActStndMngServiceImpl implements ActStndMngService
{
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate dao;
	
    //활동_기준_리스트 조회
	public List<Map<String, String>> actStndList(Map<String, String> params) throws BizException
	{
		List<Map<String, String>> result = dao.selectList("svcStnd.grow.actStndMng.searchActStndList", params);
		return result;
	}
    //활동_분류_코드_리스트 조회
	public List<Map<String, String>> actClssCdList(Map<String, String> params) throws BizException
	{
		List<Map<String, String>> result = dao.selectList("svcStnd.grow.actStndMng.searchActClssCdList", params);
		
		return result;
	}
    //활동_코드_명_리스트 조회
	public List<Map<String, String>> actCdNmList(Map<String, String> params) throws BizException
	{
		List<Map<String, String>> result = dao.selectList("svcStnd.grow.actStndMng.searchActCdNmList", params);
		return result;
	}


}
