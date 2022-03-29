package kr.co.seculink.web.service.oper.hc;

import kr.co.seculink.exception.BizException;

import java.util.List;
import java.util.Map;

public interface ActHistService
{
	//활동_이력 리스트 조회
	public List<Map<String, String>> searchActHistList(Map<String, String> params) throws BizException;
	//활동_코드 리스트 조회
	public List<Map<String, String>> searchActCdList(Map<String, String> params) throws BizException;
}
 