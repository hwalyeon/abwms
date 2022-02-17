package kr.co.seculink.web.service.cmon.stnd;

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
@Service("csInfoMngService")
public class CsInfoMngServiceImpl implements CsInfoMngService
{
	@Autowired
	private FileService fileService;

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate dao;

	public List<Map<String, String>> searchCsInfoList(Map<String, String> params) throws BizException
	{
		List<Map<String, String>> result = dao.selectList("cmon.stnd.csInfoMng.searchCsInfoList", params);

		return result;
	}

}

