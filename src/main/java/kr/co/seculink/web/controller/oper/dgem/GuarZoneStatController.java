package kr.co.seculink.web.controller.oper.dgem;

import kr.co.seculink.domain.RtnMsg;
import kr.co.seculink.exception.BizException;
import kr.co.seculink.util.GEUtil;
import kr.co.seculink.web.excel.ExcelConstant;
import kr.co.seculink.web.service.oper.dgem.GuarZoneStatService;
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
public class GuarZoneStatController
{
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate dao;

	@Autowired
	private GuarZoneStatService guarZoneStatService;

	// 위치정보_관리_조회_조건_조회
	@ResponseBody
	@RequestMapping("/oper/dgem/guarZoneStat/searchLocInfoSelect.ab")
	public RtnMsg<Map<String, Object>> searchLocInfoSelect(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		RtnMsg<Map<String, Object>> vo = new RtnMsg<>();
		Map<String, Object> rtnMap = new HashMap<>();

		List<Map<String, String>> result = guarZoneStatService.searchLocInfoSelect(params);
		List<Map<String, String>> result2 = guarZoneStatService.searchLocInfoSelect2(params);

		rtnMap.put("result", result);
		rtnMap.put("result2", result2);
		vo.setRtnData(rtnMap);

		return vo;
	}

	// 위치정보_관리_리스트_조회
	@ResponseBody
	@RequestMapping("/oper/dgem/guarZoneStat/searchLocInfoList.ab")
	public RtnMsg<Map<String, Object>> searchLocInfoList(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		RtnMsg<Map<String, Object>> vo = new RtnMsg<>();
		Map<String, Object> rtnMap = new HashMap<>();

		List<Map<String, String>> result = guarZoneStatService.searchLocInfoList(params);

		if ( !GEUtil.isEmpty(params.get("paging")) ) {
			params.put("paging", "N");
			vo.setTotalCount(guarZoneStatService.searchLocInfoList(params).size());
		}

		rtnMap.put("result", result);
		vo.setRtnData(rtnMap);

		return vo;
	}

	// 위치정보_관리_리스트_상세정보_조회
	@ResponseBody
	@RequestMapping("/oper/dgem/guarZoneStat/searchLocInfoSpec.ab")
	public RtnMsg<Map<String, Object>> searchLocInfoSpec(@RequestBody(required = false) Map<String, String> params) throws BizException
	{
		RtnMsg<Map<String, Object>> vo = new RtnMsg<>();
		Map<String, Object> rtnMap = new HashMap<>();
		List<Map<String, String>> result = guarZoneStatService.searchLocInfoSpec(params);
		rtnMap.put("result", result);

		if ( !GEUtil.isEmpty(params.get("paging")) ) {
			params.put("paging", "N");
			vo.setTotalCount(guarZoneStatService.searchLocInfoSpec(params).size());
		}

		vo.setRtnData(rtnMap, params);

		return vo;
	}

	// 위치정보_관리_상세정보_저장
	@ResponseBody
	@RequestMapping("/oper/dgem/guarZoneStat/saveLocInfoSpec.ab")
	public RtnMsg<Map<String, Object>> saveLocInfoSpec(@RequestBody(required=false) Map<String, Object> params) throws BizException {
		RtnMsg<Map<String, Object>> vo = new RtnMsg<>();
		Map<String, Object> rtnMap = new HashMap<>();

		guarZoneStatService.saveLocInfoSpec(params);

		rtnMap.put("result", params);
		vo.setRtnData(rtnMap,null);

		return vo;
	}

	// 위치정보_관리_리스트 엑셀다운로드
	@ResponseBody
	@RequestMapping("/oper/dgem/guarZoneStat/searchLocInfoList/excel.ab")
	public ModelAndView downloadExcel(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		params.put("paging", "N");
		List<Map<String, String>> result = dao.selectList("oper.dgem.guarZoneStat.searchLocInfoList", params);
		return new ModelAndView("excelXlsView", getExcelMap(result));
	}

	private Map<String, Object> getExcelMap(List<Map<String, String>> list)
	{
		String [] arrHeader = {"기준일자","위치번호","위치명","위치지정명","장소분류명","탐지건수","탐지학생수"};
		List<String> headerList = Arrays.asList(arrHeader);
		List<List<String>> dataList = new ArrayList<>();
		List<String> data;

		for ( Map<String, String> info : list )
		{
			data = new ArrayList<>();
			data.add(String.valueOf(info.get("stndDt")));
			data.add(String.valueOf(info.get("locNo")));
			data.add(String.valueOf(info.get("locNm")));
			data.add(String.valueOf(info.get("locApntNm")));
			data.add(String.valueOf(info.get("plcClssNm")));
			data.add(String.valueOf(info.get("occrCnt")));
			data.add(String.valueOf(info.get("stdtCnt")));
			dataList.add(data);
		}
		Map<String, Object> map = new HashMap<>();
		map.put(ExcelConstant.FILE_NAME, "excel");
		map.put(ExcelConstant.HEAD, headerList);
		map.put(ExcelConstant.BODY, dataList);
		return map;
	}
}
