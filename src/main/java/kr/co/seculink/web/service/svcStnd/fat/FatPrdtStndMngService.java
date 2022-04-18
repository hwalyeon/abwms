package kr.co.seculink.web.service.svcStnd.fat;

import kr.co.seculink.exception.BizException;

import java.util.List;
import java.util.Map;

public interface FatPrdtStndMngService
{
	//비만_예측_기준 리스트 조회
	public List<Map<String, String>> searchFatPrdtList(Map<String, String> params) throws BizException;

	//비만_예측_기준 리스트_저장
	public void saveFatJudgSpecDetl(Map<String, Object> params) throws BizException;
}
 