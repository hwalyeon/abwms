package kr.co.seculink.web.service.oper.dgem;

import kr.co.seculink.exception.BizException;

import java.util.List;
import java.util.Map;

public interface LocHistService
{
	public List<Map<String, String>> searchLocHistList(Map<String, String> params) throws BizException;

	public Map<String, Object> searchStdtDetlInfo(Map<String, String> params) throws BizException;

	public void saveStdtInfo(Map<String, Object> params) throws BizException;
}

