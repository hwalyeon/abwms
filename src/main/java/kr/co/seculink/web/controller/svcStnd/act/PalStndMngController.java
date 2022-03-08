package kr.co.seculink.web.controller.svcStnd.act;

import kr.co.seculink.domain.RtnMsg;
import kr.co.seculink.exception.BizException;
import kr.co.seculink.util.GEUtil;
import kr.co.seculink.web.excel.ExcelConstant;
import kr.co.seculink.web.service.svcStnd.act.PalStndMngService;
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
public class PalStndMngController
{
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate dao;

	@Autowired
	private PalStndMngService palStndMngService;

	//신체활동수준_기준_리스트_조회
	@ResponseBody
	@RequestMapping("/svcStnd/act/palStndMng/searchPalStndList.ab")
	public RtnMsg<Map<String, Object>> searchPalStndList(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		RtnMsg<Map<String, Object>> vo = new RtnMsg<>();
		Map<String, Object> rtnMap = new HashMap<>();

		List<Map<String, String>> result = palStndMngService.searchPalStndList(params);

		if ( !GEUtil.isEmpty(params.get("paging")) ) {
			params.put("paging", "N");
			vo.setTotalCount(palStndMngService.searchPalStndList(params).size());
		}
		rtnMap.put("result", result);
		vo.setRtnData(rtnMap, params);

		return vo;
	}

	//모달창 사용으로 인해 미사용
	//행추가_행삭제_저장
	@ResponseBody
	@RequestMapping("/svcStnd/act/palStndMng/savePalStnd.ab")
	public RtnMsg<Map<String, Object>> savePalStnd(@RequestBody(required = false)Map<String,Object>params)throws BizException {
		RtnMsg<Map<String, Object>> vo = new RtnMsg<>();
		Map<String, Object> rtnMap = new HashMap<>();

		palStndMngService.savePalStnd(params);

		rtnMap.put("result", params);
		vo.setRtnData(rtnMap, params);

		return vo;
	}

	//신체활동수준_기준_리스트 엑셀다운로드
	@ResponseBody
	@RequestMapping("/svcStnd/act/palStndMng/searchPalStndList/excel.ab")
	public ModelAndView downloadExcel(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		params.put("paging", "N");

		List<Map<String, String>> result = dao.selectList("svcStnd.act.palStndMng.searchPalStndList", params);
		return new ModelAndView("excelXlsView", getExcelMap(result));
	}

	private Map<String, Object> getExcelMap(List<Map<String, String>> list)
	{
		String [] arrHeader = {"신체활동수준코드","신체활동수준명","신체활동수준값From","신체활동수준값To","신체활동수준 섭취 비고","등록일자","등록시각","등록사용자ID","수정등록일자","수정시각","수정사용자ID"};
		List<String> headerList = Arrays.asList(arrHeader);

		List<List<String>> dataList = new ArrayList<>();
		List<String> data;

		for ( Map<String, String> info : list )
		{
			data = new ArrayList<>();
			data.add(info.get("palCd"));
			data.add(info.get("palNm"));
			data.add(String.valueOf(info.get("palValFr")));
			data.add(String.valueOf(info.get("palValTo")));
			data.add(info.get("palEatRmrk"));
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
	@RequestMapping("/svcStnd/act/palStndMng/searchPalStndInfo.ab")
	public RtnMsg<Map<String, Object>> searchPalStndInfo(@RequestBody(required = false) Map<String, String> params) throws BizException
	{
		RtnMsg<Map<String, Object>> vo = new RtnMsg<>();
		Map<String, Object> rtnMap = new HashMap<>();

		List<Map<String, String>> result = palStndMngService.searchPalStndList(params);

		if(result.size() > 0 ){
			rtnMap.put("result", result.get(0));
		}

		vo.setRtnData(rtnMap, params);

		return vo;
	}

	//상세보기_저장
	@ResponseBody
	@RequestMapping("/svcStnd/act/palStndMng/savePalStndInfo.ab")
	public RtnMsg<Map<String, Object>> savePalStndInfo(@RequestBody(required=false) Map<String, Object> params) throws BizException {
		RtnMsg<Map<String, Object>> vo = new RtnMsg<>();
		Map<String, Object> rtnMap = new HashMap<>();

		palStndMngService.savePalStndInfo(params);

		rtnMap.put("result", params);
		vo.setRtnData(rtnMap,null);

		return vo;
	}

}
