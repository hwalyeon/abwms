package kr.hubble.web.controller.lect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.co.seculink.api.model.RtnMsg;
import kr.co.seculink.exception.BizException;
import kr.co.seculink.util.GEUtil;
import kr.hubble.web.excel.ExcelConstant;
import kr.hubble.web.service.clss.HworkMngService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HworkEvalMngController
{
	@Autowired
	private SqlSessionTemplate dao;
	
	@Autowired
	private HworkMngService hworkMngService;
	
	@ResponseBody
	@RequestMapping("/lect/hworkEvalMng/searchHworkEvalList")
	public RtnMsg searchHworkEvalList(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		
		List<Map<String, String>> result = dao.selectList("lect.hworkEvalMng.searchHworkEvalList", params);
		if ( result == null || result.size() == 0 ) {
			throw new BizException("ECOM025");
		} else {
			rtnMap.put("result", result);
		}
		
		RtnMsg vo = new RtnMsg();
		
		vo.setRtnData(rtnMap, params);
		
		return vo;
	}
	
	@ResponseBody
	@Transactional
	@RequestMapping("/lect/hworkEvalMng/saveHworkFileEval")
	public RtnMsg saveHworkFileEval(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		
		int saveCnt = 0;
		
		String crud = params.get("crud");
		if ( "U".equals(crud) ) {
			saveCnt = dao.update("lect.hworkEvalMng.updateTsCousTakeDetl", params);
		} 
			
		if ( saveCnt == 0 ) {
			throw new BizException("ECOM999", new String[]{"과제 저장이 실패하였습니다."});
		}
		
		rtnMap.put("result", params);
		vo.setRtnData(rtnMap);
		
		return vo;
	}
	
	@ResponseBody
	@Transactional
	@RequestMapping("/lect/hworkEvalMng/saveAutoEval")
	public RtnMsg saveAutoEval(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		
		// 강의 , 과정에 등록된 학생 조회하기
		List<Map<String, String>> result = dao.selectList("lect.hworkEvalMng.searchHworkEvalList", params);
		if ( result == null || result.size() == 0 ) {
			throw new BizException("ECOM025");
		}
		
		System.out.println("upUserId " + params.get("uptUserId"));
		
		// 학생 만큼 자동 채점 하기
		if (result.size() > 0 ) {
			for (int i = 0 ; i < result.size() ; i++ ) {
				Map<String, String> hworkInfo = result.get(i);
				hworkInfo.put("uptUserId", params.get("uptUserId"));
				dao.update("lect.hworkEvalMng.updateAutoTsHworkSolvDetl", hworkInfo);
				dao.update("lect.hworkEvalMng.updateAutoTsCousTakeDetl", hworkInfo);
			}
		}
		
		RtnMsg vo = new RtnMsg();
		
		vo.setRtnData(rtnMap);
		
		return vo;
	}
	
	@ResponseBody
	@Transactional
	@RequestMapping("/lect/hworkEvalMng/saveAnswer")
	public RtnMsg saveAnswer(@RequestBody(required=false) List<Map<String, String>> answList) throws BizException
	{
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		
		String cousNo  = "";
		String lectSeq = "";
		String stdtId  = "";
		
		for ( Map<String, String> answer : answList)
		{
			cousNo  = answer.get("cousNo");
			lectSeq = answer.get("lectSeq");
			stdtId  = answer.get("stdtId");
			
			dao.insert("lect.hworkEvalMng.updateTsHworkSolvDetl", answer);
		}
			
		RtnMsg vo = new RtnMsg();
		
		vo.setRtnData(rtnMap);
		
		return vo;
	}
	
	@ResponseBody
	@Transactional
	@RequestMapping("/lect/hworkEvalMng/saveEvalEnd")
	public RtnMsg saveEvalEnd(@RequestBody(required=false) Map<String, String> hworkInfo) throws BizException
	{
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		
		//TS_COUS_TAKE_DETL
		
		dao.update("lect.hworkEvalMng.updateSaveEvalEnd", hworkInfo);
	
		
		RtnMsg vo = new RtnMsg();
		
		vo.setRtnData(rtnMap);
		
		return vo;
	}
	
	
	
	
}
