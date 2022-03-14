package kr.co.seculink.web.controller.user.stdt;

import kr.co.seculink.domain.RtnMsg;
import kr.co.seculink.exception.BizException;
import kr.co.seculink.util.GEUtil;
import kr.co.seculink.web.excel.ExcelConstant;
import kr.co.seculink.web.service.user.stdt.StdtInfoMngService;
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
public class StdtInfoMngController
{

	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate dao;

	@Autowired
	private StdtInfoMngService stdtInfoMngService;

	//학생정보 리스트 조회
	@ResponseBody
	@RequestMapping("/user/stdt/stdtInfoMng/searchStdtInfoList.ab")
	public RtnMsg searchStdtInfoList(@RequestBody(required = false) Map<String, String> params) throws BizException
	{

		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();


		List<Map<String, String>> result = dao.selectList("user.stdt.stdtInfoMng.searchStdtInfoList", params);
		rtnMap.put("result", result);


		if (!GEUtil.isEmpty(params.get("paging"))) {
			params.put("paging", "N");
			vo.setTotalCount(((List)dao.selectList("user.stdt.stdtInfoMng.searchStdtInfoList", params)).size());
		}

		vo.setRtnData(rtnMap, params);

		return vo;
	}

	//학생정보 엑셀 다운로드
	@ResponseBody
	@RequestMapping("/user/stdt/stdtInfoMng/searchStdtInfoList/excel.ab")
	public ModelAndView downloadExcel(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		params.put("paging", "N");
		List<Map<String, String>> result = dao.selectList("user.stdt.stdtInfoMng.searchStdtInfoList", params);

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

	//학생정보 상세화면 리스트 조회
	@ResponseBody
	@RequestMapping("/user/stdt/stdtInfoMng/searchStdtInfo.ab")
	public RtnMsg searchStdtInfo(@RequestBody(required = false) Map<String, String> params) throws BizException
	{

		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();


		List<Map<String, String>> result = dao.selectList("user.stdt.stdtInfoMng.searchStdtInfoList", params);

		if(result.size() > 0 ){
			rtnMap.put("result", result.get(0));
		}

		vo.setRtnData(rtnMap, params);

		return vo;
	}

	//학생정보 저장
	@ResponseBody
	@RequestMapping("/user/stdt/stdtInfoMng/saveInfo.ab")
	public RtnMsg saveInfo(@RequestBody(required=false) Map<String, Object> params) throws BizException {
		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();

		if     ("C".equals(params.get("crud"))) dao.insert("user.stdt.stdtInfoMng.insertTmStdtBase",params);
		else if("U".equals(params.get("crud"))) dao.insert("user.stdt.stdtInfoMng.updateTmStdtBase",params);
		else if("D".equals(params.get("crud"))) dao.insert("user.stdt.stdtInfoMng.deleteTmStdtBase",params);

		rtnMap.put("result", params);
		vo.setRtnData(rtnMap,null);

		return vo;
	}

	//밴드ID 중복 조회
	@ResponseBody
	@RequestMapping("/user/stdt/stdtInfoMng/searchDupBandId.ab")
	public RtnMsg searchDupBandId(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();

		Map<String, String> result = stdtInfoMngService.searchDupBandId(params);

		rtnMap.put("result", result);
		vo.setRtnData(rtnMap);

		return vo;
	}

	//밴드ID 채번
	@ResponseBody
	@RequestMapping("/user/stdt/stdtInfoMng/numberingBandId.ab")
	public RtnMsg numberingBandId(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();

		Map<String, Object> result = stdtInfoMngService.numberingBandId(params);

		rtnMap.put("result", result);
		vo.setRtnData(rtnMap);

		return vo;
	}

	//밴드정보 저장
	@ResponseBody
	@RequestMapping("/user/stdt/stdtInfoMng/saveBandOpenInfoDetl.ab")
	public RtnMsg saveBandOpenInfoDetl(@RequestBody(required = false)Map<String,Object>params)throws BizException {

		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		stdtInfoMngService.saveBandOpenInfoDetl(params);


		rtnMap.put("result", params);
		vo.setRtnData(rtnMap, params);

		return vo;
	}

	//밴드_정보_상세보기
	@ResponseBody
	@RequestMapping("/user/stdt/stdtInfoMng/searchBandOpenInfo.ab")
	public RtnMsg searchBandOpenInfo(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();

		Map<String, Object> result = stdtInfoMngService.searchBandOpenInfo(params);

		rtnMap.put("result", result);
		vo.setRtnData(rtnMap);

		return vo;
	}

	//행추가_행삭제_저장
	@ResponseBody
	@RequestMapping("/user/stdt/stdtInfoMng/saveBandOpenDetlGuarTelNo.ab")
	public RtnMsg saveGrowStnd(@RequestBody(required = false)Map<String,Object>params)throws BizException {
		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();

		stdtInfoMngService.saveBandOpenDetlGuarTelNo(params);

		rtnMap.put("result", params);
		vo.setRtnData(rtnMap, params);

		return vo;
	}
}
