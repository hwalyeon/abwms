package kr.co.seculink.web.service.svcStnd.fat;

import kr.co.seculink.exception.BizException;

import java.util.List;
import java.util.Map;

public interface FatStndMngService
{
	//비만_기준_리스트 조회
	public List<Map<String, String>> searchFatStndList(Map<String, String> params) throws BizException;
  
	//비만_기준_버전_리스트 조회	
	public List<Map<String, String>> fatStndVerList(Map<String, String> params) throws BizException;

    //나이_년수_리스트 조회
	public List<Map<String, String>> ageYcntList(Map<String, String> params) throws BizException;

	}
