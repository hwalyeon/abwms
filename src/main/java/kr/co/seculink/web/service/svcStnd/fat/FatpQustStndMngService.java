package kr.co.seculink.web.service.svcStnd.fat;

import kr.co.seculink.exception.BizException;

import java.util.List;
import java.util.Map;

public interface FatpQustStndMngService
{
	public List<Map<String, String>> searchFatpQustList(Map<String, String> params) throws BizException;

	public void saveFatpQustList(Map<String, Object> params) throws BizException;
	//중복 조회
	public Map<String, String> searchDupCdCk(Map<String, String> params) throws BizException;

}
 