package kr.co.seculink.web.controller.cmon;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.co.seculink.util.XUtil;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import kr.co.seculink.domain.RtnMsg;
import kr.co.seculink.exception.BizException;
import kr.co.seculink.util.GEUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class CmonController
{
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate dao;
	
	@RequestMapping("/cmon/code/searchCmonCdList.ab")
	public RtnMsg searchCmonCdList(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		
		if ( GEUtil.isEmpty(params.get("cdGrp")) ) {
			throw new BizException("VALID.001", new String[] {"코드그룹"});
		}

		List<Map<String, String>> result = dao.selectList("cmon.code.searchCmonCdList", params);
		
		rtnMap.put("result", result);
		vo.setRtnData(rtnMap);
				
		return vo;
	}
	
	@RequestMapping("/cmon/menu/searchMenuList.ab")
	public RtnMsg searchMenuList(@RequestBody(required=false) Map<String, String> params)
	{
		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		
		Map<String, Object> param = new HashMap<String, Object>();
		if (XUtil.isEmpty(params.get("userId")) ) {
			param.put("userId"  , GEUtil.getSessionUserId());
		} else {
			param.put("userId"  , params.get("userId"));
		}

//		param.put("roleList", GEUtil.getRoleList());

		List<Map<String, String>> result = dao.selectList("cmon.user.searchMenuList", param);
		
		rtnMap.put("result", result);
		vo.setRtnData(rtnMap);
				
		return vo;
	}
	
	@RequestMapping("/cmon/deleteImage.ab")
	public RtnMsg deleteImage(String key) throws BizException
	{
		log.debug("key: " + key);
		return new RtnMsg();
	}
	
	@GetMapping("/facebookLoginCallback.ab")
	public RtnMsg proc(@RequestParam("code") String authrizationCode, @RequestParam("state") String state)
    {
        System.out.println("facebookLoginCallback : " + authrizationCode);
        System.out.println("state : " + state);
        
        return new RtnMsg();
    }
}
