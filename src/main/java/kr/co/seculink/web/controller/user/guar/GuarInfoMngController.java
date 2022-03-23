package kr.co.seculink.web.controller.user.guar;

import kr.co.seculink.domain.RtnMsg;
import kr.co.seculink.exception.BizException;
import kr.co.seculink.util.GEUtil;
import kr.co.seculink.web.excel.ExcelConstant;
import kr.co.seculink.web.service.user.guar.GuarInfoMngService;
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
public class GuarInfoMngController
{
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate dao;

	@Autowired
	private GuarInfoMngService guarInfoMngService;

	//보호자(사용자)정보_리스트 조회
	@ResponseBody
	@RequestMapping("/user/guar/guarInfoMng/searchGuarInfoList.ab")
	public RtnMsg searchGuarInfoList(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();

		List<Map<String, String>> result = guarInfoMngService.searchGuarInfoList(params);

		if ( !GEUtil.isEmpty(params.get("paging")) ) {
			params.put("paging", "N");
			vo.setTotalCount(((List)guarInfoMngService.searchGuarInfoList(params)).size());
		}
		rtnMap.put("result", result);
		vo.setRtnData(rtnMap, params);

		return vo;
	}

	//보호자(사용자)_정보_상세보기
	@ResponseBody
	@RequestMapping("/user/guar/guarInfoMng/searchGuarInfo.ab")
	public RtnMsg searchGuarInfo(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		Map<String, Object> result = guarInfoMngService.searchGuarInfo(params);

		rtnMap.put("result", result);
		vo.setRtnData(rtnMap);

		return vo;
	}

	//보호자(사용자)_정보 저장
	@ResponseBody
	@RequestMapping("/user/guar/guarInfoMng/saveGuarInfoDetl.ab")
	public RtnMsg saveGuarInfoDetl(@RequestBody(required = false)Map<String,Object>params)throws BizException {

		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		guarInfoMngService.saveGuarInfoDetl(params);

		rtnMap.put("result", params);
		vo.setRtnData(rtnMap, params);

		return vo;
	}

	//보호자(사용자)_정보_리스트 엑셀다운로드
	@ResponseBody
	@RequestMapping("/user/guar/guarInfoMng/searchGuarInfoList/excel.ab")
	public ModelAndView downloadExcel(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		params.put("paging", "N");

		List<Map<String, String>> result = dao.selectList("user.guar.guarInfoMng.selectGuarInfoList", params);
		return new ModelAndView("excelXlsView", getExcelMap(result));
	}

	private Map<String, Object> getExcelMap(List<Map<String, String>> list)
	{
		String [] arrHeader = {"보호자번호","보호자명","보호자전화번호","학생번호","학생명","가입일자","밴드전화번호","학교(학원)명", "밴드ID", "배우자번호","배우자명","배우자전화번호"};
		List<String> headerList = Arrays.asList(arrHeader);

		List<List<String>> dataList = new ArrayList<List<String>>();
		List<String> data;

		for ( Map<String, String> info : list )
		{
			data = new ArrayList<String>();
			data.add(String.valueOf(info.get("guarNo")));
			data.add(info.get("guarNm"));
			data.add(info.get("guarTelNo"));
			data.add(String.valueOf(info.get("stdtNo")));
			data.add(info.get("stdtNm"));
			data.add(info.get("entrDt"));
			data.add(info.get("telNo"));
			data.add(info.get("locNm"));
			data.add(info.get("bandId"));
			data.add(String.valueOf(info.get("sposNo")));
			data.add(info.get("sposNm"));
			data.add(info.get("sposTelNo"));
			dataList.add(data);
		}

		Map<String, Object> map = new HashMap<>();
		map.put(ExcelConstant.FILE_NAME, "excel");
		map.put(ExcelConstant.HEAD, headerList);
		map.put(ExcelConstant.BODY, dataList);
		return map;
	}

//	//배우자_정보 상세보기
//	@ResponseBody
//	@RequestMapping("/user/guar/guarInfoMng/searchSposInfo.ab")
//	public RtnMsg searchSposInfo(@RequestBody(required=false) Map<String, String> params) throws BizException
//	{
//		RtnMsg vo = new RtnMsg();
//		Map<String, Object> rtnMap = new HashMap<String, Object>();
//
//		Map<String, Object> result = guarInfoMngService.searchSposInfo(params);
//
//		rtnMap.put("result", result);
//		vo.setRtnData(rtnMap);
//
//		return vo;
//	}
//


	//약관동의여부_정보 상세보기
	@ResponseBody
	@RequestMapping("/user/guar/guarInfoMng/searchTermAgreYnInfoDetlList.ab")
	public RtnMsg searchTermAgreYnInfoDetlList(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();

		List<Map<String, Object>> result = guarInfoMngService.searchTermAgreYnInfoDetlList(params);

		if ( !GEUtil.isEmpty(params.get("paging")) ) {
			params.put("paging", "N");
			vo.setTotalCount(((List)guarInfoMngService.searchTermAgreYnInfoDetlList(params)).size());
		}
		rtnMap.put("result", result);
		vo.setRtnData(rtnMap, params);

		return vo;
	}
/*
	//약관동의여부_정보 저장
	@ResponseBody
	@RequestMapping("/user/guar/guarInfoMng/saveTermAgreYnInfoDetl.ab")
	public RtnMsg saveTermAgreYnInfoDetl(@RequestBody(required = false)Map<String,Object>params)throws BizException {

		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		guarInfoMngService.saveTermAgreYnInfoDetl(params);


		rtnMap.put("result", params);
		vo.setRtnData(rtnMap, params);

		return vo;
	}*/
}
