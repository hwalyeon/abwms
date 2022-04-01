package kr.co.seculink.web.service.oper.dgem;

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
@Service("dgemHistService")
public class DgemHistServiceImpl implements DgemHistService
{
	@Autowired
	private FileService fileService;

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate dao;

	//위험감정 발생이력 목록
	public List<Map<String, String>> searchDgemHistList(Map<String, String> params) throws BizException
	{
		List<Map<String, String>> result = dao.selectList("oper.dgem.dgemHist.searchDgemHistList", params);

		return result;
	}
	//학생정보 및 보호자 정보
	public List<Map<String, String>> searchStdtGuarList(Map<String, String> params) throws BizException
	{
		List<Map<String, String>> result = dao.selectList("oper.dgem.dgemHist.searchStdtGuarList", params);

		return result;
	}
	//학교정보 리스트 조회
	public List<Map<String, String>> searchLocList(Map<String, String> params) throws BizException
	{
		List<Map<String, String>> result = dao.selectList("oper.dgem.dgemHist.searchLocList", params);

		return result;
	}
}

