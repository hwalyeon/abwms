package kr.co.seculink.web.service.stat.hc;

import kr.co.seculink.exception.BizException;

import java.util.List;
import java.util.Map;

public interface GidxStssService
{
	public List<Map<String, Object>> searchGidxStssList(Map<String, String> params) throws BizException;

	public List<Map<String, Object>> searchGidxJudgList(Map<String, String> params) throws BizException;
}

