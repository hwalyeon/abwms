package kr.co.seculink.web.controller.oper.hc;

import kr.co.seculink.domain.RtnMsg;
import kr.co.seculink.exception.BizException;
import kr.co.seculink.util.GEUtil;
import kr.co.seculink.web.excel.ExcelConstant;
import kr.co.seculink.web.service.oper.hc.EatHistService;
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
public class EatHistController {
	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate dao;

	@Autowired
	private EatHistService eatHistService;

	// 섭취_이력 리스트 조회
	@ResponseBody
	@RequestMapping("/oper/hc/eatHist/searchEatHistList.ab")
	public RtnMsg searchEatHistList(@RequestBody(required = false) Map<String, String> params) throws BizException {
		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();

		List<Map<String, String>> result = eatHistService.searchEatHistList(params);
		rtnMap.put("result", result);

		if (!GEUtil.isEmpty(params.get("paging"))) {
			params.put("paging", "N");
			vo.setTotalCount(((List) eatHistService.searchEatHistList(params)).size());
		}

		vo.setRtnData(rtnMap, params);

		return vo;
	}

	//섭취_이력 리스트 엑셀다운로드
	@ResponseBody
	@RequestMapping("/oper/hc/eatHist/searchEatHistList/excel.ab")
	public ModelAndView downloadExcel(@RequestBody(required = false) Map<String, String> params) throws BizException {
	
		params.put("paging", "N");
		List<Map<String, String>> result = dao.selectList("oper.hc.eatHist.selectEatHistList", params);

		return new ModelAndView("excelXlsView", getExcelMap(result));
	}

	private Map<String, Object> getExcelMap(List<Map<String, String>> list) {
		String[] arrHeader = { "기준일자", "학교 명","학생 번호","학생 명","아침 식단 번호","아침 식단 명","점심 식단 번호","점심 식단 명","저녁 식단 번호","저녁 식단 명","간식 식단 번호","간식 식단 명","학생(밴드)전화번호","보호자 번호","보호자 명","보호자 전화번호" };
		List<String> headerList = Arrays.asList(arrHeader);

		List<List<String>> dataList = new ArrayList<List<String>>();
		List<String> data;

		for (Map<String, String> info : list) {
			data = new ArrayList<String>();
			data.add(info.get("stndDt"));
			data.add(info.get("locNm"));
			data.add(String.valueOf(info.get("stdtNo")));
			data.add(info.get("stdtNm"));
			data.add(String.valueOf(info.get("mmelFmenuSeq")));
			data.add(info.get("mmelFmenuNm"));
			data.add(String.valueOf(info.get("amelFmenuSeq")));
			data.add(info.get("amelFmenuNm"));
			data.add(String.valueOf(info.get("emelFmenuSeq")));
			data.add(info.get("emelFmenuNm"));
			data.add(String.valueOf(info.get("smelFmenuSeq")));
			data.add(info.get("smelFmenuNm"));
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

	// 식단_정보 리스트 조회
	@ResponseBody
	@RequestMapping("/oper/hc/eatHist/searchFmenuSpecList.ab")
	public RtnMsg searchFmenuSpecList(@RequestBody(required = false) Map<String, String> params) throws BizException {
		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();

		List<Map<String, String>> result = eatHistService.searchFmenuSpecList(params);
		rtnMap.put("result", result);

		if (!GEUtil.isEmpty(params.get("paging"))) {
			params.put("paging", "N");
			vo.setTotalCount(((List) eatHistService.searchFmenuSpecList(params)).size());
		}
		vo.setRtnData(rtnMap, params);

		return vo;
	}

	// 섭취_영양_정보 리스트 조회
	@ResponseBody
	@RequestMapping("/oper/hc/eatHist/searchEatNutrSpecList.ab")
	public RtnMsg searcheEtNutrSpecList(@RequestBody(required = false) Map<String, String> params) throws BizException {
		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();

		List<Map<String, String>> result = eatHistService.searchEatNutrSpecList(params);
		rtnMap.put("result", result);

		if (!GEUtil.isEmpty(params.get("paging"))) {
			params.put("paging", "N");
			vo.setTotalCount(((List) eatHistService.searchEatNutrSpecList(params)).size());
		}
		vo.setRtnData(rtnMap, params);

		return vo;
	}


}
