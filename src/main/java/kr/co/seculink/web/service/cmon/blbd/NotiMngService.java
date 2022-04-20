package kr.co.seculink.web.service.cmon.blbd;

import kr.co.seculink.exception.BizException;

import java.util.List;
import java.util.Map;

public interface NotiMngService
{
	public List<Map<String, String>> searchUserList(Map<String, String> params) throws BizException;
	
	public Map<String, String> searchUserInfo(Map<String, String> params) throws BizException;
	
	public void saveUser(Map<String, String> params) throws BizException;
	
	public Map<String, String> searchDupUserId(Map<String, String> params) throws BizException;
}
