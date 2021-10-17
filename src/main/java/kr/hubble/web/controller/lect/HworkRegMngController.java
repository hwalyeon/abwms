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

import kr.hubble.api.model.RtnMsg;
import kr.hubble.exception.BizException;
import kr.hubble.util.GEUtil;
import kr.hubble.web.excel.ExcelConstant;
import kr.hubble.web.service.clss.HworkMngService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HworkRegMngController
{
	@Autowired
	private SqlSessionTemplate dao;
	
	@Autowired
	private HworkMngService hworkMngService;
	
	@ResponseBody
	@RequestMapping("/lect/hworkRegMng/searchHworkList")
	public RtnMsg searchHworkList(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		
		List<Map<String, String>> result = dao.selectList("lect.hworkRegMng.selectTsCousHworkBase", params);
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
	@RequestMapping("/lect/hworkRegMng/saveHwork")
	public RtnMsg saveHwork(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		
		int saveCnt = 0;
		// selectTsCousHworkBase
		
		String crud = params.get("crud");
		if ( "C".equals(crud) ) {
			saveCnt = dao.insert("lect.hworkRegMng.insertTsCousHworkBase", params);
		} else if ( "U".equals(crud) ) {
			saveCnt = dao.update("lect.hworkRegMng.updateTsCousHworkBase", params);
		} else if ( "D".equals(crud) ) {			
			saveCnt = dao.delete("lect.hworkRegMng.deleteTsCousHworkBase", params);
			dao.delete("lect.hworkRegMng.deleteAllTsCousHworkDetl", params);
		}
		
		// 문제풀이 과정일 경우 과제상세 저장
		if(!"D".equals(crud) && "20".equals(params.get("hworkTypeCd"))) {
			int hworkCnt = Integer.parseInt(params.get("hworkCnt"));
			
			if(hworkCnt > 0) {
				for(int i = 1 ; i <= hworkCnt ; i++) {
					params.put("seq" , i+"" );
					dao.update("lect.hworkRegMng.mergeTsCousHworkDetl", params);
				}
				dao.delete("lect.hworkRegMng.deleteTsCousHworkDetl", params);
			}
		}
			
		if ( saveCnt == 0 ) {
			throw new BizException("ECOM999", new String[]{"과제 저장이 실패하였습니다."});
		}
		
		rtnMap.put("result", params);
		vo.setRtnData(rtnMap);
		
		return vo;
	}
	
	@ResponseBody
	@RequestMapping("/lect/hworkRegMng/searchHworkDetlList")
	public RtnMsg searchHworkDetlList(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		
		List<Map<String, String>> result = dao.selectList("lect.hworkRegMng.selectTsCousHworkDetl", params);
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
	@RequestMapping("/lect/hworkRegMng/saveHworkDetl")
	public RtnMsg saveHworkDetl(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		
		int saveCnt = 0;
		// selectTsCousHworkBase
		
		String crud = params.get("crud");
		if ( "U".equals(crud) ) {
			saveCnt = dao.update("lect.hworkRegMng.updateTsCousHworkDetl", params);
		} else if ( "D".equals(crud) ) {			
			saveCnt = dao.update("lect.hworkRegMng.updateDelTsCousHworkDetl", params);
		}
			
		if ( saveCnt == 0 ) {
			throw new BizException("ECOM999", new String[]{"과제내용 저장이 실패하였습니다."});
		}		
		rtnMap.put("result", params);
		vo.setRtnData(rtnMap);
		
		return vo;
	}
	
	@ResponseBody
	@Transactional
	@RequestMapping("/lect/hworkRegMng/saveHworkRegEnd")
	public RtnMsg saveHworkRegEnd(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		
		// 과제 종결 후 학생과제 저장
		hworkMngService.defaultTsHworkSolvDetl(params);
		
		rtnMap.put("result", params);
		vo.setRtnData(rtnMap);
		
		return vo;
	}
}
