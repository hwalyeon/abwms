package kr.hubble.web.controller.lect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.hubble.api.model.RtnMsg;
import kr.hubble.exception.BizException;
import kr.hubble.util.GEUtil;
import kr.hubble.util.XUtil;
import kr.hubble.web.excel.ExcelConstant;
import kr.hubble.web.model.ExcelVO;
import kr.hubble.web.service.set.UserMngService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LctrMngController
{
	@Autowired
	private SqlSessionTemplate dao;

	@Autowired
	private UserMngService userMngService;
	
	@ResponseBody
	@RequestMapping("/lect/lctrMng/searchLctrList")
	public RtnMsg searchLctrList(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		
		List<Map<String, String>> result = dao.selectList("lect.lctrMng.selectToLctrBase", params);
		if ( result == null || result.size() == 0 ) {
			throw new BizException("ECOM025");
		} else {
			rtnMap.put("result", result);
		}
		
		RtnMsg vo = new RtnMsg();
		
		if ( !GEUtil.isEmpty(params.get("paging")) ) {
			params.put("paging", "N");
			vo.setTotalCount(((List)dao.selectList("lect.lctrMng.selectToLctrBase", params)).size());
		}
		
		vo.setRtnData(rtnMap, params);
		
		return vo;
	}
	
	@ResponseBody
	@RequestMapping("/lect/lctrMng/searchLctrListPop")
	public RtnMsg searchLctrListPop(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		
		List<Map<String, String>> result = dao.selectList("lect.lctrMng.selectToLctrBasePop", params);
		if ( result == null || result.size() == 0 ) {
			throw new BizException("ECOM025");
		} else {
			rtnMap.put("result", result);
		}
		
		RtnMsg vo = new RtnMsg();
		
		if ( !GEUtil.isEmpty(params.get("paging")) ) {
			params.put("paging", "N");
			vo.setTotalCount(((List)dao.selectList("lect.lctrMng.selectToLctrBasePop", params)).size());
		}
		
		vo.setRtnData(rtnMap, params);
		
		return vo;
	}
	
	@ResponseBody
	@RequestMapping("/lect/lctrMng/saveLctr")
	public RtnMsg saveCous(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		
		MultipartFile uploadImg = null;
				
		userMngService.saveLctr(uploadImg, params);
		
		rtnMap.put("result", params);
		vo.setRtnData(rtnMap);
		
		return vo;
	}
	
	@ResponseBody
	@RequestMapping("/lect/lctrMng/searchLctrList/excel")
	public ModelAndView downloadExcel(@RequestBody(required=false) Map<String, String> params) throws BizException
	{	
		ExcelVO vo = new ExcelVO();
		vo.setHeaders(new String[] {"강사ID","강사명","사업자번호","전화번호","휴대전화번호","메일주소","강사상태"});
		vo.setKeys   (new String[] {"lctrId","lctrNm","bizNo","telNo","mtelNo","mailAddr","lctrStatNm"});
		vo.setData   (dao.selectList("lect.lctrMng.selectToLctrBase", params));
		
		return XUtil.getExcelView(vo);
	}
}
