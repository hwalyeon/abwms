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
@Service("guarFmenuHistService")
public class GuarFmenuHistServiceImpl implements GuarFmenuHistService
{
	@Autowired
	private FileService fileService;
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate dao;

	//보호자_식단표_현황리스트 조회
	public List<Map<String, String>> searchGuarFmenuHistList(Map<String, String> params) throws BizException
	{
		List<Map<String, String>> result = dao.selectList("oper.hc.guarFmenuHist.selectGuarFmenuHistList", params);
		
		return result;
	}

	// 식단_정보 리스트 조회
	public List<Map<String, String>> searchGuarFmenuSpecList(Map<String, String> params) throws BizException
	{
		List<Map<String, String>> result = dao.selectList("oper.hc.guarFmenuHist.selectGuarFmenuSpecList", params);

		return result;
	}
}
