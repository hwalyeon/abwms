package kr.co.seculink.web.service.oper.hc;

import kr.co.seculink.exception.BizException;

import java.util.List;
import java.util.Map;

public interface GfixHistService
{
	//성장/비만_지수_이력 리스트 조회
	public List<Map<String, String>> searchGfixHistList(Map<String, String> params) throws BizException;
}
 