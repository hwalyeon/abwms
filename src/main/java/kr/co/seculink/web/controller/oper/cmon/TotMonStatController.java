package kr.co.seculink.web.controller.oper.cmon;

import kr.co.seculink.domain.RtnMsg;
import kr.co.seculink.exception.BizException;
import kr.co.seculink.util.GEUtil;
import kr.co.seculink.web.service.oper.cmon.TotMonStatService;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import java.util.*;

@Slf4j
@Controller
public class TotMonStatController
{
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate dao;

	@Autowired
	private TotMonStatService totMonStatService;

	// 종합관제현황_조회
	@ResponseBody
	@RequestMapping("/oper/cmon/totMonStat/searchDgsfOccr.ab")
	public RtnMsg<Map<String, Object>> searchDgsfOccr(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		RtnMsg<Map<String, Object>> vo = new RtnMsg<>();
		Map<String, Object> rtnMap = new HashMap<>();

		// 가동_현황
		Map<String, String> bandOperStat = totMonStatService.searchBandOperStat(params);

		// 개통_현황
		Map<String, String> bandOpenStat = totMonStatService.searchBandOpenStat(params);

		// 헬스케어_활용율
		Map<String, String> hcUseRt = totMonStatService.searchHcUseRt(params);

		// 위험안전발생
		Map<String, String> result1 = totMonStatService.searchDgsfOccr(params);

		// 위험지역_추이
		Map<String, String> result2 = totMonStatService.searchDzonTrnd(params);

		// 안전위험지역_탐지율
		Map<String, String> result3 = totMonStatService.searchDgsfDtct(params);

		// 위험감정_카운트
		Map<String, String> result4 = totMonStatService.searchDgemCnt(params);

		// 위험지역_TOP3_공공
		Map<String, String> result5 = totMonStatService.searchDngrTop3Gorg(params);

		// 보호자_지정_위험지역_TOP3
		Map<String, String> result6 = totMonStatService.searchGuarApntDngrTop3(params);

		// 위험감정_이력
		List<Map<String, String>> result7 = totMonStatService.searchDgemHist(params);

		// 헬스케어_성장지수
		Map<String, String> hcGidx = totMonStatService.searchHcGidx(params);

		// 헬스케어_비만지수
		Map<String, String> hcFidx = totMonStatService.searchHcFidx(params);

		// 헬스케어_비만예측
		Map<String, String> hcFpidx = totMonStatService.searchHcFpidx(params);

		// 헬스케어_스트레스
		Map<String, String> hcStrs = totMonStatService.searchHcStrs(params);

		// 헬스케어_평균_운동시간
		Map<String, String> hcAvgAct = totMonStatService.searchHcAvgAct(params);

		// 헬스케어_평균_칼로리_섭취
		Map<String, String> hcAvgCalEat = totMonStatService.searchHcAvgCalEat(params);

		// 헬스케어_주요식단_TOP3
		Map<String, String> hcFmenuTop3 = totMonStatService.searchHcFmenuTop3(params);

		// 헬스케어_아침식사_결식율
		Map<String, String> hcMmelNeat = totMonStatService.searchHcMmelNeat(params);

		rtnMap.put("bandOperStat"	, bandOperStat);
		rtnMap.put("bandOpenStat"	, bandOpenStat);
		rtnMap.put("hcUseRt"		, hcUseRt);
		rtnMap.put("result1"		, result1);
		rtnMap.put("result2"		, result2);
		rtnMap.put("result3"		, result3);
		rtnMap.put("result4"		, result4);
		rtnMap.put("result5"		, result5);
		rtnMap.put("result6"		, result6);
		rtnMap.put("result7"		, result7);
		rtnMap.put("hcGidx"			, hcGidx);
		rtnMap.put("hcFidx"			, hcFidx);
		rtnMap.put("hcFpidx"		, hcFpidx);
		rtnMap.put("hcStrs"			, hcStrs);
		rtnMap.put("hcAvgAct"		, hcAvgAct);
		rtnMap.put("hcAvgCalEat"	, hcAvgCalEat);
		rtnMap.put("hcFmenuTop3"	, hcFmenuTop3);
		rtnMap.put("hcMmelNeat"		, hcMmelNeat);

		vo.setRtnData(rtnMap);

		return vo;
	}

	// 종합관제현황_메뉴_리스트_조회
	@ResponseBody
	@RequestMapping("/oper/cmon/totMonStat/searchTotMonStatMenuList.ab")
	public RtnMsg<Map<String, Object>> searchTotMonStatMenuList(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		RtnMsg<Map<String, Object>> vo = new RtnMsg<>();
		Map<String, Object> rtnMap = new HashMap<>();

		List<Map<String, String>> result = totMonStatService.searchTotMonStatMenuList(params);

		rtnMap.put("result", result);
		vo.setRtnData(rtnMap);

		return vo;
	}
}
