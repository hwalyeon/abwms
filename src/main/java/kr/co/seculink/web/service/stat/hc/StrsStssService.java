package kr.co.seculink.web.service.stat.hc;

import kr.co.seculink.exception.BizException;

import java.util.List;
import java.util.Map;

public interface StrsStssService
{
	public List<Map<String, Object>> searchStrsStssList(Map<String, String> params) throws BizException;

	public List<Map<String, Object>> searchStrsJudgList(Map<String, String> params) throws BizException;
}

