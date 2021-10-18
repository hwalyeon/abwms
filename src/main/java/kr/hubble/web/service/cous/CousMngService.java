package kr.hubble.web.service.cous;

import java.util.List;
import java.util.Map;

import kr.co.seculink.exception.BizException;

public interface CousMngService
{
	public List<Map<String, String>> searchCousList(Map<String, String> params) throws BizException;
	
	public Map<String, String> searchCous(Map<String, String> params) throws BizException;
	
	public void saveCous(Map<String, String> params) throws BizException;
	
}
