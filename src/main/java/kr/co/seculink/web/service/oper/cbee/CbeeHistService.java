package kr.co.seculink.web.service.oper.cbee;

import kr.co.seculink.exception.BizException;

import java.util.List;
import java.util.Map;

public interface CbeeHistService
{
	// 스트레스_지수_이력 리스트 조회
	public List<Map<String, String>> searchCbeeHistList(Map<String, String> params) throws BizException;
}
 