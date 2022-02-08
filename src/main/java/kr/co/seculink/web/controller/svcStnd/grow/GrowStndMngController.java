package kr.co.seculink.web.controller.svcStnd.grow;

import kr.co.seculink.domain.RtnMsg;
import kr.co.seculink.exception.BizException;
import kr.co.seculink.util.GEUtil;
import kr.co.seculink.web.service.svcStnd.grow.GrowStndMngService;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
public class GrowStndMngController
{
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate dao;

	@Autowired
	private GrowStndMngService growStndMngService;

	//성장_기준_리스트_조회
	@ResponseBody
	@RequestMapping("/svcStnd/grow/growStndMng/searchGrowStndList.ab")
	public RtnMsg growStndList(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();

		List<Map<String, String>> result = growStndMngService.growStndList(params);

		if ( !GEUtil.isEmpty(params.get("paging")) ) {
			params.put("paging", "N");
			vo.setTotalCount(((List)growStndMngService.growStndList(params)).size());
		}
		rtnMap.put("result", result);
		vo.setRtnData(rtnMap, params);

		return vo;
	}
	//성장_기준_버전_리스트_조회
	@ResponseBody
	@RequestMapping("/svcStnd/grow/growStndMng/growStndVerList.ab")
	public RtnMsg growStndVerList(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();

		List<Map<String, String>> result = growStndMngService.growStndVerList(params);
		rtnMap.put("result", result);

		vo.setRtnData(rtnMap, params);

		return vo;
	}

	//나이_년수 목록 조회
	@ResponseBody
	@RequestMapping("/svcStnd/grow/growStndMng/ageYcntList.ab")
	public RtnMsg ageYcntList(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		System.out.println("얍시작이닷");
		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();

		List<Map<String, String>> result = growStndMngService.ageYcntList(params);
		rtnMap.put("result", result);
		System.out.println("얍"+result);

		vo.setRtnData(rtnMap, params);

		return vo;
	}
/*

	//위험감정기준 목록 엑셀다운로드
	@ResponseBody
	@RequestMapping("/svcStne/dgem/dgemStndMng/searchDgemList/excel.ab")
	public ModelAndView downloadExcel(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		params.put("paging", "N");
		List<Map<String, String>> result = dao.selectList("svcStnd.dgem.dgemStndMng.searchTcDgemStatBase", params);

		return new ModelAndView("excelXlsView", getExcelMap(result));
	}

	private Map<String, Object> getExcelMap(List<Map<String, String>> list)
	{
		String [] arrHeader = {"위험감정상태코드","위험감정상태내용"};
		List<String> headerList = Arrays.asList(arrHeader);

		List<List<String>> dataList = new ArrayList<List<String>>();
		List<String> data;

		for ( Map<String, String> info : list )
		{
			data = new ArrayList<String>();
			data.add(info.get("dgemStatCd"));
			data.add(info.get("dgemStatCntn"));
			dataList.add(data);
		}

		Map<String, Object> map = new HashMap<>();
		map.put(ExcelConstant.FILE_NAME, "excel");
		map.put(ExcelConstant.HEAD, headerList);
		map.put(ExcelConstant.BODY, dataList);
		return map;
	}*/
}
