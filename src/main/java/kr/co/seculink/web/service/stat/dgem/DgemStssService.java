package kr.co.seculink.web.service.stat.dgem;

import kr.co.seculink.exception.BizException;

import java.util.List;
import java.util.Map;

public interface DgemStssService
{
	public List<Map<String, Object>> searchDgemStssList(Map<String, String> params) throws BizException;

	public List<Map<String, Object>> searchDgemJudgList(Map<String, String> params) throws BizException;
}

