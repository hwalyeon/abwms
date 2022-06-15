package kr.co.seculink.web.controller.oper.hc;

import kr.co.seculink.domain.RtnMsg;
import kr.co.seculink.exception.BizException;
import kr.co.seculink.util.GEUtil;
import kr.co.seculink.web.excel.ExcelConstant;
import kr.co.seculink.web.service.oper.hc.GuarFmenuHistService;
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
public class GuarFmenuHistController {
	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate dao;

	@Autowired
	private GuarFmenuHistService guarFmenuHistService;

	//보호자_식단표_현황 리스트 조회
	@ResponseBody
	@RequestMapping("/oper/hc/guarFmenuHist/guarFmenuHistList.ab")
	public RtnMsg searchGuarFmenuHistList(@RequestBody(required = false) Map<String, String> params) throws BizException {
		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();

		List<Map<String, String>> result = guarFmenuHistService.searchGuarFmenuHistList(params);

		rtnMap.put("result", result);

		if (!GEUtil.isEmpty(params.get("paging"))) {
			params.put("paging", "N");
			vo.setTotalCount(((List) guarFmenuHistService.searchGuarFmenuHistList(params)).size());
		}

		vo.setRtnData(rtnMap, params);

		return vo;
	}
	// 식단_정보 리스트 조회
	@ResponseBody
	@RequestMapping("/oper/hc/guarFmenuHist/searchGuarFmenuSpecList.ab")
	public RtnMsg searchGuarFmenuSpecList(@RequestBody(required = false) Map<String, String> params) throws BizException {
		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();

		List<Map<String, String>> result = guarFmenuHistService.searchGuarFmenuSpecList(params);
		rtnMap.put("result", result);

		if (!GEUtil.isEmpty(params.get("paging"))) {
			params.put("paging", "N");
			vo.setTotalCount(((List) guarFmenuHistService.searchGuarFmenuSpecList(params)).size());
		}
		vo.setRtnData(rtnMap, params);

		return vo;
	}
	//보호자_식단표_현황 리스트 엑셀다운로드
	@ResponseBody
	@RequestMapping("/oper/hc/guarFmenuHist/guarFmenuHistList/excel.ab")
	public ModelAndView downloadExcel(@RequestBody(required = false) Map<String, String> params) throws BizException {
	
		params.put("paging", "N");
		List<Map<String, String>> result = dao.selectList("oper.hc.guarFmenuHist.selectGuarFmenuHistList", params);

		return new ModelAndView("excelXlsView", getExcelMap(result));
	}

	private Map<String, Object> getExcelMap(List<Map<String, String>> list) {
		String[] arrHeader = { "보호자 번호","보호자 명","식단표 번호", "식단표 명","아침 여부","점심 여부","저녁 여부","간식 여부","이용빈도(수)" };
		List<String> headerList = Arrays.asList(arrHeader);

		List<List<String>> dataList = new ArrayList<List<String>>();
		List<String> data;

		for (Map<String, String> info : list) {
			data = new ArrayList<String>();
			data.add(String.valueOf(info.get("guarNo")));
			data.add(info.get("guarNm"));
			data.add(String.valueOf(info.get("fmenuSeq")));
			data.add(info.get("fmenuNm"));
			data.add(info.get("mmelYn"));
			data.add(info.get("amelYn"));
			data.add(info.get("emelYn"));
			data.add(info.get("smelYn"));
			data.add(String.valueOf(info.get("feqUse")));
			dataList.add(data);
		}

		Map<String, Object> map = new HashMap<>();
		map.put(ExcelConstant.FILE_NAME, "excel");
		map.put(ExcelConstant.HEAD, headerList);
		map.put(ExcelConstant.BODY, dataList);
		return map;
	}

}
