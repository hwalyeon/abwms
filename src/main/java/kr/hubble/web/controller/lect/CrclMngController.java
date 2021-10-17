package kr.hubble.web.controller.lect;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.hubble.api.model.RtnMsg;
import kr.hubble.exception.BizException;
import kr.hubble.util.GEUtil;
import kr.hubble.util.XUtil;
import kr.hubble.web.model.ExcelVO;
import kr.hubble.web.service.clss.CrclMngService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CrclMngController
{
	@Autowired
	private CrclMngService crclMngService;
	
	@ResponseBody
	@RequestMapping("/lect/crclMng/searchCrclList")
	public RtnMsg searchCrclList(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		
		List<Map<String, String>> result = crclMngService.searchCrclList(params);
		if ( result == null || result.size() == 0 ) {
			throw new BizException("ECOM025");
		} else {
			rtnMap.put("result", result);
		}
		
		RtnMsg vo = new RtnMsg();
		
		if ( !GEUtil.isEmpty(params.get("paging")) ) {
			params.put("paging", "N");
			vo.setTotalCount(crclMngService.searchCrclList(params).size());
		}
		
		vo.setRtnData(rtnMap, params);
		
		return vo;
	}
	
	@ResponseBody
	@RequestMapping("/lect/crclMng/saveCrcl")
	public RtnMsg saveCrcl(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		
		crclMngService.saveCrcl(params);
		
		rtnMap.put("result", params);
		vo.setRtnData(rtnMap);
		
		return vo;
	}
	
	@ResponseBody
	@RequestMapping("/lect/crclMng/searchCrclList/excel")
	public ModelAndView downloadExcel(@RequestBody(required=false) Map<String, String> params) throws BizException
	{	
		ExcelVO vo = new ExcelVO();
		vo.setHeaders(new String[] {"과정명","강의명","강의방법","과제유형","강의시작일자","강의종료일자"});
		vo.setKeys   (new String[] {"cousNm","lectNm","lectMethNm","hworkTypeNm","lectStrtDttm","lectEndDttm"});
		vo.setData   (crclMngService.searchCrclList(params));
		
		return XUtil.getExcelView(vo);
	}
}
