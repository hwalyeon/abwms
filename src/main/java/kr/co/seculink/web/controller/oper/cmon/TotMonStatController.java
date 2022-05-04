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

	// 종합관제현황_위험감정이력_조회
	@ResponseBody
	@RequestMapping("/oper/cmon/totMonStat/searchDgemHist.ab")
	public RtnMsg<Map<String, Object>> searchDgemHist(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		RtnMsg<Map<String, Object>> vo = new RtnMsg<>();
		Map<String, Object> rtnMap = new HashMap<>();

		// 위험안전발생
		Map<String, String> result1 = totMonStatService.searchDgsfOccr(params);
		// 위험감정_카운트
		Map<String, String> result2 = totMonStatService.searchDgemCnt(params);
		// 위험감정_이력
		List<Map<String, String>> result3 = totMonStatService.searchDgemHist(params);

		rtnMap.put("result1", result1);
		rtnMap.put("result2", result2);
		rtnMap.put("result3", result3);

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
