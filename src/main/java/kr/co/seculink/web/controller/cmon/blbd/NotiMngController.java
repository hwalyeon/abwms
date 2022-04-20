package kr.co.seculink.web.controller.cmon.blbd;

import kr.co.seculink.domain.RtnMsg;
import kr.co.seculink.exception.BizException;
import kr.co.seculink.util.GEUtil;
import kr.co.seculink.web.excel.ExcelConstant;
import kr.co.seculink.web.service.cmon.blbd.NotiMngService;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.*;

@Slf4j
@Controller
public class NotiMngController
{
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate dao;

	@Autowired
	private NotiMngService notiMngService;
	
	@ResponseBody
	@RequestMapping("/cmon/blbd/searchUserList.ab")
	public RtnMsg searchUserList(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		
		List<Map<String, String>> result = notiMngService.searchUserList(params);
		rtnMap.put("result", result);
		
		if ( !GEUtil.isEmpty(params.get("paging")) ) {
			params.put("paging", "N");
			vo.setTotalCount(((List)notiMngService.searchUserList(params)).size());
		}
		
		vo.setRtnData(rtnMap, params);
		
		return vo;
	}
	
	@ResponseBody
	@RequestMapping("/cmon/blbd/searchUserInfo.ab")
	public RtnMsg searchUserInfo(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		
		Map<String, String> result = notiMngService.searchUserInfo(params);
		
		List<Map<String, String>> roleList = dao.selectList("cmon.blbd.notiMng.searchNotiList", params);
		
		rtnMap.put("result", result);
		rtnMap.put("roleList", roleList);
		vo.setRtnData(rtnMap);
				
		return vo; 
	}
	
	@ResponseBody
	@RequestMapping("/cmon/blbd/saveUser.ab")
	public RtnMsg saveUser(@RequestBody(required=false) Map<String, String> params) throws BizException
	{	
		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		System.out.println("params" + params);
		notiMngService.saveUser(params);
		
		rtnMap.put("result", params);
		vo.setRtnData(rtnMap);
		
		return vo;
	}
	
	@ResponseBody
	@RequestMapping("/cmon/blbd/searchDupUserId.ab")
	public RtnMsg searchDupUserId(@RequestBody(required=false) Map<String, String> params) throws BizException
	{	
		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();
	
		Map<String, String> user = notiMngService.searchDupUserId(params);
		
		rtnMap.put("result", user);
		vo.setRtnData(rtnMap);
		
		return vo;
	}
	
	@ResponseBody
	@RequestMapping("/cmon/blbd/searchUserList/excel.ab")
	public ModelAndView downloadExcel(@RequestBody(required=false) Map<String, String> params) throws BizException
	{	
		params.put("paging", "N");
		List<Map<String, String>> result = dao.selectList("cmon.blbd.notiMng.searchTcUserBase", params);
		
		return new ModelAndView("excelXlsView", getExcelMap(result));
	}
	
	private Map<String, Object> getExcelMap(List<Map<String, String>> list)
    {
        String [] arrHeader = {"사용자ID","사용자명","소속","전화번호","휴대전화번호","이메일","학원여부","강사여부","학생여부"};
        List<String> headerList = Arrays.asList(arrHeader);

        List<List<String>> dataList = new ArrayList<List<String>>();
        List<String> data;
        
        for ( Map<String, String> info : list )
        {
            data = new ArrayList<String>();
            data.add(info.get("userId"));
            data.add(info.get("userNm"));
            data.add(info.get("blngNm"));
            data.add(info.get("telNo"));
            data.add(info.get("mtelNo"));
            data.add(info.get("mailAddr"));
            data.add(info.get("acdmYn"));
            data.add(info.get("lctrYn"));
            data.add(info.get("stdtYn"));
            dataList.add(data);
        }

        Map<String, Object> map = new HashMap<>();
        map.put(ExcelConstant.FILE_NAME, "excel");
        map.put(ExcelConstant.HEAD, headerList);
        map.put(ExcelConstant.BODY, dataList);
        return map;
    }
}
