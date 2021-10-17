package kr.hubble.web.controller.clss;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import kr.hubble.api.model.RtnMsg;
import kr.hubble.exception.BizException;
import kr.hubble.util.GEUtil;
import kr.hubble.util.XUtil;
import kr.hubble.web.model.ExcelVO;
import kr.hubble.web.service.set.UserMngService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class StdtMngController
{
	@Autowired
	private SqlSessionTemplate dao;
	
	@Autowired
	private UserMngService userMngService;
	
	@ResponseBody
	@RequestMapping("/clss/stdtMng/searchStdtList")
	public RtnMsg searchStdtList(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		
		List<Map<String, String>> result = dao.selectList("clss.stdtMng.selectToStdtBase", params);
		if ( result == null || result.size() == 0 ) {
			throw new BizException("ECOM025");
		} else {
			rtnMap.put("result", result);
		}
		
		RtnMsg vo = new RtnMsg();
		
		if ( !GEUtil.isEmpty(params.get("paging")) ) {
			params.put("paging", "N");
			vo.setTotalCount(((List)dao.selectList("clss.stdtMng.selectToStdtBase", params)).size());
		}
		
		vo.setRtnData(rtnMap, params);
		
		return vo;
	}
	
	@ResponseBody
	@RequestMapping("/clss/stdtMng/searchStdtInfo")
	public RtnMsg searchStdtInfo(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		
		Map<String, String> stdtInfo = dao.selectOne("clss.stdtMng.selectToStdtBase", params);
		if ( stdtInfo == null || stdtInfo.isEmpty() ) {
			throw new BizException("ECOM025");
		} else {
			rtnMap.put("stdtInfo", stdtInfo);
			
			List<Map<String, String>> imgList = dao.selectList("clss.stdtMng.selectToStdtImg", params);
			rtnMap.put("uploadImg", imgList);
		}
		
		RtnMsg vo = new RtnMsg();
		
		vo.setRtnData(rtnMap, params);
		
		return vo;
	}
	
	@ResponseBody
	@RequestMapping("/clss/stdtMng/saveStdt")
	public RtnMsg saveStdt(@RequestParam(value="metaData" , required=true ) String metaData,
						   @RequestParam(value="deleteImg", required=false) String deleteImg, 
						   @RequestPart (value="profImg"  , required=false) MultipartFile profImg,
						   @RequestPart (value="uploadImg", required=false) List<MultipartFile> uploadImgList) throws BizException
	{
		Gson gson = new Gson();
		Map<String, String> params = gson.fromJson(metaData, Map.class);
		
		List<Map<String, String>> delImgList = gson.fromJson(deleteImg, List.class);
		
		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();

		userMngService.saveStdt(profImg, uploadImgList, delImgList, params);
		
		rtnMap.put("result", params);
		vo.setRtnData(rtnMap);
		
		return vo;
	}
	
	@ResponseBody
	@RequestMapping("/clss/stdtMng/searchStdtList/excel")
	public ModelAndView downloadExcel(@RequestBody(required=false) Map<String, String> params) throws BizException
	{	
		ExcelVO vo = new ExcelVO();
		vo.setHeaders(new String[] {"학생ID","학생명","전화번호","휴대전화번호","메일주소"});
		vo.setKeys   (new String[] {"stdtId","stdtNm","telNo","mtelNo","mailAddr"});
		vo.setData   (dao.selectList("clss.stdtMng.selectToStdtBase", params));
		
		return XUtil.getExcelView(vo);
	}
}
