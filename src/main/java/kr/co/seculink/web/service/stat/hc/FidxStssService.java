package kr.co.seculink.web.service.stat.hc;

import kr.co.seculink.exception.BizException;

import java.util.List;
import java.util.Map;

public interface FidxStssService
{
	public List<Map<String, Object>> searchFidxStssList(Map<String, String> params) throws BizException;

	public List<Map<String, Object>> searchFidxJudgList(Map<String, String> params) throws BizException;
}

