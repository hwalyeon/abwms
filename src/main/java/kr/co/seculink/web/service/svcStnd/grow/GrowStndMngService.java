package kr.co.seculink.web.service.svcStnd.grow;

import kr.co.seculink.exception.BizException;

import java.util.List;
import java.util.Map;

public interface GrowStndMngService
{
	//성장_기준_리스트 조회
	public List<Map<String, String>> growStndList(Map<String, String> params) throws BizException;

	//성장_기준_버전_리스트 조회	
	public List<Map<String, String>> growStndVerList(Map<String, String> params) throws BizException;

	//나이_년수_리스트 조회
	public List<Map<String, String>> ageYcntList(Map<String, String> params) throws BizException;

}
