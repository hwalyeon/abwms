package kr.co.seculink.web.controller.svcStnd.grow;

import kr.co.seculink.domain.RtnMsg;
import kr.co.seculink.exception.BizException;
import kr.co.seculink.web.service.svcStnd.dgem.DgemStndMngService;
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
	private DgemStndMngService dgemStndMngService;

	//위험감정기준 목록 조회
	@ResponseBody
	@RequestMapping("/svcStnd/grow/growStndMng/growStndVerList.ab")
	public RtnMsg growStndVerList(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();

		List<Map<String, String>> result = dao.selectList("svcStnd.grow.growStndMng.searchTIGrowStndVerList", params);

		rtnMap.put("result", result);
		vo.setRtnData(rtnMap);

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
