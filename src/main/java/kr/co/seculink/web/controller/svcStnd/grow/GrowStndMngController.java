package kr.co.seculink.web.controller.svcStnd.grow;

import kr.co.seculink.domain.RtnMsg;
import kr.co.seculink.exception.BizException;
import kr.co.seculink.util.GEUtil;
import kr.co.seculink.web.excel.ExcelConstant;
import kr.co.seculink.web.service.svcStnd.grow.GrowStndMngService;
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
	//행추가_행삭제_저장
	@ResponseBody
	@RequestMapping("/svcStnd/grow/growStndMng/saveGrowStnd.ab")
	public RtnMsg saveGrowStnd(@RequestBody(required = false)Map<String,Object>params)throws BizException {
		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();

       growStndMngService.saveGrowStnd(params);

		rtnMap.put("result", params);
		vo.setRtnData(rtnMap, params);

		return vo;
	}

	//성장_기준_리스트 엑셀다운로드
	@ResponseBody
	@RequestMapping("/svcStnd/grow/growStndMng/searchGrowStndList/excel.ab")
	public ModelAndView downloadExcel(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		params.put("paging", "N");

		List<Map<String, String>> result = dao.selectList("svcStnd.grow.growStndMng.searchGrowStndList", params);
		return new ModelAndView("excelXlsView", getExcelMap(result));
	}

	private Map<String, Object> getExcelMap(List<Map<String, String>> list)
	{
		String [] arrHeader = {"성장기준버전","성장기준번호","성별","나이(년)","나이(개월)","백분위3 성장지수","백분위50 성장지수","백분위97 성장지수","등록일자","등록시각","등록사용자ID","수정등록일자","수정시각","수정사용자ID"};
		List<String> headerList = Arrays.asList(arrHeader);

		List<List<String>> dataList = new ArrayList<List<String>>();
		List<String> data;

		for ( Map<String, String> info : list )
		{
			data = new ArrayList<String>();
			data.add(info.get("growStndVer"));
			data.add(String.valueOf(info.get("growStndNo")));
			data.add(info.get("fnGetcdnm"));
			data.add(String.valueOf(info.get("ageYcnt")));
			data.add(String.valueOf(info.get("ageMcnt")));
			data.add(String.valueOf(info.get("p3Gidx")));
			data.add(String.valueOf(info.get("p50Gidx")));
			data.add(String.valueOf(info.get("p97Gidx")));
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
