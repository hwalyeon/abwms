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

import kr.hubble.api.model.RtnMsg;
import kr.hubble.exception.BizException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class StdtWaitRoomController
{	
	@Autowired
	private SqlSessionTemplate dao;
	
	@ResponseBody
	@RequestMapping("/clss/waitRoom/searchApplCous")
	public RtnMsg searchApplCous(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		
		List<Map<String, String>> result = dao.selectList("clss.waitRoom.searchApplCous", params);
		
		rtnMap.put("result", result);
		
		RtnMsg vo = new RtnMsg();
		vo.setRtnData(rtnMap);
		
		return vo;
	}
	
}
