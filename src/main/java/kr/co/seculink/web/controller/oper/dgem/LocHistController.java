package kr.co.seculink.web.controller.oper.dgem;

import kr.co.seculink.domain.RtnMsg;
import kr.co.seculink.exception.BizException;
import kr.co.seculink.util.GEUtil;
import kr.co.seculink.web.excel.ExcelConstant;
import kr.co.seculink.web.service.oper.dgem.LocHistService;
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
public class LocHistController
{

	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate dao;

	@Autowired
	private LocHistService locHistService;

	//위치 이력 목록 리스트 조회
	@ResponseBody
	@RequestMapping("/oper/dgem/locHist/searchLocHistList.ab")
	public RtnMsg searchLocHistList(@RequestBody(required = false) Map<String, String> params) throws BizException
	{

		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();


		List<Map<String, String>> result = dao.selectList("oper.dgem.locHist.searchLocHistList", params);
		rtnMap.put("result", result);


		if (!GEUtil.isEmpty(params.get("paging"))) {
			params.put("paging", "N");
			vo.setTotalCount(((List)dao.selectList("oper.dgem.locHist.searchLocHistList", params)).size());
		}

		vo.setRtnData(rtnMap, params);

		return vo;
	}


	//위치이력 엑셀 다운로드
	@ResponseBody
	@RequestMapping("/oper/dgem/locHist/searchLocHistList/excel.ab")
	public ModelAndView downloadExcel(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		params.put("paging", "N");
		List<Map<String, String>> result = dao.selectList("oper.dgem.locHist.searchLocHistList", params);

		return new ModelAndView("excelXlsView", getExcelMap(result));
	}

	private Map<String, Object> getExcelMap(List<Map<String, String>> list)
	{
		String [] arrHeader = {"발생일시","학교명","학생번호","학생명","장소","장소분류","위도","경도","위치명","주소","학생전화번호","보호자번호",
					           "보호자명","보호자전화번호","등록일자","등록시각","등록사용자ID","수정일자","수정시각","수정사용자ID"};
		List<String> headerList = Arrays.asList(arrHeader);

		List<List<String>> dataList = new ArrayList<List<String>>();
		List<String> data;

		for ( Map<String, String> info : list )
		{
			data = new ArrayList<String>();
			data.add(String.valueOf(info.get("occrDttm")));
			data.add(String.valueOf(info.get("locNm")));
			data.add(String.valueOf(info.get("stdtNo")));
			data.add(String.valueOf(info.get("stdtNm")));
			data.add(String.valueOf(info.get("locNm")));
			data.add(String.valueOf(info.get("plcClssCd")));
			data.add(String.valueOf(info.get("latVal")));
			data.add(String.valueOf(info.get("lonVal")));
			data.add(String.valueOf(info.get("nearLocNo")));
			data.add(String.valueOf(info.get("addrBase")));
			data.add(String.valueOf(info.get("telNo")));
			data.add(String.valueOf(info.get("guarNo")));
			data.add(String.valueOf(info.get("guarNm")));
			data.add(String.valueOf(info.get("guarTelNo")));
			data.add(info.get("regDt"));
			data.add(info.get("regTm"));
			data.add(info.get("regUserId"));
			data.add(info.get("uptDt"));
			data.add(info.get("uptTm"));
			data.add(info.get("uptUserId"));
			dataList.add(data);
		}

		Map<String, Object> map = new HashMap<>();
		map.put(ExcelConstant.FILE_NAME, "excel");
		map.put(ExcelConstant.HEAD, headerList);
		map.put(ExcelConstant.BODY, dataList);
		return map;
	}
}
