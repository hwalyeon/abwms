package kr.co.seculink.web.controller.svcStnd.loc;

import kr.co.seculink.domain.RtnMsg;
import kr.co.seculink.exception.BizException;
import kr.co.seculink.util.GEUtil;
import kr.co.seculink.web.excel.ExcelConstant;
import kr.co.seculink.web.service.svcStnd.loc.EorgInfoMngService;
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
public class EorgInfoMngController
{
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate dao;

	@Autowired
	private  EorgInfoMngService eorgInfoMngService;


	// 교육시설_정보_조회
	@ResponseBody
	@RequestMapping("/svcStnd/loc/eorgInfoMng/searchEorgInfoList.ab")
	public RtnMsg<Map<String, Object>> searchEorgInfoList(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		RtnMsg<Map<String, Object>> vo = new RtnMsg<>();
		Map<String, Object> rtnMap = new HashMap<>();
		List<Map<String, String>> result = eorgInfoMngService.searchEorgInfoList(params);

		if ( !GEUtil.isEmpty(params.get("paging")) )
		{
			params.put("paging", "N");
		}

		rtnMap.put("result", result);
		vo.setRtnData(rtnMap, params);

		return vo;
	}
	
	//	주소_헤더_단어_리스트_조회
	@ResponseBody
	@RequestMapping("/svcStnd/loc/eorgInfoMng/searchWordHeadList.ab")
	public RtnMsg<Map<String, Object>> searchWordHeadList(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		RtnMsg<Map<String, Object>> vo = new RtnMsg<>();
		Map<String, Object> rtnMap     = new HashMap<>();

		System.out.println("params얌 :"+ params);
		// 단어_헤드_1_리스트_조회
		if(params.get("wordHead1") == "" || params.get("wordHead1") == null)
		{
			List<Map<String, String>> resultHead1 = eorgInfoMngService.searchWordHead1List(params);
			rtnMap.put("resultHead1", resultHead1);
		}
		// 단어_헤드_2_리스트_조회
		else
		{
			List<Map<String, String>> resultHead2 = eorgInfoMngService.searchWordHead2List(params);
			rtnMap.put("resultHead2", resultHead2);
		}

		vo.setRtnData(rtnMap);

		return vo;
	}

	//	장소_코드_리스트_조회
	@ResponseBody
	@RequestMapping("/svcStnd/loc/eorgInfoMng/searchPlcCdList.ab")
	public RtnMsg<Map<String, Object>> searchPlcCdList(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		RtnMsg<Map<String, Object>> vo = new RtnMsg<>();
		Map<String, Object> rtnMap = new HashMap<>();
		List<Map<String, String>> result = eorgInfoMngService.searchPlcCdList(params);

		rtnMap.put("result", result);
		vo.setRtnData(rtnMap, params);

		return vo;
	}

	// 교육시설_기본_리스트 엑셀다운로드
	@ResponseBody
	@RequestMapping("/svcStnd/loc/eorgInfoMng/searchEorgInfoList/excel.ab")
	public ModelAndView downloadExcel(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		params.put("paging", "N");
		List<Map<String, String>> result = dao.selectList("svcStnd.loc.eorgInfoMng.selectEorgInfoList", params);
		return new ModelAndView("excelXlsView", getExcelMap(result));
	}

	private Map<String, Object> getExcelMap(List<Map<String, String>> list)
	{
		String [] arrHeader =
		{
			  "위치번호"
			, "위치명"
			, "장소분류 코드명"
			, "장소 코드명"
			, "도로명 주소"
			, "지번 주소"
			, "위도 값"
			, "경도 값"
			, "관리 기관 명"
			, "관할 경찰서 명"
			, "CCTV 여부"
			, "CCTV 대수"
			, "도로 넓이 설명"
			, "자료 기준 일자"
			, "제공 기관 코드"
			, "제공 기관 명"
		};
		List<String> headerList = Arrays.asList(arrHeader);
		List<List<String>> dataList = new ArrayList<>();
		List<String> data;

		for ( Map<String, String> info : list )
		{
			data = new ArrayList<>();
			data.add(String.valueOf(info.get("locNo")));
			data.add(info.get("locNm"       ));
			data.add(info.get("plcClssCdNm" ));
			data.add(info.get("plcCdNm"     ));
			data.add(info.get("roadAddr"    ));
			data.add(info.get("jibnAddr"    ));
			data.add(info.get("latVal"      ));
			data.add(info.get("lonVal"      ));
			data.add(info.get("mngOrgnNm"   ));
			data.add(info.get("mngPolcNm"   ));
			data.add(info.get("cctvYn"      ));
			data.add(info.get("cctvCnt"     ));
			data.add(info.get("roadWdthDesc"));
			data.add(info.get("dataStndDt"  ));
			data.add(info.get("provOrgnCd"  ));
			data.add(info.get("provOrgnNm"  ));


			dataList.add(data);
		}
		Map<String, Object> map = new HashMap<>();
		map.put(ExcelConstant.FILE_NAME, "excel");
		map.put(ExcelConstant.HEAD, headerList);
		map.put(ExcelConstant.BODY, dataList);
		return map;
	}

}
