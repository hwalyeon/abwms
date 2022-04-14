package kr.co.seculink.web.controller.stat.hc;

import kr.co.seculink.domain.RtnMsg;
import kr.co.seculink.exception.BizException;
import kr.co.seculink.web.excel.ExcelConstant;
import kr.co.seculink.web.service.stat.hc.StrsStssService;
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
public class StrsStssController
{

	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate dao;

	@Autowired
	private StrsStssService strsStssService;

	@ResponseBody
	@RequestMapping("/stat/hc/strsStss/searchStrsStssColList.ab")
	public RtnMsg searchStrsStssColList(@RequestBody(required = false) Map<String, String> params) throws BizException
	{

		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();

		List<Map<String, String>> stndDtList = dao.selectList("stat.hc.strsStss.searchStrsStssColList", params);
		rtnMap.put("stndDtList", stndDtList);

		vo.setRtnData(rtnMap, params);

		return vo;
	}

	@ResponseBody
	@RequestMapping("/stat/hc/strsStss/searchStrsStatColList.ab")
	public RtnMsg searchStrsStatColList(@RequestBody(required = false) Map<String, String> params) throws BizException
	{

		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();

		List<Map<String, String>> strsStatCdList = dao.selectList("stat.hc.strsStss.searchStrsStatCdList", params);
		rtnMap.put("strsStatCdList", strsStatCdList);

		vo.setRtnData(rtnMap, params);

		return vo;
	}

	@ResponseBody
	@RequestMapping("/stat/hc/strsStss/searchStrsStssList.ab")
	public RtnMsg searchStrsStssList(@RequestBody(required = false) Map<String, String> params) throws BizException
	{

		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();

		List<Map<String, Object>> result = strsStssService.searchStrsStssList(params);
		rtnMap.put("result", result);

		vo.setRtnData(rtnMap, params);

		return vo;
	}


	@ResponseBody
	@RequestMapping("/stat/hc/strsStss/searchStrsJudgList.ab")
	public RtnMsg searchStrsJudgList(@RequestBody(required = false) Map<String, String> params) throws BizException
	{

		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();

		List<Map<String, Object>> result = strsStssService.searchStrsJudgList(params);
		rtnMap.put("result", result);

		vo.setRtnData(rtnMap, params);

		return vo;
	}

	//스트레스지수 통계 엑셀 다운로드
	@ResponseBody
	@RequestMapping("/stat/hc/strsStss/searchStrsStssList/excel.ab")
	public ModelAndView downloadExcel(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		params.put("paging", "N");
		List<Map<String, String>> stndDtList = dao.selectList("stat.hc.strsStss.searchStrsStssColList", params);

		List<Map<String, Object>> result = strsStssService.searchStrsStssList(params);

		return new ModelAndView("excelXlsView", getExcelMap(stndDtList , result));
	}

	private Map<String, Object> getExcelMap(List<Map<String, String>> stndDtList , List<Map<String, Object>> list)
	{

		String header = "구분";

		for(Map<String, String> stndDtInfo : stndDtList){
			header += "," + stndDtInfo.get("stndDt");
		}

		String [] arrHeader = header.split(",");
		List<String> headerList = Arrays.asList(arrHeader);

		List<List<String>> dataList = new ArrayList<List<String>>();
		List<String> data;

		for ( Map<String, Object> info : list )
		{
			data = new ArrayList<String>();
			data.add(String.valueOf(info.get("strsTypeNm")));
			for(Map<String, String> stndDtInfo : stndDtList){
				data.add(String.valueOf(info.get(stndDtInfo.get("stndDt"))));
			}
			dataList.add(data);
		}

		Map<String, Object> map = new HashMap<>();
		map.put(ExcelConstant.FILE_NAME, "excel");
		map.put(ExcelConstant.HEAD, headerList);
		map.put(ExcelConstant.BODY, dataList);
		return map;
	}


}
