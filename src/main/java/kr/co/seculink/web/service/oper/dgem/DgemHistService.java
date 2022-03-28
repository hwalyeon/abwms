package kr.co.seculink.web.service.oper.dgem;

import kr.co.seculink.exception.BizException;

import java.util.List;
import java.util.Map;

public interface DgemHistService
{
	public List<Map<String, String>> searchDgemHistList(Map<String, String> params) throws BizException;

	public List<Map<String, String>> searchStdtGuarList(Map<String, String> params) throws BizException;

	public List<Map<String, String>> searchLocList(Map<String, String> params) throws BizException;

	public Map<String, Object> searchStdtDetlInfo(Map<String, String> params) throws BizException;

	public void saveStdtInfo(Map<String, Object> params) throws BizException;
}

