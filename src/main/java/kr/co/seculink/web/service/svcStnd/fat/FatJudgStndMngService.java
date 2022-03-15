package kr.co.seculink.web.service.svcStnd.fat;

import kr.co.seculink.exception.BizException;

import java.util.List;
import java.util.Map;

public interface FatJudgStndMngService
{
	//비만판정기준 리스트 조회
	public List<Map<String, String>> searchFatJudgList(Map<String, String> params) throws BizException;
}

