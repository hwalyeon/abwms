package kr.co.seculink.web.service.oper.hc;

import kr.co.seculink.exception.BizException;

import java.util.List;
import java.util.Map;

public interface NutrEatHistService
{
	// 영양소_섭취_이력 리스트 조회
	public List<Map<String, String>> searchNutrEatHistList(Map<String, String> params) throws BizException;
}
