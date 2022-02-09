package kr.co.seculink.web.service.svcStnd.fat;

import kr.co.seculink.exception.BizException;
import kr.co.seculink.web.service.cmon.FileService;
import kr.co.seculink.web.service.svcStnd.strs.StrsStndMngService;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Slf4j
@Service("bpalCalcStndMngService")
public class BpalCalcStndMngServiceImpl implements BpalCalcStndMngService
{
	@Autowired
	private FileService fileService;
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate dao;
	
	public List<Map<String, String>> searchBpalCalcList(Map<String, String> params) throws BizException
	{
		List<Map<String, String>> result = dao.selectList("svcStnd.fat.bpalCalcStndMng.searchBpalCalcList", params);

		return result;
	}

}

