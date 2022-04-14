package kr.co.seculink.web.service.stat.etc;

import kr.co.seculink.exception.BizException;

import java.util.List;
import java.util.Map;

public interface AlamStssService
{
	public List<Map<String, Object>> searchAlamStssList(Map<String, String> params) throws BizException;

}

