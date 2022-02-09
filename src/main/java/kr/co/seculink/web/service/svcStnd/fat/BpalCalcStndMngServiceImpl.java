package kr.co.seculink.web.service.svcStnd.fat;

import kr.co.seculink.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Slf4j
@Service("bpalCalcStndMngService")
public class BpalCalcStndMngServiceImpl implements BpalCalcStndMngService
{
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate dao;
	
    //휴식대사량_계산_기준_리스트 조회
	public List<Map<String, String>> searchBpalCalcStndList(Map<String, String> params) throws BizException
	{
		List<Map<String, String>> result = dao.selectList("svcStnd.fat.bpalCalcStndMng.selectBpalCalcStndList", params);
		return result;
	}
    //나이_년수_리스트 조회
	public List<Map<String, String>> ageYcntFromList(Map<String, String> params) throws BizException
	{
		List<Map<String, String>> result = dao.selectList("svcStnd.fat.bpalCalcStndMng.searchAgeYcntFromList", params);
		return result;
	}


}
