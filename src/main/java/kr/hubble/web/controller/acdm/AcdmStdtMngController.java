package kr.hubble.web.controller.acdm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.co.seculink.api.model.RtnMsg;
import kr.co.seculink.exception.BizException;
import kr.co.seculink.util.GEUtil;
import kr.co.seculink.util.XUtil;
import kr.hubble.web.excel.ExcelConstant;
import kr.hubble.web.model.ExcelVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class AcdmStdtMngController
{
	@Autowired
	private SqlSessionTemplate dao;
	
	@ResponseBody
	@RequestMapping("/acdm/acdmStdtMng/searchAcdmStdtList")
	public RtnMsg searchAcdmStdtList(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		
		List<Map<String, Object>> result = dao.selectList("acdm.acdmStdtMng.searchAcdmStdtList", params);
		if ( result == null || result.size() == 0 ) {
			throw new BizException("ECOM025");
		} else {
			rtnMap.put("result", result);
		}
		
		RtnMsg vo = new RtnMsg();
		
		if ( !GEUtil.isEmpty(params.get("paging")) ) {
			params.put("paging", "N");
			vo.setTotalCount(((List)dao.selectList("acdm.acdmStdtMng.searchAcdmStdtList", params)).size());
		}
		
		vo.setRtnData(rtnMap, params);
		
		return vo;
	}
	
	@ResponseBody
	@RequestMapping("/acdm/acdmStdtMng/searchStdtCousList")
	public RtnMsg searchStdtCousList(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		
		List<Map<String, Object>> result = dao.selectList("acdm.acdmStdtMng.searchStdtCousList", params);
		if ( result == null || result.size() == 0 ) {
			throw new BizException("ECOM025");
		} else {
			rtnMap.put("result", result);
		}
		
		RtnMsg vo = new RtnMsg();
		
		if ( !GEUtil.isEmpty(params.get("paging")) ) {
			params.put("paging", "N");
			vo.setTotalCount(((List)dao.selectList("acdm.acdmStdtMng.searchStdtCousList", params)).size());
		}
		
		vo.setRtnData(rtnMap, params);
		
		return vo;
	}
	
	@ResponseBody
	@RequestMapping("/acdm/acdmStdtMng/searchAcdmStdtInfo")
	public RtnMsg searchAcdmStdtInfo(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		
		Map<String, String> result = dao.selectOne("acdm.acdmStdtMng.searchAcdmStdtList", params);
		
		rtnMap.put("result", result);
		vo.setRtnData(rtnMap);
				
		return vo; 
	}
	
	@ResponseBody
	@RequestMapping("/acdm/acdmStdtMng/searchAcdmStdtList/excel")
	public ModelAndView downloadExcelStdt(@RequestBody(required=false) Map<String, String> params) throws BizException
	{	
		ExcelVO vo = new ExcelVO();
		vo.setHeaders(new String[] {"학원명","학생명","휴대전화번호","메일주소","등록강의건수"});
		vo.setKeys   (new String[] {"acdmNm", "stdtNm", "mtelNo", "mailAddr", "regCousCnt"});
		vo.setData   (dao.selectList("acdm.acdmStdtMng.searchAcdmStdtList", params));
		
		return XUtil.getExcelView(vo);
	}
	
	@ResponseBody
	@RequestMapping("/acdm/acdmStdtMng/searchStdtCousList/excel")
	public ModelAndView downloadExcelCous(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		ExcelVO vo = new ExcelVO();
		vo.setHeaders(new String[] {"과정명","과정시작일자","과정종료일자","과정상태","신청상태"});
		vo.setKeys   (new String[] {"cousNm","cousStrtDt","cousEndDt","cousStatNm","cousStdtStatNm"});
		vo.setData   (dao.selectList("acdm.acdmStdtMng.searchStdtCousList", params));
		
		return XUtil.getExcelView(vo);

	}
}
