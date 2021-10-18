package kr.hubble.web.controller.acdm;

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
import org.springframework.web.servlet.ModelAndView;

import kr.co.seculink.api.model.RtnMsg;
import kr.co.seculink.exception.BizException;
import kr.co.seculink.util.GEUtil;
import kr.co.seculink.util.XUtil;
import kr.hubble.web.excel.ExcelConstant;
import kr.hubble.web.model.ExcelVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class AcdmLctrMngController
{
	@Autowired
	private SqlSessionTemplate dao;
	
	@ResponseBody
	@RequestMapping("/acdm/acdmLctrMng/searchAcdmLctrList")
	public RtnMsg searchAcdmLctrList(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		
		List<Map<String, Object>> result = dao.selectList("acdm.acdmLctrMng.selectToAcdmLctr", params);
		if ( result == null || result.size() == 0 ) {
			throw new BizException("ECOM025");
		} else {
			rtnMap.put("result", result);
		}
		
		RtnMsg vo = new RtnMsg();
		
		if ( !GEUtil.isEmpty(params.get("paging")) ) {
			params.put("paging", "N");
			vo.setTotalCount(((List)dao.selectList("acdm.acdmLctrMng.selectToAcdmLctr", params)).size());
		}
		
		vo.setRtnData(rtnMap, params);
		
		return vo;
	}
	
	@ResponseBody
	@RequestMapping("/acdm/acdmLctrMng/searchAcdmLctrInfo")
	public RtnMsg searchAcdmLctrInfo(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		
		Map<String, String> result = dao.selectOne("acdm.acdmLctrMng.selectToAcdmLctr", params);
		
		rtnMap.put("result", result);
		vo.setRtnData(rtnMap);
				
		return vo; 
	}
	
	@ResponseBody
	@RequestMapping("/acdm/acdmLctrMng/saveAcdmLctr")
	public RtnMsg saveAcdmLctr(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		
		int saveCnt = 0;
		
		String crud = params.get("crud");
		if ( "C".equals(crud) ) {
			saveCnt = dao.insert("acdm.acdmLctrMng.insertToAcdmLctr", params);
		} else if ( "U".equals(crud) ) {
			saveCnt = dao.update("acdm.acdmLctrMng.updateToAcdmLctr", params);
		} else if ( "D".equals(crud) ) {
			saveCnt = dao.update("acdm.acdmLctrMng.deleteToAcdmLctr", params);
		}
			
		if ( saveCnt == 0 ) {
			throw new BizException("ECOM999", new String[]{"학원 강사 저장이 실패하였습니다."});
		}
		
		rtnMap.put("result", params);
		vo.setRtnData(rtnMap);
		
		return vo;
	}
	
	@ResponseBody
	@RequestMapping("/acdm/acdmLctrMng/searchAcdmLctrList/excel")
	public ModelAndView downloadExcel(@RequestBody(required=false) Map<String, String> params) throws BizException
	{	
		ExcelVO vo = new ExcelVO();
		vo.setHeaders(new String[] {"학원명","강사명","계약시작일자","계약종료일자","고용형태","계약상태","강의료정산구분","월강의료","인당강의료율","인당강의료금액"});
		vo.setKeys   (new String[] {"acdmNm","lctrNm","contStrtDt","contEndDt","hireFormNm","contStatNm","lfeeStlmDivNm","mmLfee","pmanLfeeRt","pmanLfeeAmt"});
		vo.setData   (dao.selectList("acdm.acdmLctrMng.selectToAcdmLctr", params));
		
		return XUtil.getExcelView(vo);
	}
}
