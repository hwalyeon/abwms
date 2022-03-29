package kr.co.seculink.web.controller.oper.dgem;

import kr.co.seculink.domain.RtnMsg;
import kr.co.seculink.exception.BizException;
import kr.co.seculink.util.GEUtil;
import kr.co.seculink.web.excel.ExcelConstant;
import kr.co.seculink.web.service.oper.dgem.DszoneHistService;

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
public class DszoneHistController
{
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate dao;

	@Autowired
	private DszoneHistService dszoneHistService;

	// 위치정보_관리_조회_조건_조회
	@ResponseBody
	@RequestMapping("/oper/dgem/dszoneHist/searchLocInfoSelect.ab")
	public RtnMsg<Map<String, Object>> searchLocInfoSelect(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		RtnMsg<Map<String, Object>> vo = new RtnMsg<>();
		Map<String, Object> rtnMap = new HashMap<>();

		List<Map<String, String>> result = dszoneHistService.searchLocInfoSelect(params);
		List<Map<String, String>> result2 = dszoneHistService.searchLocInfoSelect2(params);

		rtnMap.put("result", result);
		rtnMap.put("result2", result2);
		vo.setRtnData(rtnMap);

		return vo;
	}

	// 위치정보_관리_학부모_학생_조건_조회
	@ResponseBody
	@RequestMapping("/oper/dgem/dszoneHist/searchPrntStdtList.ab")
	public RtnMsg<Map<String, Object>> searchPrntStdtList(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		RtnMsg<Map<String, Object>> vo = new RtnMsg<>();
		Map<String, Object> rtnMap = new HashMap<>();

		List<Map<String, String>> result = dszoneHistService.searchPrntNoSelect(params);
		List<Map<String, String>> result2 = dszoneHistService.searchStdtNoSelect(params);

		rtnMap.put("result", result);
		rtnMap.put("result2", result2);
		vo.setRtnData(rtnMap);

		return vo;
	}

	// 위치정보_관리_리스트_조회
	@ResponseBody
	@RequestMapping("/oper/dgem/dszoneHist/searchLocInfoList.ab")
	public RtnMsg<Map<String, Object>> searchLocInfoList(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		RtnMsg<Map<String, Object>> vo = new RtnMsg<>();
		Map<String, Object> rtnMap = new HashMap<>();

		List<Map<String, String>> result = dszoneHistService.searchLocInfoList(params);

		if ( !GEUtil.isEmpty(params.get("paging")) ) {
			params.put("paging", "N");
			vo.setTotalCount(dszoneHistService.searchLocInfoList(params).size());
		}

		rtnMap.put("result", result);
		vo.setRtnData(rtnMap);

		return vo;
	}

	// 위치정보_관리_리스트_상세정보_조회
	@ResponseBody
	@RequestMapping("/oper/dgem/dszoneHist/searchLocInfoSpec.ab")
	public RtnMsg<Map<String, Object>> searchLocInfoSpec(@RequestBody(required = false) Map<String, String> params) throws BizException
	{
		RtnMsg<Map<String, Object>> vo = new RtnMsg<>();
		Map<String, Object> rtnMap = new HashMap<>();
		List<Map<String, String>> result = dszoneHistService.searchLocInfoSpec(params);
		rtnMap.put("result", result);

		if ( !GEUtil.isEmpty(params.get("paging")) ) {
			params.put("paging", "N");
			vo.setTotalCount(dszoneHistService.searchLocInfoSpec(params).size());
		}

		vo.setRtnData(rtnMap, params);

		return vo;
	}

	// 위치정보_관리_상세정보_저장
	@ResponseBody
	@RequestMapping("/oper/dgem/dszoneHist/saveLocInfoSpec.ab")
	public RtnMsg<Map<String, Object>> saveLocInfoSpec(@RequestBody(required=false) Map<String, Object> params) throws BizException {
		RtnMsg<Map<String, Object>> vo = new RtnMsg<>();
		Map<String, Object> rtnMap = new HashMap<>();

		dszoneHistService.saveLocInfoSpec(params);

		rtnMap.put("result", params);
		vo.setRtnData(rtnMap,null);

		return vo;
	}

	// 위치정보_관리_리스트 엑셀다운로드
	@ResponseBody
	@RequestMapping("/oper/dgem/dszoneHist/searchLocInfoList/excel.ab")
	public ModelAndView downloadExcel(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		params.put("paging", "N");
		List<Map<String, String>> result = dao.selectList("oper.dgem.dszoneHist.searchLocInfoList", params);
		return new ModelAndView("excelXlsView", getExcelMap(result));
	}

	private Map<String, Object> getExcelMap(List<Map<String, String>> list)
	{
		String [] arrHeader = {"위치번호","위치명","장소구분","장소구분명","장소구분상세","장소구분상세명","공공/학부모","위도","경도","유효반경","남서위도","남서경도","북동위도","북동경도","우편번호","주소","주소상세","삭제여부","등록일자","등록시각","등록사용자ID","수정등록일자","수정시각","수정사용자ID"};
		List<String> headerList = Arrays.asList(arrHeader);
		List<List<String>> dataList = new ArrayList<>();
		List<String> data;

		for ( Map<String, String> info : list )
		{
			data = new ArrayList<>();
			data.add(String.valueOf(info.get("locNo")));
			data.add(info.get("locNm"));
			data.add(info.get("plcClssCd"));
			data.add(info.get("plcClssNm"));
			data.add(info.get("plcCd"));
			data.add(info.get("plcNm"));
			data.add(info.get("rdPublGuarDivNm"));
			data.add(String.valueOf(info.get("latVal")));
			data.add(String.valueOf(info.get("lonVal")));
			data.add(String.valueOf(info.get("valdRngeDist")));
			data.add(String.valueOf(info.get("swstLatVal")));
			data.add(String.valueOf(info.get("swstLonVal")));
			data.add(String.valueOf(info.get("nestLatVal")));
			data.add(String.valueOf(info.get("nestLonVal")));
			data.add(info.get("pstno"));
			data.add(info.get("addrBase"));
			data.add(info.get("addrSpec"));
			data.add(info.get("delYn"));
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
