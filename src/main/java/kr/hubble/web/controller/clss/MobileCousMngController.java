package kr.hubble.web.controller.clss;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.seculink.api.model.RtnMsg;
import kr.co.seculink.exception.BizException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MobileCousMngController
{
	@Autowired
	private SqlSessionTemplate dao;
	
	@ResponseBody
	@RequestMapping("/mobile/cousMng/searchCousList")
	public RtnMsg searchCousList(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		
		List<Map<String, String>> result = dao.selectList("mobile.cousMng.searchCousList", params);
		if ( result == null || result.size() == 0 ) {
			throw new BizException("ECOM025");
		} else {
			rtnMap.put("result", result);
		}
		
		if ( params.containsKey("paging") ) {
			params.put("paging", "N");
			vo.setTotalCount(((List)dao.selectList("mobile.cousMng.searchCousList", params)).size());
		}
		
		vo.setRtnData(rtnMap, params);
		
		return vo;
	}
}
