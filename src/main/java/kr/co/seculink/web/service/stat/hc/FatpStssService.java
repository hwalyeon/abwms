package kr.co.seculink.web.service.stat.hc;

import kr.co.seculink.exception.BizException;

import java.util.List;
import java.util.Map;

public interface FatpStssService
{
	public List<Map<String, Object>> searchFatpStssList(Map<String, String> params) throws BizException;

	public List<Map<String, Object>> searchFatpJudgList(Map<String, String> params) throws BizException;
}

