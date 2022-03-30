package kr.co.seculink.web.controller.oper.hc;

import kr.co.seculink.domain.RtnMsg;
import kr.co.seculink.exception.BizException;
import kr.co.seculink.util.GEUtil;
import kr.co.seculink.web.excel.ExcelConstant;
import kr.co.seculink.web.service.oper.hc.GfixHistService;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.*;

@Slf4j
@Controller
public class GfixHistController {
	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate dao;

	@Autowired
	private GfixHistService gfixHistService;

	// 성장/비만_지수_이력 리스트 조회
	@ResponseBody
	@RequestMapping("/oper/hc/gfixHist/searchGfixHistList.ab")
	public RtnMsg searchGfixHistList(@RequestBody(required = false) Map<String, String> params) throws BizException {
		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();

		List<Map<String, String>> result = gfixHistService.searchGfixHistList(params);
		rtnMap.put("result", result);

		if (!GEUtil.isEmpty(params.get("paging"))) {
			params.put("paging", "N");
			vo.setTotalCount(((List) gfixHistService.searchGfixHistList(params)).size());
		}

		vo.setRtnData(rtnMap, params);

		return vo;
	}

	//성장/비만_지수_이력 리스트 엑셀다운로드
	@ResponseBody
	@RequestMapping("/oper/hc/gfixHist/searchGfixHistList/excel.ab")
	public ModelAndView downloadExcel(@RequestBody(required = false) Map<String, String> params) throws BizException {
	
		params.put("paging", "N");
		List<Map<String, String>> result = dao.selectList("oper.hc.gfixHist.selectGfixHistList", params);

		return new ModelAndView("excelXlsView", getExcelMap(result));
	}

	private Map<String, Object> getExcelMap(List<Map<String, String>> list) {
		String[] arrHeader = { "기준일자",
				               "학교 명" ,
				               "학생 번호",
				               "학생 명",
				               "성별",
				               "나이(년)",
				               "나이(개월)",
				               "키",
				               "몸무게",
				               "칼로리 섭취(일)",
				               "칼로리 소모(일)",
				               "성장 지수",
				               "성장 판정",
				               "비만 지수",
				               "비만 판정",
				               "비만 예측 지수",
				               "비만 예측",
				               "신체활동 수준",
				               "학생(밴드)전화번호",
				               "보호자 번호",
				               "보호자 명",
				               "보호자 전화번호" };
		List<String> headerList = Arrays.asList(arrHeader);

		List<List<String>> dataList = new ArrayList<List<String>>();
		List<String> data;

		for (Map<String, String> info : list) {
			data = new ArrayList<String>();
			
			data.add(info.get("gfixDt"));
			data.add(info.get("locNm"));
			data.add(String.valueOf(info.get("stdtNo")));
			data.add(info.get("stdtNm"));
			data.add(info.get("sexCdNm"));
			data.add(String.valueOf(info.get("ageYcnt")));
			data.add(String.valueOf(info.get("ageMcnt")));
			data.add(String.valueOf(info.get("hghtVal")));
			data.add(String.valueOf(info.get("wghtVal")));
			data.add(String.valueOf(info.get("calEatQty")));
			data.add(String.valueOf(info.get("calCsumQty")));
			data.add(String.valueOf(info.get("growIdx")));
			data.add(info.get("growJudgCdNm"));
			data.add(String.valueOf(info.get("fatIdx")));
			data.add(info.get("fatJudgCdNm"));
			data.add(String.valueOf(info.get("fatpIdx")));
			data.add(info.get("fatpJudgCdNm"));
			data.add(String.valueOf(info.get("palVal")));
			data.add(info.get("telNo"));
			data.add(String.valueOf(info.get("guarNo")));
			data.add(info.get("guarNm"));
			data.add(info.get("guarTelNo"));
			dataList.add(data);
		}

		Map<String, Object> map = new HashMap<>();
		map.put(ExcelConstant.FILE_NAME, "excel");
		map.put(ExcelConstant.HEAD, headerList);
		map.put(ExcelConstant.BODY, dataList);
		return map;
	}

}
