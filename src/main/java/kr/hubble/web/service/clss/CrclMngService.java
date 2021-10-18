package kr.hubble.web.service.clss;

import java.util.List;
import java.util.Map;

import kr.co.seculink.exception.BizException;

public interface CrclMngService
{
	public List<Map<String, String>> searchCrclList(Map<String, String> params)throws BizException;
	
	public void saveCrcl(Map<String, String> params)throws BizException;
}
