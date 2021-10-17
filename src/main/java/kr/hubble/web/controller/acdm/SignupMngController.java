package kr.hubble.web.controller.acdm;

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
import kr.hubble.web.model.ExcelVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class SignupMngController
{
	@Autowired
	private SqlSessionTemplate dao;
	
	@ResponseBody
	@RequestMapping("/acdm/signupMng/searchSignupList")
	public RtnMsg searchSignupList(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		
		List<Map<String, String>> result = dao.selectList("acdm.acdmStdtMng.searchSignupList", params);
		if ( result == null || result.size() == 0 ) {
			throw new BizException("ECOM025");
		} else {
			rtnMap.put("result", result);
		}
		
		RtnMsg vo = new RtnMsg();
		
		if ( !GEUtil.isEmpty(params.get("paging")) ) {
			params.put("paging", "N");
			vo.setTotalCount(((List)dao.selectList("acdm.acdmStdtMng.searchSignupList", params)).size());
		}
		
		vo.setRtnData(rtnMap, params);
		
		return vo;
	}
	
	@ResponseBody
	@RequestMapping("/acdm/signupMng/saveCousStdtStat")
	public RtnMsg saveCousStdtStat(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		
		int saveCnt = 0;
		
		String crud = params.get("crud");
		if ( "C".equals(crud) ) {
			saveCnt = dao.insert("clss.cousApplMng.insertTsCousStdt", params);
		} else if ( "U".equals(crud) ) {
			saveCnt = dao.update("clss.cousApplMng.updateTsCousStdt", params);
		} else if ( "D".equals(crud) ) {
			saveCnt = dao.update("clss.cousApplMng.deleteTsCousStdt", params);
		}
			
		if ( saveCnt == 0 ) {
			throw new BizException("ECOM999", new String[]{"과정 저장이 실패하였습니다."});
		}
		
		rtnMap.put("result", params);
		vo.setRtnData(rtnMap);
		
		return vo;
	}
	
	@ResponseBody
	@RequestMapping("/acdm/signupMng/saveCousStdtStatList")
	public RtnMsg saveCousStdtStatList(@RequestBody(required=false) Map<String, Object> params) throws BizException
	{
		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		
		List<Map<String, String>> cousStdtList = (List) params.get("cousStdtList");
		
		for ( Map cousStdt : cousStdtList )
		{
			dao.update("clss.cousApplMng.updateTsCousStdt", cousStdt);
		}
		
		rtnMap.put("result", params);
		vo.setRtnData(rtnMap);
		
		return vo;
	}
	
	@ResponseBody
	@RequestMapping("/acdm/signupMng/searchSignupList/excel")
	public ModelAndView downloadExcel(@RequestBody(required=false) Map<String, String> params) throws BizException
	{	
		ExcelVO vo = new ExcelVO();
		vo.setHeaders(new String[] {"학원명","과정명","과정상태","강사명","과정시작일자","과정종료일자","수업시작시각","수업종료시각","학생ID","학생명","휴대전화번호","메일주소","수강상태"});
		vo.setKeys   (new String[] {"acdmNm","cousNm","cousStatNm","lctrNm","cousStrtDt","cousEndDt","strtTm","endTm","stdtId","stdtNm","mtelNo","mailAddr","cousStdtStatNm"});
		vo.setData   (dao.selectList("acdm.acdmStdtMng.searchSignupList", params));
		
		return XUtil.getExcelView(vo);
	}
}
