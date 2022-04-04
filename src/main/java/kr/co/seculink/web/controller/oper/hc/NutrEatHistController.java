package kr.co.seculink.web.controller.oper.hc;

import kr.co.seculink.domain.RtnMsg;
import kr.co.seculink.exception.BizException;
import kr.co.seculink.util.GEUtil;
import kr.co.seculink.web.excel.ExcelConstant;
import kr.co.seculink.web.service.oper.hc.NutrEatHistService;
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
public class NutrEatHistController {
	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate dao;

	@Autowired
	private NutrEatHistService nutrEatHistService;

	//영양소_섭취_이력 리스트 조회
	@ResponseBody
	@RequestMapping("/oper/hc/nutrEatHist/searchNutrEatHistList.ab")
	public RtnMsg searchNutrEatHistList(@RequestBody(required = false) Map<String, String> params) throws BizException {
		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();

		List<Map<String, String>> result = nutrEatHistService.searchNutrEatHistList(params);
		rtnMap.put("result", result);

		if (!GEUtil.isEmpty(params.get("paging"))) {
			params.put("paging", "N");
			vo.setTotalCount(((List) nutrEatHistService.searchNutrEatHistList(params)).size());
		}

		vo.setRtnData(rtnMap, params);

		return vo;
	}

	//영양소_섭취_이력 리스트 엑셀다운로드
	@ResponseBody
	@RequestMapping("/oper/hc/nutrEatHist/searchNutrEatHistList/excel.ab")
	public ModelAndView downloadExcel(@RequestBody(required = false) Map<String, String> params) throws BizException {
	
		params.put("paging", "N");

		List<Map<String, String>> resultHeader = dao.selectList("svcStnd.nutr.ddNutrEatStndMng.searchNutrCdNmList", params);

		List<Map<String, String>> result = dao.selectList("oper.hc.nutrEatHist.selectNutrEatHistList", params);

		return new ModelAndView("excelXlsView", getExcelMap(result,resultHeader));
	}

	private Map<String, Object> getExcelMap(List<Map<String, String>> list,List<Map<String, String>> header) {

		List<String> headerList = new ArrayList<>();
		headerList.add("기준 일자");
		headerList.add("학교 명");
		headerList.add("학생 번호");
		headerList.add("학생 명");
		if(header.size() > 0){
			for(Map<String, String> headerInfo : header){
				headerList.add(headerInfo.get("nutrNm") + " ( " +  headerInfo.get("nutrCd") + " )");
			}
		}
		headerList.add("학생(밴드)전화번호");
		headerList.add("보호자 번호");
		headerList.add("보호자 명");
		headerList.add("보호자 전화 번호");

		List<List<String>> dataList = new ArrayList<List<String>>();
		List<String> data;

		for (Map<String, String> info : list) {
			data = new ArrayList<String>();
			data.add(info.get("stndDt"));
			data.add(info.get("locNm"));
			data.add(String.valueOf(info.get("stdtNo")));
			data.add(info.get("stdtNm"));
			data.add(String.valueOf(info.get("cal")));
			data.add(String.valueOf(info.get("prtn")));
			data.add(String.valueOf(info.get("fat")));
			data.add(String.valueOf(info.get("carb")));
			data.add(String.valueOf(info.get("dfib")));
			data.add(String.valueOf(info.get("ca")));
			data.add(String.valueOf(info.get("fe")));
			data.add(String.valueOf(info.get("mg")));
			data.add(String.valueOf(info.get("na")));
			data.add(String.valueOf(info.get("zn")));
			data.add(String.valueOf(info.get("vitD3")));
			data.add(String.valueOf(info.get("vitB")));
			data.add(String.valueOf(info.get("vitB1")));
			data.add(String.valueOf(info.get("vitB2")));
			data.add(String.valueOf(info.get("nia")));
			data.add(String.valueOf(info.get("dfe")));
			data.add(String.valueOf(info.get("vitB12")));
			data.add(String.valueOf(info.get("amno")));
			data.add(String.valueOf(info.get("ile")));
			data.add(String.valueOf(info.get("leu")));
			data.add(String.valueOf(info.get("val")));
			data.add(String.valueOf(info.get("chl")));
			data.add(String.valueOf(info.get("fapu")));
			data.add(String.valueOf(info.get("epa")));
			data.add(String.valueOf(info.get("dha")));
			data.add(String.valueOf(info.get("epaDha")));
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
