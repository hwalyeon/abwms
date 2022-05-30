package kr.co.seculink.web.service.oper.hc;

import kr.co.seculink.exception.BizException;
import kr.co.seculink.web.service.cmon.FileService;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Slf4j
@Service("eatHistService")
public class EatHistServiceImpl implements EatHistService
{
	@Autowired
	private FileService fileService;
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate dao;

	// 섭취_이력 리스트 조회
	public List<Map<String, String>> searchEatHistList(Map<String, String> params) throws BizException
	{
	    System.out.println("음냐=" + params);
		List<Map<String, String>> result = dao.selectList("oper.hc.eatHist.selectEatHistList", params);
		
		return result;
	}
	// 식단_정보 리스트 조회
	public List<Map<String, String>> searchFmenuSpecList(Map<String, String> params) throws BizException
	{
		List<Map<String, String>> result = dao.selectList("oper.hc.eatHist.selectFmenuSpecList", params);

		return result;
	}
	// 섭취_영양소_정보 리스트 조회
	public List<Map<String, String>> searchEatNutrSpecList(Map<String, String> params) throws BizException
	{
		List<Map<String, String>> result = dao.selectList("oper.hc.eatHist.selectEatNutrSpecList", params);

		return result;
	}
}
