package kr.co.seculink.web.service.oper.cbee;

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
@Service("cbeeHistService")
public class CbeeHistServiceImpl implements CbeeHistService
{
	@Autowired
	private FileService fileService;
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate dao;

	// 캐시비 리스트 조회
	public List<Map<String, String>> searchCbeeHistList(Map<String, String> params) throws BizException
	{
		List<Map<String, String>> result = dao.selectList("oper.cbee.cbeeHist.selectCbeeHistList", params);
		
		return result;
	}
}
