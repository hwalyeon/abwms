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
	@RequestMapping("/oper/cmon/totMonStat/searchTotMonStat.ab")
	public RtnMsg<Map<String, Object>> searchTotMonStat(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		RtnMsg<Map<String, Object>> vo = new RtnMsg<>();
		Map<String, Object> rtnMap = new HashMap<>();

		Map<String, String> result = totMonStatService.searchTotMonStat(params);
		List<Map<String, String>> result2 = totMonStatService.searchTotMonStatDgemHist(params);

		rtnMap.put("result", result);
		rtnMap.put("result2", result2);

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
