package kr.hubble.web.controller.clss;

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

import kr.hubble.api.model.RtnMsg;
import kr.hubble.exception.BizException;
import kr.hubble.util.GEUtil;
import kr.hubble.util.XUtil;
import kr.hubble.web.excel.ExcelConstant;
import kr.hubble.web.model.ExcelVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CousApplMngController
{
	@Autowired
	private SqlSessionTemplate dao;
	
	@ResponseBody
	@RequestMapping("/clss/cousApplMng/searchCousApplList")
	public RtnMsg searchCousApplList(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		
		List<Map<String, String>> result = dao.selectList("clss.cousApplMng.searchCousApplList", params);
		if ( result == null || result.size() == 0 ) {
			throw new BizException("ECOM025");
		} else {
			rtnMap.put("result", result);
		}
		
		if ( params.containsKey("paging") ) {
			params.put("paging", "N");
			vo.setTotalCount(((List)dao.selectList("clss.cousApplMng.searchCousApplList", params)).size());
		}
		
		vo.setRtnData(rtnMap, params);
		
		return vo;
	}
	
	@ResponseBody
	@RequestMapping("/clss/cousApplMng/searchLectApplList")
	public RtnMsg searchLectApplList(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		
		List<Map<String, String>> result = dao.selectList("clss.cousApplMng.searchLectApplList", params);
		if ( result == null || result.size() == 0 ) {
			throw new BizException("ECOM025");
		} else {
			rtnMap.put("result", result);
		}
		
		if ( !GEUtil.isEmpty(params.get("paging")) ) {
			params.put("paging", "N");
			vo.setTotalCount(((List)dao.selectList("clss.cousApplMng.searchLectApplList", params)).size());
		}
		
		vo.setRtnData(rtnMap, params);
		
		return vo;
	}
	
	@ResponseBody
	@RequestMapping("/clss/cousApplMng/saveCousAppl")
	public RtnMsg saveCousAppl(@RequestBody(required=false) Map<String, String> params) throws BizException
	{	
		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		
		int saveCnt = 0;
		
		if ( "C".equals(params.get("crud")) ) {
			
			Map<String, String> cousStdtMap = dao.selectOne("clss.cousApplMng.searchTsCousStdt", params);
			params.put("cousStdtStatCd", "10");
			if ( cousStdtMap == null || cousStdtMap.isEmpty() ) {
				saveCnt = dao.insert("clss.cousApplMng.insertTsCousStdt", params);
			} else {
				saveCnt = dao.update("clss.cousApplMng.updateTsCousStdt", params);
			}
		} else if ( "D".equals(params.get("crud")) ) {
			params.put("cousStdtStatCd", "90");
			saveCnt = dao.delete("clss.cousApplMng.updateTsCousStdt", params);
		}
			
		if ( saveCnt == 0 ) {
			throw new BizException("ECOM999", new String[]{"교육신청 저장이 실패하였습니다."});
		}
		
		rtnMap.put("result", params);
		vo.setRtnData(rtnMap);
		
		return vo;
	}
	
	@ResponseBody
	@RequestMapping("/clss/cousApplMng/searchCousApplList/excel")
	public ModelAndView downloadExcelCousAppl(@RequestBody(required=false) Map<String, String> params) throws BizException
	{	
		ExcelVO vo = new ExcelVO();
		vo.setHeaders(new String[] {"학원명","과정명","강사명","과정시작일자","과정종료일자","수업시작시각","수업종료시각","수강료","강의신청상태"});
		vo.setKeys   (new String[] {"acdmNm","cousNm","lctrNm","cousStrtDt","cousEndDt","strtTm","endTm","stdtLfee","cousStdtStatNm"});
		vo.setData   (dao.selectList("clss.cousApplMng.searchCousApplList", params));
		
		return XUtil.getExcelView(vo);
	}
	
	
	@ResponseBody
	@RequestMapping("/clss/cousApplMng/searchLectApplList/excel")
	public ModelAndView downloadExcelLectAppl(@RequestBody(required=false) Map<String, String> params) throws BizException
	{	
		ExcelVO vo = new ExcelVO();
		vo.setHeaders(new String[] {"강의명","강의방법","강의시작일시","강의시간"});
		vo.setKeys   (new String[] {"lectNm","lectMethNm","lectStrtDttm","lectTcnt"});
		vo.setData   (dao.selectList("clss.cousApplMng.searchLectApplList", params));
		
		return XUtil.getExcelView(vo);
	}
}
