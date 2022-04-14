package kr.co.seculink.web.controller.svcStnd.fat;

import kr.co.seculink.domain.RtnMsg;
import kr.co.seculink.exception.BizException;
import kr.co.seculink.util.GEUtil;
import kr.co.seculink.web.excel.ExcelConstant;
import kr.co.seculink.web.service.svcStnd.fat.FatPrdtStndMngService;
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
public class FatPrdtStndMngController {
	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate dao;

	@Autowired
	private FatPrdtStndMngService fatPrdtStndMngService;

	// 위험_감정_기준 리스트 조회
	@ResponseBody
	@RequestMapping("/svcStnd/fatPrdt/fatPrdtStndMng/searchFatPrdtList.ab")
	public RtnMsg searchFatPrdtList(@RequestBody(required = false) Map<String, String> params) throws BizException {
		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();

		List<Map<String, String>> result = fatPrdtStndMngService.searchFatPrdtList(params);
		rtnMap.put("result", result);

		if (!GEUtil.isEmpty(params.get("paging"))) {
			params.put("paging", "N");
			vo.setTotalCount(((List) fatPrdtStndMngService.searchFatPrdtList(params)).size());
		}

		vo.setRtnData(rtnMap, params);

		return vo;
	}

	// 위험_감정_기준 리스트 엑셀다운로드
	@ResponseBody
	@RequestMapping("/svcStnd/fatPrdt/fatPrdtStndMng/searchFatPrdtList/excel.ab")
	public ModelAndView downloadExcel(@RequestBody(required = false) Map<String, String> params) throws BizException {
	
		params.put("paging", "N");
		List<Map<String, String>> result = dao.selectList("svcStnd.fatPrdt.fatPrdtStndMng.searchTcFatPrdtStatBase", params);

		return new ModelAndView("excelXlsView", getExcelMap(result));
	}

	private Map<String, Object> getExcelMap(List<Map<String, String>> list) {
		String[] arrHeader = { "활동 구분 명", "심박 상태 명","장소 분류 명","체온 상태 명","위험감정 지수","위험감정 상태 명","위험감정 요약내용","등록일자","등록시각","등록사용자ID","수정등록일자","수정시각","수정사용자ID" };
		List<String> headerList = Arrays.asList(arrHeader);

		List<List<String>> dataList = new ArrayList<List<String>>();
		List<String> data;

		for (Map<String, String> info : list) {
			data = new ArrayList<String>();
			data.add(info.get("actDivCdNm"));
			data.add(info.get("hbitStatCdNm"));
			data.add(info.get("plcClssCdNm"));       
			data.add(info.get("tempStatCdNm"));       
			data.add(String.valueOf(info.get("fatPrdtIdx")));       
			data.add(info.get("fatPrdtStatCdNm"));       
			data.add(info.get("fatPrdtSmryCntn"));       
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
	
	//위험_감정_기준_상세 조회
	@ResponseBody
	@RequestMapping("/svcStnd/fatPrdt/fatPrdtStndMng/searchFatPrdtStndInfo.ab")

	public RtnMsg searchFatPrdtStndInfo(@RequestBody(required = false) Map<String, String> params) throws BizException
	{

		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();

		List<Map<String, String>> result = dao.selectList("svcStnd.fatPrdt.fatPrdtStndMng.searchTcFatPrdtStatBase", params);
		
		rtnMap.put("result", result);
		vo.setRtnData(rtnMap, params);

		return vo;
	}

	@ResponseBody
	@RequestMapping("/svcStnd/fatPrdt/fatPrdtStndMng/saveInfo.ab")
	public RtnMsg saveInfo(@RequestBody(required=false) Map<String, Object> params) throws BizException {
		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();

		if("C".equals(params.get("crud"))) dao.insert("svcStnd.fatPrdt.fatPrdtStndMng.insertTiFatPrdtStnd",params);
		else if("U".equals(params.get("crud"))) dao.insert("svcStnd.fatPrdt.fatPrdtStndMng.updateTiFatPrdtStnd",params);
		else if("D".equals(params.get("crud"))) dao.insert("svcStnd.fatPrdt.fatPrdtStndMng.deleteTiFatPrdtStnd",params);

		rtnMap.put("result", params);
		vo.setRtnData(rtnMap,null);

		return vo;
	}
	@ResponseBody
	@RequestMapping("/svcStnd/fatPrdt/fatPrdtStndMng/searchDupCdCk.ab")
	public RtnMsg searchDupCdCk(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();

		Map<String, String> result = fatPrdtStndMngService.searchDupCdCk(params);

		rtnMap.put("result", result);
		vo.setRtnData(rtnMap);

		return vo;
	}
}
