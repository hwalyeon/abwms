package kr.co.seculink.web.controller.cmon.blbd;

import kr.co.seculink.domain.RtnMsg;
import kr.co.seculink.exception.BizException;
import kr.co.seculink.util.GEUtil;
import kr.co.seculink.web.excel.ExcelConstant;
import kr.co.seculink.web.service.cmon.blbd.QnaMngService;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.*;

@Slf4j
@RestController
public class QnaMngController {
	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate dao;

	@Autowired
	private QnaMngService qnaMngService;

	//질의응답_리스트 조회
	@RequestMapping("/cmon/blbd/qnaMng/searchQnaList.ab")
	public RtnMsg searchQnaList(@RequestBody(required = false) Map<String, String> params) throws BizException
	{
		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<>();

		List<Map<String, Object>> result = qnaMngService.searchQnaList(params);

		rtnMap.put("result", result);

		if (!GEUtil.isEmpty(params.get("paging"))) {
			params.put("paging", "N");
			vo.setTotalCount(((List) qnaMngService.searchQnaList(params)).size());
		}

		vo.setRtnData(rtnMap, params);

		return vo;
	}

	//질의응답_저장
	@RequestMapping("/cmon/blbd/qnaMng/saveInfo.ab")
	public RtnMsg saveInfo(@RequestBody(required = false) Map<String, String> params) throws BizException
	{
		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<>();
		qnaMngService.saveInfo(params);

		rtnMap.put("result", params);
		vo.setRtnData(rtnMap, params);

		return vo;
	}

	//질의응답 리스트 엑셀다운로드
	@RequestMapping("/cmon/blbd/qnaMng/searchQnaList/excel.ab")
	public ModelAndView downloadExcel(@RequestBody(required = false) Map<String, String> params) throws BizException {

		params.put("paging", "N");
		List<Map<String, String>> result = dao.selectList("cmon.blbd.qnaMng.selectTsQnaBaseList", params);

		return new ModelAndView("excelXlsView", getExcelMap(result));
	}

	private Map<String, Object> getExcelMap(List<Map<String, String>> list) {
		String[] arrHeader = {
				                 "QnA 번호"
				               , "질문 일자"
				               , "질문자 번호"
				               , "질문자 명"
				               , "질문 제목"
				               , "질문 내용"
				               , "답변 일자"
				               , "답변 시각"
				               , "답변 내용"
				               , "답변자 ID"
		                     };
		List<String> headerList = Arrays.asList(arrHeader);

		List<List<String>> dataList = new ArrayList<List<String>>();
		List<String> data;

		for (Map<String, String> info : list) {
			data = new ArrayList<String>();
			data.add(String.valueOf(info.get("qnaNo")));
			data.add(info.get("qustDt"));
			data.add(String.valueOf(info.get("qustGuarNo")));
			data.add(info.get("guarNm"));
			data.add(info.get("qustTitl"));
			data.add(info.get("qustCntn"));
			data.add(info.get("ansDt"));
			data.add(info.get("ansTm"));
			data.add(info.get("ansCntn"));
			data.add(info.get("ansUserId"));
			dataList.add(data);
		}

		Map<String, Object> map = new HashMap<>();
		map.put(ExcelConstant.FILE_NAME, "excel");
		map.put(ExcelConstant.HEAD, headerList);
		map.put(ExcelConstant.BODY, dataList);
		return map;
	}



}
