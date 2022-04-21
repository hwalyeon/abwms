package kr.co.seculink.web.service.cmon.blbd;

import kr.co.seculink.exception.BizException;

import java.util.List;
import java.util.Map;

public interface NotiMngService
{
	public List<Map<String, String>> searchNotiList(Map<String, String> params) throws BizException;
	
	public Map<String, String> searchNotiInfo(Map<String, String> params) throws BizException;
	
	public void saveNoti(Map<String, String> params) throws BizException;
}
