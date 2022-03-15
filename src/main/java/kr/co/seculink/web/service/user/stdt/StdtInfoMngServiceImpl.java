package kr.co.seculink.web.service.user.stdt;

import kr.co.seculink.domain.RtnMsg;
import kr.co.seculink.exception.BizException;
import kr.co.seculink.util.GEUtil;
import kr.co.seculink.web.service.cmon.FileService;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service("stdtInfoMngService")
public class StdtInfoMngServiceImpl implements StdtInfoMngService
{
	@Autowired
	private FileService fileService;

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate dao;

	//학생정보 리스트 조회
	public List<Map<String, String>> searchStdtInfoList(Map<String, String> params) throws BizException
	{
		List<Map<String, String>> result = dao.selectList("user.stdt.stdtInfoMng.searchStdtInfoList", params);

		return result;
	}
}

