package kr.co.seculink.web.controller.svcStnd.act;

import kr.co.seculink.domain.RtnMsg;
import kr.co.seculink.exception.BizException;
import kr.co.seculink.util.GEUtil;
import kr.co.seculink.web.excel.ExcelConstant;
import kr.co.seculink.web.service.svcStnd.act.FatActStndMngService;
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
public class FatActStndMngController
{
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate dao;

	@Autowired
	private FatActStndMngService fatActStndMngService;


	// 비만활동_기준_리스트_조회
	@ResponseBody
	@RequestMapping("/svcStnd/act/fatActStndMng/searchFatActStndList.ab")
	public RtnMsg searchFatActStndList(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();

		List<Map<String, String>> result = fatActStndMngService.searchFatActStndList(params);

		if ( !GEUtil.isEmpty(params.get("paging")) ) {
			params.put("paging", "N");
			vo.setTotalCount(((List)fatActStndMngService.searchFatActStndList(params)).size());
		}
		rtnMap.put("result", result);
		vo.setRtnData(rtnMap, params);

		return vo;
	}

	// 비만활동_기준_리스트 엑셀다운로드
	@ResponseBody
	@RequestMapping("/svcStnd/act/fatActStndMng/searchFatActStndList/excel.ab")
	public ModelAndView downloadExcel(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		params.put("paging", "N");

		List<Map<String, String>> result = dao.selectList("svcStnd.act.fatActStndMng.searchFatActStndList", params);
		return new ModelAndView("excelXlsView", getExcelMap(result));
	}

	private Map<String, Object> getExcelMap(List<Map<String, String>> list)
	{
		String [] arrHeader = {"현재비만판정코드","현재비만판정명","예측비만판정코드","예측비만판정명","신체활동수준코드","신체활동수준명","비만활동비고","등록일자","등록시각","등록사용자ID","수정등록일자","수정시각","수정사용자ID"};
		List<String> headerList = Arrays.asList(arrHeader);

		List<List<String>> dataList = new ArrayList<List<String>>();
		List<String> data;

		for ( Map<String, String> info : list )
		{
			data = new ArrayList<String>();
			data.add(info.get("currFatJudgCd"));
			data.add(info.get("currFatJudgNm"));
			data.add(info.get("prdtFatJudgCd"));
			data.add(info.get("prdtFatJudgNm"));
			data.add(info.get("palCd"));
			data.add(info.get("palNm"));
			data.add(info.get("fatActRmrk"));
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

	//상세보기_조회
	@ResponseBody
	@RequestMapping("/svcStnd/act/fatActStndMng/searchFatActStndInfo.ab")
	public RtnMsg searchFatActStndInfo(@RequestBody(required = false) Map<String, String> params) throws BizException
	{
		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();

		List<Map<String, String>> result = fatActStndMngService.searchFatActStndList(params);

		if(result.size() > 0 ){
			rtnMap.put("result", result.get(0));
		}

		vo.setRtnData(rtnMap, params);

		return vo;
	}

	//상세보기_저장
	@ResponseBody
	@RequestMapping("/svcStnd/act/fatActStndMng/saveFatActStndInfo.ab")
	public RtnMsg saveFatActStndInfo(@RequestBody(required=false) Map<String, Object> params) throws BizException {
		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		fatActStndMngService.saveFatActStndInfo(params);

		rtnMap.put("result", params);
		vo.setRtnData(rtnMap,null);

		return vo;
	}

}
