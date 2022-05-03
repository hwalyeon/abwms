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

	//위험감정 발생이력 리스트 조회
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


	//학교정보 리스트 조회
	@ResponseBody
	@RequestMapping("/oper/dgem/dgemHist/searchLocList.ab")
	public RtnMsg searchLocList(@RequestBody(required = false) Map<String, String> params) throws BizException
	{

		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();


		List<Map<String, String>> result = dao.selectList("oper.dgem.dgemHist.searchLocList", params);
		rtnMap.put("result", result);


		if (!GEUtil.isEmpty(params.get("paging"))) {
			params.put("paging", "N");
			vo.setTotalCount(((List)dao.selectList("oper.dgem.dgemHist.searchLocList", params)).size());
		}

		vo.setRtnData(rtnMap, params);

		return vo;
	}

	//위험감정 발생이력 엑셀 다운로드
	@ResponseBody
	@RequestMapping("/oper/dgem/dgemHist/searchDgemHistList/excel.ab")
	public ModelAndView downloadExcel(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		params.put("paging", "N");
		List<Map<String, String>> result = dao.selectList("oper.dgem.dgemHist.searchDgemHistList", params);

		return new ModelAndView("excelXlsView", getExcelMap(result));
	}

	private Map<String, Object> getExcelMap(List<Map<String, String>> list)
	{
		String [] arrHeader = {"학생번호","위험감정 이력순번","위험감정 일자","위험감정 시각","위험감정 지수","위험감정 상태코드","위험감정 요약내용"
					          ,"위험감정 상태내용","위치이력 번호","현재위도 값","현재경도 값","위치측정일시","활동구분코드","심박상태코드","장소분류코드"
					          ,"체온상태코드","판정번호","비고","위험감정알림번호","학교명","보호자번호","보호자명","보호자전화번호","등록일자","등록시각"
		   				      ,"등록사용자ID","수정일자","수정시각","수정사용자ID"};
		List<String> headerList = Arrays.asList(arrHeader);

		List<List<String>> dataList = new ArrayList<List<String>>();
		List<String> data;

		for ( Map<String, String> info : list )
		{
			data = new ArrayList<String>();
			data.add(String.valueOf(info.get("stdtNo")));
			data.add(String.valueOf(info.get("dgemHistSeq")));
			data.add(String.valueOf(info.get("dgemDt")));
			data.add(String.valueOf(info.get("dgemTm")));
			data.add(String.valueOf(info.get("dgemIdx")));
			data.add(String.valueOf(info.get("dgemStatCd")));
			data.add(String.valueOf(info.get("dgemStatCntn")));
			data.add(String.valueOf(info.get("dgemSmryCntn")));
			data.add(String.valueOf(info.get("locHistNo")));
			data.add(String.valueOf(info.get("currLatVal")));
			data.add(String.valueOf(info.get("currLonVal")));
			data.add(String.valueOf(info.get("locMesuDttm")));
			data.add(String.valueOf(info.get("actDivCd")));
			data.add(String.valueOf(info.get("hbitStatCd")));
			data.add(String.valueOf(info.get("plcClssCd")));
			data.add(String.valueOf(info.get("tempStatCd")));
			data.add(String.valueOf(info.get("judgNo")));
			data.add(String.valueOf(info.get("rmrk")));
			data.add(String.valueOf(info.get("dgemAlamNo")));
			data.add(String.valueOf(info.get("locNm")));
			data.add(String.valueOf(info.get("guarNo")));
			data.add(String.valueOf(info.get("guarNm")));
			data.add(String.valueOf(info.get("guarTelNo")));
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
}
