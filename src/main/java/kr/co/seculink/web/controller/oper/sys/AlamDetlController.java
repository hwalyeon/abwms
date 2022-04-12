package kr.co.seculink.web.controller.oper.sys;

import kr.co.seculink.domain.RtnMsg;
import kr.co.seculink.exception.BizException;
import kr.co.seculink.feign.service.FeignService;
import kr.co.seculink.feign.vo.AlrmVO;
import kr.co.seculink.util.GEUtil;
import kr.co.seculink.util.XUtil;
import kr.co.seculink.web.excel.ExcelConstant;
import kr.co.seculink.web.model.cmon.SessionVO;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.*;

@Slf4j
@Controller
public class AlamDetlController
{

	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate dao;

	@Autowired
	private FeignService feignService;

	@ResponseBody
	@RequestMapping("/stat/hc/alamDetl/sendAlamList.ab")
	public RtnMsg sendAlamList(@RequestBody(required = false) Map<String, String> AlrmVO) throws BizException
	{

		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();

		SessionVO sessionVO = GEUtil.getSessionVo();

		AlrmVO alrmVO = new AlrmVO();
		alrmVO.setGuarNo(Double.valueOf(AlrmVO.get("guarNo")));
		alrmVO.setStdtNo(Double.valueOf(AlrmVO.get("stdtNo")));
		alrmVO.setUserId(sessionVO.getUserId());
		alrmVO.setAlamTitl(AlrmVO.get("alamTitl"));
		alrmVO.setEtcAlamCntn(AlrmVO.get("etcAlamCntn"));
		alrmVO.setAlamTypeCd("ETC");
		AlrmVO rtnVO  = feignService.sendPush(alrmVO);
		rtnMap.put("result", rtnVO);

		vo.setRtnData(rtnMap, AlrmVO);

		return vo;
	}
}
