package kr.co.seculink.web.service.svcStnd.dgem;

import kr.co.seculink.exception.BizException;

import java.util.List;
import java.util.Map;

public interface HbitStatStndMngService
{
	public List<Map<String, String>> searchHbitStatStndList(Map<String, String> params) throws BizException;

	public void saveHbitStatStnd(Map<String,Object> params) throws BizException;
}

