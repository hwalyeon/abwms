package kr.co.seculink.web.service.svcStnd.grow;

import kr.co.seculink.exception.BizException;

import java.util.List;
import java.util.Map;

public interface GrowJudgStndMngService
{
	//성장판정기준 리스트 조회
	public List<Map<String, String>> searchGrowJudgList(Map<String, String> params) throws BizException;
}

