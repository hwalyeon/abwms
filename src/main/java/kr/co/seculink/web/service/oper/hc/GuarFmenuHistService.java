package kr.co.seculink.web.service.oper.hc;

import kr.co.seculink.exception.BizException;

import java.util.List;
import java.util.Map;

public interface GuarFmenuHistService
{
	//보호자_식단표_현황리스트 조회
	public List<Map<String, String>> searchGuarFmenuHistList(Map<String, String> params) throws BizException;
}
 