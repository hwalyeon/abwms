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
@Service("strsHistService")
public class StrsHistServiceImpl implements StrsHistService
{
	@Autowired
	private FileService fileService;
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate dao;

	// 스트레스_지수_이력 리스트 조회
	public List<Map<String, String>> searchStrsHistList(Map<String, String> params) throws BizException
	{
		List<Map<String, String>> result = dao.selectList("oper.hc.strsHist.selectStrsHistList", params);
		
		return result;
	}
}
