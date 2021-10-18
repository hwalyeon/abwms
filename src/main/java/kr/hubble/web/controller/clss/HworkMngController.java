package kr.hubble.web.controller.clss;

import java.io.File;
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

import kr.co.seculink.api.model.RtnMsg;
import kr.co.seculink.exception.BizException;
import kr.co.seculink.util.GEUtil;
import kr.co.seculink.util.XUtil;
import kr.hubble.web.model.TcFileVO;
import kr.hubble.web.service.clss.HworkMngService;
import kr.hubble.web.service.cmon.FileService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HworkMngController
{
	@Autowired
	private SqlSessionTemplate dao;
	
	@Autowired
	private HworkMngService hworkMngService;
	
	@Autowired
	private FileService fileService;
	
	@ResponseBody
	@RequestMapping("/clss/hworkMng/searchCousList")
	public RtnMsg searchCousList(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		
		List<Map<String, String>> result = hworkMngService.searchCousList(params);
		if ( result == null || result.size() == 0 ) {
			throw new BizException("ECOM025");
		} else {
			rtnMap.put("result", result);
		}
		
		RtnMsg vo = new RtnMsg();
		
		if ( !GEUtil.isEmpty(params.get("paging")) ) {
			params.put("paging", "N");
			vo.setTotalCount(hworkMngService.searchCousList(params).size());
		}
		
		vo.setRtnData(rtnMap, params);
		
		return vo;
	}
	
	@ResponseBody
	@RequestMapping("/clss/hworkMng/searchHworkList")
	public RtnMsg searchHworkList(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		
		List<Map<String, String>> result = hworkMngService.searchHworkList(params);
		if ( result == null || result.size() == 0 ) {
			throw new BizException("ECOM025");
		} else {
			rtnMap.put("result", result);
		}
		
		RtnMsg vo = new RtnMsg();
		
		if ( !GEUtil.isEmpty(params.get("paging")) ) {
			params.put("paging", "N");
			vo.setTotalCount(hworkMngService.searchHworkList(params).size());
		}
		
		vo.setRtnData(rtnMap, params);
		
		return vo;
	}
	
	@ResponseBody
	@RequestMapping("/clss/hworkMng/searchQust")
	public RtnMsg searchQust(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		
		List<Map<String, String>> lectList = hworkMngService.searchHworkList(params);
		if ( lectList == null || lectList.size() != 1 ) {
			throw new BizException("ECOM025");
		}
		
		Map<String, String> lectInfo = lectList.get(0);
		if ( "20".equals(lectInfo.get("hworkTypeCd")) ) {
			List<Map<String, String>> qustList  = hworkMngService.selectTsCousHworkDetl(params);
			List<Map<String, String>> answList  = hworkMngService.selectTsHworkSolvDetl(params);
			
			rtnMap.put("qustList" , qustList);
			rtnMap.put("answList" , answList);
		}
		
		Map<String, String> hworkInfo = hworkMngService.selectTsCousHworkBase(params);
		rtnMap.put("hworkInfo", hworkInfo);
		
		RtnMsg vo = new RtnMsg();
		
		vo.setRtnData(rtnMap);
		
		return vo;
	}	
	
	@ResponseBody
	@RequestMapping("/clss/hworkMng/saveAnswer")
	public RtnMsg saveAnswer(@RequestBody(required=false) Map<String, Object> params) throws BizException
	{
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		
		hworkMngService.saveAnswer(params);
		
		RtnMsg vo = new RtnMsg();
		
		vo.setRtnData(rtnMap);
		
		return vo;
	}
	
	@ResponseBody
	@RequestMapping("/clss/hworkMng/uploadHworkFile")
	public RtnMsg uploadHworkFile(@RequestParam(value="metaData", required=true) String metaData,
								  @RequestPart(value="hworkFile", required=false) MultipartFile hworkFile) throws BizException
	{
		Gson gson = new Gson();
		Map<String, String> params = gson.fromJson(metaData, Map.class);
		
		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		
		int saveCnt = 0;
		
		TcFileVO tcFileVo = new TcFileVO();
		tcFileVo.setFileDivCd("HWORK");
		tcFileVo.setFile     (hworkFile);
		tcFileVo.setCousNo   (params.get("cousNo"));
		tcFileVo.setLectSeq  (params.get("lectSeq"));
		tcFileVo.setUserId   (params.get("stdtId"));
		
		String crud = params.get("crud");
		if ( "C".equals(crud) ) {
			fileService.save(tcFileVo);
			if ( XUtil.isEmpty(tcFileVo.getFileNo()) ) {
				throw new BizException("EFIL001");
			} else {
				params.put("hworkFileNo", tcFileVo.getFileNo());
			}
			
			hworkMngService.updateHworkFile(params);
			
		} else if ( "U".equals(crud) ) {
			tcFileVo.setFileNo(XUtil.getString(params.get("hworkFileNo")));
			fileService.save(tcFileVo);
			if ( XUtil.isEmpty(tcFileVo.getFileNo()) ) {
				throw new BizException("EFIL001");
			} else if ( tcFileVo.getFileNo().equals(params.get("profImgNo")) ) {
				throw new BizException("EFIL001");
			} else {
				params.put("hworkFileNo", tcFileVo.getFileNo());
			}
			
			hworkMngService.updateHworkFile(params);
			
		} else if ( "D".equals(crud) ) {
			TcFileVO fileVo = new TcFileVO();
			fileVo.setFileNo(params.get("hworkFileNo"));
			fileVo.setFileDivCd("HWORK");
			fileService.delete(fileVo);
			
			hworkMngService.deleteHworkFile(params);
		}
		
		rtnMap.put("result", params);
		vo.setRtnData(rtnMap);
		
		return vo;
	}
	
	@RequestMapping("/clss/hworkMng/downloadHworkFile")
	public ModelAndView downloadHworkFile(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		TcFileVO fileVo = new TcFileVO();
		fileVo.setFileNo(params.get("hworkFileNo"));
		fileVo = fileService.search(fileVo);
        
        // 임시 파일
        File downloadFile = new File(fileVo.getFilePath() + fileVo.getPgicFileNm());

        // 결과값 설정
        ModelAndView mv = new ModelAndView("downloadView");
        mv.addObject("downloadFile", downloadFile);
        
        return mv;
	}
}
