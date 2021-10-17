package kr.hubble.web.controller.acdm;

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

import kr.hubble.api.model.RtnMsg;
import kr.hubble.exception.BizException;
import kr.hubble.util.GEUtil;
import kr.hubble.util.XUtil;
import kr.hubble.web.model.ExcelVO;
import kr.hubble.web.service.cous.CousMngService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CousMngController
{
	@Autowired
	private CousMngService cousMngService;
	
	@Autowired
	private SqlSessionTemplate dao;
	
	@ResponseBody
	@RequestMapping("/acdm/cousMng/searchCousList")
	public RtnMsg searchCousList(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		
		List<Map<String, String>> result = cousMngService.searchCousList(params);
		if ( result == null || result.size() == 0 ) {
			throw new BizException("ECOM025");
		} else {
			rtnMap.put("result", result);
		}
		
		RtnMsg vo = new RtnMsg();
		
		if ( !GEUtil.isEmpty(params.get("paging")) ) {
			params.put("paging", "N");
			vo.setTotalCount(cousMngService.searchCousList(params).size());
		}
		
		vo.setRtnData(rtnMap, params);
		
		return vo;
	}
	
	@ResponseBody
	@RequestMapping("/acdm/cousMng/saveCous")
	public RtnMsg saveCous(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		
		cousMngService.saveCous(params);
		
		rtnMap.put("result", params);
		vo.setRtnData(rtnMap);
		
		return vo;
	}
	
	@ResponseBody
	@RequestMapping("/acdm/cousMng/searchCousList/excel")
	public ModelAndView downloadExcel(@RequestBody(required=false) Map<String, String> params) throws BizException
	{	
		ExcelVO vo = new ExcelVO();
		vo.setHeaders(new String[] {"과정명","강사명","과정시작일자","과정종료일자","수업시작시각","수업종료시각","과정상태"});
		vo.setKeys   (new String[] {"cousNm","lctrNm","cousStrtDt","cousEndDt","strtTm","endTm","cousStatNm"});
		vo.setData   (cousMngService.searchCousList(params));
		
		return XUtil.getExcelView(vo);
	}
}
