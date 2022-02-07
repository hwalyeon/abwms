package kr.co.seculink.web.controller.svcStnd.strs;

import kr.co.seculink.domain.RtnMsg;
import kr.co.seculink.exception.BizException;
import kr.co.seculink.util.GEUtil;
import kr.co.seculink.web.service.set.UserMngService;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
public class StrsStndMngController {
	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate dao;

	@Autowired
	private UserMngService userMngService;

	@ResponseBody
	@RequestMapping("/svcStnd/strs/searchStrsList.ab")
	public RtnMsg searchUserList(@RequestBody(required = false) Map<String, String> params) throws BizException {
		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();

		List<Map<String, String>> result = userMngService.searchStrsList(params);
		rtnMap.put("result", result);

		if (!GEUtil.isEmpty(params.get("paging"))) {
			params.put("paging", "N");
			vo.setTotalCount(((List) userMngService.searchStrsList(params)).size());
		}

		vo.setRtnData(rtnMap, params);

		return vo;
	}

	@ResponseBody
	@RequestMapping("/set/userMng/searchUserInfo.ab")
	public RtnMsg searchUserInfo(@RequestBody(required = false) Map<String, String> params) throws BizException {
		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();

		Map<String, String> result = userMngService.searchUserInfo(params);

		List<Map<String, String>> roleList = dao.selectList("set.userRoleMng.searchTcUserRoleList", params);

		rtnMap.put("result", result);
		rtnMap.put("roleList", roleList);
		vo.setRtnData(rtnMap);

		return vo;
	}
}