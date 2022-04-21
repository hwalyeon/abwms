package kr.co.seculink.web.controller.cmon.stnd;

import kr.co.seculink.domain.RtnMsg;
import kr.co.seculink.exception.BizException;
import kr.co.seculink.util.GEUtil;
import kr.co.seculink.web.excel.ExcelConstant;
import kr.co.seculink.web.service.cmon.stnd.ApiStndMngService;
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
public class ApiStndMngController
{
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate dao;

	@Autowired
	private ApiStndMngService apiStndMngService;
	
	@ResponseBody
	@RequestMapping("/cmon/stnd/searchApiList.ab")
	public RtnMsg searchApiList(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		
		List<Map<String, String>> result = apiStndMngService.searchApiList(params);
		rtnMap.put("result", result);
		
		if ( !GEUtil.isEmpty(params.get("paging")) ) {
			params.put("paging", "N");
			vo.setTotalCount(((List)apiStndMngService.searchApiList(params)).size());
		}
		
		vo.setRtnData(rtnMap, params);
		
		return vo;
	}
	
	@ResponseBody
	@RequestMapping("/cmon/stnd/searchApiInfo.ab")
	public RtnMsg searchApiInfo(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		
		Map<String, String> result = apiStndMngService.searchApiInfo(params);
		
		List<Map<String, String>> roleList = dao.selectList("cmon.stnd.apiStndMng.searchTcApiStnd", params);
		
		rtnMap.put("result", result);
		rtnMap.put("roleList", roleList);
		vo.setRtnData(rtnMap);
				
		return vo; 
	}
	
	@ResponseBody
	@RequestMapping("/cmon/stnd/saveApi.ab")
	public RtnMsg saveApi(@RequestBody(required=false) Map<String, String> params) throws BizException
	{	
		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		System.out.println("params" + params);
		apiStndMngService.saveApi(params);
		
		rtnMap.put("result", params);
		vo.setRtnData(rtnMap);
		
		return vo;
	}

	@ResponseBody
	@RequestMapping("/cmon/stnd/searchDupSvrId.ab")
	public RtnMsg searchDupSvrId(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();

		Map<String, String> user = apiStndMngService.searchDupSvrId(params);

		rtnMap.put("result", user);
		vo.setRtnData(rtnMap);

		return vo;
	}
	
	@ResponseBody
	@RequestMapping("/cmon/stnd/searchApiList/excel.ab")
	public ModelAndView downloadExcel(@RequestBody(required=false) Map<String, String> params) throws BizException
	{	
		params.put("paging", "N");
		List<Map<String, String>> result = dao.selectList("cmon.stnd.apiStndMng.searchTcApiStnd", params);
		
		return new ModelAndView("excelXlsView", getExcelMap(result));
	}
	
	private Map<String, Object> getExcelMap(List<Map<String, String>> list)
    {
        String [] arrHeader = {"서버ID","서버 명","GPS정기핑 기본 주기","GPS정기핑 다음 주기","정기판정 다음 주기","정기판정 기본 주기","LED 슬립 시간","모션센서 감지 레벨","심박센서 내부감지 주기"
					          ,"체온센서 내부감지 주기","체온센서 이벤트 하한값","체온센서 이벤트 상한값","심박수 중간값 하한값","심박수 중간값 상한값","모션센서 이벤트 하한값","모션센서 이벤트 상한값"
					          ,"등록일자","등록시각","등록사용자ID","수정일자","수정시각","수정사용자ID","API-URL"};
        List<String> headerList = Arrays.asList(arrHeader);

        List<List<String>> dataList = new ArrayList<List<String>>();
        List<String> data;
        
        for ( Map<String, String> info : list )
        {
            data = new ArrayList<String>();
			data.add(info.get("svrId"));
			data.add(info.get("svrNm"));
			data.add(String.valueOf(info.get("gpsBaseCycl")));
			data.add(String.valueOf(info.get("gpsNextCycl")));
			data.add(String.valueOf(info.get("rdetNextCycl")));
			data.add(String.valueOf(info.get("rdetBaseCycl")));
			data.add(String.valueOf(info.get("ledSlepTcnt")));
			data.add(String.valueOf(info.get("msorSsngLevl")));
			data.add(String.valueOf(info.get("hsorIsngCycl")));
			data.add(String.valueOf(info.get("tsorIsngCycl")));
			data.add(String.valueOf(info.get("tsorEvntMinval")));
			data.add(String.valueOf(info.get("tsorEvntMaxval")));
			data.add(String.valueOf(info.get("hbitcntMdanMinval")));
			data.add(String.valueOf(info.get("hbitcntMdanMaxval")));
			data.add(String.valueOf(info.get("msorEvntMinval")));
			data.add(String.valueOf(info.get("msorEvntMaxval")));
			data.add(info.get("regDt"));
			data.add(info.get("regTm"));
			data.add(info.get("regUserId"));
			data.add(info.get("uptDt"));
			data.add(info.get("uptTm"));
			data.add(info.get("uptUserId"));
			data.add(String.valueOf(info.get("apiUrl")));
            dataList.add(data);
        }

        Map<String, Object> map = new HashMap<>();
        map.put(ExcelConstant.FILE_NAME, "excel");
        map.put(ExcelConstant.HEAD, headerList);
        map.put(ExcelConstant.BODY, dataList);
        return map;
    }
}
