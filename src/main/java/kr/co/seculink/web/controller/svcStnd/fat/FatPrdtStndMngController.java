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

	// 비만_예측_기준 리스트 조회
	@ResponseBody
	@RequestMapping("/svcStnd/fat/fatPrdtStndMng/searchFatPrdtList.ab")
	public RtnMsg searchFatPrdtList(@RequestBody(required = false) Map<String, String> params) throws BizException {
		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();

		List<Map<String, String>> result = fatPrdtStndMngService.searchFatPrdtList(params);
		rtnMap.put("result", result);

		if( result.size() == 0)
		{
			rtnMap.put("existsYn","N");
		}else{
			rtnMap.put("existsYn","Y");
		}
		if (!GEUtil.isEmpty(params.get("paging"))) {
			params.put("paging", "N");
			vo.setTotalCount(((List) fatPrdtStndMngService.searchFatPrdtList(params)).size());
		}

		vo.setRtnData(rtnMap, params);

		return vo;
	}

    // 비만예측기준 저장
	@ResponseBody
	@RequestMapping("/svcStnd/fat/fatPrdtStndMng/saveInfo.ab")
	public RtnMsg saveInfo(@RequestBody(required=false) Map<String, Object> params) throws BizException {


		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();

		fatPrdtStndMngService.saveFatJudgSpecDetl(params);


		rtnMap.put("result", params);
		vo.setRtnData(rtnMap, null);

		return vo;
	}
	//비만_예측_기준_리스트 엑셀다운로드
	@ResponseBody
	@RequestMapping("/svcStnd/fat/fatPrdtStndMng/searchFatPrdtList/excel.ab")
	public ModelAndView downloadExcel(@RequestBody(required = false) Map<String, String> params) throws BizException {

		params.put("paging", "N");
		List<Map<String, String>> result = dao.selectList("svcStnd.fat.fatPrdtStndMng.selectTiFatPrdtSpecBase", params);

		return new ModelAndView("excelXlsView", getExcelMap(result));
	}

	private Map<String, Object> getExcelMap(List<Map<String, String>> list) {
		String[] arrHeader = { "비만 판정 코드 명"
				             , "비만예측 판정 코드 명"
				             , "비만예측 평가 요약"
				             , "비만예측 평가 내용"
				             , "등록 일자"
				             , "등록 시각"
				             , "등록 사용자 ID"
				             , "칼로리 소모량"
				             , "수정 일자"
				             , "수정 시각"
				             , "수정 사용자 ID" };
		List<String> headerList = Arrays.asList(arrHeader);

		List<List<String>> dataList = new ArrayList<List<String>>();
		List<String> data;

		for (Map<String, String> info : list) {
			data = new ArrayList<String>();
			data.add(info.get("fatJudgCdNm"));
			data.add(info.get("fatpJudgCdNm"));
			data.add(info.get("fatpEvalSmry"));
			data.add(info.get("fatpEvalCntn"));
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
