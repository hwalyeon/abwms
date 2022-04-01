package kr.co.seculink.web.service.oper.dgem;

import kr.co.seculink.exception.BizException;

import java.util.List;
import java.util.Map;

public interface LocHistService
{
	//위치 이력 리스트
	public List<Map<String, String>> searchLocHistList(Map<String, String> params) throws BizException;
}

