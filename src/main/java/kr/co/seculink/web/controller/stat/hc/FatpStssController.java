package kr.co.seculink.web.controller.stat.hc;

import kr.co.seculink.domain.RtnMsg;
import kr.co.seculink.exception.BizException;
import kr.co.seculink.web.excel.ExcelConstant;
import kr.co.seculink.web.service.stat.hc.FatpStssService;
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
public class FatpStssController
{

	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate dao;

	@Autowired
	private FatpStssService fatpStssService;

	@ResponseBody
	@RequestMapping("/stat/hc/fatpStss/searchFatpStssColList.ab")
	public RtnMsg searchFatpStssColList(@RequestBody(required = false) Map<String, String> params) throws BizException
	{

		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();

		List<Map<String, String>> stndDtList = dao.selectList("stat.hc.fatpStss.searchFatpStssCdList", params);
		rtnMap.put("stndDtList", stndDtList);

		List<Map<String, String>> growJudgCdList = dao.selectList("stat.hc.fatpStss.searchGrowJudgCdList", params);
		rtnMap.put("growJudgCdList", growJudgCdList);

		vo.setRtnData(rtnMap, params);

		return vo;
	}

	@ResponseBody
	@RequestMapping("/stat/hc/fatpStss/searchFatpStssList.ab")
	public RtnMsg searchFatpStssList(@RequestBody(required = false) Map<String, String> params) throws BizException
	{

		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();

		List<Map<String, Object>> result = fatpStssService.searchFatpStssList(params);
		rtnMap.put("result", result);

		vo.setRtnData(rtnMap, params);

		return vo;
	}


	@ResponseBody
	@RequestMapping("/stat/hc/fatpStss/searchFatpJudgList.ab")
	public RtnMsg searchFatpJudgList(@RequestBody(required = false) Map<String, String> params) throws BizException
	{

		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();

		List<Map<String, Object>> result = fatpStssService.searchFatpJudgList(params);
		rtnMap.put("result", result);

		vo.setRtnData(rtnMap, params);

		return vo;
	}

	//비만예측지수 통계 엑셀 다운로드
	@ResponseBody
	@RequestMapping("/stat/hc/fatpStss/searchFatpStssList/excel.ab")
	public ModelAndView downloadExcel(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		params.put("paging", "N");
		List<Map<String, Object>> result = dao.selectList("stat.hc.fatpStss.searchFatpStssList", params);

		return new ModelAndView("excelXlsView", getExcelMap(result));
	}

	private Map<String, Object> getExcelMap(List<Map<String, Object>> list)
	{
		String [] arrHeader = {"구분","비만예측지수"};
		List<String> headerList = Arrays.asList(arrHeader);

		List<List<String>> dataList = new ArrayList<List<String>>();
		List<String> data;

		for ( Map<String, Object> info : list )
		{
			data = new ArrayList<String>();
			data.add(String.valueOf(info.get("stndDt")));
			data.add(String.valueOf(info.get("avgIdx")));
			dataList.add(data);
		}

		Map<String, Object> map = new HashMap<>();
		map.put(ExcelConstant.FILE_NAME, "excel");
		map.put(ExcelConstant.HEAD, headerList);
		map.put(ExcelConstant.BODY, dataList);
		return map;
	}


}
