package kr.hubble.web.controller.hist;

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
import kr.hubble.web.model.ExcelVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class TakeDetlMngController
{
	@Autowired
	private SqlSessionTemplate dao;
	
	@ResponseBody
	@RequestMapping("/hist/takeDetlMng/searchTakeDetlList")
	public RtnMsg searchTakeDetlList(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		
		List<Map<String, String>> result = dao.selectList("hist.takeDetlMng.selectTsCousLect", params);
		rtnMap.put("result", result);
		
		RtnMsg vo = new RtnMsg();
		
		if ( !GEUtil.isEmpty(params.get("paging")) ) {
			params.put("paging", "N");
			vo.setTotalCount(((List)dao.selectList("hist.takeDetlMng.selectTsCousLect", params)).size());
		}
		
		vo.setRtnData(rtnMap, params);
		
		return vo;
	}
	
	
	@ResponseBody
	@RequestMapping("/hist/takeDetlMng/searchCousTakeDetlList")
	public RtnMsg searchCousTakeDetlList(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		
		List<Map<String, String>> result = dao.selectList("hist.takeDetlMng.selectTsCousTakeDetl", params);
		rtnMap.put("result", result);
		
		RtnMsg vo = new RtnMsg();
		
		if ( !GEUtil.isEmpty(params.get("paging")) ) {
			params.put("paging", "N");
			vo.setTotalCount(((List)dao.selectList("hist.takeDetlMng.selectTsCousTakeDetl", params)).size());
		}
		
		vo.setRtnData(rtnMap, params);
		
		return vo;
	}
	
	@ResponseBody
	@RequestMapping("/hist/takeDetlMng/saveCousTakeDetl")
	public RtnMsg saveTakeDetl(@RequestBody(required=false) List<Map<String, String>> params) throws BizException
	{
		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		
		for ( Map<String, String> data : params ) 
		{
			dao.update("hist.takeDetlMng.updateTsCousTakeDetl", data);
		}
		
		rtnMap.put("result", params);
		vo.setRtnData(rtnMap);
		
		return vo;
	}
	
	@ResponseBody
	@RequestMapping("/hist/takeDetlMng/searchTakeDetlList/excel")
	public ModelAndView downloadExcel(@RequestBody(required=false) Map<String, String> params) throws BizException
	{	
		ExcelVO vo = new ExcelVO();
		vo.setHeaders(new String[] {"학원명","과정명","강의명","강사명","강의시작일자","강의종료일자","학생수","출석수","과제제출수"});
		vo.setKeys   (new String[] {"acdmNm","cousNm","lectNm","lctrNm","lectStrtDttm","lectEndDttm","stdtCnt","atndCnt","hworkSbmtCnt"});
		vo.setData   (dao.selectList("hist.takeDetlMng.selectTsCousLect", params));
		
		return XUtil.getExcelView(vo);
	}
}
