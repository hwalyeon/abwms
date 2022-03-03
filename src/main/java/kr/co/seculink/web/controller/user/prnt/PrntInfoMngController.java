package kr.co.seculink.web.controller.user.prnt;

import kr.co.seculink.domain.RtnMsg;
import kr.co.seculink.exception.BizException;
import kr.co.seculink.util.GEUtil;
import kr.co.seculink.web.service.user.prnt.PrntInfoMngService;
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
public class PrntInfoMngController
{
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate dao;

	@Autowired
	private PrntInfoMngService prntInfoMngService;

	//보호자(사용자)정보_리스트 조회
	@ResponseBody
	@RequestMapping("/user/prnt/prntInfoMng/searchPrntInfoList.ab")
	public RtnMsg searchPrntInfoList(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();

		List<Map<String, String>> result = prntInfoMngService.searchPrntInfoList(params);

		if ( !GEUtil.isEmpty(params.get("paging")) ) {
			params.put("paging", "N");
			vo.setTotalCount(((List)prntInfoMngService.searchPrntInfoList(params)).size());
		}
		rtnMap.put("result", result);
		vo.setRtnData(rtnMap, params);

		return vo;
	}

	//보호자(사용자)_정보_상세보기
	@ResponseBody
	@RequestMapping("/user/prnt/prntInfoMng/searchPrntInfo.ab")
	public RtnMsg searchPrntInfo(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();

		Map<String, Object> result = prntInfoMngService.searchPrntInfo(params);

		rtnMap.put("result", result);
		vo.setRtnData(rtnMap);

		return vo;
	}

	//밴드정보 저장
	@ResponseBody
	@RequestMapping("/user/prnt/prntInfoMng/savePrntInfoDetl.ab")
	public RtnMsg savePrntInfoDetl(@RequestBody(required = false)Map<String,Object>params)throws BizException {

		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		prntInfoMngService.savePrntInfoDetl(params);


		rtnMap.put("result", params);
		vo.setRtnData(rtnMap, params);

		return vo;
	}


/*
	//밴드/개통 정보 목록_리스트 엑셀다운로드
	@ResponseBody
	@RequestMapping("/devc/band/bandOpenInfoMng/searchBandOpenInfoList/excel.ab")
	public ModelAndView downloadExcel(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		params.put("paging", "N");

		List<Map<String, String>> result = dao.selectList("devc.band.bandOpenInfoMng.selectBandOpenInfoList", params);
		return new ModelAndView("excelXlsView", getExcelMap(result));
	}

	private Map<String, Object> getExcelMap(List<Map<String, String>> list)
	{
		String [] arrHeader = {"기준일자","밴드등록일자","출고년월","모델TYPE", "밴드ID","전화번호","학생번호","학생명","보호자번호","보호자명","보호자전화번호","블루투스ID","밴드개통상태코드","밴드개통상태코드명","개통URL전문번호","개통전문번호","URL제공여부","URL제공일시"};
		List<String> headerList = Arrays.asList(arrHeader);

		List<List<String>> dataList = new ArrayList<List<String>>();
		List<String> data;

		for ( Map<String, String> info : list )
		{
			data = new ArrayList<String>();
			data.add(info.get("uptDt"));
			data.add(info.get("regDt"));
			data.add(info.get("bandYtyp"));
			data.add(info.get("bandMdlCd"));
			data.add(info.get("bandId"));
			data.add(info.get("telNo"));
			data.add(String.valueOf(info.get("stdtNo")));		
			data.add(info.get("stdtNm"));
			data.add(String.valueOf(info.get("guarNo")));				
			data.add(info.get("guarNm"));
			data.add(info.get("guarTelNo"));
			data.add(info.get("blthId"));
			data.add(info.get("bandOpenStatCd"));
			data.add(info.get("bandOpenStatCdNm"));
			data.add(String.valueOf(info.get("apiUrlGramNo")));
			data.add(String.valueOf(info.get("openGramNo")));
			data.add(info.get("apiUrlYn"));
			data.add(info.get("apiUrlDttm"));
			*//*
			 * data.add(info.get("regDt")); data.add(info.get("regTm"));
			 * data.add(info.get("regUserId")); data.add(info.get("uptDt"));
			 * data.add(info.get("uptTm")); data.add(info.get("uptUserId"));
			 *//*
			dataList.add(data);
		}

		Map<String, Object> map = new HashMap<>();
		map.put(ExcelConstant.FILE_NAME, "excel");
		map.put(ExcelConstant.HEAD, headerList);
		map.put(ExcelConstant.BODY, dataList);
		return map;
	}


*/


}
