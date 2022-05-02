package kr.co.seculink.web.controller.popup;

import kr.co.seculink.domain.RtnMsg;
import kr.co.seculink.exception.BizException;
import kr.co.seculink.util.GEUtil;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;
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
public class PopupMngController
{
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate dao;

	//교육시설 리스트 조회
	@ResponseBody
	@RequestMapping("/popup/popupMng/searchLocList.ab")
	public RtnMsg searchLocList(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();

		List<Map<String, String>> result = dao.selectList("popup.popupMng.searchLocList", params);
		rtnMap.put("result", result);
		vo.setRtnData(rtnMap, params);

		if (!GEUtil.isEmpty(params.get("paging"))) {
			params.put("paging", "N");
			vo.setTotalCount(((List)dao.selectList("popup.popupMng.searchLocList", params)).size());
		}

		return vo;
	}

}
