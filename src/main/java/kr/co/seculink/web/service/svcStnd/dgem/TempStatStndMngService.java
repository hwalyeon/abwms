package kr.co.seculink.web.service.svcStnd.dgem;

import kr.co.seculink.exception.BizException;

import java.util.List;
import java.util.Map;

public interface TempStatStndMngService
{
	public List<Map<String, String>> searchTempStatStndList(Map<String, String> params) throws BizException;

	public void saveTempStatStnd(Map<String,Object> params) throws BizException;
}

