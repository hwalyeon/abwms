package kr.hubble.web.service.cous;

import java.util.List;
import java.util.Map;

import kr.hubble.exception.BizException;

public interface LectMngService
{
	public List<Map<String, String>> searchLectTakeObj() throws BizException;
	
	public void insertLectTake(Map<String, String> params) throws BizException;
	
	public void updateChangeCousStdtStat() throws BizException;
	
	public void updateChangeCousStat() throws BizException;
}
