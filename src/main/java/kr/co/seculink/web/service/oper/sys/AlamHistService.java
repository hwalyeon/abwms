package kr.co.seculink.web.service.oper.sys;

import kr.co.seculink.exception.BizException;

import java.util.List;
import java.util.Map;

public interface AlamHistService
{
	public List<Map<String, String>> searchAlamHistList(Map<String, String> params) throws BizException;
}

