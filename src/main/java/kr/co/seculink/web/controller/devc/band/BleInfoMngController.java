package kr.co.seculink.web.controller.devc.band;

import kr.co.seculink.domain.RtnMsg;
import kr.co.seculink.exception.BizException;
import kr.co.seculink.web.excel.ExcelConstant;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.*;

@Slf4j
@Controller
public class BleInfoMngController
{
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate dao;

	//BLE 리스트 조회
	@ResponseBody
	@RequestMapping("/devc/band/bleInfoMng/searchBleInfoList.ab")
	public RtnMsg searchBleInfoList(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();

		List<Map<String, String>> result = dao.selectList("devc.band.bleInfoMng.selectBleInfoList", params);
		rtnMap.put("result", result);
		vo.setRtnData(rtnMap, params);

		return vo;
	}


	//BLE 리스트 조회
	@ResponseBody
	@RequestMapping("/devc/band/bleInfoMng/searchBleDup.ab")
	public RtnMsg searchBleDup(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();

		int dupCnt = dao.selectOne("devc.band.bleInfoMng.searchBleDup", params);
		rtnMap.put("dupCnt", dupCnt);
		vo.setRtnData(rtnMap, params);

		return vo;
	}


	//BLE 저장
	@ResponseBody
	@RequestMapping("/devc/band/bleInfoMng/saveBleInfo.ab")
	public RtnMsg saveBleInfo(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();

		if("C".equals(params.get("crud"))){
			Map<String, String> result = dao.selectOne("devc.band.bleInfoMng.selectBleInfo", params);
			if(result != null ){
				throw new BizException("이미 등록된 ID입니다.");
			}
			dao.insert("devc.band.bleInfoMng.insert",params);
		}
		else if("U".equals(params.get("crud"))) dao.update("devc.band.bleInfoMng.update",params);
		else if("D".equals(params.get("crud"))) dao.delete("TS_BLE_INFO.delete",params);
		
		vo.setRtnData(rtnMap, params);

		return vo;
	}

	//BLE 리스트 조회
	@ResponseBody
	@RequestMapping("/devc/band/bleInfoMng/searchBleInfo.ab")
	public RtnMsg searchBleInfo(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		RtnMsg vo = new RtnMsg();
		Map<String, Object> rtnMap = new HashMap<String, Object>();

		Map<String, String> result = dao.selectOne("devc.band.bleInfoMng.selectBleInfo", params);
		rtnMap.put("result", result);
		vo.setRtnData(rtnMap, params);

		return vo;
	}

	//ble정보 목록_리스트 엑셀다운로드
	@ResponseBody
	@RequestMapping("/devc/band/bleInfoMng/searchBleInfo/excel.ab")
	public ModelAndView downloadExcel(@RequestBody(required=false) Map<String, String> params) throws BizException
	{
		params.put("paging", "N");
		List<Map<String, String>> result = dao.selectList("devc.band.bleInfoMng.selectBleInfoList", params);

		return new ModelAndView("excelXlsView", getExcelMap(result));
	}

	private Map<String, Object> getExcelMap(List<Map<String, String>> list)
	{
		String [] arrHeader = {"BLE ID" , "BLE설치일자","BLE설치시간", "장소명","위치명","위치주소","비고"};
		List<String> headerList = Arrays.asList(arrHeader);

		List<List<String>> dataList = new ArrayList<List<String>>();
		List<String> data;

		for ( Map<String, String> info : list )
		{
			data = new ArrayList<String>();
			data.add(info.get("bleId"));
			data.add(info.get("bleInstDt"));
			data.add(info.get("bleInstTm"));
			data.add(info.get("plcNm"));
			data.add(info.get("locNm"));
			data.add(info.get("addrBase"));
			data.add(info.get("rmrk"));
			dataList.add(data);
		}

		Map<String, Object> map = new HashMap<>();
		map.put(ExcelConstant.FILE_NAME, "excel");
		map.put(ExcelConstant.HEAD, headerList);
		map.put(ExcelConstant.BODY, dataList);
		return map;
	}

}
