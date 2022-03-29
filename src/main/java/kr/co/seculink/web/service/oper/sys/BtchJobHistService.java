package kr.co.seculink.web.service.oper.sys;

import kr.co.seculink.exception.BizException;

import java.util.List;
import java.util.Map;

public interface BtchJobHistService
{
	public List<Map<String, String>> searchBtchJobHistList(Map<String, String> params) throws BizException;

	public Map<String, Object> searchStdtDetlInfo(Map<String, String> params) throws BizException;

	public void saveStdtInfo(Map<String, Object> params) throws BizException;
}

