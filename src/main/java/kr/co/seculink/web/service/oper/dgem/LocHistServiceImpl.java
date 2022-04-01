package kr.co.seculink.web.service.oper.dgem;

import io.netty.util.internal.StringUtil;
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
@Service("locHistService")
public class LocHistServiceImpl implements LocHistService
{
	@Autowired
	private FileService fileService;

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate dao;

	//위치 이력 리스트
	public List<Map<String, String>> searchLocHistList(Map<String, String> params) throws BizException
	{
		List<Map<String, String>> result = dao.selectList("oper.dgem.locHist.searchLocHistList", params);

		return result;
	}
}

