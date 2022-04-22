package kr.co.seculink.web.service.cmon.stnd;

import kr.co.seculink.exception.BizException;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface ApiStndMngService
{
	public List<Map<String, String>> searchApiList(Map<String, String> params) throws BizException;
	
	public Map<String, String> searchApiInfo(Map<String, String> params) throws BizException;
	
	public void saveApi(Map<String, String> params) throws BizException;

	public Map<String, String> searchDupSvrId(Map<String, String> params) throws BizException;
}
