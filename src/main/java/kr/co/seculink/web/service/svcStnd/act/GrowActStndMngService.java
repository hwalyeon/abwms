package kr.co.seculink.web.service.svcStnd.act;

import kr.co.seculink.exception.BizException;

import java.util.List;
import java.util.Map;

public interface GrowActStndMngService
{
	//성장활동_기준_리스트 조회
	public List<Map<String, String>> searchGrowActStndList(Map<String, String> params) throws BizException;

	//상세보기_저장
	public void saveGrowActStndInfo(Map<String,Object> params) throws BizException;

}
