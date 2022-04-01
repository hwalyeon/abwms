package kr.co.seculink.web.service.oper.hc;

import kr.co.seculink.exception.BizException;

import java.util.List;
import java.util.Map;

public interface EatHistService
{
	// 섭취_이력 리스트 조회
	public List<Map<String, String>> searchEatHistList(Map<String, String> params) throws BizException;
	
	// 식단_정보 리스트 조회
	public List<Map<String, String>> searchFmenuSpecList(Map<String, String> params) throws BizException;

	// 영양소_섭취_정보 리스트 조회
	public List<Map<String, String>> searchEatNutrSpecList(Map<String, String> params) throws BizException;

}
 