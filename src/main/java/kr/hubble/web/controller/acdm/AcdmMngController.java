package kr.hubble.web.controller.acdm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.seculink.api.model.RtnMsg;
import kr.co.seculink.exception.BizException;
import kr.hubble.web.service.set.UserMngService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class AcdmMngController 
{
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate dao;

	@Autowired
	private UserMngService userMngService;
	
	@ResponseBody
	@RequestMapping("/acdm/acdmMng/searchList")
	public RtnMsg searchList(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		
		List<Map<String, String>> result = dao.selectList("acdm.acdmMng.searchList", params);
		rtnMap.put("result", result);
		
		RtnMsg vo = new RtnMsg();
		
		params.put("paging", "N");
		vo.setTotalCount(((List)dao.selectList("acdm.acdmMng.searchList", params)).size());
		
		vo.setRowCount(Integer.parseInt(params.get("rowCount")));
		vo.setCurrentPage(Integer.parseInt(params.get("currentPage")));
		vo.setCurrentIndex(Integer.parseInt(params.get("currentIndex")));
		vo.setRtnData(rtnMap);
				
		return vo; 
	}
	
	@ResponseBody
	@RequestMapping("/acdm/acdmMng/searchDetl")
	public RtnMsg searchDetl(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		
		List<Map<String, String>> result = dao.selectList("acdm.acdmMng.searchList", params);
		rtnMap.put("result", result);
		
		RtnMsg vo = new RtnMsg();
		
		vo.setRtnData(rtnMap);
				
		return vo; 
	}
	
	@ResponseBody
	@RequestMapping("/acdm/acdmMng/saveAcdm")
	public RtnMsg saveUser(@RequestBody(required=false) Map<String, String> params) throws BizException
	{	
		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		
		userMngService.saveAcdm(params);
			
		rtnMap.put("result", params);
		vo.setRtnData(rtnMap);
		
		return vo;
	}
}
