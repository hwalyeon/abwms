package kr.co.seculink.web.controller.stat.etc;

import kr.co.seculink.domain.RtnMsg;
import kr.co.seculink.exception.BizException;
import kr.co.seculink.web.excel.ExcelConstant;
import kr.co.seculink.web.service.stat.etc.CbeeStssService;
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
public class CbeeStssController
{
    @Resource(name = "sqlSessionTemplate")
    private SqlSessionTemplate dao;

    @Autowired
    private CbeeStssService cbeeStssService;

    @ResponseBody
    @RequestMapping("/stat/etc/cbeeStss/searchCbeeStssColList.ab")
    public RtnMsg searchCbeeStssColList(@RequestBody(required = false) Map<String, String> params) throws BizException
    {

        RtnMsg vo = new RtnMsg();
        Map<String, Object> rtnMap = new HashMap<String, Object>();

        List<Map<String, String>> stndDtList = dao.selectList("stat.etc.cbeeStss.searchCbeeStssCdList", params);
        rtnMap.put("stndDtList", stndDtList);

        vo.setRtnData(rtnMap, params);

        return vo;
    }

    @ResponseBody
    @RequestMapping("/stat/etc/cbeeStss/searchCbeeStssList.ab")
    public RtnMsg searchCbeeStssList(@RequestBody(required = false) Map<String, String> params) throws BizException
    {

        RtnMsg vo = new RtnMsg();
        Map<String, Object> rtnMap = new HashMap<String, Object>();

        List<Map<String, Object>> result = cbeeStssService.searchCbeeStssList(params);
        rtnMap.put("result", result);

        vo.setRtnData(rtnMap, params);

        return vo;
    }

    //캐시비 사용금액 통계 엑셀 다운로드
    @ResponseBody
    @RequestMapping("/stat/etc/cbeeStss/searchCbeeStssList/excel.ab")
    public ModelAndView downloadExcel(@RequestBody(required=false) Map<String, String> params) throws BizException
    {
        params.put("paging", "N");
        List<Map<String, Object>> result = dao.selectList("stat.etc.cbeeStss.searchCbeeStssList", params);

        return new ModelAndView("excelXlsView", getExcelMap(result));
    }

    private Map<String, Object> getExcelMap(List<Map<String, Object>> list)
    {
        String [] arrHeader = {"기준일자","캐시비 사용금액 섭취량"};
        List<String> headerList = Arrays.asList(arrHeader);

        List<List<String>> dataList = new ArrayList<List<String>>();
        List<String> data;

        for ( Map<String, Object> info : list )
        {
            data = new ArrayList<String>();
            data.add(String.valueOf(info.get("stndDt")));
            data.add(String.valueOf(info.get("cbeeAmt")));
            dataList.add(data);
        }

        Map<String, Object> map = new HashMap<>();
        map.put(ExcelConstant.FILE_NAME, "excel");
        map.put(ExcelConstant.HEAD, headerList);
        map.put(ExcelConstant.BODY, dataList);
        return map;
    }

}
