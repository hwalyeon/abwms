package kr.co.seculink.web.controller.oper.dgem;

import kr.co.seculink.domain.RtnMsg;
import kr.co.seculink.exception.BizException;
import kr.co.seculink.util.GEUtil;
import kr.co.seculink.web.excel.ExcelConstant;
import kr.co.seculink.web.service.oper.dgem.DgemHistService;
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
public class DgemHistController
{

	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate dao;

	@Autowired
	private DgemHistService dgemHistService;

	//리스트 조회
	@ResponseBody
	@RequestMapping("/oper/dgem/dgemHist/searchDgemHistList.ab")
	public RtnMsg searchDgemHistList(@RequestBody(required = false) Map<String, String> params) throws BizException
	{

		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();


		List<Map<String, String>> result = dao.selectList("oper.dgem.dgemHist.searchDgemHistList", params);
		rtnMap.put("result", result);


		if (!GEUtil.isEmpty(params.get("paging"))) {
			params.put("paging", "N");
			vo.setTotalCount(((List)dao.selectList("oper.dgem.dgemHist.searchDgemHistList", params)).size());
		}

		vo.setRtnData(rtnMap, params);

		return vo;
	}


	//학생정보 및 보호자 정보 리스트 조회
	@ResponseBody
	@RequestMapping("/oper/dgem/dgemHist/searchStdtGuarList.ab")
	public RtnMsg searchStdtGuarList(@RequestBody(required = false) Map<String, String> params) throws BizException
	{

		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();


		List<Map<String, String>> result = dao.selectList("oper.dgem.dgemHist.searchStdtGuarList", params);
		rtnMap.put("result", result);


		if (!GEUtil.isEmpty(params.get("paging"))) {
			params.put("paging", "N");
			vo.setTotalCount(((List)dao.selectList("oper.dgem.dgemHist.searchStdtGuarList", params)).size());
		}

		vo.setRtnData(rtnMap, params);

		return vo;
	}

	//학생정보 엑셀 다운로드
	@ResponseBody
	@RequestMapping("/oper/dgem/dgemHist/searchDgemHist/excel.ab")
	public ModelAndView downloadExcel(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		params.put("paging", "N");
		List<Map<String, String>> result = dao.selectList("user.stdt.stdtInfoMng.searchDgemHist", params);

		return new ModelAndView("excelXlsView", getExcelMap(result));
	}

	private Map<String, Object> getExcelMap(List<Map<String, String>> list)
	{
		String [] arrHeader = {"성장판정코드","성장판정코드명","성장지수_FORM","성장지수_TO","요약내용","상세내용","등록일자","등록시각","등록사용자ID","수정일자","수정시각","수정사용자ID"};
		List<String> headerList = Arrays.asList(arrHeader);

		List<List<String>> dataList = new ArrayList<List<String>>();
		List<String> data;

		for ( Map<String, String> info : list )
		{
			data = new ArrayList<String>();
			data.add(String.valueOf(info.get("growJudgCd")));
			data.add(String.valueOf(info.get("growJudgNm")));
			data.add(String.valueOf(info.get("gidxFr")));
			data.add(String.valueOf(info.get("gidxTo")));
			data.add(String.valueOf(info.get("smryCntn")));
			data.add(String.valueOf(info.get("specCntn")));
			data.add(info.get("regDt"));
			data.add(info.get("regTm"));
			data.add(info.get("regUserId"));
			data.add(info.get("uptDt"));
			data.add(info.get("uptTm"));
			data.add(info.get("uptUserId"));
			dataList.add(data);
		}

		Map<String, Object> map = new HashMap<>();
		map.put(ExcelConstant.FILE_NAME, "excel");
		map.put(ExcelConstant.HEAD, headerList);
		map.put(ExcelConstant.BODY, dataList);
		return map;
	}

/*	//학생정보 상세화면 리스트 조회
	@ResponseBody
	@RequestMapping("/user/stdt/stdtInfoMng/searchStdtInfo.ab")

	public RtnMsg searchStdtInfo(@RequestBody(required = false) Map<String, String> params) throws BizException
	{

		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();


		List<Map<String, String>> result = dao.selectList("oper.dgem.dgemHist.searchDgemHistList", params);

		if(result.size() > 0 ){
			rtnMap.put("result", result.get(0));
		}

		vo.setRtnData(rtnMap, params);

		return vo;
	}

	//학생정보 저장
	@ResponseBody
	@RequestMapping("/user/stdt/stdtInfoMng/saveStdtInfo.ab")
	public RtnMsg saveInfo(@RequestBody(required=false) Map<String, Object> params) throws BizException {
		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();

		dgemHistService.saveStdtInfo(params);


		rtnMap.put("result", params);
		vo.setRtnData(rtnMap,null);

		return vo;
	}



	@ResponseBody
	@RequestMapping("/user/stdt/stdtInfoMng/searchStdtDetlInfo.ab")
	public RtnMsg searchStdtDetlInfo(@RequestBody(required = false) Map<String, String> params) throws BizException
	{

		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();


		//Map<String, String> result = dao.selectOne("user.stdt.stdtInfoMng.searchStdtDetlInfo", params);
		Map<String, Object> result = dgemHistService.searchStdtDetlInfo(params);

		rtnMap.put("result", result);

		vo.setRtnData(rtnMap, params);

		return vo;
	}

	@ResponseBody
	@RequestMapping("/user/stdt/stdtInfoMng/searchStdtEorgLocList.ab")
	public RtnMsg searchStdtEorgLocList(@RequestBody(required = false) Map<String, String> params) throws BizException
	{

		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();


		List<Map<String, String>> result = dao.selectList("user.stdt.stdtInfoMng.searchStdtEorgLocList", params);

		rtnMap.put("result", result);

		vo.setRtnData(rtnMap, params);

		return vo;
	}

	@ResponseBody
	@RequestMapping("/user/stdt/stdtInfoMng/searchBandList.ab")
	public RtnMsg searchBandList(@RequestBody(required = false) Map<String, String> params) throws BizException
	{

		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();

		List<Map<String, String>> result = dao.selectList("user.stdt.stdtInfoMng.searchBandList", params);

		rtnMap.put("result", result);

		vo.setRtnData(rtnMap, params);

		return vo;
	}*/


}
